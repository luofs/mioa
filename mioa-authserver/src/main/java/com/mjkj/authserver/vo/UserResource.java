/**  
 * Project Name:mioa-authserver  
 * File Name:UserResource.java  
 * Package Name:com.mjkj.authserver.vo  
 * Date:2018年2月5日下午5:05:16  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.vo;  

import java.sql.Timestamp;

/**  
 * ClassName:UserResource   
 * Date:     2018年2月5日 下午5:05:16 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class UserResource
{
	private String id;

	private String domain;

	private String email;

	private String mobile;

	private String name;

	private String realname;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}
	
	


}
  
