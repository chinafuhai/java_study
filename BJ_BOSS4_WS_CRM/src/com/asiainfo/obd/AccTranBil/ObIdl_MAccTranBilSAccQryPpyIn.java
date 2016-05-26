/**
 * ObIdl_MAccTranBilSAccQryPpyIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccQryPpyIn  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Integer m_iRegionCode;

    private java.lang.Integer m_iFlag;

    private java.lang.Integer m_iIsReal;

    public ObIdl_MAccTranBilSAccQryPpyIn() {
    }

    public ObIdl_MAccTranBilSAccQryPpyIn(
           java.lang.Long m_llAcctId,
           java.lang.Integer m_iRegionCode,
           java.lang.Integer m_iFlag,
           java.lang.Integer m_iIsReal) {
           this.m_llAcctId = m_llAcctId;
           this.m_iRegionCode = m_iRegionCode;
           this.m_iFlag = m_iFlag;
           this.m_iIsReal = m_iIsReal;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_iFlag value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @return m_iFlag
     */
    public java.lang.Integer getM_iFlag() {
        return m_iFlag;
    }


    /**
     * Sets the m_iFlag value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @param m_iFlag
     */
    public void setM_iFlag(java.lang.Integer m_iFlag) {
        this.m_iFlag = m_iFlag;
    }


    /**
     * Gets the m_iIsReal value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @return m_iIsReal
     */
    public java.lang.Integer getM_iIsReal() {
        return m_iIsReal;
    }


    /**
     * Sets the m_iIsReal value for this ObIdl_MAccTranBilSAccQryPpyIn.
     * 
     * @param m_iIsReal
     */
    public void setM_iIsReal(java.lang.Integer m_iIsReal) {
        this.m_iIsReal = m_iIsReal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccQryPpyIn)) return false;
        ObIdl_MAccTranBilSAccQryPpyIn other = (ObIdl_MAccTranBilSAccQryPpyIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_iRegionCode==null && other.getM_iRegionCode()==null) || 
             (this.m_iRegionCode!=null &&
              this.m_iRegionCode.equals(other.getM_iRegionCode()))) &&
            ((this.m_iFlag==null && other.getM_iFlag()==null) || 
             (this.m_iFlag!=null &&
              this.m_iFlag.equals(other.getM_iFlag()))) &&
            ((this.m_iIsReal==null && other.getM_iIsReal()==null) || 
             (this.m_iIsReal!=null &&
              this.m_iIsReal.equals(other.getM_iIsReal())));
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
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_iRegionCode() != null) {
            _hashCode += getM_iRegionCode().hashCode();
        }
        if (getM_iFlag() != null) {
            _hashCode += getM_iFlag().hashCode();
        }
        if (getM_iIsReal() != null) {
            _hashCode += getM_iIsReal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccQryPpyIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iIsReal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iIsReal"));
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
