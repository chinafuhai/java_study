package com.asiainfo.report.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.beanutils.LazyDynaMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class XmlParseUtil {
    
	public static List<LazyDynaMap> parseReportXml(String inputXML){
		List<LazyDynaMap> resultList = new ArrayList<LazyDynaMap>();
		try {
			Document document = DocumentHelper.parseText(inputXML);
			Element root = document.getRootElement();
	        for(Iterator i = root.elementIterator(); i.hasNext();){
	        	Element item = (Element)i.next();
	        	if ("item".endsWith(item.getName())) {
	        		LazyDynaMap bean = new LazyDynaMap();
	        		List hallNosList = new ArrayList();
	        		List misItemList = new ArrayList();
	        		List auditItemtList = new ArrayList();
	        		for(Iterator nodes = item.elementIterator();nodes.hasNext();){
	        			Element nodeElement = (Element)nodes.next();
	        			Object[] hallNos = new Object[2];
	        			if("hallNos".endsWith(nodeElement.getName())){
	        				//针对多个营业厅编号情况
	        				for (Iterator child = nodeElement.elementIterator();child.hasNext();) {
								Element hall = (Element)child.next();
								if("hallNo".equals(hall.getName())){
									hallNos[0]=hall.getData();
								}
								if("hallName".equals(hall.getName())){
									hallNos[1]=hall.getData();
								}
							}
	        				hallNosList.add(hallNos);
	        				
	        			}else {
	        				if("dailyAuditItems".endsWith(nodeElement.getName())){
		        				//稽核系统营业员日报保存
		        				Object[] audits = new Object[6];
		        				for (Iterator child = nodeElement.elementIterator();child.hasNext();) {
									Element hall = (Element)child.next();
									if("auditItemsSeqNo".equals(hall.getName())){
										audits[0] = hall.getData();
									}
									if("auditSeqNo".equals(hall.getName())){
										audits[1] = hall.getData();
									}
									if("statisticItem".equals(hall.getName())){
										audits[2] = hall.getData();
									}
									if("itemValue".equals(hall.getName())){
										audits[3] = hall.getData();
									}
									if("extColumn".equals(hall.getName())){
										audits[4] = hall.getData();
									}
									if("itemName".equals(hall.getName())){
										audits[5] = hall.getData();
									}
								}
		        				auditItemtList.add(audits);
		        			}else{
		        				if("dailyMisItems".endsWith(nodeElement.getName())){
			        				//财务营收日报保存
		        					Object[] dailyItem = new Object[9];
			        				for (Iterator child = nodeElement.elementIterator();child.hasNext();) {
										Element dailyMisItem = (Element)child.next();
										
										if("misItemsSeqNo".equals(dailyMisItem.getName())){
											dailyItem[0] = dailyMisItem.getData();
										}
										if("auditSeqNo".equals(dailyMisItem.getName())){
											dailyItem[1] = dailyMisItem.getData();
										}
										if("statisticItem".equals(dailyMisItem.getName())){
											dailyItem[2] = dailyMisItem.getData();
										}
										if("itemValue".equals(dailyMisItem.getName())){
											dailyItem[3] = dailyMisItem.getData();
										}
										if("extColumn".equals(dailyMisItem.getName())){
											dailyItem[4] = dailyMisItem.getData();
										}
										if("itemName".equals(dailyMisItem.getName())){
											dailyItem[5] = dailyMisItem.getData();
										}
										
										if("taxRate".equals(dailyMisItem.getName())){
											dailyItem[6] = dailyMisItem.getData();
										}
										if("taxFee".equals(dailyMisItem.getName())){
											dailyItem[7] = dailyMisItem.getData();
										}
										if("taxOffFee".equals(dailyMisItem.getName())){
											dailyItem[8] = dailyMisItem.getData();
										}
									}
			        				misItemList.add(dailyItem);
			        			}else{
			        				if (!"".equals(nodeElement.getData())) { 
									bean.set(nodeElement.getName(), nodeElement.getData());
								}
			        			}
		        			}
						}
	        			
	        		}
	        		
	        		//各个不同的xml的不同之处
	        		if(misItemList!=null&&misItemList.size()>0){
	        			bean.set("dailyMisItems", misItemList);
	        		}
	        		if(auditItemtList!=null&&auditItemtList.size()>0){
	        			bean.set("dailyAuditItems", auditItemtList);
	        		}
	        		if(hallNosList!=null&&hallNosList.size()>0){
	        			if(hallNosList.size()==1){
	        				Object[] temp = (Object[])hallNosList.get(0);
	        				bean.set("hallNo", (String)temp[0]);
	        				bean.set("hallName",(String)temp[1]);
	        			}else{
	        				bean.set("hallNos", hallNosList);
	        			}
	        		}
	        		
	        		resultList.add(bean);
	        	}
	        	
	        }
			return resultList;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
			try {
				String inputxml= "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DailyMis><item><tranCode>123</tranCode><hallNo>111</hallNo><hallNos><itemName>001</itemName><itemValue>002</itemValue></hallNos><hallNos><itemName>003</itemName><itemValue>004</itemValue></hallNos></item></DailyMis>";
				Document document = DocumentHelper.parseText(inputxml);


				List<LazyDynaMap> voList=XmlParseUtil.parseReportXml(inputxml);
				for(LazyDynaMap map:voList){
				LazyDynaMap vo = (LazyDynaMap) voList.get(0);
				System.out.println(map.get("tranCode"));
				System.out.println(map.get("hallNo"));
				List has= (List)map.get("hallNos");
				for(int n=0;n<has.size();n++){
					List temp=(List)has.get(n);
					for(int i=0;i<temp.size();i++){
						Object[] f = (Object[])temp.get(i);
						System.out.println(f[0]+"===="+f[1]);
					}
				}
}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	}
	
}
