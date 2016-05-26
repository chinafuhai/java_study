/**
 * ObIdl_MBookSchemeDefSSchemePaymentQryOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSSchemePaymentQryOut  implements java.io.Serializable {
    private java.lang.String m_strBonusType;

    private java.lang.String m_strBonusDesc;

    private java.lang.Long m_llBonusAmt;

    public ObIdl_MBookSchemeDefSSchemePaymentQryOut() {
    }

    public ObIdl_MBookSchemeDefSSchemePaymentQryOut(
           java.lang.String m_strBonusType,
           java.lang.String m_strBonusDesc,
           java.lang.Long m_llBonusAmt) {
           this.m_strBonusType = m_strBonusType;
           this.m_strBonusDesc = m_strBonusDesc;
           this.m_llBonusAmt = m_llBonusAmt;
    }


    /**
     * Gets the m_strBonusType value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @return m_strBonusType
     */
    public java.lang.String getM_strBonusType() {
        return m_strBonusType;
    }


    /**
     * Sets the m_strBonusType value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @param m_strBonusType
     */
    public void setM_strBonusType(java.lang.String m_strBonusType) {
        this.m_strBonusType = m_strBonusType;
    }


    /**
     * Gets the m_strBonusDesc value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @return m_strBonusDesc
     */
    public java.lang.String getM_strBonusDesc() {
        return m_strBonusDesc;
    }


    /**
     * Sets the m_strBonusDesc value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @param m_strBonusDesc
     */
    public void setM_strBonusDesc(java.lang.String m_strBonusDesc) {
        this.m_strBonusDesc = m_strBonusDesc;
    }


    /**
     * Gets the m_llBonusAmt value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @return m_llBonusAmt
     */
    public java.lang.Long getM_llBonusAmt() {
        return m_llBonusAmt;
    }


    /**
     * Sets the m_llBonusAmt value for this ObIdl_MBookSchemeDefSSchemePaymentQryOut.
     * 
     * @param m_llBonusAmt
     */
    public void setM_llBonusAmt(java.lang.Long m_llBonusAmt) {
        this.m_llBonusAmt = m_llBonusAmt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSSchemePaymentQryOut)) return false;
        ObIdl_MBookSchemeDefSSchemePaymentQryOut other = (ObIdl_MBookSchemeDefSSchemePaymentQryOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strBonusType==null && other.getM_strBonusType()==null) || 
             (this.m_strBonusType!=null &&
              this.m_strBonusType.equals(other.getM_strBonusType()))) &&
            ((this.m_strBonusDesc==null && other.getM_strBonusDesc()==null) || 
             (this.m_strBonusDesc!=null &&
              this.m_strBonusDesc.equals(other.getM_strBonusDesc()))) &&
            ((this.m_llBonusAmt==null && other.getM_llBonusAmt()==null) || 
             (this.m_llBonusAmt!=null &&
              this.m_llBonusAmt.equals(other.getM_llBonusAmt())));
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
        if (getM_strBonusType() != null) {
            _hashCode += getM_strBonusType().hashCode();
        }
        if (getM_strBonusDesc() != null) {
            _hashCode += getM_strBonusDesc().hashCode();
        }
        if (getM_llBonusAmt() != null) {
            _hashCode += getM_llBonusAmt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSSchemePaymentQryOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBonusType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBonusType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBonusDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBonusDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBonusAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBonusAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
