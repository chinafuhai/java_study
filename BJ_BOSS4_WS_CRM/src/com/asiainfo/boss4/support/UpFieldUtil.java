package com.asiainfo.boss4.support;

import java.util.EnumSet;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.domain.IAccSprom;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.IAcctBillCycle;
import com.asiainfo.boss4.domain.ICustomer;
import com.asiainfo.boss4.domain.IFreeResRule;
import com.asiainfo.boss4.domain.IGroupMember;
import com.asiainfo.boss4.domain.IMsisdnVsCust;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserBillCycle;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserEnterprise;
import com.asiainfo.boss4.domain.IUserExtCond;
import com.asiainfo.boss4.domain.IUserMap;
import com.asiainfo.boss4.domain.IUserMonitor;
import com.asiainfo.boss4.domain.IUserParam;
import com.asiainfo.boss4.domain.IUserPayRelation;
import com.asiainfo.boss4.domain.IUserPbx;
import com.asiainfo.boss4.domain.IUserPlan;
import com.asiainfo.boss4.domain.IUserRelation;
import com.asiainfo.boss4.domain.IUserRoamRent;
import com.asiainfo.boss4.domain.IUserShareSprom;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserStatus;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * upField字符串自动生成
 * 
 * @author wenjiang, caohui
 * 
 */
public class UpFieldUtil {
	private static Log logger = LogFactory.getLog(UpFieldUtil.class);
	
	public final static String EMPTY_UPFIELD = "0000000000000000000000000000000000000000000000000000000000000000";
	public final static String FULL_UPFIELD = "1111111111111111111111111111111111111111111111111111111111111111";
	
	public static enum NeedNotice {
		I_USER(IUser.class, 0),
		I_USER_ROAM_RENT(IUserRoamRent.class, 3),
		I_GROUP_MEMBER(IGroupMember.class, 5),
		I_USER_PAY_RELATION(IUserPayRelation.class, 18),
		I_USER_RELATION(IUserRelation.class, 8),
		I_CUSTOMER(ICustomer.class, 10),
		I_ACCOUNT(IAccount.class, 11),
		I_FREE_RES_RULE(IFreeResRule.class, 16),
		I_SPROM_PARAM(ISpromParam.class, 49),
		I_USER_PARAM(IUserParam.class, 54),
		I_USER_CELL(IUserCell.class, 14),
		I_ACCBUSI_CREDIT(IAccBusiCredit.class, 21),
		I_USER_STATUS(IUserStatus.class, 22),
		I_USER_MONITOR(IUserMonitor.class, 25),
		I_USER_PLAN(IUserPlan.class, 36),
		I_USER_ENTERPRISE(IUserEnterprise.class, 44),
		I_USER_PBX(IUserPbx.class, 45),
		I_USER_SPROM(IUserSprom.class, -1),
		I_MSISDN_VS_CUST(IMsisdnVsCust.class, 10),
		I_USER_BILL_CYCLE(IUserBillCycle.class, 50),
		I_USER_EXT_COND(IUserExtCond.class, 52),
		I_ACCT_BILL_CYCLE(IAcctBillCycle.class, 55),
		I_ACC_SPROM(IAccSprom.class, 19),
		I_USER_SHARE_SPROM(IUserShareSprom.class, 59),
        I_USER_MAP(IUserMap.class,29);
		
		private Class entityClass;
		
		public Class className () {
			return this.entityClass;
		}
		
		public int index;
		
		public int getIndex() {
			return index;
		}

		private NeedNotice(Class entytClass, int index) {
			this.entityClass = entytClass;
			this.index = index;
		}

		public enum SpromType {
			_0(0, 1), _1(1, 1), _3(3, 1), _4(4, 38), _5(5, 37), _6(6, 23), _7(7, 37),  _8(8, 38), _9(7, 37), _10(10, 2), _11(11, 38);
			
			private int spromType;
			
			private int index;
			
			public int getSpromType() {
				return spromType;
			}
			
			public int getIndex() {
				return index;
			}
			
			private SpromType(int spromType, int index) {
				this.spromType = spromType;
				this.index = index;
			}
			
		}
		
