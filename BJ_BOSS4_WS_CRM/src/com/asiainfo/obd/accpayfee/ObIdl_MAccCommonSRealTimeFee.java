/**
 * ObIdl_MAccCommonSRealTimeFee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSRealTimeFee  implements java.io.Serializable {
    private java.lang.Long m_llAcctId;

    private java.lang.Long m_llOrigAcctId;

    private java.lang.Long m_llServId;

    private java.lang.String m_strPhoneId;

    private java.lang.Integer m_iBillMonth;

    private java.lang.Integer m_iFeeItemId;

    private java.lang.Integer m_iServiceId;

    private java.lang.Long m_llTotalFee;

    private java.lang.Long m_llTotalUnit;

    private java.lang.Long m_llTotalCount;

    private java.lang.Long m_llTotalCellCount;

    private java.lang.Long m_llDiscountFee;

    private java.lang.Long m_llDeratedFee;

    private java.lang.Long m_llAdjustedFee;

    private java.lang.Long m_llRefusedFee;

    private java.lang.Long m_llPpyFee;

    private java.lang.Long m_llUnpayFee;

    private java.lang.Long m_llFeeWoff;

    private ObIdl_MAccCommonSBookSnapShot[] m_listBookSnapShotList;

    public ObIdl_MAccCommonSRealTimeFee() {
    }

    public ObIdl_MAccCommonSRealTimeFee(
           java.lang.Long m_llAcctId,
           java.lang.Long m_llOrigAcctId,
           java.lang.Long m_llServId,
           java.lang.String m_strPhoneId,
           java.lang.Integer m_iBillMonth,
           java.lang.Integer m_iFeeItemId,
           java.lang.Integer m_iServiceId,
           java.lang.Long m_llTotalFee,
           java.lang.Long m_llTotalUnit,
           java.lang.Long m_llTotalCount,
           java.lang.Long m_llTotalCellCount,
           java.lang.Long m_llDiscountFee,
           java.lang.Long m_llDeratedFee,
           java.lang.Long m_llAdjustedFee,
           java.lang.Long m_llRefusedFee,
           java.lang.Long m_llPpyFee,
           java.lang.Long m_llUnpayFee,
           java.lang.Long m_llFeeWoff,
           ObIdl_MAccCommonSBookSnapShot[] m_listBookSnapShotList) {
           this.m_llAcctId = m_llAcctId;
           this.m_llOrigAcctId = m_llOrigAcctId;
           this.m_llServId = m_llServId;
           this.m_strPhoneId = m_strPhoneId;
           this.m_iBillMonth = m_iBillMonth;
           this.m_iFeeItemId = m_iFeeItemId;
           this.m_iServiceId = m_iServiceId;
           this.m_llTotalFee = m_llTotalFee;
           this.m_llTotalUnit = m_llTotalUnit;
           this.m_llTotalCount = m_llTotalCount;
           this.m_llTotalCellCount = m_llTotalCellCount;
           this.m_llDiscountFee = m_llDiscountFee;
           this.m_llDeratedFee = m_llDeratedFee;
           this.m_llAdjustedFee = m_llAdjustedFee;
           this.m_llRefusedFee = m_llRefusedFee;
           this.m_llPpyFee = m_llPpyFee;
           this.m_llUnpayFee = m_llUnpayFee;
           this.m_llFeeWoff = m_llFeeWoff;
           this.m_listBookSnapShotList = m_listBookSnapShotList;
    }


    /**
     * Gets the m_llAcctId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llAcctId
     */
    public java.lang.Long getM_llAcctId() {
        return m_llAcctId;
    }


    /**
     * Sets the m_llAcctId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llAcctId
     */
    public void setM_llAcctId(java.lang.Long m_llAcctId) {
        this.m_llAcctId = m_llAcctId;
    }


    /**
     * Gets the m_llOrigAcctId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llOrigAcctId
     */
    public java.lang.Long getM_llOrigAcctId() {
        return m_llOrigAcctId;
    }


    /**
     * Sets the m_llOrigAcctId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llOrigAcctId
     */
    public void setM_llOrigAcctId(java.lang.Long m_llOrigAcctId) {
        this.m_llOrigAcctId = m_llOrigAcctId;
    }


    /**
     * Gets the m_llServId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llServId
     */
    public java.lang.Long getM_llServId() {
        return m_llServId;
    }


    /**
     * Sets the m_llServId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llServId
     */
    public void setM_llServId(java.lang.Long m_llServId) {
        this.m_llServId = m_llServId;
    }


    /**
     * Gets the m_strPhoneId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_strPhoneId
     */
    public java.lang.String getM_strPhoneId() {
        return m_strPhoneId;
    }


    /**
     * Sets the m_strPhoneId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_strPhoneId
     */
    public void setM_strPhoneId(java.lang.String m_strPhoneId) {
        this.m_strPhoneId = m_strPhoneId;
    }


    /**
     * Gets the m_iBillMonth value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_iBillMonth
     */
    public java.lang.Integer getM_iBillMonth() {
        return m_iBillMonth;
    }


    /**
     * Sets the m_iBillMonth value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_iBillMonth
     */
    public void setM_iBillMonth(java.lang.Integer m_iBillMonth) {
        this.m_iBillMonth = m_iBillMonth;
    }


    /**
     * Gets the m_iFeeItemId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_iFeeItemId
     */
    public java.lang.Integer getM_iFeeItemId() {
        return m_iFeeItemId;
    }


    /**
     * Sets the m_iFeeItemId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_iFeeItemId
     */
    public void setM_iFeeItemId(java.lang.Integer m_iFeeItemId) {
        this.m_iFeeItemId = m_iFeeItemId;
    }


    /**
     * Gets the m_iServiceId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_iServiceId
     */
    public java.lang.Integer getM_iServiceId() {
        return m_iServiceId;
    }


    /**
     * Sets the m_iServiceId value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_iServiceId
     */
    public void setM_iServiceId(java.lang.Integer m_iServiceId) {
        this.m_iServiceId = m_iServiceId;
    }


    /**
     * Gets the m_llTotalFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llTotalFee
     */
    public java.lang.Long getM_llTotalFee() {
        return m_llTotalFee;
    }


    /**
     * Sets the m_llTotalFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llTotalFee
     */
    public void setM_llTotalFee(java.lang.Long m_llTotalFee) {
        this.m_llTotalFee = m_llTotalFee;
    }


    /**
     * Gets the m_llTotalUnit value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llTotalUnit
     */
    public java.lang.Long getM_llTotalUnit() {
        return m_llTotalUnit;
    }


    /**
     * Sets the m_llTotalUnit value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llTotalUnit
     */
    public void setM_llTotalUnit(java.lang.Long m_llTotalUnit) {
        this.m_llTotalUnit = m_llTotalUnit;
    }


    /**
     * Gets the m_llTotalCount value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llTotalCount
     */
    public java.lang.Long getM_llTotalCount() {
        return m_llTotalCount;
    }


    /**
     * Sets the m_llTotalCount value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llTotalCount
     */
    public void setM_llTotalCount(java.lang.Long m_llTotalCount) {
        this.m_llTotalCount = m_llTotalCount;
    }


    /**
     * Gets the m_llTotalCellCount value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llTotalCellCount
     */
    public java.lang.Long getM_llTotalCellCount() {
        return m_llTotalCellCount;
    }


    /**
     * Sets the m_llTotalCellCount value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llTotalCellCount
     */
    public void setM_llTotalCellCount(java.lang.Long m_llTotalCellCount) {
        this.m_llTotalCellCount = m_llTotalCellCount;
    }


    /**
     * Gets the m_llDiscountFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llDiscountFee
     */
    public java.lang.Long getM_llDiscountFee() {
        return m_llDiscountFee;
    }


    /**
     * Sets the m_llDiscountFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llDiscountFee
     */
    public void setM_llDiscountFee(java.lang.Long m_llDiscountFee) {
        this.m_llDiscountFee = m_llDiscountFee;
    }


    /**
     * Gets the m_llDeratedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llDeratedFee
     */
    public java.lang.Long getM_llDeratedFee() {
        return m_llDeratedFee;
    }


    /**
     * Sets the m_llDeratedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llDeratedFee
     */
    public void setM_llDeratedFee(java.lang.Long m_llDeratedFee) {
        this.m_llDeratedFee = m_llDeratedFee;
    }


    /**
     * Gets the m_llAdjustedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llAdjustedFee
     */
    public java.lang.Long getM_llAdjustedFee() {
        return m_llAdjustedFee;
    }


    /**
     * Sets the m_llAdjustedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llAdjustedFee
     */
    public void setM_llAdjustedFee(java.lang.Long m_llAdjustedFee) {
        this.m_llAdjustedFee = m_llAdjustedFee;
    }


    /**
     * Gets the m_llRefusedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llRefusedFee
     */
    public java.lang.Long getM_llRefusedFee() {
        return m_llRefusedFee;
    }


    /**
     * Sets the m_llRefusedFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llRefusedFee
     */
    public void setM_llRefusedFee(java.lang.Long m_llRefusedFee) {
        this.m_llRefusedFee = m_llRefusedFee;
    }


    /**
     * Gets the m_llPpyFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llPpyFee
     */
    public java.lang.Long getM_llPpyFee() {
        return m_llPpyFee;
    }


    /**
     * Sets the m_llPpyFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llPpyFee
     */
    public void setM_llPpyFee(java.lang.Long m_llPpyFee) {
        this.m_llPpyFee = m_llPpyFee;
    }


    /**
     * Gets the m_llUnpayFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llUnpayFee
     */
    public java.lang.Long getM_llUnpayFee() {
        return m_llUnpayFee;
    }


    /**
     * Sets the m_llUnpayFee value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llUnpayFee
     */
    public void setM_llUnpayFee(java.lang.Long m_llUnpayFee) {
        this.m_llUnpayFee = m_llUnpayFee;
    }


    /**
     * Gets the m_llFeeWoff value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_llFeeWoff
     */
    public java.lang.Long getM_llFeeWoff() {
        return m_llFeeWoff;
    }


    /**
     * Sets the m_llFeeWoff value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_llFeeWoff
     */
    public void setM_llFeeWoff(java.lang.Long m_llFeeWoff) {
        this.m_llFeeWoff = m_llFeeWoff;
    }


    /**
     * Gets the m_listBookSnapShotList value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @return m_listBookSnapShotList
     */
    public ObIdl_MAccCommonSBookSnapShot[] getM_listBookSnapShotList() {
        return m_listBookSnapShotList;
    }


    /**
     * Sets the m_listBookSnapShotList value for this ObIdl_MAccCommonSRealTimeFee.
     * 
     * @param m_listBookSnapShotList
     */
    public void setM_listBookSnapShotList(ObIdl_MAccCommonSBookSnapShot[] m_listBookSnapShotList) {
        this.m_listBookSnapShotList = m_listBookSnapShotList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSRealTimeFee)) return false;
        ObIdl_MAccCommonSRealTimeFee other = (ObIdl_MAccCommonSRealTimeFee) obj;
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
            ((this.m_llOrigAcctId==null && other.getM_llOrigAcctId()==null) || 
             (this.m_llOrigAcctId!=null &&
              this.m_llOrigAcctId.equals(other.getM_llOrigAcctId()))) &&
            ((this.m_llServId==null && other.getM_llServId()==null) || 
             (this.m_llServId!=null &&
              this.m_llServId.equals(other.getM_llServId()))) &&
            ((this.m_strPhoneId==null && other.getM_strPhoneId()==null) || 
             (this.m_strPhoneId!=null &&
              this.m_strPhoneId.equals(other.getM_strPhoneId()))) &&
            ((this.m_iBillMonth==null && other.getM_iBillMonth()==null) || 
             (this.m_iBillMonth!=null &&
              this.m_iBillMonth.equals(other.getM_iBillMonth()))) &&
            ((this.m_iFeeItemId==null && other.getM_iFeeItemId()==null) || 
             (this.m_iFeeItemId!=null &&
              this.m_iFeeItemId.equals(other.getM_iFeeItemId()))) &&
            ((this.m_iServiceId==null && other.getM_iServiceId()==null) || 
             (this.m_iServiceId!=null &&
              this.m_iServiceId.equals(other.getM_iServiceId()))) &&
            ((this.m_llTotalFee==null && other.getM_llTotalFee()==null) || 
             (this.m_llTotalFee!=null &&
              this.m_llTotalFee.equals(other.getM_llTotalFee()))) &&
            ((this.m_llTotalUnit==null && other.getM_llTotalUnit()==null) || 
             (this.m_llTotalUnit!=null &&
              this.m_llTotalUnit.equals(other.getM_llTotalUnit()))) &&
            ((this.m_llTotalCount==null && other.getM_llTotalCount()==null) || 
             (this.m_llTotalCount!=null &&
              this.m_llTotalCount.equals(other.getM_llTotalCount()))) &&
            ((this.m_llTotalCellCount==null && other.getM_llTotalCellCount()==null) || 
             (this.m_llTotalCellCount!=null &&
              this.m_llTotalCellCount.equals(other.getM_llTotalCellCount()))) &&
            ((this.m_llDiscountFee==null && other.getM_llDiscountFee()==null) || 
             (this.m_llDiscountFee!=null &&
              this.m_llDiscountFee.equals(other.getM_llDiscountFee()))) &&
            ((this.m_llDeratedFee==null && other.getM_llDeratedFee()==null) || 
             (this.m_llDeratedFee!=null &&
              this.m_llDeratedFee.equals(other.getM_llDeratedFee()))) &&
            ((this.m_llAdjustedFee==null && other.getM_llAdjustedFee()==null) || 
             (this.m_llAdjustedFee!=null &&
              this.m_llAdjustedFee.equals(other.getM_llAdjustedFee()))) &&
            ((this.m_llRefusedFee==null && other.getM_llRefusedFee()==null) || 
             (this.m_llRefusedFee!=null &&
              this.m_llRefusedFee.equals(other.getM_llRefusedFee()))) &&
            ((this.m_llPpyFee==null && other.getM_llPpyFee()==null) || 
             (this.m_llPpyFee!=null &&
              this.m_llPpyFee.equals(other.getM_llPpyFee()))) &&
            ((this.m_llUnpayFee==null && other.getM_llUnpayFee()==null) || 
             (this.m_llUnpayFee!=null &&
              this.m_llUnpayFee.equals(other.getM_llUnpayFee()))) &&
            ((this.m_llFeeWoff==null && other.getM_llFeeWoff()==null) || 
             (this.m_llFeeWoff!=null &&
              this.m_llFeeWoff.equals(other.getM_llFeeWoff()))) &&
            ((this.m_listBookSnapShotList==null && other.getM_listBookSnapShotList()==null) || 
             (this.m_listBookSnapShotList!=null &&
              java.util.Arrays.equals(this.m_listBookSnapShotList, other.getM_listBookSnapShotList())));
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
        if (getM_llOrigAcctId() != null) {
            _hashCode += getM_llOrigAcctId().hashCode();
        }
        if (getM_llServId() != null) {
            _hashCode += getM_llServId().hashCode();
        }
        if (getM_strPhoneId() != null) {
            _hashCode += getM_strPhoneId().hashCode();
        }
        if (getM_iBillMonth() != null) {
            _hashCode += getM_iBillMonth().hashCode();
        }
        if (getM_iFeeItemId() != null) {
            _hashCode += getM_iFeeItemId().hashCode();
        }
        if (getM_iServiceId() != null) {
            _hashCode += getM_iServiceId().hashCode();
        }
        if (getM_llTotalFee() != null) {
            _hashCode += getM_llTotalFee().hashCode();
        }
        if (getM_llTotalUnit() != null) {
            _hashCode += getM_llTotalUnit().hashCode();
        }
        if (getM_llTotalCount() != null) {
            _hashCode += getM_llTotalCount().hashCode();
        }
        if (getM_llTotalCellCount() != null) {
            _hashCode += getM_llTotalCellCount().hashCode();
        }
        if (getM_llDiscountFee() != null) {
            _hashCode += getM_llDiscountFee().hashCode();
        }
        if (getM_llDeratedFee() != null) {
            _hashCode += getM_llDeratedFee().hashCode();
        }
        if (getM_llAdjustedFee() != null) {
            _hashCode += getM_llAdjustedFee().hashCode();
        }
        if (getM_llRefusedFee() != null) {
            _hashCode += getM_llRefusedFee().hashCode();
        }
        if (getM_llPpyFee() != null) {
            _hashCode += getM_llPpyFee().hashCode();
        }
        if (getM_llUnpayFee() != null) {
            _hashCode += getM_llUnpayFee().hashCode();
        }
        if (getM_llFeeWoff() != null) {
            _hashCode += getM_llFeeWoff().hashCode();
        }
        if (getM_listBookSnapShotList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listBookSnapShotList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listBookSnapShotList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSRealTimeFee.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SRealTimeFee"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAcctId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llOrigAcctId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llOrigAcctId"));
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
        elemField.setFieldName("m_iBillMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBillMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iFeeItemId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iFeeItemId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iServiceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iServiceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalUnit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llTotalCellCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llTotalCellCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llDiscountFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llDiscountFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llDeratedFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llDeratedFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llAdjustedFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llAdjustedFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llRefusedFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llRefusedFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llPpyFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llPpyFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llUnpayFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llUnpayFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llFeeWoff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llFeeWoff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listBookSnapShotList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listBookSnapShotList"));
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
