/**
 * ObIdl_MAccCommonSAccInvcRecInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.obd.accpayfee;

public class ObIdl_MAccCommonSAccInvcRecInfo  implements java.io.Serializable {
    private java.lang.Long m_llInvcNumSeq;

    private java.lang.Short m_nInvcType;

    private java.lang.String m_strInvcTypeDesc;

    private java.lang.Integer m_iBusiType;

    private java.lang.String m_strBusiTypeName;

    private java.lang.Integer m_iReceiptType;

    private java.lang.String m_strReceiptTypeName;

    private java.lang.Long m_llInvcFee;

    private java.lang.String m_strRemark;

    private java.lang.Integer m_iOpId;

    private java.lang.String m_strCrmOpId;

    private java.lang.String m_dtmCreateTime;

    private java.lang.Short m_nSts;

    private java.lang.String m_strCheckNbr;

    private java.lang.String m_strCustName;

    private java.lang.Integer m_iPrintCount;

    private java.lang.Short m_nTaxFormat;

    private java.lang.String m_strFlag;

    private java.lang.String m_strInvcNum;

    private ObIdl_MAccCommonSAccInvcRecDtl[] m_listInvcRecDtlList;

    public ObIdl_MAccCommonSAccInvcRecInfo() {
    }

    public ObIdl_MAccCommonSAccInvcRecInfo(
           java.lang.Long m_llInvcNumSeq,
           java.lang.Short m_nInvcType,
           java.lang.String m_strInvcTypeDesc,
           java.lang.Integer m_iBusiType,
           java.lang.String m_strBusiTypeName,
           java.lang.Integer m_iReceiptType,
           java.lang.String m_strReceiptTypeName,
           java.lang.Long m_llInvcFee,
           java.lang.String m_strRemark,
           java.lang.Integer m_iOpId,
           java.lang.String m_strCrmOpId,
           java.lang.String m_dtmCreateTime,
           java.lang.Short m_nSts,
           java.lang.String m_strCheckNbr,
           java.lang.String m_strCustName,
           java.lang.Integer m_iPrintCount,
           java.lang.Short m_nTaxFormat,
           java.lang.String m_strFlag,
           java.lang.String m_strInvcNum,
           ObIdl_MAccCommonSAccInvcRecDtl[] m_listInvcRecDtlList) {
           this.m_llInvcNumSeq = m_llInvcNumSeq;
           this.m_nInvcType = m_nInvcType;
           this.m_strInvcTypeDesc = m_strInvcTypeDesc;
           this.m_iBusiType = m_iBusiType;
           this.m_strBusiTypeName = m_strBusiTypeName;
           this.m_iReceiptType = m_iReceiptType;
           this.m_strReceiptTypeName = m_strReceiptTypeName;
           this.m_llInvcFee = m_llInvcFee;
           this.m_strRemark = m_strRemark;
           this.m_iOpId = m_iOpId;
           this.m_strCrmOpId = m_strCrmOpId;
           this.m_dtmCreateTime = m_dtmCreateTime;
           this.m_nSts = m_nSts;
           this.m_strCheckNbr = m_strCheckNbr;
           this.m_strCustName = m_strCustName;
           this.m_iPrintCount = m_iPrintCount;
           this.m_nTaxFormat = m_nTaxFormat;
           this.m_strFlag = m_strFlag;
           this.m_strInvcNum = m_strInvcNum;
           this.m_listInvcRecDtlList = m_listInvcRecDtlList;
    }


    /**
     * Gets the m_llInvcNumSeq value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_llInvcNumSeq
     */
    public java.lang.Long getM_llInvcNumSeq() {
        return m_llInvcNumSeq;
    }


    /**
     * Sets the m_llInvcNumSeq value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_llInvcNumSeq
     */
    public void setM_llInvcNumSeq(java.lang.Long m_llInvcNumSeq) {
        this.m_llInvcNumSeq = m_llInvcNumSeq;
    }


    /**
     * Gets the m_nInvcType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_nInvcType
     */
    public java.lang.Short getM_nInvcType() {
        return m_nInvcType;
    }


    /**
     * Sets the m_nInvcType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_nInvcType
     */
    public void setM_nInvcType(java.lang.Short m_nInvcType) {
        this.m_nInvcType = m_nInvcType;
    }


    /**
     * Gets the m_strInvcTypeDesc value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strInvcTypeDesc
     */
    public java.lang.String getM_strInvcTypeDesc() {
        return m_strInvcTypeDesc;
    }


    /**
     * Sets the m_strInvcTypeDesc value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strInvcTypeDesc
     */
    public void setM_strInvcTypeDesc(java.lang.String m_strInvcTypeDesc) {
        this.m_strInvcTypeDesc = m_strInvcTypeDesc;
    }


    /**
     * Gets the m_iBusiType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_iBusiType
     */
    public java.lang.Integer getM_iBusiType() {
        return m_iBusiType;
    }


    /**
     * Sets the m_iBusiType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_iBusiType
     */
    public void setM_iBusiType(java.lang.Integer m_iBusiType) {
        this.m_iBusiType = m_iBusiType;
    }


    /**
     * Gets the m_strBusiTypeName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strBusiTypeName
     */
    public java.lang.String getM_strBusiTypeName() {
        return m_strBusiTypeName;
    }


    /**
     * Sets the m_strBusiTypeName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strBusiTypeName
     */
    public void setM_strBusiTypeName(java.lang.String m_strBusiTypeName) {
        this.m_strBusiTypeName = m_strBusiTypeName;
    }


    /**
     * Gets the m_iReceiptType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_iReceiptType
     */
    public java.lang.Integer getM_iReceiptType() {
        return m_iReceiptType;
    }


    /**
     * Sets the m_iReceiptType value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_iReceiptType
     */
    public void setM_iReceiptType(java.lang.Integer m_iReceiptType) {
        this.m_iReceiptType = m_iReceiptType;
    }


    /**
     * Gets the m_strReceiptTypeName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strReceiptTypeName
     */
    public java.lang.String getM_strReceiptTypeName() {
        return m_strReceiptTypeName;
    }


    /**
     * Sets the m_strReceiptTypeName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strReceiptTypeName
     */
    public void setM_strReceiptTypeName(java.lang.String m_strReceiptTypeName) {
        this.m_strReceiptTypeName = m_strReceiptTypeName;
    }


    /**
     * Gets the m_llInvcFee value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_llInvcFee
     */
    public java.lang.Long getM_llInvcFee() {
        return m_llInvcFee;
    }


    /**
     * Sets the m_llInvcFee value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_llInvcFee
     */
    public void setM_llInvcFee(java.lang.Long m_llInvcFee) {
        this.m_llInvcFee = m_llInvcFee;
    }


    /**
     * Gets the m_strRemark value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strRemark
     */
    public java.lang.String getM_strRemark() {
        return m_strRemark;
    }


    /**
     * Sets the m_strRemark value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strRemark
     */
    public void setM_strRemark(java.lang.String m_strRemark) {
        this.m_strRemark = m_strRemark;
    }


    /**
     * Gets the m_iOpId value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_iOpId
     */
    public java.lang.Integer getM_iOpId() {
        return m_iOpId;
    }


    /**
     * Sets the m_iOpId value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_iOpId
     */
    public void setM_iOpId(java.lang.Integer m_iOpId) {
        this.m_iOpId = m_iOpId;
    }


    /**
     * Gets the m_strCrmOpId value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strCrmOpId
     */
    public java.lang.String getM_strCrmOpId() {
        return m_strCrmOpId;
    }


    /**
     * Sets the m_strCrmOpId value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strCrmOpId
     */
    public void setM_strCrmOpId(java.lang.String m_strCrmOpId) {
        this.m_strCrmOpId = m_strCrmOpId;
    }


    /**
     * Gets the m_dtmCreateTime value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_dtmCreateTime
     */
    public java.lang.String getM_dtmCreateTime() {
        return m_dtmCreateTime;
    }


    /**
     * Sets the m_dtmCreateTime value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_dtmCreateTime
     */
    public void setM_dtmCreateTime(java.lang.String m_dtmCreateTime) {
        this.m_dtmCreateTime = m_dtmCreateTime;
    }


    /**
     * Gets the m_nSts value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_nSts
     */
    public java.lang.Short getM_nSts() {
        return m_nSts;
    }


    /**
     * Sets the m_nSts value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_nSts
     */
    public void setM_nSts(java.lang.Short m_nSts) {
        this.m_nSts = m_nSts;
    }


    /**
     * Gets the m_strCheckNbr value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strCheckNbr
     */
    public java.lang.String getM_strCheckNbr() {
        return m_strCheckNbr;
    }


    /**
     * Sets the m_strCheckNbr value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strCheckNbr
     */
    public void setM_strCheckNbr(java.lang.String m_strCheckNbr) {
        this.m_strCheckNbr = m_strCheckNbr;
    }


    /**
     * Gets the m_strCustName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strCustName
     */
    public java.lang.String getM_strCustName() {
        return m_strCustName;
    }


    /**
     * Sets the m_strCustName value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strCustName
     */
    public void setM_strCustName(java.lang.String m_strCustName) {
        this.m_strCustName = m_strCustName;
    }


    /**
     * Gets the m_iPrintCount value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_iPrintCount
     */
    public java.lang.Integer getM_iPrintCount() {
        return m_iPrintCount;
    }


    /**
     * Sets the m_iPrintCount value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_iPrintCount
     */
    public void setM_iPrintCount(java.lang.Integer m_iPrintCount) {
        this.m_iPrintCount = m_iPrintCount;
    }


    /**
     * Gets the m_nTaxFormat value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_nTaxFormat
     */
    public java.lang.Short getM_nTaxFormat() {
        return m_nTaxFormat;
    }


    /**
     * Sets the m_nTaxFormat value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_nTaxFormat
     */
    public void setM_nTaxFormat(java.lang.Short m_nTaxFormat) {
        this.m_nTaxFormat = m_nTaxFormat;
    }


    /**
     * Gets the m_strFlag value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strFlag
     */
    public java.lang.String getM_strFlag() {
        return m_strFlag;
    }


    /**
     * Sets the m_strFlag value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strFlag
     */
    public void setM_strFlag(java.lang.String m_strFlag) {
        this.m_strFlag = m_strFlag;
    }


    /**
     * Gets the m_strInvcNum value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_strInvcNum
     */
    public java.lang.String getM_strInvcNum() {
        return m_strInvcNum;
    }


    /**
     * Sets the m_strInvcNum value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_strInvcNum
     */
    public void setM_strInvcNum(java.lang.String m_strInvcNum) {
        this.m_strInvcNum = m_strInvcNum;
    }


    /**
     * Gets the m_listInvcRecDtlList value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @return m_listInvcRecDtlList
     */
    public ObIdl_MAccCommonSAccInvcRecDtl[] getM_listInvcRecDtlList() {
        return m_listInvcRecDtlList;
    }


    /**
     * Sets the m_listInvcRecDtlList value for this ObIdl_MAccCommonSAccInvcRecInfo.
     * 
     * @param m_listInvcRecDtlList
     */
    public void setM_listInvcRecDtlList(ObIdl_MAccCommonSAccInvcRecDtl[] m_listInvcRecDtlList) {
        this.m_listInvcRecDtlList = m_listInvcRecDtlList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObIdl_MAccCommonSAccInvcRecInfo)) return false;
        ObIdl_MAccCommonSAccInvcRecInfo other = (ObIdl_MAccCommonSAccInvcRecInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m_llInvcNumSeq==null && other.getM_llInvcNumSeq()==null) || 
             (this.m_llInvcNumSeq!=null &&
              this.m_llInvcNumSeq.equals(other.getM_llInvcNumSeq()))) &&
            ((this.m_nInvcType==null && other.getM_nInvcType()==null) || 
             (this.m_nInvcType!=null &&
              this.m_nInvcType.equals(other.getM_nInvcType()))) &&
            ((this.m_strInvcTypeDesc==null && other.getM_strInvcTypeDesc()==null) || 
             (this.m_strInvcTypeDesc!=null &&
              this.m_strInvcTypeDesc.equals(other.getM_strInvcTypeDesc()))) &&
            ((this.m_iBusiType==null && other.getM_iBusiType()==null) || 
             (this.m_iBusiType!=null &&
              this.m_iBusiType.equals(other.getM_iBusiType()))) &&
            ((this.m_strBusiTypeName==null && other.getM_strBusiTypeName()==null) || 
             (this.m_strBusiTypeName!=null &&
              this.m_strBusiTypeName.equals(other.getM_strBusiTypeName()))) &&
            ((this.m_iReceiptType==null && other.getM_iReceiptType()==null) || 
             (this.m_iReceiptType!=null &&
              this.m_iReceiptType.equals(other.getM_iReceiptType()))) &&
            ((this.m_strReceiptTypeName==null && other.getM_strReceiptTypeName()==null) || 
             (this.m_strReceiptTypeName!=null &&
              this.m_strReceiptTypeName.equals(other.getM_strReceiptTypeName()))) &&
            ((this.m_llInvcFee==null && other.getM_llInvcFee()==null) || 
             (this.m_llInvcFee!=null &&
              this.m_llInvcFee.equals(other.getM_llInvcFee()))) &&
            ((this.m_strRemark==null && other.getM_strRemark()==null) || 
             (this.m_strRemark!=null &&
              this.m_strRemark.equals(other.getM_strRemark()))) &&
            ((this.m_iOpId==null && other.getM_iOpId()==null) || 
             (this.m_iOpId!=null &&
              this.m_iOpId.equals(other.getM_iOpId()))) &&
            ((this.m_strCrmOpId==null && other.getM_strCrmOpId()==null) || 
             (this.m_strCrmOpId!=null &&
              this.m_strCrmOpId.equals(other.getM_strCrmOpId()))) &&
            ((this.m_dtmCreateTime==null && other.getM_dtmCreateTime()==null) || 
             (this.m_dtmCreateTime!=null &&
              this.m_dtmCreateTime.equals(other.getM_dtmCreateTime()))) &&
            ((this.m_nSts==null && other.getM_nSts()==null) || 
             (this.m_nSts!=null &&
              this.m_nSts.equals(other.getM_nSts()))) &&
            ((this.m_strCheckNbr==null && other.getM_strCheckNbr()==null) || 
             (this.m_strCheckNbr!=null &&
              this.m_strCheckNbr.equals(other.getM_strCheckNbr()))) &&
            ((this.m_strCustName==null && other.getM_strCustName()==null) || 
             (this.m_strCustName!=null &&
              this.m_strCustName.equals(other.getM_strCustName()))) &&
            ((this.m_iPrintCount==null && other.getM_iPrintCount()==null) || 
             (this.m_iPrintCount!=null &&
              this.m_iPrintCount.equals(other.getM_iPrintCount()))) &&
            ((this.m_nTaxFormat==null && other.getM_nTaxFormat()==null) || 
             (this.m_nTaxFormat!=null &&
              this.m_nTaxFormat.equals(other.getM_nTaxFormat()))) &&
            ((this.m_strFlag==null && other.getM_strFlag()==null) || 
             (this.m_strFlag!=null &&
              this.m_strFlag.equals(other.getM_strFlag()))) &&
            ((this.m_strInvcNum==null && other.getM_strInvcNum()==null) || 
             (this.m_strInvcNum!=null &&
              this.m_strInvcNum.equals(other.getM_strInvcNum()))) &&
            ((this.m_listInvcRecDtlList==null && other.getM_listInvcRecDtlList()==null) || 
             (this.m_listInvcRecDtlList!=null &&
              java.util.Arrays.equals(this.m_listInvcRecDtlList, other.getM_listInvcRecDtlList())));
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
        if (getM_llInvcNumSeq() != null) {
            _hashCode += getM_llInvcNumSeq().hashCode();
        }
        if (getM_nInvcType() != null) {
            _hashCode += getM_nInvcType().hashCode();
        }
        if (getM_strInvcTypeDesc() != null) {
            _hashCode += getM_strInvcTypeDesc().hashCode();
        }
        if (getM_iBusiType() != null) {
            _hashCode += getM_iBusiType().hashCode();
        }
        if (getM_strBusiTypeName() != null) {
            _hashCode += getM_strBusiTypeName().hashCode();
        }
        if (getM_iReceiptType() != null) {
            _hashCode += getM_iReceiptType().hashCode();
        }
        if (getM_strReceiptTypeName() != null) {
            _hashCode += getM_strReceiptTypeName().hashCode();
        }
        if (getM_llInvcFee() != null) {
            _hashCode += getM_llInvcFee().hashCode();
        }
        if (getM_strRemark() != null) {
            _hashCode += getM_strRemark().hashCode();
        }
        if (getM_iOpId() != null) {
            _hashCode += getM_iOpId().hashCode();
        }
        if (getM_strCrmOpId() != null) {
            _hashCode += getM_strCrmOpId().hashCode();
        }
        if (getM_dtmCreateTime() != null) {
            _hashCode += getM_dtmCreateTime().hashCode();
        }
        if (getM_nSts() != null) {
            _hashCode += getM_nSts().hashCode();
        }
        if (getM_strCheckNbr() != null) {
            _hashCode += getM_strCheckNbr().hashCode();
        }
        if (getM_strCustName() != null) {
            _hashCode += getM_strCustName().hashCode();
        }
        if (getM_iPrintCount() != null) {
            _hashCode += getM_iPrintCount().hashCode();
        }
        if (getM_nTaxFormat() != null) {
            _hashCode += getM_nTaxFormat().hashCode();
        }
        if (getM_strFlag() != null) {
            _hashCode += getM_strFlag().hashCode();
        }
        if (getM_strInvcNum() != null) {
            _hashCode += getM_strInvcNum().hashCode();
        }
        if (getM_listInvcRecDtlList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getM_listInvcRecDtlList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getM_listInvcRecDtlList(), i);
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
        new org.apache.axis.description.TypeDesc(ObIdl_MAccCommonSAccInvcRecInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvcNumSeq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvcNumSeq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nInvcType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nInvcType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strInvcTypeDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strInvcTypeDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iBusiType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iBusiType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strBusiTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strBusiTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iReceiptType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iReceiptType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strReceiptTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strReceiptTypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_llInvcFee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_llInvcFee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strRemark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strRemark"));
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
        elemField.setFieldName("m_strCrmOpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCrmOpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_dtmCreateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_dtmCreateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nSts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nSts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
        elemField.setFieldName("m_strCustName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strCustName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_iPrintCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_iPrintCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_nTaxFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_nTaxFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_strInvcNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_strInvcNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_listInvcRecDtlList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m_listInvcRecDtlList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://AccPayFee/", "ObIdl_MAccCommon.SAccInvcRecDtl"));
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
