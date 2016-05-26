/**
 * ObIdl_MAccCommonSSimplePayFeeOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSSimplePayFeeOut  implements java.io.Serializable {
    private java.lang.Long m_llPaySoNbr;

    private java.lang.Long m_llBalance;

    private java.lang.String m_strPayHint;

    public ObIdl_MAccCommonSSimplePayFeeOut() {
    }

    public ObIdl_MAccCommonSSimplePayFeeOut(
           java.lang.Long m_llPaySoNbr,
           java.lang.Long m_llBalance,
           java.lang.String m_strPayHint) {
           this.m_llPaySoNbr = m_llPaySoNbr;
           this.m_llBalance = m_llBalance;
           this.m_strPayHint = m_strPayHint;
    }


    /**
     * Gets the m_llPaySoNbr value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @return m_llPaySoNbr
     */
    public java.lang.Long getM_llPaySoNbr() {
        return m_llPaySoNbr;
    }


    /**
     * Sets the m_llPaySoNbr value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @param m_llPaySoNbr
     */
    public void setM_llPaySoNbr(java.lang.Long m_llPaySoNbr) {
        this.m_llPaySoNbr = m_llPaySoNbr;
    }


    /**
     * Gets the m_llBalance value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @return m_llBalance
     */
    public java.lang.Long getM_llBalance() {
        return m_llBalance;
    }


    /**
     * Sets the m_llBalance value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @param m_llBalance
     */
    public void setM_llBalance(java.lang.Long m_llBalance) {
        this.m_llBalance = m_llBalance;
    }


    /**
     * Gets the m_strPayHint value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @return m_strPayHint
     */
    public java.lang.String getM_strPayHint() {
        return m_strPayHint;
    }


    /**
     * Sets the m_strPayHint value for this ObIdl_MAccCommonSSimplePayFeeOut.
     * 
     * @param m_strPayHint
     */
    public void setM_strPayHint(java.lang.String m_strPayHint) {
        this.m_strPayHint = m_strPayHint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSSimplePayFeeOut)) return false;
        ObIdl_MAccCommonSSimplePayFeeOut other = (ObIdl_MAccCommonSSimplePayFeeOut) obj;
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
            ((this.m_strPayHint==null && other.getM_strPayHint()==null) || 
             (this.m_strPayHint!=null &&
              this.m_strPayHint.equals(other.getM_strPayHint())));
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
        if (getM_strPayHint() != null) {
            _hashCode += getM_strPayHint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSSimplePayFeeOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeOut"));
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
        elemField.setFieldName("m_strPayHint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPayHint"));
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
