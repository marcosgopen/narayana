/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */

package org.jboss.jbossts.xts.recovery.participant.ba;

import com.arjuna.ats.arjuna.objectstore.RecoveryStore;
import com.arjuna.ats.arjuna.objectstore.StateStatus;
import com.arjuna.ats.arjuna.objectstore.StoreManager;
import org.jboss.jbossts.xts.recovery.logging.RecoveryLogger;

import com.arjuna.ats.arjuna.state.InputObjectState;
import com.arjuna.ats.arjuna.exceptions.ObjectStoreException;
import com.arjuna.ats.arjuna.common.Uid;
import com.arjuna.ats.internal.arjuna.common.UidHelper;
import org.jboss.jbossts.xts.recovery.XTSRecoveryModule;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import java.util.Enumeration;
import java.util.HashMap;
import java.io.IOException;

/**
 * This class is a plug-in module for the recovery manager.
 * It is responsible for recovering XTS BA participants
 * (instances of org.jboss.jbossts.xts.recovery.participant.ba.BAParticipantRecoveryRecord)
 *
 * $Id$
 *
 */

public class BAParticipantRecoveryModule implements XTSRecoveryModule
{
    public BAParticipantRecoveryModule()
    {
        if (RecoveryLogger.logger.isDebugEnabled()) {
            RecoveryLogger.logger.debug("BAParticipantRecoveryModule created - default");
        }

        if (_recoveryStore == null)
        {
            _recoveryStore = StoreManager.getRecoveryStore();
        }

        _participantType = BAParticipantRecoveryRecord.type();
    }

    /**
     * called by the service startup code before the recovery module is added to the recovery managers
     * module list
     */
    public void install()
    {
        // the manager is needed by both the participant or the coordinator recovery modules so whichever
        // one gets there first creates it. No synchronization is needed as modules are only ever
        // installed in a single thread
        if (!XTSBARecoveryManagerImple.isRecoveryManagerInitialised()) {
            XTSBARecoveryManager.setRecoveryManager(new XTSBARecoveryManagerImple(_recoveryStore));
        }

        // Subordinate Coordinators register durable participants with their parent transaction so
        // we need to add an XTSBARecoveryModule which knows about the registered participants

        subordinateRecoveryModule = new XTSBASubordinateRecoveryModule();

        XTSBARecoveryManager.getRecoveryManager().registerRecoveryModule(subordinateRecoveryModule);
    }

    /**
     * a recovery module which knows hwo to recover the participants registered by Subordinate BA Coordinators
     */

    private XTSBASubordinateRecoveryModule subordinateRecoveryModule;

    /**
     * called by the service shutdown code after the recovery module is removed from the recovery managers
     * module list
     */
    public void uninstall()
    {
        XTSBARecoveryManager.getRecoveryManager().unregisterRecoveryModule(subordinateRecoveryModule);
    }

    /**
     * This is called periodically by the RecoveryManager
     */
    public void periodicWorkFirstPass()
    {
        // Transaction type
        boolean BAParticipants = false ;

        // uids per transaction type
        InputObjectState acc_uids = new InputObjectState() ;

        try
        {
            if (RecoveryLogger.logger.isDebugEnabled()) {
                RecoveryLogger.logger.debug("BAParticipantRecoveryModule: first pass");
            }

            BAParticipants = _recoveryStore.allObjUids(_participantType, acc_uids );

        }
        catch ( ObjectStoreException ex )
        {
            RecoveryLogger.i18NLogger.warn_participant_ba_BAParticipantRecoveryModule_1(ex);
        }

        if ( BAParticipants )
        {
            _participantUidVector = processParticipants( acc_uids ) ;
        }
    }

    public void periodicWorkSecondPass()
    {
        if (RecoveryLogger.logger.isDebugEnabled()) {
            RecoveryLogger.logger.debug("BAParticipantRecoveryModule: Second pass");
        }

        processParticipantsStatus() ;
    }

