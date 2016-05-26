/**
 * ObIdl_MBusiChargeDefSAccBusiReceiptItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MBusiChargeDefSAccBusiReceiptItem  implements java.io.Serializable {
    private java.lang.String m_strReceiptItemSeq;

    private java.lang.String m_strReceiptItem;

    private java.lang.String m_strReceiptItemName;

    private java.lang.Long m_llReceiptItemAmount;

    private java.lang.Long m_llQuantity;

    private java.lang.Long m_llPrice;

    private java.lang.String m_strUnit;

    public ObIdl_MBusiChargeDefSAccBusiReceiptItem() {
    }

    public ObIdl_MBusiChargeDefSAccBusiReceiptItem(
           java.lang.String m_strReceiptItemSeq,
           java.lang.String m_strReceiptItem,
           java.lang.String m_strReceiptItemName,
           java.lang.Long m_llReceiptItemAmount,
           java.lang.Long m_llQuantity,
           java.lang.Long m_llPrice,
           java.lang.String m_strUnit) {
           this.m_strReceiptItemSeq = m_strReceiptItemSeq;
           this.m_strReceiptItem = m_strReceiptItem;
           this.m_strReceiptItemName = m_strReceiptItemName;
           this.m_llReceiptItemAmount = m_llReceiptItemAmount;
           this.m_llQuantity = m_llQuantity;
           this.m_llPrice = m_llPrice;
           this.m_strUnit = m_strUnit;
    }


    /**
     * Gets the m_strReceiptItemSeq value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_strReceiptItemSeq
     */
    public java.lang.String getM_strReceiptItemSeq() {
        return m_strReceiptItemSeq;
    }


    /**
     * Sets the m_strReceiptItemSeq value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_strReceiptItemSeq
     */
    public void setM_strReceiptItemSeq(java.lang.String m_strReceiptItemSeq) {
        this.m_strReceiptItemSeq = m_strReceiptItemSeq;
    }


    /**
     * Gets the m_strReceiptItem value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_strReceiptItem
     */
    public java.lang.String getM_strReceiptItem() {
        return m_strReceiptItem;
    }


    /**
     * Sets the m_strReceiptItem value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_strReceiptItem
     */
    public void setM_strReceiptItem(java.lang.String m_strReceiptItem) {
        this.m_strReceiptItem = m_strReceiptItem;
    }


    /**
     * Gets the m_strReceiptItemName value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_strReceiptItemName
     */
    public java.lang.String getM_strReceiptItemName() {
        return m_strReceiptItemName;
    }


    /**
     * Sets the m_strReceiptItemName value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_strReceiptItemName
     */
    public void setM_strReceiptItemName(java.lang.String m_strReceiptItemName) {
        this.m_strReceiptItemName = m_strReceiptItemName;
    }


    /**
     * Gets the m_llReceiptItemAmount value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_llReceiptItemAmount
     */
    public java.lang.Long getM_llReceiptItemAmount() {
        return m_llReceiptItemAmount;
    }


    /**
     * Sets the m_llReceiptItemAmount value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_llReceiptItemAmount
     */
    public void setM_llReceiptItemAmount(java.lang.Long m_llReceiptItemAmount) {
        this.m_llReceiptItemAmount = m_llReceiptItemAmount;
    }


    /**
     * Gets the m_llQuantity value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_llQuantity
     */
    public java.lang.Long getM_llQuantity() {
        return m_llQuantity;
    }


    /**
     * Sets the m_llQuantity value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_llQuantity
     */
    public void setM_llQuantity(java.lang.Long m_llQuantity) {
        this.m_llQuantity = m_llQuantity;
    }


    /**
     * Gets the m_llPrice value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_llPrice
     */
    public java.lang.Long getM_llPrice() {
        return m_llPrice;
    }


    /**
     * Sets the m_llPrice value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_llPrice
     */
    public void setM_llPrice(java.lang.Long m_llPrice) {
        this.m_llPrice = m_llPrice;
    }


    /**
     * Gets the m_strUnit value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @return m_strUnit
     */
    public java.lang.String getM_strUnit() {
        return m_strUnit;
    }


    /**
     * Sets the m_strUnit value for this ObIdl_MBusiChargeDefSAccBusiReceiptItem.
     * 
     * @param m_strUnit
     */
    public void setM_strUnit(java.lang.String m_strUnit) {
        this.m_strUnit = m_strUnit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBusiChargeDefSAccBusiReceiptItem)) return false;
        ObIdl_MBusiChargeDefSAccBusiReceiptItem other = (ObIdl_MBusiChargeDefSAccBusiReceiptItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strReceiptItemSeq==null && other.getM_strReceiptItemSeq()==null) || 
             (this.m_strReceiptItemSeq!=null &&
              this.m_strReceiptItemSeq.equals(other.getM_strReceiptItemSeq()))) &&
            ((this.m_strReceiptItem==null && other.getM_strReceiptItem()==null) || 
             (this.m_strReceiptItem!=null &&
              this.m_strReceiptItem.equals(other.getM_strReceiptItem()))) &&
            ((this.m_strReceiptItemName==null && other.getM_strReceiptItemName()==null) || 
             (this.m_strReceiptItemName!=null &&
              this.m_strReceiptItemName.equals(other.getM_strReceiptItemName()))) &&
            ((this.m_llReceiptItemAmount==null && other.getM_llReceiptItemAmount()==null) || 
             (this.m_llReceiptItemAmount!=null &&
              this.m_llReceiptItemAmount.equals(other.getM_llReceiptItemAmount()))) &&
            ((this.m_llQuantity==null && other.getM_llQuantity()==null) || 
             (this.m_llQuantity!=null &&
              this.m_llQuantity.equals(other.getM_llQuantity()))) &&
            ((this.m_llPrice==null && other.getM_llPrice()==null) || 
             (this.m_llPrice!=null &&
              this.m_llPrice.equals(other.getM_llPrice()))) &&
            ((this.m_strUnit==null && other.getM_strUnit()==null) || 
             (this.m_strUnit!=null &&
              this.m_strUnit.equals(other.getM_strUnit())));
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
        if (getM_strReceiptItemSeq() != null) {
            _hashCode += getM_strReceiptItemSeq().hashCode();
        }
        if (getM_strReceiptItem() != null) {
            _hashCode += getM_strReceiptItem().hashCode();
        }
        if (getM_strReceiptItemName() != null) {
            _hashCode += getM_strReceiptItemName().hashCode();
        }
        if (getM_llReceiptItemAmount() != null) {
            _hashCode += getM_llReceiptItemAmount().hashCode();
        }
        if (getM_llQuantity() != null) {
            _hashCode += getM_llQuantity().hashCode();
        }
        if (getM_llPrice() != null) {
            _hashCode += getM_llPrice().hashCode();
        }
        if (getM_strUnit() != null) {
            _hashCode += getM_strUnit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBusiChargeDefSAccBusiReceiptItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReceiptItemSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReceiptItemSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReceiptItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReceiptItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReceiptItemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReceiptItemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llReceiptItemAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llReceiptItemAmount"));
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
        elemField.setFieldName("m_llPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strUnit"));
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
