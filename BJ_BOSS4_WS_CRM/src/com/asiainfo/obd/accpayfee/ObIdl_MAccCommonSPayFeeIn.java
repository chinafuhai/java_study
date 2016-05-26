/**
 * ObIdl_MAccCommonSPayFeeIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSPayFeeIn  implements java.io.Serializable {
    private java.lang.String m_strChargeId;

    private java.lang.Short m_nIdType;

    private java.lang.String m_strPhoneId;

    private java.lang.Short m_nBillSts;

    private java.lang.Long m_llBankId;

    private java.lang.String m_strBankAcct;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    private java.lang.String m_strOtherOp;

    private java.lang.String m_strOtherNbr;

    private java.lang.Short m_nBusiType;

    private java.lang.String m_strCardNbr;

    private java.lang.Long m_llCardExpiry;

    private java.lang.String m_strCbossArea;

    private java.lang.String m_strCheckNbr;

    private java.lang.Long m_llCheckAmount;

    private java.lang.Short m_nInvoiceMode;

    private java.lang.Long m_llDunTaskId;

    private java.lang.Long m_llUgreBillNbr;

    private java.lang.Long m_llTrustSoNbr;

    private java.lang.Long m_llAuxFee1;

    private java.lang.Long m_llAuxFee2;

    private java.lang.Long m_llAuxFee3;

    private java.lang.Long m_llAuxFee4;

    private java.lang.Long m_llRecvAmount;

    private java.lang.Long m_llPaidAmount;

    private java.lang.String m_strRemarks;

    private java.lang.Short m_nPayMode;

    private java.lang.Integer m_iVerifyOpId;

    private java.lang.String m_strAuxChargeId;

    private java.lang.String m_strBankNet;

    private java.lang.String m_dtmTradeDate;

    private java.lang.Short m_nTradeOrigin;

    private java.lang.Short m_nProcessMode;

    private java.lang.Integer m_iChange;

    private java.lang.Short m_nUserBrand;

    private java.lang.String m_strPaymentMethod;

    private ObIdl_MAccCommonSPayLimit[] m_listPayLimitList;

    private ObIdl_MAccCommonSBookWriteFee[] m_listBookWriteFeeList;

    private ObIdl_MAccCommonSRealTimeFeeOut m_sRealTimeFee;

    public ObIdl_MAccCommonSPayFeeIn() {
    }

    public ObIdl_MAccCommonSPayFeeIn(
           java.lang.String m_strChargeId,
           java.lang.Short m_nIdType,
           java.lang.String m_strPhoneId,
           java.lang.Short m_nBillSts,
           java.lang.Long m_llBankId,
           java.lang.String m_strBankAcct,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId,
           java.lang.String m_strOtherOp,
           java.lang.String m_strOtherNbr,
           java.lang.Short m_nBusiType,
           java.lang.String m_strCardNbr,
           java.lang.Long m_llCardExpiry,
           java.lang.String m_strCbossArea,
           java.lang.String m_strCheckNbr,
           java.lang.Long m_llCheckAmount,
           java.lang.Short m_nInvoiceMode,
           java.lang.Long m_llDunTaskId,
           java.lang.Long m_llUgreBillNbr,
           java.lang.Long m_llTrustSoNbr,
           java.lang.Long m_llAuxFee1,
           java.lang.Long m_llAuxFee2,
           java.lang.Long m_llAuxFee3,
           java.lang.Long m_llAuxFee4,
           java.lang.Long m_llRecvAmount,
           java.lang.Long m_llPaidAmount,
           java.lang.String m_strRemarks,
           java.lang.Short m_nPayMode,
           java.lang.Integer m_iVerifyOpId,
           java.lang.String m_strAuxChargeId,
           java.lang.String m_strBankNet,
           java.lang.String m_dtmTradeDate,
           java.lang.Short m_nTradeOrigin,
           java.lang.Short m_nProcessMode,
           java.lang.Integer m_iChange,
           java.lang.Short m_nUserBrand,
           java.lang.String m_strPaymentMethod,
           ObIdl_MAccCommonSPayLimit[] m_listPayLimitList,
           ObIdl_MAccCommonSBookWriteFee[] m_listBookWriteFeeList,
           ObIdl_MAccCommonSRealTimeFeeOut m_sRealTimeFee) {
           this.m_strChargeId = m_strChargeId;
           this.m_nIdType = m_nIdType;
           this.m_strPhoneId = m_strPhoneId;
           this.m_nBillSts = m_nBillSts;
           this.m_llBankId = m_llBankId;
           this.m_strBankAcct = m_strBankAcct;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
           this.m_strOtherOp = m_strOtherOp;
           this.m_strOtherNbr = m_strOtherNbr;
           this.m_nBusiType = m_nBusiType;
           this.m_strCardNbr = m_strCardNbr;
           this.m_llCardExpiry = m_llCardExpiry;
           this.m_strCbossArea = m_strCbossArea;
           this.m_strCheckNbr = m_strCheckNbr;
           this.m_llCheckAmount = m_llCheckAmount;
           this.m_nInvoiceMode = m_nInvoiceMode;
           this.m_llDunTaskId = m_llDunTaskId;
           this.m_llUgreBillNbr = m_llUgreBillNbr;
           this.m_llTrustSoNbr = m_llTrustSoNbr;
           this.m_llAuxFee1 = m_llAuxFee1;
           this.m_llAuxFee2 = m_llAuxFee2;
           this.m_llAuxFee3 = m_llAuxFee3;
           this.m_llAuxFee4 = m_llAuxFee4;
           this.m_llRecvAmount = m_llRecvAmount;
           this.m_llPaidAmount = m_llPaidAmount;
           this.m_strRemarks = m_strRemarks;
           this.m_nPayMode = m_nPayMode;
           this.m_iVerifyOpId = m_iVerifyOpId;
           this.m_strAuxChargeId = m_strAuxChargeId;
           this.m_strBankNet = m_strBankNet;
           this.m_dtmTradeDate = m_dtmTradeDate;
           this.m_nTradeOrigin = m_nTradeOrigin;
           this.m_nProcessMode = m_nProcessMode;
           this.m_iChange = m_iChange;
           this.m_nUserBrand = m_nUserBrand;
           this.m_strPaymentMethod = m_strPaymentMethod;
           this.m_listPayLimitList = m_listPayLimitList;
           this.m_listBookWriteFeeList = m_listBookWriteFeeList;
           this.m_sRealTimeFee = m_sRealTimeFee;
    }


    /**
     * Gets the m_strChargeId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strChargeId
     */
    public java.lang.String getM_strChargeId() {
        return m_strChargeId;
    }


    /**
     * Sets the m_strChargeId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strChargeId
     */
    public void setM_strChargeId(java.lang.String m_strChargeId) {
        this.m_strChargeId = m_strChargeId;
    }


    /**
     * Gets the m_nIdType value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nIdType
     */
    public java.lang.Short getM_nIdType() {
        return m_nIdType;
    }


    /**
     * Sets the m_nIdType value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nIdType
     */
    public void setM_nIdType(java.lang.Short m_nIdType) {
        this.m_nIdType = m_nIdType;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_nBillSts value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nBillSts
     */
    public java.lang.Short getM_nBillSts() {
        return m_nBillSts;
    }


    /**
     * Sets the m_nBillSts value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nBillSts
     */
    public void setM_nBillSts(java.lang.Short m_nBillSts) {
        this.m_nBillSts = m_nBillSts;
    }


    /**
     * Gets the m_llBankId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llBankId
     */
    public java.lang.Long getM_llBankId() {
        return m_llBankId;
    }


    /**
     * Sets the m_llBankId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llBankId
     */
    public void setM_llBankId(java.lang.Long m_llBankId) {
        this.m_llBankId = m_llBankId;
    }


    /**
     * Gets the m_strBankAcct value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strBankAcct
     */
    public java.lang.String getM_strBankAcct() {
        return m_strBankAcct;
    }


    /**
     * Sets the m_strBankAcct value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strBankAcct
     */
    public void setM_strBankAcct(java.lang.String m_strBankAcct) {
        this.m_strBankAcct = m_strBankAcct;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_strOtherOp value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strOtherOp
     */
    public java.lang.String getM_strOtherOp() {
        return m_strOtherOp;
    }


    /**
     * Sets the m_strOtherOp value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strOtherOp
     */
    public void setM_strOtherOp(java.lang.String m_strOtherOp) {
        this.m_strOtherOp = m_strOtherOp;
    }


    /**
     * Gets the m_strOtherNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strOtherNbr
     */
    public java.lang.String getM_strOtherNbr() {
        return m_strOtherNbr;
    }


    /**
     * Sets the m_strOtherNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strOtherNbr
     */
    public void setM_strOtherNbr(java.lang.String m_strOtherNbr) {
        this.m_strOtherNbr = m_strOtherNbr;
    }


    /**
     * Gets the m_nBusiType value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nBusiType
     */
    public java.lang.Short getM_nBusiType() {
        return m_nBusiType;
    }


    /**
     * Sets the m_nBusiType value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nBusiType
     */
    public void setM_nBusiType(java.lang.Short m_nBusiType) {
        this.m_nBusiType = m_nBusiType;
    }


    /**
     * Gets the m_strCardNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strCardNbr
     */
    public java.lang.String getM_strCardNbr() {
        return m_strCardNbr;
    }


    /**
     * Sets the m_strCardNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strCardNbr
     */
    public void setM_strCardNbr(java.lang.String m_strCardNbr) {
        this.m_strCardNbr = m_strCardNbr;
    }


    /**
     * Gets the m_llCardExpiry value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llCardExpiry
     */
    public java.lang.Long getM_llCardExpiry() {
        return m_llCardExpiry;
    }


    /**
     * Sets the m_llCardExpiry value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llCardExpiry
     */
    public void setM_llCardExpiry(java.lang.Long m_llCardExpiry) {
        this.m_llCardExpiry = m_llCardExpiry;
    }


    /**
     * Gets the m_strCbossArea value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strCbossArea
     */
    public java.lang.String getM_strCbossArea() {
        return m_strCbossArea;
    }


    /**
     * Sets the m_strCbossArea value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strCbossArea
     */
    public void setM_strCbossArea(java.lang.String m_strCbossArea) {
        this.m_strCbossArea = m_strCbossArea;
    }


    /**
     * Gets the m_strCheckNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strCheckNbr
     */
    public java.lang.String getM_strCheckNbr() {
        return m_strCheckNbr;
    }


    /**
     * Sets the m_strCheckNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strCheckNbr
     */
    public void setM_strCheckNbr(java.lang.String m_strCheckNbr) {
        this.m_strCheckNbr = m_strCheckNbr;
    }


    /**
     * Gets the m_llCheckAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llCheckAmount
     */
    public java.lang.Long getM_llCheckAmount() {
        return m_llCheckAmount;
    }


    /**
     * Sets the m_llCheckAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llCheckAmount
     */
    public void setM_llCheckAmount(java.lang.Long m_llCheckAmount) {
        this.m_llCheckAmount = m_llCheckAmount;
    }


    /**
     * Gets the m_nInvoiceMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nInvoiceMode
     */
    public java.lang.Short getM_nInvoiceMode() {
        return m_nInvoiceMode;
    }


    /**
     * Sets the m_nInvoiceMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nInvoiceMode
     */
    public void setM_nInvoiceMode(java.lang.Short m_nInvoiceMode) {
        this.m_nInvoiceMode = m_nInvoiceMode;
    }


    /**
     * Gets the m_llDunTaskId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llDunTaskId
     */
    public java.lang.Long getM_llDunTaskId() {
        return m_llDunTaskId;
    }


    /**
     * Sets the m_llDunTaskId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llDunTaskId
     */
    public void setM_llDunTaskId(java.lang.Long m_llDunTaskId) {
        this.m_llDunTaskId = m_llDunTaskId;
    }


    /**
     * Gets the m_llUgreBillNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llUgreBillNbr
     */
    public java.lang.Long getM_llUgreBillNbr() {
        return m_llUgreBillNbr;
    }


    /**
     * Sets the m_llUgreBillNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llUgreBillNbr
     */
    public void setM_llUgreBillNbr(java.lang.Long m_llUgreBillNbr) {
        this.m_llUgreBillNbr = m_llUgreBillNbr;
    }


    /**
     * Gets the m_llTrustSoNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llTrustSoNbr
     */
    public java.lang.Long getM_llTrustSoNbr() {
        return m_llTrustSoNbr;
    }


    /**
     * Sets the m_llTrustSoNbr value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llTrustSoNbr
     */
    public void setM_llTrustSoNbr(java.lang.Long m_llTrustSoNbr) {
        this.m_llTrustSoNbr = m_llTrustSoNbr;
    }


    /**
     * Gets the m_llAuxFee1 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llAuxFee1
     */
    public java.lang.Long getM_llAuxFee1() {
        return m_llAuxFee1;
    }


    /**
     * Sets the m_llAuxFee1 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llAuxFee1
     */
    public void setM_llAuxFee1(java.lang.Long m_llAuxFee1) {
        this.m_llAuxFee1 = m_llAuxFee1;
    }


    /**
     * Gets the m_llAuxFee2 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llAuxFee2
     */
    public java.lang.Long getM_llAuxFee2() {
        return m_llAuxFee2;
    }


    /**
     * Sets the m_llAuxFee2 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llAuxFee2
     */
    public void setM_llAuxFee2(java.lang.Long m_llAuxFee2) {
        this.m_llAuxFee2 = m_llAuxFee2;
    }


    /**
     * Gets the m_llAuxFee3 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llAuxFee3
     */
    public java.lang.Long getM_llAuxFee3() {
        return m_llAuxFee3;
    }


    /**
     * Sets the m_llAuxFee3 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llAuxFee3
     */
    public void setM_llAuxFee3(java.lang.Long m_llAuxFee3) {
        this.m_llAuxFee3 = m_llAuxFee3;
    }


    /**
     * Gets the m_llAuxFee4 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llAuxFee4
     */
    public java.lang.Long getM_llAuxFee4() {
        return m_llAuxFee4;
    }


    /**
     * Sets the m_llAuxFee4 value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llAuxFee4
     */
    public void setM_llAuxFee4(java.lang.Long m_llAuxFee4) {
        this.m_llAuxFee4 = m_llAuxFee4;
    }


    /**
     * Gets the m_llRecvAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llRecvAmount
     */
    public java.lang.Long getM_llRecvAmount() {
        return m_llRecvAmount;
    }


    /**
     * Sets the m_llRecvAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llRecvAmount
     */
    public void setM_llRecvAmount(java.lang.Long m_llRecvAmount) {
        this.m_llRecvAmount = m_llRecvAmount;
    }


    /**
     * Gets the m_llPaidAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_llPaidAmount
     */
    public java.lang.Long getM_llPaidAmount() {
        return m_llPaidAmount;
    }


    /**
     * Sets the m_llPaidAmount value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_llPaidAmount
     */
    public void setM_llPaidAmount(java.lang.Long m_llPaidAmount) {
        this.m_llPaidAmount = m_llPaidAmount;
    }


    /**
     * Gets the m_strRemarks value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strRemarks
     */
    public java.lang.String getM_strRemarks() {
        return m_strRemarks;
    }


    /**
     * Sets the m_strRemarks value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strRemarks
     */
    public void setM_strRemarks(java.lang.String m_strRemarks) {
        this.m_strRemarks = m_strRemarks;
    }


    /**
     * Gets the m_nPayMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nPayMode
     */
    public java.lang.Short getM_nPayMode() {
        return m_nPayMode;
    }


    /**
     * Sets the m_nPayMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nPayMode
     */
    public void setM_nPayMode(java.lang.Short m_nPayMode) {
        this.m_nPayMode = m_nPayMode;
    }


    /**
     * Gets the m_iVerifyOpId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_iVerifyOpId
     */
    public java.lang.Integer getM_iVerifyOpId() {
        return m_iVerifyOpId;
    }


    /**
     * Sets the m_iVerifyOpId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_iVerifyOpId
     */
    public void setM_iVerifyOpId(java.lang.Integer m_iVerifyOpId) {
        this.m_iVerifyOpId = m_iVerifyOpId;
    }


    /**
     * Gets the m_strAuxChargeId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strAuxChargeId
     */
    public java.lang.String getM_strAuxChargeId() {
        return m_strAuxChargeId;
    }


    /**
     * Sets the m_strAuxChargeId value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strAuxChargeId
     */
    public void setM_strAuxChargeId(java.lang.String m_strAuxChargeId) {
        this.m_strAuxChargeId = m_strAuxChargeId;
    }


    /**
     * Gets the m_strBankNet value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strBankNet
     */
    public java.lang.String getM_strBankNet() {
        return m_strBankNet;
    }


    /**
     * Sets the m_strBankNet value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strBankNet
     */
    public void setM_strBankNet(java.lang.String m_strBankNet) {
        this.m_strBankNet = m_strBankNet;
    }


    /**
     * Gets the m_dtmTradeDate value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_dtmTradeDate
     */
    public java.lang.String getM_dtmTradeDate() {
        return m_dtmTradeDate;
    }


    /**
     * Sets the m_dtmTradeDate value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_dtmTradeDate
     */
    public void setM_dtmTradeDate(java.lang.String m_dtmTradeDate) {
        this.m_dtmTradeDate = m_dtmTradeDate;
    }


    /**
     * Gets the m_nTradeOrigin value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nTradeOrigin
     */
    public java.lang.Short getM_nTradeOrigin() {
        return m_nTradeOrigin;
    }


    /**
     * Sets the m_nTradeOrigin value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nTradeOrigin
     */
    public void setM_nTradeOrigin(java.lang.Short m_nTradeOrigin) {
        this.m_nTradeOrigin = m_nTradeOrigin;
    }


    /**
     * Gets the m_nProcessMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nProcessMode
     */
    public java.lang.Short getM_nProcessMode() {
        return m_nProcessMode;
    }


    /**
     * Sets the m_nProcessMode value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nProcessMode
     */
    public void setM_nProcessMode(java.lang.Short m_nProcessMode) {
        this.m_nProcessMode = m_nProcessMode;
    }


    /**
     * Gets the m_iChange value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_iChange
     */
    public java.lang.Integer getM_iChange() {
        return m_iChange;
    }


    /**
     * Sets the m_iChange value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_iChange
     */
    public void setM_iChange(java.lang.Integer m_iChange) {
        this.m_iChange = m_iChange;
    }


    /**
     * Gets the m_nUserBrand value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_nUserBrand
     */
    public java.lang.Short getM_nUserBrand() {
        return m_nUserBrand;
    }


    /**
     * Sets the m_nUserBrand value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_nUserBrand
     */
    public void setM_nUserBrand(java.lang.Short m_nUserBrand) {
        this.m_nUserBrand = m_nUserBrand;
    }


    /**
     * Gets the m_strPaymentMethod value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_strPaymentMethod
     */
    public java.lang.String getM_strPaymentMethod() {
        return m_strPaymentMethod;
    }


    /**
     * Sets the m_strPaymentMethod value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_strPaymentMethod
     */
    public void setM_strPaymentMethod(java.lang.String m_strPaymentMethod) {
        this.m_strPaymentMethod = m_strPaymentMethod;
    }


    /**
     * Gets the m_listPayLimitList value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_listPayLimitList
     */
    public ObIdl_MAccCommonSPayLimit[] getM_listPayLimitList() {
        return m_listPayLimitList;
    }


    /**
     * Sets the m_listPayLimitList value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_listPayLimitList
     */
    public void setM_listPayLimitList(ObIdl_MAccCommonSPayLimit[] m_listPayLimitList) {
        this.m_listPayLimitList = m_listPayLimitList;
    }


    /**
     * Gets the m_listBookWriteFeeList value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_listBookWriteFeeList
     */
    public ObIdl_MAccCommonSBookWriteFee[] getM_listBookWriteFeeList() {
        return m_listBookWriteFeeList;
    }


    /**
     * Sets the m_listBookWriteFeeList value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_listBookWriteFeeList
     */
    public void setM_listBookWriteFeeList(ObIdl_MAccCommonSBookWriteFee[] m_listBookWriteFeeList) {
        this.m_listBookWriteFeeList = m_listBookWriteFeeList;
    }


    /**
     * Gets the m_sRealTimeFee value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @return m_sRealTimeFee
     */
    public ObIdl_MAccCommonSRealTimeFeeOut getM_sRealTimeFee() {
        return m_sRealTimeFee;
    }


    /**
     * Sets the m_sRealTimeFee value for this ObIdl_MAccCommonSPayFeeIn.
     * 
     * @param m_sRealTimeFee
     */
    public void setM_sRealTimeFee(ObIdl_MAccCommonSRealTimeFeeOut m_sRealTimeFee) {
        this.m_sRealTimeFee = m_sRealTimeFee;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSPayFeeIn)) return false;
        ObIdl_MAccCommonSPayFeeIn other = (ObIdl_MAccCommonSPayFeeIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_strChargeId==null && other.getM_strChargeId()==null) || 
             (this.m_strChargeId!=null &&
              this.m_strChargeId.equals(other.getM_strChargeId()))) &&
            ((this.m_nIdType==null && other.getM_nIdType()==null) || 
             (this.m_nIdType!=null &&
              this.m_nIdType.equals(other.getM_nIdType()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_nBillSts==null && other.getM_nBillSts()==null) || 
             (this.m_nBillSts!=null &&
              this.m_nBillSts.equals(other.getM_nBillSts()))) &&
            ((this.m_llBankId==null && other.getM_llBankId()==null) || 
             (this.m_llBankId!=null &&
              this.m_llBankId.equals(other.getM_llBankId()))) &&
            ((this.m_strBankAcct==null && other.getM_strBankAcct()==null) || 
             (this.m_strBankAcct!=null &&
              this.m_strBankAcct.equals(other.getM_strBankAcct()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_iSoOrgId==null && other.getM_iSoOrgId()==null) || 
             (this.m_iSoOrgId!=null &&
              this.m_iSoOrgId.equals(other.getM_iSoOrgId()))) &&
            ((this.m_strOtherOp==null && other.getM_strOtherOp()==null) || 
             (this.m_strOtherOp!=null &&
              this.m_strOtherOp.equals(other.getM_strOtherOp()))) &&
            ((this.m_strOtherNbr==null && other.getM_strOtherNbr()==null) || 
             (this.m_strOtherNbr!=null &&
              this.m_strOtherNbr.equals(other.getM_strOtherNbr()))) &&
            ((this.m_nBusiType==null && other.getM_nBusiType()==null) || 
             (this.m_nBusiType!=null &&
              this.m_nBusiType.equals(other.getM_nBusiType()))) &&
            ((this.m_strCardNbr==null && other.getM_strCardNbr()==null) || 
             (this.m_strCardNbr!=null &&
              this.m_strCardNbr.equals(other.getM_strCardNbr()))) &&
            ((this.m_llCardExpiry==null && other.getM_llCardExpiry()==null) || 
             (this.m_llCardExpiry!=null &&
              this.m_llCardExpiry.equals(other.getM_llCardExpiry()))) &&
            ((this.m_strCbossArea==null && other.getM_strCbossArea()==null) || 
             (this.m_strCbossArea!=null &&
              this.m_strCbossArea.equals(other.getM_strCbossArea()))) &&
            ((this.m_strCheckNbr==null && other.getM_strCheckNbr()==null) || 
             (this.m_strCheckNbr!=null &&
              this.m_strCheckNbr.equals(other.getM_strCheckNbr()))) &&
            ((this.m_llCheckAmount==null && other.getM_llCheckAmount()==null) || 
             (this.m_llCheckAmount!=null &&
              this.m_llCheckAmount.equals(other.getM_llCheckAmount()))) &&
            ((this.m_nInvoiceMode==null && other.getM_nInvoiceMode()==null) || 
             (this.m_nInvoiceMode!=null &&
              this.m_nInvoiceMode.equals(other.getM_nInvoiceMode()))) &&
            ((this.m_llDunTaskId==null && other.getM_llDunTaskId()==null) || 
             (this.m_llDunTaskId!=null &&
              this.m_llDunTaskId.equals(other.getM_llDunTaskId()))) &&
            ((this.m_llUgreBillNbr==null && other.getM_llUgreBillNbr()==null) || 
             (this.m_llUgreBillNbr!=null &&
              this.m_llUgreBillNbr.equals(other.getM_llUgreBillNbr()))) &&
            ((this.m_llTrustSoNbr==null && other.getM_llTrustSoNbr()==null) || 
             (this.m_llTrustSoNbr!=null &&
              this.m_llTrustSoNbr.equals(other.getM_llTrustSoNbr()))) &&
            ((this.m_llAuxFee1==null && other.getM_llAuxFee1()==null) || 
             (this.m_llAuxFee1!=null &&
              this.m_llAuxFee1.equals(other.getM_llAuxFee1()))) &&
            ((this.m_llAuxFee2==null && other.getM_llAuxFee2()==null) || 
             (this.m_llAuxFee2!=null &&
              this.m_llAuxFee2.equals(other.getM_llAuxFee2()))) &&
            ((this.m_llAuxFee3==null && other.getM_llAuxFee3()==null) || 
             (this.m_llAuxFee3!=null &&
              this.m_llAuxFee3.equals(other.getM_llAuxFee3()))) &&
            ((this.m_llAuxFee4==null && other.getM_llAuxFee4()==null) || 
             (this.m_llAuxFee4!=null &&
              this.m_llAuxFee4.equals(other.getM_llAuxFee4()))) &&
            ((this.m_llRecvAmount==null && other.getM_llRecvAmount()==null) || 
             (this.m_llRecvAmount!=null &&
              this.m_llRecvAmount.equals(other.getM_llRecvAmount()))) &&
            ((this.m_llPaidAmount==null && other.getM_llPaidAmount()==null) || 
             (this.m_llPaidAmount!=null &&
              this.m_llPaidAmount.equals(other.getM_llPaidAmount()))) &&
            ((this.m_strRemarks==null && other.getM_strRemarks()==null) || 
             (this.m_strRemarks!=null &&
              this.m_strRemarks.equals(other.getM_strRemarks()))) &&
            ((this.m_nPayMode==null && other.getM_nPayMode()==null) || 
             (this.m_nPayMode!=null &&
              this.m_nPayMode.equals(other.getM_nPayMode()))) &&
            ((this.m_iVerifyOpId==null && other.getM_iVerifyOpId()==null) || 
             (this.m_iVerifyOpId!=null &&
              this.m_iVerifyOpId.equals(other.getM_iVerifyOpId()))) &&
            ((this.m_strAuxChargeId==null && other.getM_strAuxChargeId()==null) || 
             (this.m_strAuxChargeId!=null &&
              this.m_strAuxChargeId.equals(other.getM_strAuxChargeId()))) &&
            ((this.m_strBankNet==null && other.getM_strBankNet()==null) || 
             (this.m_strBankNet!=null &&
              this.m_strBankNet.equals(other.getM_strBankNet()))) &&
            ((this.m_dtmTradeDate==null && other.getM_dtmTradeDate()==null) || 
             (this.m_dtmTradeDate!=null &&
              this.m_dtmTradeDate.equals(other.getM_dtmTradeDate()))) &&
            ((this.m_nTradeOrigin==null && other.getM_nTradeOrigin()==null) || 
             (this.m_nTradeOrigin!=null &&
              this.m_nTradeOrigin.equals(other.getM_nTradeOrigin()))) &&
            ((this.m_nProcessMode==null && other.getM_nProcessMode()==null) || 
             (this.m_nProcessMode!=null &&
              this.m_nProcessMode.equals(other.getM_nProcessMode()))) &&
            ((this.m_iChange==null && other.getM_iChange()==null) || 
             (this.m_iChange!=null &&
              this.m_iChange.equals(other.getM_iChange()))) &&
            ((this.m_nUserBrand==null && other.getM_nUserBrand()==null) || 
             (this.m_nUserBrand!=null &&
              this.m_nUserBrand.equals(other.getM_nUserBrand()))) &&
            ((this.m_strPaymentMethod==null && other.getM_strPaymentMethod()==null) || 
             (this.m_strPaymentMethod!=null &&
              this.m_strPaymentMethod.equals(other.getM_strPaymentMethod()))) &&
            ((this.m_listPayLimitList==null && other.getM_listPayLimitList()==null) || 
             (this.m_listPayLimitList!=null &&
              java.util.Arrays.equals(this.m_listPayLimitList, other.getM_listPayLimitList()))) &&
            ((this.m_listBookWriteFeeList==null && other.getM_listBookWriteFeeList()==null) || 
             (this.m_listBookWriteFeeList!=null &&
              java.util.Arrays.equals(this.m_listBookWriteFeeList, other.getM_listBookWriteFeeList()))) &&
            ((this.m_sRealTimeFee==null && other.getM_sRealTimeFee()==null) || 
             (this.m_sRealTimeFee!=null &&
              this.m_sRealTimeFee.equals(other.getM_sRealTimeFee())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getM_strChargeId() != null) {
            _hashCode += getM_strChargeId().hashCode();
        }
        if (getM_nIdType() != null) {
            _hashCode += getM_nIdType().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_nBillSts() != null) {
            _hashCode += getM_nBillSts().hashCode();
        }
        if (getM_llBankId() != null) {
            _hashCode += getM_llBankId().hashCode();
        }
        if (getM_strBankAcct() != null) {
            _hashCode += getM_strBankAcct().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_iSoOrgId() != null) {
            _hashCode += getM_iSoOrgId().hashCode();
        }
        if (getM_strOtherOp() != null) {
            _hashCode += getM_strOtherOp().hashCode();
        }
        if (getM_strOtherNbr() != null) {
            _hashCode += getM_strOtherNbr().hashCode();
        }
        if (getM_nBusiType() != null) {
            _hashCode += getM_nBusiType().hashCode();
        }
        if (getM_strCardNbr() != null) {
            _hashCode += getM_strCardNbr().hashCode();
        }
        if (getM_llCardExpiry() != null) {
            _hashCode += getM_llCardExpiry().hashCode();
        }
        if (getM_strCbossArea() != null) {
            _hashCode += getM_strCbossArea().hashCode();
        }
        if (getM_strCheckNbr() != null) {
            _hashCode += getM_strCheckNbr().hashCode();
        }
        if (getM_llCheckAmount() != null) {
            _hashCode += getM_llCheckAmount().hashCode();
        }
        if (getM_nInvoiceMode() != null) {
            _hashCode += getM_nInvoiceMode().hashCode();
        }
        if (getM_llDunTaskId() != null) {
            _hashCode += getM_llDunTaskId().hashCode();
        }
        if (getM_llUgreBillNbr() != null) {
            _hashCode += getM_llUgreBillNbr().hashCode();
        }
        if (getM_llTrustSoNbr() != null) {
            _hashCode += getM_llTrustSoNbr().hashCode();
        }
        if (getM_llAuxFee1() != null) {
            _hashCode += getM_llAuxFee1().hashCode();
        }
        if (getM_llAuxFee2() != null) {
            _hashCode += getM_llAuxFee2().hashCode();
        }
        if (getM_llAuxFee3() != null) {
            _hashCode += getM_llAuxFee3().hashCode();
        }
        if (getM_llAuxFee4() != null) {
            _hashCode += getM_llAuxFee4().hashCode();
        }
        if (getM_llRecvAmount() != null) {
            _hashCode += getM_llRecvAmount().hashCode();
        }
        if (getM_llPaidAmount() != null) {
            _hashCode += getM_llPaidAmount().hashCode();
        }
        if (getM_strRemarks() != null) {
            _hashCode += getM_strRemarks().hashCode();
        }
        if (getM_nPayMode() != null) {
            _hashCode += getM_nPayMode().hashCode();
        }
        if (getM_iVerifyOpId() != null) {
            _hashCode += getM_iVerifyOpId().hashCode();
        }
        if (getM_strAuxChargeId() != null) {
            _hashCode += getM_strAuxChargeId().hashCode();
        }
        if (getM_strBankNet() != null) {
            _hashCode += getM_strBankNet().hashCode();
        }
        if (getM_dtmTradeDate() != null) {
            _hashCode += getM_dtmTradeDate().hashCode();
        }
        if (getM_nTradeOrigin() != null) {
            _hashCode += getM_nTradeOrigin().hashCode();
        }
        if (getM_nProcessMode() != null) {
            _hashCode += getM_nProcessMode().hashCode();
        }
        if (getM_iChange() != null) {
            _hashCode += getM_iChange().hashCode();
        }
        if (getM_nUserBrand() != null) {
            _hashCode += getM_nUserBrand().hashCode();
        }
        if (getM_strPaymentMethod() != null) {
            _hashCode += getM_strPaymentMethod().hashCode();
        }
        if (getM_listPayLimitList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listPayLimitList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listPayLimitList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listBookWriteFeeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listBookWriteFeeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listBookWriteFeeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_sRealTimeFee() != null) {
            _hashCode += getM_sRealTimeFee().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSPayFeeIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayFeeIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strChargeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strChargeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nIdType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nIdType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPhoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPhoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBillSts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBillSts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBankId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBankId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankAcct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankAcct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iSoOrgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iSoOrgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strOtherOp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOtherOp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strOtherNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strOtherNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nBusiType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nBusiType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCardNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCardNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCardExpiry");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCardExpiry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCbossArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCbossArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCheckNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCheckNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCheckAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCheckAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nInvoiceMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nInvoiceMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llDunTaskId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llDunTaskId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUgreBillNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUgreBillNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTrustSoNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTrustSoNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAuxFee1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAuxFee1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAuxFee2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAuxFee2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAuxFee3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAuxFee3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAuxFee4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAuxFee4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llRecvAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRecvAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPaidAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPaidAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strRemarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemarks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nPayMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nPayMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iVerifyOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iVerifyOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strAuxChargeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strAuxChargeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBankNet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBankNet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmTradeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmTradeDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nTradeOrigin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nTradeOrigin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nProcessMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nProcessMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iChange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nUserBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nUserBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strPaymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strPaymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listPayLimitList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listPayLimitList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SPayLimit"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listBookWriteFeeList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listBookWriteFeeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookWriteFee"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_sRealTimeFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_sRealTimeFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFeeOut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
