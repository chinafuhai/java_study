/**
 * ObIdl_MAccPrtInvIAccPrtInvServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInv_IAccPrtInvServiceLocator extends org.apache.axis.client.Service implements ObIdl_MAccPrtInv_IAccPrtInvService {

    public ObIdl_MAccPrtInv_IAccPrtInvServiceLocator() {
    }

    public ObIdl_MAccPrtInv_IAccPrtInvServiceLocator(java.lang.String address) {
    	setObIdl_MAccPrtInvIAccPrtInvPortEndpointAddress(address+"/ObIdl_MAccPrtInv.IAccPrtInvPort");
    }

    public ObIdl_MAccPrtInv_IAccPrtInvServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ObIdl_MAccPrtInv_IAccPrtInvServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObIdl_MAccPrtInvIAccPrtInvPort
    private java.lang.String ObIdl_MAccPrtInvIAccPrtInvPort_address = "http://...";

    public java.lang.String getObIdl_MAccPrtInvIAccPrtInvPortAddress() {
        return ObIdl_MAccPrtInvIAccPrtInvPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName = "ObIdl_MAccPrtInv.IAccPrtInvPort";

    public java.lang.String getObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName() {
        return ObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName;
    }

    public void setObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName(java.lang.String name) {
        ObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName = name;
    }

    public ObIdl_MAccPrtInv_IAccPrtInv getObIdl_MAccPrtInvIAccPrtInvPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObIdl_MAccPrtInvIAccPrtInvPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObIdl_MAccPrtInvIAccPrtInvPort(endpoint);
    }

    public ObIdl_MAccPrtInv_IAccPrtInv getObIdl_MAccPrtInvIAccPrtInvPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ObIdl_MAccPrtInvIAccPrtInvBindingStub _stub = new ObIdl_MAccPrtInvIAccPrtInvBindingStub(portAddress, this);
            _stub.setPortName(getObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObIdl_MAccPrtInvIAccPrtInvPortEndpointAddress(java.lang.String address) {
        ObIdl_MAccPrtInvIAccPrtInvPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ObIdl_MAccPrtInv_IAccPrtInv.class.isAssignableFrom(serviceEndpointInterface)) {
                ObIdl_MAccPrtInvIAccPrtInvBindingStub _stub = new ObIdl_MAccPrtInvIAccPrtInvBindingStub(new java.net.URL(ObIdl_MAccPrtInvIAccPrtInvPort_address), this);
                _stub.setPortName(getObIdl_MAccPrtInvIAccPrtInvPortWSDDServiceName());
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
        if ("ObIdl_MAccPrtInv.IAccPrtInvPort".equals(inputPortName)) {
            return getObIdl_MAccPrtInvIAccPrtInvPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInv.IAccPrtInvService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInv.IAccPrtInvPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObIdl_MAccPrtInvIAccPrtInvPort".equals(portName)) {
            setObIdl_MAccPrtInvIAccPrtInvPortEndpointAddress(address);
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
