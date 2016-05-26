/**
 * ObIdl_MAccTranBilSAccTranBilIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccTranBilIn  implements java.io.Serializable {
    private java.lang.Short m_nBusiType;

    private java.lang.Long m_llSoNbr;

    private java.lang.String m_strOutSoNbr;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    private java.lang.String m_strRemark;

    private ObIdl_MAccTranBilSAccTranAcct[] m_listTranAcctList;

    public ObIdl_MAccTranBilSAccTranBilIn() {
    }

    public ObIdl_MAccTranBilSAccTranBilIn(
           java.lang.Short m_nBusiType,
           java.lang.Long m_llSoNbr,
           java.lang.String m_strOutSoNbr,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId,
           java.lang.String m_strRemark,
           ObIdl_MAccTranBilSAccTranAcct[] m_listTranAcctList) {
           this.m_nBusiType = m_nBusiType;
           this.m_llSoNbr = m_llSoNbr;
           this.m_strOutSoNbr = m_strOutSoNbr;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
           this.m_strRemark = m_strRemark;
           this.m_listTranAcctList = m_listTranAcctList;
    }


    /**
     * Gets the m_nBusiType value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_nBusiType
     */
    public java.lang.Short getM_nBusiType() {
        return m_nBusiType;
    }


    /**
     * Sets the m_nBusiType value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_nBusiType
     */
    public void setM_nBusiType(java.lang.Short m_nBusiType) {
        this.m_nBusiType = m_nBusiType;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_strOutSoNbr value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_strOutSoNbr
     */
    public java.lang.String getM_strOutSoNbr() {
        return m_strOutSoNbr;
    }


    /**
     * Sets the m_strOutSoNbr value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_strOutSoNbr
     */
    public void setM_strOutSoNbr(java.lang.String m_strOutSoNbr) {
        this.m_strOutSoNbr = m_strOutSoNbr;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_strRemark value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_strRemark
     */
    public java.lang.String getM_strRemark() {
        return m_strRemark;
    }


    /**
     * Sets the m_strRemark value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_strRemark
     */
    public void setM_strRemark(java.lang.String m_strRemark) {
        this.m_strRemark = m_strRemark;
    }


    /**
     * Gets the m_listTranAcctList value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @return m_listTranAcctList
     */
    public ObIdl_MAccTranBilSAccTranAcct[] getM_listTranAcctList() {
        return m_listTranAcctList;
    }


    /**
     * Sets the m_listTranAcctList value for this ObIdl_MAccTranBilSAccTranBilIn.
     * 
     * @param m_listTranAcctList
     */
    public void setM_listTranAcctList(ObIdl_MAccTranBilSAccTranAcct[] m_listTranAcctList) {
        this.m_listTranAcctList = m_listTranAcctList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccTranBilIn)) return false;
        ObIdl_MAccTranBilSAccTranBilIn other = (ObIdl_MAccTranBilSAccTranBilIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_nBusiType==null && other.getM_nBusiType()==null) || 
             (this.m_nBusiType!=null &&
              this.m_nBusiType.equals(other.getM_nBusiType()))) &&
            ((this.m_llSoNbr==null && other.getM_llSoNbr()==null) || 
             (this.m_llSoNbr!=null &&
              this.m_llSoNbr.equals(other.getM_llSoNbr()))) &&
            ((this.m_strOutSoNbr==null && other.getM_strOutSoNbr()==null) || 
             (this.m_strOutSoNbr!=null &&
              this.m_strOutSoNbr.equals(other.getM_strOutSoNbr()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_iSoOrgId==null && other.getM_iSoOrgId()==null) || 
             (this.m_iSoOrgId!=null &&
              this.m_iSoOrgId.equals(other.getM_iSoOrgId()))) &&
            ((this.m_strRemark==null && other.getM_strRemark()==null) || 
             (this.m_strRemark!=null &&
              this.m_strRemark.equals(other.getM_strRemark()))) &&
            ((this.m_listTranAcctList==null && other.getM_listTranAcctList()==null) || 
             (this.m_listTranAcctList!=null &&
              java.util.Arrays.equals(this.m_listTranAcctList, other.getM_listTranAcctList())));
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
        if (getM_nBusiType() != null) {
            _hashCode += getM_nBusiType().hashCode();
        }
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        if (getM_strOutSoNbr() != null) {
            _hashCode += getM_strOutSoNbr().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_iSoOrgId() != null) {
            _hashCode += getM_iSoOrgId().hashCode();
        }
        if (getM_strRemark() != null) {
            _hashCode += getM_strRemark().hashCode();
        }
        if (getM_listTranAcctList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listTranAcctList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listTranAcctList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccTranBilIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBilIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBusiType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBusiType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
        elemField.setFieldName("m_strOutSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOutSoNbr"));
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
        elemField.setFieldName("m_strRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listTranAcctList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listTranAcctList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranAcct"));
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
