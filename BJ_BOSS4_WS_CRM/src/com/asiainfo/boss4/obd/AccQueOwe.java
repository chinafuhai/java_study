package com.asiainfo.boss4.obd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.obd.MObdCommonSOBSessionProperty;
import com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFee;
import com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFeeService;
import com.asiainfo.obd.ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator;
import com.asiainfo.obd.holders.MObdCommonSCbsErrorMsgHolder;

public class AccQueOwe {
	private static Log logger = LogFactory.getLog(AccQueOwe.class);

	/**
	 * 查询指定手机号码的余额
	 * @param number
	 * @return 单位是分
	 */
	public static long queryOwe(String number) {
		javax.xml.rpc.holders.LongHolder llPreMonthFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llCurMonthFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llRealTimeFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llBookAmt = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llBookSub = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llSpecBook = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llTransInBook = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llCreditBook = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontPreMonthFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontCurMonthFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontRealTimeFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontBookAmt = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontBookSub = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontSpecBook = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.LongHolder llFrontTransInBook = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.ShortHolder nMonth = new javax.xml.rpc.holders.ShortHolder();
		javax.xml.rpc.holders.IntHolder iCreditValue = new javax.xml.rpc.holders.IntHolder();
		javax.xml.rpc.holders.LongHolder llBillMonthFee = new javax.xml.rpc.holders.LongHolder();
		javax.xml.rpc.holders.StringHolder strCurMonth = new javax.xml.rpc.holders.StringHolder();
		javax.xml.rpc.holders.StringHolder dtmExpDate = new javax.xml.rpc.holders.StringHolder();
		javax.xml.rpc.holders.StringHolder strUserSts = new javax.xml.rpc.holders.StringHolder();
		ObIdl_MAccQuickQryFee_IAccQuickQryFeeService qmis = new ObIdl_MAccQuickQryFee_IAccQuickQryFeeServiceLocator();
		try {
			ObIdl_MAccQuickQryFee_IAccQuickQryFee qmi = qmis
					.getObIdl_MAccQuickQryFeeIAccQuickQryFeePort();
			MObdCommonSOBSessionProperty[] sSession = new MObdCommonSOBSessionProperty[1];
			sSession[0] = new MObdCommonSOBSessionProperty();
			sSession[0].setM_strName("");
			sSession[0].setM_strValue("");
			String strPhoneId = number;
			long llAcctId = (long) 0;
			short nRealTimeFeeFlag = (short) 1;
			short nItemType = (short) 1;
			MObdCommonSCbsErrorMsgHolder sErrorMsg = new MObdCommonSCbsErrorMsgHolder();

			qmi.query_userOweFee(sSession, strPhoneId, llAcctId,
					nRealTimeFeeFlag, nItemType, llPreMonthFee, llCurMonthFee,
					llRealTimeFee, llBookAmt, llBookSub, llSpecBook,
					llTransInBook, llCreditBook, llFrontPreMonthFee,
					llFrontCurMonthFee, llFrontRealTimeFee, llFrontBookAmt,
					llFrontBookSub, llFrontSpecBook, llFrontTransInBook,
					nMonth, iCreditValue, llBillMonthFee, strCurMonth,
					dtmExpDate, strUserSts, sErrorMsg);
//			logger.debug("llBookSub:" + llBookSub.value);
//			logger.debug("llBookAmt:" + llBookAmt.value);
//			logger.debug("llSpecBook:" + llSpecBook.value);
//			logger.debug("llTransInBook:" + llTransInBook.value);
//			logger.debug("llCreditBook:" + llCreditBook.value);
//			logger.debug("llFrontPreMonthFee:" + llFrontPreMonthFee.value);
//			logger.debug("llFrontCurMonthFee:" + llFrontCurMonthFee.value);
//			logger.debug("llFrontRealTimeFee:" + llFrontRealTimeFee.value);
//			logger.debug("llFrontBookAmt:" + llFrontBookAmt.value);
//			logger.debug("llFrontBookSub:" + llFrontBookSub.value);
//			logger.debug("llFrontSpecBook:" + llFrontSpecBook.value);
//			logger.debug("llFrontTransInBook:" + llFrontTransInBook.value);
//			logger.debug("nMonth:" + nMonth.value);
//			logger.debug("iCreditValue:" + iCreditValue.value);
//			logger.debug("llBillMonthFee:" + llBillMonthFee.value);
//			logger.debug("strCurMonth:" + strCurMonth.value);
//			logger.debug("dtmExpDate:" + dtmExpDate.value);
//
//			logger.debug(((llBookSub.value + llBookAmt.value + llTransInBook.value) - (llPreMonthFee.value
//					+ llCurMonthFee.value + llRealTimeFee.value)) / 100);
			
			logger.debug("CODE:" + sErrorMsg.value.getM_iErrorCode());
			logger.debug("MSG:" + sErrorMsg.value.getM_strErrorMsg());
		} catch (Exception e) {
			throw new BossException(StatusCode.CALL_OBD_SERVICE_ERROR, e);
		}
		return ((llBookSub.value + llBookAmt.value + llTransInBook.value) - (llPreMonthFee.value
				+ llCurMonthFee.value + llRealTimeFee.value));

	}

}
