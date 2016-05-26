/**
 * ObIdl_MBookSchemeDefSOneTimePaymentQryIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSOneTimePaymentQryIn  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.String m_strPaymentType;

    private java.lang.String m_dtmBeginDate;

    private java.lang.String m_dtmEndDate;

    public ObIdl_MBookSchemeDefSOneTimePaymentQryIn() {
    }

    public ObIdl_MBookSchemeDefSOneTimePaymentQryIn(
           java.lang.Long m_llAcctId,
           java.lang.String m_strPaymentType,
           java.lang.String m_dtmBeginDate,
           java.lang.String m_dtmEndDate) {
           this.m_llAcctId = m_llAcctId;
           this.m_strPaymentType = m_strPaymentType;
           this.m_dtmBeginDate = m_dtmBeginDate;
           this.m_dtmEndDate = m_dtmEndDate;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @return m_dtmBeginDate
     */
    public java.lang.String getM_dtmBeginDate() {
        return m_dtmBeginDate;
    }


    /**
     * Sets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @param m_dtmBeginDate
     */
    public void setM_dtmBeginDate(java.lang.String m_dtmBeginDate) {
        this.m_dtmBeginDate = m_dtmBeginDate;
    }


    /**
     * Gets the m_dtmEndDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @return m_dtmEndDate
     */
    public java.lang.String getM_dtmEndDate() {
        return m_dtmEndDate;
    }


    /**
     * Sets the m_dtmEndDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryIn.
     * 
     * @param m_dtmEndDate
     */
    public void setM_dtmEndDate(java.lang.String m_dtmEndDate) {
        this.m_dtmEndDate = m_dtmEndDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSOneTimePaymentQryIn)) return false;
        ObIdl_MBookSchemeDefSOneTimePaymentQryIn other = (ObIdl_MBookSchemeDefSOneTimePaymentQryIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_strPaymentType==null && other.getM_strPaymentType()==null) || 
             (this.m_strPaymentType!=null &&
              this.m_strPaymentType.equals(other.getM_strPaymentType()))) &&
            ((this.m_dtmBeginDate==null && other.getM_dtmBeginDate()==null) || 
             (this.m_dtmBeginDate!=null &&
              this.m_dtmBeginDate.equals(other.getM_dtmBeginDate()))) &&
            ((this.m_dtmEndDate==null && other.getM_dtmEndDate()==null) || 
             (this.m_dtmEndDate!=null &&
              this.m_dtmEndDate.equals(other.getM_dtmEndDate())));
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
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_strPaymentType() != null) {
            _hashCode += getM_strPaymentType().hashCode();
        }
        if (getM_dtmBeginDate() != null) {
            _hashCode += getM_dtmBeginDate().hashCode();
        }
        if (getM_dtmEndDate() != null) {
            _hashCode += getM_dtmEndDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSOneTimePaymentQryIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmBeginDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmBeginDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmEndDate"));
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