		private static EnumSet<NeedNotice> needNoticeISaleOper = null;
		private static EnumSet<NeedNotice> needNoticeISaleOper() {
			if (needNoticeISaleOper == null) {
				needNoticeISaleOper = EnumSet.of(I_USER, 
						I_USER_PLAN, 
						I_USER_PAY_RELATION,
						I_USER_RELATION, 
						I_USER_SPROM, 
						I_USER_PARAM,
						I_USER_STATUS, 
						I_USER_MONITOR,
//						I_ACCOUNT, 
//						I_CUSTOMER,
						I_SPROM_PARAM,
						I_USER_CELL,
						I_GROUP_MEMBER,
						I_USER_PBX,
						I_USER_ENTERPRISE,
						I_USER_ROAM_RENT,
						I_FREE_RES_RULE,
						I_USER_BILL_CYCLE,
						I_ACCT_BILL_CYCLE,
						I_USER_EXT_COND,
						I_USER_SHARE_SPROM,
                        I_USER_MAP);
//账务优惠不需要接口校验标志位 	I_ACC_SPROM);
			}
			return needNoticeISaleOper;
		}
		
		public static boolean isNeedNoticeISaleOper(Class entityClass) {
			for (NeedNotice needNotice : needNoticeISaleOper()) {
				if (needNotice.className().equals(entityClass)) {
					return true;
				}
			}
			return false;
		}
		
		public static NeedNotice getNeedNotice(Class entityClass) {
			for (NeedNotice notice : EnumSet.allOf(NeedNotice.class)) {
				if (notice.className().equals(entityClass)) {
					return notice;
				}
			}
			logger.debug("指定的表不需要上发");
			return null;
		}
	};
	
