/**  
 * Project Name:mioa-web  
 * File Name:UserListVO.java  
 * Package Name:com.mjkj.mioa.web.vo.user  
 * Date:2018年1月23日上午11:18:55  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.user;  

import java.sql.Timestamp;

/**  
 * ClassName:UserListVO   
 * Date:     2018年1月23日 上午11:18:55 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class UserListVO
{
	private String id;
	
	private String realname;
	
	private String name;
	
	private String mobile;
	
	private byte disable = 0;

	private String telephone;

	private Timestamp lastlogintime;
	
	private String lastloginip;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public byte getDisable()
	{
		return disable;
	}

	public void setDisable(byte disable)
	{
		this.disable = disable;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public Timestamp getLastlogintime()
	{
		return lastlogintime;
	}

	public void setLastlogintime(Timestamp lastlogintime)
	{
		this.lastlogintime = lastlogintime;
	}

	public String getLastloginip()
	{
		return lastloginip;
	}

	public void setLastloginip(String lastloginip)
	{
		this.lastloginip = lastloginip;
	}
	
	
}
  
