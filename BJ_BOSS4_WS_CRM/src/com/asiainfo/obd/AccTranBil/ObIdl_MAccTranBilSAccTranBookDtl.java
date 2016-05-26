/**
 * ObIdl_MAccTranBilSAccTranBookDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccTranBookDtl  implements java.io.Serializable {
    private java.lang.Long m_llBookId;

    private java.lang.Integer m_iBookItemId;

    private java.lang.Long m_llAmount;

    public ObIdl_MAccTranBilSAccTranBookDtl() {
    }

    public ObIdl_MAccTranBilSAccTranBookDtl(
           java.lang.Long m_llBookId,
           java.lang.Integer m_iBookItemId,
           java.lang.Long m_llAmount) {
           this.m_llBookId = m_llBookId;
           this.m_iBookItemId = m_iBookItemId;
           this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_llBookId value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @return m_llBookId
     */
    public java.lang.Long getM_llBookId() {
        return m_llBookId;
    }


    /**
     * Sets the m_llBookId value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @param m_llBookId
     */
    public void setM_llBookId(java.lang.Long m_llBookId) {
        this.m_llBookId = m_llBookId;
    }


    /**
     * Gets the m_iBookItemId value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @return m_iBookItemId
     */
    public java.lang.Integer getM_iBookItemId() {
        return m_iBookItemId;
    }


    /**
     * Sets the m_iBookItemId value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @param m_iBookItemId
     */
    public void setM_iBookItemId(java.lang.Integer m_iBookItemId) {
        this.m_iBookItemId = m_iBookItemId;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccTranBilSAccTranBookDtl.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccTranBookDtl)) return false;
        ObIdl_MAccTranBilSAccTranBookDtl other = (ObIdl_MAccTranBilSAccTranBookDtl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llBookId==null && other.getM_llBookId()==null) || 
             (this.m_llBookId!=null &&
              this.m_llBookId.equals(other.getM_llBookId()))) &&
            ((this.m_iBookItemId==null && other.getM_iBookItemId()==null) || 
             (this.m_iBookItemId!=null &&
              this.m_iBookItemId.equals(other.getM_iBookItemId()))) &&
            ((this.m_llAmount==null && other.getM_llAmount()==null) || 
             (this.m_llAmount!=null &&
              this.m_llAmount.equals(other.getM_llAmount())));
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
        if (getM_llBookId() != null) {
            _hashCode += getM_llBookId().hashCode();
        }
        if (getM_iBookItemId() != null) {
            _hashCode += getM_iBookItemId().hashCode();
        }
        if (getM_llAmount() != null) {
            _hashCode += getM_llAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccTranBookDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBookDtl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBookItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBookItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmount"));
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
