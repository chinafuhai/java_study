/**
 * MObdCommonSCbsErrorMsg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class MObdCommonSCbsErrorMsg  implements java.io.Serializable {
    private java.lang.Integer m_iErrorCode;

    private java.lang.String m_strErrorMsg;

    private java.lang.String m_strHint;

    public MObdCommonSCbsErrorMsg() {
    }

    public MObdCommonSCbsErrorMsg(
           java.lang.Integer m_iErrorCode,
           java.lang.String m_strErrorMsg,
           java.lang.String m_strHint) {
           this.m_iErrorCode = m_iErrorCode;
           this.m_strErrorMsg = m_strErrorMsg;
           this.m_strHint = m_strHint;
    }


    /**
     * Gets the m_iErrorCode value for this MObdCommonSCbsErrorMsg.
     * 
     * @return m_iErrorCode
     */
    public java.lang.Integer getM_iErrorCode() {
        return m_iErrorCode;
    }


    /**
     * Sets the m_iErrorCode value for this MObdCommonSCbsErrorMsg.
     * 
     * @param m_iErrorCode
     */
    public void setM_iErrorCode(java.lang.Integer m_iErrorCode) {
        this.m_iErrorCode = m_iErrorCode;
    }


    /**
     * Gets the m_strErrorMsg value for this MObdCommonSCbsErrorMsg.
     * 
     * @return m_strErrorMsg
     */
    public java.lang.String getM_strErrorMsg() {
        return m_strErrorMsg;
    }


    /**
     * Sets the m_strErrorMsg value for this MObdCommonSCbsErrorMsg.
     * 
     * @param m_strErrorMsg
     */
    public void setM_strErrorMsg(java.lang.String m_strErrorMsg) {
        this.m_strErrorMsg = m_strErrorMsg;
    }


    /**
     * Gets the m_strHint value for this MObdCommonSCbsErrorMsg.
     * 
     * @return m_strHint
     */
    public java.lang.String getM_strHint() {
        return m_strHint;
    }


    /**
     * Sets the m_strHint value for this MObdCommonSCbsErrorMsg.
     * 
     * @param m_strHint
     */
    public void setM_strHint(java.lang.String m_strHint) {
        this.m_strHint = m_strHint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MObdCommonSCbsErrorMsg)) return false;
        MObdCommonSCbsErrorMsg other = (MObdCommonSCbsErrorMsg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iErrorCode==null && other.getM_iErrorCode()==null) || 
             (this.m_iErrorCode!=null &&
              this.m_iErrorCode.equals(other.getM_iErrorCode()))) &&
            ((this.m_strErrorMsg==null && other.getM_strErrorMsg()==null) || 
             (this.m_strErrorMsg!=null &&
              this.m_strErrorMsg.equals(other.getM_strErrorMsg()))) &&
            ((this.m_strHint==null && other.getM_strHint()==null) || 
             (this.m_strHint!=null &&
              this.m_strHint.equals(other.getM_strHint())));
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
        if (getM_iErrorCode() != null) {
            _hashCode += getM_iErrorCode().hashCode();
        }
        if (getM_strErrorMsg() != null) {
            _hashCode += getM_strErrorMsg().hashCode();
        }
        if (getM_strHint() != null) {
            _hashCode += getM_strHint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MObdCommonSCbsErrorMsg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iErrorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strErrorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strErrorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strHint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strHint"));
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
