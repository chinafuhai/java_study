/**
 * ObIdl_MBookSchemeDefSOneTimePaymentQryOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSOneTimePaymentQryOut  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.String m_strPaymentType;

    private java.lang.String m_dtmBeginDate;

    private java.lang.Long m_llSegmentAmount;

    private java.lang.Long m_llUncoveredAmount;

    private java.lang.String m_strStatus;

    public ObIdl_MBookSchemeDefSOneTimePaymentQryOut() {
    }

    public ObIdl_MBookSchemeDefSOneTimePaymentQryOut(
           java.lang.Long m_llAcctId,
           java.lang.String m_strPaymentType,
           java.lang.String m_dtmBeginDate,
           java.lang.Long m_llSegmentAmount,
           java.lang.Long m_llUncoveredAmount,
           java.lang.String m_strStatus) {
           this.m_llAcctId = m_llAcctId;
           this.m_strPaymentType = m_strPaymentType;
           this.m_dtmBeginDate = m_dtmBeginDate;
           this.m_llSegmentAmount = m_llSegmentAmount;
           this.m_llUncoveredAmount = m_llUncoveredAmount;
           this.m_strStatus = m_strStatus;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_dtmBeginDate
     */
    public java.lang.String getM_dtmBeginDate() {
        return m_dtmBeginDate;
    }


    /**
     * Sets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_dtmBeginDate
     */
    public void setM_dtmBeginDate(java.lang.String m_dtmBeginDate) {
        this.m_dtmBeginDate = m_dtmBeginDate;
    }


    /**
     * Gets the m_llSegmentAmount value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_llSegmentAmount
     */
    public java.lang.Long getM_llSegmentAmount() {
        return m_llSegmentAmount;
    }


    /**
     * Sets the m_llSegmentAmount value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_llSegmentAmount
     */
    public void setM_llSegmentAmount(java.lang.Long m_llSegmentAmount) {
        this.m_llSegmentAmount = m_llSegmentAmount;
    }


    /**
     * Gets the m_llUncoveredAmount value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_llUncoveredAmount
     */
    public java.lang.Long getM_llUncoveredAmount() {
        return m_llUncoveredAmount;
    }


    /**
     * Sets the m_llUncoveredAmount value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_llUncoveredAmount
     */
    public void setM_llUncoveredAmount(java.lang.Long m_llUncoveredAmount) {
        this.m_llUncoveredAmount = m_llUncoveredAmount;
    }


    /**
     * Gets the m_strStatus value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @return m_strStatus
     */
    public java.lang.String getM_strStatus() {
        return m_strStatus;
    }


    /**
     * Sets the m_strStatus value for this ObIdl_MBookSchemeDefSOneTimePaymentQryOut.
     * 
     * @param m_strStatus
     */
    public void setM_strStatus(java.lang.String m_strStatus) {
        this.m_strStatus = m_strStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSOneTimePaymentQryOut)) return false;
        ObIdl_MBookSchemeDefSOneTimePaymentQryOut other = (ObIdl_MBookSchemeDefSOneTimePaymentQryOut) obj;
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
            ((this.m_llSegmentAmount==null && other.getM_llSegmentAmount()==null) || 
             (this.m_llSegmentAmount!=null &&
              this.m_llSegmentAmount.equals(other.getM_llSegmentAmount()))) &&
            ((this.m_llUncoveredAmount==null && other.getM_llUncoveredAmount()==null) || 
             (this.m_llUncoveredAmount!=null &&
              this.m_llUncoveredAmount.equals(other.getM_llUncoveredAmount()))) &&
            ((this.m_strStatus==null && other.getM_strStatus()==null) || 
             (this.m_strStatus!=null &&
              this.m_strStatus.equals(other.getM_strStatus())));
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
        if (getM_llSegmentAmount() != null) {
            _hashCode += getM_llSegmentAmount().hashCode();
        }
        if (getM_llUncoveredAmount() != null) {
            _hashCode += getM_llUncoveredAmount().hashCode();
        }
        if (getM_strStatus() != null) {
            _hashCode += getM_strStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSOneTimePaymentQryOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryOut"));
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
        elemField.setFieldName("m_llSegmentAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSegmentAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUncoveredAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUncoveredAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strStatus"));
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
