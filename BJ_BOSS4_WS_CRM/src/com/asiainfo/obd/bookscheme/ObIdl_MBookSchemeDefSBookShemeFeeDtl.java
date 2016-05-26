/**
 * ObIdl_MBookSchemeDefSBookShemeFeeDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSBookShemeFeeDtl  implements java.io.Serializable {
    private java.lang.Long m_llAmount;

    private java.lang.Long m_llRemainAmount;

    private java.lang.Long m_llRemainMonth;

    private java.lang.String m_strOperTime;

    private java.lang.String m_strRemark;

    public ObIdl_MBookSchemeDefSBookShemeFeeDtl() {
    }

    public ObIdl_MBookSchemeDefSBookShemeFeeDtl(
           java.lang.Long m_llAmount,
           java.lang.Long m_llRemainAmount,
           java.lang.Long m_llRemainMonth,
           java.lang.String m_strOperTime,
           java.lang.String m_strRemark) {
           this.m_llAmount = m_llAmount;
           this.m_llRemainAmount = m_llRemainAmount;
           this.m_llRemainMonth = m_llRemainMonth;
           this.m_strOperTime = m_strOperTime;
           this.m_strRemark = m_strRemark;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_llRemainAmount value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @return m_llRemainAmount
     */
    public java.lang.Long getM_llRemainAmount() {
        return m_llRemainAmount;
    }


    /**
     * Sets the m_llRemainAmount value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @param m_llRemainAmount
     */
    public void setM_llRemainAmount(java.lang.Long m_llRemainAmount) {
        this.m_llRemainAmount = m_llRemainAmount;
    }


    /**
     * Gets the m_llRemainMonth value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @return m_llRemainMonth
     */
    public java.lang.Long getM_llRemainMonth() {
        return m_llRemainMonth;
    }


    /**
     * Sets the m_llRemainMonth value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @param m_llRemainMonth
     */
    public void setM_llRemainMonth(java.lang.Long m_llRemainMonth) {
        this.m_llRemainMonth = m_llRemainMonth;
    }


    /**
     * Gets the m_strOperTime value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @return m_strOperTime
     */
    public java.lang.String getM_strOperTime() {
        return m_strOperTime;
    }


    /**
     * Sets the m_strOperTime value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @param m_strOperTime
     */
    public void setM_strOperTime(java.lang.String m_strOperTime) {
        this.m_strOperTime = m_strOperTime;
    }


    /**
     * Gets the m_strRemark value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @return m_strRemark
     */
    public java.lang.String getM_strRemark() {
        return m_strRemark;
    }


    /**
     * Sets the m_strRemark value for this ObIdl_MBookSchemeDefSBookShemeFeeDtl.
     * 
     * @param m_strRemark
     */
    public void setM_strRemark(java.lang.String m_strRemark) {
        this.m_strRemark = m_strRemark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSBookShemeFeeDtl)) return false;
        ObIdl_MBookSchemeDefSBookShemeFeeDtl other = (ObIdl_MBookSchemeDefSBookShemeFeeDtl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llAmount==null && other.getM_llAmount()==null) || 
             (this.m_llAmount!=null &&
              this.m_llAmount.equals(other.getM_llAmount()))) &&
            ((this.m_llRemainAmount==null && other.getM_llRemainAmount()==null) || 
             (this.m_llRemainAmount!=null &&
              this.m_llRemainAmount.equals(other.getM_llRemainAmount()))) &&
            ((this.m_llRemainMonth==null && other.getM_llRemainMonth()==null) || 
             (this.m_llRemainMonth!=null &&
              this.m_llRemainMonth.equals(other.getM_llRemainMonth()))) &&
            ((this.m_strOperTime==null && other.getM_strOperTime()==null) || 
             (this.m_strOperTime!=null &&
              this.m_strOperTime.equals(other.getM_strOperTime()))) &&
            ((this.m_strRemark==null && other.getM_strRemark()==null) || 
             (this.m_strRemark!=null &&
              this.m_strRemark.equals(other.getM_strRemark())));
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
        if (getM_llAmount() != null) {
            _hashCode += getM_llAmount().hashCode();
        }
        if (getM_llRemainAmount() != null) {
            _hashCode += getM_llRemainAmount().hashCode();
        }
        if (getM_llRemainMonth() != null) {
            _hashCode += getM_llRemainMonth().hashCode();
        }
        if (getM_strOperTime() != null) {
            _hashCode += getM_strOperTime().hashCode();
        }
        if (getM_strRemark() != null) {
            _hashCode += getM_strRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSBookShemeFeeDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFeeDtl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llRemainAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRemainAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llRemainMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRemainMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strOperTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOperTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemark"));
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
