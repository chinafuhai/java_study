/**
 * ObIdl_MAccQuickQryFeeIAccQuickQryFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.AccQuickQryFee;

public interface ObIdl_MAccQuickQryFeeIAccQuickQryFee extends java.rmi.Remote {
    public int query_oweFee(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_ocsBalance(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, com.asiainfo.obd.AccQuickQryFee.ObIdl_MAccQuickQryFeeSOcsBalanceQuery sQuery, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSOcsBalanceHolder sOcsBalance, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_bankBalance(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strRequest, javax.xml.rpc.holders.StringHolder strResponse, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_userOweFee(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, javax.xml.rpc.holders.LongHolder llFrontSubSpecBook, javax.xml.rpc.holders.LongHolder llSubSpecBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_userOweFeeExt(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSFrontSpecBookListHolder listFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSAfterSpecBookListHolder listAfterSpecBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_advancedAndDepositPayment(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_schemeBook(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutExtListHolder listSchemeBookExt, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_advancedAndDepositPayment2(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strResourceNumber, java.lang.String strStartDate, java.lang.String strEndDate, java.lang.String strPaymentType, java.lang.String strStatus, java.lang.String strCrmSapInstanceId, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listRegularBook, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQrySchemeBookOutListHolder listSchemeBook, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryDepositBookOutListHolder listDepositBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_gtBook(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strPhoneId, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSGtBookListHolder listGtBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_accountInfo(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, int iOpId, javax.xml.rpc.holders.LongHolder llAcctIdOut, javax.xml.rpc.holders.StringHolder strBalance, javax.xml.rpc.holders.ShortHolder nWriteOffFlag, javax.xml.rpc.holders.ShortHolder nLpcWavingInd, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_corBook(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strCrmSapInstanceId, long llCustId, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSGroupAmountListHolder listGroupAmount, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_pfbankOweFee(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSPfBankBillFeeListHolder listPfBankFee, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_gtBookV2(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, long llAcctId, java.lang.String strQryFlag, java.lang.String strPhoneId, com.asiainfo.obd.AccQuickQryFee.holders.ObIdl_MAccQuickQryFeeSQryRegularBookOutListHolder listGtBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
    public int query_userOweFeeRefund(com.asiainfo.obd.AccQuickQryFee.MObdCommonSOBSessionProperty[] sSession, java.lang.String strPhoneId, long llAcctId, short nRealTimeFeeFlag, short nItemType, javax.xml.rpc.holders.LongHolder llPreMonthFee, javax.xml.rpc.holders.LongHolder llCurMonthFee, javax.xml.rpc.holders.LongHolder llRealTimeFee, javax.xml.rpc.holders.LongHolder llBookAmt, javax.xml.rpc.holders.LongHolder llBookAmtRefund, javax.xml.rpc.holders.LongHolder llBookAmtNoRefund, javax.xml.rpc.holders.LongHolder llBookSub, javax.xml.rpc.holders.LongHolder llSpecBook, javax.xml.rpc.holders.LongHolder llTransInBook, javax.xml.rpc.holders.LongHolder llCreditBook, javax.xml.rpc.holders.LongHolder llFrontPreMonthFee, javax.xml.rpc.holders.LongHolder llFrontCurMonthFee, javax.xml.rpc.holders.LongHolder llFrontRealTimeFee, javax.xml.rpc.holders.LongHolder llFrontBookAmt, javax.xml.rpc.holders.LongHolder llFrontBookSub, javax.xml.rpc.holders.LongHolder llFrontSpecBook, javax.xml.rpc.holders.LongHolder llFrontTransInBook, javax.xml.rpc.holders.ShortHolder nMonth, javax.xml.rpc.holders.IntHolder iCreditValue, javax.xml.rpc.holders.LongHolder llBillMonthFee, javax.xml.rpc.holders.StringHolder strCurMonth, javax.xml.rpc.holders.StringHolder dtmExpDate, javax.xml.rpc.holders.StringHolder strUserSts, javax.xml.rpc.holders.LongHolder llFrontSubSpecBook, javax.xml.rpc.holders.LongHolder llSubSpecBook, com.asiainfo.obd.AccQuickQryFee.holders.MObdCommonSCbsErrorMsgHolder sErrorMsg) throws java.rmi.RemoteException, com.asiainfo.obd.AccQuickQryFee.CORBASystemException;
}