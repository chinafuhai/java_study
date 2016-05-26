/**
 * ObIdl_MAccCommonSInvoicePayFeeIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSInvoicePayFeeIn  implements java.io.Serializable {
    private java.lang.String m_strChargeId;

    private java.lang.Short m_nIdType;

    private java.lang.String m_strPhoneId;

    private java.lang.Long m_llBankId;

    private java.lang.String m_strBankAcct;

    private java.lang.Integer m_iOpId;

    private java.lang.Integer m_iSoOrgId;

    private java.lang.String m_strOtherNbr;

    private java.lang.Short m_nBusiType;

    private java.lang.String m_strCardNbr;

    private java.lang.String m_strCbossArea;

    private java.lang.String m_strCheckNbr;

    private java.lang.Long m_llCheckAmount;

    private java.lang.Short m_nInvoiceMode;

    private java.lang.Long m_llPaidAmount;

    private java.lang.String m_strRemarks;

    private java.lang.Short m_nSmsFlag;

    private java.lang.String m_dtmTradeDate;

    private java.lang.Short m_nPayMode;

    private java.lang.String m_strMonList;

    private java.lang.Integer m_iBillFormatId;

    private java.lang.Short m_nCalcLateFee;

    private java.lang.Long m_llLateFeeCut;

    private java.lang.Short m_nPhoneIdSts;

    private java.lang.Short m_nBillSts;

    private java.lang.Short m_nProcessMode;

    private java.lang.Integer m_iChange;

    private java.lang.Short m_nUserBrand;

    private java.lang.String m_strPaymentMethod;

    public ObIdl_MAccCommonSInvoicePayFeeIn() {
    	this.m_strChargeId = "";
        this.m_nIdType = 1;
        this.m_strPhoneId = "";
        this.m_llBankId = 0l;
        this.m_strBankAcct = "0";
        this.m_iOpId = 99999999;
        this.m_iSoOrgId = 99999999;
        this.m_strOtherNbr = "0";
        this.m_nBusiType = 0;
        this.m_strCardNbr = "0";
        this.m_strCbossArea = "0";
        this.m_strCheckNbr = "0";
        this.m_llCheckAmount = 0l;
        this.m_nInvoiceMode = 0;
        this.m_llPaidAmount = 0l;
        this.m_strRemarks = "";
        this.m_nSmsFlag = 0;
        this.m_nPayMode = 1;
        this.m_strMonList = "0";
        this.m_iBillFormatId = 1;
        this.m_nCalcLateFee = 0;
        this.m_llLateFeeCut = 0l;
        this.m_nPhoneIdSts = 0;
        this.m_nBillSts = 0;
        this.m_nProcessMode = 0;
        this.m_iChange = 0;
        this.m_nUserBrand = 0;
        this.m_strPaymentMethod = "CA";

    }

    public ObIdl_MAccCommonSInvoicePayFeeIn(
           java.lang.String m_strChargeId,
           java.lang.Short m_nIdType,
           java.lang.String m_strPhoneId,
           java.lang.Long m_llBankId,
           java.lang.String m_strBankAcct,
           java.lang.Integer m_iOpId,
           java.lang.Integer m_iSoOrgId,
           java.lang.String m_strOtherNbr,
           java.lang.Short m_nBusiType,
           java.lang.String m_strCardNbr,
           java.lang.String m_strCbossArea,
           java.lang.String m_strCheckNbr,
           java.lang.Long m_llCheckAmount,
           java.lang.Short m_nInvoiceMode,
           java.lang.Long m_llPaidAmount,
           java.lang.String m_strRemarks,
           java.lang.Short m_nSmsFlag,
           java.lang.String m_dtmTradeDate,
           java.lang.Short m_nPayMode,
           java.lang.String m_strMonList,
           java.lang.Integer m_iBillFormatId,
           java.lang.Short m_nCalcLateFee,
           java.lang.Long m_llLateFeeCut,
           java.lang.Short m_nPhoneIdSts,
           java.lang.Short m_nBillSts,
           java.lang.Short m_nProcessMode,
           java.lang.Integer m_iChange,
           java.lang.Short m_nUserBrand,
           java.lang.String m_strPaymentMethod) {
           this.m_strChargeId = m_strChargeId;
           this.m_nIdType = m_nIdType;
           this.m_strPhoneId = m_strPhoneId;
           this.m_llBankId = m_llBankId;
           this.m_strBankAcct = m_strBankAcct;
           this.m_iOpId = m_iOpId;
           this.m_iSoOrgId = m_iSoOrgId;
           this.m_strOtherNbr = m_strOtherNbr;
           this.m_nBusiType = m_nBusiType;
           this.m_strCardNbr = m_strCardNbr;
           this.m_strCbossArea = m_strCbossArea;
           this.m_strCheckNbr = m_strCheckNbr;
           this.m_llCheckAmount = m_llCheckAmount;
           this.m_nInvoiceMode = m_nInvoiceMode;
           this.m_llPaidAmount = m_llPaidAmount;
           this.m_strRemarks = m_strRemarks;
           this.m_nSmsFlag = m_nSmsFlag;
           this.m_dtmTradeDate = m_dtmTradeDate;
           this.m_nPayMode = m_nPayMode;
           this.m_strMonList = m_strMonList;
           this.m_iBillFormatId = m_iBillFormatId;
           this.m_nCalcLateFee = m_nCalcLateFee;
           this.m_llLateFeeCut = m_llLateFeeCut;
           this.m_nPhoneIdSts = m_nPhoneIdSts;
           this.m_nBillSts = m_nBillSts;
           this.m_nProcessMode = m_nProcessMode;
           this.m_iChange = m_iChange;
           this.m_nUserBrand = m_nUserBrand;
           this.m_strPaymentMethod = m_strPaymentMethod;
    }


    /**
     * Gets the m_strChargeId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strChargeId
     */
    public java.lang.String getM_strChargeId() {
        return m_strChargeId;
    }


    /**
     * Sets the m_strChargeId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strChargeId
     */
    public void setM_strChargeId(java.lang.String m_strChargeId) {
        this.m_strChargeId = m_strChargeId;
    }


    /**
     * Gets the m_nIdType value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nIdType
     */
    public java.lang.Short getM_nIdType() {
        return m_nIdType;
    }


    /**
     * Sets the m_nIdType value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nIdType
     */
    public void setM_nIdType(java.lang.Short m_nIdType) {
        this.m_nIdType = m_nIdType;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_llBankId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_llBankId
     */
    public java.lang.Long getM_llBankId() {
        return m_llBankId;
    }


    /**
     * Sets the m_llBankId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_llBankId
     */
    public void setM_llBankId(java.lang.Long m_llBankId) {
        this.m_llBankId = m_llBankId;
    }


    /**
     * Gets the m_strBankAcct value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strBankAcct
     */
    public java.lang.String getM_strBankAcct() {
        return m_strBankAcct;
    }


    /**
     * Sets the m_strBankAcct value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strBankAcct
     */
    public void setM_strBankAcct(java.lang.String m_strBankAcct) {
        this.m_strBankAcct = m_strBankAcct;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_iSoOrgId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_iSoOrgId
     */
    public java.lang.Integer getM_iSoOrgId() {
        return m_iSoOrgId;
    }


    /**
     * Sets the m_iSoOrgId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_iSoOrgId
     */
    public void setM_iSoOrgId(java.lang.Integer m_iSoOrgId) {
        this.m_iSoOrgId = m_iSoOrgId;
    }


    /**
     * Gets the m_strOtherNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strOtherNbr
     */
    public java.lang.String getM_strOtherNbr() {
        return m_strOtherNbr;
    }


    /**
     * Sets the m_strOtherNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strOtherNbr
     */
    public void setM_strOtherNbr(java.lang.String m_strOtherNbr) {
        this.m_strOtherNbr = m_strOtherNbr;
    }


    /**
     * Gets the m_nBusiType value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nBusiType
     */
    public java.lang.Short getM_nBusiType() {
        return m_nBusiType;
    }


    /**
     * Sets the m_nBusiType value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nBusiType
     */
    public void setM_nBusiType(java.lang.Short m_nBusiType) {
        this.m_nBusiType = m_nBusiType;
    }


    /**
     * Gets the m_strCardNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strCardNbr
     */
    public java.lang.String getM_strCardNbr() {
        return m_strCardNbr;
    }


    /**
     * Sets the m_strCardNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strCardNbr
     */
    public void setM_strCardNbr(java.lang.String m_strCardNbr) {
        this.m_strCardNbr = m_strCardNbr;
    }


    /**
     * Gets the m_strCbossArea value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strCbossArea
     */
    public java.lang.String getM_strCbossArea() {
        return m_strCbossArea;
    }


    /**
     * Sets the m_strCbossArea value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strCbossArea
     */
    public void setM_strCbossArea(java.lang.String m_strCbossArea) {
        this.m_strCbossArea = m_strCbossArea;
    }


    /**
     * Gets the m_strCheckNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strCheckNbr
     */
    public java.lang.String getM_strCheckNbr() {
        return m_strCheckNbr;
    }


    /**
     * Sets the m_strCheckNbr value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strCheckNbr
     */
    public void setM_strCheckNbr(java.lang.String m_strCheckNbr) {
        this.m_strCheckNbr = m_strCheckNbr;
    }


    /**
     * Gets the m_llCheckAmount value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_llCheckAmount
     */
    public java.lang.Long getM_llCheckAmount() {
        return m_llCheckAmount;
    }


    /**
     * Sets the m_llCheckAmount value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_llCheckAmount
     */
    public void setM_llCheckAmount(java.lang.Long m_llCheckAmount) {
        this.m_llCheckAmount = m_llCheckAmount;
    }


    /**
     * Gets the m_nInvoiceMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nInvoiceMode
     */
    public java.lang.Short getM_nInvoiceMode() {
        return m_nInvoiceMode;
    }


    /**
     * Sets the m_nInvoiceMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nInvoiceMode
     */
    public void setM_nInvoiceMode(java.lang.Short m_nInvoiceMode) {
        this.m_nInvoiceMode = m_nInvoiceMode;
    }


    /**
     * Gets the m_llPaidAmount value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_llPaidAmount
     */
    public java.lang.Long getM_llPaidAmount() {
        return m_llPaidAmount;
    }


    /**
     * Sets the m_llPaidAmount value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_llPaidAmount
     */
    public void setM_llPaidAmount(java.lang.Long m_llPaidAmount) {
        this.m_llPaidAmount = m_llPaidAmount;
    }


    /**
     * Gets the m_strRemarks value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strRemarks
     */
    public java.lang.String getM_strRemarks() {
        return m_strRemarks;
    }


    /**
     * Sets the m_strRemarks value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strRemarks
     */
    public void setM_strRemarks(java.lang.String m_strRemarks) {
        this.m_strRemarks = m_strRemarks;
    }


    /**
     * Gets the m_nSmsFlag value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nSmsFlag
     */
    public java.lang.Short getM_nSmsFlag() {
        return m_nSmsFlag;
    }


    /**
     * Sets the m_nSmsFlag value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nSmsFlag
     */
    public void setM_nSmsFlag(java.lang.Short m_nSmsFlag) {
        this.m_nSmsFlag = m_nSmsFlag;
    }


    /**
     * Gets the m_dtmTradeDate value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_dtmTradeDate
     */
    public java.lang.String getM_dtmTradeDate() {
        return m_dtmTradeDate;
    }


    /**
     * Sets the m_dtmTradeDate value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_dtmTradeDate
     */
    public void setM_dtmTradeDate(java.lang.String m_dtmTradeDate) {
        this.m_dtmTradeDate = m_dtmTradeDate;
    }


    /**
     * Gets the m_nPayMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nPayMode
     */
    public java.lang.Short getM_nPayMode() {
        return m_nPayMode;
    }


    /**
     * Sets the m_nPayMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nPayMode
     */
    public void setM_nPayMode(java.lang.Short m_nPayMode) {
        this.m_nPayMode = m_nPayMode;
    }


    /**
     * Gets the m_strMonList value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strMonList
     */
    public java.lang.String getM_strMonList() {
        return m_strMonList;
    }


    /**
     * Sets the m_strMonList value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strMonList
     */
    public void setM_strMonList(java.lang.String m_strMonList) {
        this.m_strMonList = m_strMonList;
    }


    /**
     * Gets the m_iBillFormatId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_iBillFormatId
     */
    public java.lang.Integer getM_iBillFormatId() {
        return m_iBillFormatId;
    }


    /**
     * Sets the m_iBillFormatId value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_iBillFormatId
     */
    public void setM_iBillFormatId(java.lang.Integer m_iBillFormatId) {
        this.m_iBillFormatId = m_iBillFormatId;
    }


    /**
     * Gets the m_nCalcLateFee value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nCalcLateFee
     */
    public java.lang.Short getM_nCalcLateFee() {
        return m_nCalcLateFee;
    }


    /**
     * Sets the m_nCalcLateFee value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nCalcLateFee
     */
    public void setM_nCalcLateFee(java.lang.Short m_nCalcLateFee) {
        this.m_nCalcLateFee = m_nCalcLateFee;
    }


    /**
     * Gets the m_llLateFeeCut value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_llLateFeeCut
     */
    public java.lang.Long getM_llLateFeeCut() {
        return m_llLateFeeCut;
    }


    /**
     * Sets the m_llLateFeeCut value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_llLateFeeCut
     */
    public void setM_llLateFeeCut(java.lang.Long m_llLateFeeCut) {
        this.m_llLateFeeCut = m_llLateFeeCut;
    }


    /**
     * Gets the m_nPhoneIdSts value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nPhoneIdSts
     */
    public java.lang.Short getM_nPhoneIdSts() {
        return m_nPhoneIdSts;
    }


    /**
     * Sets the m_nPhoneIdSts value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nPhoneIdSts
     */
    public void setM_nPhoneIdSts(java.lang.Short m_nPhoneIdSts) {
        this.m_nPhoneIdSts = m_nPhoneIdSts;
    }


    /**
     * Gets the m_nBillSts value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nBillSts
     */
    public java.lang.Short getM_nBillSts() {
        return m_nBillSts;
    }


    /**
     * Sets the m_nBillSts value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nBillSts
     */
    public void setM_nBillSts(java.lang.Short m_nBillSts) {
        this.m_nBillSts = m_nBillSts;
    }


    /**
     * Gets the m_nProcessMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nProcessMode
     */
    public java.lang.Short getM_nProcessMode() {
        return m_nProcessMode;
    }


    /**
     * Sets the m_nProcessMode value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nProcessMode
     */
    public void setM_nProcessMode(java.lang.Short m_nProcessMode) {
        this.m_nProcessMode = m_nProcessMode;
    }


    /**
     * Gets the m_iChange value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_iChange
     */
    public java.lang.Integer getM_iChange() {
        return m_iChange;
    }


    /**
     * Sets the m_iChange value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_iChange
     */
    public void setM_iChange(java.lang.Integer m_iChange) {
        this.m_iChange = m_iChange;
    }


    /**
     * Gets the m_nUserBrand value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_nUserBrand
     */
    public java.lang.Short getM_nUserBrand() {
        return m_nUserBrand;
    }


    /**
     * Sets the m_nUserBrand value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_nUserBrand
     */
    public void setM_nUserBrand(java.lang.Short m_nUserBrand) {
        this.m_nUserBrand = m_nUserBrand;
    }


    /**
     * Gets the m_strPaymentMethod value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @return m_strPaymentMethod
     */
    public java.lang.String getM_strPaymentMethod() {
        return m_strPaymentMethod;
    }


    /**
     * Sets the m_strPaymentMethod value for this ObIdl_MAccCommonSInvoicePayFeeIn.
     * 
     * @param m_strPaymentMethod
     */
    public void setM_strPaymentMethod(java.lang.String m_strPaymentMethod) {
        this.m_strPaymentMethod = m_strPaymentMethod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSInvoicePayFeeIn)) return false;
        ObIdl_MAccCommonSInvoicePayFeeIn other = (ObIdl_MAccCommonSInvoicePayFeeIn) obj;
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
            ((this.m_strOtherNbr==null && other.getM_strOtherNbr()==null) || 
             (this.m_strOtherNbr!=null &&
              this.m_strOtherNbr.equals(other.getM_strOtherNbr()))) &&
            ((this.m_nBusiType==null && other.getM_nBusiType()==null) || 
             (this.m_nBusiType!=null &&
              this.m_nBusiType.equals(other.getM_nBusiType()))) &&
            ((this.m_strCardNbr==null && other.getM_strCardNbr()==null) || 
             (this.m_strCardNbr!=null &&
              this.m_strCardNbr.equals(other.getM_strCardNbr()))) &&
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
            ((this.m_llPaidAmount==null && other.getM_llPaidAmount()==null) || 
             (this.m_llPaidAmount!=null &&
              this.m_llPaidAmount.equals(other.getM_llPaidAmount()))) &&
            ((this.m_strRemarks==null && other.getM_strRemarks()==null) || 
             (this.m_strRemarks!=null &&
              this.m_strRemarks.equals(other.getM_strRemarks()))) &&
            ((this.m_nSmsFlag==null && other.getM_nSmsFlag()==null) || 
             (this.m_nSmsFlag!=null &&
              this.m_nSmsFlag.equals(other.getM_nSmsFlag()))) &&
            ((this.m_dtmTradeDate==null && other.getM_dtmTradeDate()==null) || 
             (this.m_dtmTradeDate!=null &&
              this.m_dtmTradeDate.equals(other.getM_dtmTradeDate()))) &&
            ((this.m_nPayMode==null && other.getM_nPayMode()==null) || 
             (this.m_nPayMode!=null &&
              this.m_nPayMode.equals(other.getM_nPayMode()))) &&
            ((this.m_strMonList==null && other.getM_strMonList()==null) || 
             (this.m_strMonList!=null &&
              this.m_strMonList.equals(other.getM_strMonList()))) &&
            ((this.m_iBillFormatId==null && other.getM_iBillFormatId()==null) || 
             (this.m_iBillFormatId!=null &&
              this.m_iBillFormatId.equals(other.getM_iBillFormatId()))) &&
            ((this.m_nCalcLateFee==null && other.getM_nCalcLateFee()==null) || 
             (this.m_nCalcLateFee!=null &&
              this.m_nCalcLateFee.equals(other.getM_nCalcLateFee()))) &&
            ((this.m_llLateFeeCut==null && other.getM_llLateFeeCut()==null) || 
             (this.m_llLateFeeCut!=null &&
              this.m_llLateFeeCut.equals(other.getM_llLateFeeCut()))) &&
            ((this.m_nPhoneIdSts==null && other.getM_nPhoneIdSts()==null) || 
             (this.m_nPhoneIdSts!=null &&
              this.m_nPhoneIdSts.equals(other.getM_nPhoneIdSts()))) &&
            ((this.m_nBillSts==null && other.getM_nBillSts()==null) || 
             (this.m_nBillSts!=null &&
              this.m_nBillSts.equals(other.getM_nBillSts()))) &&
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
              this.m_strPaymentMethod.equals(other.getM_strPaymentMethod())));
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
        if (getM_strOtherNbr() != null) {
            _hashCode += getM_strOtherNbr().hashCode();
        }
        if (getM_nBusiType() != null) {
            _hashCode += getM_nBusiType().hashCode();
        }
        if (getM_strCardNbr() != null) {
            _hashCode += getM_strCardNbr().hashCode();
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
        if (getM_llPaidAmount() != null) {
            _hashCode += getM_llPaidAmount().hashCode();
        }
        if (getM_strRemarks() != null) {
            _hashCode += getM_strRemarks().hashCode();
        }
        if (getM_nSmsFlag() != null) {
            _hashCode += getM_nSmsFlag().hashCode();
        }
        if (getM_dtmTradeDate() != null) {
            _hashCode += getM_dtmTradeDate().hashCode();
        }
        if (getM_nPayMode() != null) {
            _hashCode += getM_nPayMode().hashCode();
        }
        if (getM_strMonList() != null) {
            _hashCode += getM_strMonList().hashCode();
        }
        if (getM_iBillFormatId() != null) {
            _hashCode += getM_iBillFormatId().hashCode();
        }
        if (getM_nCalcLateFee() != null) {
            _hashCode += getM_nCalcLateFee().hashCode();
        }
        if (getM_llLateFeeCut() != null) {
            _hashCode += getM_llLateFeeCut().hashCode();
        }
        if (getM_nPhoneIdSts() != null) {
            _hashCode += getM_nPhoneIdSts().hashCode();
        }
        if (getM_nBillSts() != null) {
            _hashCode += getM_nBillSts().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSInvoicePayFeeIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SInvoicePayFeeIn"));
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
        elemField.setFieldName("m_nSmsFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nSmsFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
        elemField.setFieldName("m_nPayMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nPayMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strMonList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strMonList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBillFormatId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBillFormatId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nCalcLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nCalcLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llLateFeeCut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llLateFeeCut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nPhoneIdSts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nPhoneIdSts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
