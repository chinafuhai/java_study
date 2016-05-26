/**
 * ObIdl_MAccPrtInvDefSPrepayInvcQryIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSPrepayInvcQryIn  implements java.io.Serializable {
    private java.lang.Long m_llCustId;

    private java.lang.Long m_llAcctId;

    private java.lang.String m_strPhoneId;

    private java.lang.String[] m_listListBillCycle;

    public ObIdl_MAccPrtInvDefSPrepayInvcQryIn() {
    }

    public ObIdl_MAccPrtInvDefSPrepayInvcQryIn(
           java.lang.Long m_llCustId,
           java.lang.Long m_llAcctId,
           java.lang.String m_strPhoneId,
           java.lang.String[] m_listListBillCycle) {
           this.m_llCustId = m_llCustId;
           this.m_llAcctId = m_llAcctId;
           this.m_strPhoneId = m_strPhoneId;
           this.m_listListBillCycle = m_listListBillCycle;
    }


    /**
     * Gets the m_llCustId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @return m_llCustId
     */
    public java.lang.Long getM_llCustId() {
        return m_llCustId;
    }


    /**
     * Sets the m_llCustId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @param m_llCustId
     */
    public void setM_llCustId(java.lang.Long m_llCustId) {
        this.m_llCustId = m_llCustId;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_listListBillCycle value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @return m_listListBillCycle
     */
    public java.lang.String[] getM_listListBillCycle() {
        return m_listListBillCycle;
    }


    /**
     * Sets the m_listListBillCycle value for this ObIdl_MAccPrtInvDefSPrepayInvcQryIn.
     * 
     * @param m_listListBillCycle
     */
    public void setM_listListBillCycle(java.lang.String[] m_listListBillCycle) {
        this.m_listListBillCycle = m_listListBillCycle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSPrepayInvcQryIn)) return false;
        ObIdl_MAccPrtInvDefSPrepayInvcQryIn other = (ObIdl_MAccPrtInvDefSPrepayInvcQryIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llCustId==null && other.getM_llCustId()==null) || 
             (this.m_llCustId!=null &&
              this.m_llCustId.equals(other.getM_llCustId()))) &&
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_listListBillCycle==null && other.getM_listListBillCycle()==null) || 
             (this.m_listListBillCycle!=null &&
              java.util.Arrays.equals(this.m_listListBillCycle, other.getM_listListBillCycle())));
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
        if (getM_llCustId() != null) {
            _hashCode += getM_llCustId().hashCode();
        }
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_listListBillCycle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListBillCycle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListBillCycle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSPrepayInvcQryIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrepayInvcQryIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCustId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCustId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListBillCycle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListBillCycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
