/**
 * ObIdl_MAccPrtInvDefSInvcItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSInvcItem  implements java.io.Serializable {
    private java.lang.Integer m_iBillItemId;

    private java.lang.String m_strItemName;

    private java.lang.Long m_llItemAmount;

    public ObIdl_MAccPrtInvDefSInvcItem() {
    }

    public ObIdl_MAccPrtInvDefSInvcItem(
           java.lang.Integer m_iBillItemId,
           java.lang.String m_strItemName,
           java.lang.Long m_llItemAmount) {
           this.m_iBillItemId = m_iBillItemId;
           this.m_strItemName = m_strItemName;
           this.m_llItemAmount = m_llItemAmount;
    }


    /**
     * Gets the m_iBillItemId value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @return m_iBillItemId
     */
    public java.lang.Integer getM_iBillItemId() {
        return m_iBillItemId;
    }


    /**
     * Sets the m_iBillItemId value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @param m_iBillItemId
     */
    public void setM_iBillItemId(java.lang.Integer m_iBillItemId) {
        this.m_iBillItemId = m_iBillItemId;
    }


    /**
     * Gets the m_strItemName value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @return m_strItemName
     */
    public java.lang.String getM_strItemName() {
        return m_strItemName;
    }


    /**
     * Sets the m_strItemName value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @param m_strItemName
     */
    public void setM_strItemName(java.lang.String m_strItemName) {
        this.m_strItemName = m_strItemName;
    }


    /**
     * Gets the m_llItemAmount value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @return m_llItemAmount
     */
    public java.lang.Long getM_llItemAmount() {
        return m_llItemAmount;
    }


    /**
     * Sets the m_llItemAmount value for this ObIdl_MAccPrtInvDefSInvcItem.
     * 
     * @param m_llItemAmount
     */
    public void setM_llItemAmount(java.lang.Long m_llItemAmount) {
        this.m_llItemAmount = m_llItemAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSInvcItem)) return false;
        ObIdl_MAccPrtInvDefSInvcItem other = (ObIdl_MAccPrtInvDefSInvcItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iBillItemId==null && other.getM_iBillItemId()==null) || 
             (this.m_iBillItemId!=null &&
              this.m_iBillItemId.equals(other.getM_iBillItemId()))) &&
            ((this.m_strItemName==null && other.getM_strItemName()==null) || 
             (this.m_strItemName!=null &&
              this.m_strItemName.equals(other.getM_strItemName()))) &&
            ((this.m_llItemAmount==null && other.getM_llItemAmount()==null) || 
             (this.m_llItemAmount!=null &&
              this.m_llItemAmount.equals(other.getM_llItemAmount())));
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
        if (getM_iBillItemId() != null) {
            _hashCode += getM_iBillItemId().hashCode();
        }
        if (getM_strItemName() != null) {
            _hashCode += getM_strItemName().hashCode();
        }
        if (getM_llItemAmount() != null) {
            _hashCode += getM_llItemAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSInvcItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
