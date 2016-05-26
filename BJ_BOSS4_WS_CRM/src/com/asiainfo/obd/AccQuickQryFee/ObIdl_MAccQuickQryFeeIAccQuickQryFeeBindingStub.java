/**
 * ObIdl_MAccQuickQryFeeIAccQuickQryFeeBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccQuickQryFee;
import com.asiainfo.obd.AccQuickQryFee.holders.*;
import com.asiainfo.obd.AccQuickQryFee.*;

public class ObIdl_MAccQuickQryFeeIAccQuickQryFeeBindingStub extends org.apache.axis.client.Stub implements ObIdl_MAccQuickQryFeeIAccQuickQryFee {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_oweFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_oweFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_ocsBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sQuery"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalanceQuery"), ObIdl_MAccQuickQryFeeSOcsBalanceQuery.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sOcsBalance"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalance"), ObIdl_MAccQuickQryFeeSOcsBalance.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_ocsBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_bankBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_bankBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_userOweFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontSubSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSubSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_userOweFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_userOweFeeExt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listFrontSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SFrontSpecBookList"), ObIdl_MAccQuickQryFeeSFrontSpecBook[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAfterSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SAfterSpecBookList"), ObIdl_MAccQuickQryFeeSAfterSpecBook[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_userOweFeeExtReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_advancedAndDepositPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listRegularBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList"), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listSchemeBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutList"), ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listDepositBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOutList"), ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_advancedAndDepositPaymentReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_schemeBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listSchemeBookExt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutExtList"), ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_schemeBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_advancedAndDepositPayment2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCrmSapInstanceId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listRegularBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList"), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listSchemeBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutList"), ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listDepositBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOutList"), ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_advancedAndDepositPayment2Return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_gtBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strQryFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listGtBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGtBookList"), ObIdl_MAccQuickQryFeeSGtBook[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_gtBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_accountInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctIdOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strBalance"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nWriteOffFlag"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nLpcWavingInd"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_accountInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_corBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strCrmSapInstanceId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llCustId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listGroupAmount"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGroupAmountList"), ObIdl_MAccQuickQryFeeSGroupAmount[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_corBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_pfbankOweFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listPfBankFee"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SPfBankBillFeeList"), ObIdl_MAccQuickQryFeeSPfBankBillFee[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_pfbankOweFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_gtBookV2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strQryFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listGtBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList"), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_gtBookV2Return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_userOweFeeRefund");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBookAmtRefund"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llBookAmtNoRefund"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llFrontSubSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSubSpecBook"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_userOweFeeRefundReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[13] = oper;

    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeeBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeeBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MAccQuickQryFeeIAccQuickQryFeeBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            cls = MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SAfterSpecBook");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSAfterSpecBook.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SAfterSpecBookList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSAfterSpecBook[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SAfterSpecBook");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SFrontSpecBook");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSFrontSpecBook.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SFrontSpecBookList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSFrontSpecBook[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SFrontSpecBook");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGroupAmount");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSGroupAmount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGroupAmountList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSGroupAmount[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGroupAmount");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGtBook");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSGtBook.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGtBookList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSGtBook[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SGtBook");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalance");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSOcsBalance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SOcsBalanceQuery");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSOcsBalanceQuery.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SPfBankBillFee");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSPfBankBillFee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SPfBankBillFeeList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSPfBankBillFee[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SPfBankBillFee");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQryDepositBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOutList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryDepositBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQryRegularBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOutList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQryRegularBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQrySchemeBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutExt");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutExtList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutExt");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOutList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccQuickQryFee/", "ObIdl_MAccQuickQryFee.SQrySchemeBookOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

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

    public int query_oweFee(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_oweFee"));

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

    public int query_ocsBalance(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccQuickQryFeeSOcsBalanceQuery sQuery, ObIdl_MAccQuickQryFeeSOcsBalanceHolder sOcsBalance, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_ocsBalance"));

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
                sOcsBalance.value = (ObIdl_MAccQuickQryFeeSOcsBalance) _output.get(new javax.xml.namespace.QName("", "sOcsBalance"));
            } catch (java.lang.Exception _exception) {
                sOcsBalance.value = (ObIdl_MAccQuickQryFeeSOcsBalance) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sOcsBalance")), ObIdl_MAccQuickQryFeeSOcsBalance.class);
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

    public int query_bankBalance(MObdCommonSOBSessionProperty[] sSession, java.lang.String strRequest, javax.xml.rpc.holders.StringHolder strResponse, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_bankBalance"));

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

    public int query_userOweFee(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, javax.xml.rpc.holders.LongHolder llFrontSubSpecBook, javax.xml.rpc.holders.LongHolder llSubSpecBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_userOweFee"));

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
                llFrontSubSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontSubSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontSubSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontSubSpecBook")), long.class)).longValue();
            }
            try {
                llSubSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llSubSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llSubSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llSubSpecBook")), long.class)).longValue();
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

    public int query_userOweFeeExt(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, ObIdl_MAccQuickQryFeeSFrontSpecBookListHolder listFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, ObIdl_MAccQuickQryFeeSAfterSpecBookListHolder listAfterSpecBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_userOweFeeExt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_userOweFeeExt"));

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
                listFrontSpecBook.value = (ObIdl_MAccQuickQryFeeSFrontSpecBook[]) _output.get(new javax.xml.namespace.QName("", "listFrontSpecBook"));
            } catch (java.lang.Exception _exception) {
                listFrontSpecBook.value = (ObIdl_MAccQuickQryFeeSFrontSpecBook[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listFrontSpecBook")), ObIdl_MAccQuickQryFeeSFrontSpecBook[].class);
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
                listAfterSpecBook.value = (ObIdl_MAccQuickQryFeeSAfterSpecBook[]) _output.get(new javax.xml.namespace.QName("", "listAfterSpecBook"));
            } catch (java.lang.Exception _exception) {
                listAfterSpecBook.value = (ObIdl_MAccQuickQryFeeSAfterSpecBook[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAfterSpecBook")), ObIdl_MAccQuickQryFeeSAfterSpecBook[].class);
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

    public int query_advancedAndDepositPayment(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_advancedAndDepositPayment");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_advancedAndDepositPayment"));

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
                listRegularBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) _output.get(new javax.xml.namespace.QName("", "listRegularBook"));
            } catch (java.lang.Exception _exception) {
                listRegularBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listRegularBook")), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class);
            }
            try {
                listSchemeBook.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) _output.get(new javax.xml.namespace.QName("", "listSchemeBook"));
            } catch (java.lang.Exception _exception) {
                listSchemeBook.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listSchemeBook")), ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class);
            }
            try {
                listDepositBook.value = (ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) _output.get(new javax.xml.namespace.QName("", "listDepositBook"));
            } catch (java.lang.Exception _exception) {
                listDepositBook.value = (ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listDepositBook")), ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class);
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

    public int query_schemeBook(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, ObIdl_MAccQuickQryFeeSQrySchemeBookOutExtListHolder listSchemeBookExt, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_schemeBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_schemeBook"));

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
                listSchemeBookExt.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt[]) _output.get(new javax.xml.namespace.QName("", "listSchemeBookExt"));
            } catch (java.lang.Exception _exception) {
                listSchemeBookExt.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listSchemeBookExt")), ObIdl_MAccQuickQryFeeSQrySchemeBookOutExt[].class);
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

    public int query_advancedAndDepositPayment2(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, java.lang.String strCrmSapInstanceId, ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_advancedAndDepositPayment2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_advancedAndDepositPayment2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strQryFlag, strResourceNumber, strStartDate, strEndDate, strPaymentType, strStatus, strCrmSapInstanceId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listRegularBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) _output.get(new javax.xml.namespace.QName("", "listRegularBook"));
            } catch (java.lang.Exception _exception) {
                listRegularBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listRegularBook")), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class);
            }
            try {
                listSchemeBook.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) _output.get(new javax.xml.namespace.QName("", "listSchemeBook"));
            } catch (java.lang.Exception _exception) {
                listSchemeBook.value = (ObIdl_MAccQuickQryFeeSQrySchemeBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listSchemeBook")), ObIdl_MAccQuickQryFeeSQrySchemeBookOut[].class);
            }
            try {
                listDepositBook.value = (ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) _output.get(new javax.xml.namespace.QName("", "listDepositBook"));
            } catch (java.lang.Exception _exception) {
                listDepositBook.value = (ObIdl_MAccQuickQryFeeSQryDepositBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listDepositBook")), ObIdl_MAccQuickQryFeeSQryDepositBookOut[].class);
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

    public int query_gtBook(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strPhoneId, ObIdl_MAccQuickQryFeeSGtBookListHolder listGtBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_gtBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_gtBook"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strQryFlag, strPhoneId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listGtBook.value = (ObIdl_MAccQuickQryFeeSGtBook[]) _output.get(new javax.xml.namespace.QName("", "listGtBook"));
            } catch (java.lang.Exception _exception) {
                listGtBook.value = (ObIdl_MAccQuickQryFeeSGtBook[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listGtBook")), ObIdl_MAccQuickQryFeeSGtBook[].class);
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

    public int query_accountInfo(MObdCommonSOBSessionProperty[] sSession, long llAcctId, int iOpId, javax.xml.rpc.holders.LongHolder llAcctIdOut, javax.xml.rpc.holders.StringHolder strBalance, javax.xml.rpc.holders.ShortHolder nWriteOffFlag, javax.xml.rpc.holders.ShortHolder nLpcWavingInd, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_accountInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_accountInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), new java.lang.Integer(iOpId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llAcctIdOut.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llAcctIdOut"))).longValue();
            } catch (java.lang.Exception _exception) {
                llAcctIdOut.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llAcctIdOut")), long.class)).longValue();
            }
            try {
                strBalance.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strBalance"));
            } catch (java.lang.Exception _exception) {
                strBalance.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strBalance")), java.lang.String.class);
            }
            try {
                nWriteOffFlag.value = ((java.lang.Short) _output.get(new javax.xml.namespace.QName("", "nWriteOffFlag"))).shortValue();
            } catch (java.lang.Exception _exception) {
                nWriteOffFlag.value = ((java.lang.Short) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "nWriteOffFlag")), short.class)).shortValue();
            }
            try {
                nLpcWavingInd.value = ((java.lang.Short) _output.get(new javax.xml.namespace.QName("", "nLpcWavingInd"))).shortValue();
            } catch (java.lang.Exception _exception) {
                nLpcWavingInd.value = ((java.lang.Short) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "nLpcWavingInd")), short.class)).shortValue();
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

    public int query_corBook(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strCrmSapInstanceId, long llCustId, ObIdl_MAccQuickQryFeeSGroupAmountListHolder listGroupAmount, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_corBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_corBook"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strCrmSapInstanceId, new java.lang.Long(llCustId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listGroupAmount.value = (ObIdl_MAccQuickQryFeeSGroupAmount[]) _output.get(new javax.xml.namespace.QName("", "listGroupAmount"));
            } catch (java.lang.Exception _exception) {
                listGroupAmount.value = (ObIdl_MAccQuickQryFeeSGroupAmount[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listGroupAmount")), ObIdl_MAccQuickQryFeeSGroupAmount[].class);
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

    public int query_pfbankOweFee(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, ObIdl_MAccQuickQryFeeSPfBankBillFeeListHolder listPfBankFee, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_pfbankOweFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_pfbankOweFee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listPfBankFee.value = (ObIdl_MAccQuickQryFeeSPfBankBillFee[]) _output.get(new javax.xml.namespace.QName("", "listPfBankFee"));
            } catch (java.lang.Exception _exception) {
                listPfBankFee.value = (ObIdl_MAccQuickQryFeeSPfBankBillFee[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listPfBankFee")), ObIdl_MAccQuickQryFeeSPfBankBillFee[].class);
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

    public int query_gtBookV2(MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strPhoneId, ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listGtBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_gtBookV2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_gtBookV2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llAcctId), strQryFlag, strPhoneId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listGtBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) _output.get(new javax.xml.namespace.QName("", "listGtBook"));
            } catch (java.lang.Exception _exception) {
                listGtBook.value = (ObIdl_MAccQuickQryFeeSQryRegularBookOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listGtBook")), ObIdl_MAccQuickQryFeeSQryRegularBookOut[].class);
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

    public int query_userOweFeeRefund(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookAmtRefund, javax.xml.rpc.holders.LongHolder llBookAmtNoRefund, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, javax.xml.rpc.holders.LongHolder llFrontSubSpecBook, javax.xml.rpc.holders.LongHolder llSubSpecBook, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccQuickQryFee.IAccQuickQryFee#query_userOweFeeRefund");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccQuickQryFee.IAccQuickQryFee", "query_userOweFeeRefund"));

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
                llBookAmtRefund.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBookAmtRefund"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBookAmtRefund.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBookAmtRefund")), long.class)).longValue();
            }
            try {
                llBookAmtNoRefund.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llBookAmtNoRefund"))).longValue();
            } catch (java.lang.Exception _exception) {
                llBookAmtNoRefund.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llBookAmtNoRefund")), long.class)).longValue();
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
                llFrontSubSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llFrontSubSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llFrontSubSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llFrontSubSpecBook")), long.class)).longValue();
            }
            try {
                llSubSpecBook.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llSubSpecBook"))).longValue();
            } catch (java.lang.Exception _exception) {
                llSubSpecBook.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llSubSpecBook")), long.class)).longValue();
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
