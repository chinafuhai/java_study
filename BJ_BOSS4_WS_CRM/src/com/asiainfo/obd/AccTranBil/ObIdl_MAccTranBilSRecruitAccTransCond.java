/**
 * ObIdl_MAccTranBilSRecruitAccTransCond.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSRecruitAccTransCond  implements java.io.Serializable {
    private java.lang.Short m_nOpType;

    private java.lang.String m_strMobileIdOut;

    private java.lang.String m_strMobileIdIn;

    private java.lang.Long m_llOpFund;

    private java.lang.Long m_llSoNbr;

    private java.lang.Long m_llSrcDonecode;

    private java.lang.Long m_llSrcSoNbr;

    public ObIdl_MAccTranBilSRecruitAccTransCond() {
    }

    public ObIdl_MAccTranBilSRecruitAccTransCond(
           java.lang.Short m_nOpType,
           java.lang.String m_strMobileIdOut,
           java.lang.String m_strMobileIdIn,
           java.lang.Long m_llOpFund,
           java.lang.Long m_llSoNbr,
           java.lang.Long m_llSrcDonecode,
           java.lang.Long m_llSrcSoNbr) {
           this.m_nOpType = m_nOpType;
           this.m_strMobileIdOut = m_strMobileIdOut;
           this.m_strMobileIdIn = m_strMobileIdIn;
           this.m_llOpFund = m_llOpFund;
           this.m_llSoNbr = m_llSoNbr;
           this.m_llSrcDonecode = m_llSrcDonecode;
           this.m_llSrcSoNbr = m_llSrcSoNbr;
    }


    /**
     * Gets the m_nOpType value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_nOpType
     */
    public java.lang.Short getM_nOpType() {
        return m_nOpType;
    }


    /**
     * Sets the m_nOpType value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_nOpType
     */
    public void setM_nOpType(java.lang.Short m_nOpType) {
        this.m_nOpType = m_nOpType;
    }


    /**
     * Gets the m_strMobileIdOut value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_strMobileIdOut
     */
    public java.lang.String getM_strMobileIdOut() {
        return m_strMobileIdOut;
    }


    /**
     * Sets the m_strMobileIdOut value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_strMobileIdOut
     */
    public void setM_strMobileIdOut(java.lang.String m_strMobileIdOut) {
        this.m_strMobileIdOut = m_strMobileIdOut;
    }


    /**
     * Gets the m_strMobileIdIn value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_strMobileIdIn
     */
    public java.lang.String getM_strMobileIdIn() {
        return m_strMobileIdIn;
    }


    /**
     * Sets the m_strMobileIdIn value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_strMobileIdIn
     */
    public void setM_strMobileIdIn(java.lang.String m_strMobileIdIn) {
        this.m_strMobileIdIn = m_strMobileIdIn;
    }


    /**
     * Gets the m_llOpFund value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_llOpFund
     */
    public java.lang.Long getM_llOpFund() {
        return m_llOpFund;
    }


    /**
     * Sets the m_llOpFund value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_llOpFund
     */
    public void setM_llOpFund(java.lang.Long m_llOpFund) {
        this.m_llOpFund = m_llOpFund;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_llSrcDonecode value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_llSrcDonecode
     */
    public java.lang.Long getM_llSrcDonecode() {
        return m_llSrcDonecode;
    }


    /**
     * Sets the m_llSrcDonecode value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_llSrcDonecode
     */
    public void setM_llSrcDonecode(java.lang.Long m_llSrcDonecode) {
        this.m_llSrcDonecode = m_llSrcDonecode;
    }


    /**
     * Gets the m_llSrcSoNbr value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @return m_llSrcSoNbr
     */
    public java.lang.Long getM_llSrcSoNbr() {
        return m_llSrcSoNbr;
    }


    /**
     * Sets the m_llSrcSoNbr value for this ObIdl_MAccTranBilSRecruitAccTransCond.
     * 
     * @param m_llSrcSoNbr
     */
    public void setM_llSrcSoNbr(java.lang.Long m_llSrcSoNbr) {
        this.m_llSrcSoNbr = m_llSrcSoNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSRecruitAccTransCond)) return false;
        ObIdl_MAccTranBilSRecruitAccTransCond other = (ObIdl_MAccTranBilSRecruitAccTransCond) obj;
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
            ((this.m_strMobileIdOut==null && other.getM_strMobileIdOut()==null) || 
             (this.m_strMobileIdOut!=null &&
              this.m_strMobileIdOut.equals(other.getM_strMobileIdOut()))) &&
            ((this.m_strMobileIdIn==null && other.getM_strMobileIdIn()==null) || 
             (this.m_strMobileIdIn!=null &&
              this.m_strMobileIdIn.equals(other.getM_strMobileIdIn()))) &&
            ((this.m_llOpFund==null && other.getM_llOpFund()==null) || 
             (this.m_llOpFund!=null &&
              this.m_llOpFund.equals(other.getM_llOpFund()))) &&
            ((this.m_llSoNbr==null && other.getM_llSoNbr()==null) || 
             (this.m_llSoNbr!=null &&
              this.m_llSoNbr.equals(other.getM_llSoNbr()))) &&
            ((this.m_llSrcDonecode==null && other.getM_llSrcDonecode()==null) || 
             (this.m_llSrcDonecode!=null &&
              this.m_llSrcDonecode.equals(other.getM_llSrcDonecode()))) &&
            ((this.m_llSrcSoNbr==null && other.getM_llSrcSoNbr()==null) || 
             (this.m_llSrcSoNbr!=null &&
              this.m_llSrcSoNbr.equals(other.getM_llSrcSoNbr())));
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
        if (getM_strMobileIdOut() != null) {
            _hashCode += getM_strMobileIdOut().hashCode();
        }
        if (getM_strMobileIdIn() != null) {
            _hashCode += getM_strMobileIdIn().hashCode();
        }
        if (getM_llOpFund() != null) {
            _hashCode += getM_llOpFund().hashCode();
        }
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        if (getM_llSrcDonecode() != null) {
            _hashCode += getM_llSrcDonecode().hashCode();
        }
        if (getM_llSrcSoNbr() != null) {
            _hashCode += getM_llSrcSoNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSRecruitAccTransCond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccTransCond"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nOpType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nOpType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMobileIdOut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMobileIdOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMobileIdIn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMobileIdIn"));
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
        elemField.setFieldName("m_llSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSoNbr"));
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
