package com.asiainfo.boss4.exception;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;

/**
 * 基础应用异常
 * 
 * @author caohui
 *
 */
public class BossException extends RuntimeException {
	private static Log logger = LogFactory.getLog(BossException.class);
	
	private static final long serialVersionUID = -2647588658466977435L;

	private StatusCode status;
	private String statusCode;
	private String tranCode;
	private String sid;
	private String entityName;
	private Map<String, Object> queryResult;
	
	public Map<String, Object> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(Map<String, Object> queryResult) {
		this.queryResult = queryResult;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public BossException(StatusCode statusCode) {
		super(statusCode.getDescription());
		this.status = statusCode;
		this.statusCode = statusCode.getCode();
	}
	
	public BossException(StatusCode statusCode, String message) {
		super(message);
		this.status = statusCode;
		this.statusCode = statusCode.getCode();
	}

	public BossException(StatusCode statusCode, Throwable cause) {
		super(statusCode.getDescription(), cause);
		this.status = statusCode;
		this.statusCode = statusCode.getCode();
	}

	public BossException(StatusCode statusCode, Throwable cause,
			String tranCode, String sid) {
		super(statusCode.getDescription(), cause);
		this.status = statusCode;
		this.statusCode = statusCode.getCode();
		this.tranCode = tranCode;
		this.sid = sid;
	}
	
	public BossException(StatusCode statusCode, Throwable cause, String message) {
		super(message, cause);
		this.status = statusCode;
		this.statusCode = statusCode.getCode();
	}

	public BossException(BossException e, String tranCode, String sid) {
		super(e.getMessage(), e);
		this.status = e.getStatus();
		this.statusCode = e.getStatusCode();
		this.tranCode = tranCode;
		this.sid = sid;
	}

	/**
	 * 返回遍历后异常跟踪信息
	 * @return
	 */
	public String getTraceMessage() {
		StringBuffer messages = new StringBuffer();
		Throwable t = this.getCause();
		int i = 1;
		while (t != null) {
			if (t.getMessage() != null && !"".equals(t.getMessage().trim())) {
				messages.append(i++).append("# ").append(t.getMessage()).append(". ");
			}
			t = t.getCause();
		}
		return "".equals(messages.toString().trim()) ? null : messages.toString();
	}
	
	/**
	 * 输出响应报文的报错信息描述
	 * @return
	 */
	public String buildResponseDescription() {
		StringBuffer errorMessage = new StringBuffer(this.getMessage()).append(". ");
		if (this.tranCode != null)
			errorMessage.append("[").append(this.tranCode).append("] ");
		if (this.getTraceMessage() != null)
			errorMessage.append("详细异常信息：").append(this.getTraceMessage());
		
		return errorMessage.toString();
	}
	
	public String toString() {
		StringBuffer sb =  new StringBuffer("[").append(this.getStatusCode()).append("]")
				.append(this.getMessage()).append(". ");
		
		if (this.tranCode != null) {
			sb.append("TRANCODE=> ").append(this.getTranCode()).append(". ");
		}
//		if (this.sid != null) {
//			sb.append("消息编号(SID)为 ").append(this.getSid()).append(". ");
//		}
		if (this.getTraceMessage() != null) {
			sb.append("TRACE MESSAGE=> ").append(this.getTraceMessage());
		}
		
		return sb.toString();
	}
	
	public void handle(ServiceContext context, BaseEntity entity) {
		//家庭网拆网套餐不存在报错时，判断如果已经销户，直接返回
		if (StatusCode.QUERY_ENTITY_NONE_ERROR.equals(this.getStatus()) 
				&& TranCode.DISMISS_HOME_GROUP_CANCEL_SPROM_SPECIAL_HANDLE.equals(context.getTranCode())
				&& (entity instanceof IUserSprom || entity instanceof ISpromParam)
				) {
			logger.debug("handle BossException => " + this);
			Long servId = (Long) BeanCopyHelper.getProperty(entity, "servId");
			List<IUserAll> users = IUserAll.queryByServId(context, IUserAll.class, servId);
			if (users.size() == 0) {
				logger.warn(entity.getClass().getSimpleName() + " does not exists. This operation is ignored. =>" + entity);
				return;
			}
		}
		throw this;
	}

}
