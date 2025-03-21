/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */

package org.jboss.jbossts.xts.recovery.logging;

import com.arjuna.ats.arjuna.common.Uid;
import org.jboss.logging.annotations.*;
import static org.jboss.logging.Logger.Level.*;
import static org.jboss.logging.annotations.Message.Format.*;

/**
 * i18n log messages for the xtsrecovery module.
 *
 * @author Jonathan Halliday (jonathan.halliday@redhat.com) 2010-06
 */
@MessageLogger(projectCode = "ARJUNA")
public interface recoveryI18NLogger {

    /*
        Message IDs are unique and non-recyclable.
        Don't change the purpose of existing messages.
          (tweak the message text or params for clarification if you like).
        Allocate new messages by following instructions at the bottom of the file.
     */

//	@Message(id = 46001, value = "RecoveryATCoordinator.replayPhase2: Unexpected status: {0}", format = MESSAGE_FORMAT)
//	@LogMessage(level = WARN)
//	public void warn_coordinator_at_RecoveryATCoordinator_2(String arg0);

	@Message(id = 46002, value = "RecoveryATCoordinator.replayPhase2 transaction {0} not activated, unable to replay phase 2 commit", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_RecoveryATCoordinator_4(Uid arg0);

//	@Message(id = 46003, value = "RecoverySubordinateATCoordinator.replayPhase2: Unexpected status: {0}", format = MESSAGE_FORMAT)
//	@LogMessage(level = WARN)
//	public void warn_coordinator_at_RecoverySubordinateATCoordinator_2(String arg0);

	@Message(id = 46004, value = "RecoverySubordinateATCoordinator.replayPhase2 transaction {0} not activated, unable to replay phase 2 commit", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_RecoverySubordinateATCoordinator_4(Uid arg0);

//	@Message(id = 46005, value = "RecoverBASubordinateCoordinator.replayPhase2: Unexpected status: {0}", format = MESSAGE_FORMAT)
//	@LogMessage(level = WARN)
//	public void warn_coordinator_ba_RecoverBASubordinateCoordinator_2(String arg0);

	@Message(id = 46006, value = "RecoverBASubordinateCoordinator.replayPhase2 transaction {0} not activated, unable to replay phase 2 commit", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_RecoverBASubordinateCoordinator_4(Uid arg0);

//	@Message(id = 46007, value = "RecoveryBACoordinator.replayPhase2: Unexpected status: {0}", format = MESSAGE_FORMAT)
//	@LogMessage(level = WARN)
//	public void warn_coordinator_ba_RecoveryBACoordinator_2(String arg0);

	@Message(id = 46008, value = "RecoveryBACoordinator.replayPhase2 transaction {0} not activated, unable to replay phase 2 commit", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_RecoveryBACoordinator_4(Uid arg0);

//	@Message(id = 46009, value = "RecoverBASubordinateCoordinator.replayPhase2 recovering {0} ActionStatus is {1}", format = MESSAGE_FORMAT)
//	@LogMessage(level = WARN)
//	public void warn_coordinator_ba_RecoverySubordinateBACoordinator_1(String arg0, String arg1);

	@Message(id = 46010, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_ATCoordinatorRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46011, value = "failed to recover Transaction {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_ATCoordinatorRecoveryModule_2(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46012, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_ATCoordinatorRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46013, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_SubordinateATCoordinatorRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46014, value = "failed to recover Transaction {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_SubordinateATCoordinatorRecoveryModule_2(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46015, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_at_SubordinateATCoordinatorRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46016, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_BACoordinatorRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46017, value = "failed to recover Transaction {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_BACoordinatorRecoveryModule_2(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46018, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_BACoordinatorRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46019, value = "failed to recover Transaction {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_SubordinateBACoordinatorRecoveryModule_2(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46020, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_SubordinateBACoordinatorRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46021, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_coordinator_ba_SubordinateCoordinatorRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46022, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_ATParticipantRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46023, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_ATParticipantRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46024, value = "unable to load recovery record implementation class {0} for WS-AT participant recovery record {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_at_ATParticipantRecoveryModule_4(String arg0, Uid arg1, @Cause() Throwable arg2);

	@Message(id = 46025, value = "unable to instantiate recovery record implementation class {0} for WS-AT participant recovery record {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_at_ATParticipantRecoveryModule_5(String arg0, Uid arg1, @Cause() Throwable arg2);

	@Message(id = 46026, value = "unable to unpack recovery record data for WS-AT participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_at_ATParticipantRecoveryModule_6(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46027, value = "missing recovery record data for WS-AT participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_at_ATParticipantRecoveryModule_7(Uid arg0);

	@Message(id = 46028, value = "unable to read recovery record data for WS-AT participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_at_ATParticipantRecoveryModule_8(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46029, value = "exception writing recovery record for WS-AT participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_XTSATRecoveryModule_1(String arg0, @Cause() Throwable arg1);

	@Message(id = 46030, value = "exception removing recovery record {0} for WS-AT participant {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_XTSATRecoveryModule_2(Uid arg0, String arg1, @Cause() Throwable arg2);

	@Message(id = 46031, value = "exception reactivating recovered WS-AT participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_XTSATRecoveryModule_3(String arg0, @Cause() Throwable arg1);

	@Message(id = 46032, value = "no XTS application recovery module found to help reactivate recovered WS-AT participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_XTSATRecoveryModule_4(String arg0);

	@Message(id = 46033, value = "Compensating orphaned subordinate WS-AT transcation {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_at_XTSATRecoveryModule_5(Uid arg0);

	@Message(id = 46034, value = "RecoveryManagerStatusModule: Object store exception", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_BAParticipantRecoveryModule_1(@Cause() Throwable arg0);

	@Message(id = 46035, value = "failed to access transaction store {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_BAParticipantRecoveryModule_3(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46036, value = "unable to load recovery record implementation class {0} for WS-BA participant recovery record {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_ba_BAParticipantRecoveryModule_4(String arg0, Uid arg1, @Cause() Throwable arg2);

	@Message(id = 46037, value = "unable to instantiate recovery record implementation class {0} for WS-BA participant recovery record {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_ba_BAParticipantRecoveryModule_5(String arg0, Uid arg1, @Cause() Throwable arg2);

	@Message(id = 46038, value = "unable to unpack recovery record data for WS-BA participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_BAParticipantRecoveryModule_6(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46039, value = "missing recovery record data for WS-BA participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_ba_BAParticipantRecoveryModule_7(Uid arg0);

	@Message(id = 46040, value = "unable to read recovery record data for WS-BA participant recovery record {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = ERROR)
	public void error_participant_ba_BAParticipantRecoveryModule_8(Uid arg0, @Cause() Throwable arg1);

	@Message(id = 46041, value = "exception writing recovery record for WS-BA participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_XTSBARecoveryModule_1(String arg0, @Cause() Throwable arg1);

	@Message(id = 46042, value = "exception removing recovery record {0} for WS-BA participant {1}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_XTSBARecoveryModule_2(Uid arg0, String arg1, @Cause() Throwable arg2);

	@Message(id = 46043, value = "exception reactivating recovered WS-BA participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_XTSBARecoveryModule_3(String arg0, @Cause() Throwable arg1);

	@Message(id = 46044, value = "no XTS application recovery module found to help reactivate recovered WS-BA participant {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_XTSBARecoveryModule_4(String arg0);

	@Message(id = 46045, value = "Compensating orphaned subordinate WS-BA transcation {0}", format = MESSAGE_FORMAT)
	@LogMessage(level = WARN)
	public void warn_participant_ba_XTSBARecoveryModule_5(Uid arg0);

    @Message(id = 46046, value = "Unable to load recovery module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_1(String arg0, @Cause() Throwable arg1);

    @Message(id = 46047, value = "Not a recovery module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_2(String arg0);

    @Message(id = 46048, value = "Unable to instantiate module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_3(String arg0, @Cause() Throwable arg1);

    @Message(id = 46049, value = "Unable to access module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_4(String arg0, @Cause() Throwable arg1);

    @Message(id = 46050, value = "Unable to load recovery module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_1(String arg0, @Cause() Throwable arg1);

    @Message(id = 46051, value = "Not a recovery module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_2(String arg0);

    @Message(id = 46052, value = "Unable to instantiate module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_3(String arg0, @Cause() Throwable arg1);

    @Message(id = 46053, value = "Unable to access module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_4(String arg0, @Cause() Throwable arg1);

    @Message(id = 46054, value = "Unable to invoke module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_5(String arg0, @Cause() Throwable arg1);

    @Message(id = 46055, value = "Unable to find module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_coordinator_CoordinatorRecoveryInitialisation_6(String arg0, @Cause() Throwable arg1);

    @Message(id = 46056, value = "Unable to invoke module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_5(String arg0, @Cause() Throwable arg1);

    @Message(id = 46057, value = "Unable to find module class {0}", format = MESSAGE_FORMAT)
    @LogMessage(level = ERROR)
    public void error_recovery_participant_ParticipantRecoveryInitialisation_6(String arg0, @Cause() Throwable arg1);

    /*
        Allocate new messages directly above this notice.
          - id: use the next id number in numeric sequence. Don't reuse ids.
          The first two digits of the id(XXyyy) denote the module
            all message in this file should have the same prefix.
          - value: default (English) version of the log message.
          - level: according to severity semantics defined at http://docspace.corp.redhat.com/docs/DOC-30217
          Debug and trace don't get i18n. Everything else MUST be i18n.
          By convention methods with String return type have prefix get_,
            all others are log methods and have prefix <level>_
     */

}