	/**
	 * 根据指定的分表实体，更新传入的upfield串，并返回
	 * @param entity
	 * @param originalUpField
	 * @return
	 */
	public static String getUpField(Object entity, String originalUpField) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		NeedNotice notice = NeedNotice.getNeedNotice(entityClass);
		if (notice == null) {
			return originalUpField;
		}
		int index = notice.getIndex();
		if (index == -1 && IUserSprom.class.equals(entityClass)) {
			Integer spromType = (Integer) BeanCopyHelper.getProperty(entity, "spromType");
			if (spromType == null) {
				return originalUpField;
			}
			StringBuffer newUpField = new StringBuffer(originalUpField);
			for (NeedNotice.SpromType item : EnumSet.allOf(NeedNotice.SpromType.class)) {
				if (item.getSpromType() == spromType.intValue() || AppConstant.ALL_SPROM_TYPE.equals(spromType.toString())) {
					index = item.getIndex();
					newUpField.replace(index, index+1, "1");
				}
			}
			if (index == -1) {//对于未配置的spromType均更新第二位
				newUpField.replace(1, 2, "1");
			}
			return newUpField.toString();
		}
		if (index == -1) {
			return originalUpField;
		}
		return new StringBuffer(originalUpField).replace(index, index+1, "1").toString();
	}
	
	/**
	 * 返回指定的实体需要更新upfield的对应位数
	 * @param entity
	 * @return
	 */
	public static int getPositionOfUpfield(Object entity) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		NeedNotice notice = NeedNotice.getNeedNotice(entityClass);
		if (notice == null) {
			return -1;
		}
		int index = notice.getIndex();
		if (index == -1 && IUserSprom.class.equals(entityClass)) {
			Integer spromType = (Integer) BeanCopyHelper.getProperty(entity, "spromType");
			if (spromType == null) {
				throw new BossException(StatusCode.INSIDE_ERROR, "spromType为空，无法计算upfield位数");
			}
			for (NeedNotice.SpromType item : EnumSet.allOf(NeedNotice.SpromType.class)) {
				if (item.getSpromType() == spromType.intValue()) {
					return item.getIndex();
				}
			}
			if (index == -1) { //对于未配置的spromType均更新第二位
				index = 1;
			}
		}
		return index;
	}
	
	/**
	 * 实际处理中，某些在配置中定义的表实际不需要操作，可使用此方法更新upfield对应位数为0
	 * @param vo
	 * @param entity
	 */
	public static void setLiveCanceledUpfield(DynaBean vo, Object entity) {
		String liveCanceledField = (String) vo.get(AppConstant.LIVE_CANCELED_UPFIELD);
		StringBuffer liveBuffer = new StringBuffer();
		if (liveCanceledField == null || "".equals(liveCanceledField)) {
			liveBuffer.append(UpFieldUtil.FULL_UPFIELD);
		} else {
			liveBuffer.append(liveCanceledField);
		}
		int upfieldIndex = UpFieldUtil.getPositionOfUpfield(entity);
		if (upfieldIndex == -1) {
			return;
		}
		liveBuffer.replace(upfieldIndex, upfieldIndex+1, "0");
		vo.set(AppConstant.LIVE_CANCELED_UPFIELD, liveBuffer.toString());
		logger.debug(">> setting LIVE_CANCELED_UPFIELD :"+liveBuffer.toString());
	}
	
	/**
	 * 获取最终的UpField串
	 * 在实际业务处理中，某些表可能无需处理，此时需要更新UpField的指定位为0，此方法通过位运算生成最终的UpField字符串
	 * @param vo
	 * @param originalUpField
	 * @return
	 */
	public static String getFinallyUpField(DynaBean vo, String originalUpField) {
		// 取实际业务处理中实时更新的upfield
		// (此字符串在处理的业务处理的过程中会被实时更新，在全1的基础更新，如果某个表不操作更新指定的位数为0)
		String liveField = (String) vo.get(AppConstant.LIVE_CANCELED_UPFIELD);
		if (liveField ==  null) {
			return originalUpField;
		}
		// 根据配置生成的upfield串
		StringBuffer orig = new StringBuffer(originalUpField);
		logger.debug(">> viewing CONFIG_UPFIELD : "+originalUpField);
		// 实时生成的upfield串
		StringBuffer live = new StringBuffer(liveField);
		logger.debug(">> viewing LIVE_CANCELED_UPFIELD : "+liveField);
		
		// 每位进行AND运算
		for (int i = 0; i < originalUpField.length(); i++) {
			Integer origInt = Integer.valueOf(orig.subSequence(i, i+1).toString(), 2);
			Integer liveInt = Integer.valueOf(live.subSequence(i, i+1).toString(), 2);
			orig.replace(i, i+1, Integer.toBinaryString(origInt & liveInt));
		}
		
		logger.debug(">> viewing FINALLY_UPFIELD : "+orig.toString());
		return orig.toString();
	}

	/**
	 * 获得LazyDynaMap vo 系统根据业务设置UpField串
	 */
	public static void setUpField(LazyDynaMap vo) {
		String tranCode = null;
		try {
			tranCode = (String) vo.get("tranCode");
			if (tranCode == null) {
				throw new Exception("交易代码为空");
			}
		} catch (Exception e1) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR, e1);
		}

		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);

		Class[] classes = config.getClasses();
		
		StringBuffer raccUpField = new StringBuffer();
		raccUpField.append(EMPTY_UPFIELD);
		for (int i = 0; i < classes.length; i++) {
			if (classes[i].getSimpleName().equals("IAccBusiCredit")) {
				raccUpField.replace(21, 22, "1");
			}
		}
		vo.set("iRaccOperUpField", raccUpField.toString());
		
		StringBuffer custUpField = new StringBuffer();
		custUpField.append(EMPTY_UPFIELD);
		for (int i = 0; i < classes.length; i++) {
			if (classes[i].getSimpleName().equals("IMsisdnVsCust")) {
				custUpField.replace(10, 11, "1");
			}
		}
		vo.set("iIntfOperUpField", custUpField.toString());
		
		StringBuffer orderUpField = new StringBuffer();
		orderUpField.append(EMPTY_UPFIELD);
		for (int i = 0; i < classes.length; i++) {
			if (classes[i].getSimpleName().equals("IUserOrder")) {
				orderUpField.replace(0, 1, "1");
			}
		}
		vo.set("iOrderOperUpField", orderUpField.toString());
	}
	
	/**
	 * 根据spromType修改upField值
	 * @param upField
	 * @param spromType
	 */
	public static void modifyUpFieldBySpromType(StringBuffer upField, String spromType){
		if (spromType == null || "".equals(spromType)) {
			return;
		}
		
		IUserSprom sprom = new IUserSprom();
		sprom.setSpromType(Integer.valueOf(spromType));
		
		int updateIndex = getPositionOfUpfield(sprom);
		if (updateIndex == -1) {
			return;
		}
		upField.replace(updateIndex, updateIndex+1, "1");
		
	}

	/**
	 * 按指定类更新传入的upField，并返回
	 * @param upField
	 * @param clazz
	 * @return
	 */
	public static String modifyUpFieldByClass(String upField, Class clazz) {
		Object entity = BeanCopyHelper.newInstance(clazz);
		int index = getPositionOfUpfield(entity);
		return new StringBuffer(upField).replace(index, index+1, "1").toString();
	}
}
