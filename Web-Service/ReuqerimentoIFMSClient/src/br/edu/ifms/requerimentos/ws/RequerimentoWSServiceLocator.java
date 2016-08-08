/**
 * RequerimentoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.edu.ifms.requerimentos.ws;

public class RequerimentoWSServiceLocator extends org.apache.axis.client.Service implements br.edu.ifms.requerimentos.ws.RequerimentoWSService {

    public RequerimentoWSServiceLocator() {
    }


    public RequerimentoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequerimentoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequerimentoWS
    private java.lang.String RequerimentoWS_address = "http://localhost:8080/TesteBoot/services/RequerimentoWS";

    public java.lang.String getRequerimentoWSAddress() {
        return RequerimentoWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequerimentoWSWSDDServiceName = "RequerimentoWS";

    public java.lang.String getRequerimentoWSWSDDServiceName() {
        return RequerimentoWSWSDDServiceName;
    }

    public void setRequerimentoWSWSDDServiceName(java.lang.String name) {
        RequerimentoWSWSDDServiceName = name;
    }

    public br.edu.ifms.requerimentos.ws.RequerimentoWS getRequerimentoWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequerimentoWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequerimentoWS(endpoint);
    }

    public br.edu.ifms.requerimentos.ws.RequerimentoWS getRequerimentoWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.edu.ifms.requerimentos.ws.RequerimentoWSSoapBindingStub _stub = new br.edu.ifms.requerimentos.ws.RequerimentoWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequerimentoWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequerimentoWSEndpointAddress(java.lang.String address) {
        RequerimentoWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.edu.ifms.requerimentos.ws.RequerimentoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                br.edu.ifms.requerimentos.ws.RequerimentoWSSoapBindingStub _stub = new br.edu.ifms.requerimentos.ws.RequerimentoWSSoapBindingStub(new java.net.URL(RequerimentoWS_address), this);
                _stub.setPortName(getRequerimentoWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RequerimentoWS".equals(inputPortName)) {
            return getRequerimentoWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.requerimentos.ifms.edu.br", "RequerimentoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.requerimentos.ifms.edu.br", "RequerimentoWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequerimentoWS".equals(portName)) {
            setRequerimentoWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
