/**
 * ObIdl_MAccQuickQryFeeSAfterSpecBook.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccQuickQryFee;

public class ObIdl_MAccQuickQryFeeSAfterSpecBook  implements java.io.Serializable {
    private java.lang.Long m_llBookItemId;

    private java.lang.String m_strItemName;

    private java.lang.Long m_llAmount;

    private java.lang.Long m_llLeftAmount;

    private java.lang.Integer m_iItemType;

    private java.lang.Integer m_iSts;

    public ObIdl_MAccQuickQryFeeSAfterSpecBook() {
    }

    public ObIdl_MAccQuickQryFeeSAfterSpecBook(
           java.lang.Long m_llBookItemId,
           java.lang.String m_strItemName,
           java.lang.Long m_llAmount,
           java.lang.Long m_llLeftAmount,
           java.lang.Integer m_iItemType,
           java.lang.Integer m_iSts) {
           this.m_llBookItemId = m_llBookItemId;
           this.m_strItemName = m_strItemName;
           this.m_llAmount = m_llAmount;
           this.m_llLeftAmount = m_llLeftAmount;
           this.m_iItemType = m_iItemType;
           this.m_iSts = m_iSts;
    }


    /**
     * Gets the m_llBookItemId value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_llBookItemId
     */
    public java.lang.Long getM_llBookItemId() {
        return m_llBookItemId;
    }


    /**
     * Sets the m_llBookItemId value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_llBookItemId
     */
    public void setM_llBookItemId(java.lang.Long m_llBookItemId) {
        this.m_llBookItemId = m_llBookItemId;
    }


    /**
     * Gets the m_strItemName value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_strItemName
     */
    public java.lang.String getM_strItemName() {
        return m_strItemName;
    }


    /**
     * Sets the m_strItemName value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_strItemName
     */
    public void setM_strItemName(java.lang.String m_strItemName) {
        this.m_strItemName = m_strItemName;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_llLeftAmount value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_llLeftAmount
     */
    public java.lang.Long getM_llLeftAmount() {
        return m_llLeftAmount;
    }


    /**
     * Sets the m_llLeftAmount value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_llLeftAmount
     */
    public void setM_llLeftAmount(java.lang.Long m_llLeftAmount) {
        this.m_llLeftAmount = m_llLeftAmount;
    }


    /**
     * Gets the m_iItemType value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_iItemType
     */
    public java.lang.Integer getM_iItemType() {
        return m_iItemType;
    }


    /**
     * Sets the m_iItemType value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_iItemType
     */
    public void setM_iItemType(java.lang.Integer m_iItemType) {
        this.m_iItemType = m_iItemType;
    }


    /**
     * Gets the m_iSts value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @return m_iSts
     */
    public java.lang.Integer getM_iSts() {
        return m_iSts;
    }


    /**
     * Sets the m_iSts value for this ObIdl_MAccQuickQryFeeSAfterSpecBook.
     * 
     * @param m_iSts
     */
    public void setM_iSts(java.lang.Integer m_iSts) {
        this.m_iSts = m_iSts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccQuickQryFeeSAfterSpecBook)) return false;
        ObIdl_MAccQuickQryFeeSAfterSpecBook other = (ObIdl_MAccQuickQryFeeSAfterSpecBook) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llBookItemId==null && other.getM_llBookItemId()==null) || 
             (this.m_llBookItemId!=null &&
              this.m_llBookItemId.equals(other.getM_llBookItemId()))) &&
            ((this.m_strItemName==null && other.getM_strItemName()==null) || 
             (this.m_strItemName!=null &&
              this.m_strItemName.equals(other.getM_strItemName()))) &&
            ((this.m_llAmount==null && other.getM_llAmount()==null) || 
             (this.m_llAmount!=null &&
              this.m_llAmount.equals(other.getM_llAmount()))) &&
            ((this.m_llLeftAmount==null && other.getM_llLeftAmount()==null) || 
             (this.m_llLeftAmount!=null &&
              this.m_llLeftAmount.equals(other.getM_llLeftAmount()))) &&
            ((this.m_iItemType==null && other.getM_iItemType()==null) || 
             (this.m_iItemType!=null &&
              this.m_iItemType.equals(other.getM_iItemType()))) &&
            ((this.m_iSts==null && other.getM_iSts()==null) || 
             (this.m_iSts!=null &&
              this.m_iSts.equals(other.getM_iSts())));
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
        if (getM_llBookItemId() != null) {
            _hashCode += getM_llBookItemId().hashCode();
        }
        if (getM_strItemName() != null) {
            _hashCode += getM_strItemName().hashCode();
        }
        if (getM_llAmount() != null) {
            _hashCode += getM_llAmount().hashCode();
        }
        if (getM_llLeftAmount() != null) {
            _hashCode += getM_llLeftAmount().hashCode();
        }
        if (getM_iItemType() != null) {
            _hashCode += getM_iItemType().hashCode();
        }
        if (getM_iSts() != null) {
            _hashCode += getM_iSts().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccQuickQryFeeSAfterSpecBook.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SAfterSpecBook"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strItemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strItemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llLeftAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llLeftAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iItemType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iItemType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iSts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iSts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
