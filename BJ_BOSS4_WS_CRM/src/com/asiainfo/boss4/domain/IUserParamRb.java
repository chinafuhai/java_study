package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.support.annotation.Backup;

/**
 * IUserParam entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PARAM_RB", schema = "INTER")
@IdClass(IUserParamRb.IUserParamRbId.class)
@Backup
public class IUserParamRb implements java.io.Serializable {

        // Fields

        private Long servId;
        private Integer keyId;
        private String userParam;
        private Short regionCode;
        private Date beginDate;
        private Date validDate;
        private Date expireDate;
        private Long sid;
        private Long soNbr;
        private String remark;
        private Long rollbackSoNbr;
        
        // Constructors

        /** default constructor */
        public IUserParamRb() {
        }

        /** minimal constructor */
        public IUserParamRb(Long servId, Date validDate, Date expireDate, Long sid,
                        Long soNbr, Long rollbackSoNbr) {
                this.servId = servId;
                this.validDate = validDate;
                this.expireDate = expireDate;
                this.soNbr = soNbr;
                this.rollbackSoNbr = rollbackSoNbr;
        }

        /** full constructor */
        public IUserParamRb(Long servId, Integer keyId,
                        String userParam,Short regionCode, Date beginDate, Date validDate,Date expireDate, 
                        Long sid, Long soNbr, String remark, Long rollbackSoNbr) {
                this.servId = servId;
                this.keyId = keyId;
                this.userParam = userParam;
                this.regionCode = regionCode;
                this.beginDate = beginDate;
                this.validDate = validDate;
                this.expireDate = expireDate;
                this.sid = sid;
                this.soNbr = soNbr;
                this.remark = remark;
                this.rollbackSoNbr = rollbackSoNbr;
        }
        
        // Property accessors
        
        @Id
        public Long getServId() {
                return servId;
        }

        public void setServId(Long servId) {
                this.servId = servId;
        }

        @Id
        public Integer getKeyId() {
                return this.keyId;
        }

        public void setKeyId(Integer keyId) {
                this.keyId = keyId;
        }

        @Column(name = "USER_PARAM", length = 32)
        public String getUserParam() {
                return this.userParam;
        }

        public void setUserParam(String userParam) {
                this.userParam = userParam;
        }
        
        @Column(name = "REGION_CODE", precision = 4, scale = 0)
        public Short getRegionCode() {
                return this.regionCode;
        }

        public void setRegionCode(Short regionCode) {
                this.regionCode = regionCode;
        }
        
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "BEGIN_DATE", nullable = false, length = 7)
        public Date getBeginDate() {
                return this.beginDate;
        }

        public void setBeginDate(Date beginDate) {
                this.beginDate = beginDate;
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

        @Column(name = "REMARK")
        public String getRemark() {
                return this.remark;
        }

        public void setRemark(String remark) {
                this.remark = remark;
        }
        
        @Column(name = "ROLLBACK_SO_NBR", nullable = false, precision = 15, scale = 0)
        public Long getRollbackSoNbr() {
                return rollbackSoNbr;
        }

        public void setRollbackSoNbr(Long rollbackSoNbr) {
                this.rollbackSoNbr = rollbackSoNbr;
        }
        
        @Override
        public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("keyId", getKeyId())
            .append("userParam",getUserParam())
            .append("regionCode",getRegionCode())
            .append("beginDate", getBeginDate())
            .append("validDate", getValidDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("rollbackSoNbr",getRollbackSoNbr())
            .toString();
        }
        
        public static class IUserParamRbId implements java.io.Serializable {

                // Fields

                private Long servId;
                private Integer keyId;
                private Date validDate;

                // Constructors

                /** default constructor */
                public IUserParamRbId() {
                }

                /** full constructor */
                public IUserParamRbId(Long servId, Integer keyId, Date validDate) {
                        this.servId = servId;
                        this.keyId = keyId;
                        this.validDate = validDate;
                }

                // Property accessors
                
                @Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
                public Long getServId() {
                        return this.servId;
                }

                public void setServId(Long servId) {
                        this.servId = servId;
                }
                
                @Column(name = "KEY_ID", precision = 8, scale = 0)
                public Integer getKeyId() {
                        return this.keyId;
                }

                public void setKeyId(Integer keyId) {
                        this.keyId = keyId;
                }

                @Temporal(TemporalType.TIMESTAMP)
                @Column(name = "VALID_DATE", nullable = false, length = 7)
                public Date getValidDate() {
                        return this.validDate;
                }

                public void setValidDate(Date validDate) {
                        this.validDate = validDate;
                }

                @Override
                public boolean equals(Object other) {
                    if ( !(other instanceof IUserParamRbId) ) return false;
                    IUserParamRbId castOther = (IUserParamRbId) other;
                    return new EqualsBuilder()
                        .append(this.getServId(), castOther.getServId())
                        .append(this.getKeyId(), castOther.getKeyId())
                        .append(this.getValidDate(), castOther.getValidDate())
                        .isEquals();
                }
                
                @Override
                public int hashCode() {
                    return new HashCodeBuilder()
                        .append(getServId())
                        .append(getKeyId())
                        .append(getValidDate())
                        .toHashCode();
                }
        }       
}