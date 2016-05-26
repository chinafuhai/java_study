/**
 * ObIdl_MAccPrtInvDefSInvCancelIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSInvCancelIn  implements java.io.Serializable {
    private ObIdl_MAccPrtInvDefSInvCancelUnit[] m_listSoNbrList;

    private java.lang.String m_strMonth;

    private java.lang.Integer m_iRegionCode;

    public ObIdl_MAccPrtInvDefSInvCancelIn() {
    }

    public ObIdl_MAccPrtInvDefSInvCancelIn(
           ObIdl_MAccPrtInvDefSInvCancelUnit[] m_listSoNbrList,
           java.lang.String m_strMonth,
           java.lang.Integer m_iRegionCode) {
           this.m_listSoNbrList = m_listSoNbrList;
           this.m_strMonth = m_strMonth;
           this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_listSoNbrList value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @return m_listSoNbrList
     */
    public ObIdl_MAccPrtInvDefSInvCancelUnit[] getM_listSoNbrList() {
        return m_listSoNbrList;
    }


    /**
     * Sets the m_listSoNbrList value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @param m_listSoNbrList
     */
    public void setM_listSoNbrList(ObIdl_MAccPrtInvDefSInvCancelUnit[] m_listSoNbrList) {
        this.m_listSoNbrList = m_listSoNbrList;
    }


    /**
     * Gets the m_strMonth value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @return m_strMonth
     */
    public java.lang.String getM_strMonth() {
        return m_strMonth;
    }


    /**
     * Sets the m_strMonth value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @param m_strMonth
     */
    public void setM_strMonth(java.lang.String m_strMonth) {
        this.m_strMonth = m_strMonth;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccPrtInvDefSInvCancelIn.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSInvCancelIn)) return false;
        ObIdl_MAccPrtInvDefSInvCancelIn other = (ObIdl_MAccPrtInvDefSInvCancelIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_listSoNbrList==null && other.getM_listSoNbrList()==null) || 
             (this.m_listSoNbrList!=null &&
              java.util.Arrays.equals(this.m_listSoNbrList, other.getM_listSoNbrList()))) &&
            ((this.m_strMonth==null && other.getM_strMonth()==null) || 
             (this.m_strMonth!=null &&
              this.m_strMonth.equals(other.getM_strMonth()))) &&
            ((this.m_iRegionCode==null && other.getM_iRegionCode()==null) || 
             (this.m_iRegionCode!=null &&
              this.m_iRegionCode.equals(other.getM_iRegionCode())));
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
        if (getM_listSoNbrList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listSoNbrList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listSoNbrList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_strMonth() != null) {
            _hashCode += getM_strMonth().hashCode();
        }
        if (getM_iRegionCode() != null) {
            _hashCode += getM_iRegionCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSInvCancelIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listSoNbrList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listSoNbrList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelUnit"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
