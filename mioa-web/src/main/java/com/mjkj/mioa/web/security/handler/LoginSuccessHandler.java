/**  
 * Project Name:mioa-web  
 * File Name:LoginSuccessHandler.java  
 * Package Name:com.mjkj.mioa.web.security.handler  
 * Date:2017年11月15日下午10:10:55  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
 */

package com.mjkj.mioa.web.security.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import com.mjkj.mioa.org.entity.TOrgUser;


/**
 * ClassName:LoginSuccessHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月15日 下午10:10:55 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.7.0_67
 * @see
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException
	{
		TOrgUser user = (TOrgUser) authentication.getPrincipal();
		// 输出登录提示信息
		System.out.println("管理员 " + user.getName() + " 登录");
		System.out.println("IP :" + getIpAddress(request));
		super.onAuthenticationSuccess(request, response, authentication);
	}

	public String getIpAddress(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
