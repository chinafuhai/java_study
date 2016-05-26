/**
 * ObIdl_MAccTranBilSReturnBookDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSReturnBookDtl  implements java.io.Serializable {
    private java.lang.Long m_llBookId;

    private java.lang.Integer m_iBookItemId;

    private java.lang.Long m_llAmount;

    private java.lang.Long m_llBookIdAdd;

    private java.lang.Integer m_iBookItemIdAdd;

    private java.lang.Long m_llAmountAdd;

    public ObIdl_MAccTranBilSReturnBookDtl() {
    }

    public ObIdl_MAccTranBilSReturnBookDtl(
           java.lang.Long m_llBookId,
           java.lang.Integer m_iBookItemId,
           java.lang.Long m_llAmount,
           java.lang.Long m_llBookIdAdd,
           java.lang.Integer m_iBookItemIdAdd,
           java.lang.Long m_llAmountAdd) {
           this.m_llBookId = m_llBookId;
           this.m_iBookItemId = m_iBookItemId;
           this.m_llAmount = m_llAmount;
           this.m_llBookIdAdd = m_llBookIdAdd;
           this.m_iBookItemIdAdd = m_iBookItemIdAdd;
           this.m_llAmountAdd = m_llAmountAdd;
    }


    /**
     * Gets the m_llBookId value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_llBookId
     */
    public java.lang.Long getM_llBookId() {
        return m_llBookId;
    }


    /**
     * Sets the m_llBookId value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_llBookId
     */
    public void setM_llBookId(java.lang.Long m_llBookId) {
        this.m_llBookId = m_llBookId;
    }


    /**
     * Gets the m_iBookItemId value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_iBookItemId
     */
    public java.lang.Integer getM_iBookItemId() {
        return m_iBookItemId;
    }


    /**
     * Sets the m_iBookItemId value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_iBookItemId
     */
    public void setM_iBookItemId(java.lang.Integer m_iBookItemId) {
        this.m_iBookItemId = m_iBookItemId;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_llBookIdAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_llBookIdAdd
     */
    public java.lang.Long getM_llBookIdAdd() {
        return m_llBookIdAdd;
    }


    /**
     * Sets the m_llBookIdAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_llBookIdAdd
     */
    public void setM_llBookIdAdd(java.lang.Long m_llBookIdAdd) {
        this.m_llBookIdAdd = m_llBookIdAdd;
    }


    /**
     * Gets the m_iBookItemIdAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_iBookItemIdAdd
     */
    public java.lang.Integer getM_iBookItemIdAdd() {
        return m_iBookItemIdAdd;
    }


    /**
     * Sets the m_iBookItemIdAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_iBookItemIdAdd
     */
    public void setM_iBookItemIdAdd(java.lang.Integer m_iBookItemIdAdd) {
        this.m_iBookItemIdAdd = m_iBookItemIdAdd;
    }


    /**
     * Gets the m_llAmountAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @return m_llAmountAdd
     */
    public java.lang.Long getM_llAmountAdd() {
        return m_llAmountAdd;
    }


    /**
     * Sets the m_llAmountAdd value for this ObIdl_MAccTranBilSReturnBookDtl.
     * 
     * @param m_llAmountAdd
     */
    public void setM_llAmountAdd(java.lang.Long m_llAmountAdd) {
        this.m_llAmountAdd = m_llAmountAdd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSReturnBookDtl)) return false;
        ObIdl_MAccTranBilSReturnBookDtl other = (ObIdl_MAccTranBilSReturnBookDtl) obj;
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
              this.m_llAmount.equals(other.getM_llAmount()))) &&
            ((this.m_llBookIdAdd==null && other.getM_llBookIdAdd()==null) || 
             (this.m_llBookIdAdd!=null &&
              this.m_llBookIdAdd.equals(other.getM_llBookIdAdd()))) &&
            ((this.m_iBookItemIdAdd==null && other.getM_iBookItemIdAdd()==null) || 
             (this.m_iBookItemIdAdd!=null &&
              this.m_iBookItemIdAdd.equals(other.getM_iBookItemIdAdd()))) &&
            ((this.m_llAmountAdd==null && other.getM_llAmountAdd()==null) || 
             (this.m_llAmountAdd!=null &&
              this.m_llAmountAdd.equals(other.getM_llAmountAdd())));
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
        if (getM_llBookIdAdd() != null) {
            _hashCode += getM_llBookIdAdd().hashCode();
        }
        if (getM_iBookItemIdAdd() != null) {
            _hashCode += getM_iBookItemIdAdd().hashCode();
        }
        if (getM_llAmountAdd() != null) {
            _hashCode += getM_llAmountAdd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSReturnBookDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnBookDtl"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookIdAdd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookIdAdd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBookItemIdAdd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBookItemIdAdd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmountAdd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmountAdd"));
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
