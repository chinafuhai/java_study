/**
 * ObIdl_MAccTranBilSRecruitAccCond.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSRecruitAccCond  implements java.io.Serializable {
    private java.lang.Short m_nOpType;

    private java.lang.String m_strMobileId;

    private java.lang.Long m_llOpFund;

    private java.lang.Long m_llSrcDonecode;

    private java.lang.Long m_llSrcSoNbr;

    private java.lang.Long m_llSoNbr;

    public ObIdl_MAccTranBilSRecruitAccCond() {
    }

    public ObIdl_MAccTranBilSRecruitAccCond(
           java.lang.Short m_nOpType,
           java.lang.String m_strMobileId,
           java.lang.Long m_llOpFund,
           java.lang.Long m_llSrcDonecode,
           java.lang.Long m_llSrcSoNbr,
           java.lang.Long m_llSoNbr) {
           this.m_nOpType = m_nOpType;
           this.m_strMobileId = m_strMobileId;
           this.m_llOpFund = m_llOpFund;
           this.m_llSrcDonecode = m_llSrcDonecode;
           this.m_llSrcSoNbr = m_llSrcSoNbr;
           this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_nOpType value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_nOpType
     */
    public java.lang.Short getM_nOpType() {
        return m_nOpType;
    }


    /**
     * Sets the m_nOpType value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_nOpType
     */
    public void setM_nOpType(java.lang.Short m_nOpType) {
        this.m_nOpType = m_nOpType;
    }


    /**
     * Gets the m_strMobileId value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_strMobileId
     */
    public java.lang.String getM_strMobileId() {
        return m_strMobileId;
    }


    /**
     * Sets the m_strMobileId value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_strMobileId
     */
    public void setM_strMobileId(java.lang.String m_strMobileId) {
        this.m_strMobileId = m_strMobileId;
    }


    /**
     * Gets the m_llOpFund value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_llOpFund
     */
    public java.lang.Long getM_llOpFund() {
        return m_llOpFund;
    }


    /**
     * Sets the m_llOpFund value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_llOpFund
     */
    public void setM_llOpFund(java.lang.Long m_llOpFund) {
        this.m_llOpFund = m_llOpFund;
    }


    /**
     * Gets the m_llSrcDonecode value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_llSrcDonecode
     */
    public java.lang.Long getM_llSrcDonecode() {
        return m_llSrcDonecode;
    }


    /**
     * Sets the m_llSrcDonecode value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_llSrcDonecode
     */
    public void setM_llSrcDonecode(java.lang.Long m_llSrcDonecode) {
        this.m_llSrcDonecode = m_llSrcDonecode;
    }


    /**
     * Gets the m_llSrcSoNbr value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_llSrcSoNbr
     */
    public java.lang.Long getM_llSrcSoNbr() {
        return m_llSrcSoNbr;
    }


    /**
     * Sets the m_llSrcSoNbr value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_llSrcSoNbr
     */
    public void setM_llSrcSoNbr(java.lang.Long m_llSrcSoNbr) {
        this.m_llSrcSoNbr = m_llSrcSoNbr;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccTranBilSRecruitAccCond.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSRecruitAccCond)) return false;
        ObIdl_MAccTranBilSRecruitAccCond other = (ObIdl_MAccTranBilSRecruitAccCond) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_nOpType==null && other.getM_nOpType()==null) || 
             (this.m_nOpType!=null &&
              this.m_nOpType.equals(other.getM_nOpType()))) &&
            ((this.m_strMobileId==null && other.getM_strMobileId()==null) || 
             (this.m_strMobileId!=null &&
              this.m_strMobileId.equals(other.getM_strMobileId()))) &&
            ((this.m_llOpFund==null && other.getM_llOpFund()==null) || 
             (this.m_llOpFund!=null &&
              this.m_llOpFund.equals(other.getM_llOpFund()))) &&
            ((this.m_llSrcDonecode==null && other.getM_llSrcDonecode()==null) || 
             (this.m_llSrcDonecode!=null &&
              this.m_llSrcDonecode.equals(other.getM_llSrcDonecode()))) &&
            ((this.m_llSrcSoNbr==null && other.getM_llSrcSoNbr()==null) || 
             (this.m_llSrcSoNbr!=null &&
              this.m_llSrcSoNbr.equals(other.getM_llSrcSoNbr()))) &&
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
        if (getM_nOpType() != null) {
            _hashCode += getM_nOpType().hashCode();
        }
        if (getM_strMobileId() != null) {
            _hashCode += getM_strMobileId().hashCode();
        }
        if (getM_llOpFund() != null) {
            _hashCode += getM_llOpFund().hashCode();
        }
        if (getM_llSrcDonecode() != null) {
            _hashCode += getM_llSrcDonecode().hashCode();
        }
        if (getM_llSrcSoNbr() != null) {
            _hashCode += getM_llSrcSoNbr().hashCode();
        }
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSRecruitAccCond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccCond"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nOpType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nOpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMobileId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMobileId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llOpFund");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llOpFund"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSrcDonecode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSrcDonecode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSrcSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSrcSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
