/**
 * ObIdl_MAccPrtInvDefSInvcQryInSpdb.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSInvcQryInSpdb  implements java.io.Serializable {
    private java.lang.String m_strOtherSoNbr;

    private java.lang.Integer m_iBusiType;

    private java.lang.String m_strSoNbr;

    private java.lang.String m_strMonth;

    private java.lang.String m_strPhoneId;

    private java.lang.Short m_nInvcType;

    private java.lang.String m_strReserve;

    public ObIdl_MAccPrtInvDefSInvcQryInSpdb() {
    }

    public ObIdl_MAccPrtInvDefSInvcQryInSpdb(
           java.lang.String m_strOtherSoNbr,
           java.lang.Integer m_iBusiType,
           java.lang.String m_strSoNbr,
           java.lang.String m_strMonth,
           java.lang.String m_strPhoneId,
           java.lang.Short m_nInvcType,
           java.lang.String m_strReserve) {
           this.m_strOtherSoNbr = m_strOtherSoNbr;
           this.m_iBusiType = m_iBusiType;
           this.m_strSoNbr = m_strSoNbr;
           this.m_strMonth = m_strMonth;
           this.m_strPhoneId = m_strPhoneId;
           this.m_nInvcType = m_nInvcType;
           this.m_strReserve = m_strReserve;
    }


    /**
     * Gets the m_strOtherSoNbr value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_strOtherSoNbr
     */
    public java.lang.String getM_strOtherSoNbr() {
        return m_strOtherSoNbr;
    }


    /**
     * Sets the m_strOtherSoNbr value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_strOtherSoNbr
     */
    public void setM_strOtherSoNbr(java.lang.String m_strOtherSoNbr) {
        this.m_strOtherSoNbr = m_strOtherSoNbr;
    }


    /**
     * Gets the m_iBusiType value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_iBusiType
     */
    public java.lang.Integer getM_iBusiType() {
        return m_iBusiType;
    }


    /**
     * Sets the m_iBusiType value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_iBusiType
     */
    public void setM_iBusiType(java.lang.Integer m_iBusiType) {
        this.m_iBusiType = m_iBusiType;
    }


    /**
     * Gets the m_strSoNbr value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_strSoNbr
     */
    public java.lang.String getM_strSoNbr() {
        return m_strSoNbr;
    }


    /**
     * Sets the m_strSoNbr value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_strSoNbr
     */
    public void setM_strSoNbr(java.lang.String m_strSoNbr) {
        this.m_strSoNbr = m_strSoNbr;
    }


    /**
     * Gets the m_strMonth value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_strMonth
     */
    public java.lang.String getM_strMonth() {
        return m_strMonth;
    }


    /**
     * Sets the m_strMonth value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_strMonth
     */
    public void setM_strMonth(java.lang.String m_strMonth) {
        this.m_strMonth = m_strMonth;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_nInvcType value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_nInvcType
     */
    public java.lang.Short getM_nInvcType() {
        return m_nInvcType;
    }


    /**
     * Sets the m_nInvcType value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_nInvcType
     */
    public void setM_nInvcType(java.lang.Short m_nInvcType) {
        this.m_nInvcType = m_nInvcType;
    }


    /**
     * Gets the m_strReserve value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @return m_strReserve
     */
    public java.lang.String getM_strReserve() {
        return m_strReserve;
    }


    /**
     * Sets the m_strReserve value for this ObIdl_MAccPrtInvDefSInvcQryInSpdb.
     * 
     * @param m_strReserve
     */
    public void setM_strReserve(java.lang.String m_strReserve) {
        this.m_strReserve = m_strReserve;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSInvcQryInSpdb)) return false;
        ObIdl_MAccPrtInvDefSInvcQryInSpdb other = (ObIdl_MAccPrtInvDefSInvcQryInSpdb) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strOtherSoNbr==null && other.getM_strOtherSoNbr()==null) || 
             (this.m_strOtherSoNbr!=null &&
              this.m_strOtherSoNbr.equals(other.getM_strOtherSoNbr()))) &&
            ((this.m_iBusiType==null && other.getM_iBusiType()==null) || 
             (this.m_iBusiType!=null &&
              this.m_iBusiType.equals(other.getM_iBusiType()))) &&
            ((this.m_strSoNbr==null && other.getM_strSoNbr()==null) || 
             (this.m_strSoNbr!=null &&
              this.m_strSoNbr.equals(other.getM_strSoNbr()))) &&
            ((this.m_strMonth==null && other.getM_strMonth()==null) || 
             (this.m_strMonth!=null &&
              this.m_strMonth.equals(other.getM_strMonth()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_nInvcType==null && other.getM_nInvcType()==null) || 
             (this.m_nInvcType!=null &&
              this.m_nInvcType.equals(other.getM_nInvcType()))) &&
            ((this.m_strReserve==null && other.getM_strReserve()==null) || 
             (this.m_strReserve!=null &&
              this.m_strReserve.equals(other.getM_strReserve())));
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
        if (getM_strOtherSoNbr() != null) {
            _hashCode += getM_strOtherSoNbr().hashCode();
        }
        if (getM_iBusiType() != null) {
            _hashCode += getM_iBusiType().hashCode();
        }
        if (getM_strSoNbr() != null) {
            _hashCode += getM_strSoNbr().hashCode();
        }
        if (getM_strMonth() != null) {
            _hashCode += getM_strMonth().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_nInvcType() != null) {
            _hashCode += getM_nInvcType().hashCode();
        }
        if (getM_strReserve() != null) {
            _hashCode += getM_strReserve().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSInvcQryInSpdb.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcQryInSpdb"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strOtherSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOtherSoNbr"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMonth"));
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
        elemField.setFieldName("m_nInvcType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nInvcType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReserve");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReserve"));
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
