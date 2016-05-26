/**
 * ObIdl_MAccTranBilSPayCreditBookIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSPayCreditBookIn  implements java.io.Serializable {
    private java.lang.String m_strPhoneId;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    private java.lang.String m_strOtherNbr;

    private java.lang.Short m_nBusiType;

    private java.lang.Long m_llPaidAmount;

    public ObIdl_MAccTranBilSPayCreditBookIn() {
    }

    public ObIdl_MAccTranBilSPayCreditBookIn(
           java.lang.String m_strPhoneId,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId,
           java.lang.String m_strOtherNbr,
           java.lang.Short m_nBusiType,
           java.lang.Long m_llPaidAmount) {
           this.m_strPhoneId = m_strPhoneId;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
           this.m_strOtherNbr = m_strOtherNbr;
           this.m_nBusiType = m_nBusiType;
           this.m_llPaidAmount = m_llPaidAmount;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_strOtherNbr value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_strOtherNbr
     */
    public java.lang.String getM_strOtherNbr() {
        return m_strOtherNbr;
    }


    /**
     * Sets the m_strOtherNbr value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_strOtherNbr
     */
    public void setM_strOtherNbr(java.lang.String m_strOtherNbr) {
        this.m_strOtherNbr = m_strOtherNbr;
    }


    /**
     * Gets the m_nBusiType value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_nBusiType
     */
    public java.lang.Short getM_nBusiType() {
        return m_nBusiType;
    }


    /**
     * Sets the m_nBusiType value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_nBusiType
     */
    public void setM_nBusiType(java.lang.Short m_nBusiType) {
        this.m_nBusiType = m_nBusiType;
    }


    /**
     * Gets the m_llPaidAmount value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @return m_llPaidAmount
     */
    public java.lang.Long getM_llPaidAmount() {
        return m_llPaidAmount;
    }


    /**
     * Sets the m_llPaidAmount value for this ObIdl_MAccTranBilSPayCreditBookIn.
     * 
     * @param m_llPaidAmount
     */
    public void setM_llPaidAmount(java.lang.Long m_llPaidAmount) {
        this.m_llPaidAmount = m_llPaidAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSPayCreditBookIn)) return false;
        ObIdl_MAccTranBilSPayCreditBookIn other = (ObIdl_MAccTranBilSPayCreditBookIn) obj;
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
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_iSoOrgId==null && other.getM_iSoOrgId()==null) || 
             (this.m_iSoOrgId!=null &&
              this.m_iSoOrgId.equals(other.getM_iSoOrgId()))) &&
            ((this.m_strOtherNbr==null && other.getM_strOtherNbr()==null) || 
             (this.m_strOtherNbr!=null &&
              this.m_strOtherNbr.equals(other.getM_strOtherNbr()))) &&
            ((this.m_nBusiType==null && other.getM_nBusiType()==null) || 
             (this.m_nBusiType!=null &&
              this.m_nBusiType.equals(other.getM_nBusiType()))) &&
            ((this.m_llPaidAmount==null && other.getM_llPaidAmount()==null) || 
             (this.m_llPaidAmount!=null &&
              this.m_llPaidAmount.equals(other.getM_llPaidAmount())));
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
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_iSoOrgId() != null) {
            _hashCode += getM_iSoOrgId().hashCode();
        }
        if (getM_strOtherNbr() != null) {
            _hashCode += getM_strOtherNbr().hashCode();
        }
        if (getM_nBusiType() != null) {
            _hashCode += getM_nBusiType().hashCode();
        }
        if (getM_llPaidAmount() != null) {
            _hashCode += getM_llPaidAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSPayCreditBookIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("m_strOtherNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOtherNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBusiType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBusiType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPaidAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPaidAmount"));
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
