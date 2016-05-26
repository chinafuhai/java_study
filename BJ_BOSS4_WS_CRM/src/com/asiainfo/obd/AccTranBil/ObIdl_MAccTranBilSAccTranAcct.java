/**
 * ObIdl_MAccTranBilSAccTranAcct.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccTranAcct  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Integer m_iRegionCode;

    private java.lang.String m_strPhoneId;

    private java.lang.Integer m_iIsReal;

    private ObIdl_MAccTranBilSAccTranBookDtl[] m_listAdjBookDtlList;

    public ObIdl_MAccTranBilSAccTranAcct() {
    }

    public ObIdl_MAccTranBilSAccTranAcct(
           java.lang.Long m_llAcctId,
           java.lang.Integer m_iRegionCode,
           java.lang.String m_strPhoneId,
           java.lang.Integer m_iIsReal,
           ObIdl_MAccTranBilSAccTranBookDtl[] m_listAdjBookDtlList) {
           this.m_llAcctId = m_llAcctId;
           this.m_iRegionCode = m_iRegionCode;
           this.m_strPhoneId = m_strPhoneId;
           this.m_iIsReal = m_iIsReal;
           this.m_listAdjBookDtlList = m_listAdjBookDtlList;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_iRegionCode value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @return m_iRegionCode
     */
    public java.lang.Integer getM_iRegionCode() {
        return m_iRegionCode;
    }


    /**
     * Sets the m_iRegionCode value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @param m_iRegionCode
     */
    public void setM_iRegionCode(java.lang.Integer m_iRegionCode) {
        this.m_iRegionCode = m_iRegionCode;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_iIsReal value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @return m_iIsReal
     */
    public java.lang.Integer getM_iIsReal() {
        return m_iIsReal;
    }


    /**
     * Sets the m_iIsReal value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @param m_iIsReal
     */
    public void setM_iIsReal(java.lang.Integer m_iIsReal) {
        this.m_iIsReal = m_iIsReal;
    }


    /**
     * Gets the m_listAdjBookDtlList value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @return m_listAdjBookDtlList
     */
    public ObIdl_MAccTranBilSAccTranBookDtl[] getM_listAdjBookDtlList() {
        return m_listAdjBookDtlList;
    }


    /**
     * Sets the m_listAdjBookDtlList value for this ObIdl_MAccTranBilSAccTranAcct.
     * 
     * @param m_listAdjBookDtlList
     */
    public void setM_listAdjBookDtlList(ObIdl_MAccTranBilSAccTranBookDtl[] m_listAdjBookDtlList) {
        this.m_listAdjBookDtlList = m_listAdjBookDtlList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccTranAcct)) return false;
        ObIdl_MAccTranBilSAccTranAcct other = (ObIdl_MAccTranBilSAccTranAcct) obj;
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
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_iIsReal==null && other.getM_iIsReal()==null) || 
             (this.m_iIsReal!=null &&
              this.m_iIsReal.equals(other.getM_iIsReal()))) &&
            ((this.m_listAdjBookDtlList==null && other.getM_listAdjBookDtlList()==null) || 
             (this.m_listAdjBookDtlList!=null &&
              java.util.Arrays.equals(this.m_listAdjBookDtlList, other.getM_listAdjBookDtlList())));
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
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_iIsReal() != null) {
            _hashCode += getM_iIsReal().hashCode();
        }
        if (getM_listAdjBookDtlList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listAdjBookDtlList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listAdjBookDtlList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccTranAcct.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranAcct"));
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
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iIsReal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iIsReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listAdjBookDtlList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listAdjBookDtlList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBookDtl"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
