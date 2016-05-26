/**
 * ObIdl_MAccQuickQryFeeSOcsBalance.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccQuickQryFee;

public class ObIdl_MAccQuickQryFeeSOcsBalance  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Short m_nIsMonitored;

    private java.lang.Long m_llFeeTotal;

    private java.lang.Long m_llBalance;

    public ObIdl_MAccQuickQryFeeSOcsBalance() {
    }

    public ObIdl_MAccQuickQryFeeSOcsBalance(
           java.lang.Long m_llAcctId,
           java.lang.Short m_nIsMonitored,
           java.lang.Long m_llFeeTotal,
           java.lang.Long m_llBalance) {
           this.m_llAcctId = m_llAcctId;
           this.m_nIsMonitored = m_nIsMonitored;
           this.m_llFeeTotal = m_llFeeTotal;
           this.m_llBalance = m_llBalance;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_nIsMonitored value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @return m_nIsMonitored
     */
    public java.lang.Short getM_nIsMonitored() {
        return m_nIsMonitored;
    }


    /**
     * Sets the m_nIsMonitored value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @param m_nIsMonitored
     */
    public void setM_nIsMonitored(java.lang.Short m_nIsMonitored) {
        this.m_nIsMonitored = m_nIsMonitored;
    }


    /**
     * Gets the m_llFeeTotal value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @return m_llFeeTotal
     */
    public java.lang.Long getM_llFeeTotal() {
        return m_llFeeTotal;
    }


    /**
     * Sets the m_llFeeTotal value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @param m_llFeeTotal
     */
    public void setM_llFeeTotal(java.lang.Long m_llFeeTotal) {
        this.m_llFeeTotal = m_llFeeTotal;
    }


    /**
     * Gets the m_llBalance value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @return m_llBalance
     */
    public java.lang.Long getM_llBalance() {
        return m_llBalance;
    }


    /**
     * Sets the m_llBalance value for this ObIdl_MAccQuickQryFeeSOcsBalance.
     * 
     * @param m_llBalance
     */
    public void setM_llBalance(java.lang.Long m_llBalance) {
        this.m_llBalance = m_llBalance;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccQuickQryFeeSOcsBalance)) return false;
        ObIdl_MAccQuickQryFeeSOcsBalance other = (ObIdl_MAccQuickQryFeeSOcsBalance) obj;
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
            ((this.m_nIsMonitored==null && other.getM_nIsMonitored()==null) || 
             (this.m_nIsMonitored!=null &&
              this.m_nIsMonitored.equals(other.getM_nIsMonitored()))) &&
            ((this.m_llFeeTotal==null && other.getM_llFeeTotal()==null) || 
             (this.m_llFeeTotal!=null &&
              this.m_llFeeTotal.equals(other.getM_llFeeTotal()))) &&
            ((this.m_llBalance==null && other.getM_llBalance()==null) || 
             (this.m_llBalance!=null &&
              this.m_llBalance.equals(other.getM_llBalance())));
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
        if (getM_nIsMonitored() != null) {
            _hashCode += getM_nIsMonitored().hashCode();
        }
        if (getM_llFeeTotal() != null) {
            _hashCode += getM_llFeeTotal().hashCode();
        }
        if (getM_llBalance() != null) {
            _hashCode += getM_llBalance().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccQuickQryFeeSOcsBalance.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalance"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nIsMonitored");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nIsMonitored"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llFeeTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llFeeTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBalance"));
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
