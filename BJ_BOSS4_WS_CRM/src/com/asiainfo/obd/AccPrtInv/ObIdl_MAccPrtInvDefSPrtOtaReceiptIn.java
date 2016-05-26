/**
 * ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSPrtOtaReceiptIn  implements java.io.Serializable {
    private java.lang.Integer m_iOpId;

    private java.lang.String m_strBeginDate;

    private java.lang.String m_strEndDate;

    private java.lang.String m_strCustomerName;

    private java.lang.Integer m_iBusiType;

    public ObIdl_MAccPrtInvDefSPrtOtaReceiptIn() {
    }

    public ObIdl_MAccPrtInvDefSPrtOtaReceiptIn(
           java.lang.Integer m_iOpId,
           java.lang.String m_strBeginDate,
           java.lang.String m_strEndDate,
           java.lang.String m_strCustomerName,
           java.lang.Integer m_iBusiType) {
           this.m_iOpId = m_iOpId;
           this.m_strBeginDate = m_strBeginDate;
           this.m_strEndDate = m_strEndDate;
           this.m_strCustomerName = m_strCustomerName;
           this.m_iBusiType = m_iBusiType;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_strBeginDate value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @return m_strBeginDate
     */
    public java.lang.String getM_strBeginDate() {
        return m_strBeginDate;
    }


    /**
     * Sets the m_strBeginDate value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @param m_strBeginDate
     */
    public void setM_strBeginDate(java.lang.String m_strBeginDate) {
        this.m_strBeginDate = m_strBeginDate;
    }


    /**
     * Gets the m_strEndDate value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @return m_strEndDate
     */
    public java.lang.String getM_strEndDate() {
        return m_strEndDate;
    }


    /**
     * Sets the m_strEndDate value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @param m_strEndDate
     */
    public void setM_strEndDate(java.lang.String m_strEndDate) {
        this.m_strEndDate = m_strEndDate;
    }


    /**
     * Gets the m_strCustomerName value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @return m_strCustomerName
     */
    public java.lang.String getM_strCustomerName() {
        return m_strCustomerName;
    }


    /**
     * Sets the m_strCustomerName value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @param m_strCustomerName
     */
    public void setM_strCustomerName(java.lang.String m_strCustomerName) {
        this.m_strCustomerName = m_strCustomerName;
    }


    /**
     * Gets the m_iBusiType value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @return m_iBusiType
     */
    public java.lang.Integer getM_iBusiType() {
        return m_iBusiType;
    }


    /**
     * Sets the m_iBusiType value for this ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.
     * 
     * @param m_iBusiType
     */
    public void setM_iBusiType(java.lang.Integer m_iBusiType) {
        this.m_iBusiType = m_iBusiType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSPrtOtaReceiptIn)) return false;
        ObIdl_MAccPrtInvDefSPrtOtaReceiptIn other = (ObIdl_MAccPrtInvDefSPrtOtaReceiptIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_strBeginDate==null && other.getM_strBeginDate()==null) || 
             (this.m_strBeginDate!=null &&
              this.m_strBeginDate.equals(other.getM_strBeginDate()))) &&
            ((this.m_strEndDate==null && other.getM_strEndDate()==null) || 
             (this.m_strEndDate!=null &&
              this.m_strEndDate.equals(other.getM_strEndDate()))) &&
            ((this.m_strCustomerName==null && other.getM_strCustomerName()==null) || 
             (this.m_strCustomerName!=null &&
              this.m_strCustomerName.equals(other.getM_strCustomerName()))) &&
            ((this.m_iBusiType==null && other.getM_iBusiType()==null) || 
             (this.m_iBusiType!=null &&
              this.m_iBusiType.equals(other.getM_iBusiType())));
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
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_strBeginDate() != null) {
            _hashCode += getM_strBeginDate().hashCode();
        }
        if (getM_strEndDate() != null) {
            _hashCode += getM_strEndDate().hashCode();
        }
        if (getM_strCustomerName() != null) {
            _hashCode += getM_strCustomerName().hashCode();
        }
        if (getM_iBusiType() != null) {
            _hashCode += getM_iBusiType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrtOtaReceiptIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBeginDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBeginDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCustomerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustomerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBusiType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBusiType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
