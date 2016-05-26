package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "PROD_OUT_SP", schema = "INTER")
@IdClass(ProdOutSp.ProdOutSpId.class)
@CommonDao(fieldOfSelectConditions = { "spCode", "operatorCode", "prodId"},fieldOfDBSelectConditions={"sp_Code", "operator_Code", "prod_Id"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class ProdOutSp  extends BaseEntity implements java.io.Serializable {
	private Short promType;
	private Long prodId;
	private Long spCode;
	private String prodName;
	private String promName;
	private String operatorCode;
	private String remark;
	private String brand;
	
	public ProdOutSp() {
	}
	
	public ProdOutSp(Short promType, Long prodId, Long spCode, String prodName,
			String promName, String operatorCode, String remark,String brand) {
		this.promType = promType;
		this.prodId = prodId;
		this.spCode = spCode;
		this.prodName = prodName;
		this.promName = promName;
		this.operatorCode = operatorCode;
		this.remark = remark;
		this.brand = brand;
	}

	@Column(name = "PROM_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getPromType() {
		return promType;
	}

	public void setPromType(Short promType) {
		this.promType = promType;
	}

	@Id
	@Column(name = "PROD_ID", nullable = false, precision = 10, scale = 0)
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	@Id
	public Long getSpCode() {
		return spCode;
	}

	public void setSpCode(Long spCode) {
		this.spCode = spCode;
	}

	@Column(name = "PROD_NAME", nullable = false, length = 128)
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "PROM_NAME", nullable = false, length = 128)
	public String getPromName() {
		return promName;
	}

	public void setPromName(String promName) {
		this.promName = promName;
	}

	@Id
	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Column(name = "REMARK",  length = 24)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "BRAND",  length = 24)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public static class ProdOutSpId implements java.io.Serializable {

		// Fields

		private Long prodId;
		private Long spCode;
		private String operatorCode;
		// Constructors

		/** default constructor */
		public ProdOutSpId() {
		}

		/** full constructor */
		public ProdOutSpId(Long prodId, Long spCode, String operatorCode) {
			this.prodId = prodId;
			this.spCode = spCode;
			this.operatorCode = operatorCode;
		}

		// Property accessors

		@Column(name = "PROD_ID", nullable = false, precision = 10, scale = 0)
		public Long getProdId() {
			return prodId;
		}

		public void setProdId(Long prodId) {
			this.prodId = prodId;
		}
		
		@Column(name = "SP_CODE", nullable = false, precision = 14, scale = 0)
		public Long getSpCode() {
			return spCode;
		}

		public void setSpCode(Long spCode) {
			this.spCode = spCode;
		}

		@Column(name = "OPERATOR_CODE", nullable = false, length = 24)
		public String getOperatorCode() {
			return operatorCode;
		}

		public void setOperatorCode(String operatorCode) {
			this.operatorCode = operatorCode;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof ProdOutSpId) ) return false;
	        ProdOutSpId castOther = (ProdOutSpId) other;
	        return new EqualsBuilder()
	            .append(this.getSpCode(), castOther.getSpCode())
	            .append(this.getOperatorCode(), castOther.getOperatorCode())
	            .append(this.getProdId(), castOther.getProdId())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getSpCode())
	            .append(getOperatorCode())
	            .append(getProdId())
	            .toHashCode();
	    }

	}
}
