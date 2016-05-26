/**
 * ObIdl_MAccTranBilSPayCreditBookOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSPayCreditBookOut  implements java.io.Serializable {
    private java.lang.Long m_llPaySoNbr;

    public ObIdl_MAccTranBilSPayCreditBookOut() {
    }

    public ObIdl_MAccTranBilSPayCreditBookOut(
           java.lang.Long m_llPaySoNbr) {
           this.m_llPaySoNbr = m_llPaySoNbr;
    }


    /**
     * Gets the m_llPaySoNbr value for this ObIdl_MAccTranBilSPayCreditBookOut.
     * 
     * @return m_llPaySoNbr
     */
    public java.lang.Long getM_llPaySoNbr() {
        return m_llPaySoNbr;
    }


    /**
     * Sets the m_llPaySoNbr value for this ObIdl_MAccTranBilSPayCreditBookOut.
     * 
     * @param m_llPaySoNbr
     */
    public void setM_llPaySoNbr(java.lang.Long m_llPaySoNbr) {
        this.m_llPaySoNbr = m_llPaySoNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSPayCreditBookOut)) return false;
        ObIdl_MAccTranBilSPayCreditBookOut other = (ObIdl_MAccTranBilSPayCreditBookOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llPaySoNbr==null && other.getM_llPaySoNbr()==null) || 
             (this.m_llPaySoNbr!=null &&
              this.m_llPaySoNbr.equals(other.getM_llPaySoNbr())));
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
        if (getM_llPaySoNbr() != null) {
            _hashCode += getM_llPaySoNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSPayCreditBookOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPaySoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPaySoNbr"));
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
