/**
 * ObIdl_MBusiChargeDefSReceiptAdjustReason.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MBusiChargeDefSReceiptAdjustReason  implements java.io.Serializable {
    private java.lang.Long m_llInvcNumSeq;

    private java.lang.Integer m_iReasonType;

    private java.lang.String m_strReasonDesc;

    private java.lang.String m_strReserve;

    public ObIdl_MBusiChargeDefSReceiptAdjustReason() {
    }

    public ObIdl_MBusiChargeDefSReceiptAdjustReason(
           java.lang.Long m_llInvcNumSeq,
           java.lang.Integer m_iReasonType,
           java.lang.String m_strReasonDesc,
           java.lang.String m_strReserve) {
           this.m_llInvcNumSeq = m_llInvcNumSeq;
           this.m_iReasonType = m_iReasonType;
           this.m_strReasonDesc = m_strReasonDesc;
           this.m_strReserve = m_strReserve;
    }


    /**
     * Gets the m_llInvcNumSeq value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @return m_llInvcNumSeq
     */
    public java.lang.Long getM_llInvcNumSeq() {
        return m_llInvcNumSeq;
    }


    /**
     * Sets the m_llInvcNumSeq value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @param m_llInvcNumSeq
     */
    public void setM_llInvcNumSeq(java.lang.Long m_llInvcNumSeq) {
        this.m_llInvcNumSeq = m_llInvcNumSeq;
    }


    /**
     * Gets the m_iReasonType value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @return m_iReasonType
     */
    public java.lang.Integer getM_iReasonType() {
        return m_iReasonType;
    }


    /**
     * Sets the m_iReasonType value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @param m_iReasonType
     */
    public void setM_iReasonType(java.lang.Integer m_iReasonType) {
        this.m_iReasonType = m_iReasonType;
    }


    /**
     * Gets the m_strReasonDesc value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @return m_strReasonDesc
     */
    public java.lang.String getM_strReasonDesc() {
        return m_strReasonDesc;
    }


    /**
     * Sets the m_strReasonDesc value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @param m_strReasonDesc
     */
    public void setM_strReasonDesc(java.lang.String m_strReasonDesc) {
        this.m_strReasonDesc = m_strReasonDesc;
    }


    /**
     * Gets the m_strReserve value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @return m_strReserve
     */
    public java.lang.String getM_strReserve() {
        return m_strReserve;
    }


    /**
     * Sets the m_strReserve value for this ObIdl_MBusiChargeDefSReceiptAdjustReason.
     * 
     * @param m_strReserve
     */
    public void setM_strReserve(java.lang.String m_strReserve) {
        this.m_strReserve = m_strReserve;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBusiChargeDefSReceiptAdjustReason)) return false;
        ObIdl_MBusiChargeDefSReceiptAdjustReason other = (ObIdl_MBusiChargeDefSReceiptAdjustReason) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llInvcNumSeq==null && other.getM_llInvcNumSeq()==null) || 
             (this.m_llInvcNumSeq!=null &&
              this.m_llInvcNumSeq.equals(other.getM_llInvcNumSeq()))) &&
            ((this.m_iReasonType==null && other.getM_iReasonType()==null) || 
             (this.m_iReasonType!=null &&
              this.m_iReasonType.equals(other.getM_iReasonType()))) &&
            ((this.m_strReasonDesc==null && other.getM_strReasonDesc()==null) || 
             (this.m_strReasonDesc!=null &&
              this.m_strReasonDesc.equals(other.getM_strReasonDesc()))) &&
            ((this.m_strReserve==null && other.getM_strReserve()==null) || 
             (this.m_strReserve!=null &&
              this.m_strReserve.equals(other.getM_strReserve())));
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
        if (getM_llInvcNumSeq() != null) {
            _hashCode += getM_llInvcNumSeq().hashCode();
        }
        if (getM_iReasonType() != null) {
            _hashCode += getM_iReasonType().hashCode();
        }
        if (getM_strReasonDesc() != null) {
            _hashCode += getM_strReasonDesc().hashCode();
        }
        if (getM_strReserve() != null) {
            _hashCode += getM_strReserve().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBusiChargeDefSReceiptAdjustReason.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SReceiptAdjustReason"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvcNumSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvcNumSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iReasonType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iReasonType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("m_strReserve");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReserve"));
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
