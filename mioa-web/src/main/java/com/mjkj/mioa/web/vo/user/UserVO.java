/**  
 * Project Name:mioa-web  
 * File Name:UserVO.java  
 * Package Name:com.mjkj.mioa.web.vo.user  
 * Date:2017年11月15日下午5:22:45  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.user;  


/**  
 * ClassName:UserVO   
 * Date:     2017年11月15日 下午5:22:45 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class UserVO
{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 联系地址
	 */
	private String address;

	/**
	 * 联系邮箱
	 */
	private String email;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 账户
	 */
	private String name;

	/**
	 * 姓名
	 */
	private String realname;

	/**
	 * 性别
	 */
	private byte sex;

	/**
	 * 座机
	 */
	private String telephone;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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

	public byte getSex()
	{
		return sex;
	}

	public void setSex(byte sex)
	{
		this.sex = sex;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	

}
  
