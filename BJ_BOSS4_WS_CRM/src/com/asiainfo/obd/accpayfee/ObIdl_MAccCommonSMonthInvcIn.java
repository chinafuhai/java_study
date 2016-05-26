/**
 * ObIdl_MAccCommonSMonthInvcIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSMonthInvcIn  implements java.io.Serializable {
    private java.lang.Integer m_iRegionCode;

    private java.lang.Integer m_iBillMonth;

    private java.lang.Long m_llAcctId;

    private java.lang.Long m_llServId;

    public ObIdl_MAccCommonSMonthInvcIn() {
    }

    public ObIdl_MAccCommonSMonthInvcIn(
           java.lang.Integer m_iRegionCode,
           java.lang.Integer m_iBillMonth,
           java.lang.Long m_llAcctId,
           java.lang.Long m_llServId) {
           this.m_iRegionCode = m_iRegionCode;
           this.m_iBillMonth = m_iBillMonth;
           this.m_llAcctId = m_llAcctId;
           this.m_llServId = m_llServId;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_iBillMonth value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @return m_iBillMonth
     */
    public java.lang.Integer getM_iBillMonth() {
        return m_iBillMonth;
    }


    /**
     * Sets the m_iBillMonth value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @param m_iBillMonth
     */
    public void setM_iBillMonth(java.lang.Integer m_iBillMonth) {
        this.m_iBillMonth = m_iBillMonth;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_llServId value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @return m_llServId
     */
    public java.lang.Long getM_llServId() {
        return m_llServId;
    }


    /**
     * Sets the m_llServId value for this ObIdl_MAccCommonSMonthInvcIn.
     * 
     * @param m_llServId
     */
    public void setM_llServId(java.lang.Long m_llServId) {
        this.m_llServId = m_llServId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSMonthInvcIn)) return false;
        ObIdl_MAccCommonSMonthInvcIn other = (ObIdl_MAccCommonSMonthInvcIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iRegionCode==null && other.getM_iRegionCode()==null) || 
             (this.m_iRegionCode!=null &&
              this.m_iRegionCode.equals(other.getM_iRegionCode()))) &&
            ((this.m_iBillMonth==null && other.getM_iBillMonth()==null) || 
             (this.m_iBillMonth!=null &&
              this.m_iBillMonth.equals(other.getM_iBillMonth()))) &&
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_llServId==null && other.getM_llServId()==null) || 
             (this.m_llServId!=null &&
              this.m_llServId.equals(other.getM_llServId())));
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
        if (getM_iRegionCode() != null) {
            _hashCode += getM_iRegionCode().hashCode();
        }
        if (getM_iBillMonth() != null) {
            _hashCode += getM_iBillMonth().hashCode();
        }
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_llServId() != null) {
            _hashCode += getM_llServId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSMonthInvcIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SMonthInvcIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBillMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBillMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("m_llServId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llServId"));
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
