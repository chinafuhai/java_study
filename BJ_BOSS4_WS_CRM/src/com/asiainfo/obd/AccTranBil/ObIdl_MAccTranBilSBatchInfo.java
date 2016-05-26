/**
 * ObIdl_MAccTranBilSBatchInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;

public class ObIdl_MAccTranBilSBatchInfo  implements java.io.Serializable {
    private java.lang.String m_strBatchid;

    private java.lang.String m_strCheckname;

    private java.lang.String m_strSodesc;

    private java.lang.String m_strRemark;

    public ObIdl_MAccTranBilSBatchInfo() {
    }

    public ObIdl_MAccTranBilSBatchInfo(
           java.lang.String m_strBatchid,
           java.lang.String m_strCheckname,
           java.lang.String m_strSodesc,
           java.lang.String m_strRemark) {
           this.m_strBatchid = m_strBatchid;
           this.m_strCheckname = m_strCheckname;
           this.m_strSodesc = m_strSodesc;
           this.m_strRemark = m_strRemark;
    }


    /**
     * Gets the m_strBatchid value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @return m_strBatchid
     */
    public java.lang.String getM_strBatchid() {
        return m_strBatchid;
    }


    /**
     * Sets the m_strBatchid value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @param m_strBatchid
     */
    public void setM_strBatchid(java.lang.String m_strBatchid) {
        this.m_strBatchid = m_strBatchid;
    }


    /**
     * Gets the m_strCheckname value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @return m_strCheckname
     */
    public java.lang.String getM_strCheckname() {
        return m_strCheckname;
    }


    /**
     * Sets the m_strCheckname value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @param m_strCheckname
     */
    public void setM_strCheckname(java.lang.String m_strCheckname) {
        this.m_strCheckname = m_strCheckname;
    }


    /**
     * Gets the m_strSodesc value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @return m_strSodesc
     */
    public java.lang.String getM_strSodesc() {
        return m_strSodesc;
    }


    /**
     * Sets the m_strSodesc value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @param m_strSodesc
     */
    public void setM_strSodesc(java.lang.String m_strSodesc) {
        this.m_strSodesc = m_strSodesc;
    }


    /**
     * Gets the m_strRemark value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @return m_strRemark
     */
    public java.lang.String getM_strRemark() {
        return m_strRemark;
    }


    /**
     * Sets the m_strRemark value for this ObIdl_MAccTranBilSBatchInfo.
     * 
     * @param m_strRemark
     */
    public void setM_strRemark(java.lang.String m_strRemark) {
        this.m_strRemark = m_strRemark;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccTranBilSBatchInfo)) return false;
        ObIdl_MAccTranBilSBatchInfo other = (ObIdl_MAccTranBilSBatchInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strBatchid==null && other.getM_strBatchid()==null) || 
             (this.m_strBatchid!=null &&
              this.m_strBatchid.equals(other.getM_strBatchid()))) &&
            ((this.m_strCheckname==null && other.getM_strCheckname()==null) || 
             (this.m_strCheckname!=null &&
              this.m_strCheckname.equals(other.getM_strCheckname()))) &&
            ((this.m_strSodesc==null && other.getM_strSodesc()==null) || 
             (this.m_strSodesc!=null &&
              this.m_strSodesc.equals(other.getM_strSodesc()))) &&
            ((this.m_strRemark==null && other.getM_strRemark()==null) || 
             (this.m_strRemark!=null &&
              this.m_strRemark.equals(other.getM_strRemark())));
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
        if (getM_strBatchid() != null) {
            _hashCode += getM_strBatchid().hashCode();
        }
        if (getM_strCheckname() != null) {
            _hashCode += getM_strCheckname().hashCode();
        }
        if (getM_strSodesc() != null) {
            _hashCode += getM_strSodesc().hashCode();
        }
        if (getM_strRemark() != null) {
            _hashCode += getM_strRemark().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccTranBilSBatchInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBatchInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBatchid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBatchid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCheckname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCheckname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strSodesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strSodesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemark"));
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
