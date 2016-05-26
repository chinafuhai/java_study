/**
 * CORBASystemException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class CORBASystemException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedInt minor;

    private com.asiainfo.obd.bookscheme.CORBACompletion_status completion_status;

    public CORBASystemException() {
    }

    public CORBASystemException(
           org.apache.axis.types.UnsignedInt minor,
           com.asiainfo.obd.bookscheme.CORBACompletion_status completion_status) {
        this.minor = minor;
        this.completion_status = completion_status;
    }


    /**
     * Gets the minor value for this CORBASystemException.
     * 
     * @return minor
     */
    public org.apache.axis.types.UnsignedInt getMinor() {
        return minor;
    }


    /**
     * Sets the minor value for this CORBASystemException.
     * 
     * @param minor
     */
    public void setMinor(org.apache.axis.types.UnsignedInt minor) {
        this.minor = minor;
    }


    /**
     * Gets the completion_status value for this CORBASystemException.
     * 
     * @return completion_status
     */
    public com.asiainfo.obd.bookscheme.CORBACompletion_status getCompletion_status() {
        return completion_status;
    }


    /**
     * Sets the completion_status value for this CORBASystemException.
     * 
     * @param completion_status
     */
    public void setCompletion_status(com.asiainfo.obd.bookscheme.CORBACompletion_status completion_status) {
        this.completion_status = completion_status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CORBASystemException)) return false;
        CORBASystemException other = (CORBASystemException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.minor==null && other.getMinor()==null) || 
             (this.minor!=null &&
              this.minor.equals(other.getMinor()))) &&
            ((this.completion_status==null && other.getCompletion_status()==null) || 
             (this.completion_status!=null &&
              this.completion_status.equals(other.getCompletion_status())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMinor() != null) {
            _hashCode += getMinor().hashCode();
        }
        if (getCompletion_status() != null) {
            _hashCode += getCompletion_status().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CORBASystemException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedInt"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("completion_status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "completion_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.completion_status"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
