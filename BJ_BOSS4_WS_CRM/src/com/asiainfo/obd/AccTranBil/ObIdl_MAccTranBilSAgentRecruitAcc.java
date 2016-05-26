/**
 * ObIdl_MAccTranBilSAgentRecruitAcc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAgentRecruitAcc  implements java.io.Serializable {
    private java.lang.Long m_llChannelId;

    private java.lang.String m_strBillId;

    private java.lang.String m_strAccId;

    private java.lang.Long m_llRecruitOverdrawAmt;

    private java.lang.Short m_nRecruitStatus;

    private java.lang.String m_dtmRecruitStDate;

    public ObIdl_MAccTranBilSAgentRecruitAcc() {
    }

    public ObIdl_MAccTranBilSAgentRecruitAcc(
           java.lang.Long m_llChannelId,
           java.lang.String m_strBillId,
           java.lang.String m_strAccId,
           java.lang.Long m_llRecruitOverdrawAmt,
           java.lang.Short m_nRecruitStatus,
           java.lang.String m_dtmRecruitStDate) {
           this.m_llChannelId = m_llChannelId;
           this.m_strBillId = m_strBillId;
           this.m_strAccId = m_strAccId;
           this.m_llRecruitOverdrawAmt = m_llRecruitOverdrawAmt;
           this.m_nRecruitStatus = m_nRecruitStatus;
           this.m_dtmRecruitStDate = m_dtmRecruitStDate;
    }


    /**
     * Gets the m_llChannelId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_llChannelId
     */
    public java.lang.Long getM_llChannelId() {
        return m_llChannelId;
    }


    /**
     * Sets the m_llChannelId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_llChannelId
     */
    public void setM_llChannelId(java.lang.Long m_llChannelId) {
        this.m_llChannelId = m_llChannelId;
    }


    /**
     * Gets the m_strBillId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_strBillId
     */
    public java.lang.String getM_strBillId() {
        return m_strBillId;
    }


    /**
     * Sets the m_strBillId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_strBillId
     */
    public void setM_strBillId(java.lang.String m_strBillId) {
        this.m_strBillId = m_strBillId;
    }


    /**
     * Gets the m_strAccId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_strAccId
     */
    public java.lang.String getM_strAccId() {
        return m_strAccId;
    }


    /**
     * Sets the m_strAccId value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_strAccId
     */
    public void setM_strAccId(java.lang.String m_strAccId) {
        this.m_strAccId = m_strAccId;
    }


    /**
     * Gets the m_llRecruitOverdrawAmt value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_llRecruitOverdrawAmt
     */
    public java.lang.Long getM_llRecruitOverdrawAmt() {
        return m_llRecruitOverdrawAmt;
    }


    /**
     * Sets the m_llRecruitOverdrawAmt value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_llRecruitOverdrawAmt
     */
    public void setM_llRecruitOverdrawAmt(java.lang.Long m_llRecruitOverdrawAmt) {
        this.m_llRecruitOverdrawAmt = m_llRecruitOverdrawAmt;
    }


    /**
     * Gets the m_nRecruitStatus value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_nRecruitStatus
     */
    public java.lang.Short getM_nRecruitStatus() {
        return m_nRecruitStatus;
    }


    /**
     * Sets the m_nRecruitStatus value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_nRecruitStatus
     */
    public void setM_nRecruitStatus(java.lang.Short m_nRecruitStatus) {
        this.m_nRecruitStatus = m_nRecruitStatus;
    }


    /**
     * Gets the m_dtmRecruitStDate value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @return m_dtmRecruitStDate
     */
    public java.lang.String getM_dtmRecruitStDate() {
        return m_dtmRecruitStDate;
    }


    /**
     * Sets the m_dtmRecruitStDate value for this ObIdl_MAccTranBilSAgentRecruitAcc.
     * 
     * @param m_dtmRecruitStDate
     */
    public void setM_dtmRecruitStDate(java.lang.String m_dtmRecruitStDate) {
        this.m_dtmRecruitStDate = m_dtmRecruitStDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAgentRecruitAcc)) return false;
        ObIdl_MAccTranBilSAgentRecruitAcc other = (ObIdl_MAccTranBilSAgentRecruitAcc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llChannelId==null && other.getM_llChannelId()==null) || 
             (this.m_llChannelId!=null &&
              this.m_llChannelId.equals(other.getM_llChannelId()))) &&
            ((this.m_strBillId==null && other.getM_strBillId()==null) || 
             (this.m_strBillId!=null &&
              this.m_strBillId.equals(other.getM_strBillId()))) &&
            ((this.m_strAccId==null && other.getM_strAccId()==null) || 
             (this.m_strAccId!=null &&
              this.m_strAccId.equals(other.getM_strAccId()))) &&
            ((this.m_llRecruitOverdrawAmt==null && other.getM_llRecruitOverdrawAmt()==null) || 
             (this.m_llRecruitOverdrawAmt!=null &&
              this.m_llRecruitOverdrawAmt.equals(other.getM_llRecruitOverdrawAmt()))) &&
            ((this.m_nRecruitStatus==null && other.getM_nRecruitStatus()==null) || 
             (this.m_nRecruitStatus!=null &&
              this.m_nRecruitStatus.equals(other.getM_nRecruitStatus()))) &&
            ((this.m_dtmRecruitStDate==null && other.getM_dtmRecruitStDate()==null) || 
             (this.m_dtmRecruitStDate!=null &&
              this.m_dtmRecruitStDate.equals(other.getM_dtmRecruitStDate())));
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
        if (getM_llChannelId() != null) {
            _hashCode += getM_llChannelId().hashCode();
        }
        if (getM_strBillId() != null) {
            _hashCode += getM_strBillId().hashCode();
        }
        if (getM_strAccId() != null) {
            _hashCode += getM_strAccId().hashCode();
        }
        if (getM_llRecruitOverdrawAmt() != null) {
            _hashCode += getM_llRecruitOverdrawAmt().hashCode();
        }
        if (getM_nRecruitStatus() != null) {
            _hashCode += getM_nRecruitStatus().hashCode();
        }
        if (getM_dtmRecruitStDate() != null) {
            _hashCode += getM_dtmRecruitStDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAgentRecruitAcc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentRecruitAcc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llChannelId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llChannelId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBillId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBillId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strAccId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strAccId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llRecruitOverdrawAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRecruitOverdrawAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nRecruitStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nRecruitStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmRecruitStDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmRecruitStDate"));
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
