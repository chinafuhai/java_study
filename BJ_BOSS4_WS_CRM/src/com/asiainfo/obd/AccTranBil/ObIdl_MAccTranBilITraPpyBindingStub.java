/**
 * ObIdl_MAccTranBilITraPpyBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccTranBil;
import com.asiainfo.obd.AccTranBil.holders.*;
public class ObIdl_MAccTranBilITraPpyBindingStub extends org.apache.axis.client.Stub implements ObIdl_MAccTranBil_ITraPpy {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[33];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_exec");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBilIn"), ObIdl_MAccTranBilSAccTranBilIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_execReturn"));
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
        oper.setName("do_selectPpy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyIn"), ObIdl_MAccTranBilSAccQryPpyIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyOutList"), ObIdl_MAccTranBilSAccQryPpyOut[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_selectPpyReturn"));
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
        oper.setName("do_mppyDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccModiDateIn"), ObIdl_MAccTranBilSAccModiDateIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_mppyDateReturn"));
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
        oper.setName("do_backout");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBackOutBook"), ObIdl_MAccTranBilSBackOutBook.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBackOutBook"), ObIdl_MAccTranBilSBackOutBook.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_backoutReturn"));
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
        oper.setName("do_unPpyRefund");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnPpyRefundIn"), ObIdl_MAccTranBilSUnPpyRefundIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_unPpyRefundReturn"));
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
        oper.setName("do_execReturnFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBilIn"), ObIdl_MAccTranBilSAccTranBilIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAccTraAcct"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnAccList"), ObIdl_MAccTranBilSReturnAcc[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_execReturnFeeReturn"));
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
        oper.setName("do_addBatchPay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sBatchInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBatchInfo"), ObIdl_MAccTranBilSBatchInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInBatchPay"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList"), ObIdl_MAccTranBilSAccBatchPay[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOutBatchPay"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList"), ObIdl_MAccTranBilSAccBatchPay[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_addBatchPayReturn"));
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
        oper.setName("do_queryBatchPay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SQueryBatchPayIn"), ObIdl_MAccTranBilSQueryBatchPayIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOutBatchPay"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList"), ObIdl_MAccTranBilSAccBatchPay[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_queryBatchPayReturn"));
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
        oper.setName("do_batchUnPay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sBatchInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBatchInfo"), ObIdl_MAccTranBilSBatchInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInBatchPay"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList"), ObIdl_MAccTranBilSAccBatchPay[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOutBatchPay"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList"), ObIdl_MAccTranBilSAccBatchPay[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_batchUnPayReturn"));
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
        oper.setName("get_channelPayAcctId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAgentRecruitAcc"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentRecruitAccList"), ObIdl_MAccTranBilSAgentRecruitAcc[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_channelPayAcctIdReturn"));
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
        oper.setName("do_agentRecruitAcc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sRecruitAccCond"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccCond"), ObIdl_MAccTranBilSRecruitAccCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sRecruitAccOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccOut"), ObIdl_MAccTranBilSRecruitAccOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_agentRecruitAccReturn"));
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
        oper.setName("do_agentRecruitAccTrans");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sRecruitAccTransCond"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccTransCond"), ObIdl_MAccTranBilSRecruitAccTransCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sRecruitAccTransOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccTransOut"), ObIdl_MAccTranBilSRecruitAccTransOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llDoneCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_agentRecruitAccTransReturn"));
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
        oper.setName("get_agentOrgDept");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llChannelId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iProvinceId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iCityId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionDetail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strDeptName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iChannelType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAgentDept"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentOrgDeptList"), ObIdl_MAccTranBilSAgentOrgDept[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_agentOrgDeptReturn"));
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
        oper.setName("do_agentBusiFee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sAgentBusiFeeCond"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentBusiFeeCond"), ObIdl_MAccTranBilSAgentBusiFeeCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_agentBusiFeeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_agentAirDepositParam");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sAgentAirDepParamCond"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepParamCond"), ObIdl_MAccTranBilSAgentAirDepParamCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAgentAirDepositParam"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParamList"), ObIdl_MAccTranBilSAgentAirDepositParam[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_agentAirDepositParamReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("add_agentAirDepositParam");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sAgentAirDepositParam"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParam"), ObIdl_MAccTranBilSAgentAirDepositParam.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llDoneCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "add_agentAirDepositParamReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chg_agentAirDepositParam");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sAgentAirDepositParam"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParam"), ObIdl_MAccTranBilSAgentAirDepositParam.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llDoneCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chg_agentAirDepositParamReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("del_agentAirDepositParam");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sAgentAirDepositParam"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParam"), ObIdl_MAccTranBilSAgentAirDepositParam.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llDoneCode"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "del_agentAirDepositParamReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_agentAccInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sCond"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfoCond"), ObIdl_MAccTranBilSAgentAccInfoCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listAgentAccInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfoList"), ObIdl_MAccTranBilSAgentAccInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_agentAccInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_ppyAdj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccPpyAdjIn"), ObIdl_MAccTranBilSAccPpyAdjIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_ppyAdjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update_unpn");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sUnpnIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnIn"), ObIdl_MAccTranBilSUnpnIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listUnpn"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnList"), ObIdl_MAccTranBilSUnpn[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "update_unpnReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_accUnpnRec");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sUppnRecIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnRec"), ObIdl_MAccTranBilSUnpnRec.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listUppnRecOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnRecList"), ObIdl_MAccTranBilSUnpnRec[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "get_accUnpnRecReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_adjFileInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strBillCycle"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strFileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iBusiType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dtmBegin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dtmEnd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listDataOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjFileInfoList"), ObIdl_MAccTranBilSAccAdjFileInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_adjFileInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_batchSpDoubleBack");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfoList"), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSoInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSoInfo"), ObIdl_MAccTranBilSAccAdjSoInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfoList"), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_batchSpDoubleBackReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_batchSpDoubleBackRefund");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfoList"), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSoInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSoInfo"), ObIdl_MAccTranBilSAccAdjSoInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfoList"), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_batchSpDoubleBackRefundReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_batchAdjustBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfoList"), ObIdl_MAccTranBilSAccAdjBookInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSoInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSoInfo"), ObIdl_MAccTranBilSAccAdjSoInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfoList"), ObIdl_MAccTranBilSAccAdjBookInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_batchAdjustBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_batchAdjustBookRefund");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strBillCycle"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strFileName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iBusiType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dtmBegin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dtmEnd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_batchAdjustBookRefundReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_adjustBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llCustId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strBillCycle"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iFeeItemId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nAdjustFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nBrand"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strReasonDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_adjustBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_payCreditBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookIn"), ObIdl_MAccTranBilSPayCreditBookIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookOut"), ObIdl_MAccTranBilSPayCreditBookOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_payCreditBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_unpayCreditBook");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpayCreditBookIn"), ObIdl_MAccTranBilSUnpayCreditBookIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpayCreditBookOut"), ObIdl_MAccTranBilSUnpayCreditBookOut.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_unpayCreditBookReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_adjustMsBalance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAdjAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRealAdjAmount"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_adjustMsBalanceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_changeIntellnetCycle");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_changeIntellnetCycleReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_transferSubscriber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iBusiType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOldAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llNewAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_transferSubscriberReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[32] = oper;

    }

    public ObIdl_MAccTranBilITraPpyBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MAccTranBilITraPpyBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MAccTranBilITraPpyBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SCbsErrorMsg");
            cachedSerQNames.add(qName);
            cls = MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjBookInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjBookInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjBookInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjFileInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjFileInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjFileInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjFileInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjFileInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSoInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjSoInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjSpBackInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccAdjSpBackInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccAdjSpBackInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPay");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccBatchPay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPayList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccBatchPay[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBatchPay");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBookDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccBookDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBookDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccBookDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccBookDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccModiDateIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccModiDateIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccPpyAdjIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccPpyAdjIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccQryPpyIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccQryPpyOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyOutList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccQryPpyOut[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccQryPpyOut");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranAcct");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccTranAcct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranAcctList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccTranAcct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranAcct");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBilIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccTranBilIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBookDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccTranBookDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBookDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAccTranBookDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAccTranBookDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAccInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfoCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAccInfoCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAccInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAccInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParam");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAirDepositParam.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParamList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAirDepositParam[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepositParam");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentAirDepParamCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentAirDepParamCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentBusiFeeCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentBusiFeeCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentOrgDept");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentOrgDept.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentOrgDeptList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentOrgDept[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentOrgDept");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentRecruitAcc");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentRecruitAcc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentRecruitAccList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSAgentRecruitAcc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SAgentRecruitAcc");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBackOutBook");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSBackOutBook.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SBatchInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSBatchInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSPayCreditBookIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SPayCreditBookOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSPayCreditBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SQueryBatchPayIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSQueryBatchPayIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSRecruitAccCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSRecruitAccOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccTransCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSRecruitAccTransCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SRecruitAccTransOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSRecruitAccTransOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnAcc");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSReturnAcc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnAccList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSReturnAcc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnAcc");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnBookDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSReturnBookDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnBookDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSReturnBookDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SReturnBookDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpayCreditBookIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpayCreditBookIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpayCreditBookOut");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpayCreditBookOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpnIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpn");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnRec");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpnRec.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnRecList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnpnRec[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnpnRec");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccTranBil/", "ObIdl_MAccTranBil.SUnPpyRefundIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccTranBilSUnPpyRefundIn.class;
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

    public int do_exec(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccTranBilIn sIn, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_exec");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_exec"));

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
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int do_selectPpy(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccQryPpyIn sIn, ObIdl_MAccTranBilSAccQryPpyOutListHolder listOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_selectPpy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_selectPpy"));

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
                listOut.value = (ObIdl_MAccTranBilSAccQryPpyOut[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (ObIdl_MAccTranBilSAccQryPpyOut[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), ObIdl_MAccTranBilSAccQryPpyOut[].class);
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

    public int do_mppyDate(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccModiDateIn sIn, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_mppyDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_mppyDate"));

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
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int do_backout(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSBackOutBook sIn, ObIdl_MAccTranBilSBackOutBookHolder sOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_backout");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_backout"));

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
                sOut.value = (ObIdl_MAccTranBilSBackOutBook) _output.get(new javax.xml.namespace.QName("", "sOut"));
            } catch (java.lang.Exception _exception) {
                sOut.value = (ObIdl_MAccTranBilSBackOutBook) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sOut")), ObIdl_MAccTranBilSBackOutBook.class);
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

    public int do_unPpyRefund(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSUnPpyRefundIn sIn, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_unPpyRefund");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_unPpyRefund"));

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
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int do_execReturnFee(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccTranBilIn sIn, javax.xml.rpc.holders.LongHolder llRetSoNbr, ObIdl_MAccTranBilSReturnAccListHolder listAccTraAcct, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_execReturnFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_execReturnFee"));

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
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
            }
            try {
                listAccTraAcct.value = (ObIdl_MAccTranBilSReturnAcc[]) _output.get(new javax.xml.namespace.QName("", "listAccTraAcct"));
            } catch (java.lang.Exception _exception) {
                listAccTraAcct.value = (ObIdl_MAccTranBilSReturnAcc[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAccTraAcct")), ObIdl_MAccTranBilSReturnAcc[].class);
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

    public int do_addBatchPay(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSBatchInfo sBatchInfo, ObIdl_MAccTranBilSAccBatchPay[] listInBatchPay, ObIdl_MAccTranBilSAccBatchPayListHolder listOutBatchPay, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_addBatchPay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_addBatchPay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sBatchInfo, listInBatchPay});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) _output.get(new javax.xml.namespace.QName("", "listOutBatchPay"));
            } catch (java.lang.Exception _exception) {
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOutBatchPay")), ObIdl_MAccTranBilSAccBatchPay[].class);
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

    public int do_queryBatchPay(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSQueryBatchPayIn sIn, ObIdl_MAccTranBilSAccBatchPayListHolder listOutBatchPay, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_queryBatchPay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_queryBatchPay"));

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
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) _output.get(new javax.xml.namespace.QName("", "listOutBatchPay"));
            } catch (java.lang.Exception _exception) {
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOutBatchPay")), ObIdl_MAccTranBilSAccBatchPay[].class);
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

    public int do_batchUnPay(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSBatchInfo sBatchInfo, ObIdl_MAccTranBilSAccBatchPay[] listInBatchPay,ObIdl_MAccTranBilSAccBatchPayListHolder listOutBatchPay, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_batchUnPay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_batchUnPay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sBatchInfo, listInBatchPay});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) _output.get(new javax.xml.namespace.QName("", "listOutBatchPay"));
            } catch (java.lang.Exception _exception) {
                listOutBatchPay.value = (ObIdl_MAccTranBilSAccBatchPay[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOutBatchPay")), ObIdl_MAccTranBilSAccBatchPay[].class);
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

    public int get_channelPayAcctId(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, java.lang.String strPhoneId, ObIdl_MAccTranBilSAgentRecruitAccListHolder listAgentRecruitAcc, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#get_channelPayAcctId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "get_channelPayAcctId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), strPhoneId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listAgentRecruitAcc.value = (ObIdl_MAccTranBilSAgentRecruitAcc[]) _output.get(new javax.xml.namespace.QName("", "listAgentRecruitAcc"));
            } catch (java.lang.Exception _exception) {
                listAgentRecruitAcc.value = (ObIdl_MAccTranBilSAgentRecruitAcc[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAgentRecruitAcc")), ObIdl_MAccTranBilSAgentRecruitAcc[].class);
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

    public int do_agentRecruitAcc(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSRecruitAccCond sRecruitAccCond, ObIdl_MAccTranBilSRecruitAccOutHolder sRecruitAccOut, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_agentRecruitAcc");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_agentRecruitAcc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sRecruitAccCond});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sRecruitAccOut.value = (ObIdl_MAccTranBilSRecruitAccOut) _output.get(new javax.xml.namespace.QName("", "sRecruitAccOut"));
            } catch (java.lang.Exception _exception) {
                sRecruitAccOut.value = (ObIdl_MAccTranBilSRecruitAccOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sRecruitAccOut")), ObIdl_MAccTranBilSRecruitAccOut.class);
            }
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int do_agentRecruitAccTrans(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSRecruitAccTransCond sRecruitAccTransCond, ObIdl_MAccTranBilSRecruitAccTransOutHolder sRecruitAccTransOut, javax.xml.rpc.holders.LongHolder llDoneCode, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_agentRecruitAccTrans");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_agentRecruitAccTrans"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sRecruitAccTransCond});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                sRecruitAccTransOut.value = (ObIdl_MAccTranBilSRecruitAccTransOut) _output.get(new javax.xml.namespace.QName("", "sRecruitAccTransOut"));
            } catch (java.lang.Exception _exception) {
                sRecruitAccTransOut.value = (ObIdl_MAccTranBilSRecruitAccTransOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sRecruitAccTransOut")), ObIdl_MAccTranBilSRecruitAccTransOut.class);
            }
            try {
                llDoneCode.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llDoneCode"))).longValue();
            } catch (java.lang.Exception _exception) {
                llDoneCode.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llDoneCode")), long.class)).longValue();
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

    public int get_agentOrgDept(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, long llChannelId, int iProvinceId, int iCityId, int iRegionType, int iRegionDetail, java.lang.String strDeptName, int iChannelType, ObIdl_MAccTranBilSAgentOrgDeptListHolder listAgentDept, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#get_agentOrgDept");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "get_agentOrgDept"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), new java.lang.Long(llChannelId), new java.lang.Integer(iProvinceId), new java.lang.Integer(iCityId), new java.lang.Integer(iRegionType), new java.lang.Integer(iRegionDetail), strDeptName, new java.lang.Integer(iChannelType)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listAgentDept.value = (ObIdl_MAccTranBilSAgentOrgDept[]) _output.get(new javax.xml.namespace.QName("", "listAgentDept"));
            } catch (java.lang.Exception _exception) {
                listAgentDept.value = (ObIdl_MAccTranBilSAgentOrgDept[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAgentDept")), ObIdl_MAccTranBilSAgentOrgDept[].class);
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

    public int do_agentBusiFee(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentBusiFeeCond sAgentBusiFeeCond, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_agentBusiFee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_agentBusiFee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sAgentBusiFeeCond});

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

    public int get_agentAirDepositParam(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentAirDepParamCond sAgentAirDepParamCond, ObIdl_MAccTranBilSAgentAirDepositParamListHolder listAgentAirDepositParam, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#get_agentAirDepositParam");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "get_agentAirDepositParam"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sAgentAirDepParamCond});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listAgentAirDepositParam.value = (ObIdl_MAccTranBilSAgentAirDepositParam[]) _output.get(new javax.xml.namespace.QName("", "listAgentAirDepositParam"));
            } catch (java.lang.Exception _exception) {
                listAgentAirDepositParam.value = (ObIdl_MAccTranBilSAgentAirDepositParam[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAgentAirDepositParam")), ObIdl_MAccTranBilSAgentAirDepositParam[].class);
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

    public int add_agentAirDepositParam(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentAirDepositParam sAgentAirDepositParam, javax.xml.rpc.holders.LongHolder llDoneCode, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#add_agentAirDepositParam");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "add_agentAirDepositParam"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sAgentAirDepositParam});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llDoneCode.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llDoneCode"))).longValue();
            } catch (java.lang.Exception _exception) {
                llDoneCode.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llDoneCode")), long.class)).longValue();
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

    public int chg_agentAirDepositParam(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentAirDepositParam sAgentAirDepositParam, javax.xml.rpc.holders.LongHolder llDoneCode, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#chg_agentAirDepositParam");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "chg_agentAirDepositParam"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sAgentAirDepositParam});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llDoneCode.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llDoneCode"))).longValue();
            } catch (java.lang.Exception _exception) {
                llDoneCode.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llDoneCode")), long.class)).longValue();
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

    public int del_agentAirDepositParam(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentAirDepositParam sAgentAirDepositParam, javax.xml.rpc.holders.LongHolder llDoneCode, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#del_agentAirDepositParam");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "del_agentAirDepositParam"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sAgentAirDepositParam});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llDoneCode.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llDoneCode"))).longValue();
            } catch (java.lang.Exception _exception) {
                llDoneCode.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llDoneCode")), long.class)).longValue();
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

    public int get_agentAccInfo(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgId, ObIdl_MAccTranBilSAgentAccInfoCond sCond, ObIdl_MAccTranBilSAgentAccInfoListHolder listAgentAccInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#get_agentAccInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "get_agentAccInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), sCond});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listAgentAccInfo.value = (ObIdl_MAccTranBilSAgentAccInfo[]) _output.get(new javax.xml.namespace.QName("", "listAgentAccInfo"));
            } catch (java.lang.Exception _exception) {
                listAgentAccInfo.value = (ObIdl_MAccTranBilSAgentAccInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listAgentAccInfo")), ObIdl_MAccTranBilSAgentAccInfo[].class);
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

    public int do_ppyAdj(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccPpyAdjIn sIn, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_ppyAdj");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_ppyAdj"));

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
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int update_unpn(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSUnpnIn sUnpnIn, ObIdl_MAccTranBilSUnpnListHolder listUnpn,MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#update_unpn");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "update_unpn"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sUnpnIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listUnpn.value = (ObIdl_MAccTranBilSUnpn[]) _output.get(new javax.xml.namespace.QName("", "listUnpn"));
            } catch (java.lang.Exception _exception) {
                listUnpn.value = (ObIdl_MAccTranBilSUnpn[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listUnpn")), ObIdl_MAccTranBilSUnpn[].class);
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

    public int get_accUnpnRec(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSUnpnRec sUppnRecIn, ObIdl_MAccTranBilSUnpnRecListHolder listUppnRecOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#get_accUnpnRec");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "get_accUnpnRec"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sUppnRecIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listUppnRecOut.value = (ObIdl_MAccTranBilSUnpnRec[]) _output.get(new javax.xml.namespace.QName("", "listUppnRecOut"));
            } catch (java.lang.Exception _exception) {
                listUppnRecOut.value = (ObIdl_MAccTranBilSUnpnRec[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listUppnRecOut")), ObIdl_MAccTranBilSUnpnRec[].class);
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

    public int query_adjFileInfo(MObdCommonSOBSessionProperty[] sSession, long llSoNbr, java.lang.String strPhoneId, java.lang.String strBillCycle, java.lang.String strFileName, int iBusiType, java.lang.String dtmBegin, java.lang.String dtmEnd, ObIdl_MAccTranBilSAccAdjFileInfoListHolder listDataOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#query_adjFileInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "query_adjFileInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llSoNbr), strPhoneId, strBillCycle, strFileName, new java.lang.Integer(iBusiType), dtmBegin, dtmEnd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listDataOut.value = (ObIdl_MAccTranBilSAccAdjFileInfo[]) _output.get(new javax.xml.namespace.QName("", "listDataOut"));
            } catch (java.lang.Exception _exception) {
                listDataOut.value = (ObIdl_MAccTranBilSAccAdjFileInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listDataOut")), ObIdl_MAccTranBilSAccAdjFileInfo[].class);
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

    public int do_batchSpDoubleBack(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccAdjSpBackInfo[] listIn, ObIdl_MAccTranBilSAccAdjSoInfo sSoInfo, ObIdl_MAccTranBilSAccAdjSpBackInfoListHolder listOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_batchSpDoubleBack");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_batchSpDoubleBack"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, listIn, sSoInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (ObIdl_MAccTranBilSAccAdjSpBackInfo[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (ObIdl_MAccTranBilSAccAdjSpBackInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class);
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

    public int do_batchSpDoubleBackRefund(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccAdjSpBackInfo[] listIn, ObIdl_MAccTranBilSAccAdjSoInfo sSoInfo, ObIdl_MAccTranBilSAccAdjSpBackInfoListHolder listOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_batchSpDoubleBackRefund");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_batchSpDoubleBackRefund"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, listIn, sSoInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (ObIdl_MAccTranBilSAccAdjSpBackInfo[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (ObIdl_MAccTranBilSAccAdjSpBackInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), ObIdl_MAccTranBilSAccAdjSpBackInfo[].class);
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

    public int do_batchAdjustBook(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSAccAdjBookInfo[] listIn, ObIdl_MAccTranBilSAccAdjSoInfo sSoInfo, ObIdl_MAccTranBilSAccAdjBookInfoListHolder listOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_batchAdjustBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_batchAdjustBook"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, listIn, sSoInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listOut.value = (ObIdl_MAccTranBilSAccAdjBookInfo[]) _output.get(new javax.xml.namespace.QName("", "listOut"));
            } catch (java.lang.Exception _exception) {
                listOut.value = (ObIdl_MAccTranBilSAccAdjBookInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listOut")), ObIdl_MAccTranBilSAccAdjBookInfo[].class);
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

    public int do_batchAdjustBookRefund(MObdCommonSOBSessionProperty[] sSession, long llSoNbr, java.lang.String strPhoneId, java.lang.String strBillCycle, java.lang.String strFileName, int iBusiType, java.lang.String dtmBegin, java.lang.String dtmEnd, java.lang.String strOtherSoNbr, int iOpId, int iSoOrgId, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_batchAdjustBookRefund");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_batchAdjustBookRefund"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llSoNbr), strPhoneId, strBillCycle, strFileName, new java.lang.Integer(iBusiType), dtmBegin, dtmEnd, strOtherSoNbr, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
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

    public int do_adjustBook(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llCustId, java.lang.String strBillCycle, long llAmount, int iFeeItemId, short nAdjustFlag, short nBrand, java.lang.String strOtherSoNbr, java.lang.String strReasonDesc, int iOpId, int iSoOrgId, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_adjustBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_adjustBook"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, new java.lang.Long(llCustId), strBillCycle, new java.lang.Long(llAmount), new java.lang.Integer(iFeeItemId), new java.lang.Short(nAdjustFlag), new java.lang.Short(nBrand), strOtherSoNbr, strReasonDesc, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId)});

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

    public int do_payCreditBook(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSPayCreditBookIn sIn, ObIdl_MAccTranBilSPayCreditBookOutHolder sOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_payCreditBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_payCreditBook"));

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
                sOut.value = (ObIdl_MAccTranBilSPayCreditBookOut) _output.get(new javax.xml.namespace.QName("", "sOut"));
            } catch (java.lang.Exception _exception) {
                sOut.value = (ObIdl_MAccTranBilSPayCreditBookOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sOut")), ObIdl_MAccTranBilSPayCreditBookOut.class);
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

    public int do_unpayCreditBook(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccTranBilSUnpayCreditBookIn sIn, ObIdl_MAccTranBilSUnpayCreditBookOutHolder sOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_unpayCreditBook");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_unpayCreditBook"));

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
                sOut.value = (ObIdl_MAccTranBilSUnpayCreditBookOut) _output.get(new javax.xml.namespace.QName("", "sOut"));
            } catch (java.lang.Exception _exception) {
                sOut.value = (ObIdl_MAccTranBilSUnpayCreditBookOut) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sOut")), ObIdl_MAccTranBilSUnpayCreditBookOut.class);
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

    public int do_adjustMsBalance(MObdCommonSOBSessionProperty[] sSession, int iFlag, java.lang.String strPhoneId, java.lang.String strOtherSoNbr, long llAdjAmount, int iOpId, int iSoOrgId, java.lang.String strRemark, javax.xml.rpc.holders.LongHolder llRealAdjAmount, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_adjustMsBalance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_adjustMsBalance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iFlag), strPhoneId, strOtherSoNbr, new java.lang.Long(llAdjAmount), new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), strRemark});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                llRealAdjAmount.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRealAdjAmount"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRealAdjAmount.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRealAdjAmount")), long.class)).longValue();
            }
            try {
                llRetSoNbr.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int do_changeIntellnetCycle(MObdCommonSOBSessionProperty[] sSession, int iFlag, java.lang.String strPhoneId, java.lang.String strOtherSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_changeIntellnetCycle");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_changeIntellnetCycle"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iFlag), strPhoneId, strOtherSoNbr});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
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

    public int do_transferSubscriber(MObdCommonSOBSessionProperty[] sSession, int iBusiType, long llOldAcctId, long llNewAcctId, int iOpId, int iSoOrgId, java.lang.String strRemark, java.lang.String strOtherSoNbr, javax.xml.rpc.holders.LongHolder llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccTranBil.ITraPpy#do_transferSubscriber");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccTranBil.ITraPpy", "do_transferSubscriber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iBusiType), new java.lang.Long(llOldAcctId), new java.lang.Long(llNewAcctId), new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgId), strRemark, strOtherSoNbr});
 //java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iBusiType), new java.lang.Long(llOldAcctId), new java.lang.Long(llNewAcctId)});
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
