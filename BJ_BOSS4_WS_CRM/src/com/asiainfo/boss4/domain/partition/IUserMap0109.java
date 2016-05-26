package com.asiainfo.boss4.domain.partition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;


/**
 * IUserMap0109 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_MAP_0109", schema = "ZG")
@IdClass(IUserMap0109.IUserMap0109Id.class)

public class IUserMap0109 extends BaseEntity implements java.io.Serializable {

        // Fields
        private String imsi;
        private String msisdn;
        private String imsi2;
        private String msisdn2;
        private Date validDate;
        private Date expireDate;
        private Long sid;
        private Long soNbr;
        private String remark;
        private Long servId;
        private Short busiType;
        private Short regionCode;
        
        /** default constructor */
        public IUserMap0109() {
        }

        /** minimal constructor */
        public IUserMap0109(String imsi, String msisdn, String imsi2, String msisdn2,
                        Date validDate, Date expireDate,Long sid,Long soNbr, Long servId) {
                this.imsi = imsi;
                this.msisdn = msisdn;
                this.imsi2 = imsi2;
                this.msisdn2 = msisdn2;
                this.validDate = validDate;
                this.expireDate = expireDate;
                this.sid = sid;
                this.soNbr = soNbr;
                this.servId = servId;
        }

        /** full constructor */
        public IUserMap0109(String imsi, String msisdn, String imsi2, String msisdn2,
                        Date validDate, Date expireDate,Long sid,Long soNbr, String remark,
                        Long servId,Short busiType,Short regionCode) {
                this.imsi = imsi;
                this.msisdn = msisdn;
                this.imsi2 = imsi2;
                this.msisdn2 = msisdn2;
                this.validDate = validDate;
                this.expireDate = expireDate;
                this.sid = sid;
                this.soNbr = soNbr;
                this.remark = remark;
                this.servId = servId;
                this.busiType = busiType;
                this.regionCode = regionCode;
        }

        // Property accessors
        @Column(name = "IMSI", nullable = false, length = 50)
        public String getImsi() {
                return imsi;
        }

        public void setImsi(String imsi) {
                this.imsi = imsi;
        }
        
        @Column(name = "MSISDN", nullable = false, length = 50)
        public String getMsisdn() {
                return msisdn;
        }

        public void setMsisdn(String msisdn) {
                this.msisdn = msisdn;
        }
        
        @Column(name = "IMSI2", nullable = false, length = 50)
        public String getImsi2() {
                return imsi2;
        }

        public void setImsi2(String imsi2) {
                this.imsi2 = imsi2;
        }
        
        @Column(name = "MSISDN2", nullable = false, length = 50)
        public String getMsisdn2() {
                return msisdn2;
        }

        public void setMsisdn2(String msisdn2) {
                this.msisdn2 = msisdn2;
        }
        
        @Id
        public Date getValidDate() {
                return validDate;
        }

        public void setValidDate(Date validDate) {
                this.validDate = validDate;
        }
        
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "EXPIRE_DATE", nullable = false, length = 7)
        public Date getExpireDate() {
                return this.expireDate;
        }

        public void setExpireDate(Date expireDate) {
                this.expireDate = expireDate;
        }
        
        @Id
        public Long getSid() {
                return sid;
        }

        public void setSid(Long sid) {
                this.sid = sid;
        }
        
        @Id
        public Long getSoNbr() {
                return this.soNbr;
        }

        public void setSoNbr(Long soNbr) {
                this.soNbr = soNbr;
        }
        
        @Column(name = "REMARK")
        public String getRemark() {
                return remark;
        }

        public void setRemark(String remark) {
                this.remark = remark;
        }
        
        @Id
        public Long getServId() {
                return servId;
        }

        public void setServId(Long servId) {
                this.servId = servId;
        }
        
        @Column(name = "BUSI_TYPE", precision = 4, scale = 0)
        public Short getBusiType() {
                return this.busiType;
        }

        public void setBusiType(Short busiType) {
                this.busiType = busiType;
        }
        
        @Column(name = "REGION_CODE", precision = 4, scale = 0)
        public Short getRegionCode() {
                return this.regionCode;
        }

        public void setRegionCode(Short regionCode) {
                this.regionCode = regionCode;
        }
        
        @Override
        public String toString() {
        return new ToStringBuilder(this)
            .append("imsi", getImsi())
            .append("msisdn", getMsisdn())
            .append("imsi2", getImsi2())
            .append("msisdn2",getMsisdn2())
            .append("validDate",getValidDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("servId",getServId())
            .append("busiType",getBusiType())
            .append("regionCode",getRegionCode())
            .toString();
    }
        
        public static class IUserMap0109Id implements java.io.Serializable {
                // Fields

                private Long servId;
                private Date validDate;
                private Long sid;
                private Long soNbr;

                // Constructors

                /** default constructor */
                public IUserMap0109Id() {
                }

                /** full constructor */
                public IUserMap0109Id(Long servId, Date validDate, Long sid, Long soNbr) {
                        this.servId = servId;
                        this.validDate = validDate;
                        this.sid = sid;
                        this.soNbr = soNbr;
                }

                // Property accessors

                @Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
                public Long getServId() {
                        return this.servId;
                }

                public void setServId(Long servId) {
                        this.servId = servId;
                }

                @Temporal(TemporalType.TIMESTAMP)
                @Column(name = "VALID_DATE", nullable = false, length = 7)
                public Date getValidDate() {
                        return this.validDate;
                }

                public void setValidDate(Date validDate) {
                        this.validDate = validDate;
                }

                @Column(name = "SID", nullable = false, precision = 12, scale = 0)
                public Long getSid() {
                        return this.sid;
                }

                public void setSid(Long sid) {
                        this.sid = sid;
                }

                @Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
                public Long getSoNbr() {
                        return this.soNbr;
                }

                public void setSoNbr(Long soNbr) {
                        this.soNbr = soNbr;
                }

                @Override
                public boolean equals(Object other) {
                        if (!(other instanceof IUserMap0109Id))
                                return false;
                        IUserMap0109Id castOther = (IUserMap0109Id) other;
                        return new EqualsBuilder().append(this.getServId(),
                                        castOther.getServId()).append(this.getValidDate(),
                                        castOther.getValidDate()).append(this.getSid(),
                                        castOther.getSid()).append(this.getSoNbr(),
                                        castOther.getSoNbr()).isEquals();
                }

                @Override
                public int hashCode() {
                        return new HashCodeBuilder().append(getServId()).append(getValidDate())
                                        .append(getSid()).append(getSoNbr()).toHashCode();
                }
        }
}