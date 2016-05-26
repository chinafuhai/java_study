/**
 * ObIdl_MBookSchemeDefSSegmentFund.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSSegmentFund  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.String m_strExtCustomerId;

    private java.lang.String m_strPaymentTransactionId;

    private java.lang.String m_strResourceNumber;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListPayment;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListRefund;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListUpdate;

    public ObIdl_MBookSchemeDefSSegmentFund() {
    }

    public ObIdl_MBookSchemeDefSSegmentFund(
           java.lang.Long m_llAcctId,
           java.lang.String m_strExtCustomerId,
           java.lang.String m_strPaymentTransactionId,
           java.lang.String m_strResourceNumber,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListPayment,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListRefund,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListUpdate) {
           this.m_llAcctId = m_llAcctId;
           this.m_strExtCustomerId = m_strExtCustomerId;
           this.m_strPaymentTransactionId = m_strPaymentTransactionId;
           this.m_strResourceNumber = m_strResourceNumber;
           this.m_listListPayment = m_listListPayment;
           this.m_listListRefund = m_listListRefund;
           this.m_listListUpdate = m_listListUpdate;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_strExtCustomerId
     */
    public java.lang.String getM_strExtCustomerId() {
        return m_strExtCustomerId;
    }


    /**
     * Sets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_strExtCustomerId
     */
    public void setM_strExtCustomerId(java.lang.String m_strExtCustomerId) {
        this.m_strExtCustomerId = m_strExtCustomerId;
    }


    /**
     * Gets the m_strPaymentTransactionId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_strPaymentTransactionId
     */
    public java.lang.String getM_strPaymentTransactionId() {
        return m_strPaymentTransactionId;
    }


    /**
     * Sets the m_strPaymentTransactionId value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_strPaymentTransactionId
     */
    public void setM_strPaymentTransactionId(java.lang.String m_strPaymentTransactionId) {
        this.m_strPaymentTransactionId = m_strPaymentTransactionId;
    }


    /**
     * Gets the m_strResourceNumber value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_strResourceNumber
     */
    public java.lang.String getM_strResourceNumber() {
        return m_strResourceNumber;
    }


    /**
     * Sets the m_strResourceNumber value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_strResourceNumber
     */
    public void setM_strResourceNumber(java.lang.String m_strResourceNumber) {
        this.m_strResourceNumber = m_strResourceNumber;
    }


    /**
     * Gets the m_listListPayment value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_listListPayment
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] getM_listListPayment() {
        return m_listListPayment;
    }


    /**
     * Sets the m_listListPayment value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_listListPayment
     */
    public void setM_listListPayment(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListPayment) {
        this.m_listListPayment = m_listListPayment;
    }


    /**
     * Gets the m_listListRefund value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_listListRefund
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] getM_listListRefund() {
        return m_listListRefund;
    }


    /**
     * Sets the m_listListRefund value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_listListRefund
     */
    public void setM_listListRefund(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListRefund) {
        this.m_listListRefund = m_listListRefund;
    }


    /**
     * Gets the m_listListUpdate value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @return m_listListUpdate
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] getM_listListUpdate() {
        return m_listListUpdate;
    }


    /**
     * Sets the m_listListUpdate value for this ObIdl_MBookSchemeDefSSegmentFund.
     * 
     * @param m_listListUpdate
     */
    public void setM_listListUpdate(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[] m_listListUpdate) {
        this.m_listListUpdate = m_listListUpdate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSSegmentFund)) return false;
        ObIdl_MBookSchemeDefSSegmentFund other = (ObIdl_MBookSchemeDefSSegmentFund) obj;
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
            ((this.m_strExtCustomerId==null && other.getM_strExtCustomerId()==null) || 
             (this.m_strExtCustomerId!=null &&
              this.m_strExtCustomerId.equals(other.getM_strExtCustomerId()))) &&
            ((this.m_strPaymentTransactionId==null && other.getM_strPaymentTransactionId()==null) || 
             (this.m_strPaymentTransactionId!=null &&
              this.m_strPaymentTransactionId.equals(other.getM_strPaymentTransactionId()))) &&
            ((this.m_strResourceNumber==null && other.getM_strResourceNumber()==null) || 
             (this.m_strResourceNumber!=null &&
              this.m_strResourceNumber.equals(other.getM_strResourceNumber()))) &&
            ((this.m_listListPayment==null && other.getM_listListPayment()==null) || 
             (this.m_listListPayment!=null &&
              java.util.Arrays.equals(this.m_listListPayment, other.getM_listListPayment()))) &&
            ((this.m_listListRefund==null && other.getM_listListRefund()==null) || 
             (this.m_listListRefund!=null &&
              java.util.Arrays.equals(this.m_listListRefund, other.getM_listListRefund()))) &&
            ((this.m_listListUpdate==null && other.getM_listListUpdate()==null) || 
             (this.m_listListUpdate!=null &&
              java.util.Arrays.equals(this.m_listListUpdate, other.getM_listListUpdate())));
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
        if (getM_strExtCustomerId() != null) {
            _hashCode += getM_strExtCustomerId().hashCode();
        }
        if (getM_strPaymentTransactionId() != null) {
            _hashCode += getM_strPaymentTransactionId().hashCode();
        }
        if (getM_strResourceNumber() != null) {
            _hashCode += getM_strResourceNumber().hashCode();
        }
        if (getM_listListPayment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListPayment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListPayment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listListRefund() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListRefund());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListRefund(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listListUpdate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListUpdate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListUpdate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSSegmentFund.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentFund"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("m_strPaymentTransactionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentTransactionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strResourceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strResourceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListRefund");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListRefund"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
