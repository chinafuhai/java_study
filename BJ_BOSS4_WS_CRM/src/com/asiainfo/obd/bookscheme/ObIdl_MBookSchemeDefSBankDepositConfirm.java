/**
 * ObIdl_MBookSchemeDefSBankDepositConfirm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSBankDepositConfirm  implements java.io.Serializable {
    private java.lang.Long m_llSoNbr;

    private java.lang.Long m_llAcctId;

    private java.lang.Long m_llFeeTotal;

    private java.lang.String m_strBankCode;

    private java.lang.String m_strBankCard;

    private java.lang.String m_strBankCardName;

    private java.lang.String m_strAcctName;

    public ObIdl_MBookSchemeDefSBankDepositConfirm() {
    }

    public ObIdl_MBookSchemeDefSBankDepositConfirm(
           java.lang.Long m_llSoNbr,
           java.lang.Long m_llAcctId,
           java.lang.Long m_llFeeTotal,
           java.lang.String m_strBankCode,
           java.lang.String m_strBankCard,
           java.lang.String m_strBankCardName,
           java.lang.String m_strAcctName) {
           this.m_llSoNbr = m_llSoNbr;
           this.m_llAcctId = m_llAcctId;
           this.m_llFeeTotal = m_llFeeTotal;
           this.m_strBankCode = m_strBankCode;
           this.m_strBankCard = m_strBankCard;
           this.m_strBankCardName = m_strBankCardName;
           this.m_strAcctName = m_strAcctName;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_llFeeTotal value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_llFeeTotal
     */
    public java.lang.Long getM_llFeeTotal() {
        return m_llFeeTotal;
    }


    /**
     * Sets the m_llFeeTotal value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_llFeeTotal
     */
    public void setM_llFeeTotal(java.lang.Long m_llFeeTotal) {
        this.m_llFeeTotal = m_llFeeTotal;
    }


    /**
     * Gets the m_strBankCode value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_strBankCode
     */
    public java.lang.String getM_strBankCode() {
        return m_strBankCode;
    }


    /**
     * Sets the m_strBankCode value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_strBankCode
     */
    public void setM_strBankCode(java.lang.String m_strBankCode) {
        this.m_strBankCode = m_strBankCode;
    }


    /**
     * Gets the m_strBankCard value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_strBankCard
     */
    public java.lang.String getM_strBankCard() {
        return m_strBankCard;
    }


    /**
     * Sets the m_strBankCard value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_strBankCard
     */
    public void setM_strBankCard(java.lang.String m_strBankCard) {
        this.m_strBankCard = m_strBankCard;
    }


    /**
     * Gets the m_strBankCardName value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_strBankCardName
     */
    public java.lang.String getM_strBankCardName() {
        return m_strBankCardName;
    }


    /**
     * Sets the m_strBankCardName value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_strBankCardName
     */
    public void setM_strBankCardName(java.lang.String m_strBankCardName) {
        this.m_strBankCardName = m_strBankCardName;
    }


    /**
     * Gets the m_strAcctName value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @return m_strAcctName
     */
    public java.lang.String getM_strAcctName() {
        return m_strAcctName;
    }


    /**
     * Sets the m_strAcctName value for this ObIdl_MBookSchemeDefSBankDepositConfirm.
     * 
     * @param m_strAcctName
     */
    public void setM_strAcctName(java.lang.String m_strAcctName) {
        this.m_strAcctName = m_strAcctName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSBankDepositConfirm)) return false;
        ObIdl_MBookSchemeDefSBankDepositConfirm other = (ObIdl_MBookSchemeDefSBankDepositConfirm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llSoNbr==null && other.getM_llSoNbr()==null) || 
             (this.m_llSoNbr!=null &&
              this.m_llSoNbr.equals(other.getM_llSoNbr()))) &&
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_llFeeTotal==null && other.getM_llFeeTotal()==null) || 
             (this.m_llFeeTotal!=null &&
              this.m_llFeeTotal.equals(other.getM_llFeeTotal()))) &&
            ((this.m_strBankCode==null && other.getM_strBankCode()==null) || 
             (this.m_strBankCode!=null &&
              this.m_strBankCode.equals(other.getM_strBankCode()))) &&
            ((this.m_strBankCard==null && other.getM_strBankCard()==null) || 
             (this.m_strBankCard!=null &&
              this.m_strBankCard.equals(other.getM_strBankCard()))) &&
            ((this.m_strBankCardName==null && other.getM_strBankCardName()==null) || 
             (this.m_strBankCardName!=null &&
              this.m_strBankCardName.equals(other.getM_strBankCardName()))) &&
            ((this.m_strAcctName==null && other.getM_strAcctName()==null) || 
             (this.m_strAcctName!=null &&
              this.m_strAcctName.equals(other.getM_strAcctName())));
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
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_llFeeTotal() != null) {
            _hashCode += getM_llFeeTotal().hashCode();
        }
        if (getM_strBankCode() != null) {
            _hashCode += getM_strBankCode().hashCode();
        }
        if (getM_strBankCard() != null) {
            _hashCode += getM_strBankCard().hashCode();
        }
        if (getM_strBankCardName() != null) {
            _hashCode += getM_strBankCardName().hashCode();
        }
        if (getM_strAcctName() != null) {
            _hashCode += getM_strAcctName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSBankDepositConfirm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llFeeTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llFeeTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankCard");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankCardName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankCardName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strAcctName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strAcctName"));
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
