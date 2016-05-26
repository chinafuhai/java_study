package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.QueryBusinessDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserOrder;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.PmSpOperatorCode;
import com.asiainfo.boss4.domain.ProdOutSp;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.RateType;

public class QueryProdOutSpImpl   implements QueryBusinessService{
private static Log logger = LogFactory.getLog(QueryProdOutSpImpl.class);
	
	private QueryBusinessDao queryBusinessDao;
	
	public void setQueryBusinessDao(QueryBusinessDao queryBusinessDao) {
		this.queryBusinessDao = queryBusinessDao;
	}

	public String process(LazyDynaMap vo) {
		StringBuffer retXml = new StringBuffer();
		retXml.append("<item>")
				.append("<tranCode>").append(vo.get("tranCode")).append("</tranCode>")
				.append("<SID>").append(vo.get("soNbr")).append("</SID>");
				
		try{
			Long servId = Long.valueOf((String) vo.get("servId"));
			Long spCode = Long.valueOf((String) vo.get("spCode"));
			ProdOutSp prodOutSp = new ProdOutSp();
			prodOutSp.setSpCode(spCode);
			prodOutSp.setOperatorCode((String) vo.get("operCode"));
			List prodOutSpList = queryBusinessDao.getEntityList(prodOutSp,new String[]{"spCode","operatorCode"});
			retXml.append("<retCode>").append(StatusCode.SUCCESS.getCode()).append("</retCode>")
				.append("<retInfo>").append(StatusCode.SUCCESS.getDescription()).append("</retInfo>");
			
			boolean isFoundSprom = false;
			boolean isFoundParam = false;
			boolean isFoundSpec = false;
			boolean isFoundMail = false;
			Double rateSprom = null;
			Double rateParam = null;
			Double rateSpec = null;
			Double rateMail = null;
			StringBuffer rate = new StringBuffer();
			String rateDescription = RateType.getRateDescription(spCode, (String) vo.get("operCode"));
			
			//是否为统付
			long regionCode = servId.longValue()%10+101;
			IUserOrder  userOrder = (IUserOrder)Class.forName("com.asiainfo.boss4.domain.partition.IUserOrder0" + regionCode).newInstance();;
			userOrder.setServId(servId);
			userOrder.setSpCode((String) vo.get("spCode"));
			userOrder.setOperatorCode((String) vo.get("operCode"));
			List userOrderList = queryBusinessDao.getEntityList(userOrder, new String[]{"servId", "spCode", "operatorCode","expireDate"});
			Date cpcOrderDate = null;
			userOrder = null;
			//取生效时间最晚的CPC订购
			for (int i=0;i<userOrderList.size();i++)
			{
				userOrder = (IUserOrder)userOrderList.get(i);
				if (cpcOrderDate != null)
				{
					if (userOrder.getValidDate().after(cpcOrderDate))
						cpcOrderDate = userOrder.getValidDate();
					else
						userOrder = null;
				}
				else
				{
					cpcOrderDate = userOrder.getValidDate();
				}
			}
			
			//0-订购
			//3-恢复
			if (userOrder != null 
					&& (userOrder.getOrderSts().intValue() == 0 || userOrder.getOrderSts().intValue() == 3) 
					&& !userOrder.getThirdMsisdn().equals(userOrder.getMsisdn()))
			{
				//统付
				retXml.append("<servId>").append(servId).append("</servId>")
				.append("<spCode>").append(spCode).append("</spCode>")
				.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
				.append("<rate>0元/月</rate>")
				.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
				retXml.append("</item>");
				return retXml.toString();
			}
				
			PmSpOperatorCode pmSpOperatorCode = new PmSpOperatorCode();
			pmSpOperatorCode.setSpCode(prodOutSp.getSpCode());
			pmSpOperatorCode.setOperatorCode(prodOutSp.getOperatorCode());
			//此类业务为包月业务bill_flag=3
			pmSpOperatorCode.setBillFlag(Short.valueOf("3"));
			
			pmSpOperatorCode = (PmSpOperatorCode)queryBusinessDao.getEntity(pmSpOperatorCode,new String[]{"spCode","operatorCode","billFlag","expireDate"});
			if (pmSpOperatorCode == null)
			{
				pmSpOperatorCode = new PmSpOperatorCode();
				pmSpOperatorCode.setSpCode(prodOutSp.getSpCode());
				pmSpOperatorCode.setOperatorCode(prodOutSp.getOperatorCode());
				//此类业务为包月免费业务bill_flag=1
				pmSpOperatorCode.setBillFlag(Short.valueOf("1"));
				pmSpOperatorCode = (PmSpOperatorCode)queryBusinessDao.getEntity(pmSpOperatorCode,new String[]{"spCode","operatorCode","billFlag","expireDate"});
				if (pmSpOperatorCode == null)
					throw new BossException(StatusCode.PM_SP_OPERATOR_CODE_ERROR);
			}
			if (prodOutSpList.size() ==0)
			{
				//特殊类业务（如无线音乐）
				isFoundSpec = true;
				
				int memberLevel = 0;
				//普通会员   memberLevel = 0
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + (servId%10+101)).newInstance();
				userSprom.setServId(servId);
				userSprom.setSpromId(Integer.valueOf("50006004"));
				userSprom = (IUserSprom)queryBusinessDao.getEntity(userSprom, new String[]{"servId","spromId","expireDate"});
				if (userSprom == null)
				{
					//高级会员  memberLevel = 1
					memberLevel = 1;
					userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + (servId%10+101)).newInstance();
					userSprom.setServId(servId);
					userSprom.setSpromId(Integer.valueOf("50006005"));
					userSprom = (IUserSprom)queryBusinessDao.getEntity(userSprom, new String[]{"servId","spromId","expireDate"});
					if (userSprom == null)
					{
						//体验型高级会员  memberLevel = 1
						memberLevel = 1;
						userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + (servId%10+101)).newInstance();
						userSprom.setServId(servId);
						userSprom.setSpromId(Integer.valueOf("50006016"));
						userSprom = (IUserSprom)queryBusinessDao.getEntity(userSprom, new String[]{"servId","spromId","expireDate"});
						if (userSprom == null)
						{
							//特级会员  memberLevel = 2
							memberLevel = 2;
							userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + (servId%10+101)).newInstance();
							userSprom.setServId(servId);
							userSprom.setSpromId(Integer.valueOf("50006006"));
							userSprom = (IUserSprom)queryBusinessDao.getEntity(userSprom, new String[]{"servId","spromId","expireDate"});
						}
					}
				}
				if (userSprom == null)
					rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0;
				else 
				{
					
					
						switch (memberLevel)
						{
							case 0:
								if (pmSpOperatorCode != null 
										&& pmSpOperatorCode.getServType().intValue() == 8001 
										&& !prodOutSp.getOperatorCode().substring(7, 9).equals("03"))
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.9;
								else if (pmSpOperatorCode != null && pmSpOperatorCode.getServType().intValue() == 204)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.9;
								else if (pmSpOperatorCode != null)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0;
								else
									rateSpec = null;
								break;
							case 1:
								if (pmSpOperatorCode != null 
										&& pmSpOperatorCode.getServType().intValue() == 8001)
								{
									if (prodOutSp.getOperatorCode().substring(7, 9).equals("03"))
										rateSpec = 0.0;
									else
										rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.7;
								}
								else if (pmSpOperatorCode != null && pmSpOperatorCode.getServType().intValue() == 204)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.7;
								else if (pmSpOperatorCode != null)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0;
								else
									rateSpec = null;
								break;
							default:
								if (pmSpOperatorCode != null 
										&& pmSpOperatorCode.getServType().intValue() == 8001)
								{
									if (prodOutSp.getOperatorCode().substring(7, 9).equals("03")
											||prodOutSp.getOperatorCode().substring(7, 9).equals("04"))
										rateSpec = 0.0;
									else
										rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.7;
								}
								else if (pmSpOperatorCode != null && pmSpOperatorCode.getServType().intValue() == 204)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0*0.7;
								else if (pmSpOperatorCode != null)
									rateSpec = pmSpOperatorCode.getRate().intValue()/1000.0;
								else
									rateSpec = null;
						}
						
				}

			}
			else
			{
				CrmUser user = new CrmUser();
				user.setServId(servId);
				user = (CrmUser)queryBusinessDao.getEntity(user, new String[]{"servId"});

				for (int i=0;i<prodOutSpList.size();i++)
				{
					prodOutSp = (ProdOutSp)prodOutSpList.get(i);
					IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + (servId%10+101)).newInstance();
					userSprom.setServId(servId);
					userSprom.setSpromId(Integer.valueOf(prodOutSp.getProdId().toString()));
					userSprom = (IUserSprom)queryBusinessDao.getEntity(userSprom, new String[]{"servId","spromId","expireDate"});
					if (prodOutSp.getPromType()!=null && prodOutSp.getPromType().shortValue() == 1)
					{
						//全免业务
						if (prodOutSp.getBrand()!= null && !"".equals(prodOutSp.getBrand()))
						{
							if (user!=null && userSprom != null)
							{
								String[] brandList = prodOutSp.getBrand().split(",");
								boolean isFound = false;
								for (int j=0;j<brandList.length;j++)
								{
									if (user.getBrand().intValue() == Integer.valueOf(brandList[j]).intValue())
									{
										isFound = true;
										break;
									}
								}								
								
								if (isFound)
									isFoundSprom = true;
								else
									rateSprom = pmSpOperatorCode.getRate().intValue()/1000.0;
							}
							else
								rateSprom = pmSpOperatorCode.getRate().intValue()/1000.0;
						}
						else
						{
							if (userSprom != null)
								isFoundSprom = true;
							else
							{
								rateSprom = pmSpOperatorCode.getRate().intValue()/1000.0;
							}
						}
										
					}
					else if (prodOutSp.getPromType()!=null && prodOutSp.getPromType().shortValue() == 2)
					{
						//个性化折扣业务
						if (userSprom != null)
						{
							ISpromParam spromParam = (ISpromParam)Class.forName("com.asiainfo.boss4.domain.partition.ISpromParam0" + (servId%10+101)).newInstance();
							spromParam.setServId(userSprom.getServId());
							spromParam.setSoId(userSprom.getSoId());
							
							spromParam = (ISpromParam)queryBusinessDao.getEntity(spromParam, new String[]{"servId", "soId", "expireDate"});
							if (spromParam!=null)
							{
								isFoundParam = true;
								if (spromParam.getKeyId().intValue() == 790002)
								{
									if (rateParam == null || rateParam == 0.0 )
										rateParam = Integer.valueOf(spromParam.getSpromPara()).intValue()/100.0*pmSpOperatorCode.getRate().intValue()/1000.0;
									else if (rateParam != null)
										rateParam = rateParam * (Integer.valueOf(spromParam.getSpromPara()).intValue()/100.0*pmSpOperatorCode.getRate().intValue()/1000.0);

								}
								else if (spromParam.getKeyId().intValue() == 790001)
								{
									if (rateParam == null || rateParam == 0.0)
										rateParam = Integer.valueOf(spromParam.getSpromPara()).intValue()/1000.0;
									else if (rateParam != null)
										rateParam = rateParam + (Integer.valueOf(spromParam.getSpromPara()).intValue())/1000.0;
								}
							}
							else if (pmSpOperatorCode != null && !isFoundParam)
							{
								rateParam = pmSpOperatorCode.getRate().intValue()/1000.0;
							}
							
						}
						else if (pmSpOperatorCode != null && !isFoundParam)
						{
							rateParam = pmSpOperatorCode.getRate().intValue()/1000.0;
						}

					}
					else if (prodOutSp.getPromType()!=null && prodOutSp.getPromType().shortValue() == 4)
					{
						//139手机邮箱
						if (userSprom != null && userSprom.getValidDate().before(DateHelper.String2Date("20120901","yyyyMMdd")))
							isFoundMail = true;
						else
						{
							rateMail = pmSpOperatorCode.getRate().intValue()/1000.0;
						}
					}
					else if (prodOutSp.getPromType()!=null && prodOutSp.getPromType().shortValue() == 5)
					{
						//优惠彩铃月功能费_5元每月
//						retXml.append("<servId>").append(servId).append("</servId>")
//						.append("<spCode>").append(spCode).append("</spCode>")
//						.append("<operCode>").append(vo.get("operCode")).append("</operCode>");

						if (user != null && userSprom != null)
						{
							if (prodOutSp.getBrand()!= null && !"".equals(prodOutSp.getBrand()))
							{
								String[] brandList = prodOutSp.getBrand().split(",");
								boolean isFound = false;
								for (int j=0;j<brandList.length;j++)
								{
									if (user.getBrand().intValue() == Integer.valueOf(brandList[j]).intValue())
									{
										isFound = true;
										break;
									}
								}								
								
								if (isFound)
								{
									retXml.append("<servId>").append(servId).append("</servId>")
									.append("<spCode>").append(spCode).append("</spCode>")
									.append("<operCode>").append(vo.get("operCode")).append("</operCode>");
									retXml.append("<rate>0元/月</rate>");
									retXml.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
									retXml.append("</item>");
									return retXml.toString();
								}
								else
								{
//									retXml.append("<rate>").append(pmSpOperatorCode.getRate().intValue()/1000).append("元/月</rate>");
									rateSprom = pmSpOperatorCode.getRate().intValue()/1000.0;
								}
							}
						}
						else
						{
//							retXml.append("<rate>").append(pmSpOperatorCode.getRate().intValue()/1000).append("元/月</rate>");
							rateSprom = pmSpOperatorCode.getRate().intValue()/1000.0;
						}
//						retXml.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
//						retXml.append("</item>");
//						return retXml.toString();

					}

				}
			}
			if (isFoundSpec)
			{
				if (rateSpec != null)
				{
					rateSpec =((long)((rateSpec+0.005)*100))/100.0;
					//rate.append(rateSpec).append("元/月");
					rate.append(rateSpec).append(rateDescription);
				}
			}
			else if (isFoundSprom || rateSprom!=null )
			{
				if (isFoundSprom)
					rate.append("0元/月");
				else if (rateSprom != null)
				{
					rateSprom =((long)((rateSprom+0.005)*100))/100.0;
					//rate.append(rateSprom).append("元/月");
					rate.append(rateSprom).append(rateDescription);
				}
			}
			else if (isFoundParam || rateParam!=null)
			{
				if (rateParam != null)
				{
					rateParam =((long)((rateParam+0.005)*100))/100.0;
					//rate.append(rateParam).append("元/月");
					rate.append(rateParam).append(rateDescription);
				}
			}
			else if (isFoundMail || rateMail !=null )
			{
				if (isFoundMail)
					rate.append("0元/月");
				else if (rateMail != null)
				{
					rateMail =((long)((rateMail+0.005)*100))/100.0;
					//rate.append(rateMail).append("元/月");
					rate.append(rateMail).append(rateDescription);
				}
			}
			retXml.append("<servId>").append(servId).append("</servId>")
				.append("<spCode>").append(spCode).append("</spCode>")
				.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
				.append("<rate>").append(rate.toString()).append("</rate>")
				.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
			retXml.append("</item>");
			
		}
		catch (BossException e)
		{
			e.printStackTrace();
//			retXml.append("<retCode>").append(e.getStatusCode()).append("</retCode>")
//			.append("<retInfo>").append( e.getMessage()).append("</retInfo>");
//			retXml.append("<servId>").append(vo.get("servId")).append("</servId>")
//			.append("<spCode>").append(vo.get("spCode")).append("</spCode>")
//			.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
//			.append("<rate/>")
//			.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
			throw e;
		}
		catch (Exception e)
		{
			e.printStackTrace();
//			retXml.append("<retCode>").append(StatusCode.INSIDE_ERROR.getCode()).append("</retCode>")
//			.append("<retInfo>").append( e.getMessage()).append("</retInfo>");
//			retXml.append("<servId>").append(vo.get("servId")).append("</servId>")
//			.append("<spCode>").append(vo.get("spCode")).append("</spCode>")
//			.append("<operCode>").append(vo.get("operCode")).append("</operCode>")
//			.append("<rate/>")
//			.append("<msisdn>").append(vo.get("msisdn")).append("</msisdn>");
			if (e.getMessage()!=null && !"".equals(e.getMessage()))
				throw new BossException(StatusCode.INSIDE_ERROR,e.getMessage());
			else
				throw new BossException(StatusCode.INSIDE_ERROR,e.toString());

		}
		return retXml.toString();
	}
}
