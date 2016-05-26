/**
 * ObIdl_MAccPrtInvDefSInvcUpdCond.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSInvcUpdCond  implements java.io.Serializable {
    private java.lang.Long m_llInvcNumSeq;

    private java.lang.String m_strOtherSoNbr;

    private java.lang.String m_strPhoneId;

    private java.lang.Long m_llCustId;

    private java.lang.Short m_nInvcType;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    public ObIdl_MAccPrtInvDefSInvcUpdCond() {
    }

    public ObIdl_MAccPrtInvDefSInvcUpdCond(
           java.lang.Long m_llInvcNumSeq,
           java.lang.String m_strOtherSoNbr,
           java.lang.String m_strPhoneId,
           java.lang.Long m_llCustId,
           java.lang.Short m_nInvcType,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId) {
           this.m_llInvcNumSeq = m_llInvcNumSeq;
           this.m_strOtherSoNbr = m_strOtherSoNbr;
           this.m_strPhoneId = m_strPhoneId;
           this.m_llCustId = m_llCustId;
           this.m_nInvcType = m_nInvcType;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_llInvcNumSeq value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_llInvcNumSeq
     */
    public java.lang.Long getM_llInvcNumSeq() {
        return m_llInvcNumSeq;
    }


    /**
     * Sets the m_llInvcNumSeq value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_llInvcNumSeq
     */
    public void setM_llInvcNumSeq(java.lang.Long m_llInvcNumSeq) {
        this.m_llInvcNumSeq = m_llInvcNumSeq;
    }


    /**
     * Gets the m_strOtherSoNbr value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_strOtherSoNbr
     */
    public java.lang.String getM_strOtherSoNbr() {
        return m_strOtherSoNbr;
    }


    /**
     * Sets the m_strOtherSoNbr value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_strOtherSoNbr
     */
    public void setM_strOtherSoNbr(java.lang.String m_strOtherSoNbr) {
        this.m_strOtherSoNbr = m_strOtherSoNbr;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_llCustId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_llCustId
     */
    public java.lang.Long getM_llCustId() {
        return m_llCustId;
    }


    /**
     * Sets the m_llCustId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_llCustId
     */
    public void setM_llCustId(java.lang.Long m_llCustId) {
        this.m_llCustId = m_llCustId;
    }


    /**
     * Gets the m_nInvcType value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_nInvcType
     */
    public java.lang.Short getM_nInvcType() {
        return m_nInvcType;
    }


    /**
     * Sets the m_nInvcType value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_nInvcType
     */
    public void setM_nInvcType(java.lang.Short m_nInvcType) {
        this.m_nInvcType = m_nInvcType;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccPrtInvDefSInvcUpdCond.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSInvcUpdCond)) return false;
        ObIdl_MAccPrtInvDefSInvcUpdCond other = (ObIdl_MAccPrtInvDefSInvcUpdCond) obj;
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
            ((this.m_strOtherSoNbr==null && other.getM_strOtherSoNbr()==null) || 
             (this.m_strOtherSoNbr!=null &&
              this.m_strOtherSoNbr.equals(other.getM_strOtherSoNbr()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_llCustId==null && other.getM_llCustId()==null) || 
             (this.m_llCustId!=null &&
              this.m_llCustId.equals(other.getM_llCustId()))) &&
            ((this.m_nInvcType==null && other.getM_nInvcType()==null) || 
             (this.m_nInvcType!=null &&
              this.m_nInvcType.equals(other.getM_nInvcType()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_iSoOrgId==null && other.getM_iSoOrgId()==null) || 
             (this.m_iSoOrgId!=null &&
              this.m_iSoOrgId.equals(other.getM_iSoOrgId())));
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
        if (getM_strOtherSoNbr() != null) {
            _hashCode += getM_strOtherSoNbr().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_llCustId() != null) {
            _hashCode += getM_llCustId().hashCode();
        }
        if (getM_nInvcType() != null) {
            _hashCode += getM_nInvcType().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_iSoOrgId() != null) {
            _hashCode += getM_iSoOrgId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSInvcUpdCond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcUpdCond"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvcNumSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvcNumSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strOtherSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOtherSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCustId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCustId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nInvcType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nInvcType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iSoOrgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iSoOrgId"));
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
