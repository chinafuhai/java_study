/**
 * ObIdl_MBookSchemeDefSSchemePaymentQryIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSSchemePaymentQryIn  implements java.io.Serializable {
    private java.lang.String m_strPhoneId;

    private java.lang.Short m_nCacelledFlag;

    private java.lang.String m_dtmBeginDate;

    private java.lang.String m_dtmEndDate;

    public ObIdl_MBookSchemeDefSSchemePaymentQryIn() {
    }

    public ObIdl_MBookSchemeDefSSchemePaymentQryIn(
           java.lang.String m_strPhoneId,
           java.lang.Short m_nCacelledFlag,
           java.lang.String m_dtmBeginDate,
           java.lang.String m_dtmEndDate) {
           this.m_strPhoneId = m_strPhoneId;
           this.m_nCacelledFlag = m_nCacelledFlag;
           this.m_dtmBeginDate = m_dtmBeginDate;
           this.m_dtmEndDate = m_dtmEndDate;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_nCacelledFlag value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @return m_nCacelledFlag
     */
    public java.lang.Short getM_nCacelledFlag() {
        return m_nCacelledFlag;
    }


    /**
     * Sets the m_nCacelledFlag value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @param m_nCacelledFlag
     */
    public void setM_nCacelledFlag(java.lang.Short m_nCacelledFlag) {
        this.m_nCacelledFlag = m_nCacelledFlag;
    }


    /**
     * Gets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @return m_dtmBeginDate
     */
    public java.lang.String getM_dtmBeginDate() {
        return m_dtmBeginDate;
    }


    /**
     * Sets the m_dtmBeginDate value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @param m_dtmBeginDate
     */
    public void setM_dtmBeginDate(java.lang.String m_dtmBeginDate) {
        this.m_dtmBeginDate = m_dtmBeginDate;
    }


    /**
     * Gets the m_dtmEndDate value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @return m_dtmEndDate
     */
    public java.lang.String getM_dtmEndDate() {
        return m_dtmEndDate;
    }


    /**
     * Sets the m_dtmEndDate value for this ObIdl_MBookSchemeDefSSchemePaymentQryIn.
     * 
     * @param m_dtmEndDate
     */
    public void setM_dtmEndDate(java.lang.String m_dtmEndDate) {
        this.m_dtmEndDate = m_dtmEndDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSSchemePaymentQryIn)) return false;
        ObIdl_MBookSchemeDefSSchemePaymentQryIn other = (ObIdl_MBookSchemeDefSSchemePaymentQryIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_nCacelledFlag==null && other.getM_nCacelledFlag()==null) || 
             (this.m_nCacelledFlag!=null &&
              this.m_nCacelledFlag.equals(other.getM_nCacelledFlag()))) &&
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
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_nCacelledFlag() != null) {
            _hashCode += getM_nCacelledFlag().hashCode();
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
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSSchemePaymentQryIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nCacelledFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nCacelledFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
