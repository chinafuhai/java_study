/**
 * ObIdl_MAccTranBilSUnpnIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSUnpnIn  implements java.io.Serializable {
    private java.lang.Integer m_iOpId;

    private ObIdl_MAccTranBilSUnpn[] m_listUppnList;

    public ObIdl_MAccTranBilSUnpnIn() {
    }

    public ObIdl_MAccTranBilSUnpnIn(
           java.lang.Integer m_iOpId,
           ObIdl_MAccTranBilSUnpn[] m_listUppnList) {
           this.m_iOpId = m_iOpId;
           this.m_listUppnList = m_listUppnList;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccTranBilSUnpnIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccTranBilSUnpnIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_listUppnList value for this ObIdl_MAccTranBilSUnpnIn.
     * 
     * @return m_listUppnList
     */
    public ObIdl_MAccTranBilSUnpn[] getM_listUppnList() {
        return m_listUppnList;
    }


    /**
     * Sets the m_listUppnList value for this ObIdl_MAccTranBilSUnpnIn.
     * 
     * @param m_listUppnList
     */
    public void setM_listUppnList(ObIdl_MAccTranBilSUnpn[] m_listUppnList) {
        this.m_listUppnList = m_listUppnList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSUnpnIn)) return false;
        ObIdl_MAccTranBilSUnpnIn other = (ObIdl_MAccTranBilSUnpnIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_listUppnList==null && other.getM_listUppnList()==null) || 
             (this.m_listUppnList!=null &&
              java.util.Arrays.equals(this.m_listUppnList, other.getM_listUppnList())));
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
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_listUppnList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listUppnList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listUppnList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSUnpnIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listUppnList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listUppnList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpn"));
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
