/**
 * ObIdl_MAccPrtInvDefSSpInvContentIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSSpInvContentIn  implements java.io.Serializable {
    private java.lang.Long m_llSoNbr;

    private java.lang.Long m_llAcctId;

    private java.lang.String m_strStartMonth;

    private java.lang.String m_strEndMonth;

    private java.lang.String m_strPayMonth;

    private java.lang.String m_strPhoneId;

    private java.lang.Short m_nIsAdCon;

    public ObIdl_MAccPrtInvDefSSpInvContentIn() {
    }

    public ObIdl_MAccPrtInvDefSSpInvContentIn(
           java.lang.Long m_llSoNbr,
           java.lang.Long m_llAcctId,
           java.lang.String m_strStartMonth,
           java.lang.String m_strEndMonth,
           java.lang.String m_strPayMonth,
           java.lang.String m_strPhoneId,
           java.lang.Short m_nIsAdCon) {
           this.m_llSoNbr = m_llSoNbr;
           this.m_llAcctId = m_llAcctId;
           this.m_strStartMonth = m_strStartMonth;
           this.m_strEndMonth = m_strEndMonth;
           this.m_strPayMonth = m_strPayMonth;
           this.m_strPhoneId = m_strPhoneId;
           this.m_nIsAdCon = m_nIsAdCon;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strStartMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_strStartMonth
     */
    public java.lang.String getM_strStartMonth() {
        return m_strStartMonth;
    }


    /**
     * Sets the m_strStartMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_strStartMonth
     */
    public void setM_strStartMonth(java.lang.String m_strStartMonth) {
        this.m_strStartMonth = m_strStartMonth;
    }


    /**
     * Gets the m_strEndMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_strEndMonth
     */
    public java.lang.String getM_strEndMonth() {
        return m_strEndMonth;
    }


    /**
     * Sets the m_strEndMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_strEndMonth
     */
    public void setM_strEndMonth(java.lang.String m_strEndMonth) {
        this.m_strEndMonth = m_strEndMonth;
    }


    /**
     * Gets the m_strPayMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_strPayMonth
     */
    public java.lang.String getM_strPayMonth() {
        return m_strPayMonth;
    }


    /**
     * Sets the m_strPayMonth value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_strPayMonth
     */
    public void setM_strPayMonth(java.lang.String m_strPayMonth) {
        this.m_strPayMonth = m_strPayMonth;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_nIsAdCon value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @return m_nIsAdCon
     */
    public java.lang.Short getM_nIsAdCon() {
        return m_nIsAdCon;
    }


    /**
     * Sets the m_nIsAdCon value for this ObIdl_MAccPrtInvDefSSpInvContentIn.
     * 
     * @param m_nIsAdCon
     */
    public void setM_nIsAdCon(java.lang.Short m_nIsAdCon) {
        this.m_nIsAdCon = m_nIsAdCon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSSpInvContentIn)) return false;
        ObIdl_MAccPrtInvDefSSpInvContentIn other = (ObIdl_MAccPrtInvDefSSpInvContentIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llSoNbr==null && other.getM_llSoNbr()==null) || 
             (this.m_llSoNbr!=null &&
              this.m_llSoNbr.equals(other.getM_llSoNbr()))) &&
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_strStartMonth==null && other.getM_strStartMonth()==null) || 
             (this.m_strStartMonth!=null &&
              this.m_strStartMonth.equals(other.getM_strStartMonth()))) &&
            ((this.m_strEndMonth==null && other.getM_strEndMonth()==null) || 
             (this.m_strEndMonth!=null &&
              this.m_strEndMonth.equals(other.getM_strEndMonth()))) &&
            ((this.m_strPayMonth==null && other.getM_strPayMonth()==null) || 
             (this.m_strPayMonth!=null &&
              this.m_strPayMonth.equals(other.getM_strPayMonth()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_nIsAdCon==null && other.getM_nIsAdCon()==null) || 
             (this.m_nIsAdCon!=null &&
              this.m_nIsAdCon.equals(other.getM_nIsAdCon())));
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
        if (getM_llSoNbr() != null) {
            _hashCode += getM_llSoNbr().hashCode();
        }
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_strStartMonth() != null) {
            _hashCode += getM_strStartMonth().hashCode();
        }
        if (getM_strEndMonth() != null) {
            _hashCode += getM_strEndMonth().hashCode();
        }
        if (getM_strPayMonth() != null) {
            _hashCode += getM_strPayMonth().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_nIsAdCon() != null) {
            _hashCode += getM_nIsAdCon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSSpInvContentIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContentIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strStartMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strStartMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strEndMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strEndMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPayMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPayMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("m_nIsAdCon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nIsAdCon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
