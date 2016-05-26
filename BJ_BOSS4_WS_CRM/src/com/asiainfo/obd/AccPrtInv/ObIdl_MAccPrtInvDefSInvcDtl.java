/**
 * ObIdl_MAccPrtInvDefSInvcDtl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class ObIdl_MAccPrtInvDefSInvcDtl  implements java.io.Serializable {
    private java.lang.Long m_llSoNbr;

    private java.lang.Long m_llSeqNbr;

    private java.lang.String m_dtmPrintTime;

    private java.lang.Long m_llOpId;

    private java.lang.String m_strReason;

    private java.lang.String m_strInvoiceId;

    private java.lang.Long m_llInvoiceNo;

    public ObIdl_MAccPrtInvDefSInvcDtl() {
    }

    public ObIdl_MAccPrtInvDefSInvcDtl(
           java.lang.Long m_llSoNbr,
           java.lang.Long m_llSeqNbr,
           java.lang.String m_dtmPrintTime,
           java.lang.Long m_llOpId,
           java.lang.String m_strReason,
           java.lang.String m_strInvoiceId,
           java.lang.Long m_llInvoiceNo) {
           this.m_llSoNbr = m_llSoNbr;
           this.m_llSeqNbr = m_llSeqNbr;
           this.m_dtmPrintTime = m_dtmPrintTime;
           this.m_llOpId = m_llOpId;
           this.m_strReason = m_strReason;
           this.m_strInvoiceId = m_strInvoiceId;
           this.m_llInvoiceNo = m_llInvoiceNo;
    }


    /**
     * Gets the m_llSoNbr value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_llSoNbr
     */
    public java.lang.Long getM_llSoNbr() {
        return m_llSoNbr;
    }


    /**
     * Sets the m_llSoNbr value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_llSoNbr
     */
    public void setM_llSoNbr(java.lang.Long m_llSoNbr) {
        this.m_llSoNbr = m_llSoNbr;
    }


    /**
     * Gets the m_llSeqNbr value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_llSeqNbr
     */
    public java.lang.Long getM_llSeqNbr() {
        return m_llSeqNbr;
    }


    /**
     * Sets the m_llSeqNbr value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_llSeqNbr
     */
    public void setM_llSeqNbr(java.lang.Long m_llSeqNbr) {
        this.m_llSeqNbr = m_llSeqNbr;
    }


    /**
     * Gets the m_dtmPrintTime value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_dtmPrintTime
     */
    public java.lang.String getM_dtmPrintTime() {
        return m_dtmPrintTime;
    }


    /**
     * Sets the m_dtmPrintTime value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_dtmPrintTime
     */
    public void setM_dtmPrintTime(java.lang.String m_dtmPrintTime) {
        this.m_dtmPrintTime = m_dtmPrintTime;
    }


    /**
     * Gets the m_llOpId value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_llOpId
     */
    public java.lang.Long getM_llOpId() {
        return m_llOpId;
    }


    /**
     * Sets the m_llOpId value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_llOpId
     */
    public void setM_llOpId(java.lang.Long m_llOpId) {
        this.m_llOpId = m_llOpId;
    }


    /**
     * Gets the m_strReason value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_strReason
     */
    public java.lang.String getM_strReason() {
        return m_strReason;
    }


    /**
     * Sets the m_strReason value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_strReason
     */
    public void setM_strReason(java.lang.String m_strReason) {
        this.m_strReason = m_strReason;
    }


    /**
     * Gets the m_strInvoiceId value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_strInvoiceId
     */
    public java.lang.String getM_strInvoiceId() {
        return m_strInvoiceId;
    }


    /**
     * Sets the m_strInvoiceId value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_strInvoiceId
     */
    public void setM_strInvoiceId(java.lang.String m_strInvoiceId) {
        this.m_strInvoiceId = m_strInvoiceId;
    }


    /**
     * Gets the m_llInvoiceNo value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @return m_llInvoiceNo
     */
    public java.lang.Long getM_llInvoiceNo() {
        return m_llInvoiceNo;
    }


    /**
     * Sets the m_llInvoiceNo value for this ObIdl_MAccPrtInvDefSInvcDtl.
     * 
     * @param m_llInvoiceNo
     */
    public void setM_llInvoiceNo(java.lang.Long m_llInvoiceNo) {
        this.m_llInvoiceNo = m_llInvoiceNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccPrtInvDefSInvcDtl)) return false;
        ObIdl_MAccPrtInvDefSInvcDtl other = (ObIdl_MAccPrtInvDefSInvcDtl) obj;
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
            ((this.m_llSeqNbr==null && other.getM_llSeqNbr()==null) || 
             (this.m_llSeqNbr!=null &&
              this.m_llSeqNbr.equals(other.getM_llSeqNbr()))) &&
            ((this.m_dtmPrintTime==null && other.getM_dtmPrintTime()==null) || 
             (this.m_dtmPrintTime!=null &&
              this.m_dtmPrintTime.equals(other.getM_dtmPrintTime()))) &&
            ((this.m_llOpId==null && other.getM_llOpId()==null) || 
             (this.m_llOpId!=null &&
              this.m_llOpId.equals(other.getM_llOpId()))) &&
            ((this.m_strReason==null && other.getM_strReason()==null) || 
             (this.m_strReason!=null &&
              this.m_strReason.equals(other.getM_strReason()))) &&
            ((this.m_strInvoiceId==null && other.getM_strInvoiceId()==null) || 
             (this.m_strInvoiceId!=null &&
              this.m_strInvoiceId.equals(other.getM_strInvoiceId()))) &&
            ((this.m_llInvoiceNo==null && other.getM_llInvoiceNo()==null) || 
             (this.m_llInvoiceNo!=null &&
              this.m_llInvoiceNo.equals(other.getM_llInvoiceNo())));
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
        if (getM_llSeqNbr() != null) {
            _hashCode += getM_llSeqNbr().hashCode();
        }
        if (getM_dtmPrintTime() != null) {
            _hashCode += getM_dtmPrintTime().hashCode();
        }
        if (getM_llOpId() != null) {
            _hashCode += getM_llOpId().hashCode();
        }
        if (getM_strReason() != null) {
            _hashCode += getM_strReason().hashCode();
        }
        if (getM_strInvoiceId() != null) {
            _hashCode += getM_strInvoiceId().hashCode();
        }
        if (getM_llInvoiceNo() != null) {
            _hashCode += getM_llInvoiceNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccPrtInvDefSInvcDtl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcDtl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llSeqNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llSeqNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmPrintTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmPrintTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strInvoiceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strInvoiceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvoiceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvoiceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
