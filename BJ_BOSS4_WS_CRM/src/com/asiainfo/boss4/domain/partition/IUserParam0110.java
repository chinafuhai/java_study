package com.asiainfo.boss4.domain.partition;

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

import com.asiainfo.boss4.domain.IUserParam;

/**
 * IUserParam0110 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PARAM_0110", schema = "ZG")
@IdClass(IUserParam0110.IUserParam0110Id.class)
public class IUserParam0110 extends IUserParam implements java.io.Serializable {

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
        
        // Constructors

        /** default constructor */
        public IUserParam0110() {
        }

        /** minimal constructor */
        public IUserParam0110(Long servId, Date validDate, Date expireDate, Long sid,
                        Long soNbr) {
                this.servId = servId;
                this.validDate = validDate;
                this.expireDate = expireDate;
                this.soNbr = soNbr;
        }

        /** full constructor */
        public IUserParam0110(Long servId, Integer keyId,
                        String userParam,Short regionCode, Date beginDate, Date validDate,Date expireDate, 
                        Long sid, Long soNbr, String remark) {
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
            .toString();
        }

        public static class IUserParam0110Id implements java.io.Serializable {

                // Fields

                private Long servId;
                private Integer keyId;
                private Date validDate;

                // Constructors

                /** default constructor */
                public IUserParam0110Id() {
                }

                /** full constructor */
                public IUserParam0110Id(Long servId, Integer keyId, Date validDate) {
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
                   if ( !(other instanceof IUserParam0110Id) ) return false;
                   IUserParam0110Id castOther = (IUserParam0110Id) other;
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