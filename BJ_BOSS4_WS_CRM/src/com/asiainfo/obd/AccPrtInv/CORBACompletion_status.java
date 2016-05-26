/**
 * CORBACompletion_status.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;

public class CORBACompletion_status implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CORBACompletion_status(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _COMPLETED_YES = "COMPLETED_YES";
    public static final java.lang.String _COMPLETED_NO = "COMPLETED_NO";
    public static final java.lang.String _COMPLETED_MAYBE = "COMPLETED_MAYBE";
    public static final CORBACompletion_status COMPLETED_YES = new CORBACompletion_status(_COMPLETED_YES);
    public static final CORBACompletion_status COMPLETED_NO = new CORBACompletion_status(_COMPLETED_NO);
    public static final CORBACompletion_status COMPLETED_MAYBE = new CORBACompletion_status(_COMPLETED_MAYBE);
    public java.lang.String getValue() { return _value_;}
    public static CORBACompletion_status fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CORBACompletion_status enumeration = (CORBACompletion_status)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CORBACompletion_status fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CORBACompletion_status.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.completion_status"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
