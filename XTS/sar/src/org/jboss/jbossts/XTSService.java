/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */

package org.jboss.jbossts;

import org.jboss.jbossts.xts.environment.XTSEnvironmentBean;
import org.jboss.jbossts.xts.environment.XTSPropertyManager;
import org.jboss.jbossts.xts.initialisation.XTSInitialisation;
import org.jboss.jbossts.xts.logging.XTSLogger;
import org.jboss.jbossts.xts.recovery.coordinator.CoordinatorRecoveryInitialisation;
import com.arjuna.services.framework.task.TaskManager;
import com.arjuna.mwlabs.wsas.activity.ActivityReaper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * $Id$
 */
public class XTSService implements XTSServiceMBean {

    // TODO expose as bean properties
    private int taskManagerMinWorkerCount = 0;
    private int taskManagerMaxWorkerCount = 10;

    public XTSService() {}

    public void start() throws Exception
    {
        XTSLogger.logger.info("JBossTS XTS Transaction Service - starting");

        //  execute startup for all registered initialisations

        XTSEnvironmentBean xtsEnvironmentBean = XTSPropertyManager.getXTSEnvironmentBean();
        Iterator<String> iterator = xtsEnvironmentBean.getXtsInitialisations().iterator();

        while (iterator.hasNext()) {
            String className = iterator.next();

            Class<?> clazz = null;

            try {
                clazz = CoordinatorRecoveryInitialisation.class.getClassLoader().loadClass(className);
            } catch (ClassNotFoundException cnfe) {
                XTSLogger.i18NLogger.error_XTSService_1(className, cnfe);
                continue;
            }

            if (!XTSInitialisation.class.isAssignableFrom(clazz)) {
                XTSLogger.i18NLogger.error_XTSService_2(className);
                continue;
            }

            try {
                XTSInitialisation initialisation = (XTSInitialisation)clazz.getDeclaredConstructor().newInstance();
                initialisation.startup();
                xtsInitialisations.add(initialisation);
            } catch (InstantiationException ie) {
                XTSLogger.i18NLogger.error_XTSService_3(className, ie);
            } catch (IllegalAccessException iae) {
                XTSLogger.i18NLogger.error_XTSService_4(className, iae);
            }
        }

        TaskManagerInitialisation();
    }

    public void stop() throws Exception
    {
        XTSLogger.logger.info("JBossTS XTS Transaction Service - stopping");

        TaskManager.getManager().shutdown() ; // com.arjuna.services.framework.admin.TaskManagerInitialisation

        // shutdown the activity service reaper

        ActivityReaper.shutdown();

        //  execute shutdown for all registered initialisations

        Iterator<XTSInitialisation> iterator = xtsInitialisations.iterator();

        while (iterator.hasNext()) {
            XTSInitialisation xtsInitialisation = iterator.next();
            xtsInitialisation.shutdown();
        }

        xtsInitialisations.clear();
    }

    private void TaskManagerInitialisation()
    {
        final TaskManager taskManager = TaskManager.getManager() ;
        taskManager.setMinimumWorkerCount(taskManagerMinWorkerCount) ;
        taskManager.setMaximumWorkerCount(taskManagerMaxWorkerCount) ;
    }

    private List<XTSInitialisation> xtsInitialisations = new ArrayList<XTSInitialisation>();
}