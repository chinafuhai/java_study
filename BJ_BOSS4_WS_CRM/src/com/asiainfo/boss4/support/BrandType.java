package com.asiainfo.boss4.support;

import java.util.EnumSet;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
/**
 * 用户品牌类型枚举类
 * @author caohui
 *
 */
public enum BrandType {
	
	GOTONE(1,50001001L,"全球通"),
	GOTONE_PAY_BEFORE(15,50001027L,"全球通预付费"),
	E_NET(2,50001002L,"随e行"),
	E_NET_GIFT_CARD(2,50001018L,"随e行礼品卡"),
	E_NET_LTE(2,50001029L,"随e行-LTE后付费"),
	EASYOWN_GPRS(3,50001012L,"神州行GPRS"),
	M_ZONE(4,50001004L,"动感地带"),
	M_ZONE_FAMILY_BEFORE(4,50001024L,"动感地带（家庭预付费）"),
	EASYOWN_CT_CARD3(5,50001003L,"神州行畅听卡"),
	EASYOWN_CT_CARD6(5,50001006L,"神州行畅听卡"),
	EASYOWN_CT_CARD10(5,50001010L,"神州行畅听卡"),
	EASYOWN_CT_CARD25(5,50001025L,"神州行畅听卡-长市漫合一卡"),
	EASYOWN_CT_CARD8(5,50001008L,"神州行5元卡(畅听卡)"),
	EASYOWN_CT_CARD9(13,50001009L,"神州行5元卡"),
	EASYOWN_DZ_CARD(6,50001007L,"神州行大众卡"),
	EASYOWN_BOSS(7,50001005L,"神州行BOSS4"),
	EASYOWN_BOSS_HELLO(7,50001019L,"神州行HELLO卡"),
	EASYOWN_BOSS_OLYMPIC_INTERNATIONAL(7,50001020L,"神州行奥运国际卡"),
	EASYOWN_BOSS_OLYMPIC_TRAVEL(7,50001021L,"神州行奥运商旅卡"),
	EASYOWN_BOSS_OLYMPIC(7,50001022L,"神州行奥运卡"),
	EASYOWN_BOSS_2012HELLO(7,50001026L,"2012版hello卡"),
	EASYOWN_TT_CARD(8,50001108L,"铁通卡"),
	TD_XF_CARD(9,50001013L,"TD先锋卡"),
	TD_XF_IPOWER_CARD(9,50001023L,"I-POWER卡"),
	TD_SJ_CARD(10,50001014L,"TD数据卡"),
	G3_YFF_CARD(11,50001015L,"G3预付费卡"),
	G3_YFF_LTE_CARD(11,50001028L,"G3预付费卡-LTE预付费"),
	G3_XXJ_CARD(12,50001016L,"G3信息机卡"),
	RAILWAY_CARD(14,50001018L,"铁路公话"),
	M2M_BEFORE_CARD(16,5001030L,"物联网预付费品牌"),
	M2M_AFTER_CARD(17,5001031L,"物联网后付费品牌"),
	ENTERPRISE_GROUP_BEFORE(4,50001017L,"预付费集团"),
	ENTERPRISE_GROUP_AFTER(1,50001011L,"后付费集团");
	
	private Integer code;
	private Long planId;
	private String description;
	
	BrandType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	private BrandType(Integer code, Long planId, String description) {
		this.code = code;
		this.planId = planId;
		this.description = description;
	}

	public Integer code() {
		return code;
	}
	
	public Long getPlanId() {
		return planId;
	}

	public String description() {
		return description;
	}
	
	public static BrandType getBrandType(Integer code) {
		EnumSet<BrandType> brands = EnumSet.allOf(BrandType.class);
		for (BrandType brand : brands) {
			if (brand.code.equals(code)) {
				return brand;
			}
		}
		throw new BossException(StatusCode.NOT_EXIST_BRAND_TYPE_ERROR);
	}
	
	public static BrandType getBrandType(Integer code, Long planId) {
		EnumSet<BrandType> brands = EnumSet.allOf(BrandType.class);
		for (BrandType brand : brands) {
			if (brand.code.equals(code) && brand.planId.equals(planId)) {
				return brand;
			}
		}
		throw new BossException(StatusCode.NOT_EXIST_BRAND_TYPE_ERROR);
	}
	
