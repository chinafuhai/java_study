//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.20 at 07:48:03 ���� GMT 
//


package com.asiainfo.boss4.domain.ext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BeginDate_QNAME = new QName("", "beginDate");
    private final static QName _CheckNo_QNAME = new QName("", "checkNo");
    private final static QName _ReceiptTransactionId_QNAME = new QName("", "receiptTransactionId");
    private final static QName _CrmFeeId_QNAME = new QName("", "crmFeeId");
    private final static QName _ItemMemo_QNAME = new QName("", "itemMemo");
    private final static QName _Code_QNAME = new QName("", "code");
    private final static QName _BankCardNbr_QNAME = new QName("", "bankCardNbr");
    private final static QName _Brand_QNAME = new QName("", "brand");
    private final static QName _OrgId_QNAME = new QName("", "orgId");
    private final static QName _ResourceNumber_QNAME = new QName("", "resourceNumber");
    private final static QName _PaymentType_QNAME = new QName("", "paymentType");
    private final static QName _PaymentFlag_QNAME = new QName("", "paymentFlag");
    private final static QName _ExtCustomerId_QNAME = new QName("", "extCustomerId");
    private final static QName _PaymentMethod_QNAME = new QName("", "paymentMethod");
    private final static QName _BankCardName_QNAME = new QName("", "bankCardName");
    private final static QName _Price_QNAME = new QName("", "price");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Quantity_QNAME = new QName("", "quantity");
    private final static QName _OpId_QNAME = new QName("", "opId");
    private final static QName _Month_QNAME = new QName("", "month");
    private final static QName _Memo_QNAME = new QName("", "memo");
    private final static QName _CrmSapInstanceId_QNAME = new QName("", "crmSapInstanceId");
    private final static QName _AcctId_QNAME = new QName("", "acctId");
    private final static QName _DevNumber_QNAME = new QName("", "devNumber");
    private final static QName _BankCode_QNAME = new QName("", "bankCode");
    private final static QName _Amount_QNAME = new QName("", "amount");
    private final static QName _AccountId_QNAME = new QName("", "accountId");
    private final static QName _CustomerName_QNAME = new QName("", "customerName");
    private final static QName _PayChannel_QNAME = new QName("", "payChannel");
    private final static QName _EndDate_QNAME = new QName("", "endDate");
    private final static QName _PaymentTransactionId_QNAME = new QName("", "paymentTransactionId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiptServInfo }
     * 
     */
    public ReceiptServInfo createReceiptServInfo() {
        return new ReceiptServInfo();
    }

    /**
     * Create an instance of {@link RefundList }
     * 
     */
    public RefundList createRefundList() {
        return new RefundList();
    }

    /**
     * Create an instance of {@link SegmentPayMethod }
     * 
     */
    public SegmentPayMethod createSegmentPayMethod() {
        return new SegmentPayMethod();
    }

    /**
     * Create an instance of {@link ReceiptItemList }
     * 
     */
    public ReceiptItemList createReceiptItemList() {
        return new ReceiptItemList();
    }

    /**
     * Create an instance of {@link OneTimePaymentItemList }
     * 
     */
    public OneTimePaymentItemList createOneTimePaymentItemList() {
        return new OneTimePaymentItemList();
    }

    /**
     * Create an instance of {@link BusinessReceipt }
     * 
     */
    public BusinessReceipt createBusinessReceipt() {
        return new BusinessReceipt();
    }

    /**
     * Create an instance of {@link UpdateList }
     * 
     */
    public UpdateList createUpdateList() {
        return new UpdateList();
    }

    /**
     * Create an instance of {@link ReceiptItem }
     * 
     */
    public ReceiptItem createReceiptItem() {
        return new ReceiptItem();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link PaymentList }
     * 
     */
    public PaymentList createPaymentList() {
        return new PaymentList();
    }

    /**
     * Create an instance of {@link OneTimePayment }
     * 
     */
    public OneTimePayment createOneTimePayment() {
        return new OneTimePayment();
    }

    /**
     * Create an instance of {@link SegmentFund }
     * 
     */
    public SegmentFund createSegmentFund() {
        return new SegmentFund();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "beginDate")
    public JAXBElement<String> createBeginDate(String value) {
        return new JAXBElement<String>(_BeginDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "checkNo")
    public JAXBElement<String> createCheckNo(String value) {
        return new JAXBElement<String>(_CheckNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "receiptTransactionId")
    public JAXBElement<String> createReceiptTransactionId(String value) {
        return new JAXBElement<String>(_ReceiptTransactionId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "crmFeeId")
    public JAXBElement<Short> createCrmFeeId(Short value) {
        return new JAXBElement<Short>(_CrmFeeId_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "itemMemo")
    public JAXBElement<String> createItemMemo(String value) {
        return new JAXBElement<String>(_ItemMemo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bankCardNbr")
    public JAXBElement<String> createBankCardNbr(String value) {
        return new JAXBElement<String>(_BankCardNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "brand")
    public JAXBElement<String> createBrand(String value) {
        return new JAXBElement<String>(_Brand_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orgId")
    public JAXBElement<Short> createOrgId(Short value) {
        return new JAXBElement<Short>(_OrgId_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resourceNumber")
    public JAXBElement<String> createResourceNumber(String value) {
        return new JAXBElement<String>(_ResourceNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "paymentType")
    public JAXBElement<String> createPaymentType(String value) {
        return new JAXBElement<String>(_PaymentType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "paymentFlag")
    public JAXBElement<String> createPaymentFlag(String value) {
        return new JAXBElement<String>(_PaymentFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "extCustomerId")
    public JAXBElement<String> createExtCustomerId(String value) {
        return new JAXBElement<String>(_ExtCustomerId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "paymentMethod")
    public JAXBElement<String> createPaymentMethod(String value) {
        return new JAXBElement<String>(_PaymentMethod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bankCardName")
    public JAXBElement<String> createBankCardName(String value) {
        return new JAXBElement<String>(_BankCardName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "price")
    public JAXBElement<String> createPrice(String value) {
        return new JAXBElement<String>(_Price_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "quantity")
    public JAXBElement<String> createQuantity(String value) {
        return new JAXBElement<String>(_Quantity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "opId")
    public JAXBElement<String> createOpId(String value) {
        return new JAXBElement<String>(_OpId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "month")
    public JAXBElement<String> createMonth(String value) {
        return new JAXBElement<String>(_Month_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "memo")
    public JAXBElement<String> createMemo(String value) {
        return new JAXBElement<String>(_Memo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "crmSapInstanceId")
    public JAXBElement<String> createCrmSapInstanceId(String value) {
        return new JAXBElement<String>(_CrmSapInstanceId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "acctId")
    public JAXBElement<Long> createAcctId(Long value) {
        return new JAXBElement<Long>(_AcctId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "devNumber")
    public JAXBElement<String> createDevNumber(String value) {
        return new JAXBElement<String>(_DevNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bankCode")
    public JAXBElement<String> createBankCode(String value) {
        return new JAXBElement<String>(_BankCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "amount")
    public JAXBElement<String> createAmount(String value) {
        return new JAXBElement<String>(_Amount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "accountId")
    public JAXBElement<String> createAccountId(String value) {
        return new JAXBElement<String>(_AccountId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "customerName")
    public JAXBElement<String> createCustomerName(String value) {
        return new JAXBElement<String>(_CustomerName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "payChannel")
    public JAXBElement<String> createPayChannel(String value) {
        return new JAXBElement<String>(_PayChannel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "endDate")
    public JAXBElement<String> createEndDate(String value) {
        return new JAXBElement<String>(_EndDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "paymentTransactionId")
    public JAXBElement<String> createPaymentTransactionId(String value) {
        return new JAXBElement<String>(_PaymentTransactionId_QNAME, String.class, null, value);
    }

}
