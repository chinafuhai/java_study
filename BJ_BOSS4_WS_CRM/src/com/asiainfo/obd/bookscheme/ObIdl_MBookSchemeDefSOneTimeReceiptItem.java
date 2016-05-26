/**
 * ObIdl_MBookSchemeDefSOneTimeReceiptItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSOneTimeReceiptItem  implements java.io.Serializable {
    private java.lang.String m_strCode;

    private java.lang.String m_strName;

    private java.lang.Long m_llAmount;

    private java.lang.Long m_llPrice;

    private java.lang.Long m_llQuantity;

    private java.lang.String m_strItemMemo;

    public ObIdl_MBookSchemeDefSOneTimeReceiptItem() {
    }

    public ObIdl_MBookSchemeDefSOneTimeReceiptItem(
           java.lang.String m_strCode,
           java.lang.String m_strName,
           java.lang.Long m_llAmount,
           java.lang.Long m_llPrice,
           java.lang.Long m_llQuantity,
           java.lang.String m_strItemMemo) {
           this.m_strCode = m_strCode;
           this.m_strName = m_strName;
           this.m_llAmount = m_llAmount;
           this.m_llPrice = m_llPrice;
           this.m_llQuantity = m_llQuantity;
           this.m_strItemMemo = m_strItemMemo;
    }


    /**
     * Gets the m_strCode value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_strCode
     */
    public java.lang.String getM_strCode() {
        return m_strCode;
    }


    /**
     * Sets the m_strCode value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_strCode
     */
    public void setM_strCode(java.lang.String m_strCode) {
        this.m_strCode = m_strCode;
    }


    /**
     * Gets the m_strName value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_strName
     */
    public java.lang.String getM_strName() {
        return m_strName;
    }


    /**
     * Sets the m_strName value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_strName
     */
    public void setM_strName(java.lang.String m_strName) {
        this.m_strName = m_strName;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_llPrice value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_llPrice
     */
    public java.lang.Long getM_llPrice() {
        return m_llPrice;
    }


    /**
     * Sets the m_llPrice value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_llPrice
     */
    public void setM_llPrice(java.lang.Long m_llPrice) {
        this.m_llPrice = m_llPrice;
    }


    /**
     * Gets the m_llQuantity value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_llQuantity
     */
    public java.lang.Long getM_llQuantity() {
        return m_llQuantity;
    }


    /**
     * Sets the m_llQuantity value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_llQuantity
     */
    public void setM_llQuantity(java.lang.Long m_llQuantity) {
        this.m_llQuantity = m_llQuantity;
    }


    /**
     * Gets the m_strItemMemo value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @return m_strItemMemo
     */
    public java.lang.String getM_strItemMemo() {
        return m_strItemMemo;
    }


    /**
     * Sets the m_strItemMemo value for this ObIdl_MBookSchemeDefSOneTimeReceiptItem.
     * 
     * @param m_strItemMemo
     */
    public void setM_strItemMemo(java.lang.String m_strItemMemo) {
        this.m_strItemMemo = m_strItemMemo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSOneTimeReceiptItem)) return false;
        ObIdl_MBookSchemeDefSOneTimeReceiptItem other = (ObIdl_MBookSchemeDefSOneTimeReceiptItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strCode==null && other.getM_strCode()==null) || 
             (this.m_strCode!=null &&
              this.m_strCode.equals(other.getM_strCode()))) &&
            ((this.m_strName==null && other.getM_strName()==null) || 
             (this.m_strName!=null &&
              this.m_strName.equals(other.getM_strName()))) &&
            ((this.m_llAmount==null && other.getM_llAmount()==null) || 
             (this.m_llAmount!=null &&
              this.m_llAmount.equals(other.getM_llAmount()))) &&
            ((this.m_llPrice==null && other.getM_llPrice()==null) || 
             (this.m_llPrice!=null &&
              this.m_llPrice.equals(other.getM_llPrice()))) &&
            ((this.m_llQuantity==null && other.getM_llQuantity()==null) || 
             (this.m_llQuantity!=null &&
              this.m_llQuantity.equals(other.getM_llQuantity()))) &&
            ((this.m_strItemMemo==null && other.getM_strItemMemo()==null) || 
             (this.m_strItemMemo!=null &&
              this.m_strItemMemo.equals(other.getM_strItemMemo())));
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
        if (getM_strCode() != null) {
            _hashCode += getM_strCode().hashCode();
        }
        if (getM_strName() != null) {
            _hashCode += getM_strName().hashCode();
        }
        if (getM_llAmount() != null) {
            _hashCode += getM_llAmount().hashCode();
        }
        if (getM_llPrice() != null) {
            _hashCode += getM_llPrice().hashCode();
        }
        if (getM_llQuantity() != null) {
            _hashCode += getM_llQuantity().hashCode();
        }
        if (getM_strItemMemo() != null) {
            _hashCode += getM_strItemMemo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSOneTimeReceiptItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimeReceiptItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strName"));
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
        elemField.setFieldName("m_llPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strItemMemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strItemMemo"));
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
