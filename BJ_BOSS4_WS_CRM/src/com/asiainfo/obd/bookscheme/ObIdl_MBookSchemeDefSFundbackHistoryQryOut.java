/**
 * ObIdl_MBookSchemeDefSFundbackHistoryQryOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeDefSFundbackHistoryQryOut  implements java.io.Serializable {
    private java.lang.String m_strPaymentType;

    private java.lang.String m_strTotalAmount;

    private java.lang.String m_strMonthAmount;

    private java.lang.Short m_nAccountFlag;

    private java.lang.String m_strChargeBackTime;

    public ObIdl_MBookSchemeDefSFundbackHistoryQryOut() {
    }

    public ObIdl_MBookSchemeDefSFundbackHistoryQryOut(
           java.lang.String m_strPaymentType,
           java.lang.String m_strTotalAmount,
           java.lang.String m_strMonthAmount,
           java.lang.Short m_nAccountFlag,
           java.lang.String m_strChargeBackTime) {
           this.m_strPaymentType = m_strPaymentType;
           this.m_strTotalAmount = m_strTotalAmount;
           this.m_strMonthAmount = m_strMonthAmount;
           this.m_nAccountFlag = m_nAccountFlag;
           this.m_strChargeBackTime = m_strChargeBackTime;
    }


    /**
     * Gets the m_strPaymentType value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @return m_strPaymentType
     */
    public java.lang.String getM_strPaymentType() {
        return m_strPaymentType;
    }


    /**
     * Sets the m_strPaymentType value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @param m_strPaymentType
     */
    public void setM_strPaymentType(java.lang.String m_strPaymentType) {
        this.m_strPaymentType = m_strPaymentType;
    }


    /**
     * Gets the m_strTotalAmount value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @return m_strTotalAmount
     */
    public java.lang.String getM_strTotalAmount() {
        return m_strTotalAmount;
    }


    /**
     * Sets the m_strTotalAmount value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @param m_strTotalAmount
     */
    public void setM_strTotalAmount(java.lang.String m_strTotalAmount) {
        this.m_strTotalAmount = m_strTotalAmount;
    }


    /**
     * Gets the m_strMonthAmount value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @return m_strMonthAmount
     */
    public java.lang.String getM_strMonthAmount() {
        return m_strMonthAmount;
    }


    /**
     * Sets the m_strMonthAmount value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @param m_strMonthAmount
     */
    public void setM_strMonthAmount(java.lang.String m_strMonthAmount) {
        this.m_strMonthAmount = m_strMonthAmount;
    }


    /**
     * Gets the m_nAccountFlag value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @return m_nAccountFlag
     */
    public java.lang.Short getM_nAccountFlag() {
        return m_nAccountFlag;
    }


    /**
     * Sets the m_nAccountFlag value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @param m_nAccountFlag
     */
    public void setM_nAccountFlag(java.lang.Short m_nAccountFlag) {
        this.m_nAccountFlag = m_nAccountFlag;
    }


    /**
     * Gets the m_strChargeBackTime value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @return m_strChargeBackTime
     */
    public java.lang.String getM_strChargeBackTime() {
        return m_strChargeBackTime;
    }


    /**
     * Sets the m_strChargeBackTime value for this ObIdl_MBookSchemeDefSFundbackHistoryQryOut.
     * 
     * @param m_strChargeBackTime
     */
    public void setM_strChargeBackTime(java.lang.String m_strChargeBackTime) {
        this.m_strChargeBackTime = m_strChargeBackTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MBookSchemeDefSFundbackHistoryQryOut)) return false;
        ObIdl_MBookSchemeDefSFundbackHistoryQryOut other = (ObIdl_MBookSchemeDefSFundbackHistoryQryOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strPaymentType==null && other.getM_strPaymentType()==null) || 
             (this.m_strPaymentType!=null &&
              this.m_strPaymentType.equals(other.getM_strPaymentType()))) &&
            ((this.m_strTotalAmount==null && other.getM_strTotalAmount()==null) || 
             (this.m_strTotalAmount!=null &&
              this.m_strTotalAmount.equals(other.getM_strTotalAmount()))) &&
            ((this.m_strMonthAmount==null && other.getM_strMonthAmount()==null) || 
             (this.m_strMonthAmount!=null &&
              this.m_strMonthAmount.equals(other.getM_strMonthAmount()))) &&
            ((this.m_nAccountFlag==null && other.getM_nAccountFlag()==null) || 
             (this.m_nAccountFlag!=null &&
              this.m_nAccountFlag.equals(other.getM_nAccountFlag()))) &&
            ((this.m_strChargeBackTime==null && other.getM_strChargeBackTime()==null) || 
             (this.m_strChargeBackTime!=null &&
              this.m_strChargeBackTime.equals(other.getM_strChargeBackTime())));
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
        if (getM_strPaymentType() != null) {
            _hashCode += getM_strPaymentType().hashCode();
        }
        if (getM_strTotalAmount() != null) {
            _hashCode += getM_strTotalAmount().hashCode();
        }
        if (getM_strMonthAmount() != null) {
            _hashCode += getM_strMonthAmount().hashCode();
        }
        if (getM_nAccountFlag() != null) {
            _hashCode += getM_nAccountFlag().hashCode();
        }
        if (getM_strChargeBackTime() != null) {
            _hashCode += getM_strChargeBackTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MBookSchemeDefSFundbackHistoryQryOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SFundbackHistoryQryOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strTotalAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strTotalAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMonthAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMonthAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nAccountFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nAccountFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strChargeBackTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strChargeBackTime"));
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
