/**
 * ObIdl_MAccPayFeeIAccPayFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public interface ObIdl_MAccPayFee_IAccPayFee extends java.rmi.Remote {
    public int do_payFee(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSPayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSPayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int gen_monthInvc(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSMonthInvcIn sMonInvcIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSMonthInvcOutHolder sMonInvcOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int tran_posSvr(MObdCommonSOBSessionProperty[] sSession, java.lang.String strSpkg, javax.xml.rpc.holders.StringHolder strRpkg, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int do_payFeeSimple(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSSimplePayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSSimplePayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int do_payFeeCross(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSCrossPayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSCrossPayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int do_payFeeBank(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSInvoicePayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSBankPayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int do_payFeeInvoice(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSInvoicePayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSInvoicePayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
    public int do_payFeeCm(MObdCommonSOBSessionProperty[] sSession, ObIdl_MAccCommonSCmPayFeeIn sPayFeeIn, com.asiainfo.obd.accpayfee.holders.ObIdl_MAccCommonSSimplePayFeeOutHolder sPayFeeOut, com.asiainfo.obd.accpayfee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.accpayfee.CORBASystemException;
}
