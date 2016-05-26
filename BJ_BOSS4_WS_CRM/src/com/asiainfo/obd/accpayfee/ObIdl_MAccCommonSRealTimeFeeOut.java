/**
 * ObIdl_MAccCommonSRealTimeFeeOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSRealTimeFeeOut  implements java.io.Serializable {
    private ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeFavourFeeList;

    private ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeWoffFeeList;

    public ObIdl_MAccCommonSRealTimeFeeOut() {
    }

    public ObIdl_MAccCommonSRealTimeFeeOut(
           ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeFavourFeeList,
           ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeWoffFeeList) {
           this.m_listRealTimeFavourFeeList = m_listRealTimeFavourFeeList;
           this.m_listRealTimeWoffFeeList = m_listRealTimeWoffFeeList;
    }


    /**
     * Gets the m_listRealTimeFavourFeeList value for this ObIdl_MAccCommonSRealTimeFeeOut.
     * 
     * @return m_listRealTimeFavourFeeList
     */
    public ObIdl_MAccCommonSRealTimeBillFee[] getM_listRealTimeFavourFeeList() {
        return m_listRealTimeFavourFeeList;
    }


    /**
     * Sets the m_listRealTimeFavourFeeList value for this ObIdl_MAccCommonSRealTimeFeeOut.
     * 
     * @param m_listRealTimeFavourFeeList
     */
    public void setM_listRealTimeFavourFeeList(ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeFavourFeeList) {
        this.m_listRealTimeFavourFeeList = m_listRealTimeFavourFeeList;
    }


    /**
     * Gets the m_listRealTimeWoffFeeList value for this ObIdl_MAccCommonSRealTimeFeeOut.
     * 
     * @return m_listRealTimeWoffFeeList
     */
    public ObIdl_MAccCommonSRealTimeBillFee[] getM_listRealTimeWoffFeeList() {
        return m_listRealTimeWoffFeeList;
    }


    /**
     * Sets the m_listRealTimeWoffFeeList value for this ObIdl_MAccCommonSRealTimeFeeOut.
     * 
     * @param m_listRealTimeWoffFeeList
     */
    public void setM_listRealTimeWoffFeeList(ObIdl_MAccCommonSRealTimeBillFee[] m_listRealTimeWoffFeeList) {
        this.m_listRealTimeWoffFeeList = m_listRealTimeWoffFeeList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSRealTimeFeeOut)) return false;
        ObIdl_MAccCommonSRealTimeFeeOut other = (ObIdl_MAccCommonSRealTimeFeeOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_listRealTimeFavourFeeList==null && other.getM_listRealTimeFavourFeeList()==null) || 
             (this.m_listRealTimeFavourFeeList!=null &&
              java.util.Arrays.equals(this.m_listRealTimeFavourFeeList, other.getM_listRealTimeFavourFeeList()))) &&
            ((this.m_listRealTimeWoffFeeList==null && other.getM_listRealTimeWoffFeeList()==null) || 
             (this.m_listRealTimeWoffFeeList!=null &&
              java.util.Arrays.equals(this.m_listRealTimeWoffFeeList, other.getM_listRealTimeWoffFeeList())));
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
        if (getM_listRealTimeFavourFeeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listRealTimeFavourFeeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listRealTimeFavourFeeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listRealTimeWoffFeeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listRealTimeWoffFeeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listRealTimeWoffFeeList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSRealTimeFeeOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFeeOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listRealTimeFavourFeeList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listRealTimeFavourFeeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFee"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listRealTimeWoffFeeList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listRealTimeWoffFeeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFee"));
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
