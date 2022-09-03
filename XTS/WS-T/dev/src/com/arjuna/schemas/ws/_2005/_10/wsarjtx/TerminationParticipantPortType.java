
package com.arjuna.schemas.ws._2005._10.wsarjtx;

import org.xmlsoap.schemas.soap.envelope.Fault;

import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-hudson-182-RC1
 * Generated source version: 2.1
 * 
 */
@WebService(name = "TerminationParticipantPortType", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TerminationParticipantPortType {


    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "CompletedOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Completed")
    @Oneway
    public void completedOperation(
        @WebParam(name = "Completed", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "ClosedOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Closed")
    @Oneway
    public void closedOperation(
        @WebParam(name = "Closed", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "CancelledOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Cancelled")
    @Oneway
    public void cancelledOperation(
        @WebParam(name = "Cancelled", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "FaultedOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Faulted")
    @Oneway
    public void faultedOperation(
        @WebParam(name = "Faulted", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "FaultOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Fault")
    @Oneway
    public void faultOperation(
        @WebParam(name = "Fault", targetNamespace = "http://schemas.xmlsoap.org/soap/envelope/", partName = "parameters")
        Fault parameters);
}
