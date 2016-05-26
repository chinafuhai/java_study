/**
 * ObIdl_MAccCommonSPayLimit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSPayLimit  implements java.io.Serializable {
    private java.lang.Long m_llBillMonth;

    private java.lang.Long m_llServId;

    public ObIdl_MAccCommonSPayLimit() {
    }

    public ObIdl_MAccCommonSPayLimit(
           java.lang.Long m_llBillMonth,
           java.lang.Long m_llServId) {
           this.m_llBillMonth = m_llBillMonth;
           this.m_llServId = m_llServId;
    }


    /**
     * Gets the m_llBillMonth value for this ObIdl_MAccCommonSPayLimit.
     * 
     * @return m_llBillMonth
     */
    public java.lang.Long getM_llBillMonth() {
        return m_llBillMonth;
    }


    /**
     * Sets the m_llBillMonth value for this ObIdl_MAccCommonSPayLimit.
     * 
     * @param m_llBillMonth
     */
    public void setM_llBillMonth(java.lang.Long m_llBillMonth) {
        this.m_llBillMonth = m_llBillMonth;
    }


    /**
     * Gets the m_llServId value for this ObIdl_MAccCommonSPayLimit.
     * 
     * @return m_llServId
     */
    public java.lang.Long getM_llServId() {
        return m_llServId;
    }


    /**
     * Sets the m_llServId value for this ObIdl_MAccCommonSPayLimit.
     * 
     * @param m_llServId
     */
    public void setM_llServId(java.lang.Long m_llServId) {
        this.m_llServId = m_llServId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSPayLimit)) return false;
        ObIdl_MAccCommonSPayLimit other = (ObIdl_MAccCommonSPayLimit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llBillMonth==null && other.getM_llBillMonth()==null) || 
             (this.m_llBillMonth!=null &&
              this.m_llBillMonth.equals(other.getM_llBillMonth()))) &&
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
        if (getM_llBillMonth() != null) {
            _hashCode += getM_llBillMonth().hashCode();
        }
        if (getM_llServId() != null) {
            _hashCode += getM_llServId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSPayLimit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayLimit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBillMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBillMonth"));
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
