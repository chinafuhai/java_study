/**
 * ObIdl_MAccCommonSBillSnapShot.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSBillSnapShot  implements java.io.Serializable {
    private java.lang.Long m_llBillId;

    private java.lang.Long m_llServId;

    private java.lang.String m_strPhoneId;

    private java.lang.Long m_llDefaultAcctId;

    private java.lang.Long m_llBillMonth;

    private java.lang.Long m_llUserType;

    private java.lang.Long m_llBrand;

    private java.lang.Long m_llPlanId;

    private java.lang.Long m_llUserProperty;

    private java.lang.Short m_nPaySts;

    private java.lang.Short m_nPayType;

    private java.lang.String m_dtmBeginDate;

    private java.lang.String m_dtmEndDate;

    private java.lang.String m_dtmPrintDate;

    private java.lang.Long m_llLateFee;

    private java.lang.Long m_llDelayLateFee;

    private java.lang.Long m_llWoffLateFee;

    private java.lang.Long m_llCutLateFee;

    private java.lang.Long m_llPpyLateFee;

    private java.lang.Long m_llUnprtLateFee;

    private java.lang.Long m_llWoffCardBook;

    private ObIdl_MAccCommonSFeeBookSnapShot[] m_listFeeBookSnapShotList;

    private ObIdl_MAccCommonSBookSnapShot[] m_listLfeeBookSnapShotList;

    public ObIdl_MAccCommonSBillSnapShot() {
    }

    public ObIdl_MAccCommonSBillSnapShot(
           java.lang.Long m_llBillId,
           java.lang.Long m_llServId,
           java.lang.String m_strPhoneId,
           java.lang.Long m_llDefaultAcctId,
           java.lang.Long m_llBillMonth,
           java.lang.Long m_llUserType,
           java.lang.Long m_llBrand,
           java.lang.Long m_llPlanId,
           java.lang.Long m_llUserProperty,
           java.lang.Short m_nPaySts,
           java.lang.Short m_nPayType,
           java.lang.String m_dtmBeginDate,
           java.lang.String m_dtmEndDate,
           java.lang.String m_dtmPrintDate,
           java.lang.Long m_llLateFee,
           java.lang.Long m_llDelayLateFee,
           java.lang.Long m_llWoffLateFee,
           java.lang.Long m_llCutLateFee,
           java.lang.Long m_llPpyLateFee,
           java.lang.Long m_llUnprtLateFee,
           java.lang.Long m_llWoffCardBook,
           ObIdl_MAccCommonSFeeBookSnapShot[] m_listFeeBookSnapShotList,
           ObIdl_MAccCommonSBookSnapShot[] m_listLfeeBookSnapShotList) {
           this.m_llBillId = m_llBillId;
           this.m_llServId = m_llServId;
           this.m_strPhoneId = m_strPhoneId;
           this.m_llDefaultAcctId = m_llDefaultAcctId;
           this.m_llBillMonth = m_llBillMonth;
           this.m_llUserType = m_llUserType;
           this.m_llBrand = m_llBrand;
           this.m_llPlanId = m_llPlanId;
           this.m_llUserProperty = m_llUserProperty;
           this.m_nPaySts = m_nPaySts;
           this.m_nPayType = m_nPayType;
           this.m_dtmBeginDate = m_dtmBeginDate;
           this.m_dtmEndDate = m_dtmEndDate;
           this.m_dtmPrintDate = m_dtmPrintDate;
           this.m_llLateFee = m_llLateFee;
           this.m_llDelayLateFee = m_llDelayLateFee;
           this.m_llWoffLateFee = m_llWoffLateFee;
           this.m_llCutLateFee = m_llCutLateFee;
           this.m_llPpyLateFee = m_llPpyLateFee;
           this.m_llUnprtLateFee = m_llUnprtLateFee;
           this.m_llWoffCardBook = m_llWoffCardBook;
           this.m_listFeeBookSnapShotList = m_listFeeBookSnapShotList;
           this.m_listLfeeBookSnapShotList = m_listLfeeBookSnapShotList;
    }


    /**
     * Gets the m_llBillId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llBillId
     */
    public java.lang.Long getM_llBillId() {
        return m_llBillId;
    }


    /**
     * Sets the m_llBillId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llBillId
     */
    public void setM_llBillId(java.lang.Long m_llBillId) {
        this.m_llBillId = m_llBillId;
    }


    /**
     * Gets the m_llServId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llServId
     */
    public java.lang.Long getM_llServId() {
        return m_llServId;
    }


    /**
     * Sets the m_llServId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llServId
     */
    public void setM_llServId(java.lang.Long m_llServId) {
        this.m_llServId = m_llServId;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_llDefaultAcctId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llDefaultAcctId
     */
    public java.lang.Long getM_llDefaultAcctId() {
        return m_llDefaultAcctId;
    }


    /**
     * Sets the m_llDefaultAcctId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llDefaultAcctId
     */
    public void setM_llDefaultAcctId(java.lang.Long m_llDefaultAcctId) {
        this.m_llDefaultAcctId = m_llDefaultAcctId;
    }


    /**
     * Gets the m_llBillMonth value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llBillMonth
     */
    public java.lang.Long getM_llBillMonth() {
        return m_llBillMonth;
    }


    /**
     * Sets the m_llBillMonth value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llBillMonth
     */
    public void setM_llBillMonth(java.lang.Long m_llBillMonth) {
        this.m_llBillMonth = m_llBillMonth;
    }


    /**
     * Gets the m_llUserType value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llUserType
     */
    public java.lang.Long getM_llUserType() {
        return m_llUserType;
    }


    /**
     * Sets the m_llUserType value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llUserType
     */
    public void setM_llUserType(java.lang.Long m_llUserType) {
        this.m_llUserType = m_llUserType;
    }


    /**
     * Gets the m_llBrand value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llBrand
     */
    public java.lang.Long getM_llBrand() {
        return m_llBrand;
    }


    /**
     * Sets the m_llBrand value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llBrand
     */
    public void setM_llBrand(java.lang.Long m_llBrand) {
        this.m_llBrand = m_llBrand;
    }


    /**
     * Gets the m_llPlanId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llPlanId
     */
    public java.lang.Long getM_llPlanId() {
        return m_llPlanId;
    }


    /**
     * Sets the m_llPlanId value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llPlanId
     */
    public void setM_llPlanId(java.lang.Long m_llPlanId) {
        this.m_llPlanId = m_llPlanId;
    }


    /**
     * Gets the m_llUserProperty value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llUserProperty
     */
    public java.lang.Long getM_llUserProperty() {
        return m_llUserProperty;
    }


    /**
     * Sets the m_llUserProperty value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llUserProperty
     */
    public void setM_llUserProperty(java.lang.Long m_llUserProperty) {
        this.m_llUserProperty = m_llUserProperty;
    }


    /**
     * Gets the m_nPaySts value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_nPaySts
     */
    public java.lang.Short getM_nPaySts() {
        return m_nPaySts;
    }


    /**
     * Sets the m_nPaySts value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_nPaySts
     */
    public void setM_nPaySts(java.lang.Short m_nPaySts) {
        this.m_nPaySts = m_nPaySts;
    }


    /**
     * Gets the m_nPayType value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_nPayType
     */
    public java.lang.Short getM_nPayType() {
        return m_nPayType;
    }


    /**
     * Sets the m_nPayType value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_nPayType
     */
    public void setM_nPayType(java.lang.Short m_nPayType) {
        this.m_nPayType = m_nPayType;
    }


    /**
     * Gets the m_dtmBeginDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_dtmBeginDate
     */
    public java.lang.String getM_dtmBeginDate() {
        return m_dtmBeginDate;
    }


    /**
     * Sets the m_dtmBeginDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_dtmBeginDate
     */
    public void setM_dtmBeginDate(java.lang.String m_dtmBeginDate) {
        this.m_dtmBeginDate = m_dtmBeginDate;
    }


    /**
     * Gets the m_dtmEndDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_dtmEndDate
     */
    public java.lang.String getM_dtmEndDate() {
        return m_dtmEndDate;
    }


    /**
     * Sets the m_dtmEndDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_dtmEndDate
     */
    public void setM_dtmEndDate(java.lang.String m_dtmEndDate) {
        this.m_dtmEndDate = m_dtmEndDate;
    }


    /**
     * Gets the m_dtmPrintDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_dtmPrintDate
     */
    public java.lang.String getM_dtmPrintDate() {
        return m_dtmPrintDate;
    }


    /**
     * Sets the m_dtmPrintDate value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_dtmPrintDate
     */
    public void setM_dtmPrintDate(java.lang.String m_dtmPrintDate) {
        this.m_dtmPrintDate = m_dtmPrintDate;
    }


    /**
     * Gets the m_llLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llLateFee
     */
    public java.lang.Long getM_llLateFee() {
        return m_llLateFee;
    }


    /**
     * Sets the m_llLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llLateFee
     */
    public void setM_llLateFee(java.lang.Long m_llLateFee) {
        this.m_llLateFee = m_llLateFee;
    }


    /**
     * Gets the m_llDelayLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llDelayLateFee
     */
    public java.lang.Long getM_llDelayLateFee() {
        return m_llDelayLateFee;
    }


    /**
     * Sets the m_llDelayLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llDelayLateFee
     */
    public void setM_llDelayLateFee(java.lang.Long m_llDelayLateFee) {
        this.m_llDelayLateFee = m_llDelayLateFee;
    }


    /**
     * Gets the m_llWoffLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llWoffLateFee
     */
    public java.lang.Long getM_llWoffLateFee() {
        return m_llWoffLateFee;
    }


    /**
     * Sets the m_llWoffLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llWoffLateFee
     */
    public void setM_llWoffLateFee(java.lang.Long m_llWoffLateFee) {
        this.m_llWoffLateFee = m_llWoffLateFee;
    }


    /**
     * Gets the m_llCutLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llCutLateFee
     */
    public java.lang.Long getM_llCutLateFee() {
        return m_llCutLateFee;
    }


    /**
     * Sets the m_llCutLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llCutLateFee
     */
    public void setM_llCutLateFee(java.lang.Long m_llCutLateFee) {
        this.m_llCutLateFee = m_llCutLateFee;
    }


    /**
     * Gets the m_llPpyLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llPpyLateFee
     */
    public java.lang.Long getM_llPpyLateFee() {
        return m_llPpyLateFee;
    }


    /**
     * Sets the m_llPpyLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llPpyLateFee
     */
    public void setM_llPpyLateFee(java.lang.Long m_llPpyLateFee) {
        this.m_llPpyLateFee = m_llPpyLateFee;
    }


    /**
     * Gets the m_llUnprtLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llUnprtLateFee
     */
    public java.lang.Long getM_llUnprtLateFee() {
        return m_llUnprtLateFee;
    }


    /**
     * Sets the m_llUnprtLateFee value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llUnprtLateFee
     */
    public void setM_llUnprtLateFee(java.lang.Long m_llUnprtLateFee) {
        this.m_llUnprtLateFee = m_llUnprtLateFee;
    }


    /**
     * Gets the m_llWoffCardBook value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_llWoffCardBook
     */
    public java.lang.Long getM_llWoffCardBook() {
        return m_llWoffCardBook;
    }


    /**
     * Sets the m_llWoffCardBook value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_llWoffCardBook
     */
    public void setM_llWoffCardBook(java.lang.Long m_llWoffCardBook) {
        this.m_llWoffCardBook = m_llWoffCardBook;
    }


    /**
     * Gets the m_listFeeBookSnapShotList value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_listFeeBookSnapShotList
     */
    public ObIdl_MAccCommonSFeeBookSnapShot[] getM_listFeeBookSnapShotList() {
        return m_listFeeBookSnapShotList;
    }


    /**
     * Sets the m_listFeeBookSnapShotList value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_listFeeBookSnapShotList
     */
    public void setM_listFeeBookSnapShotList(ObIdl_MAccCommonSFeeBookSnapShot[] m_listFeeBookSnapShotList) {
        this.m_listFeeBookSnapShotList = m_listFeeBookSnapShotList;
    }


    /**
     * Gets the m_listLfeeBookSnapShotList value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @return m_listLfeeBookSnapShotList
     */
    public ObIdl_MAccCommonSBookSnapShot[] getM_listLfeeBookSnapShotList() {
        return m_listLfeeBookSnapShotList;
    }


    /**
     * Sets the m_listLfeeBookSnapShotList value for this ObIdl_MAccCommonSBillSnapShot.
     * 
     * @param m_listLfeeBookSnapShotList
     */
    public void setM_listLfeeBookSnapShotList(ObIdl_MAccCommonSBookSnapShot[] m_listLfeeBookSnapShotList) {
        this.m_listLfeeBookSnapShotList = m_listLfeeBookSnapShotList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSBillSnapShot)) return false;
        ObIdl_MAccCommonSBillSnapShot other = (ObIdl_MAccCommonSBillSnapShot) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llBillId==null && other.getM_llBillId()==null) || 
             (this.m_llBillId!=null &&
              this.m_llBillId.equals(other.getM_llBillId()))) &&
            ((this.m_llServId==null && other.getM_llServId()==null) || 
             (this.m_llServId!=null &&
              this.m_llServId.equals(other.getM_llServId()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_llDefaultAcctId==null && other.getM_llDefaultAcctId()==null) || 
             (this.m_llDefaultAcctId!=null &&
              this.m_llDefaultAcctId.equals(other.getM_llDefaultAcctId()))) &&
            ((this.m_llBillMonth==null && other.getM_llBillMonth()==null) || 
             (this.m_llBillMonth!=null &&
              this.m_llBillMonth.equals(other.getM_llBillMonth()))) &&
            ((this.m_llUserType==null && other.getM_llUserType()==null) || 
             (this.m_llUserType!=null &&
              this.m_llUserType.equals(other.getM_llUserType()))) &&
            ((this.m_llBrand==null && other.getM_llBrand()==null) || 
             (this.m_llBrand!=null &&
              this.m_llBrand.equals(other.getM_llBrand()))) &&
            ((this.m_llPlanId==null && other.getM_llPlanId()==null) || 
             (this.m_llPlanId!=null &&
              this.m_llPlanId.equals(other.getM_llPlanId()))) &&
            ((this.m_llUserProperty==null && other.getM_llUserProperty()==null) || 
             (this.m_llUserProperty!=null &&
              this.m_llUserProperty.equals(other.getM_llUserProperty()))) &&
            ((this.m_nPaySts==null && other.getM_nPaySts()==null) || 
             (this.m_nPaySts!=null &&
              this.m_nPaySts.equals(other.getM_nPaySts()))) &&
            ((this.m_nPayType==null && other.getM_nPayType()==null) || 
             (this.m_nPayType!=null &&
              this.m_nPayType.equals(other.getM_nPayType()))) &&
            ((this.m_dtmBeginDate==null && other.getM_dtmBeginDate()==null) || 
             (this.m_dtmBeginDate!=null &&
              this.m_dtmBeginDate.equals(other.getM_dtmBeginDate()))) &&
            ((this.m_dtmEndDate==null && other.getM_dtmEndDate()==null) || 
             (this.m_dtmEndDate!=null &&
              this.m_dtmEndDate.equals(other.getM_dtmEndDate()))) &&
            ((this.m_dtmPrintDate==null && other.getM_dtmPrintDate()==null) || 
             (this.m_dtmPrintDate!=null &&
              this.m_dtmPrintDate.equals(other.getM_dtmPrintDate()))) &&
            ((this.m_llLateFee==null && other.getM_llLateFee()==null) || 
             (this.m_llLateFee!=null &&
              this.m_llLateFee.equals(other.getM_llLateFee()))) &&
            ((this.m_llDelayLateFee==null && other.getM_llDelayLateFee()==null) || 
             (this.m_llDelayLateFee!=null &&
              this.m_llDelayLateFee.equals(other.getM_llDelayLateFee()))) &&
            ((this.m_llWoffLateFee==null && other.getM_llWoffLateFee()==null) || 
             (this.m_llWoffLateFee!=null &&
              this.m_llWoffLateFee.equals(other.getM_llWoffLateFee()))) &&
            ((this.m_llCutLateFee==null && other.getM_llCutLateFee()==null) || 
             (this.m_llCutLateFee!=null &&
              this.m_llCutLateFee.equals(other.getM_llCutLateFee()))) &&
            ((this.m_llPpyLateFee==null && other.getM_llPpyLateFee()==null) || 
             (this.m_llPpyLateFee!=null &&
              this.m_llPpyLateFee.equals(other.getM_llPpyLateFee()))) &&
            ((this.m_llUnprtLateFee==null && other.getM_llUnprtLateFee()==null) || 
             (this.m_llUnprtLateFee!=null &&
              this.m_llUnprtLateFee.equals(other.getM_llUnprtLateFee()))) &&
            ((this.m_llWoffCardBook==null && other.getM_llWoffCardBook()==null) || 
             (this.m_llWoffCardBook!=null &&
              this.m_llWoffCardBook.equals(other.getM_llWoffCardBook()))) &&
            ((this.m_listFeeBookSnapShotList==null && other.getM_listFeeBookSnapShotList()==null) || 
             (this.m_listFeeBookSnapShotList!=null &&
              java.util.Arrays.equals(this.m_listFeeBookSnapShotList, other.getM_listFeeBookSnapShotList()))) &&
            ((this.m_listLfeeBookSnapShotList==null && other.getM_listLfeeBookSnapShotList()==null) || 
             (this.m_listLfeeBookSnapShotList!=null &&
              java.util.Arrays.equals(this.m_listLfeeBookSnapShotList, other.getM_listLfeeBookSnapShotList())));
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
        if (getM_llBillId() != null) {
            _hashCode += getM_llBillId().hashCode();
        }
        if (getM_llServId() != null) {
            _hashCode += getM_llServId().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_llDefaultAcctId() != null) {
            _hashCode += getM_llDefaultAcctId().hashCode();
        }
        if (getM_llBillMonth() != null) {
            _hashCode += getM_llBillMonth().hashCode();
        }
        if (getM_llUserType() != null) {
            _hashCode += getM_llUserType().hashCode();
        }
        if (getM_llBrand() != null) {
            _hashCode += getM_llBrand().hashCode();
        }
        if (getM_llPlanId() != null) {
            _hashCode += getM_llPlanId().hashCode();
        }
        if (getM_llUserProperty() != null) {
            _hashCode += getM_llUserProperty().hashCode();
        }
        if (getM_nPaySts() != null) {
            _hashCode += getM_nPaySts().hashCode();
        }
        if (getM_nPayType() != null) {
            _hashCode += getM_nPayType().hashCode();
        }
        if (getM_dtmBeginDate() != null) {
            _hashCode += getM_dtmBeginDate().hashCode();
        }
        if (getM_dtmEndDate() != null) {
            _hashCode += getM_dtmEndDate().hashCode();
        }
        if (getM_dtmPrintDate() != null) {
            _hashCode += getM_dtmPrintDate().hashCode();
        }
        if (getM_llLateFee() != null) {
            _hashCode += getM_llLateFee().hashCode();
        }
        if (getM_llDelayLateFee() != null) {
            _hashCode += getM_llDelayLateFee().hashCode();
        }
        if (getM_llWoffLateFee() != null) {
            _hashCode += getM_llWoffLateFee().hashCode();
        }
        if (getM_llCutLateFee() != null) {
            _hashCode += getM_llCutLateFee().hashCode();
        }
        if (getM_llPpyLateFee() != null) {
            _hashCode += getM_llPpyLateFee().hashCode();
        }
        if (getM_llUnprtLateFee() != null) {
            _hashCode += getM_llUnprtLateFee().hashCode();
        }
        if (getM_llWoffCardBook() != null) {
            _hashCode += getM_llWoffCardBook().hashCode();
        }
        if (getM_listFeeBookSnapShotList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listFeeBookSnapShotList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listFeeBookSnapShotList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getM_listLfeeBookSnapShotList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listLfeeBookSnapShotList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listLfeeBookSnapShotList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSBillSnapShot.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBillSnapShot"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBillId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBillId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llServId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llServId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("m_llDefaultAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llDefaultAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBillMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBillMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUserType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUserType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPlanId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPlanId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUserProperty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUserProperty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nPaySts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nPaySts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nPayType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nPayType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmBeginDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmBeginDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmPrintDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmPrintDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llDelayLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llDelayLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llWoffLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llWoffLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llCutLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llCutLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPpyLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPpyLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUnprtLateFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUnprtLateFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llWoffCardBook");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llWoffCardBook"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listFeeBookSnapShotList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listFeeBookSnapShotList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SFeeBookSnapShot"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listLfeeBookSnapShotList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listLfeeBookSnapShotList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SBookSnapShot"));
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
