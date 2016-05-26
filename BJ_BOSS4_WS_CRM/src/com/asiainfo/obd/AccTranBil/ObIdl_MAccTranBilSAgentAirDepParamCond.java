/**
 * ObIdl_MAccTranBilSAgentAirDepParamCond.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAgentAirDepParamCond  implements java.io.Serializable {
    private java.lang.Long m_llParamId;

    private java.lang.Short m_nParamType;

    private java.lang.Integer m_iChannelCity;

    private java.lang.Integer m_iRegionType;

    private java.lang.Integer m_iRegionDetail;

    private java.lang.Short m_nAgentLevel;

    private java.lang.Long m_llChannelId;

    public ObIdl_MAccTranBilSAgentAirDepParamCond() {
    }

    public ObIdl_MAccTranBilSAgentAirDepParamCond(
           java.lang.Long m_llParamId,
           java.lang.Short m_nParamType,
           java.lang.Integer m_iChannelCity,
           java.lang.Integer m_iRegionType,
           java.lang.Integer m_iRegionDetail,
           java.lang.Short m_nAgentLevel,
           java.lang.Long m_llChannelId) {
           this.m_llParamId = m_llParamId;
           this.m_nParamType = m_nParamType;
           this.m_iChannelCity = m_iChannelCity;
           this.m_iRegionType = m_iRegionType;
           this.m_iRegionDetail = m_iRegionDetail;
           this.m_nAgentLevel = m_nAgentLevel;
           this.m_llChannelId = m_llChannelId;
    }


    /**
     * Gets the m_llParamId value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_llParamId
     */
    public java.lang.Long getM_llParamId() {
        return m_llParamId;
    }


    /**
     * Sets the m_llParamId value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_llParamId
     */
    public void setM_llParamId(java.lang.Long m_llParamId) {
        this.m_llParamId = m_llParamId;
    }


    /**
     * Gets the m_nParamType value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_nParamType
     */
    public java.lang.Short getM_nParamType() {
        return m_nParamType;
    }


    /**
     * Sets the m_nParamType value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_nParamType
     */
    public void setM_nParamType(java.lang.Short m_nParamType) {
        this.m_nParamType = m_nParamType;
    }


    /**
     * Gets the m_iChannelCity value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_iChannelCity
     */
    public java.lang.Integer getM_iChannelCity() {
        return m_iChannelCity;
    }


    /**
     * Sets the m_iChannelCity value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_iChannelCity
     */
    public void setM_iChannelCity(java.lang.Integer m_iChannelCity) {
        this.m_iChannelCity = m_iChannelCity;
    }


    /**
     * Gets the m_iRegionType value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_iRegionType
     */
    public java.lang.Integer getM_iRegionType() {
        return m_iRegionType;
    }


    /**
     * Sets the m_iRegionType value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_iRegionType
     */
    public void setM_iRegionType(java.lang.Integer m_iRegionType) {
        this.m_iRegionType = m_iRegionType;
    }


    /**
     * Gets the m_iRegionDetail value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_iRegionDetail
     */
    public java.lang.Integer getM_iRegionDetail() {
        return m_iRegionDetail;
    }


    /**
     * Sets the m_iRegionDetail value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_iRegionDetail
     */
    public void setM_iRegionDetail(java.lang.Integer m_iRegionDetail) {
        this.m_iRegionDetail = m_iRegionDetail;
    }


    /**
     * Gets the m_nAgentLevel value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_nAgentLevel
     */
    public java.lang.Short getM_nAgentLevel() {
        return m_nAgentLevel;
    }


    /**
     * Sets the m_nAgentLevel value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_nAgentLevel
     */
    public void setM_nAgentLevel(java.lang.Short m_nAgentLevel) {
        this.m_nAgentLevel = m_nAgentLevel;
    }


    /**
     * Gets the m_llChannelId value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @return m_llChannelId
     */
    public java.lang.Long getM_llChannelId() {
        return m_llChannelId;
    }


    /**
     * Sets the m_llChannelId value for this ObIdl_MAccTranBilSAgentAirDepParamCond.
     * 
     * @param m_llChannelId
     */
    public void setM_llChannelId(java.lang.Long m_llChannelId) {
        this.m_llChannelId = m_llChannelId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAgentAirDepParamCond)) return false;
        ObIdl_MAccTranBilSAgentAirDepParamCond other = (ObIdl_MAccTranBilSAgentAirDepParamCond) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llParamId==null && other.getM_llParamId()==null) || 
             (this.m_llParamId!=null &&
              this.m_llParamId.equals(other.getM_llParamId()))) &&
            ((this.m_nParamType==null && other.getM_nParamType()==null) || 
             (this.m_nParamType!=null &&
              this.m_nParamType.equals(other.getM_nParamType()))) &&
            ((this.m_iChannelCity==null && other.getM_iChannelCity()==null) || 
             (this.m_iChannelCity!=null &&
              this.m_iChannelCity.equals(other.getM_iChannelCity()))) &&
            ((this.m_iRegionType==null && other.getM_iRegionType()==null) || 
             (this.m_iRegionType!=null &&
              this.m_iRegionType.equals(other.getM_iRegionType()))) &&
            ((this.m_iRegionDetail==null && other.getM_iRegionDetail()==null) || 
             (this.m_iRegionDetail!=null &&
              this.m_iRegionDetail.equals(other.getM_iRegionDetail()))) &&
            ((this.m_nAgentLevel==null && other.getM_nAgentLevel()==null) || 
             (this.m_nAgentLevel!=null &&
              this.m_nAgentLevel.equals(other.getM_nAgentLevel()))) &&
            ((this.m_llChannelId==null && other.getM_llChannelId()==null) || 
             (this.m_llChannelId!=null &&
              this.m_llChannelId.equals(other.getM_llChannelId())));
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
        if (getM_llParamId() != null) {
            _hashCode += getM_llParamId().hashCode();
        }
        if (getM_nParamType() != null) {
            _hashCode += getM_nParamType().hashCode();
        }
        if (getM_iChannelCity() != null) {
            _hashCode += getM_iChannelCity().hashCode();
        }
        if (getM_iRegionType() != null) {
            _hashCode += getM_iRegionType().hashCode();
        }
        if (getM_iRegionDetail() != null) {
            _hashCode += getM_iRegionDetail().hashCode();
        }
        if (getM_nAgentLevel() != null) {
            _hashCode += getM_nAgentLevel().hashCode();
        }
        if (getM_llChannelId() != null) {
            _hashCode += getM_llChannelId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAgentAirDepParamCond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepParamCond"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llParamId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llParamId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nParamType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nParamType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iChannelCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iChannelCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iRegionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iRegionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iRegionDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iRegionDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nAgentLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nAgentLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llChannelId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llChannelId"));
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
