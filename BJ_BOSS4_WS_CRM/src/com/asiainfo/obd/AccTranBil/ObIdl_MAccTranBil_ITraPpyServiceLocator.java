/**
 * ObIdl_MAccTranBilITraPpyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBil_ITraPpyServiceLocator extends org.apache.axis.client.Service implements ObIdl_MAccTranBil_ITraPpyService {

    public ObIdl_MAccTranBil_ITraPpyServiceLocator() {
    }

    public ObIdl_MAccTranBil_ITraPpyServiceLocator(java.lang.String address) {
    	setObIdl_MAccTranBilITraPpyPortEndpointAddress(address+"/ObIdl_MAccTranBil.ITraPpyPort");
    }
    
    public ObIdl_MAccTranBil_ITraPpyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ObIdl_MAccTranBil_ITraPpyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObIdl_MAccTranBilITraPpyPort
    private java.lang.String ObIdl_MAccTranBilITraPpyPort_address = "http://...";

    public java.lang.String getObIdl_MAccTranBilITraPpyPortAddress() {
        return ObIdl_MAccTranBilITraPpyPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObIdl_MAccTranBilITraPpyPortWSDDServiceName = "ObIdl_MAccTranBil.ITraPpyPort";

    public java.lang.String getObIdl_MAccTranBilITraPpyPortWSDDServiceName() {
        return ObIdl_MAccTranBilITraPpyPortWSDDServiceName;
    }

    public void setObIdl_MAccTranBilITraPpyPortWSDDServiceName(java.lang.String name) {
        ObIdl_MAccTranBilITraPpyPortWSDDServiceName = name;
    }

    public ObIdl_MAccTranBil_ITraPpy getObIdl_MAccTranBilITraPpyPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObIdl_MAccTranBilITraPpyPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObIdl_MAccTranBilITraPpyPort(endpoint);
    }

    public ObIdl_MAccTranBil_ITraPpy getObIdl_MAccTranBilITraPpyPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ObIdl_MAccTranBilITraPpyBindingStub _stub = new ObIdl_MAccTranBilITraPpyBindingStub(portAddress, this);
            _stub.setPortName(getObIdl_MAccTranBilITraPpyPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObIdl_MAccTranBilITraPpyPortEndpointAddress(java.lang.String address) {
        ObIdl_MAccTranBilITraPpyPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ObIdl_MAccTranBil_ITraPpy.class.isAssignableFrom(serviceEndpointInterface)) {
                ObIdl_MAccTranBilITraPpyBindingStub _stub = new ObIdl_MAccTranBilITraPpyBindingStub(new java.net.URL(ObIdl_MAccTranBilITraPpyPort_address), this);
                _stub.setPortName(getObIdl_MAccTranBilITraPpyPortWSDDServiceName());
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
        if ("ObIdl_MAccTranBil.ITraPpyPort".equals(inputPortName)) {
            return getObIdl_MAccTranBilITraPpyPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.ITraPpyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.ITraPpyPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObIdl_MAccTranBilITraPpyPort".equals(portName)) {
            setObIdl_MAccTranBilITraPpyPortEndpointAddress(address);
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
