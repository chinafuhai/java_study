/**
 * ObIdl_MAccQuickQryFeeSQryDepositBookOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public class ObIdl_MAccQuickQryFeeSQryDepositBookOut  implements java.io.Serializable {
    private java.lang.String m_strDepositReason;

    private long m_llAmount;

    private java.lang.String m_strCreateDate;

    private java.lang.String m_strMemo;

    private java.lang.String m_strStatus;

    private java.lang.String m_strBankCard;

    private java.lang.String m_strBankRefundFlag;

    private java.lang.String m_strBankRefundFailReason;

    public ObIdl_MAccQuickQryFeeSQryDepositBookOut() {
    }

    public ObIdl_MAccQuickQryFeeSQryDepositBookOut(
           java.lang.String m_strDepositReason,
           long m_llAmount,
           java.lang.String m_strCreateDate,
           java.lang.String m_strMemo,
           java.lang.String m_strStatus,
           java.lang.String m_strBankCard,
           java.lang.String m_strBankRefundFlag,
           java.lang.String m_strBankRefundFailReason) {
           this.m_strDepositReason = m_strDepositReason;
           this.m_llAmount = m_llAmount;
           this.m_strCreateDate = m_strCreateDate;
           this.m_strMemo = m_strMemo;
           this.m_strStatus = m_strStatus;
           this.m_strBankCard = m_strBankCard;
           this.m_strBankRefundFlag = m_strBankRefundFlag;
           this.m_strBankRefundFailReason = m_strBankRefundFailReason;
    }


    /**
     * Gets the m_strDepositReason value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strDepositReason
     */
    public java.lang.String getM_strDepositReason() {
        return m_strDepositReason;
    }


    /**
     * Sets the m_strDepositReason value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strDepositReason
     */
    public void setM_strDepositReason(java.lang.String m_strDepositReason) {
        this.m_strDepositReason = m_strDepositReason;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_llAmount
     */
    public long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strCreateDate
     */
    public java.lang.String getM_strCreateDate() {
        return m_strCreateDate;
    }


    /**
     * Sets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strCreateDate
     */
    public void setM_strCreateDate(java.lang.String m_strCreateDate) {
        this.m_strCreateDate = m_strCreateDate;
    }


    /**
     * Gets the m_strMemo value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strMemo
     */
    public java.lang.String getM_strMemo() {
        return m_strMemo;
    }


    /**
     * Sets the m_strMemo value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strMemo
     */
    public void setM_strMemo(java.lang.String m_strMemo) {
        this.m_strMemo = m_strMemo;
    }


    /**
     * Gets the m_strStatus value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strStatus
     */
    public java.lang.String getM_strStatus() {
        return m_strStatus;
    }


    /**
     * Sets the m_strStatus value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strStatus
     */
    public void setM_strStatus(java.lang.String m_strStatus) {
        this.m_strStatus = m_strStatus;
    }


    /**
     * Gets the m_strBankCard value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strBankCard
     */
    public java.lang.String getM_strBankCard() {
        return m_strBankCard;
    }


    /**
     * Sets the m_strBankCard value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strBankCard
     */
    public void setM_strBankCard(java.lang.String m_strBankCard) {
        this.m_strBankCard = m_strBankCard;
    }


    /**
     * Gets the m_strBankRefundFlag value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strBankRefundFlag
     */
    public java.lang.String getM_strBankRefundFlag() {
        return m_strBankRefundFlag;
    }


    /**
     * Sets the m_strBankRefundFlag value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strBankRefundFlag
     */
    public void setM_strBankRefundFlag(java.lang.String m_strBankRefundFlag) {
        this.m_strBankRefundFlag = m_strBankRefundFlag;
    }


    /**
     * Gets the m_strBankRefundFailReason value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @return m_strBankRefundFailReason
     */
    public java.lang.String getM_strBankRefundFailReason() {
        return m_strBankRefundFailReason;
    }


    /**
     * Sets the m_strBankRefundFailReason value for this ObIdl_MAccQuickQryFeeSQryDepositBookOut.
     * 
     * @param m_strBankRefundFailReason
     */
    public void setM_strBankRefundFailReason(java.lang.String m_strBankRefundFailReason) {
        this.m_strBankRefundFailReason = m_strBankRefundFailReason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccQuickQryFeeSQryDepositBookOut)) return false;
        ObIdl_MAccQuickQryFeeSQryDepositBookOut other = (ObIdl_MAccQuickQryFeeSQryDepositBookOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strDepositReason==null && other.getM_strDepositReason()==null) || 
             (this.m_strDepositReason!=null &&
              this.m_strDepositReason.equals(other.getM_strDepositReason()))) &&
            this.m_llAmount == other.getM_llAmount() &&
            ((this.m_strCreateDate==null && other.getM_strCreateDate()==null) || 
             (this.m_strCreateDate!=null &&
              this.m_strCreateDate.equals(other.getM_strCreateDate()))) &&
            ((this.m_strMemo==null && other.getM_strMemo()==null) || 
             (this.m_strMemo!=null &&
              this.m_strMemo.equals(other.getM_strMemo()))) &&
            ((this.m_strStatus==null && other.getM_strStatus()==null) || 
             (this.m_strStatus!=null &&
              this.m_strStatus.equals(other.getM_strStatus()))) &&
            ((this.m_strBankCard==null && other.getM_strBankCard()==null) || 
             (this.m_strBankCard!=null &&
              this.m_strBankCard.equals(other.getM_strBankCard()))) &&
            ((this.m_strBankRefundFlag==null && other.getM_strBankRefundFlag()==null) || 
             (this.m_strBankRefundFlag!=null &&
              this.m_strBankRefundFlag.equals(other.getM_strBankRefundFlag()))) &&
            ((this.m_strBankRefundFailReason==null && other.getM_strBankRefundFailReason()==null) || 
             (this.m_strBankRefundFailReason!=null &&
              this.m_strBankRefundFailReason.equals(other.getM_strBankRefundFailReason())));
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
        if (getM_strDepositReason() != null) {
            _hashCode += getM_strDepositReason().hashCode();
        }
        _hashCode += new Long(getM_llAmount()).hashCode();
        if (getM_strCreateDate() != null) {
            _hashCode += getM_strCreateDate().hashCode();
        }
        if (getM_strMemo() != null) {
            _hashCode += getM_strMemo().hashCode();
        }
        if (getM_strStatus() != null) {
            _hashCode += getM_strStatus().hashCode();
        }
        if (getM_strBankCard() != null) {
            _hashCode += getM_strBankCard().hashCode();
        }
        if (getM_strBankRefundFlag() != null) {
            _hashCode += getM_strBankRefundFlag().hashCode();
        }
        if (getM_strBankRefundFailReason() != null) {
            _hashCode += getM_strBankRefundFailReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccQuickQryFeeSQryDepositBookOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strDepositReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strDepositReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCreateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCreateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMemo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankCard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankRefundFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankRefundFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankRefundFailReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankRefundFailReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
