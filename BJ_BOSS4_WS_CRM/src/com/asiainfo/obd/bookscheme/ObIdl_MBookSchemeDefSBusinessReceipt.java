/**
 * ObIdl_MBookSchemeDefSBusinessReceipt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSBusinessReceipt  implements java.io.Serializable {
    private java.lang.Long m_llAccountId;

    private java.lang.String m_strExtCustomerId;

    private java.lang.String m_strResourceNumber;

    private java.lang.String m_strMemo;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] m_listListReceiptItem;

    private java.lang.String m_strReceiptTransactionId;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo m_sReceiptServInfo;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod m_sPaymentMethod;

    private java.lang.String m_strPayChannel;

    public ObIdl_MBookSchemeDefSBusinessReceipt() {
    }

    public ObIdl_MBookSchemeDefSBusinessReceipt(
           java.lang.Long m_llAccountId,
           java.lang.String m_strExtCustomerId,
           java.lang.String m_strResourceNumber,
           java.lang.String m_strMemo,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] m_listListReceiptItem,
           java.lang.String m_strReceiptTransactionId,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo m_sReceiptServInfo,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod m_sPaymentMethod,
           java.lang.String m_strPayChannel) {
           this.m_llAccountId = m_llAccountId;
           this.m_strExtCustomerId = m_strExtCustomerId;
           this.m_strResourceNumber = m_strResourceNumber;
           this.m_strMemo = m_strMemo;
           this.m_listListReceiptItem = m_listListReceiptItem;
           this.m_strReceiptTransactionId = m_strReceiptTransactionId;
           this.m_sReceiptServInfo = m_sReceiptServInfo;
           this.m_sPaymentMethod = m_sPaymentMethod;
           this.m_strPayChannel = m_strPayChannel;
    }


    /**
     * Gets the m_llAccountId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_llAccountId
     */
    public java.lang.Long getM_llAccountId() {
        return m_llAccountId;
    }


    /**
     * Sets the m_llAccountId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_llAccountId
     */
    public void setM_llAccountId(java.lang.Long m_llAccountId) {
        this.m_llAccountId = m_llAccountId;
    }


    /**
     * Gets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_strExtCustomerId
     */
    public java.lang.String getM_strExtCustomerId() {
        return m_strExtCustomerId;
    }


    /**
     * Sets the m_strExtCustomerId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_strExtCustomerId
     */
    public void setM_strExtCustomerId(java.lang.String m_strExtCustomerId) {
        this.m_strExtCustomerId = m_strExtCustomerId;
    }


    /**
     * Gets the m_strResourceNumber value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_strResourceNumber
     */
    public java.lang.String getM_strResourceNumber() {
        return m_strResourceNumber;
    }


    /**
     * Sets the m_strResourceNumber value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_strResourceNumber
     */
    public void setM_strResourceNumber(java.lang.String m_strResourceNumber) {
        this.m_strResourceNumber = m_strResourceNumber;
    }


    /**
     * Gets the m_strMemo value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_strMemo
     */
    public java.lang.String getM_strMemo() {
        return m_strMemo;
    }


    /**
     * Sets the m_strMemo value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_strMemo
     */
    public void setM_strMemo(java.lang.String m_strMemo) {
        this.m_strMemo = m_strMemo;
    }


    /**
     * Gets the m_listListReceiptItem value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_listListReceiptItem
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] getM_listListReceiptItem() {
        return m_listListReceiptItem;
    }


    /**
     * Sets the m_listListReceiptItem value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_listListReceiptItem
     */
    public void setM_listListReceiptItem(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[] m_listListReceiptItem) {
        this.m_listListReceiptItem = m_listListReceiptItem;
    }


    /**
     * Gets the m_strReceiptTransactionId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_strReceiptTransactionId
     */
    public java.lang.String getM_strReceiptTransactionId() {
        return m_strReceiptTransactionId;
    }


    /**
     * Sets the m_strReceiptTransactionId value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_strReceiptTransactionId
     */
    public void setM_strReceiptTransactionId(java.lang.String m_strReceiptTransactionId) {
        this.m_strReceiptTransactionId = m_strReceiptTransactionId;
    }


    /**
     * Gets the m_sReceiptServInfo value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_sReceiptServInfo
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo getM_sReceiptServInfo() {
        return m_sReceiptServInfo;
    }


    /**
     * Sets the m_sReceiptServInfo value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_sReceiptServInfo
     */
    public void setM_sReceiptServInfo(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo m_sReceiptServInfo) {
        this.m_sReceiptServInfo = m_sReceiptServInfo;
    }


    /**
     * Gets the m_sPaymentMethod value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_sPaymentMethod
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod getM_sPaymentMethod() {
        return m_sPaymentMethod;
    }


    /**
     * Sets the m_sPaymentMethod value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_sPaymentMethod
     */
    public void setM_sPaymentMethod(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod m_sPaymentMethod) {
        this.m_sPaymentMethod = m_sPaymentMethod;
    }


    /**
     * Gets the m_strPayChannel value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @return m_strPayChannel
     */
    public java.lang.String getM_strPayChannel() {
        return m_strPayChannel;
    }


    /**
     * Sets the m_strPayChannel value for this ObIdl_MBookSchemeDefSBusinessReceipt.
     * 
     * @param m_strPayChannel
     */
    public void setM_strPayChannel(java.lang.String m_strPayChannel) {
        this.m_strPayChannel = m_strPayChannel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSBusinessReceipt)) return false;
        ObIdl_MBookSchemeDefSBusinessReceipt other = (ObIdl_MBookSchemeDefSBusinessReceipt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llAccountId==null && other.getM_llAccountId()==null) || 
             (this.m_llAccountId!=null &&
              this.m_llAccountId.equals(other.getM_llAccountId()))) &&
            ((this.m_strExtCustomerId==null && other.getM_strExtCustomerId()==null) || 
             (this.m_strExtCustomerId!=null &&
              this.m_strExtCustomerId.equals(other.getM_strExtCustomerId()))) &&
            ((this.m_strResourceNumber==null && other.getM_strResourceNumber()==null) || 
             (this.m_strResourceNumber!=null &&
              this.m_strResourceNumber.equals(other.getM_strResourceNumber()))) &&
            ((this.m_strMemo==null && other.getM_strMemo()==null) || 
             (this.m_strMemo!=null &&
              this.m_strMemo.equals(other.getM_strMemo()))) &&
            ((this.m_listListReceiptItem==null && other.getM_listListReceiptItem()==null) || 
             (this.m_listListReceiptItem!=null &&
              java.util.Arrays.equals(this.m_listListReceiptItem, other.getM_listListReceiptItem()))) &&
            ((this.m_strReceiptTransactionId==null && other.getM_strReceiptTransactionId()==null) || 
             (this.m_strReceiptTransactionId!=null &&
              this.m_strReceiptTransactionId.equals(other.getM_strReceiptTransactionId()))) &&
            ((this.m_sReceiptServInfo==null && other.getM_sReceiptServInfo()==null) || 
             (this.m_sReceiptServInfo!=null &&
              this.m_sReceiptServInfo.equals(other.getM_sReceiptServInfo()))) &&
            ((this.m_sPaymentMethod==null && other.getM_sPaymentMethod()==null) || 
             (this.m_sPaymentMethod!=null &&
              this.m_sPaymentMethod.equals(other.getM_sPaymentMethod()))) &&
            ((this.m_strPayChannel==null && other.getM_strPayChannel()==null) || 
             (this.m_strPayChannel!=null &&
              this.m_strPayChannel.equals(other.getM_strPayChannel())));
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
        if (getM_llAccountId() != null) {
            _hashCode += getM_llAccountId().hashCode();
        }
        if (getM_strExtCustomerId() != null) {
            _hashCode += getM_strExtCustomerId().hashCode();
        }
        if (getM_strResourceNumber() != null) {
            _hashCode += getM_strResourceNumber().hashCode();
        }
        if (getM_strMemo() != null) {
            _hashCode += getM_strMemo().hashCode();
        }
        if (getM_listListReceiptItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListReceiptItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListReceiptItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_strReceiptTransactionId() != null) {
            _hashCode += getM_strReceiptTransactionId().hashCode();
        }
        if (getM_sReceiptServInfo() != null) {
            _hashCode += getM_sReceiptServInfo().hashCode();
        }
        if (getM_sPaymentMethod() != null) {
            _hashCode += getM_sPaymentMethod().hashCode();
        }
        if (getM_strPayChannel() != null) {
            _hashCode += getM_strPayChannel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSBusinessReceipt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBusinessReceipt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAccountId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAccountId"));
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
        elemField.setFieldName("m_strResourceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strResourceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListReceiptItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListReceiptItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimeReceiptItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReceiptTransactionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReceiptTransactionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_sReceiptServInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_sReceiptServInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SReceiptServInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_sPaymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_sPaymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentPayMethod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPayChannel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPayChannel"));
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
