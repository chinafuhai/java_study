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
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserCell entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_CELL", schema = "ZG")
@IdClass(IUserCell.IUserCellId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = { "servId", "soId","expireDate" },fieldOfDBSelectConditions={"serv_id","so_id","expire_date"})
public class IUserCell extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long soId;
	private Integer cellCode;
	private Integer busiType;
	private Short regionCode;
	private Date beginDate;
	private Date validDate;
	private Date expireDate;
	private String property;
	private Long sid;
	private Long soNbr;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserCell() {
	}

	/** minimal constructor */
	public IUserCell(Long servId, Integer spromId, Date validDate, Long soId,
			Integer busiType, Date beginDate, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.cellCode = spromId;
		this.validDate = validDate;
		this.soId = soId;
		this.busiType = busiType;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserCell(Long servId, Integer spromId, Date validDate, Long soId,
			Short regionCode, Integer busiType, String property,
			Date beginDate, Date expireDate, Long sid, Long soNbr,
			String remark) {
		this.servId = servId;
		this.cellCode = spromId;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.busiType = busiType;
		this.property = property;
		this.beginDate = beginDate;
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

	@Column(name = "CELL_CODE", nullable = false, precision = 8, scale = 0)
	public Integer getCellCode() {
		return this.cellCode;
	}

	public void setCellCode(Integer cellCode) {
		this.cellCode = cellCode;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoId() {
		return soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiType() {
		return this.busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_DATE", nullable = false, length = 7)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
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
            .append("cellCode", getCellCode())
            .append("validDate", getValidDate())
            .append("regionCode",getRegionCode())
            .append("busiType",getBusiType())
            .append("property",getProperty())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IUserCellId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Date validDate;
		private Long soId;

		// Constructors

		/** default constructor */
		public IUserCellId() {
		}

		/** full constructor */
		public IUserCellId(Long servId, Date validDate, Long soId) {
			this.servId = servId;
			this.validDate = validDate;
			this.soId = soId;
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

		@Column(name = "SO_ID", nullable = false, precision = 15, scale = 0)
		public Long getSoId() {
			return this.soId;
		}

		public void setSoId(Long soId) {
			this.soId = soId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserCellId) ) return false;
	        IUserCellId castOther = (IUserCellId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getSoId(), castOther.getSoId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getSoId())
	            .append(getValidDate())
	            .toHashCode();
	    }

	}
}