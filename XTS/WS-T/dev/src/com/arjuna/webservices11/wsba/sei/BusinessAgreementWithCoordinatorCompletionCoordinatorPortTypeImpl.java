
package com.arjuna.webservices11.wsba.sei;

import com.arjuna.services.framework.task.Task;
import com.arjuna.services.framework.task.TaskManager;
import com.arjuna.webservices11.wsarj.ArjunaContext;
import com.arjuna.webservices11.wsba.processors.CoordinatorCompletionCoordinatorProcessor;
import com.arjuna.webservices11.SoapFault11;
import org.jboss.ws.api.addressing.MAP;
import com.arjuna.webservices11.wsaddr.AddressingHelper;
import com.arjuna.webservices.SoapFault;
import org.oasis_open.docs.ws_tx.wsba._2006._06.ExceptionType;
import org.oasis_open.docs.ws_tx.wsba._2006._06.NotificationType;
import org.oasis_open.docs.ws_tx.wsba._2006._06.StatusType;
import org.xmlsoap.schemas.soap.envelope.Fault;

import jakarta.annotation.Resource;
import jakarta.jws.*;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.soap.Addressing;
import jakarta.xml.ws.handler.MessageContext;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1-b03-
 * Generated source version: 2.0
 *
 */
@WebService(name = "BusinessAgreementWithCoordinatorCompletionCoordinatorPortType", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06",
        //wsdlLocation = "/WEB-INF/wsdl/wsba-coordinator-completion-coordinator-binding.wsdl",
        serviceName = "BusinessAgreementWithCoordinatorCompletionCoordinatorService",
        portName = "BusinessAgreementWithCoordinatorCompletionCoordinatorPortType"
)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@HandlerChain(file="/ws-t_handlers.xml")
@Addressing(required=true)
public class BusinessAgreementWithCoordinatorCompletionCoordinatorPortTypeImpl // implements BusinessAgreementWithCoordinatorCompletionCoordinatorPortType
{
    @Resource
    private WebServiceContext webServiceCtx;

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "CompletedOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Completed")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Completed")
    public void completedOperation(
        @WebParam(name = "Completed", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType completed = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().completed(completed, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "FailOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Fail")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Fail")
    public void failOperation(
        @WebParam(name = "Fail", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        ExceptionType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final ExceptionType fail = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().fail(fail, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "CompensatedOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Compensated")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Compensated")
    public void compensatedOperation(
        @WebParam(name = "Compensated", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType compensated = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().compensated(compensated, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "ClosedOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Closed")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Closed")
    public void closedOperation(
        @WebParam(name = "Closed", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType closed = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().closed(closed, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "CanceledOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Canceled")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Canceled")
    public void canceledOperation(
        @WebParam(name = "Canceled", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType canceled = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().cancelled(canceled, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "ExitOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Exit")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Exit")
    public void exitOperation(
        @WebParam(name = "Exit", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType exit = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().exit(exit, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "CannotComplete", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/CannotComplete")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/CannotComplete")
    public void cannotComplete(
        @WebParam(name = "CannotComplete", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType cannotComplete = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().cannotComplete(cannotComplete, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "GetStatusOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/GetStatus")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/GetStatus")
    public void getStatusOperation(
        @WebParam(name = "GetStatus", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType getStatus = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().getStatus(getStatus, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    /**
     *
     * @param parameters
     */
    @WebMethod(operationName = "StatusOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Status")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wsba/2006/06/Status")
    public void statusOperation(
        @WebParam(name = "Status", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        StatusType parameters)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final StatusType status = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getContext(ctx);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().status(status, inboundMap, arjunaContext) ;
            }
        }) ;
    }

    @WebMethod(operationName = "fault", action = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06/fault")
    @Oneway
    @Action(input="http://docs.oasis-open.org/ws-tx/wscoor/2006/06/fault")
    public void soapFault(
            @WebParam(name = "Fault", targetNamespace = "http://schemas.xmlsoap.org/soap/envelope/", partName = "parameters")
            Fault fault)
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);
        final SoapFault soapFault = SoapFault11.fromFault(fault);

        TaskManager.getManager().queueTask(new Task() {
            public void executeTask() {
                CoordinatorCompletionCoordinatorProcessor.getProcessor().soapFault(soapFault, inboundMap, arjunaContext); ;
            }
        }) ;
    }
}
