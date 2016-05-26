/**
 * ObIdl_MBookSchemeDefSSegmentPayMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSSegmentPayMethod  implements java.io.Serializable {
    private java.lang.String m_strPaymentMethod;

    private java.lang.String m_strCheckNo;

    public ObIdl_MBookSchemeDefSSegmentPayMethod() {
    }

    public ObIdl_MBookSchemeDefSSegmentPayMethod(
           java.lang.String m_strPaymentMethod,
           java.lang.String m_strCheckNo) {
           this.m_strPaymentMethod = m_strPaymentMethod;
           this.m_strCheckNo = m_strCheckNo;
    }


    /**
     * Gets the m_strPaymentMethod value for this ObIdl_MBookSchemeDefSSegmentPayMethod.
     * 
     * @return m_strPaymentMethod
     */
    public java.lang.String getM_strPaymentMethod() {
        return m_strPaymentMethod;
    }


    /**
     * Sets the m_strPaymentMethod value for this ObIdl_MBookSchemeDefSSegmentPayMethod.
     * 
     * @param m_strPaymentMethod
     */
    public void setM_strPaymentMethod(java.lang.String m_strPaymentMethod) {
        this.m_strPaymentMethod = m_strPaymentMethod;
    }


    /**
     * Gets the m_strCheckNo value for this ObIdl_MBookSchemeDefSSegmentPayMethod.
     * 
     * @return m_strCheckNo
     */
    public java.lang.String getM_strCheckNo() {
        return m_strCheckNo;
    }


    /**
     * Sets the m_strCheckNo value for this ObIdl_MBookSchemeDefSSegmentPayMethod.
     * 
     * @param m_strCheckNo
     */
    public void setM_strCheckNo(java.lang.String m_strCheckNo) {
        this.m_strCheckNo = m_strCheckNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSSegmentPayMethod)) return false;
        ObIdl_MBookSchemeDefSSegmentPayMethod other = (ObIdl_MBookSchemeDefSSegmentPayMethod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strPaymentMethod==null && other.getM_strPaymentMethod()==null) || 
             (this.m_strPaymentMethod!=null &&
              this.m_strPaymentMethod.equals(other.getM_strPaymentMethod()))) &&
            ((this.m_strCheckNo==null && other.getM_strCheckNo()==null) || 
             (this.m_strCheckNo!=null &&
              this.m_strCheckNo.equals(other.getM_strCheckNo())));
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
        if (getM_strPaymentMethod() != null) {
            _hashCode += getM_strPaymentMethod().hashCode();
        }
        if (getM_strCheckNo() != null) {
            _hashCode += getM_strCheckNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSSegmentPayMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentPayMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCheckNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCheckNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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

}
