/**
 * ObIdl_MAccTranBilSAccAdjBookInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSAccAdjBookInfo  implements java.io.Serializable {
    private java.lang.String m_strPhoneId;

    private java.lang.Long m_llCustId;

    private java.lang.String m_strBillCycle;

    private java.lang.Long m_llAmount;

    private java.lang.Integer m_iFeeItemId;

    private java.lang.Short m_nAdjustFlag;

    private java.lang.Short m_nBrand;

    private java.lang.String m_strErrInfo;

    public ObIdl_MAccTranBilSAccAdjBookInfo() {
    }

    public ObIdl_MAccTranBilSAccAdjBookInfo(
           java.lang.String m_strPhoneId,
           java.lang.Long m_llCustId,
           java.lang.String m_strBillCycle,
           java.lang.Long m_llAmount,
           java.lang.Integer m_iFeeItemId,
           java.lang.Short m_nAdjustFlag,
           java.lang.Short m_nBrand,
           java.lang.String m_strErrInfo) {
           this.m_strPhoneId = m_strPhoneId;
           this.m_llCustId = m_llCustId;
           this.m_strBillCycle = m_strBillCycle;
           this.m_llAmount = m_llAmount;
           this.m_iFeeItemId = m_iFeeItemId;
           this.m_nAdjustFlag = m_nAdjustFlag;
           this.m_nBrand = m_nBrand;
           this.m_strErrInfo = m_strErrInfo;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_llCustId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_llCustId
     */
    public java.lang.Long getM_llCustId() {
        return m_llCustId;
    }


    /**
     * Sets the m_llCustId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_llCustId
     */
    public void setM_llCustId(java.lang.Long m_llCustId) {
        this.m_llCustId = m_llCustId;
    }


    /**
     * Gets the m_strBillCycle value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_strBillCycle
     */
    public java.lang.String getM_strBillCycle() {
        return m_strBillCycle;
    }


    /**
     * Sets the m_strBillCycle value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_strBillCycle
     */
    public void setM_strBillCycle(java.lang.String m_strBillCycle) {
        this.m_strBillCycle = m_strBillCycle;
    }


    /**
     * Gets the m_llAmount value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_llAmount
     */
    public java.lang.Long getM_llAmount() {
        return m_llAmount;
    }


    /**
     * Sets the m_llAmount value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_llAmount
     */
    public void setM_llAmount(java.lang.Long m_llAmount) {
        this.m_llAmount = m_llAmount;
    }


    /**
     * Gets the m_iFeeItemId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_iFeeItemId
     */
    public java.lang.Integer getM_iFeeItemId() {
        return m_iFeeItemId;
    }


    /**
     * Sets the m_iFeeItemId value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_iFeeItemId
     */
    public void setM_iFeeItemId(java.lang.Integer m_iFeeItemId) {
        this.m_iFeeItemId = m_iFeeItemId;
    }


    /**
     * Gets the m_nAdjustFlag value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_nAdjustFlag
     */
    public java.lang.Short getM_nAdjustFlag() {
        return m_nAdjustFlag;
    }


    /**
     * Sets the m_nAdjustFlag value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_nAdjustFlag
     */
    public void setM_nAdjustFlag(java.lang.Short m_nAdjustFlag) {
        this.m_nAdjustFlag = m_nAdjustFlag;
    }


    /**
     * Gets the m_nBrand value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_nBrand
     */
    public java.lang.Short getM_nBrand() {
        return m_nBrand;
    }


    /**
     * Sets the m_nBrand value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_nBrand
     */
    public void setM_nBrand(java.lang.Short m_nBrand) {
        this.m_nBrand = m_nBrand;
    }


    /**
     * Gets the m_strErrInfo value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @return m_strErrInfo
     */
    public java.lang.String getM_strErrInfo() {
        return m_strErrInfo;
    }


    /**
     * Sets the m_strErrInfo value for this ObIdl_MAccTranBilSAccAdjBookInfo.
     * 
     * @param m_strErrInfo
     */
    public void setM_strErrInfo(java.lang.String m_strErrInfo) {
        this.m_strErrInfo = m_strErrInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSAccAdjBookInfo)) return false;
        ObIdl_MAccTranBilSAccAdjBookInfo other = (ObIdl_MAccTranBilSAccAdjBookInfo) obj;
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
            ((this.m_llCustId==null && other.getM_llCustId()==null) || 
             (this.m_llCustId!=null &&
              this.m_llCustId.equals(other.getM_llCustId()))) &&
            ((this.m_strBillCycle==null && other.getM_strBillCycle()==null) || 
             (this.m_strBillCycle!=null &&
              this.m_strBillCycle.equals(other.getM_strBillCycle()))) &&
            ((this.m_llAmount==null && other.getM_llAmount()==null) || 
             (this.m_llAmount!=null &&
              this.m_llAmount.equals(other.getM_llAmount()))) &&
            ((this.m_iFeeItemId==null && other.getM_iFeeItemId()==null) || 
             (this.m_iFeeItemId!=null &&
              this.m_iFeeItemId.equals(other.getM_iFeeItemId()))) &&
            ((this.m_nAdjustFlag==null && other.getM_nAdjustFlag()==null) || 
             (this.m_nAdjustFlag!=null &&
              this.m_nAdjustFlag.equals(other.getM_nAdjustFlag()))) &&
            ((this.m_nBrand==null && other.getM_nBrand()==null) || 
             (this.m_nBrand!=null &&
              this.m_nBrand.equals(other.getM_nBrand()))) &&
            ((this.m_strErrInfo==null && other.getM_strErrInfo()==null) || 
             (this.m_strErrInfo!=null &&
              this.m_strErrInfo.equals(other.getM_strErrInfo())));
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
        if (getM_llCustId() != null) {
            _hashCode += getM_llCustId().hashCode();
        }
        if (getM_strBillCycle() != null) {
            _hashCode += getM_strBillCycle().hashCode();
        }
        if (getM_llAmount() != null) {
            _hashCode += getM_llAmount().hashCode();
        }
        if (getM_iFeeItemId() != null) {
            _hashCode += getM_iFeeItemId().hashCode();
        }
        if (getM_nAdjustFlag() != null) {
            _hashCode += getM_nAdjustFlag().hashCode();
        }
        if (getM_nBrand() != null) {
            _hashCode += getM_nBrand().hashCode();
        }
        if (getM_strErrInfo() != null) {
            _hashCode += getM_strErrInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSAccAdjBookInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCustId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCustId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBillCycle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBillCycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iFeeItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iFeeItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nAdjustFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nAdjustFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strErrInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strErrInfo"));
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
