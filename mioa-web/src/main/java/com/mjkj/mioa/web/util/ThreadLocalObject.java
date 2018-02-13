/**  
 * Project Name:mioa-web  
 * File Name:ThreadLocalObject.java  
 * Package Name:com.mjkj.mioa.web.util  
 * Date:2018年2月5日下午10:03:21  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.util;  
/**  
 * ClassName:ThreadLocalObject   
 * Date:     2018年2月5日 下午10:03:21 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class ThreadLocalObject
{
	private String userId;

	private String domain;

	private String userEmail;

	private String userMobile;

	private String userName;

	private String userRealName;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getUserMobile()
	{
		return userMobile;
	}

	public void setUserMobile(String userMobile)
	{
		this.userMobile = userMobile;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserRealName()
	{
		return userRealName;
	}

	public void setUserRealName(String userRealName)
	{
		this.userRealName = userRealName;
	}

}
  
