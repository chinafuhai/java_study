package com.asiainfo.boss4.support;

import java.util.Comparator;
import java.util.HashSet;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class VoComparator implements Comparator<LazyDynaMap> {
	private static Log logger = LogFactory.getLog(VoComparator.class);
	
	private static VoComparator voComparator = null;
	
	//存放需要排序的交易代码
	private static HashSet<String> tranCodeSet = new HashSet<String>();
	
	public static VoComparator getInstance(){
		if(voComparator==null){
			voComparator = new VoComparator();
			tranCodeSet.add(TranCode.CHANGE_COMBO.getTranCode());
			tranCodeSet.add(TranCode.SMS_CHARGE_REMIND.getTranCode());
			tranCodeSet.add(TranCode.COMBO_MESSENGER.getTranCode());
			tranCodeSet.add(TranCode.CHANGE_COMBO_PARAM.getTranCode());
			tranCodeSet.add(TranCode.CHANGE_COMBO_APPEND.getTranCode());
			tranCodeSet.add(TranCode.CHANGE_COMBO_PARAM_ONLY.getTranCode());
			tranCodeSet.add(TranCode.CHANGE_GROUP_BUSI.getTranCode());
			tranCodeSet.add(TranCode.PAY_RELATION.getTranCode());
			tranCodeSet.add(TranCode.CHANGE_GROUP_MEMBER.getTranCode());
			//全球通话费提醒
			tranCodeSet.add(TranCode.CHARGE_NOTICE.getTranCode());
		}
		return voComparator;
	}

	public int compare(LazyDynaMap vo1, LazyDynaMap vo2) {
		String tranCode1 = (String) vo1.get("tranCode");
		String tranCode2 = (String) vo2.get("tranCode");
		String soNbr1 = (String) vo1.get("soNbr");
		String soNbr2 = (String) vo2.get("soNbr");
		
		//交易代码为空
		if (tranCode1 == null || tranCode2 == null){
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		 //国家折扣10606新增排在11602业务之后，取消排在11602业务之前
		if (tranCode1.equals(TranCode.CHANGE_COMBO_PARAM_ONLY.getTranCode())&&tranCode2.equals(TranCode.CHANGE_GROUP_BUSI.getTranCode())) {
			String operType1 = (String) vo1.get("operType");
			if (operType1.equals(OperateType.ADD.getTypeCode())) {
				return 1;
			}
			else if (operType1.equals(OperateType.CANCEL.getTypeCode())) {
				return -1;
			}
		}
		if (tranCode1.equals(TranCode.CHANGE_GROUP_BUSI.getTranCode())&&tranCode2.equals(TranCode.CHANGE_COMBO_PARAM_ONLY.getTranCode())) {
			String operType2 = (String) vo2.get("operType");
			if (operType2.equals(OperateType.ADD.getTypeCode())) {
				return -1;
			}
			else if (operType2.equals(OperateType.CANCEL.getTypeCode())) {
				return 1;
			}
		}
		
		//交易代码在集合中的vo比不在集合中的靠后
		if (tranCodeSet.contains(tranCode1)&&!tranCodeSet.contains(tranCode2)) return 1;
//		if (!tranCodeSet.contains(tranCode1)&&tranCodeSet.contains(tranCode2)) return -1;
		
		//都在集合中的，operType较小的靠后
		if (tranCodeSet.contains(tranCode1)&&tranCodeSet.contains(tranCode2)&&tranCode1.equals(tranCode1)){
			String operType1 = (String) vo1.get("operType");
			String operType2 = (String) vo2.get("operType");
			return operType2.compareTo(operType1);
		}
		return -1;
	}
}