/**
 * ObIdl_MAccQuickQryFeeSQryRegularBookOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public class ObIdl_MAccQuickQryFeeSQryRegularBookOut  implements java.io.Serializable {
    private java.lang.String m_strPaymentType;

    private long m_llAmount;

    private java.lang.String m_strCreateDate;

    public ObIdl_MAccQuickQryFeeSQryRegularBookOut() {
    }

    public ObIdl_MAccQuickQryFeeSQryRegularBookOut(
           java.lang.String m_strPaymentType,
           long m_llAmount,
           java.lang.String m_strCreateDate) {
           this.m_strPaymentType = m_strPaymentType;
           this.m_llAmount = m_llAmount;
           this.m_strCreateDate = m_strCreateDate;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @return m_llAmount
     */
    public long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @return m_strCreateDate
     */
    public java.lang.String getM_strCreateDate() {
        return m_strCreateDate;
    }


    /**
     * Sets the m_strCreateDate value for this ObIdl_MAccQuickQryFeeSQryRegularBookOut.
     * 
     * @param m_strCreateDate
     */
    public void setM_strCreateDate(java.lang.String m_strCreateDate) {
        this.m_strCreateDate = m_strCreateDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccQuickQryFeeSQryRegularBookOut)) return false;
        ObIdl_MAccQuickQryFeeSQryRegularBookOut other = (ObIdl_MAccQuickQryFeeSQryRegularBookOut) obj;
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
            this.m_llAmount == other.getM_llAmount() &&
            ((this.m_strCreateDate==null && other.getM_strCreateDate()==null) || 
             (this.m_strCreateDate!=null &&
              this.m_strCreateDate.equals(other.getM_strCreateDate())));
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
        _hashCode += new Long(getM_llAmount()).hashCode();
        if (getM_strCreateDate() != null) {
            _hashCode += getM_strCreateDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccQuickQryFeeSQryRegularBookOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentType"));
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
