/**
 * ObIdl_MAccTranBilSUnpn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSUnpn  implements java.io.Serializable {
    private java.lang.String m_strPhoneId;

    private java.lang.Short m_nUnpnFlag;

    private java.lang.String m_strRemarks;

    public ObIdl_MAccTranBilSUnpn() {
    }

    public ObIdl_MAccTranBilSUnpn(
           java.lang.String m_strPhoneId,
           java.lang.Short m_nUnpnFlag,
           java.lang.String m_strRemarks) {
           this.m_strPhoneId = m_strPhoneId;
           this.m_nUnpnFlag = m_nUnpnFlag;
           this.m_strRemarks = m_strRemarks;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_nUnpnFlag value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @return m_nUnpnFlag
     */
    public java.lang.Short getM_nUnpnFlag() {
        return m_nUnpnFlag;
    }


    /**
     * Sets the m_nUnpnFlag value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @param m_nUnpnFlag
     */
    public void setM_nUnpnFlag(java.lang.Short m_nUnpnFlag) {
        this.m_nUnpnFlag = m_nUnpnFlag;
    }


    /**
     * Gets the m_strRemarks value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @return m_strRemarks
     */
    public java.lang.String getM_strRemarks() {
        return m_strRemarks;
    }


    /**
     * Sets the m_strRemarks value for this ObIdl_MAccTranBilSUnpn.
     * 
     * @param m_strRemarks
     */
    public void setM_strRemarks(java.lang.String m_strRemarks) {
        this.m_strRemarks = m_strRemarks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSUnpn)) return false;
        ObIdl_MAccTranBilSUnpn other = (ObIdl_MAccTranBilSUnpn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_nUnpnFlag==null && other.getM_nUnpnFlag()==null) || 
             (this.m_nUnpnFlag!=null &&
              this.m_nUnpnFlag.equals(other.getM_nUnpnFlag()))) &&
            ((this.m_strRemarks==null && other.getM_strRemarks()==null) || 
             (this.m_strRemarks!=null &&
              this.m_strRemarks.equals(other.getM_strRemarks())));
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
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_nUnpnFlag() != null) {
            _hashCode += getM_nUnpnFlag().hashCode();
        }
        if (getM_strRemarks() != null) {
            _hashCode += getM_strRemarks().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSUnpn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nUnpnFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nUnpnFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strRemarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemarks"));
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
