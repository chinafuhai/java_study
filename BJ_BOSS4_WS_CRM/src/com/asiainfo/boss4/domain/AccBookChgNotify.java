package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AddOnly;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;

/**
 * AccBookChgNotify entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_BOOK_CHG_NOTIFY", schema = "ZG")
@IdClass(AccBookChgNotify.AccBookChgNotifyId.class)
@PartitionNameForTable(operatedField = OperatedField.ACCT_ID)
@AddOnly
public class AccBookChgNotify extends BaseEntity implements java.io.Serializable {
        
        // Fields

        private Long soNbr;
        private Long acctId;
        private Date createDate;
        private Byte changeFlag;
        private Byte sts;
        private Short soRegionCode;
        private String soMonth;
        private Long staffId;
        private Integer busiCode;
        private Byte monitType;
        private Byte monitSource;
        private Byte changeType;
        private Short priority;
        private Long servId;
        private Long srcDoneCode;
        private Date upDate;

        // Constructors

        /** default constructor */
        public AccBookChgNotify() {
        }

        /** minimal constructor */
        public AccBookChgNotify(Long soNbr, Long acctId, Short soRegionCode,
                        String soMonth) {
                this.soNbr = soNbr;
                this.acctId = acctId;
                this.soRegionCode = soRegionCode;
                this.soMonth = soMonth;
        }

        /** full constructor */
        public AccBookChgNotify(Long soNbr, Long acctId, Date createDate,
                        Byte changeFlag, Byte sts, Short soRegionCode, String soMonth,
                        Long staffId, Integer busiCode, Byte monitType, Byte monitSource,
                        Byte changeType, Short priority, Long servId, Long srcDoneCode,
                        Date upDate) {
                this.soNbr = soNbr;
                this.acctId = acctId;
                this.createDate = createDate;
                this.changeFlag = changeFlag;
                this.sts = sts;
                this.soRegionCode = soRegionCode;
                this.soMonth = soMonth;
                this.staffId = staffId;
                this.busiCode = busiCode;
                this.monitType = monitType;
                this.monitSource = monitSource;
                this.changeType = changeType;
                this.priority = priority;
                this.servId = servId;
                this.srcDoneCode = srcDoneCode;
                this.upDate = upDate;
        }

        // Property accessors
        @Id
        public Long getSoNbr() {
                return this.soNbr;
        }

        public void setSoNbr(Long soNbr) {
                this.soNbr = soNbr;
        }

        @Id
        public Long getAcctId() {
                return this.acctId;
        }

        public void setAcctId(Long acctId) {
                this.acctId = acctId;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CREATE_DATE", length = 7)
        public Date getCreateDate() {
                return this.createDate;
        }

        public void setCreateDate(Date createDate) {
                this.createDate = createDate;
        }

        @Column(name = "CHANGE_FLAG", precision = 2, scale = 0)
        public Byte getChangeFlag() {
                return this.changeFlag;
        }

        public void setChangeFlag(Byte changeFlag) {
                this.changeFlag = changeFlag;
        }

        @Column(name = "STS", precision = 2, scale = 0)
        public Byte getSts() {
                return this.sts;
        }

        public void setSts(Byte sts) {
                this.sts = sts;
        }

        @Column(name = "SO_REGION_CODE", nullable = false, precision = 4, scale = 0)
        public Short getSoRegionCode() {
                return this.soRegionCode;
        }

        public void setSoRegionCode(Short soRegionCode) {
                this.soRegionCode = soRegionCode;
        }

        @Column(name = "SO_MONTH", nullable = false, length = 6)
        public String getSoMonth() {
                return this.soMonth;
        }

        public void setSoMonth(String soMonth) {
                this.soMonth = soMonth;
        }

        @Column(name = "STAFF_ID", precision = 14, scale = 0)
        public Long getStaffId() {
                return this.staffId;
        }

        public void setStaffId(Long staffId) {
                this.staffId = staffId;
        }

        @Column(name = "BUSI_CODE", precision = 6, scale = 0)
        public Integer getBusiCode() {
                return this.busiCode;
        }

        public void setBusiCode(Integer busiCode) {
                this.busiCode = busiCode;
        }

        @Column(name = "MONIT_TYPE", precision = 2, scale = 0)
        public Byte getMonitType() {
                return this.monitType;
        }

        public void setMonitType(Byte monitType) {
                this.monitType = monitType;
        }

        @Column(name = "MONIT_SOURCE", precision = 2, scale = 0)
        public Byte getMonitSource() {
                return this.monitSource;
        }

        public void setMonitSource(Byte monitSource) {
                this.monitSource = monitSource;
        }

        @Column(name = "CHANGE_TYPE", precision = 2, scale = 0)
        public Byte getChangeType() {
                return this.changeType;
        }

        public void setChangeType(Byte changeType) {
                this.changeType = changeType;
        }

        @Column(name = "PRIORITY", precision = 4, scale = 0)
        public Short getPriority() {
                return this.priority;
        }

        public void setPriority(Short priority) {
                this.priority = priority;
        }

        @Column(name = "SERV_ID", precision = 14, scale = 0)
        public Long getServId() {
                return this.servId;
        }

        public void setServId(Long servId) {
                this.servId = servId;
        }

        @Column(name = "SRC_DONE_CODE", precision = 15, scale = 0)
        public Long getSrcDoneCode() {
                return this.srcDoneCode;
        }

        public void setSrcDoneCode(Long srcDoneCode) {
                this.srcDoneCode = srcDoneCode;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UP_DATE", length = 7)
        public Date getUpDate() {
                return this.upDate;
        }

        public void setUpDate(Date upDate) {
                this.upDate = upDate;
        }

        @Override
        public String toString() {
                return new ToStringBuilder(this)
                .append("servId",getServId())
                .append("busiCode",getBusiCode())
                .append("changeFlag",getChangeFlag())
                .append("acctId",getAcctId())
                .append("upDate",getUpDate())
                .append("soNbr",getSoNbr())
                .append("soRegionCode",getSoRegionCode())
                .append("sts",getSts())
                .append("changeType",getChangeType())
                .append("srcDoneCode",getSrcDoneCode())
                .append("staffId",getStaffId())
                .append("monitType",getMonitType())
                .append("monitSource",getMonitSource())
                .append("createDate",getCreateDate())
                .append("priority",getPriority())
                .append("soMonth",getSoMonth())
                .toString();
        }

        public static class AccBookChgNotifyId implements java.io.Serializable {

                // Fields

                private Long soNbr;
                private Long acctId;

                // Constructors

                /** default constructor */
                public AccBookChgNotifyId() {
                }

                /** full constructor */
                public AccBookChgNotifyId(Long soNbr, Long acctId) {
                        this.soNbr = soNbr;
                        this.acctId = acctId;
                }

                // Property accessors

                @Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
                public Long getSoNbr() {
                        return this.soNbr;
                }

                public void setSoNbr(Long soNbr) {
                        this.soNbr = soNbr;
                }

                @Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
                public Long getAcctId() {
                        return this.acctId;
                }

                public void setAcctId(Long acctId) {
                        this.acctId = acctId;
                }

                @Override
                public boolean equals(Object other) {
                        if ( !(other instanceof AccBookChgNotifyId) ) return false;
                        AccBookChgNotifyId castOther = (AccBookChgNotifyId) other;
                        return new EqualsBuilder()
                                .append(this.getAcctId(), castOther.getAcctId())
                                .append(this.getSoNbr(), castOther.getSoNbr())
                                .isEquals();
                }

                @Override
                public int hashCode() {
                        return new HashCodeBuilder()
                        .append(getAcctId())
                        .append(getSoNbr())
                        .toHashCode();
                }

        }

        @Override
        public BaseEntity add(ServiceContext context) {
             //获取最终更新后的AccBookChgNotify.changeFlag
             if (context.getReadjustedChangeFlagOfAccBookChgNotify() == null) {//如果为null,则不操作AccBookChgNotify
                   return this;
             }
             this.setChangeFlag(context.getReadjustedChangeFlagOfAccBookChgNotify());

             //如果为大账户，直接上发ZG.ACC_BOOK_CHG_NOTIFY_LARGE
             if (isLargeAccount(context)) {
            	 //如果为大账户,报文changeFlag为11,12且存在正在处理的数据，上发到ZG.ACC_BOOK_CHG_NOTIFY_LARGE_INT
                 if (this.getChangeFlag()==(byte)11 || this.getChangeFlag()==(byte)12){
                	 if (isLargeCount(context)){
                         AccBookChgNotifyLargeInt largeNotifyInt = new AccBookChgNotifyLargeInt();
                         BeanCopyHelper.copyProperties(largeNotifyInt, this);
                         return largeNotifyInt.add(context);    
                     }else{
                          AccBookChgNotifyLarge largeNotify = new AccBookChgNotifyLarge();
                          BeanCopyHelper.copyProperties(largeNotify, this);
                          return largeNotify.add(context); 
                     }
                 }else{
                     AccBookChgNotifyLarge largeNotify = new AccBookChgNotifyLarge();
                     BeanCopyHelper.copyProperties(largeNotify, this);
                     return largeNotify.add(context); 
                 }
             }
             return super.add(context);
        }
        
        private boolean isLargeAccount(ServiceContext context) {
            String sql = "select 1 from zg.large_account_info where acct_id = :acctId";
            return context.getBusinessDao().getSess().createSQLQuery(sql).setLong("acctId", this.getAcctId()).list().size() > 0;
        }
        
        private boolean isLargeCount(ServiceContext context) {
            String sql = "select 1 from zg.acc_book_chg_notify_large where acct_id = :acctId and change_Flag in(11,12)";
            return context.getBusinessDao().getSess().createSQLQuery(sql).setLong("acctId", this.getAcctId()).list().size() > 0;
        }
        
}