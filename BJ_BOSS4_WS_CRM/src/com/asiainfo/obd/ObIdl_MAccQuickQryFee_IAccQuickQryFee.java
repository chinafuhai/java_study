/**
 * ObIdl_MAccQuickQryFee_IAccQuickQryFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd;

public interface ObIdl_MAccQuickQryFee_IAccQuickQryFee extends java.rmi.Remote {
    public int query_oweFee(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException;
    public int query_ocsBalance(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.ObIdl_MAccQuickQryFeeSOcsBalanceQuery sQuery, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSOcsBalanceHolder sOcsBalance, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException;
    public int query_bankBalance(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strRequest, javax.xml.rpc.holders.StringHolder strResponse, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException;
    public int query_userOweFee(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException;
    public int query_advancedAndDepositPayment(com.asiainfo.obd.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, com.asiainfo.obd.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.CORBASystemException;
}