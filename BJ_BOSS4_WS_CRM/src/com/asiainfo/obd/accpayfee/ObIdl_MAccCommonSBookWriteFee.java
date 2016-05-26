/**
 * ObIdl_MAccCommonSBookWriteFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSBookWriteFee  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.String m_strAcctName;

    private java.lang.String m_strServName;

    private java.lang.String m_strCustName;

    private java.lang.Integer m_iPayType;

    private java.lang.Integer m_iOfRegionCode;

    private java.lang.Integer m_iCountyCode;

    private java.lang.Integer m_iOfOrgId;

    private java.lang.Short m_nCreditClass;

    private java.lang.Integer m_iCredit;

    private java.lang.Short m_nCustClass;

    private java.lang.Short m_nAcctClass;

    private java.lang.Short m_nVipFlag;

    private java.lang.Short m_nUserRelate;

    private java.lang.Integer m_iBillFormatId;

    private java.lang.Long m_llBookTotalAmt;

    private java.lang.Long m_llBookTotalWoff;

    private java.lang.Long m_llBookNorTotalAmt;

    private java.lang.Long m_llBookNorTotalWoff;

    private java.lang.Long m_llBookSpecTotalAmt;

    private java.lang.Long m_llBookSpecTotalWoff;

    private java.lang.Long m_llBookNoinvtotalWoff;

    private ObIdl_MAccCommonSBookSnapShot[] m_listAllBookSnapShotList;

    private ObIdl_MAccCommonSBillSnapShot[] m_listBillSnapShotList;

    public ObIdl_MAccCommonSBookWriteFee() {
    }

    public ObIdl_MAccCommonSBookWriteFee(
           java.lang.Long m_llAcctId,
           java.lang.String m_strAcctName,
           java.lang.String m_strServName,
           java.lang.String m_strCustName,
           java.lang.Integer m_iPayType,
           java.lang.Integer m_iOfRegionCode,
           java.lang.Integer m_iCountyCode,
           java.lang.Integer m_iOfOrgId,
           java.lang.Short m_nCreditClass,
           java.lang.Integer m_iCredit,
           java.lang.Short m_nCustClass,
           java.lang.Short m_nAcctClass,
           java.lang.Short m_nVipFlag,
           java.lang.Short m_nUserRelate,
           java.lang.Integer m_iBillFormatId,
           java.lang.Long m_llBookTotalAmt,
           java.lang.Long m_llBookTotalWoff,
           java.lang.Long m_llBookNorTotalAmt,
           java.lang.Long m_llBookNorTotalWoff,
           java.lang.Long m_llBookSpecTotalAmt,
           java.lang.Long m_llBookSpecTotalWoff,
           java.lang.Long m_llBookNoinvtotalWoff,
           ObIdl_MAccCommonSBookSnapShot[] m_listAllBookSnapShotList,
           ObIdl_MAccCommonSBillSnapShot[] m_listBillSnapShotList) {
           this.m_llAcctId = m_llAcctId;
           this.m_strAcctName = m_strAcctName;
           this.m_strServName = m_strServName;
           this.m_strCustName = m_strCustName;
           this.m_iPayType = m_iPayType;
           this.m_iOfRegionCode = m_iOfRegionCode;
           this.m_iCountyCode = m_iCountyCode;
           this.m_iOfOrgId = m_iOfOrgId;
           this.m_nCreditClass = m_nCreditClass;
           this.m_iCredit = m_iCredit;
           this.m_nCustClass = m_nCustClass;
           this.m_nAcctClass = m_nAcctClass;
           this.m_nVipFlag = m_nVipFlag;
           this.m_nUserRelate = m_nUserRelate;
           this.m_iBillFormatId = m_iBillFormatId;
           this.m_llBookTotalAmt = m_llBookTotalAmt;
           this.m_llBookTotalWoff = m_llBookTotalWoff;
           this.m_llBookNorTotalAmt = m_llBookNorTotalAmt;
           this.m_llBookNorTotalWoff = m_llBookNorTotalWoff;
           this.m_llBookSpecTotalAmt = m_llBookSpecTotalAmt;
           this.m_llBookSpecTotalWoff = m_llBookSpecTotalWoff;
           this.m_llBookNoinvtotalWoff = m_llBookNoinvtotalWoff;
           this.m_listAllBookSnapShotList = m_listAllBookSnapShotList;
           this.m_listBillSnapShotList = m_listBillSnapShotList;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_strAcctName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_strAcctName
     */
    public java.lang.String getM_strAcctName() {
        return m_strAcctName;
    }


    /**
     * Sets the m_strAcctName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_strAcctName
     */
    public void setM_strAcctName(java.lang.String m_strAcctName) {
        this.m_strAcctName = m_strAcctName;
    }


    /**
     * Gets the m_strServName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_strServName
     */
    public java.lang.String getM_strServName() {
        return m_strServName;
    }


    /**
     * Sets the m_strServName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_strServName
     */
    public void setM_strServName(java.lang.String m_strServName) {
        this.m_strServName = m_strServName;
    }


    /**
     * Gets the m_strCustName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_strCustName
     */
    public java.lang.String getM_strCustName() {
        return m_strCustName;
    }


    /**
     * Sets the m_strCustName value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_strCustName
     */
    public void setM_strCustName(java.lang.String m_strCustName) {
        this.m_strCustName = m_strCustName;
    }


    /**
     * Gets the m_iPayType value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iPayType
     */
    public java.lang.Integer getM_iPayType() {
        return m_iPayType;
    }


    /**
     * Sets the m_iPayType value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iPayType
     */
    public void setM_iPayType(java.lang.Integer m_iPayType) {
        this.m_iPayType = m_iPayType;
    }


    /**
     * Gets the m_iOfRegionCode value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iOfRegionCode
     */
    public java.lang.Integer getM_iOfRegionCode() {
        return m_iOfRegionCode;
    }


    /**
     * Sets the m_iOfRegionCode value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iOfRegionCode
     */
    public void setM_iOfRegionCode(java.lang.Integer m_iOfRegionCode) {
        this.m_iOfRegionCode = m_iOfRegionCode;
    }


    /**
     * Gets the m_iCountyCode value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iCountyCode
     */
    public java.lang.Integer getM_iCountyCode() {
        return m_iCountyCode;
    }


    /**
     * Sets the m_iCountyCode value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iCountyCode
     */
    public void setM_iCountyCode(java.lang.Integer m_iCountyCode) {
        this.m_iCountyCode = m_iCountyCode;
    }


    /**
     * Gets the m_iOfOrgId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iOfOrgId
     */
    public java.lang.Integer getM_iOfOrgId() {
        return m_iOfOrgId;
    }


    /**
     * Sets the m_iOfOrgId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iOfOrgId
     */
    public void setM_iOfOrgId(java.lang.Integer m_iOfOrgId) {
        this.m_iOfOrgId = m_iOfOrgId;
    }


    /**
     * Gets the m_nCreditClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_nCreditClass
     */
    public java.lang.Short getM_nCreditClass() {
        return m_nCreditClass;
    }


    /**
     * Sets the m_nCreditClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_nCreditClass
     */
    public void setM_nCreditClass(java.lang.Short m_nCreditClass) {
        this.m_nCreditClass = m_nCreditClass;
    }


    /**
     * Gets the m_iCredit value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iCredit
     */
    public java.lang.Integer getM_iCredit() {
        return m_iCredit;
    }


    /**
     * Sets the m_iCredit value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iCredit
     */
    public void setM_iCredit(java.lang.Integer m_iCredit) {
        this.m_iCredit = m_iCredit;
    }


    /**
     * Gets the m_nCustClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_nCustClass
     */
    public java.lang.Short getM_nCustClass() {
        return m_nCustClass;
    }


    /**
     * Sets the m_nCustClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_nCustClass
     */
    public void setM_nCustClass(java.lang.Short m_nCustClass) {
        this.m_nCustClass = m_nCustClass;
    }


    /**
     * Gets the m_nAcctClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_nAcctClass
     */
    public java.lang.Short getM_nAcctClass() {
        return m_nAcctClass;
    }


    /**
     * Sets the m_nAcctClass value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_nAcctClass
     */
    public void setM_nAcctClass(java.lang.Short m_nAcctClass) {
        this.m_nAcctClass = m_nAcctClass;
    }


    /**
     * Gets the m_nVipFlag value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_nVipFlag
     */
    public java.lang.Short getM_nVipFlag() {
        return m_nVipFlag;
    }


    /**
     * Sets the m_nVipFlag value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_nVipFlag
     */
    public void setM_nVipFlag(java.lang.Short m_nVipFlag) {
        this.m_nVipFlag = m_nVipFlag;
    }


    /**
     * Gets the m_nUserRelate value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_nUserRelate
     */
    public java.lang.Short getM_nUserRelate() {
        return m_nUserRelate;
    }


    /**
     * Sets the m_nUserRelate value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_nUserRelate
     */
    public void setM_nUserRelate(java.lang.Short m_nUserRelate) {
        this.m_nUserRelate = m_nUserRelate;
    }


    /**
     * Gets the m_iBillFormatId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_iBillFormatId
     */
    public java.lang.Integer getM_iBillFormatId() {
        return m_iBillFormatId;
    }


    /**
     * Sets the m_iBillFormatId value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_iBillFormatId
     */
    public void setM_iBillFormatId(java.lang.Integer m_iBillFormatId) {
        this.m_iBillFormatId = m_iBillFormatId;
    }


    /**
     * Gets the m_llBookTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookTotalAmt
     */
    public java.lang.Long getM_llBookTotalAmt() {
        return m_llBookTotalAmt;
    }


    /**
     * Sets the m_llBookTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookTotalAmt
     */
    public void setM_llBookTotalAmt(java.lang.Long m_llBookTotalAmt) {
        this.m_llBookTotalAmt = m_llBookTotalAmt;
    }


    /**
     * Gets the m_llBookTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookTotalWoff
     */
    public java.lang.Long getM_llBookTotalWoff() {
        return m_llBookTotalWoff;
    }


    /**
     * Sets the m_llBookTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookTotalWoff
     */
    public void setM_llBookTotalWoff(java.lang.Long m_llBookTotalWoff) {
        this.m_llBookTotalWoff = m_llBookTotalWoff;
    }


    /**
     * Gets the m_llBookNorTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookNorTotalAmt
     */
    public java.lang.Long getM_llBookNorTotalAmt() {
        return m_llBookNorTotalAmt;
    }


    /**
     * Sets the m_llBookNorTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookNorTotalAmt
     */
    public void setM_llBookNorTotalAmt(java.lang.Long m_llBookNorTotalAmt) {
        this.m_llBookNorTotalAmt = m_llBookNorTotalAmt;
    }


    /**
     * Gets the m_llBookNorTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookNorTotalWoff
     */
    public java.lang.Long getM_llBookNorTotalWoff() {
        return m_llBookNorTotalWoff;
    }


    /**
     * Sets the m_llBookNorTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookNorTotalWoff
     */
    public void setM_llBookNorTotalWoff(java.lang.Long m_llBookNorTotalWoff) {
        this.m_llBookNorTotalWoff = m_llBookNorTotalWoff;
    }


    /**
     * Gets the m_llBookSpecTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookSpecTotalAmt
     */
    public java.lang.Long getM_llBookSpecTotalAmt() {
        return m_llBookSpecTotalAmt;
    }


    /**
     * Sets the m_llBookSpecTotalAmt value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookSpecTotalAmt
     */
    public void setM_llBookSpecTotalAmt(java.lang.Long m_llBookSpecTotalAmt) {
        this.m_llBookSpecTotalAmt = m_llBookSpecTotalAmt;
    }


    /**
     * Gets the m_llBookSpecTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookSpecTotalWoff
     */
    public java.lang.Long getM_llBookSpecTotalWoff() {
        return m_llBookSpecTotalWoff;
    }


    /**
     * Sets the m_llBookSpecTotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookSpecTotalWoff
     */
    public void setM_llBookSpecTotalWoff(java.lang.Long m_llBookSpecTotalWoff) {
        this.m_llBookSpecTotalWoff = m_llBookSpecTotalWoff;
    }


    /**
     * Gets the m_llBookNoinvtotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_llBookNoinvtotalWoff
     */
    public java.lang.Long getM_llBookNoinvtotalWoff() {
        return m_llBookNoinvtotalWoff;
    }


    /**
     * Sets the m_llBookNoinvtotalWoff value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_llBookNoinvtotalWoff
     */
    public void setM_llBookNoinvtotalWoff(java.lang.Long m_llBookNoinvtotalWoff) {
        this.m_llBookNoinvtotalWoff = m_llBookNoinvtotalWoff;
    }


    /**
     * Gets the m_listAllBookSnapShotList value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_listAllBookSnapShotList
     */
    public ObIdl_MAccCommonSBookSnapShot[] getM_listAllBookSnapShotList() {
        return m_listAllBookSnapShotList;
    }


    /**
     * Sets the m_listAllBookSnapShotList value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_listAllBookSnapShotList
     */
    public void setM_listAllBookSnapShotList(ObIdl_MAccCommonSBookSnapShot[] m_listAllBookSnapShotList) {
        this.m_listAllBookSnapShotList = m_listAllBookSnapShotList;
    }


    /**
     * Gets the m_listBillSnapShotList value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @return m_listBillSnapShotList
     */
    public ObIdl_MAccCommonSBillSnapShot[] getM_listBillSnapShotList() {
        return m_listBillSnapShotList;
    }


    /**
     * Sets the m_listBillSnapShotList value for this ObIdl_MAccCommonSBookWriteFee.
     * 
     * @param m_listBillSnapShotList
     */
    public void setM_listBillSnapShotList(ObIdl_MAccCommonSBillSnapShot[] m_listBillSnapShotList) {
        this.m_listBillSnapShotList = m_listBillSnapShotList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSBookWriteFee)) return false;
        ObIdl_MAccCommonSBookWriteFee other = (ObIdl_MAccCommonSBookWriteFee) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llAcctId==null && other.getM_llAcctId()==null) || 
             (this.m_llAcctId!=null &&
              this.m_llAcctId.equals(other.getM_llAcctId()))) &&
            ((this.m_strAcctName==null && other.getM_strAcctName()==null) || 
             (this.m_strAcctName!=null &&
              this.m_strAcctName.equals(other.getM_strAcctName()))) &&
            ((this.m_strServName==null && other.getM_strServName()==null) || 
             (this.m_strServName!=null &&
              this.m_strServName.equals(other.getM_strServName()))) &&
            ((this.m_strCustName==null && other.getM_strCustName()==null) || 
             (this.m_strCustName!=null &&
              this.m_strCustName.equals(other.getM_strCustName()))) &&
            ((this.m_iPayType==null && other.getM_iPayType()==null) || 
             (this.m_iPayType!=null &&
              this.m_iPayType.equals(other.getM_iPayType()))) &&
            ((this.m_iOfRegionCode==null && other.getM_iOfRegionCode()==null) || 
             (this.m_iOfRegionCode!=null &&
              this.m_iOfRegionCode.equals(other.getM_iOfRegionCode()))) &&
            ((this.m_iCountyCode==null && other.getM_iCountyCode()==null) || 
             (this.m_iCountyCode!=null &&
              this.m_iCountyCode.equals(other.getM_iCountyCode()))) &&
            ((this.m_iOfOrgId==null && other.getM_iOfOrgId()==null) || 
             (this.m_iOfOrgId!=null &&
              this.m_iOfOrgId.equals(other.getM_iOfOrgId()))) &&
            ((this.m_nCreditClass==null && other.getM_nCreditClass()==null) || 
             (this.m_nCreditClass!=null &&
              this.m_nCreditClass.equals(other.getM_nCreditClass()))) &&
            ((this.m_iCredit==null && other.getM_iCredit()==null) || 
             (this.m_iCredit!=null &&
              this.m_iCredit.equals(other.getM_iCredit()))) &&
            ((this.m_nCustClass==null && other.getM_nCustClass()==null) || 
             (this.m_nCustClass!=null &&
              this.m_nCustClass.equals(other.getM_nCustClass()))) &&
            ((this.m_nAcctClass==null && other.getM_nAcctClass()==null) || 
             (this.m_nAcctClass!=null &&
              this.m_nAcctClass.equals(other.getM_nAcctClass()))) &&
            ((this.m_nVipFlag==null && other.getM_nVipFlag()==null) || 
             (this.m_nVipFlag!=null &&
              this.m_nVipFlag.equals(other.getM_nVipFlag()))) &&
            ((this.m_nUserRelate==null && other.getM_nUserRelate()==null) || 
             (this.m_nUserRelate!=null &&
              this.m_nUserRelate.equals(other.getM_nUserRelate()))) &&
            ((this.m_iBillFormatId==null && other.getM_iBillFormatId()==null) || 
             (this.m_iBillFormatId!=null &&
              this.m_iBillFormatId.equals(other.getM_iBillFormatId()))) &&
            ((this.m_llBookTotalAmt==null && other.getM_llBookTotalAmt()==null) || 
             (this.m_llBookTotalAmt!=null &&
              this.m_llBookTotalAmt.equals(other.getM_llBookTotalAmt()))) &&
            ((this.m_llBookTotalWoff==null && other.getM_llBookTotalWoff()==null) || 
             (this.m_llBookTotalWoff!=null &&
              this.m_llBookTotalWoff.equals(other.getM_llBookTotalWoff()))) &&
            ((this.m_llBookNorTotalAmt==null && other.getM_llBookNorTotalAmt()==null) || 
             (this.m_llBookNorTotalAmt!=null &&
              this.m_llBookNorTotalAmt.equals(other.getM_llBookNorTotalAmt()))) &&
            ((this.m_llBookNorTotalWoff==null && other.getM_llBookNorTotalWoff()==null) || 
             (this.m_llBookNorTotalWoff!=null &&
              this.m_llBookNorTotalWoff.equals(other.getM_llBookNorTotalWoff()))) &&
            ((this.m_llBookSpecTotalAmt==null && other.getM_llBookSpecTotalAmt()==null) || 
             (this.m_llBookSpecTotalAmt!=null &&
              this.m_llBookSpecTotalAmt.equals(other.getM_llBookSpecTotalAmt()))) &&
            ((this.m_llBookSpecTotalWoff==null && other.getM_llBookSpecTotalWoff()==null) || 
             (this.m_llBookSpecTotalWoff!=null &&
              this.m_llBookSpecTotalWoff.equals(other.getM_llBookSpecTotalWoff()))) &&
            ((this.m_llBookNoinvtotalWoff==null && other.getM_llBookNoinvtotalWoff()==null) || 
             (this.m_llBookNoinvtotalWoff!=null &&
              this.m_llBookNoinvtotalWoff.equals(other.getM_llBookNoinvtotalWoff()))) &&
            ((this.m_listAllBookSnapShotList==null && other.getM_listAllBookSnapShotList()==null) || 
             (this.m_listAllBookSnapShotList!=null &&
              java.util.Arrays.equals(this.m_listAllBookSnapShotList, other.getM_listAllBookSnapShotList()))) &&
            ((this.m_listBillSnapShotList==null && other.getM_listBillSnapShotList()==null) || 
             (this.m_listBillSnapShotList!=null &&
              java.util.Arrays.equals(this.m_listBillSnapShotList, other.getM_listBillSnapShotList())));
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
        if (getM_llAcctId() != null) {
            _hashCode += getM_llAcctId().hashCode();
        }
        if (getM_strAcctName() != null) {
            _hashCode += getM_strAcctName().hashCode();
        }
        if (getM_strServName() != null) {
            _hashCode += getM_strServName().hashCode();
        }
        if (getM_strCustName() != null) {
            _hashCode += getM_strCustName().hashCode();
        }
        if (getM_iPayType() != null) {
            _hashCode += getM_iPayType().hashCode();
        }
        if (getM_iOfRegionCode() != null) {
            _hashCode += getM_iOfRegionCode().hashCode();
        }
        if (getM_iCountyCode() != null) {
            _hashCode += getM_iCountyCode().hashCode();
        }
        if (getM_iOfOrgId() != null) {
            _hashCode += getM_iOfOrgId().hashCode();
        }
        if (getM_nCreditClass() != null) {
            _hashCode += getM_nCreditClass().hashCode();
        }
        if (getM_iCredit() != null) {
            _hashCode += getM_iCredit().hashCode();
        }
        if (getM_nCustClass() != null) {
            _hashCode += getM_nCustClass().hashCode();
        }
        if (getM_nAcctClass() != null) {
            _hashCode += getM_nAcctClass().hashCode();
        }
        if (getM_nVipFlag() != null) {
            _hashCode += getM_nVipFlag().hashCode();
        }
        if (getM_nUserRelate() != null) {
            _hashCode += getM_nUserRelate().hashCode();
        }
        if (getM_iBillFormatId() != null) {
            _hashCode += getM_iBillFormatId().hashCode();
        }
        if (getM_llBookTotalAmt() != null) {
            _hashCode += getM_llBookTotalAmt().hashCode();
        }
        if (getM_llBookTotalWoff() != null) {
            _hashCode += getM_llBookTotalWoff().hashCode();
        }
        if (getM_llBookNorTotalAmt() != null) {
            _hashCode += getM_llBookNorTotalAmt().hashCode();
        }
        if (getM_llBookNorTotalWoff() != null) {
            _hashCode += getM_llBookNorTotalWoff().hashCode();
        }
        if (getM_llBookSpecTotalAmt() != null) {
            _hashCode += getM_llBookSpecTotalAmt().hashCode();
        }
        if (getM_llBookSpecTotalWoff() != null) {
            _hashCode += getM_llBookSpecTotalWoff().hashCode();
        }
        if (getM_llBookNoinvtotalWoff() != null) {
            _hashCode += getM_llBookNoinvtotalWoff().hashCode();
        }
        if (getM_listAllBookSnapShotList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listAllBookSnapShotList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listAllBookSnapShotList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listBillSnapShotList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listBillSnapShotList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listBillSnapShotList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSBookWriteFee.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookWriteFee"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strAcctName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strAcctName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strServName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strServName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strCustName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iPayType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iPayType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOfRegionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOfRegionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iCountyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iCountyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iOfOrgId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iOfOrgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nCreditClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nCreditClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nCustClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nCustClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nAcctClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nAcctClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nVipFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nVipFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nUserRelate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nUserRelate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
        elemField.setFieldName("m_llBookTotalAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookTotalAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookTotalWoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookTotalWoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookNorTotalAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookNorTotalAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookNorTotalWoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookNorTotalWoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookSpecTotalAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookSpecTotalAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookSpecTotalWoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookSpecTotalWoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBookNoinvtotalWoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBookNoinvtotalWoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listAllBookSnapShotList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listAllBookSnapShotList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShot"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listBillSnapShotList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listBillSnapShotList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBillSnapShot"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
