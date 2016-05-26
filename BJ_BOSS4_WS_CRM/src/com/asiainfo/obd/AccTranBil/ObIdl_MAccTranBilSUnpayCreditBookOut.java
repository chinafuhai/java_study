/**
 * ObIdl_MAccTranBilSUnpayCreditBookOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSUnpayCreditBookOut  implements java.io.Serializable {
    private java.lang.Long m_llUnpaySoNbr;

    public ObIdl_MAccTranBilSUnpayCreditBookOut() {
    }

    public ObIdl_MAccTranBilSUnpayCreditBookOut(
           java.lang.Long m_llUnpaySoNbr) {
           this.m_llUnpaySoNbr = m_llUnpaySoNbr;
    }


    /**
     * Gets the m_llUnpaySoNbr value for this ObIdl_MAccTranBilSUnpayCreditBookOut.
     * 
     * @return m_llUnpaySoNbr
     */
    public java.lang.Long getM_llUnpaySoNbr() {
        return m_llUnpaySoNbr;
    }


    /**
     * Sets the m_llUnpaySoNbr value for this ObIdl_MAccTranBilSUnpayCreditBookOut.
     * 
     * @param m_llUnpaySoNbr
     */
    public void setM_llUnpaySoNbr(java.lang.Long m_llUnpaySoNbr) {
        this.m_llUnpaySoNbr = m_llUnpaySoNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSUnpayCreditBookOut)) return false;
        ObIdl_MAccTranBilSUnpayCreditBookOut other = (ObIdl_MAccTranBilSUnpayCreditBookOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llUnpaySoNbr==null && other.getM_llUnpaySoNbr()==null) || 
             (this.m_llUnpaySoNbr!=null &&
              this.m_llUnpaySoNbr.equals(other.getM_llUnpaySoNbr())));
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
        if (getM_llUnpaySoNbr() != null) {
            _hashCode += getM_llUnpaySoNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSUnpayCreditBookOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpayCreditBookOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUnpaySoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUnpaySoNbr"));
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
