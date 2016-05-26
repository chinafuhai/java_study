/**
 * ObIdl_MBookSchemeIBkScheBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.bookscheme;

public class ObIdl_MBookSchemeIBkScheBindingStub extends org.apache.axis.client.Stub implements com.asiainfo.obd.bookscheme.ObIdl_MBookScheme_IBkSche {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[13];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deal_oneTimePayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strBrand"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSegmentIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentFund"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentFund.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sReceiptIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBusinessReceipt"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBusinessReceipt.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceipt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llPaymentNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetReceiptNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deal_oneTimePaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("rollback_backoutPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPaymentSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strReceiptSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPayDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strReason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iInvcFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strError"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "rollback_backoutPaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("refund_schemeDeposit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strResourceNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPaymentType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCrmFeeId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCrmSapInstanceId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefundList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceipt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "refund_schemeDepositReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("refund_regularBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iBookItemId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRefundReason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefundList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceipt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "refund_regularBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("refund_msBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRefundAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOriBalance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strTransNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iCancelFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefundList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceipt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBalance"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "refund_msBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_fundBackHistory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strStartTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strEndTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPaymentType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listFundbackHistoryQryOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SFundbackHistoryQryOutList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_fundBackHistoryReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_bookSchemeDtl");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strStartTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strEndTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listQry"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeQryOutList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_bookSchemeDtlReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("active_mzoneUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strError"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "active_mzoneUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_oneTimePayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryIn"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryOutList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_oneTimePaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_schemePayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryIn"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryOutList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_schemePaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_schemeFeeLog");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryIn"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryOutList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_schemeFeeLogReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_bankDepositConfirm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strSapId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strEndDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirmList"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_bankDepositConfirmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("confirm_bankDepositConfirm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession"), com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sDeposit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirm"), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iConfimType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "confirm_bankDepositConfirmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.bookscheme.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[12] = oper;

    }

    public ObIdl_MBookSchemeIBkScheBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MBookSchemeIBkScheBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MBookSchemeIBkScheBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SCbsErrorMsg");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecDtlList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfoList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirm");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirmList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBankDepositConfirm");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFee");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFeeDtl");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFeeDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFeeDtlList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFeeDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFeeDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFeeList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeFee[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeFee");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeQryOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeQryOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBookShemeQryOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SBusinessReceipt");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBusinessReceipt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SFundbackHistoryQryOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SFundbackHistoryQryOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SFundbackHistoryQryOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItem");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItemList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentItem");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryIn");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimePaymentQryOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimeReceiptItem");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimeReceiptItemList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimeReceiptItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SOneTimeReceiptItem");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SReceiptServInfo");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSReceiptServInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefund");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefundList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemeDepositRefund");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryIn");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSchemePaymentQryOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentFund");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentFund.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SSegmentPayMethod");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentPayMethod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryIn");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BookScheme/", "ObIdl_MBookSchemeDef.SShemeFeeLogQryOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.completion_status");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.CORBACompletion_status.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.bookscheme.CORBASystemException.class;
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

    public int deal_oneTimePayment(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, java.lang.String strBrand, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSegmentFund sSegmentIn, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBusinessReceipt sReceiptIn, int iOpId, int iOrgId, com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listReceipt, javax.xml.rpc.holders.LongHolder llPaymentNbr, javax.xml.rpc.holders.LongHolder llRetReceiptNbr, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#deal_oneTimePayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "deal_oneTimePayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strBrand, sSegmentIn, sReceiptIn, new java.lang.Integer(iOpId), new java.lang.Integer(iOrgId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listReceipt"));
            } catch (java.lang.Exception _exception) {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listReceipt")), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class);
            }
            try {
                llPaymentNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llPaymentNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llPaymentNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llPaymentNbr")), long.class)).longValue();
            }
            try {
                llRetReceiptNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetReceiptNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetReceiptNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetReceiptNbr")), long.class)).longValue();
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int rollback_backoutPayment(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPaymentSoNbr, java.lang.String strReceiptSoNbr, java.lang.String strPayDate, java.lang.String strOtherSoNbr, java.lang.String strReason, int iInvcFlag, int iOpId, int iSoOrgId, com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcRecInfo, javax.xml.rpc.holders.StringHolder strError, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#rollback_backoutPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "rollback_backoutPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPaymentSoNbr, strReceiptSoNbr, strPayDate, strOtherSoNbr, strReason, new java.lang.Integer(iInvcFlag), new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvcRecInfo.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcRecInfo.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcRecInfo")), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class);
            }
            try {
                strError.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strError"));
            } catch (java.lang.Exception _exception) {
                strError.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strError")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int refund_schemeDeposit(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strResourceNumber, java.lang.String strPaymentType, long llAmount, java.lang.String strCrmFeeId, java.lang.String strOtherSoNbr, java.lang.String strCrmSapInstanceId, java.lang.String strRemark, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[] listIn, int iOpId, int iOrgId, com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listReceipt, javax.xml.rpc.holders.LongHolder llRetSoNbr, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#refund_schemeDeposit");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "refund_schemeDeposit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strResourceNumber, strPaymentType, new java.lang.Long(llAmount), strCrmFeeId, strOtherSoNbr, strCrmSapInstanceId, strRemark, listIn, new java.lang.Integer(iOpId), new java.lang.Integer(iOrgId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listReceipt"));
            } catch (java.lang.Exception _exception) {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listReceipt")), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class);
            }
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int refund_regularBook(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, long llAcctId, int iBookItemId, long llAmount, java.lang.String strRefundReason, java.lang.String strOtherSoNbr, int iOpId, int iOrgId, java.lang.String strRemark, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[] listIn, com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listReceipt, javax.xml.rpc.holders.LongHolder llRetSoNbr, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#refund_regularBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "refund_regularBook"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), new java.lang.Integer(iBookItemId), new java.lang.Long(llAmount), strRefundReason, strOtherSoNbr, new java.lang.Integer(iOpId), new java.lang.Integer(iOrgId), strRemark, listIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listReceipt"));
            } catch (java.lang.Exception _exception) {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listReceipt")), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class);
            }
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int refund_msBalance(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, java.lang.String strPhoneId, long llAcctId, long llRefundAmount, long llOriBalance, java.lang.String strTransNbr, int iCancelFlag, java.lang.String strRemark, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemeDepositRefund[] listIn, com.asiainfo.obd.bookscheme.holders.ObIdl_MAccCommonSAccInvcRecInfoListHolder listReceipt, javax.xml.rpc.holders.LongHolder llBalance, javax.xml.rpc.holders.LongHolder llRetSoNbr, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#refund_msBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "refund_msBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), strPhoneId, new java.lang.Long(llAcctId), new java.lang.Long(llRefundAmount), new java.lang.Long(llOriBalance), strTransNbr, new java.lang.Integer(iCancelFlag), strRemark, listIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listReceipt"));
            } catch (java.lang.Exception _exception) {
                listReceipt.value = (com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listReceipt")), com.asiainfo.obd.bookscheme.ObIdl_MAccCommonSAccInvcRecInfo[].class);
            }
            try {
                llBalance.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBalance"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBalance.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBalance")), long.class)).longValue();
            }
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_fundBackHistory(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, java.lang.String strStartTime, java.lang.String strEndTime, java.lang.String strPaymentType, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSFundbackHistoryQryOutListHolder listFundbackHistoryQryOut, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_fundBackHistory");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_fundBackHistory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, strStartTime, strEndTime, strPaymentType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listFundbackHistoryQryOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut[]) _output.get(new javax.xml.namespace.QName("", "listFundbackHistoryQryOut"));
            } catch (java.lang.Exception _exception) {
                listFundbackHistoryQryOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listFundbackHistoryQryOut")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSFundbackHistoryQryOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_bookSchemeDtl(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strStartTime, java.lang.String strEndTime, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSBookShemeQryOutListHolder listQry, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_bookSchemeDtl");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_bookSchemeDtl"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strStartTime, strEndTime});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listQry.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut[]) _output.get(new javax.xml.namespace.QName("", "listQry"));
            } catch (java.lang.Exception _exception) {
                listQry.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listQry")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBookShemeQryOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int active_mzoneUser(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, int iOpId, int iSoOrgId, java.lang.String strOtherSoNbr, javax.xml.rpc.holders.StringHolder strError, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#active_mzoneUser");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "active_mzoneUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), strOtherSoNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                strError.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strError"));
            } catch (java.lang.Exception _exception) {
                strError.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strError")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_oneTimePayment(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryIn sIn, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSOneTimePaymentQryOutListHolder listOut, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_oneTimePayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_oneTimePayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSOneTimePaymentQryOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_schemePayment(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryIn sIn, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSSchemePaymentQryOutListHolder listOut, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_schemePayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_schemePayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSSchemePaymentQryOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_schemeFeeLog(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryIn sIn, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSShemeFeeLogQryOutListHolder listOut, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_schemeFeeLog");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_schemeFeeLog"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSShemeFeeLogQryOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_bankDepositConfirm(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, java.lang.String strSapId, java.lang.String strEndDate, com.asiainfo.obd.bookscheme.holders.ObIdl_MBookSchemeDefSBankDepositConfirmListHolder listOut, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#query_bankDepositConfirm");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "query_bankDepositConfirm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strSapId, strEndDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int confirm_bankDepositConfirm(com.asiainfo.obd.bookscheme.MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, com.asiainfo.obd.bookscheme.ObIdl_MBookSchemeDefSBankDepositConfirm sDeposit, int iConfimType, javax.xml.rpc.holders.LongHolder llRetSoNbr, com.asiainfo.obd.bookscheme.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.bookscheme.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MBookScheme.IBkSche#confirm_bankDepositConfirm");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MBookScheme.IBkSche", "confirm_bankDepositConfirm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sDeposit, new java.lang.Integer(iConfimType)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.bookscheme.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.bookscheme.CORBASystemException) {
              throw (com.asiainfo.obd.bookscheme.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
