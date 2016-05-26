/**
 * ObIdl_MAccCommonSBankPayFeeOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSBankPayFeeOut  implements java.io.Serializable {
    private java.lang.Long m_llPaySoNbr;

    private java.lang.Long m_llBalance;

    private java.lang.String m_strCustId;

    private java.lang.String m_strCustName;

    private java.lang.String m_strErrorCode;

    public ObIdl_MAccCommonSBankPayFeeOut() {
    }

    public ObIdl_MAccCommonSBankPayFeeOut(
           java.lang.Long m_llPaySoNbr,
           java.lang.Long m_llBalance,
           java.lang.String m_strCustId,
           java.lang.String m_strCustName,
           java.lang.String m_strErrorCode) {
           this.m_llPaySoNbr = m_llPaySoNbr;
           this.m_llBalance = m_llBalance;
           this.m_strCustId = m_strCustId;
           this.m_strCustName = m_strCustName;
           this.m_strErrorCode = m_strErrorCode;
    }


    /**
     * Gets the m_llPaySoNbr value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @return m_llPaySoNbr
     */
    public java.lang.Long getM_llPaySoNbr() {
        return m_llPaySoNbr;
    }


    /**
     * Sets the m_llPaySoNbr value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @param m_llPaySoNbr
     */
    public void setM_llPaySoNbr(java.lang.Long m_llPaySoNbr) {
        this.m_llPaySoNbr = m_llPaySoNbr;
    }


    /**
     * Gets the m_llBalance value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @return m_llBalance
     */
    public java.lang.Long getM_llBalance() {
        return m_llBalance;
    }


    /**
     * Sets the m_llBalance value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @param m_llBalance
     */
    public void setM_llBalance(java.lang.Long m_llBalance) {
        this.m_llBalance = m_llBalance;
    }


    /**
     * Gets the m_strCustId value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @return m_strCustId
     */
    public java.lang.String getM_strCustId() {
        return m_strCustId;
    }


    /**
     * Sets the m_strCustId value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @param m_strCustId
     */
    public void setM_strCustId(java.lang.String m_strCustId) {
        this.m_strCustId = m_strCustId;
    }


    /**
     * Gets the m_strCustName value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @return m_strCustName
     */
    public java.lang.String getM_strCustName() {
        return m_strCustName;
    }


    /**
     * Sets the m_strCustName value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @param m_strCustName
     */
    public void setM_strCustName(java.lang.String m_strCustName) {
        this.m_strCustName = m_strCustName;
    }


    /**
     * Gets the m_strErrorCode value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @return m_strErrorCode
     */
    public java.lang.String getM_strErrorCode() {
        return m_strErrorCode;
    }


    /**
     * Sets the m_strErrorCode value for this ObIdl_MAccCommonSBankPayFeeOut.
     * 
     * @param m_strErrorCode
     */
    public void setM_strErrorCode(java.lang.String m_strErrorCode) {
        this.m_strErrorCode = m_strErrorCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSBankPayFeeOut)) return false;
        ObIdl_MAccCommonSBankPayFeeOut other = (ObIdl_MAccCommonSBankPayFeeOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llPaySoNbr==null && other.getM_llPaySoNbr()==null) || 
             (this.m_llPaySoNbr!=null &&
              this.m_llPaySoNbr.equals(other.getM_llPaySoNbr()))) &&
            ((this.m_llBalance==null && other.getM_llBalance()==null) || 
             (this.m_llBalance!=null &&
              this.m_llBalance.equals(other.getM_llBalance()))) &&
            ((this.m_strCustId==null && other.getM_strCustId()==null) || 
             (this.m_strCustId!=null &&
              this.m_strCustId.equals(other.getM_strCustId()))) &&
            ((this.m_strCustName==null && other.getM_strCustName()==null) || 
             (this.m_strCustName!=null &&
              this.m_strCustName.equals(other.getM_strCustName()))) &&
            ((this.m_strErrorCode==null && other.getM_strErrorCode()==null) || 
             (this.m_strErrorCode!=null &&
              this.m_strErrorCode.equals(other.getM_strErrorCode())));
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
        if (getM_llPaySoNbr() != null) {
            _hashCode += getM_llPaySoNbr().hashCode();
        }
        if (getM_llBalance() != null) {
            _hashCode += getM_llBalance().hashCode();
        }
        if (getM_strCustId() != null) {
            _hashCode += getM_strCustId().hashCode();
        }
        if (getM_strCustName() != null) {
            _hashCode += getM_strCustName().hashCode();
        }
        if (getM_strErrorCode() != null) {
            _hashCode += getM_strErrorCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSBankPayFeeOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBankPayFeeOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPaySoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPaySoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCustId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCustName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strErrorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strErrorCode"));
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
