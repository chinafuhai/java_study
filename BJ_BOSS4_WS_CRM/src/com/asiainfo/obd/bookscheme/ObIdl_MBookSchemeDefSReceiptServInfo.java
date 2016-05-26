/**
 * ObIdl_MBookSchemeDefSReceiptServInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSReceiptServInfo  implements java.io.Serializable {
    private java.lang.String m_strDevNumber;

    private java.lang.String m_strExtCustomerId;

    private java.lang.String m_strCustomerName;

    public ObIdl_MBookSchemeDefSReceiptServInfo() {
    }

    public ObIdl_MBookSchemeDefSReceiptServInfo(
           java.lang.String m_strDevNumber,
           java.lang.String m_strExtCustomerId,
           java.lang.String m_strCustomerName) {
           this.m_strDevNumber = m_strDevNumber;
           this.m_strExtCustomerId = m_strExtCustomerId;
           this.m_strCustomerName = m_strCustomerName;
    }


    /**
     * Gets the m_strDevNumber value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @return m_strDevNumber
     */
    public java.lang.String getM_strDevNumber() {
        return m_strDevNumber;
    }


    /**
     * Sets the m_strDevNumber value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @param m_strDevNumber
     */
    public void setM_strDevNumber(java.lang.String m_strDevNumber) {
        this.m_strDevNumber = m_strDevNumber;
    }


    /**
     * Gets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @return m_strExtCustomerId
     */
    public java.lang.String getM_strExtCustomerId() {
        return m_strExtCustomerId;
    }


    /**
     * Sets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @param m_strExtCustomerId
     */
    public void setM_strExtCustomerId(java.lang.String m_strExtCustomerId) {
        this.m_strExtCustomerId = m_strExtCustomerId;
    }


    /**
     * Gets the m_strCustomerName value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @return m_strCustomerName
     */
    public java.lang.String getM_strCustomerName() {
        return m_strCustomerName;
    }


    /**
     * Sets the m_strCustomerName value for this ObIdl_MBookSchemeDefSReceiptServInfo.
     * 
     * @param m_strCustomerName
     */
    public void setM_strCustomerName(java.lang.String m_strCustomerName) {
        this.m_strCustomerName = m_strCustomerName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSReceiptServInfo)) return false;
        ObIdl_MBookSchemeDefSReceiptServInfo other = (ObIdl_MBookSchemeDefSReceiptServInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strDevNumber==null && other.getM_strDevNumber()==null) || 
             (this.m_strDevNumber!=null &&
              this.m_strDevNumber.equals(other.getM_strDevNumber()))) &&
            ((this.m_strExtCustomerId==null && other.getM_strExtCustomerId()==null) || 
             (this.m_strExtCustomerId!=null &&
              this.m_strExtCustomerId.equals(other.getM_strExtCustomerId()))) &&
            ((this.m_strCustomerName==null && other.getM_strCustomerName()==null) || 
             (this.m_strCustomerName!=null &&
              this.m_strCustomerName.equals(other.getM_strCustomerName())));
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
        if (getM_strDevNumber() != null) {
            _hashCode += getM_strDevNumber().hashCode();
        }
        if (getM_strExtCustomerId() != null) {
            _hashCode += getM_strExtCustomerId().hashCode();
        }
        if (getM_strCustomerName() != null) {
            _hashCode += getM_strCustomerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSReceiptServInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SReceiptServInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strDevNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strDevNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strExtCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strExtCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCustomerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustomerName"));
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
