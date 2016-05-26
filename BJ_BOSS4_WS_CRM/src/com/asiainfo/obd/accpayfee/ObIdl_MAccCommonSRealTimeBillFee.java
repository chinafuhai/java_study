/**
 * ObIdl_MAccCommonSRealTimeBillFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSRealTimeBillFee  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Integer m_iBillItemId;

    private java.lang.String m_strItemName;

    private java.lang.Long m_llTotalBillFee;

    private java.lang.Long m_llTotalWoffFee;

    private ObIdl_MAccCommonSRealTimeFee[] m_listRealTimeFeeList;

    public ObIdl_MAccCommonSRealTimeBillFee() {
    }

    public ObIdl_MAccCommonSRealTimeBillFee(
           java.lang.Long m_llAcctId,
           java.lang.Integer m_iBillItemId,
           java.lang.String m_strItemName,
           java.lang.Long m_llTotalBillFee,
           java.lang.Long m_llTotalWoffFee,
           ObIdl_MAccCommonSRealTimeFee[] m_listRealTimeFeeList) {
           this.m_llAcctId = m_llAcctId;
           this.m_iBillItemId = m_iBillItemId;
           this.m_strItemName = m_strItemName;
           this.m_llTotalBillFee = m_llTotalBillFee;
           this.m_llTotalWoffFee = m_llTotalWoffFee;
           this.m_listRealTimeFeeList = m_listRealTimeFeeList;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_iBillItemId value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_iBillItemId
     */
    public java.lang.Integer getM_iBillItemId() {
        return m_iBillItemId;
    }


    /**
     * Sets the m_iBillItemId value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_iBillItemId
     */
    public void setM_iBillItemId(java.lang.Integer m_iBillItemId) {
        this.m_iBillItemId = m_iBillItemId;
    }


    /**
     * Gets the m_strItemName value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_strItemName
     */
    public java.lang.String getM_strItemName() {
        return m_strItemName;
    }


    /**
     * Sets the m_strItemName value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_strItemName
     */
    public void setM_strItemName(java.lang.String m_strItemName) {
        this.m_strItemName = m_strItemName;
    }


    /**
     * Gets the m_llTotalBillFee value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_llTotalBillFee
     */
    public java.lang.Long getM_llTotalBillFee() {
        return m_llTotalBillFee;
    }


    /**
     * Sets the m_llTotalBillFee value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_llTotalBillFee
     */
    public void setM_llTotalBillFee(java.lang.Long m_llTotalBillFee) {
        this.m_llTotalBillFee = m_llTotalBillFee;
    }


    /**
     * Gets the m_llTotalWoffFee value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_llTotalWoffFee
     */
    public java.lang.Long getM_llTotalWoffFee() {
        return m_llTotalWoffFee;
    }


    /**
     * Sets the m_llTotalWoffFee value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_llTotalWoffFee
     */
    public void setM_llTotalWoffFee(java.lang.Long m_llTotalWoffFee) {
        this.m_llTotalWoffFee = m_llTotalWoffFee;
    }


    /**
     * Gets the m_listRealTimeFeeList value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @return m_listRealTimeFeeList
     */
    public ObIdl_MAccCommonSRealTimeFee[] getM_listRealTimeFeeList() {
        return m_listRealTimeFeeList;
    }


    /**
     * Sets the m_listRealTimeFeeList value for this ObIdl_MAccCommonSRealTimeBillFee.
     * 
     * @param m_listRealTimeFeeList
     */
    public void setM_listRealTimeFeeList(ObIdl_MAccCommonSRealTimeFee[] m_listRealTimeFeeList) {
        this.m_listRealTimeFeeList = m_listRealTimeFeeList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSRealTimeBillFee)) return false;
        ObIdl_MAccCommonSRealTimeBillFee other = (ObIdl_MAccCommonSRealTimeBillFee) obj;
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
            ((this.m_iBillItemId==null && other.getM_iBillItemId()==null) || 
             (this.m_iBillItemId!=null &&
              this.m_iBillItemId.equals(other.getM_iBillItemId()))) &&
            ((this.m_strItemName==null && other.getM_strItemName()==null) || 
             (this.m_strItemName!=null &&
              this.m_strItemName.equals(other.getM_strItemName()))) &&
            ((this.m_llTotalBillFee==null && other.getM_llTotalBillFee()==null) || 
             (this.m_llTotalBillFee!=null &&
              this.m_llTotalBillFee.equals(other.getM_llTotalBillFee()))) &&
            ((this.m_llTotalWoffFee==null && other.getM_llTotalWoffFee()==null) || 
             (this.m_llTotalWoffFee!=null &&
              this.m_llTotalWoffFee.equals(other.getM_llTotalWoffFee()))) &&
            ((this.m_listRealTimeFeeList==null && other.getM_listRealTimeFeeList()==null) || 
             (this.m_listRealTimeFeeList!=null &&
              java.util.Arrays.equals(this.m_listRealTimeFeeList, other.getM_listRealTimeFeeList())));
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
        if (getM_iBillItemId() != null) {
            _hashCode += getM_iBillItemId().hashCode();
        }
        if (getM_strItemName() != null) {
            _hashCode += getM_strItemName().hashCode();
        }
        if (getM_llTotalBillFee() != null) {
            _hashCode += getM_llTotalBillFee().hashCode();
        }
        if (getM_llTotalWoffFee() != null) {
            _hashCode += getM_llTotalWoffFee().hashCode();
        }
        if (getM_listRealTimeFeeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listRealTimeFeeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listRealTimeFeeList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSRealTimeBillFee.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFee"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBillItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBillItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strItemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strItemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalBillFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalBillFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalWoffFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalWoffFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listRealTimeFeeList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listRealTimeFeeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFee"));
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
