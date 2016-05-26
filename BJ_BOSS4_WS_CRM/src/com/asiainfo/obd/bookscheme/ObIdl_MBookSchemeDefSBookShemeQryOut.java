/**
 * ObIdl_MBookSchemeDefSBookShemeQryOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSBookShemeQryOut  implements java.io.Serializable {
    private java.lang.String m_strPhoneId;

    private java.lang.String m_strPaymentType;

    private java.lang.String m_strPaymentName;

    private java.lang.String m_strCreateTime;

    private java.lang.String m_strBrand;

    private com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee[] m_listListBookSchemeFee;

    private java.lang.String m_strRemark;

    public ObIdl_MBookSchemeDefSBookShemeQryOut() {
    }

    public ObIdl_MBookSchemeDefSBookShemeQryOut(
           java.lang.String m_strPhoneId,
           java.lang.String m_strPaymentType,
           java.lang.String m_strPaymentName,
           java.lang.String m_strCreateTime,
           java.lang.String m_strBrand,
           com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee[] m_listListBookSchemeFee,
           java.lang.String m_strRemark) {
           this.m_strPhoneId = m_strPhoneId;
           this.m_strPaymentType = m_strPaymentType;
           this.m_strPaymentName = m_strPaymentName;
           this.m_strCreateTime = m_strCreateTime;
           this.m_strBrand = m_strBrand;
           this.m_listListBookSchemeFee = m_listListBookSchemeFee;
           this.m_strRemark = m_strRemark;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_strPaymentName value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strPaymentName
     */
    public java.lang.String getM_strPaymentName() {
        return m_strPaymentName;
    }


    /**
     * Sets the m_strPaymentName value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strPaymentName
     */
    public void setM_strPaymentName(java.lang.String m_strPaymentName) {
        this.m_strPaymentName = m_strPaymentName;
    }


    /**
     * Gets the m_strCreateTime value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strCreateTime
     */
    public java.lang.String getM_strCreateTime() {
        return m_strCreateTime;
    }


    /**
     * Sets the m_strCreateTime value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strCreateTime
     */
    public void setM_strCreateTime(java.lang.String m_strCreateTime) {
        this.m_strCreateTime = m_strCreateTime;
    }


    /**
     * Gets the m_strBrand value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strBrand
     */
    public java.lang.String getM_strBrand() {
        return m_strBrand;
    }


    /**
     * Sets the m_strBrand value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strBrand
     */
    public void setM_strBrand(java.lang.String m_strBrand) {
        this.m_strBrand = m_strBrand;
    }


    /**
     * Gets the m_listListBookSchemeFee value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_listListBookSchemeFee
     */
    public com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee[] getM_listListBookSchemeFee() {
        return m_listListBookSchemeFee;
    }


    /**
     * Sets the m_listListBookSchemeFee value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_listListBookSchemeFee
     */
    public void setM_listListBookSchemeFee(com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee[] m_listListBookSchemeFee) {
        this.m_listListBookSchemeFee = m_listListBookSchemeFee;
    }


    /**
     * Gets the m_strRemark value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @return m_strRemark
     */
    public java.lang.String getM_strRemark() {
        return m_strRemark;
    }


    /**
     * Sets the m_strRemark value for this ObIdl_MBookSchemeDefSBookShemeQryOut.
     * 
     * @param m_strRemark
     */
    public void setM_strRemark(java.lang.String m_strRemark) {
        this.m_strRemark = m_strRemark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSBookShemeQryOut)) return false;
        ObIdl_MBookSchemeDefSBookShemeQryOut other = (ObIdl_MBookSchemeDefSBookShemeQryOut) obj;
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
            ((this.m_strPaymentType==null && other.getM_strPaymentType()==null) || 
             (this.m_strPaymentType!=null &&
              this.m_strPaymentType.equals(other.getM_strPaymentType()))) &&
            ((this.m_strPaymentName==null && other.getM_strPaymentName()==null) || 
             (this.m_strPaymentName!=null &&
              this.m_strPaymentName.equals(other.getM_strPaymentName()))) &&
            ((this.m_strCreateTime==null && other.getM_strCreateTime()==null) || 
             (this.m_strCreateTime!=null &&
              this.m_strCreateTime.equals(other.getM_strCreateTime()))) &&
            ((this.m_strBrand==null && other.getM_strBrand()==null) || 
             (this.m_strBrand!=null &&
              this.m_strBrand.equals(other.getM_strBrand()))) &&
            ((this.m_listListBookSchemeFee==null && other.getM_listListBookSchemeFee()==null) || 
             (this.m_listListBookSchemeFee!=null &&
              java.util.Arrays.equals(this.m_listListBookSchemeFee, other.getM_listListBookSchemeFee()))) &&
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
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_strPaymentType() != null) {
            _hashCode += getM_strPaymentType().hashCode();
        }
        if (getM_strPaymentName() != null) {
            _hashCode += getM_strPaymentName().hashCode();
        }
        if (getM_strCreateTime() != null) {
            _hashCode += getM_strCreateTime().hashCode();
        }
        if (getM_strBrand() != null) {
            _hashCode += getM_strBrand().hashCode();
        }
        if (getM_listListBookSchemeFee() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listListBookSchemeFee());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listListBookSchemeFee(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_strRemark() != null) {
            _hashCode += getM_strRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSBookShemeQryOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeQryOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCreateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCreateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listListBookSchemeFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listListBookSchemeFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFee"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
