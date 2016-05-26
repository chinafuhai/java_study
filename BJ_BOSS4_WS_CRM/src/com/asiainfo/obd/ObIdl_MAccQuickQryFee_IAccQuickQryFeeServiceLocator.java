/**
 * ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public class ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator extends org.apache.axis.client.Service implements com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFeeService {

    public ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator() {
    }


    public ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObIdl_MAccQuickQryFeeIAccQuickQryFeePort
    private java.lang.String ObIdl_MAccQuickQryFeeIAccQuickQryFeePort_address = "http://10.7.6.124:13000/axis/services/ObIdl_MAccQuickQryFee.IAccQuickQryFeePort";

    public java.lang.String getObIdl_MAccQuickQryFeeIAccQuickQryFeePortAddress() {
        return ObIdl_MAccQuickQryFeeIAccQuickQryFeePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName = "ObIdl_MAccQuickQryFee.IAccQuickQryFeePort";

    public java.lang.String getObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName() {
        return ObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName;
    }

    public void setObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName(java.lang.String name) {
        ObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName = name;
    }

    public com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFee getObIdl_MAccQuickQryFeeIAccQuickQryFeePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObIdl_MAccQuickQryFeeIAccQuickQryFeePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObIdl_MAccQuickQryFeeIAccQuickQryFeePort(endpoint);
    }

    public com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFee getObIdl_MAccQuickQryFeeIAccQuickQryFeePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.asiainfo.obd.ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub _stub = new com.asiainfo.obd.ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub(portAddress, this);
            _stub.setPortName(getObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObIdl_MAccQuickQryFeeIAccQuickQryFeePortEndpointAddress(java.lang.String address) {
        ObIdl_MAccQuickQryFeeIAccQuickQryFeePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFee.class.isAssignableFrom(serviceEndpointInterface)) {
                com.asiainfo.obd.ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub _stub = new com.asiainfo.obd.ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub(new java.net.URL(ObIdl_MAccQuickQryFeeIAccQuickQryFeePort_address), this);
                _stub.setPortName(getObIdl_MAccQuickQryFeeIAccQuickQryFeePortWSDDServiceName());
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
        if ("ObIdl_MAccQuickQryFee.IAccQuickQryFeePort".equals(inputPortName)) {
            return getObIdl_MAccQuickQryFeeIAccQuickQryFeePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "ObIdl_MAccQuickQryFee_IAccQuickQryFeeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "ObIdl_MAccQuickQryFee.IAccQuickQryFeePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObIdl_MAccQuickQryFeeIAccQuickQryFeePort".equals(portName)) {
            setObIdl_MAccQuickQryFeeIAccQuickQryFeePortEndpointAddress(address);
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
