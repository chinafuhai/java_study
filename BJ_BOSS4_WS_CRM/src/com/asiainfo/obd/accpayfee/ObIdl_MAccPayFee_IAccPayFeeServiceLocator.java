/**
 * ObIdl_MAccPayFeeIAccPayFeeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccPayFee_IAccPayFeeServiceLocator extends org.apache.axis.client.Service implements ObIdl_MAccPayFee_IAccPayFeeService {

    public ObIdl_MAccPayFee_IAccPayFeeServiceLocator() {
    }

    public ObIdl_MAccPayFee_IAccPayFeeServiceLocator(java.lang.String address) {
    	setObIdl_MAccPayFeeIAccPayFeePortEndpointAddress(address+"/ObIdl_MAccPayFee.IAccPayFeePort");
    }
    
    public ObIdl_MAccPayFee_IAccPayFeeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ObIdl_MAccPayFee_IAccPayFeeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObIdl_MAccPayFeeIAccPayFeePort
    //private java.lang.String ObIdl_MAccPayFeeIAccPayFeePort_address = "http://10.7.5.132:13105/axis/services/ObIdl_MAccPayFee.IAccPayFeePort";
    private java.lang.String ObIdl_MAccPayFeeIAccPayFeePort_address = "";
    
    public java.lang.String getObIdl_MAccPayFeeIAccPayFeePortAddress() {
        return ObIdl_MAccPayFeeIAccPayFeePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName = "ObIdl_MAccPayFee.IAccPayFeePort";

    public java.lang.String getObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName() {
        return ObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName;
    }

    public void setObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName(java.lang.String name) {
        ObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName = name;
    }

    public com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFee getObIdl_MAccPayFeeIAccPayFeePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObIdl_MAccPayFeeIAccPayFeePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObIdl_MAccPayFeeIAccPayFeePort(endpoint);
    }

    public com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFee getObIdl_MAccPayFeeIAccPayFeePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	com.asiainfo.obd.accpayfee.ObIdl_MAccPayFeeIAccPayFeeBindingStub _stub = new com.asiainfo.obd.accpayfee.ObIdl_MAccPayFeeIAccPayFeeBindingStub(portAddress, this);
            _stub.setPortName(getObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObIdl_MAccPayFeeIAccPayFeePortEndpointAddress(java.lang.String address) {
        ObIdl_MAccPayFeeIAccPayFeePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.asiainfo.obd.accpayfee.ObIdl_MAccPayFee_IAccPayFee.class.isAssignableFrom(serviceEndpointInterface)) {
            	com.asiainfo.obd.accpayfee.ObIdl_MAccPayFeeIAccPayFeeBindingStub _stub = new com.asiainfo.obd.accpayfee.ObIdl_MAccPayFeeIAccPayFeeBindingStub(new java.net.URL(ObIdl_MAccPayFeeIAccPayFeePort_address), this);
                _stub.setPortName(getObIdl_MAccPayFeeIAccPayFeePortWSDDServiceName());
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
        if ("ObIdl_MAccPayFee.IAccPayFeePort".equals(inputPortName)) {
            return getObIdl_MAccPayFeeIAccPayFeePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ObIdl_MAccPayFee.IAccPayFee", "ObIdl_MAccPayFee_IAccPayFeeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ObIdl_MAccPayFee.IAccPayFee", "ObIdl_MAccPayFee.IAccPayFeePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObIdl_MAccPayFeeIAccPayFeePort".equals(portName)) {
            setObIdl_MAccPayFeeIAccPayFeePortEndpointAddress(address);
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
