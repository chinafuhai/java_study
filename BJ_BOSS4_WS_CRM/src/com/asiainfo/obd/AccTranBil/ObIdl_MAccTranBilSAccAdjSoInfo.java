/**
 * ObIdl_MAccTranBilSAccAdjSoInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccAdjSoInfo  implements java.io.Serializable {
    private java.lang.String m_strFileName;

    private java.lang.String m_strReasonDesc;

    private java.lang.Long m_llOrgId;

    private java.lang.Integer m_iOpId;

    public ObIdl_MAccTranBilSAccAdjSoInfo() {
    }

    public ObIdl_MAccTranBilSAccAdjSoInfo(
           java.lang.String m_strFileName,
           java.lang.String m_strReasonDesc,
           java.lang.Long m_llOrgId,
           java.lang.Integer m_iOpId) {
           this.m_strFileName = m_strFileName;
           this.m_strReasonDesc = m_strReasonDesc;
           this.m_llOrgId = m_llOrgId;
           this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_strFileName value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @return m_strFileName
     */
    public java.lang.String getM_strFileName() {
        return m_strFileName;
    }


    /**
     * Sets the m_strFileName value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @param m_strFileName
     */
    public void setM_strFileName(java.lang.String m_strFileName) {
        this.m_strFileName = m_strFileName;
    }


    /**
     * Gets the m_strReasonDesc value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @return m_strReasonDesc
     */
    public java.lang.String getM_strReasonDesc() {
        return m_strReasonDesc;
    }


    /**
     * Sets the m_strReasonDesc value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @param m_strReasonDesc
     */
    public void setM_strReasonDesc(java.lang.String m_strReasonDesc) {
        this.m_strReasonDesc = m_strReasonDesc;
    }


    /**
     * Gets the m_llOrgId value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @return m_llOrgId
     */
    public java.lang.Long getM_llOrgId() {
        return m_llOrgId;
    }


    /**
     * Sets the m_llOrgId value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @param m_llOrgId
     */
    public void setM_llOrgId(java.lang.Long m_llOrgId) {
        this.m_llOrgId = m_llOrgId;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccTranBilSAccAdjSoInfo.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccAdjSoInfo)) return false;
        ObIdl_MAccTranBilSAccAdjSoInfo other = (ObIdl_MAccTranBilSAccAdjSoInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strFileName==null && other.getM_strFileName()==null) || 
             (this.m_strFileName!=null &&
              this.m_strFileName.equals(other.getM_strFileName()))) &&
            ((this.m_strReasonDesc==null && other.getM_strReasonDesc()==null) || 
             (this.m_strReasonDesc!=null &&
              this.m_strReasonDesc.equals(other.getM_strReasonDesc()))) &&
            ((this.m_llOrgId==null && other.getM_llOrgId()==null) || 
             (this.m_llOrgId!=null &&
              this.m_llOrgId.equals(other.getM_llOrgId()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId())));
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
        if (getM_strFileName() != null) {
            _hashCode += getM_strFileName().hashCode();
        }
        if (getM_strReasonDesc() != null) {
            _hashCode += getM_strReasonDesc().hashCode();
        }
        if (getM_llOrgId() != null) {
            _hashCode += getM_llOrgId().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccAdjSoInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSoInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReasonDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReasonDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llOrgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llOrgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOpId"));
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
