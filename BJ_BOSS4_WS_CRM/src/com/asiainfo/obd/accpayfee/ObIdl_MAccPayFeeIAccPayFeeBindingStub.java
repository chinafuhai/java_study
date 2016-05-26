/**
 * ObIdl_MAccPayFeeIAccPayFeeBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;
import com.asiainfo.obd.accpayfee.holders.*;

public class ObIdl_MAccPayFeeIAccPayFeeBindingStub extends org.apache.axis.client.Stub implements ObIdl_MAccPayFee_IAccPayFee {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayFeeIn"), ObIdl_MAccCommonSPayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayFeeOut"), ObIdl_MAccCommonSPayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("gen_monthInvc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sMonInvcIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SMonthInvcIn"), ObIdl_MAccCommonSMonthInvcIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sMonInvcOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SMonthInvcOut"), ObIdl_MAccCommonSMonthInvcOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "gen_monthInvcReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("tran_posSvr");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strSpkg"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRpkg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "tran_posSvrReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFeeSimple");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeIn"), ObIdl_MAccCommonSSimplePayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeOut"), ObIdl_MAccCommonSSimplePayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeSimpleReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFeeCross");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCrossPayFeeIn"), ObIdl_MAccCommonSCrossPayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCrossPayFeeOut"), ObIdl_MAccCommonSCrossPayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeCrossReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFeeBank");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeIn"), ObIdl_MAccCommonSInvoicePayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBankPayFeeOut"), ObIdl_MAccCommonSBankPayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeBankReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFeeInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeIn"), ObIdl_MAccCommonSInvoicePayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeOut"), ObIdl_MAccCommonSInvoicePayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payFeeCm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCmPayFeeIn"), ObIdl_MAccCommonSCmPayFeeIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sPayFeeOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeOut"), ObIdl_MAccCommonSSimplePayFeeOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payFeeCmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.accpayfee.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[7] = oper;

    }

    public ObIdl_MAccPayFeeIAccPayFeeBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MAccPayFeeIAccPayFeeBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MAccPayFeeIAccPayFeeBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SCbsErrorMsg");
            cachedSerQNames.add(qName);
            cls = MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBankPayFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBankPayFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBillSnapShot");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBillSnapShot.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBillSnapShotList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBillSnapShot[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBillSnapShot");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShot");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBookSnapShot.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShotList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBookSnapShot[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShot");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookWriteFee");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBookWriteFee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookWriteFeeList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSBookWriteFee[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookWriteFee");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCmPayFeeIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSCmPayFeeIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCrossPayFeeIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSCrossPayFeeIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SCrossPayFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSCrossPayFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SFeeBookSnapShot");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSFeeBookSnapShot.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SFeeBookSnapShotList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSFeeBookSnapShot[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SFeeBookSnapShot");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSInvoicePayFeeIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSInvoicePayFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SMonthInvcIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSMonthInvcIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SMonthInvcOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSMonthInvcOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayFeeIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSPayFeeIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSPayFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayLimit");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSPayLimit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayLimitList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSPayLimit[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayLimit");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFee");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSRealTimeBillFee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFeeList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSRealTimeBillFee[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeBillFee");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFee");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSRealTimeFee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFeeList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSRealTimeFee[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFee");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSRealTimeFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSSimplePayFeeIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SSimplePayFeeOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSSimplePayFeeOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.completion_status");
            cachedSerQNames.add(qName);
            cls = CORBACompletion_status.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException");
            cachedSerQNames.add(qName);
            cls = CORBASystemException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public int do_payFee(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSPayFeeIn sPayFeeIn, ObIdl_MAccCommonSPayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#do_payFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "do_payFee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSPayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSPayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSPayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int gen_monthInvc(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSMonthInvcIn sMonInvcIn, ObIdl_MAccCommonSMonthInvcOutHolder sMonInvcOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#gen_monthInvc");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "gen_monthInvc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sMonInvcIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sMonInvcOut.value = (ObIdl_MAccCommonSMonthInvcOut) _output.get(new javax.xml.namespace.QName("", "sMonInvcOut"));
            } catch (java.lang.Exception _exception) {
                sMonInvcOut.value = (ObIdl_MAccCommonSMonthInvcOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sMonInvcOut")), ObIdl_MAccCommonSMonthInvcOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int tran_posSvr(MObdCommonSOBSessionProperty[] sSession, java.lang.String strSpkg, javax.xml.rpc.holders.StringHolder strRpkg, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#tran_posSvr");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "tran_posSvr"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strSpkg});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                strRpkg.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strRpkg"));
            } catch (java.lang.Exception _exception) {
                strRpkg.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strRpkg")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int do_payFeeSimple(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSSimplePayFeeIn sPayFeeIn, ObIdl_MAccCommonSSimplePayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#do_payFeeSimple");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "do_payFeeSimple"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSSimplePayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSSimplePayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSSimplePayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int do_payFeeCross(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSCrossPayFeeIn sPayFeeIn, ObIdl_MAccCommonSCrossPayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#do_payFeeCross");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "do_payFeeCross"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSCrossPayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSCrossPayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSCrossPayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int do_payFeeBank(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSInvoicePayFeeIn sPayFeeIn, ObIdl_MAccCommonSBankPayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#do_payFeeBank");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "do_payFeeBank"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSBankPayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSBankPayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSBankPayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int do_payFeeInvoice(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSInvoicePayFeeIn sPayFeeIn, ObIdl_MAccCommonSInvoicePayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPayFee.IAccPayFee#do_payFeeInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccPayFee.IAccPayFeePort", "do_payFeeInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSInvoicePayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSInvoicePayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSInvoicePayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int do_payFeeCm(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSCmPayFeeIn sPayFeeIn, ObIdl_MAccCommonSSimplePayFeeOutHolder sPayFeeOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MIAccPayFee#do_payFeeCm");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MIAccPayFee", "do_payFeeCm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sPayFeeIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sPayFeeOut.value = (ObIdl_MAccCommonSSimplePayFeeOut) _output.get(new javax.xml.namespace.QName("", "sPayFeeOut"));
            } catch (java.lang.Exception _exception) {
                sPayFeeOut.value = (ObIdl_MAccCommonSSimplePayFeeOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sPayFeeOut")), ObIdl_MAccCommonSSimplePayFeeOut.class);
            }
            try {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), MObdCommonSCbsErrorMsg.class);
            }
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CORBASystemException) {
              throw (CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
