package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * CmTaxpayerInfo entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CM_TAXPAYER_INFO", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "taxId" }, fieldOfDBSelectConditions = { "tax_id" },  isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class CmTaxpayerInfo extends BaseEntity implements java.io.Serializable {

        // Fields

        private Long taxId;
        private String busiLicenseNum;
        private String nationalTaxNum;
        private String enterpriseName;
        private String addTaxVinNum;
        private String address;
        private String contactPhone;
        private String paymentAccountName;
        private String paymentAccount;
        private Byte isInvoiceNeed;
        private Byte invoiceType;
        private String contactPerson;
        private Byte property;
        private String exitPicTaxfSec;
        private Byte exitPicTaxf;
        private String exitPicApplySec;
        private String exitPicAddTaxSec;
        private Byte exitPicApply;
        private Byte exitPicAddTax;
        private String exitPicLicenseSec;
        private Byte exitPicLicense;
        private String exitPicOthSec;
        private Byte exitPicOth;
        private Byte taxState;
        private Date intellEffectiveDate;
        private Date intellExpireDate;
        private Byte taxWork;
        private String state;
        private Long firstCheckId;
        private Long sedCheckGroup;
        private Long startOpId;
        private Long createOpId;
        private Long createOrgId;
        private Long opId;
        private Long orgId;
        private Long doneCode;
        private Date createDate;
        private Date doneDate;
        private Date effectiveDate;
        private Date expireDate;
        private String regionId;
        private String remarks;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;
        private String agentContactPhone;
        private String remindPhone;
        private Date motDate;
        private Date metEffectiveDate; 
        private Date metExpireDate;
        private String thirdPartyName;
        private String exitThirdPartySeq;
        private Byte exitThirdParty;
        private Long contactTaxId;
        private Byte picAddress;
        private String picAddressSeq;
        private Byte picBank;
        private String picBankSeq;

        // Constructors

        /** default constructor */
        public CmTaxpayerInfo() {
        }

        /** minimal constructor */
        public CmTaxpayerInfo(Long taxId) {
                this.taxId = taxId;
        }

        /** full constructor */
        public CmTaxpayerInfo(Long taxId, String busiLicenseNum,
                        String nationalTaxNum, String enterpriseName, String addTaxVinNum,
                        String address, String contactPhone, String paymentAccountName,
                        String paymentAccount, Byte isInvoiceNeed, Byte invoiceType,
                        String contactPerson, Byte property, String exitPicTaxfSec,
                        Byte exitPicTaxf, String exitPicApplySec, String exitPicAddTaxSec,
                        Byte exitPicApply, Byte exitPicAddTax, String exitPicLicenseSec,
                        Byte exitPicLicense, String exitPicOthSec, Byte exitPicOth,
                        Byte taxState, Date intellEffectiveDate, Date intellExpireDate,
                        Byte taxWork, String state, Long firstCheckId, Long sedCheckGroup,
                        Long startOpId, Long createOpId, Long createOrgId, Long opId,
                        Long orgId, Long doneCode, Date createDate, Date doneDate,
                        Date effectiveDate, Date expireDate, String regionId,
                        String remarks, String ext1, String ext2, String ext3, String ext4,
                        String ext5,String ext6,String agentContactPhone,String remindPhone,
                        Date motDate,Date metEffectiveDate,Date metExpireDate,
                        String thirdPartyName,String exitThirdPartySeq,Byte exitThirdParty,
                        Long contactTaxId,Byte picAddress,String picAddressSeq,Byte picBank,
                        String picBankSeq) {
                this.taxId = taxId;
                this.busiLicenseNum = busiLicenseNum;
                this.nationalTaxNum = nationalTaxNum;
                this.enterpriseName = enterpriseName;
                this.addTaxVinNum = addTaxVinNum;
                this.address = address;
                this.contactPhone = contactPhone;
                this.paymentAccountName = paymentAccountName;
                this.paymentAccount = paymentAccount;
                this.isInvoiceNeed = isInvoiceNeed;
                this.invoiceType = invoiceType;
                this.contactPerson = contactPerson;
                this.property = property;
                this.exitPicTaxfSec = exitPicTaxfSec;
                this.exitPicTaxf = exitPicTaxf;
                this.exitPicApplySec = exitPicApplySec;
                this.exitPicAddTaxSec = exitPicAddTaxSec;
                this.exitPicApply = exitPicApply;
                this.exitPicAddTax = exitPicAddTax;
                this.exitPicLicenseSec = exitPicLicenseSec;
                this.exitPicLicense = exitPicLicense;
                this.exitPicOthSec = exitPicOthSec;
                this.exitPicOth = exitPicOth;
                this.taxState = taxState;
                this.intellEffectiveDate = intellEffectiveDate;
                this.intellExpireDate = intellExpireDate;
                this.taxWork = taxWork;
                this.state = state;
                this.firstCheckId = firstCheckId;
                this.sedCheckGroup = sedCheckGroup;
                this.startOpId = startOpId;
                this.createOpId = createOpId;
                this.createOrgId = createOrgId;
                this.opId = opId;
                this.orgId = orgId;
                this.doneCode = doneCode;
                this.createDate = createDate;
                this.doneDate = doneDate;
                this.effectiveDate = effectiveDate;
                this.expireDate = expireDate;
                this.regionId = regionId;
                this.remarks = remarks;
                this.ext1 = ext1;
                this.ext2 = ext2;
                this.ext3 = ext3;
                this.ext4 = ext4;
                this.ext5 = ext5;
                this.ext6 = ext6;
                this.agentContactPhone = agentContactPhone;
                this.remindPhone = remindPhone;
                this.motDate =  motDate;
                this.metEffectiveDate = metEffectiveDate;
                this.metExpireDate =  metExpireDate;
                this.thirdPartyName = thirdPartyName;
                this.exitThirdPartySeq = exitThirdPartySeq;
                this.exitThirdParty = exitThirdParty;
                this.contactTaxId = contactTaxId;
                this.picAddress = picAddress;
                this.picAddressSeq = picAddressSeq;
                this.picBank = picBank;
                this.picBankSeq = picBankSeq;
        }

        // Property accessors
        @Id
        @Column(name = "TAX_ID", unique = true, nullable = false, precision = 14, scale = 0)
        public Long getTaxId() {
                return this.taxId;
        }

        public void setTaxId(Long taxId) {
                this.taxId = taxId;
        }

        @Column(name = "BUSI_LICENSE_NUM", length = 50)
        public String getBusiLicenseNum() {
                return this.busiLicenseNum;
        }

        public void setBusiLicenseNum(String busiLicenseNum) {
                this.busiLicenseNum = busiLicenseNum;
        }

        @Column(name = "NATIONAL_TAX_NUM", length = 50)
        public String getNationalTaxNum() {
                return this.nationalTaxNum;
        }

        public void setNationalTaxNum(String nationalTaxNum) {
                this.nationalTaxNum = nationalTaxNum;
        }

        @Column(name = "ENTERPRISE_NAME")
        public String getEnterpriseName() {
                return this.enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
                this.enterpriseName = enterpriseName;
        }

        @Column(name = "ADD_TAX_VIN_NUM", length = 50)
        public String getAddTaxVinNum() {
                return this.addTaxVinNum;
        }

        public void setAddTaxVinNum(String addTaxVinNum) {
                this.addTaxVinNum = addTaxVinNum;
        }

        @Column(name = "ADDRESS")
        public String getAddress() {
                return this.address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        @Column(name = "CONTACT_PHONE", length = 50)
        public String getContactPhone() {
                return this.contactPhone;
        }

        public void setContactPhone(String contactPhone) {
                this.contactPhone = contactPhone;
        }

        @Column(name = "PAYMENT_ACCOUNT_NAME", length = 256)
        public String getPaymentAccountName() {
                return this.paymentAccountName;
        }

        public void setPaymentAccountName(String paymentAccountName) {
                this.paymentAccountName = paymentAccountName;
        }

        @Column(name = "PAYMENT_ACCOUNT", length = 256)
        public String getPaymentAccount() {
                return this.paymentAccount;
        }

        public void setPaymentAccount(String paymentAccount) {
                this.paymentAccount = paymentAccount;
        }

        @Column(name = "IS_INVOICE_NEED", precision = 2, scale = 0)
        public Byte getIsInvoiceNeed() {
                return this.isInvoiceNeed;
        }

        public void setIsInvoiceNeed(Byte isInvoiceNeed) {
                this.isInvoiceNeed = isInvoiceNeed;
        }

        @Column(name = "INVOICE_TYPE", precision = 2, scale = 0)
        public Byte getInvoiceType() {
                return this.invoiceType;
        }

        public void setInvoiceType(Byte invoiceType) {
                this.invoiceType = invoiceType;
        }

        @Column(name = "CONTACT_PERSON", length = 256)
        public String getContactPerson() {
                return this.contactPerson;
        }

        public void setContactPerson(String contactPerson) {
                this.contactPerson = contactPerson;
        }

        @Column(name = "PROPERTY", precision = 2, scale = 0)
        public Byte getProperty() {
                return this.property;
        }

        public void setProperty(Byte property) {
                this.property = property;
        }

        @Column(name = "EXIT_PIC_TAXF_SEC", length = 50)
        public String getExitPicTaxfSec() {
                return this.exitPicTaxfSec;
        }

        public void setExitPicTaxfSec(String exitPicTaxfSec) {
                this.exitPicTaxfSec = exitPicTaxfSec;
        }

        @Column(name = "EXIT_PIC_TAXF", precision = 2, scale = 0)
        public Byte getExitPicTaxf() {
                return this.exitPicTaxf;
        }

        public void setExitPicTaxf(Byte exitPicTaxf) {
                this.exitPicTaxf = exitPicTaxf;
        }

        @Column(name = "EXIT_PIC_APPLY_SEC", length = 50)
        public String getExitPicApplySec() {
                return this.exitPicApplySec;
        }

        public void setExitPicApplySec(String exitPicApplySec) {
                this.exitPicApplySec = exitPicApplySec;
        }

        @Column(name = "EXIT_PIC_ADD_TAX_SEC", length = 50)
        public String getExitPicAddTaxSec() {
                return this.exitPicAddTaxSec;
        }

        public void setExitPicAddTaxSec(String exitPicAddTaxSec) {
                this.exitPicAddTaxSec = exitPicAddTaxSec;
        }

        @Column(name = "EXIT_PIC_APPLY", precision = 2, scale = 0)
        public Byte getExitPicApply() {
                return this.exitPicApply;
        }

        public void setExitPicApply(Byte exitPicApply) {
                this.exitPicApply = exitPicApply;
        }

        @Column(name = "EXIT_PIC_ADD_TAX", precision = 2, scale = 0)
        public Byte getExitPicAddTax() {
                return this.exitPicAddTax;
        }

        public void setExitPicAddTax(Byte exitPicAddTax) {
                this.exitPicAddTax = exitPicAddTax;
        }

        @Column(name = "EXIT_PIC_LICENSE_SEC", length = 50)
        public String getExitPicLicenseSec() {
                return this.exitPicLicenseSec;
        }

        public void setExitPicLicenseSec(String exitPicLicenseSec) {
                this.exitPicLicenseSec = exitPicLicenseSec;
        }

        @Column(name = "EXIT_PIC_LICENSE", precision = 2, scale = 0)
        public Byte getExitPicLicense() {
                return this.exitPicLicense;
        }

        public void setExitPicLicense(Byte exitPicLicense) {
                this.exitPicLicense = exitPicLicense;
        }

        @Column(name = "EXIT_PIC_OTH_SEC", length = 50)
        public String getExitPicOthSec() {
                return this.exitPicOthSec;
        }

        public void setExitPicOthSec(String exitPicOthSec) {
                this.exitPicOthSec = exitPicOthSec;
        }

        @Column(name = "EXIT_PIC_OTH", precision = 2, scale = 0)
        public Byte getExitPicOth() {
                return this.exitPicOth;
        }

        public void setExitPicOth(Byte exitPicOth) {
                this.exitPicOth = exitPicOth;
        }

        @Column(name = "TAX_STATE", precision = 2, scale = 0)
        public Byte getTaxState() {
                return this.taxState;
        }

        public void setTaxState(Byte taxState) {
                this.taxState = taxState;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "INTELL_EFFECTIVE_DATE", length = 7)
        public Date getIntellEffectiveDate() {
                return this.intellEffectiveDate;
        }

        public void setIntellEffectiveDate(Date intellEffectiveDate) {
                this.intellEffectiveDate = intellEffectiveDate;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "INTELL_EXPIRE_DATE", length = 7)
        public Date getIntellExpireDate() {
                return this.intellExpireDate;
        }

        public void setIntellExpireDate(Date intellExpireDate) {
                this.intellExpireDate = intellExpireDate;
        }

        @Column(name = "TAX_WORK", precision = 2, scale = 0)
        public Byte getTaxWork() {
                return this.taxWork;
        }

        public void setTaxWork(Byte taxWork) {
                this.taxWork = taxWork;
        }

        @Column(name = "STATE", length = 3)
        public String getState() {
                return this.state;
        }

        public void setState(String state) {
                this.state = state;
        }

        @Column(name = "FIRST_CHECK_ID", precision = 12, scale = 0)
        public Long getFirstCheckId() {
                return this.firstCheckId;
        }

        public void setFirstCheckId(Long firstCheckId) {
                this.firstCheckId = firstCheckId;
        }

        @Column(name = "SED_CHECK_GROUP", precision = 12, scale = 0)
        public Long getSedCheckGroup() {
                return this.sedCheckGroup;
        }

        public void setSedCheckGroup(Long sedCheckGroup) {
                this.sedCheckGroup = sedCheckGroup;
        }

        @Column(name = "START_OP_ID", precision = 12, scale = 0)
        public Long getStartOpId() {
                return this.startOpId;
        }

        public void setStartOpId(Long startOpId) {
                this.startOpId = startOpId;
        }

        @Column(name = "CREATE_OP_ID", precision = 12, scale = 0)
        public Long getCreateOpId() {
                return this.createOpId;
        }

        public void setCreateOpId(Long createOpId) {
                this.createOpId = createOpId;
        }

        @Column(name = "CREATE_ORG_ID", precision = 12, scale = 0)
        public Long getCreateOrgId() {
                return this.createOrgId;
        }

        public void setCreateOrgId(Long createOrgId) {
                this.createOrgId = createOrgId;
        }

        @Column(name = "OP_ID", precision = 12, scale = 0)
        public Long getOpId() {
                return this.opId;
        }

        public void setOpId(Long opId) {
                this.opId = opId;
        }

        @Column(name = "ORG_ID", precision = 12, scale = 0)
        public Long getOrgId() {
                return this.orgId;
        }

        public void setOrgId(Long orgId) {
                this.orgId = orgId;
        }

        @Column(name = "DONE_CODE", precision = 14, scale = 0)
        public Long getDoneCode() {
                return this.doneCode;
        }

        public void setDoneCode(Long doneCode) {
                this.doneCode = doneCode;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CREATE_DATE", length = 7)
        public Date getCreateDate() {
                return this.createDate;
        }

        public void setCreateDate(Date createDate) {
                this.createDate = createDate;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "DONE_DATE", length = 7)
        public Date getDoneDate() {
                return this.doneDate;
        }

        public void setDoneDate(Date doneDate) {
                this.doneDate = doneDate;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "EFFECTIVE_DATE", length = 7)
        public Date getEffectiveDate() {
                return this.effectiveDate;
        }

        public void setEffectiveDate(Date effectiveDate) {
                this.effectiveDate = effectiveDate;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "EXPIRE_DATE", length = 7)
        public Date getExpireDate() {
                return this.expireDate;
        }

        public void setExpireDate(Date expireDate) {
                this.expireDate = expireDate;
        }

        @Column(name = "REGION_ID", length = 6)
        public String getRegionId() {
                return this.regionId;
        }

        public void setRegionId(String regionId) {
                this.regionId = regionId;
        }

        @Column(name = "REMARKS")
        public String getRemarks() {
                return this.remarks;
        }

        public void setRemarks(String remarks) {
                this.remarks = remarks;
        }

        @Column(name = "EXT1")
        public String getExt1() {
                return this.ext1;
        }

        public void setExt1(String ext1) {
                this.ext1 = ext1;
        }

        @Column(name = "EXT2")
        public String getExt2() {
                return this.ext2;
        }

        public void setExt2(String ext2) {
                this.ext2 = ext2;
        }

        @Column(name = "EXT3")
        public String getExt3() {
                return this.ext3;
        }

        public void setExt3(String ext3) {
                this.ext3 = ext3;
        }

        @Column(name = "EXT4")
        public String getExt4() {
                return this.ext4;
        }

        public void setExt4(String ext4) {
                this.ext4 = ext4;
        }

        @Column(name = "EXT5")
        public String getExt5() {
                return this.ext5;
        }

        public void setExt5(String ext5) {
                this.ext5 = ext5;
        }
        
        @Column(name = "EXT6")
        public String getExt6() {
                return this.ext6;
        }

        public void setExt6(String ext6) {
                this.ext6 = ext6;
        }
        
        @Column(name = "AGENT_CONTACT_PHONE", length = 30)
        public String getAgentContactPhone() {
                return this.agentContactPhone;
        }

        public void setAgentContactPhone(String agentContactPhone) {
                this.agentContactPhone = agentContactPhone;
        }
        
        @Column(name = "REMIND_PHONE", length = 30)
        public String getRemindPhone() {
                return this.remindPhone;
        }

        public void setRemindPhone(String remindPhone) {
                this.remindPhone = remindPhone;
        }
        
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "MOT_DATE", length = 7)
        public Date getMotDate() {
                return this.motDate;
        }

        public void setMotDate(Date motDate) {
                this.motDate = motDate;
        }
        
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "MET_EFFECTIVE_DATE", length = 7)
        public Date getMetEffectiveDate() {
                return this.metEffectiveDate;
        }

        public void setMetEffectiveDate(Date metEffectiveDate) {
                this.metEffectiveDate = metEffectiveDate;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "MET_EXPIRE_DATE", length = 7)
        public Date getMetExpireDate() {
                return this.metExpireDate;
        }

        public void setMetExpireDate(Date metExpireDate) {
                this.metExpireDate = metExpireDate;
        }
        
        @Column(name = "THIRD_PARTY_NAME", length = 50)
        public String getThirdPartyName() {
                return this.thirdPartyName;
        }

        public void setThirdPartyName(String thirdPartyName) {
                this.thirdPartyName = thirdPartyName;
        }
        
        @Column(name = "EXIT_THIRD_PARTY_SEQ", length = 50)
        public String getExitThirdPartySeq() {
                return this.exitThirdPartySeq;
        }

        public void setExitThirdPartySeq(String exitThirdPartySeq) {
                this.exitThirdPartySeq = exitThirdPartySeq;
        }
        
        @Column(name = "EXIT_THIRD_PARTY", precision = 2, scale = 0)
        public Byte getExitThirdParty() {
                return this.exitThirdParty;
        }

        public void setExitThirdParty(Byte exitThirdParty) {
                this.exitThirdParty = exitThirdParty;
        }
        
        @Column(name = "CONTACT_TAX_ID", precision = 14, scale = 0)
        public Long getContactTaxId() {
                return this.contactTaxId;
        }

        public void setContactTaxId(Long contactTaxId) {
                this.contactTaxId = contactTaxId;
        }
        
        @Column(name = "PIC_ADDRESS", precision = 2, scale = 0)
        public Byte getPicAddress() {
                return this.picAddress;
        }

        public void setPicAddress(Byte picAddress) {
                this.picAddress = picAddress;
        }
        
        @Column(name = "PIC_ADDRESS_SEQ", length = 50)
        public String getPicAddressSeq() {
                return this.picAddressSeq;
        }

        public void setPicAddressSeq(String picAddressSeq) {
                this.picAddressSeq = picAddressSeq;
        }
        
        @Column(name = "PIC_BANK", precision = 2, scale = 0)
        public Byte getPicBank() {
                return this.picBank;
        }

        public void setPicBank(Byte picBank) {
                this.picBank = picBank;
        }
            
        @Column(name = "PIC_BANK_SEQ", length = 50)
        public String getPicBankSeq() {
                return this.picBankSeq;
        }

        public void setPicBankSeq(String picBankSeq) {
                this.picBankSeq = picBankSeq;
        }

        @Override
        public String toString() {
                return new ToStringBuilder(this)
                                .append("exitPicOth",getExitPicOth())
                                .append("regionId",getRegionId())
                                .append("exitPicLicense",getExitPicLicense())
                                .append("createOrgId",getCreateOrgId())
                                .append("exitPicAddTaxSec",getExitPicAddTaxSec())
                                .append("addTaxVinNum",getAddTaxVinNum())
                                .append("exitPicLicenseSec",getExitPicLicenseSec())
                                .append("firstCheckId",getFirstCheckId())
                                .append("theOperateType",getTheOperateType())
                                .append("rollBackSoNbr",getRollBackSoNbr())
                                .append("doneDate",getDoneDate())
                                .append("opId",getOpId())
                                .append("exitPicApplySec",getExitPicApplySec())
                                .append("property",getProperty())
                                .append("effectiveDate",getEffectiveDate())
                                .append("ext3",getExt3())
                                .append("exitPicAddTax",getExitPicAddTax())
                                .append("ext2",getExt2())
                                .append("doneCode",getDoneCode())
                                .append("taxState",getTaxState())
                                .append("startOpId",getStartOpId())
                                .append("nationalTaxNum",getNationalTaxNum())
                                .append("exitPicTaxf",getExitPicTaxf())
                                .append("sedCheckGroup",getSedCheckGroup())
                                .append("state",getState())
                                .append("createDate",getCreateDate())
                                .append("taxId",getTaxId())
                                .append("createOpId",getCreateOpId())
                                .append("ext1",getExt1())
                                .append("exitPicTaxfSec",getExitPicTaxfSec())
                                .append("address",getAddress())
                                .append("intellExpireDate",getIntellExpireDate())
                                .append("enterpriseName",getEnterpriseName())
                                .append("invoiceType",getInvoiceType())
                                .append("orgId",getOrgId())
                                .append("exitPicOthSec",getExitPicOthSec())
                                .append("exitPicApply",getExitPicApply())
                                .append("contactPerson",getContactPerson())
                                .append("ext4",getExt4())
                                .append("taxWork",getTaxWork())
                                .append("contactPhone",getContactPhone())
                                .append("remarks",getRemarks())
                                .append("expireDate",getExpireDate())
                                .append("ext5",getExt5())
                                .append("paymentAccount",getPaymentAccount())
                                .append("intellEffectiveDate",getIntellEffectiveDate())
                                .append("paymentAccountName",getPaymentAccountName())
                                .append("busiLicenseNum",getBusiLicenseNum())
                                .append("isInvoiceNeed",getIsInvoiceNeed())
                                .append("ext6",getExt6())
                                .append("agentContactPhone",getAgentContactPhone())
                                .append("remindPhone",getRemindPhone())
                                .append("motDate",getMotDate())
                                .append("metEffectiveDate",getMetEffectiveDate())
                                .append("metExpireDate",getMetExpireDate())
                                .append("thirdPartyName",getThirdPartyName())
                                .append("exitThirdPartySeq",getExitThirdPartySeq())
                                .append("exitThirdParty",getExitThirdParty())
                                .append("contactTaxId",getContactTaxId())
                                .append("picAddress",getPicAddress())
                                .append("picAddressSeq",getPicAddressSeq())
                                .append("picBank",getPicBank())
                                .append("picBankSeq",getPicBankSeq())
                                .toString();
        }
        
}