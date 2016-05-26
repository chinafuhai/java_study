/**
 * ObIdl_MAccTranBilSAccModiDateIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccModiDateIn  implements java.io.Serializable {
    private java.lang.Integer m_iRegionCode;

    private java.lang.Long m_llBookId;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    private java.lang.String m_strValidDate;

    private java.lang.String m_strExpireDate;

    private java.lang.Long m_llSoNbr;

    public ObIdl_MAccTranBilSAccModiDateIn() {
    }

    public ObIdl_MAccTranBilSAccModiDateIn(
           java.lang.Integer m_iRegionCode,
           java.lang.Long m_llBookId,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId,
           java.lang.String m_strValidDate,
           java.lang.String m_strExpireDate,
           java.lang.Long m_llSoNbr) {
           this.m_iRegionCode = m_iRegionCode;
           this.m_llBookId = m_llBookId;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
           this.m_strValidDate = m_strValidDate;
           this.m_strExpireDate = m_strExpireDate;
           this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_llBookId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_llBookId
     */
    public java.lang.Long getM_llBookId() {
        return m_llBookId;
    }


    /**
     * Sets the m_llBookId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_llBookId
     */
    public void setM_llBookId(java.lang.Long m_llBookId) {
        this.m_llBookId = m_llBookId;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_strValidDate value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_strValidDate
     */
    public java.lang.String getM_strValidDate() {
        return m_strValidDate;
    }


    /**
     * Sets the m_strValidDate value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_strValidDate
     */
    public void setM_strValidDate(java.lang.String m_strValidDate) {
        this.m_strValidDate = m_strValidDate;
    }


    /**
     * Gets the m_strExpireDate value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_strExpireDate
     */
    public java.lang.String getM_strExpireDate() {
        return m_strExpireDate;
    }


    /**
     * Sets the m_strExpireDate value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_strExpireDate
     */
    public void setM_strExpireDate(java.lang.String m_strExpireDate) {
        this.m_strExpireDate = m_strExpireDate;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccTranBilSAccModiDateIn.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccModiDateIn)) return false;
        ObIdl_MAccTranBilSAccModiDateIn other = (ObIdl_MAccTranBilSAccModiDateIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iRegionCode==null && other.getM_iRegionCode()==null) || 
             (this.m_iRegionCode!=null &&
              this.m_iRegionCode.equals(other.getM_iRegionCode()))) &&
            ((this.m_llBookId==null && other.getM_llBookId()==null) || 
             (this.m_llBookId!=null &&
              this.m_llBookId.equals(other.getM_llBookId()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_iSoOrgId==null && other.getM_iSoOrgId()==null) || 
             (this.m_iSoOrgId!=null &&
              this.m_iSoOrgId.equals(other.getM_iSoOrgId()))) &&
            ((this.m_strValidDate==null && other.getM_strValidDate()==null) || 
             (this.m_strValidDate!=null &&
              this.m_strValidDate.equals(other.getM_strValidDate()))) &&
            ((this.m_strExpireDate==null && other.getM_strExpireDate()==null) || 
             (this.m_strExpireDate!=null &&
              this.m_strExpireDate.equals(other.getM_strExpireDate()))) &&
            ((this.m_llSoNbr==null && other.getM_llSoNbr()==null) || 
             (this.m_llSoNbr!=null &&
              this.m_llSoNbr.equals(other.getM_llSoNbr())));
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
        if (getM_iRegionCode() != null) {
            _hashCode += getM_iRegionCode().hashCode();
        }
        if (getM_llBookId() != null) {
            _hashCode += getM_llBookId().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_iSoOrgId() != null) {
            _hashCode += getM_iSoOrgId().hashCode();
        }
        if (getM_strValidDate() != null) {
            _hashCode += getM_strValidDate().hashCode();
        }
        if (getM_strExpireDate() != null) {
            _hashCode += getM_strExpireDate().hashCode();
        }
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccModiDateIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccModiDateIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iSoOrgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iSoOrgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strValidDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strValidDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
