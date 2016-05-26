/**
 * ObIdl_MAccCommonSAccInvcRecDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSAccInvcRecDtl  implements java.io.Serializable {
    private java.lang.Long m_llInvcNumSeq;

    private java.lang.Short m_nBillItemSeq;

    private java.lang.Integer m_iBillItemId;

    private java.lang.String m_strItemName;

    private java.lang.Long m_llItemAmount;

    private java.lang.Long m_llQuantity;

    private java.lang.Long m_llUnitPrice;

    private java.lang.String m_strUnit;

    public ObIdl_MAccCommonSAccInvcRecDtl() {
    }

    public ObIdl_MAccCommonSAccInvcRecDtl(
           java.lang.Long m_llInvcNumSeq,
           java.lang.Short m_nBillItemSeq,
           java.lang.Integer m_iBillItemId,
           java.lang.String m_strItemName,
           java.lang.Long m_llItemAmount,
           java.lang.Long m_llQuantity,
           java.lang.Long m_llUnitPrice,
           java.lang.String m_strUnit) {
           this.m_llInvcNumSeq = m_llInvcNumSeq;
           this.m_nBillItemSeq = m_nBillItemSeq;
           this.m_iBillItemId = m_iBillItemId;
           this.m_strItemName = m_strItemName;
           this.m_llItemAmount = m_llItemAmount;
           this.m_llQuantity = m_llQuantity;
           this.m_llUnitPrice = m_llUnitPrice;
           this.m_strUnit = m_strUnit;
    }


    /**
     * Gets the m_llInvcNumSeq value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_llInvcNumSeq
     */
    public java.lang.Long getM_llInvcNumSeq() {
        return m_llInvcNumSeq;
    }


    /**
     * Sets the m_llInvcNumSeq value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_llInvcNumSeq
     */
    public void setM_llInvcNumSeq(java.lang.Long m_llInvcNumSeq) {
        this.m_llInvcNumSeq = m_llInvcNumSeq;
    }


    /**
     * Gets the m_nBillItemSeq value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_nBillItemSeq
     */
    public java.lang.Short getM_nBillItemSeq() {
        return m_nBillItemSeq;
    }


    /**
     * Sets the m_nBillItemSeq value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_nBillItemSeq
     */
    public void setM_nBillItemSeq(java.lang.Short m_nBillItemSeq) {
        this.m_nBillItemSeq = m_nBillItemSeq;
    }


    /**
     * Gets the m_iBillItemId value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_iBillItemId
     */
    public java.lang.Integer getM_iBillItemId() {
        return m_iBillItemId;
    }


    /**
     * Sets the m_iBillItemId value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_iBillItemId
     */
    public void setM_iBillItemId(java.lang.Integer m_iBillItemId) {
        this.m_iBillItemId = m_iBillItemId;
    }


    /**
     * Gets the m_strItemName value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_strItemName
     */
    public java.lang.String getM_strItemName() {
        return m_strItemName;
    }


    /**
     * Sets the m_strItemName value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_strItemName
     */
    public void setM_strItemName(java.lang.String m_strItemName) {
        this.m_strItemName = m_strItemName;
    }


    /**
     * Gets the m_llItemAmount value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_llItemAmount
     */
    public java.lang.Long getM_llItemAmount() {
        return m_llItemAmount;
    }


    /**
     * Sets the m_llItemAmount value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_llItemAmount
     */
    public void setM_llItemAmount(java.lang.Long m_llItemAmount) {
        this.m_llItemAmount = m_llItemAmount;
    }


    /**
     * Gets the m_llQuantity value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_llQuantity
     */
    public java.lang.Long getM_llQuantity() {
        return m_llQuantity;
    }


    /**
     * Sets the m_llQuantity value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_llQuantity
     */
    public void setM_llQuantity(java.lang.Long m_llQuantity) {
        this.m_llQuantity = m_llQuantity;
    }


    /**
     * Gets the m_llUnitPrice value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_llUnitPrice
     */
    public java.lang.Long getM_llUnitPrice() {
        return m_llUnitPrice;
    }


    /**
     * Sets the m_llUnitPrice value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_llUnitPrice
     */
    public void setM_llUnitPrice(java.lang.Long m_llUnitPrice) {
        this.m_llUnitPrice = m_llUnitPrice;
    }


    /**
     * Gets the m_strUnit value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @return m_strUnit
     */
    public java.lang.String getM_strUnit() {
        return m_strUnit;
    }


    /**
     * Sets the m_strUnit value for this ObIdl_MAccCommonSAccInvcRecDtl.
     * 
     * @param m_strUnit
     */
    public void setM_strUnit(java.lang.String m_strUnit) {
        this.m_strUnit = m_strUnit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSAccInvcRecDtl)) return false;
        ObIdl_MAccCommonSAccInvcRecDtl other = (ObIdl_MAccCommonSAccInvcRecDtl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llInvcNumSeq==null && other.getM_llInvcNumSeq()==null) || 
             (this.m_llInvcNumSeq!=null &&
              this.m_llInvcNumSeq.equals(other.getM_llInvcNumSeq()))) &&
            ((this.m_nBillItemSeq==null && other.getM_nBillItemSeq()==null) || 
             (this.m_nBillItemSeq!=null &&
              this.m_nBillItemSeq.equals(other.getM_nBillItemSeq()))) &&
            ((this.m_iBillItemId==null && other.getM_iBillItemId()==null) || 
             (this.m_iBillItemId!=null &&
              this.m_iBillItemId.equals(other.getM_iBillItemId()))) &&
            ((this.m_strItemName==null && other.getM_strItemName()==null) || 
             (this.m_strItemName!=null &&
              this.m_strItemName.equals(other.getM_strItemName()))) &&
            ((this.m_llItemAmount==null && other.getM_llItemAmount()==null) || 
             (this.m_llItemAmount!=null &&
              this.m_llItemAmount.equals(other.getM_llItemAmount()))) &&
            ((this.m_llQuantity==null && other.getM_llQuantity()==null) || 
             (this.m_llQuantity!=null &&
              this.m_llQuantity.equals(other.getM_llQuantity()))) &&
            ((this.m_llUnitPrice==null && other.getM_llUnitPrice()==null) || 
             (this.m_llUnitPrice!=null &&
              this.m_llUnitPrice.equals(other.getM_llUnitPrice()))) &&
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
        if (getM_llInvcNumSeq() != null) {
            _hashCode += getM_llInvcNumSeq().hashCode();
        }
        if (getM_nBillItemSeq() != null) {
            _hashCode += getM_nBillItemSeq().hashCode();
        }
        if (getM_iBillItemId() != null) {
            _hashCode += getM_iBillItemId().hashCode();
        }
        if (getM_strItemName() != null) {
            _hashCode += getM_strItemName().hashCode();
        }
        if (getM_llItemAmount() != null) {
            _hashCode += getM_llItemAmount().hashCode();
        }
        if (getM_llQuantity() != null) {
            _hashCode += getM_llQuantity().hashCode();
        }
        if (getM_llUnitPrice() != null) {
            _hashCode += getM_llUnitPrice().hashCode();
        }
        if (getM_strUnit() != null) {
            _hashCode += getM_strUnit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSAccInvcRecDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecDtl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvcNumSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvcNumSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBillItemSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBillItemSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBillItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBillItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("m_llItemAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llItemAmount"));
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
        elemField.setFieldName("m_llUnitPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUnitPrice"));
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