    private void doRecoverParticipant( Uid recoverUid )
    {
        // Retrieve the participant from its original process.

        if (RecoveryLogger.logger.isDebugEnabled()) {
            RecoveryLogger.logger.debug("participant type is " + _participantType + " uid is " +
                    recoverUid.toString());
        }

        // we don't need to use a lock here because we only attempt the read
        // when the uid is inactive which means it cannto be pulled out form under our
        // feet at commit. uniqueness of uids also means we can't be foiled by a reused
        // uid.

        XTSBARecoveryManager recoveryManager = XTSBARecoveryManager.getRecoveryManager();

        if (!recoveryManager.isParticipantPresent(recoverUid)) {
            // ok, the participant can neither be active nor loaded awaiting recreation by
            // an application recovery module so we need to load it
            try {
                // retrieve the data for the participant
                InputObjectState inputState = _recoveryStore.read_committed(recoverUid, _participantType);

                if (inputState != null) {
                    try {
                        String participantRecordClazzName = inputState.unpackString();
                        try {
                            // create a participant engine instance and tell it to recover itself
                            Class participantRecordClazz = Class.forName(participantRecordClazzName);
                            BAParticipantRecoveryRecord participantRecord = (BAParticipantRecoveryRecord)participantRecordClazz.getDeclaredConstructor().newInstance();
                            participantRecord.restoreState(inputState);
                            // ok, now insert into recovery map if needed
                            XTSBARecoveryManager.getRecoveryManager().addParticipantRecoveryRecord(recoverUid, participantRecord);
                        } catch (ClassNotFoundException cnfe) {
                            // oh boy, not supposed to happen -- n.b. either the user deployed 1.0
                            // last time and 1.1 this time or vice versa or something is rotten in
                            // the state of Danmark
                            RecoveryLogger.i18NLogger.error_participant_ba_BAParticipantRecoveryModule_4(participantRecordClazzName, recoverUid, cnfe);
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            // this is also worrying, log an error
                            RecoveryLogger.i18NLogger.error_participant_ba_BAParticipantRecoveryModule_5(participantRecordClazzName, recoverUid, e);
                        }
                    } catch (IOException ioe) {
                        // hmm, record corrupted? log this as a warning
                        RecoveryLogger.i18NLogger.warn_participant_ba_BAParticipantRecoveryModule_6(recoverUid, ioe);
                    }
                } else {
                    // hmm, it ought not to be able to disappear unless the recovery manager knows about it
                    // this is an error!
                    RecoveryLogger.i18NLogger.error_participant_ba_BAParticipantRecoveryModule_7(recoverUid);
                }
            } catch (ObjectStoreException ose) {
                // if the object store is not working this is serious
                RecoveryLogger.i18NLogger.error_participant_ba_BAParticipantRecoveryModule_8(recoverUid, ose);
            }
        }
    }

    private Vector processParticipants( InputObjectState uids )
    {
        Vector uidVector = new Vector() ;

        if (RecoveryLogger.logger.isDebugEnabled()) {
            RecoveryLogger.logger.debug("processing " + _participantType
                    + " WS-BA participants");
        }

        Uid NULL_UID = Uid.nullUid();
        Uid theUid = null;

        while (true)
        {
            try
            {
                theUid = UidHelper.unpackFrom( uids ) ;
            }
            catch ( Exception ex )
            {
                break;
            }

            if (theUid.equals( NULL_UID ))
            {
                break;
            }

            if (RecoveryLogger.logger.isDebugEnabled()) {
                RecoveryLogger.logger.debug("found WS-BA participant " + theUid);
            }

            uidVector.addElement( theUid ) ;
        }

        return uidVector ;
    }

    private void processParticipantsStatus()
    {
        if (_participantUidVector != null) {
        // Process the Vector of transaction Uids
        Enumeration participantUidEnum = _participantUidVector.elements() ;

        while ( participantUidEnum.hasMoreElements() )
        {
            Uid currentUid = (Uid) participantUidEnum.nextElement();

            try
            {
                if ( _recoveryStore.currentState( currentUid, _participantType) != StateStatus.OS_UNKNOWN )
                {
                    doRecoverParticipant( currentUid ) ;
                }
            }
            catch ( ObjectStoreException ex )
            {
                RecoveryLogger.i18NLogger.warn_participant_ba_BAParticipantRecoveryModule_3(currentUid, ex);
            }
        }
        }

        // now get the BA recovery manager to try to activate recovered participants

        XTSBARecoveryManager.getRecoveryManager().recoverParticipants();
    }

    // 'type' within the Object Store for BAParticipant record.
    private String _participantType = BAParticipantRecoveryRecord.type() ;

    // Array of transactions found in the object store of the
    // ACCoordinator type.
    private Vector _participantUidVector = null ;

    // Reference to the Object Store.
    private static RecoveryStore _recoveryStore = null ;

}