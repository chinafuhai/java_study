package com.asiainfo.openPlatform.exception;

public class OpenPlatException extends RuntimeException{
	private String statusCode;
	private String tranCode;

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

	public OpenPlatException(OpenPlatStatusCode openPlatStatusCode) {
		super(openPlatStatusCode.getDescription());
		this.statusCode = openPlatStatusCode.getCode();
	}

	public OpenPlatException(OpenPlatStatusCode openPlatStatusCode, Throwable cause) {
		super(openPlatStatusCode.getDescription(), cause);
		this.statusCode = openPlatStatusCode.getCode();
	}

	public OpenPlatException(OpenPlatStatusCode openPlatStatusCode,
			Throwable cause, String tranCode) {
		super(openPlatStatusCode.getDescription(), cause);
		this.statusCode = openPlatStatusCode.getCode();
		this.tranCode = tranCode;
	}

	public OpenPlatException(OpenPlatException e, String tranCode) {
		super(e.getMessage(), e.getCause());
		this.statusCode = e.getStatusCode();
		this.tranCode = tranCode;
	}

	/**
	 * 返回遍历后异常跟踪信息
	 * 
	 * @return
	 */
	public String getTraceMessage() {
		StringBuffer messages = new StringBuffer();
		Throwable t = this.getCause();
		int i = 1;
		while (t != null) {
			if (t.getMessage() != null && !"".equals(t.getMessage().trim())) {
				messages.append(i++).append("# ").append(t.getMessage())
						.append(". ");
			}
			t = t.getCause();
		}
		return "".equals(messages.toString().trim()) ? null : messages
				.toString();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[").append(this.getStatusCode())
				.append("]").append(this.getMessage()).append(". ");

		if (this.tranCode != null) {
			sb.append("此异常发生在代码(tranCode)为 ").append(this.getTranCode())
					.append(" 的交易中. ");
		}
		if (this.getTraceMessage() != null) {
			sb.append("异常跟踪信息为 ").append(this.getTraceMessage());
		}

		return sb.toString();
	}
}
