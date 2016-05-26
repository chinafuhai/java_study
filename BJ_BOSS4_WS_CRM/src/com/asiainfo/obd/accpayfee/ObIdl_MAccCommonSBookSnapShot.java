/**
 * ObIdl_MAccCommonSBookSnapShot.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSBookSnapShot  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Integer m_iRegionCode;

    private java.lang.Long m_llBookId;

    private java.lang.Long m_llBookItemId;

    private java.lang.Long m_llAmtUsed;

    private java.lang.Long m_llAmtOld;

    private java.lang.Integer m_iIsInv;

    private java.lang.Short m_nUseType;

    public ObIdl_MAccCommonSBookSnapShot() {
    }

    public ObIdl_MAccCommonSBookSnapShot(
           java.lang.Long m_llAcctId,
           java.lang.Integer m_iRegionCode,
           java.lang.Long m_llBookId,
           java.lang.Long m_llBookItemId,
           java.lang.Long m_llAmtUsed,
           java.lang.Long m_llAmtOld,
           java.lang.Integer m_iIsInv,
           java.lang.Short m_nUseType) {
           this.m_llAcctId = m_llAcctId;
           this.m_iRegionCode = m_iRegionCode;
           this.m_llBookId = m_llBookId;
           this.m_llBookItemId = m_llBookItemId;
           this.m_llAmtUsed = m_llAmtUsed;
           this.m_llAmtOld = m_llAmtOld;
           this.m_iIsInv = m_iIsInv;
           this.m_nUseType = m_nUseType;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_llBookId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_llBookId
     */
    public java.lang.Long getM_llBookId() {
        return m_llBookId;
    }


    /**
     * Sets the m_llBookId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_llBookId
     */
    public void setM_llBookId(java.lang.Long m_llBookId) {
        this.m_llBookId = m_llBookId;
    }


    /**
     * Gets the m_llBookItemId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_llBookItemId
     */
    public java.lang.Long getM_llBookItemId() {
        return m_llBookItemId;
    }


    /**
     * Sets the m_llBookItemId value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_llBookItemId
     */
    public void setM_llBookItemId(java.lang.Long m_llBookItemId) {
        this.m_llBookItemId = m_llBookItemId;
    }


    /**
     * Gets the m_llAmtUsed value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_llAmtUsed
     */
    public java.lang.Long getM_llAmtUsed() {
        return m_llAmtUsed;
    }


    /**
     * Sets the m_llAmtUsed value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_llAmtUsed
     */
    public void setM_llAmtUsed(java.lang.Long m_llAmtUsed) {
        this.m_llAmtUsed = m_llAmtUsed;
    }


    /**
     * Gets the m_llAmtOld value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_llAmtOld
     */
    public java.lang.Long getM_llAmtOld() {
        return m_llAmtOld;
    }


    /**
     * Sets the m_llAmtOld value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_llAmtOld
     */
    public void setM_llAmtOld(java.lang.Long m_llAmtOld) {
        this.m_llAmtOld = m_llAmtOld;
    }


    /**
     * Gets the m_iIsInv value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_iIsInv
     */
    public java.lang.Integer getM_iIsInv() {
        return m_iIsInv;
    }


    /**
     * Sets the m_iIsInv value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_iIsInv
     */
    public void setM_iIsInv(java.lang.Integer m_iIsInv) {
        this.m_iIsInv = m_iIsInv;
    }


    /**
     * Gets the m_nUseType value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @return m_nUseType
     */
    public java.lang.Short getM_nUseType() {
        return m_nUseType;
    }


    /**
     * Sets the m_nUseType value for this ObIdl_MAccCommonSBookSnapShot.
     * 
     * @param m_nUseType
     */
    public void setM_nUseType(java.lang.Short m_nUseType) {
        this.m_nUseType = m_nUseType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSBookSnapShot)) return false;
        ObIdl_MAccCommonSBookSnapShot other = (ObIdl_MAccCommonSBookSnapShot) obj;
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
            ((this.m_llBookId==null && other.getM_llBookId()==null) || 
             (this.m_llBookId!=null &&
              this.m_llBookId.equals(other.getM_llBookId()))) &&
            ((this.m_llBookItemId==null && other.getM_llBookItemId()==null) || 
             (this.m_llBookItemId!=null &&
              this.m_llBookItemId.equals(other.getM_llBookItemId()))) &&
            ((this.m_llAmtUsed==null && other.getM_llAmtUsed()==null) || 
             (this.m_llAmtUsed!=null &&
              this.m_llAmtUsed.equals(other.getM_llAmtUsed()))) &&
            ((this.m_llAmtOld==null && other.getM_llAmtOld()==null) || 
             (this.m_llAmtOld!=null &&
              this.m_llAmtOld.equals(other.getM_llAmtOld()))) &&
            ((this.m_iIsInv==null && other.getM_iIsInv()==null) || 
             (this.m_iIsInv!=null &&
              this.m_iIsInv.equals(other.getM_iIsInv()))) &&
            ((this.m_nUseType==null && other.getM_nUseType()==null) || 
             (this.m_nUseType!=null &&
              this.m_nUseType.equals(other.getM_nUseType())));
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
        if (getM_llBookId() != null) {
            _hashCode += getM_llBookId().hashCode();
        }
        if (getM_llBookItemId() != null) {
            _hashCode += getM_llBookItemId().hashCode();
        }
        if (getM_llAmtUsed() != null) {
            _hashCode += getM_llAmtUsed().hashCode();
        }
        if (getM_llAmtOld() != null) {
            _hashCode += getM_llAmtOld().hashCode();
        }
        if (getM_iIsInv() != null) {
            _hashCode += getM_iIsInv().hashCode();
        }
        if (getM_nUseType() != null) {
            _hashCode += getM_nUseType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSBookSnapShot.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShot"));
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
        elemField.setFieldName("m_llBookId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmtUsed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmtUsed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmtOld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmtOld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iIsInv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iIsInv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nUseType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nUseType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
