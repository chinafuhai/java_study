/**
 * MObdCommonSOBSessionProperty.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public class MObdCommonSOBSessionProperty  implements java.io.Serializable {
    private java.lang.String m_strName;

    private java.lang.String m_strValue;

    public MObdCommonSOBSessionProperty() {
    }

    public MObdCommonSOBSessionProperty(
           java.lang.String m_strName,
           java.lang.String m_strValue) {
           this.m_strName = m_strName;
           this.m_strValue = m_strValue;
    }


    /**
     * Gets the m_strName value for this MObdCommonSOBSessionProperty.
     * 
     * @return m_strName
     */
    public java.lang.String getM_strName() {
        return m_strName;
    }


    /**
     * Sets the m_strName value for this MObdCommonSOBSessionProperty.
     * 
     * @param m_strName
     */
    public void setM_strName(java.lang.String m_strName) {
        this.m_strName = m_strName;
    }


    /**
     * Gets the m_strValue value for this MObdCommonSOBSessionProperty.
     * 
     * @return m_strValue
     */
    public java.lang.String getM_strValue() {
        return m_strValue;
    }


    /**
     * Sets the m_strValue value for this MObdCommonSOBSessionProperty.
     * 
     * @param m_strValue
     */
    public void setM_strValue(java.lang.String m_strValue) {
        this.m_strValue = m_strValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MObdCommonSOBSessionProperty)) return false;
        MObdCommonSOBSessionProperty other = (MObdCommonSOBSessionProperty) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strName==null && other.getM_strName()==null) || 
             (this.m_strName!=null &&
              this.m_strName.equals(other.getM_strName()))) &&
            ((this.m_strValue==null && other.getM_strValue()==null) || 
             (this.m_strValue!=null &&
              this.m_strValue.equals(other.getM_strValue())));
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
        if (getM_strName() != null) {
            _hashCode += getM_strName().hashCode();
        }
        if (getM_strValue() != null) {
            _hashCode += getM_strValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MObdCommonSOBSessionProperty.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SOBSessionProperty"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
