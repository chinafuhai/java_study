package com.asiainfo.boss4.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.AuthenticationCredentialsNotFoundException;
import org.springframework.security.AuthenticationException;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.context.SecurityContextHolder;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.XmlHelper;

public class AuthAdvice {
	private Log logger = LogFactory.getLog(AuthAdvice.class);
	
	public Object authOnAction(ProceedingJoinPoint pjp) throws Throwable {
		String inputXml = (String) pjp.getArgs()[0];
		
		// 注册用户验证信息
		SecurityContextHolder.getContext().setAuthentication(XmlHelper.parseAuthInfo(inputXml));
		Object retVal = null;
		try {
			retVal = pjp.proceed();
			
		} catch(AuthenticationCredentialsNotFoundException e) {
			logger.error("用户尚未登录，无法进行认证");
			throw new BossException(StatusCode.AUTH_FAIL_ERROR, e);
		} catch (BadCredentialsException e) {
			logger.error("用户名或密码错误，无法通过认证");
			throw new BossException(StatusCode.AUTH_FAIL_ERROR, e);
		} catch (AccessDeniedException e) {
			logger.error("用户已登录，但是没有访问当前资源的权限");
			throw new BossException(StatusCode.AUTH_FAIL_ERROR, e);
		} catch (AuthenticationException e) {
			logger.error("验证服务出现异常");
			throw new BossException(StatusCode.AUTH_FAIL_ERROR, e);
		} 
		
	    return retVal;
	}
}
