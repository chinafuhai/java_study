//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.20 at 07:48:03 ���� GMT 
//


package com.asiainfo.boss4.domain.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}accountId"/>
 *         &lt;element ref="{}extCustomerId"/>
 *         &lt;element ref="{}resourceNumber"/>
 *         &lt;element ref="{}memo"/>
 *         &lt;element ref="{}receiptTransactionId"/>
 *         &lt;element ref="{}payChannel"/>
 *         &lt;element ref="{}ReceiptItemList"/>
 *         &lt;element ref="{}ReceiptServInfo"/>
 *         &lt;element ref="{}SegmentPayMethod"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountId",
    "extCustomerId",
    "resourceNumber",
    "memo",
    "receiptTransactionId",
    "payChannel",
    "receiptItemList",
    "receiptServInfo",
    "segmentPayMethod"
})
@XmlRootElement(name = "BusinessReceipt")
public class BusinessReceipt {

    @XmlElement(required = true)
    protected Long accountId;
    @XmlElement(required = true)
    protected String extCustomerId;
    @XmlElement(required = true)
    protected String resourceNumber;
    @XmlElement(required = true)
    protected String memo;
    @XmlElement(required = true)
    protected String receiptTransactionId;
    @XmlElement(required = true)
    protected String payChannel;
    @XmlElement(name = "ReceiptItemList", required = true)
    protected ReceiptItemList receiptItemList;
    @XmlElement(name = "ReceiptServInfo", required = true)
    protected ReceiptServInfo receiptServInfo;
    @XmlElement(name = "SegmentPayMethod", required = true)
    protected SegmentPayMethod segmentPayMethod;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the extCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtCustomerId() {
        return extCustomerId;
    }

    /**
     * Sets the value of the extCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtCustomerId(String value) {
        this.extCustomerId = value;
    }

    /**
     * Gets the value of the resourceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceNumber() {
        return resourceNumber;
    }

    /**
     * Sets the value of the resourceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceNumber(String value) {
        this.resourceNumber = value;
    }

    /**
     * Gets the value of the memo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Sets the value of the memo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo(String value) {
        this.memo = value;
    }

    /**
     * Gets the value of the receiptTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptTransactionId() {
        return receiptTransactionId;
    }

    /**
     * Sets the value of the receiptTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptTransactionId(String value) {
        this.receiptTransactionId = value;
    }

    /**
     * Gets the value of the payChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * Sets the value of the payChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayChannel(String value) {
        this.payChannel = value;
    }

    /**
     * Gets the value of the receiptItemList property.
     * 
     * @return
     *     possible object is
     *     {@link ReceiptItemList }
     *     
     */
    public ReceiptItemList getReceiptItemList() {
        return receiptItemList;
    }

    /**
     * Sets the value of the receiptItemList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiptItemList }
     *     
     */
    public void setReceiptItemList(ReceiptItemList value) {
        this.receiptItemList = value;
    }

    /**
     * Gets the value of the receiptServInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ReceiptServInfo }
     *     
     */
    public ReceiptServInfo getReceiptServInfo() {
        return receiptServInfo;
    }

    /**
     * Sets the value of the receiptServInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiptServInfo }
     *     
     */
    public void setReceiptServInfo(ReceiptServInfo value) {
        this.receiptServInfo = value;
    }

    /**
     * Gets the value of the segmentPayMethod property.
     * 
     * @return
     *     possible object is
     *     {@link SegmentPayMethod }
     *     
     */
    public SegmentPayMethod getSegmentPayMethod() {
        return segmentPayMethod;
    }

    /**
     * Sets the value of the segmentPayMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentPayMethod }
     *     
     */
    public void setSegmentPayMethod(SegmentPayMethod value) {
        this.segmentPayMethod = value;
    }

}
