/**
 * ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public class ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub extends org.apache.axis.client.Stub implements com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFee {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_oweFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), com.asiainfo.obd.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nRealTimeFeeFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nItemType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llPreMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llCurMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRealTimeFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBookAmt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontPreMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontCurMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontRealTimeFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontBookAmt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nMonth"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iCreditValue"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBillMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCurMonth"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_oweFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_ocsBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), com.asiainfo.obd.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sQuery"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalanceQuery"), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalanceQuery.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sOcsBalance"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalance"), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalance.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_ocsBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_bankBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), com.asiainfo.obd.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_bankBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_userOweFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), com.asiainfo.obd.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nRealTimeFeeFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nItemType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llPreMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llCurMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRealTimeFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBookAmt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBookSub"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llTransInBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llCreditBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontPreMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontCurMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontRealTimeFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontBookAmt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontBookSub"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontTransInBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nMonth"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iCreditValue"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBillMonthFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCurMonth"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dtmExpDate"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strUserSts"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_userOweFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_advancedAndDepositPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), com.asiainfo.obd.MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strQryFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strResourceNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strStartDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strEndDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPaymentType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strStatus"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listRegularBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList"), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listSchemeBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutList"), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listDepositBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOutList"), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_advancedAndDepositPaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "com.asiainfo.obd.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[4] = oper;

    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeePortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalance");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalanceQuery");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalanceQuery.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOut");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutList");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.completion_status");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.CORBACompletion_status.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException");
            cachedSerQNames.add(qName);
            cls = com.asiainfo.obd.CORBASystemException.class;
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

    public int query_oweFee(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_oweFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccQuickQryFee.IAccQuickQryFeePort", "query_oweFee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, new java.lang.Long(llAcctId), new java.lang.Short(nRealTimeFeeFlag), new java.lang.Short(nItemType)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llPreMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llPreMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llPreMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llPreMonthFee")), long.class)).longValue();
            }
            try {
                llCurMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llCurMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llCurMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llCurMonthFee")), long.class)).longValue();
            }
            try {
                llRealTimeFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRealTimeFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRealTimeFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRealTimeFee")), long.class)).longValue();
            }
            try {
                llBookAmt.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBookAmt"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBookAmt.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBookAmt")), long.class)).longValue();
            }
            try {
                llSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llSpecBook")), long.class)).longValue();
            }
            try {
                llFrontPreMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontPreMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontPreMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontPreMonthFee")), long.class)).longValue();
            }
            try {
                llFrontCurMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontCurMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontCurMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontCurMonthFee")), long.class)).longValue();
            }
            try {
                llFrontRealTimeFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontRealTimeFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontRealTimeFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontRealTimeFee")), long.class)).longValue();
            }
            try {
                llFrontBookAmt.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontBookAmt"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontBookAmt.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontBookAmt")), long.class)).longValue();
            }
            try {
                llFrontSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontSpecBook")), long.class)).longValue();
            }
            try {
                nMonth.value = ((java.lang.Short) _output.get(new javax.xml.namespace.QName("", "nMonth"))).shortValue();
            } catch (java.lang.Exception _exception) {
                nMonth.value = ((java.lang.Short) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "nMonth")), short.class)).shortValue();
            }
            try {
                iCreditValue.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "iCreditValue"))).intValue();
            } catch (java.lang.Exception _exception) {
                iCreditValue.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "iCreditValue")), int.class)).intValue();
            }
            try {
                llBillMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBillMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBillMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBillMonthFee")), long.class)).longValue();
            }
            try {
                strCurMonth.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strCurMonth"));
            } catch (java.lang.Exception _exception) {
                strCurMonth.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strCurMonth")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.CORBASystemException) {
              throw (com.asiainfo.obd.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_ocsBalance(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalanceQuery sQuery, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSOcsBalanceHolder sOcsBalance, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_ocsBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccQuickQryFee.IAccQuickQryFeePort", "query_ocsBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sQuery});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sOcsBalance.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalance) _output.get(new javax.xml.namespace.QName("", "sOcsBalance"));
            } catch (java.lang.Exception _exception) {
                sOcsBalance.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalance) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sOcsBalance")), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalance.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.CORBASystemException) {
              throw (com.asiainfo.obd.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_bankBalance(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strRequest, javax.xml.rpc.holders.StringHolder strResponse, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_bankBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccQuickQryFee.IAccQuickQryFeePort", "query_bankBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                strResponse.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strResponse"));
            } catch (java.lang.Exception _exception) {
                strResponse.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strResponse")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.CORBASystemException) {
              throw (com.asiainfo.obd.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_userOweFee(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_userOweFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccQuickQryFee.IAccQuickQryFeePort", "query_userOweFee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, new java.lang.Long(llAcctId), new java.lang.Short(nRealTimeFeeFlag), new java.lang.Short(nItemType)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llPreMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llPreMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llPreMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llPreMonthFee")), long.class)).longValue();
            }
            try {
                llCurMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llCurMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llCurMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llCurMonthFee")), long.class)).longValue();
            }
            try {
                llRealTimeFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRealTimeFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRealTimeFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRealTimeFee")), long.class)).longValue();
            }
            try {
                llBookAmt.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBookAmt"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBookAmt.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBookAmt")), long.class)).longValue();
            }
            try {
                llBookSub.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBookSub"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBookSub.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBookSub")), long.class)).longValue();
            }
            try {
                llSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llSpecBook")), long.class)).longValue();
            }
            try {
                llTransInBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llTransInBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llTransInBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llTransInBook")), long.class)).longValue();
            }
            try {
                llCreditBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llCreditBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llCreditBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llCreditBook")), long.class)).longValue();
            }
            try {
                llFrontPreMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontPreMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontPreMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontPreMonthFee")), long.class)).longValue();
            }
            try {
                llFrontCurMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontCurMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontCurMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontCurMonthFee")), long.class)).longValue();
            }
            try {
                llFrontRealTimeFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontRealTimeFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontRealTimeFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontRealTimeFee")), long.class)).longValue();
            }
            try {
                llFrontBookAmt.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontBookAmt"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontBookAmt.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontBookAmt")), long.class)).longValue();
            }
            try {
                llFrontBookSub.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontBookSub"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontBookSub.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontBookSub")), long.class)).longValue();
            }
            try {
                llFrontSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontSpecBook")), long.class)).longValue();
            }
            try {
                llFrontTransInBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontTransInBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontTransInBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontTransInBook")), long.class)).longValue();
            }
            try {
                nMonth.value = ((java.lang.Short) _output.get(new javax.xml.namespace.QName("", "nMonth"))).shortValue();
            } catch (java.lang.Exception _exception) {
                nMonth.value = ((java.lang.Short) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "nMonth")), short.class)).shortValue();
            }
            try {
                iCreditValue.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "iCreditValue"))).intValue();
            } catch (java.lang.Exception _exception) {
                iCreditValue.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "iCreditValue")), int.class)).intValue();
            }
            try {
                llBillMonthFee.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBillMonthFee"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBillMonthFee.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBillMonthFee")), long.class)).longValue();
            }
            try {
                strCurMonth.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strCurMonth"));
            } catch (java.lang.Exception _exception) {
                strCurMonth.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strCurMonth")), java.lang.String.class);
            }
            try {
                dtmExpDate.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "dtmExpDate"));
            } catch (java.lang.Exception _exception) {
                dtmExpDate.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "dtmExpDate")), java.lang.String.class);
            }
            try {
                strUserSts.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strUserSts"));
            } catch (java.lang.Exception _exception) {
                strUserSts.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strUserSts")), java.lang.String.class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.CORBASystemException) {
              throw (com.asiainfo.obd.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int query_advancedAndDepositPayment(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_advancedAndDepositPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ObIdl_MAccQuickQryFee.IAccQuickQryFeePort", "query_advancedAndDepositPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strQryFlag, strResourceNumber, strStartDate, strEndDate, strPaymentType, strStatus});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listRegularBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) _output.get(new javax.xml.namespace.QName("", "listRegularBook"));
            } catch (java.lang.Exception _exception) {
                listRegularBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listRegularBook")), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class);
            }
            try {
                listSchemeBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) _output.get(new javax.xml.namespace.QName("", "listSchemeBook"));
            } catch (java.lang.Exception _exception) {
                listSchemeBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listSchemeBook")), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class);
            }
            try {
                listDepositBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) _output.get(new javax.xml.namespace.QName("", "listDepositBook"));
            } catch (java.lang.Exception _exception) {
                listDepositBook.value = (com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listDepositBook")), com.asiainfo.obd.ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class);
            }
            try {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) _output.get(new javax.xml.namespace.QName("", "sErrorMsg"));
            } catch (java.lang.Exception _exception) {
                sErrorMsg.value = (com.asiainfo.obd.MObdCommonSCbsErrorMsg) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sErrorMsg")), com.asiainfo.obd.MObdCommonSCbsErrorMsg.class);
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
        if (axisFaultException.detail instanceof com.asiainfo.obd.CORBASystemException) {
              throw (com.asiainfo.obd.CORBASystemException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
