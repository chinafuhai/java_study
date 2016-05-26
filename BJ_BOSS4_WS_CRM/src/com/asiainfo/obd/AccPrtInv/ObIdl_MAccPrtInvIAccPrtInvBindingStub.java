/**
 * ObIdl_MAccPrtInvIAccPrtInvBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccPrtInv;
import com.asiainfo.obd.AccPrtInv.holders.*;

public class ObIdl_MAccPrtInvIAccPrtInvBindingStub extends org.apache.axis.client.Stub implements ObIdl_MAccPrtInv_IAccPrtInv {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[23];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_invoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentIn"), ObIdl_MAccPrtInvDefSInvContentIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvContent"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentList"), ObIdl_MAccPrtInvDefSInvContent[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_invoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_invoiceDtl");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSeqNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcDtl"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcDtlList"), ObIdl_MAccPrtInvDefSInvcDtl[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_invoiceDtlReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("print_invoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nPrintCount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSeqNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strReason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "print_invoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("print_max");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iPrtMaxCnt"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "print_maxReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_regInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nPrintCount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nIsAdCon"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nIsCoinCredit"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SBankTrustQryIn"), ObIdl_MAccPrtInvDefSBankTrustQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvContent"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentList"), ObIdl_MAccPrtInvDefSInvContent[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_regInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_invoiceAux");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentIn"), ObIdl_MAccPrtInvDefSInvContentIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvContent"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvAuxContentList"), ObIdl_MAccPrtInvDefSInvAuxContent[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_invoiceAuxReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_spInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContentIn"), ObIdl_MAccPrtInvDefSSpInvContentIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listSpInvContent"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContentList"), ObIdl_MAccPrtInvDefSSpInvContent[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_spInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_cancelInvc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelInList"), ObIdl_MAccPrtInvDefSInvCancelIn[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvContent"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelList"), ObIdl_MAccPrtInvDefSInvCancel[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_cancelInvcReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("print_invoiceRes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvPrintIn"), ObIdl_MAccPrtInvDefSInvPrintIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "print_invoiceResReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modify_invcDtl");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSeqNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strInvcDtl"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "modify_invcDtlReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_receipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcQryIn"), ObIdl_MAccPrtInvDefSInvcQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_receiptReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("process_taxInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strTaxInvcInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "process_taxInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update_printCount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llInvcNumSeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "update_printCountReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("do_minusInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbrOld"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llInvcNumSeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "nInvcSts"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "do_minusInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_arcInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llAcctId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iRegionCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonthBegin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonthEnd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llInvcNumSeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iInvcCallFlag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_arcInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("prt_otaReceipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrtOtaReceiptIn"), ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfo"), ObIdl_MAccCommonSAccInvcRecInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "prt_otaReceiptReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("qry_prepayInvcInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrepayInvcQryIn"), ObIdl_MAccPrtInvDefSPrepayInvcQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcInfoList"), ObIdl_MAccPrtInvDefSInvcInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "qry_prepayInvcInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("upd_receiptInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcUpdCond"), ObIdl_MAccPrtInvDefSInvcUpdCond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcUpdResult"), ObIdl_MAccPrtInvDefSInvcUpdResult.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "upd_receiptInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_receiptSpdb");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcQryInSpdb"), ObIdl_MAccPrtInvDefSInvcQryInSpdb.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listInvcRecInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList"), ObIdl_MAccCommonSAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_receiptSpdbReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update_printCountSpdb");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llInvcNumSeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strSpdbQrySeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPrintTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strReserve"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "update_printCountSpdbReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("adjust_taxInvoiceReason");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strOtherSoNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iPayType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceipt"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptTypeList"), ObIdl_MBusiChargeDefSAccBusiReceiptType[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listReceiptReason"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SReceiptAdjustReasonList"), ObIdl_MBusiChargeDefSReceiptAdjustReason[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecInfoList"), ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llRetSoNbr"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "adjust_taxInvoiceReasonReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query_taxReceipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sIn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxInvcQryIn"), ObIdl_MAccPrtInvDefSTaxInvcQryIn.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecInfoList"), ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "query_taxReceiptReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update_taxInvoice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sSession"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession"), MObdCommonSOBSessionProperty[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llOpId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "iSoOrgid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPhoneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strMonth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "llInvcNumSeq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strInvoiceNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strInvoiceNum"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strTaxMachineCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strPrtTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strRemark"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strInvcPrtInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sErrorMsg"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg"), MObdCommonSCbsErrorMsg.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "update_taxInvoiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("", "_return"),
                      "org.omg.www.IDL_WSDL._1_0.CORBASystemException",
                      new javax.xml.namespace.QName("http://www.omg.org/IDL-WSDL/1.0/", "CORBA.SystemException"), 
                      true
                     ));
        _operations[22] = oper;

    }

    public ObIdl_MAccPrtInvIAccPrtInvBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ObIdl_MAccPrtInvIAccPrtInvBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ObIdl_MAccPrtInvIAccPrtInvBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SCbsErrorMsg");
            cachedSerQNames.add(qName);
            cls = MObdCommonSCbsErrorMsg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SIdlSession");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SOBSessionProperty");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "MObdCommon.SOBSessionProperty");
            cachedSerQNames.add(qName);
            cls = MObdCommonSOBSessionProperty.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccCommonSAccInvcRecInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccCommon.SAccInvcRecInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SBankTrustQryIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSBankTrustQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SCmTaxpayerInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSCmTaxpayerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvAuxContent");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvAuxContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvAuxContentList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvAuxContent[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvAuxContent");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancel");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancelIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelInList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancelIn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelIn");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancel[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancel");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelUnit");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancelUnit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelUnitList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvCancelUnit[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvCancelUnit");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcItem");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcItemList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcItem");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContent");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvContentIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContentList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvContent[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvContent");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcQryIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcQryInSpdb");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcQryInSpdb.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcUpdCond");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcUpdCond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvcUpdResult");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvcUpdResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SInvPrintIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSInvPrintIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrepayInvcQryIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSPrepayInvcQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SPrtOtaReceiptIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSPrtOtaReceiptIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContent");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSSpInvContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContentIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSSpInvContentIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContentList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSSpInvContent[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.SSpInvContent");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecDtl");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSTaxAccInvcRecDtl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecDtlList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSTaxAccInvcRecDtl[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecDtl");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecInfo");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecInfoList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxAccInvcRecInfo");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.STaxInvcQryIn");
            cachedSerQNames.add(qName);
            cls = ObIdl_MAccPrtInvDefSTaxInvcQryIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MAccPrtInvDef.StringList");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptItem");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSAccBusiReceiptItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptItemList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSAccBusiReceiptItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptItem");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptType");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSAccBusiReceiptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptTypeList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSAccBusiReceiptType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SAccBusiReceiptType");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SReceiptAdjustReason");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSReceiptAdjustReason.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SReceiptAdjustReasonList");
            cachedSerQNames.add(qName);
            cls = ObIdl_MBusiChargeDefSReceiptAdjustReason[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://AccPrtInv/", "ObIdl_MBusiChargeDef.SReceiptAdjustReason");
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

    public int query_invoice(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvContentIn sIn, ObIdl_MAccPrtInvDefSInvContentListHolder listInvContent, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_invoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_invoice"));

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
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvContent[]) _output.get(new javax.xml.namespace.QName("", "listInvContent"));
            } catch (java.lang.Exception _exception) {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvContent[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvContent")), ObIdl_MAccPrtInvDefSInvContent[].class);
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

    public int query_invoiceDtl(MObdCommonSOBSessionProperty[] sSession, long llSoNbr, long llSeqNbr, int iRegionCode, java.lang.String strMonth, ObIdl_MAccPrtInvDefSInvcDtlListHolder listInvcDtl, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_invoiceDtl");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_invoiceDtl"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llSoNbr), new java.lang.Long(llSeqNbr), new java.lang.Integer(iRegionCode), strMonth});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvcDtl.value = (ObIdl_MAccPrtInvDefSInvcDtl[]) _output.get(new javax.xml.namespace.QName("", "listInvcDtl"));
            } catch (java.lang.Exception _exception) {
                listInvcDtl.value = (ObIdl_MAccPrtInvDefSInvcDtl[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcDtl")), ObIdl_MAccPrtInvDefSInvcDtl[].class);
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

    public int print_invoice(MObdCommonSOBSessionProperty[] sSession, short nFlag, short nPrintCount, long llSoNbr, long llSeqNbr, int iOpId, java.lang.String strReason, int iRegionCode, java.lang.String strMonth, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#print_invoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "print_invoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Short(nFlag), new java.lang.Short(nPrintCount), new java.lang.Long(llSoNbr), new java.lang.Long(llSeqNbr), new java.lang.Integer(iOpId), strReason, new java.lang.Integer(iRegionCode), strMonth});

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

    public int print_max(MObdCommonSOBSessionProperty[] sSession, int iRegionCode, javax.xml.rpc.holders.IntHolder iPrtMaxCnt, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#print_max");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "print_max"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iRegionCode)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                iPrtMaxCnt.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("", "iPrtMaxCnt"))).intValue();
            } catch (java.lang.Exception _exception) {
                iPrtMaxCnt.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "iPrtMaxCnt")), int.class)).intValue();
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

    public int query_regInvoice(MObdCommonSOBSessionProperty[] sSession, short nPrintCount, short nIsAdCon, short nIsCoinCredit, ObIdl_MAccPrtInvDefSBankTrustQryIn sIn, ObIdl_MAccPrtInvDefSInvContentListHolder listInvContent, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_regInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_regInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Short(nPrintCount), new java.lang.Short(nIsAdCon), new java.lang.Short(nIsCoinCredit), sIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvContent[]) _output.get(new javax.xml.namespace.QName("", "listInvContent"));
            } catch (java.lang.Exception _exception) {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvContent[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvContent")), ObIdl_MAccPrtInvDefSInvContent[].class);
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

    public int query_invoiceAux(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvContentIn sIn, ObIdl_MAccPrtInvDefSInvAuxContentListHolder listInvContent, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_invoiceAux");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_invoiceAux"));

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
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvAuxContent[]) _output.get(new javax.xml.namespace.QName("", "listInvContent"));
            } catch (java.lang.Exception _exception) {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvAuxContent[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvContent")), ObIdl_MAccPrtInvDefSInvAuxContent[].class);
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

    public int query_spInvoice(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSSpInvContentIn sIn, ObIdl_MAccPrtInvDefSSpInvContentListHolder listSpInvContent, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_spInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_spInvoice"));

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
                listSpInvContent.value = (ObIdl_MAccPrtInvDefSSpInvContent[]) _output.get(new javax.xml.namespace.QName("", "listSpInvContent"));
            } catch (java.lang.Exception _exception) {
                listSpInvContent.value = (ObIdl_MAccPrtInvDefSSpInvContent[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listSpInvContent")), ObIdl_MAccPrtInvDefSSpInvContent[].class);
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

    public int query_cancelInvc(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvCancelIn[] listIn, ObIdl_MAccPrtInvDefSInvCancelListHolder listInvContent, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_cancelInvc");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_cancelInvc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, listIn});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvCancel[]) _output.get(new javax.xml.namespace.QName("", "listInvContent"));
            } catch (java.lang.Exception _exception) {
                listInvContent.value = (ObIdl_MAccPrtInvDefSInvCancel[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvContent")), ObIdl_MAccPrtInvDefSInvCancel[].class);
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

    public int print_invoiceRes(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvPrintIn sIn, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#print_invoiceRes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "print_invoiceRes"));

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

    public int modify_invcDtl(MObdCommonSOBSessionProperty[] sSession, long llSoNbr, long llSeqNbr, int iRegionCode, java.lang.String strMonth, java.lang.String strInvcDtl, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#modify_invcDtl");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "modify_invcDtl"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llSoNbr), new java.lang.Long(llSeqNbr), new java.lang.Integer(iRegionCode), strMonth, strInvcDtl});

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

    public int query_receipt(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvcQryIn sIn, ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcRecInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_receipt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_receipt"));

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
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcRecInfo")), ObIdl_MAccCommonSAccInvcRecInfo[].class);
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

    public int process_taxInfo(MObdCommonSOBSessionProperty[] sSession, java.lang.String strTaxInvcInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#process_taxInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "process_taxInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strTaxInvcInfo});

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

    public int update_printCount(MObdCommonSOBSessionProperty[] sSession, int iRegionCode, java.lang.String strPhoneId, java.lang.String strMonth, long llOpId, long llInvcNumSeq, java.lang.String strRemark, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#update_printCount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "update_printCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iRegionCode), strPhoneId, strMonth, new java.lang.Long(llOpId), new java.lang.Long(llInvcNumSeq), strRemark});

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

    public int do_minusInvoice(MObdCommonSOBSessionProperty[] sSession, int iRegionCode, java.lang.String strMonth, long llOpId, long llSoNbrOld, long llSoNbr, long llInvcNumSeq, short nInvcSts, java.lang.String strRemark, ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcRecInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#do_minusInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "do_minusInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iRegionCode), strMonth, new java.lang.Long(llOpId), new java.lang.Long(llSoNbrOld), new java.lang.Long(llSoNbr), new java.lang.Long(llInvcNumSeq), new java.lang.Short(nInvcSts), strRemark});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcRecInfo")), ObIdl_MAccCommonSAccInvcRecInfo[].class);
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

    public int query_arcInvoice(MObdCommonSOBSessionProperty[] sSession, long llOpId, long llAcctId, java.lang.String strPhoneId, int iRegionCode, java.lang.String strMonthBegin, java.lang.String strMonthEnd, long llInvcNumSeq, java.lang.String strRemark, int iInvcCallFlag, ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcRecInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_arcInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_arcInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llOpId), new java.lang.Long(llAcctId), strPhoneId, new java.lang.Integer(iRegionCode), strMonthBegin, strMonthEnd, new java.lang.Long(llInvcNumSeq), strRemark, new java.lang.Integer(iInvcCallFlag)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcRecInfo")), ObIdl_MAccCommonSAccInvcRecInfo[].class);
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

    public int prt_otaReceipt(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSPrtOtaReceiptIn sIn, ObIdl_MAccCommonSAccInvcRecInfoHolder sInvcRecInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#prt_otaReceipt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "prt_otaReceipt"));

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
                sInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo) _output.get(new javax.xml.namespace.QName("", "sInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                sInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "sInvcRecInfo")), ObIdl_MAccCommonSAccInvcRecInfo.class);
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

    public int qry_prepayInvcInfo(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSPrepayInvcQryIn sIn, ObIdl_MAccPrtInvDefSInvcInfoListHolder listInvcInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#qry_prepayInvcInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "qry_prepayInvcInfo"));

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
                listInvcInfo.value = (ObIdl_MAccPrtInvDefSInvcInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcInfo.value = (ObIdl_MAccPrtInvDefSInvcInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcInfo")), ObIdl_MAccPrtInvDefSInvcInfo[].class);
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

    public int upd_receiptInfo(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvcUpdCond sIn1, ObIdl_MAccPrtInvDefSInvcUpdResult sIn2, javax.xml.rpc.holders.StringHolder strOtherSoNbr, ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#upd_receiptInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "upd_receiptInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, sIn1, sIn2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                strOtherSoNbr.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "strOtherSoNbr"));
            } catch (java.lang.Exception _exception) {
                strOtherSoNbr.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "strOtherSoNbr")), java.lang.String.class);
            }
            try {
                listInvcInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcInfo")), ObIdl_MAccCommonSAccInvcRecInfo[].class);
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

    public int query_receiptSpdb(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSInvcQryInSpdb sIn, ObIdl_MAccCommonSAccInvcRecInfoListHolder listInvcRecInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_receiptSpdb");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_receiptSpdb"));

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
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listInvcRecInfo"));
            } catch (java.lang.Exception _exception) {
                listInvcRecInfo.value = (ObIdl_MAccCommonSAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listInvcRecInfo")), ObIdl_MAccCommonSAccInvcRecInfo[].class);
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

    public int update_printCountSpdb(MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, java.lang.String strMonth, long llOpId, long llInvcNumSeq, java.lang.String strOtherSoNbr, java.lang.String strSpdbQrySeq, java.lang.String strPrintTime, java.lang.String strReserve, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#update_printCountSpdb");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "update_printCountSpdb"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, strPhoneId, strMonth, new java.lang.Long(llOpId), new java.lang.Long(llInvcNumSeq), strOtherSoNbr, strSpdbQrySeq, strPrintTime, strReserve});

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

    public int adjust_taxInvoiceReason(MObdCommonSOBSessionProperty[] sSession, int iOpId, int iSoOrgid, java.lang.String strOtherSoNbr, int iPayType, ObIdl_MBusiChargeDefSAccBusiReceiptType[] listReceipt, ObIdl_MBusiChargeDefSReceiptAdjustReason[] listReceiptReason, ObIdl_MAccPrtInvDefSTaxAccInvcRecInfoListHolder listTaxInvcRecInfoOut, long llRetSoNbr, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#adjust_taxInvoiceReason");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "adjust_taxInvoiceReason"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Integer(iOpId), new java.lang.Integer(iSoOrgid), strOtherSoNbr, new java.lang.Integer(iPayType), listReceipt, listReceiptReason});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                listTaxInvcRecInfoOut.value = (ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut"));
            } catch (java.lang.Exception _exception) {
                listTaxInvcRecInfoOut.value = (ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut")), ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[].class);
            }
            try {
                llRetSoNbr = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "llRetSoNbr"))).longValue();
            } catch (java.lang.Exception _exception) {
                llRetSoNbr = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "llRetSoNbr")), long.class)).longValue();
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

    public int query_taxReceipt(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccPrtInvDefSTaxInvcQryIn sIn, ObIdl_MAccPrtInvDefSTaxAccInvcRecInfoListHolder listTaxInvcRecInfoOut, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#query_taxReceipt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "query_taxReceipt"));

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
                listTaxInvcRecInfoOut.value = (ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[]) _output.get(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut"));
            } catch (java.lang.Exception _exception) {
                listTaxInvcRecInfoOut.value = (ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "listTaxInvcRecInfoOut")), ObIdl_MAccPrtInvDefSTaxAccInvcRecInfo[].class);
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

    public int update_taxInvoice(MObdCommonSOBSessionProperty[] sSession, long llOpId, int iSoOrgid, java.lang.String strPhoneId, java.lang.String strMonth, long llInvcNumSeq, java.lang.String strInvoiceNo, java.lang.String strInvoiceNum, java.lang.String strTaxMachineCode, java.lang.String strPrtTime, java.lang.String strRemark, java.lang.String strInvcPrtInfo, MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, CORBASystemException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ObIdl_MAccPrtInv.IAccPrtInv#update_taxInvoice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ObIdl_MAccPrtInv.IAccPrtInv", "update_taxInvoice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sSession, new java.lang.Long(llOpId), new java.lang.Integer(iSoOrgid), strPhoneId, strMonth, new java.lang.Long(llInvcNumSeq), strInvoiceNo, strInvoiceNum, strTaxMachineCode, strPrtTime, strRemark, strInvcPrtInfo});

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

}
