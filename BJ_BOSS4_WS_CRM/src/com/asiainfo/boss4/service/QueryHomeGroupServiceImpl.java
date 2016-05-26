package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;

import com.asiainfo.boss4.domain.IGroupMember;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.XmlHelper;

public class QueryHomeGroupServiceImpl implements QueryBusinessService {

	public String process(LazyDynaMap vo) {
		try {
			DataValiditionHelper.checkInputVo(vo, "msisdn");
			ServiceContext context = ServiceContext
					.getInstanceFromCurrentThread();

			String msisdn = (String) vo.get("msisdn");
			IUserAll user = IUserAll.queryByMsisdn(context, msisdn);
			if (user == null)
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR);

			// 由于数据不一致，同一个用户可能同时存在于多个同类群组中
			List<IGroupMember> groups = IGroupMember.queryByServIdAndGroupType(
					context, user.getServId(), (byte) 8);

			List<IGroupMember> members = new ArrayList<IGroupMember>();
			List<IUserSprom> sproms = new ArrayList<IUserSprom>();

			for (IGroupMember group : groups) {
				// 根据groupId加载所有成员
				List<IGroupMember> member = IGroupMember.queryAllMemberInGroup(
						context, group.getGroupId());
				members.addAll(member);

				// 根据groupId加载计费产品
				IUserSprom sprom = IUserSprom.queryRecentByServId(context,
						group.getGroupId());
				sproms.add(sprom);
			}

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("members", members);
			root.put("sproms", sproms);

			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_HOME_GROUP.getTranCode(), root);
		} catch (BossException e) {
			Map<String, String> root = new HashMap<String, String>();
			root.put(XmlHelper._CODE, e.getStatus().getCode());
			root.put(XmlHelper._DESC, e.buildResponseDescription());
			return XmlHelper.buildQueryOutputXMLByTemplate(TranCode.QUERY_HOME_GROUP.getTranCode(), root);
		}
	}

}
