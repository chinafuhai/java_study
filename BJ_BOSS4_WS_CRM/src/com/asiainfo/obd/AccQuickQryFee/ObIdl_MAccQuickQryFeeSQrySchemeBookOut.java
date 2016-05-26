/**
 * ObIdl_MAccQuickQryFeeSQrySchemeBookOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccQuickQryFee;

public class ObIdl_MAccQuickQryFeeSQrySchemeBookOut  implements java.io.Serializable {
    private java.lang.String m_strPaymentType;

    private java.lang.Long m_llTotalAmount;

    private java.lang.String m_strCreateDate;

    private java.lang.String m_strMemo;

    private java.lang.Long m_llRemainAmount;

    private java.lang.String m_strStatus;

    private java.lang.String m_strCrmSapInstanceId;

    public ObIdl_MAccQuickQryFeeSQrySchemeBookOut() {
    }

    public ObIdl_MAccQuickQryFeeSQrySchemeBookOut(
           java.lang.String m_strPaymentType,
           java.lang.Long m_llTotalAmount,
           java.lang.String m_strCreateDate,
           java.lang.String m_strMemo,
           java.lang.Long m_llRemainAmount,
           java.lang.String m_strStatus,
           java.lang.String m_strCrmSapInstanceId) {
           this.m_strPaymentType = m_strPaymentType;
           this.m_llTotalAmount = m_llTotalAmount;
           this.m_strCreateDate = m_strCreateDate;
           this.m_strMemo = m_strMemo;
           this.m_llRemainAmount = m_llRemainAmount;
           this.m_strStatus = m_strStatus;
           this.m_strCrmSapInstanceId = m_strCrmSapInstanceId;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_llTotalAmount value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_llTotalAmount
     */
    public java.lang.Long getM_llTotalAmount() {
        return m_llTotalAmount;
    }


    /**
     * Sets the m_llTotalAmount value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_llTotalAmount
     */
    public void setM_llTotalAmount(java.lang.Long m_llTotalAmount) {
        this.m_llTotalAmount = m_llTotalAmount;
    }


    /**
     * Gets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_strCreateDate
     */
    public java.lang.String getM_strCreateDate() {
        return m_strCreateDate;
    }


    /**
     * Sets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_strCreateDate
     */
    public void setM_strCreateDate(java.lang.String m_strCreateDate) {
        this.m_strCreateDate = m_strCreateDate;
    }


    /**
     * Gets the m_strMemo value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_strMemo
     */
    public java.lang.String getM_strMemo() {
        return m_strMemo;
    }


    /**
     * Sets the m_strMemo value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_strMemo
     */
    public void setM_strMemo(java.lang.String m_strMemo) {
        this.m_strMemo = m_strMemo;
    }


    /**
     * Gets the m_llRemainAmount value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_llRemainAmount
     */
    public java.lang.Long getM_llRemainAmount() {
        return m_llRemainAmount;
    }


    /**
     * Sets the m_llRemainAmount value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_llRemainAmount
     */
    public void setM_llRemainAmount(java.lang.Long m_llRemainAmount) {
        this.m_llRemainAmount = m_llRemainAmount;
    }


    /**
     * Gets the m_strStatus value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_strStatus
     */
    public java.lang.String getM_strStatus() {
        return m_strStatus;
    }


    /**
     * Sets the m_strStatus value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_strStatus
     */
    public void setM_strStatus(java.lang.String m_strStatus) {
        this.m_strStatus = m_strStatus;
    }


    /**
     * Gets the m_strCrmSapInstanceId value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @return m_strCrmSapInstanceId
     */
    public java.lang.String getM_strCrmSapInstanceId() {
        return m_strCrmSapInstanceId;
    }


    /**
     * Sets the m_strCrmSapInstanceId value for this ObIdl_MAccQuickQryFeeSQrySchemeBookOut.
     * 
     * @param m_strCrmSapInstanceId
     */
    public void setM_strCrmSapInstanceId(java.lang.String m_strCrmSapInstanceId) {
        this.m_strCrmSapInstanceId = m_strCrmSapInstanceId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccQuickQryFeeSQrySchemeBookOut)) return false;
        ObIdl_MAccQuickQryFeeSQrySchemeBookOut other = (ObIdl_MAccQuickQryFeeSQrySchemeBookOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strPaymentType==null && other.getM_strPaymentType()==null) || 
             (this.m_strPaymentType!=null &&
              this.m_strPaymentType.equals(other.getM_strPaymentType()))) &&
            ((this.m_llTotalAmount==null && other.getM_llTotalAmount()==null) || 
             (this.m_llTotalAmount!=null &&
              this.m_llTotalAmount.equals(other.getM_llTotalAmount()))) &&
            ((this.m_strCreateDate==null && other.getM_strCreateDate()==null) || 
             (this.m_strCreateDate!=null &&
              this.m_strCreateDate.equals(other.getM_strCreateDate()))) &&
            ((this.m_strMemo==null && other.getM_strMemo()==null) || 
             (this.m_strMemo!=null &&
              this.m_strMemo.equals(other.getM_strMemo()))) &&
            ((this.m_llRemainAmount==null && other.getM_llRemainAmount()==null) || 
             (this.m_llRemainAmount!=null &&
              this.m_llRemainAmount.equals(other.getM_llRemainAmount()))) &&
            ((this.m_strStatus==null && other.getM_strStatus()==null) || 
             (this.m_strStatus!=null &&
              this.m_strStatus.equals(other.getM_strStatus()))) &&
            ((this.m_strCrmSapInstanceId==null && other.getM_strCrmSapInstanceId()==null) || 
             (this.m_strCrmSapInstanceId!=null &&
              this.m_strCrmSapInstanceId.equals(other.getM_strCrmSapInstanceId())));
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
        if (getM_strPaymentType() != null) {
            _hashCode += getM_strPaymentType().hashCode();
        }
        if (getM_llTotalAmount() != null) {
            _hashCode += getM_llTotalAmount().hashCode();
        }
        if (getM_strCreateDate() != null) {
            _hashCode += getM_strCreateDate().hashCode();
        }
        if (getM_strMemo() != null) {
            _hashCode += getM_strMemo().hashCode();
        }
        if (getM_llRemainAmount() != null) {
            _hashCode += getM_llRemainAmount().hashCode();
        }
        if (getM_strStatus() != null) {
            _hashCode += getM_strStatus().hashCode();
        }
        if (getM_strCrmSapInstanceId() != null) {
            _hashCode += getM_strCrmSapInstanceId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccQuickQryFeeSQrySchemeBookOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCreateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCreateDate"));
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
        elemField.setFieldName("m_llRemainAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRemainAmount"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCrmSapInstanceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCrmSapInstanceId"));
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
