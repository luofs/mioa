/**  
 * Project Name:mioa-web  
 * File Name:SecurityFilter.java  
 * Package Name:com.mjkj.mioa.web.security.vo  
 * Date:2017年11月15日下午11:06:21  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
 */

package com.mjkj.mioa.web.security.filter;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import com.mjkj.mioa.web.security.config.mioaAuthenticationProvider;
import com.mjkj.mioa.web.security.service.CustomAccessDecisionManager;
import com.mjkj.mioa.web.security.service.CustomInvocationSecurityMetadataSourceService;


/**
 * ClassName:SecurityFilter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月15日 下午11:06:21 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.7.0_67
 * @see
 */
@Component
public class SecurityFilter extends AbstractSecurityInterceptor implements Filter
{

	@Autowired
	private CustomInvocationSecurityMetadataSourceService mySecurityMetadataSource;

	@Autowired
	private CustomAccessDecisionManager myAccessDecisionManager;

	private mioaAuthenticationProvider authenticationProvider;

	@PostConstruct
	public void init()
	{
		super.setAuthenticationManager(new AuthenticationManager()
		{
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException
			{
				return authenticationProvider.authenticate(authentication);
			}
		});
		super.setAccessDecisionManager(myAccessDecisionManager);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

	}

	public Class<? extends Object> getSecureObjectClass()
	{
		return FilterInvocation.class;
	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException
	{
		System.out.println("filter..........................");
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try
		{
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally
		{
			super.afterInvocation(token, null);
		}

	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource()
	{
		System.out.println("filtergergetghrthetyetyetyetyj");
		return this.mySecurityMetadataSource;
	}

	public void destroy()
	{
		System.out.println("filter===========================end");
	}

	public void init(FilterConfig filterconfig) throws ServletException
	{
		System.out.println("filter===========================");
	}
}