	/**
	 * 根据brand和planId判断BrandType
	 * @param brand
	 * @param planId
	 * @return
	 */
	public boolean equalByBrandAndPlan(Integer brand, Long planId) {
		if (this.code.equals(brand) && this.planId.equals(planId)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据brand和planId判断BrandType
	 * @param brand
	 * @param planId
	 * @return
	 */
	public boolean equalByBrandAndPlan(String brand, String planId) {
		return equalByBrandAndPlan(Integer.valueOf(brand), Long.valueOf(planId));
	}
	
	/**
	 * 根据brand判断BrandType
	 * @param brand
	 * @return
	 */
	public boolean equalByBrand(Integer brand) {
		if (this.code.equals(brand)) {
			return true;
		}
		return false;
	}
	
	private static EnumSet<BrandType> boss4UserBrand = null;
	public static EnumSet<BrandType> getBoss4UserBrand() {
		if (boss4UserBrand == null) {
			boss4UserBrand = EnumSet.of(
					GOTONE,
					E_NET,
					E_NET_GIFT_CARD,
					M_ZONE,
					M_ZONE_FAMILY_BEFORE,
					EASYOWN_CT_CARD3,
					EASYOWN_CT_CARD6,
					EASYOWN_CT_CARD8,
					EASYOWN_CT_CARD9,
					EASYOWN_CT_CARD10,
					EASYOWN_DZ_CARD,
					EASYOWN_BOSS,
					EASYOWN_BOSS_HELLO,
					EASYOWN_BOSS_OLYMPIC_INTERNATIONAL,
					EASYOWN_BOSS_OLYMPIC_TRAVEL,
					EASYOWN_BOSS_OLYMPIC,
					EASYOWN_TT_CARD,
					TD_XF_CARD,
					TD_XF_IPOWER_CARD,
					TD_SJ_CARD,
					G3_YFF_CARD,
					G3_XXJ_CARD,
					ENTERPRISE_GROUP_BEFORE,
					ENTERPRISE_GROUP_AFTER);
		}
		return boss4UserBrand;
	}
	
	public static boolean isBoss4UserBrand(Integer code) {
		for (BrandType brand : getBoss4UserBrand()) {
			if (brand.code().equals(code)) {
				return true;
			}
		}
		return false;
	}
	
	//个人后付费品牌
	private static EnumSet<BrandType> individualAfterPayBrand = null;
	public static EnumSet<BrandType> getIndividualAfterPayBrand() {
		if (individualAfterPayBrand == null) {
			individualAfterPayBrand = EnumSet.of(
					GOTONE,
					E_NET);
		}
		return individualAfterPayBrand;
	}
	
	/**
	 * 是否为个人后付费品牌
	 * @param code
	 * @return
	 */
	public static boolean isIndividualAfterPayBrand(Integer code) {
		for (BrandType brand : getIndividualAfterPayBrand()) {
			if (brand.code().equals(code)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否为个人后付费品牌
	 * @return
	 */
	public boolean isIndividualAfterPayBrand() {
		return getIndividualAfterPayBrand().contains(this);
	}
	
	//后付费品牌
	private static EnumSet<BrandType> afterPayBrand = null;
	public static EnumSet<BrandType> getAfterPayBrand() {
		if (afterPayBrand == null) {
			afterPayBrand = EnumSet.of(
					GOTONE,
					E_NET,
					ENTERPRISE_GROUP_AFTER);
		}
		return afterPayBrand;
	}
	
	/**
	 * 是否为后付费品牌
	 * 包括个人和集团
	 * @param code
	 * @return
	 */
	public static boolean isAfterPayBrand(Integer code) {
		for (BrandType brand : getAfterPayBrand()) {
			if (brand.code().equals(code)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否为后付费品牌
	 * 包括个人和集团
	 * @return
	 */
	public boolean isAfterPayBrand() {
		return getAfterPayBrand().contains(this);
	}
	
	public static BrandType getNewBrandType(LazyDynaMap vo) {
		DataValiditionHelper.checkInputVo(vo, "newBrand");
		DataValiditionHelper.checkInputVo(vo, "newPlanId");
		
		Integer newBrand = Integer.valueOf((String) vo.get("newBrand"));
		Long newPlanId = Long.valueOf((String) vo.get("newPlanId"));
		
		return BrandType.getBrandType(newBrand, newPlanId);
	}
	
	public static BrandType getOldBrandType(LazyDynaMap vo) {
		DataValiditionHelper.checkInputVo(vo, "oldBrand");
		DataValiditionHelper.checkInputVo(vo, "oldPlanId");
		
		Integer oldBrand = Integer.valueOf((String) vo.get("oldBrand"));
		Long oldPlanId = Long.valueOf((String) vo.get("oldPlanId"));
		
		return BrandType.getBrandType(oldBrand, oldPlanId);
	}
	
	public static BrandType getBrandType(LazyDynaMap vo) {
		DataValiditionHelper.checkInputVo(vo, "brand");
		DataValiditionHelper.checkInputVo(vo, "planId");
		
		Integer brand = Integer.valueOf((String) vo.get("brand"));
		Long planId = Long.valueOf((String) vo.get("planId"));
		
		return BrandType.getBrandType(brand, planId);
	}
}
