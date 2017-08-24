/**  
 * Project Name:mioa-web  
 * File Name:WebLogAspect.java  
 * Package Name:com.mjkj.mioa.web.aop  
 * Date:2017年8月24日上午11:14:49  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.aop;  

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ch.qos.logback.classic.Logger;

/**  
 * ClassName:WebLogAspect   
 * Date:     2017年8月24日 上午11:14:49 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Aspect
@Order(0)
@Configuration
public class WebLogAspect
{
	private Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	/**
     * 定义一个切入点.
     * 解释下：
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 代表任意方法.
     * ~ 第三个 * 定义在web包或者子包
     * ~ 第四个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
	@Pointcut(" execution ( public * com.mjkj.mioa.web.demo..*.*(..))")
	public void webLog()
	{
		
	}
	
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	startTime.set(System.currentTimeMillis());
    	
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    
    @After("webLog()")
    public void doAfter() throws Throwable
    {
    	log.info("doAfter....");
    }
    
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	log.info("return : " + ret);
    	//打印请求所花的时间
    	log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
    
//    @AfterThrowing
//    public void doAfterThrowing() throws Throwable
//    {
//    	log.info("doAfterThrowing....");
//    }
}
  
