/**  
 * Project Name:mioa-org  
 * File Name:OrgUserTO.java  
 * Package Name:com.mjkj.mioa.org.to  
 * Date:2018年2月12日上午11:50:43  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.to;  

import java.util.Map;

/**  
 * ClassName:OrgUserTO   
 * Date:     2018年2月12日 上午11:50:43 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class OrgUserTO
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
	
	/**
	 * 域
	 */
	private String domain;
	
	/**
	 * 用户岗位集合
	 * key 为部门id，value为岗位id
	 */
	private Map<String, String> deptPositmap;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

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

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	public Map<String, String> getDeptPositmap()
	{
		return deptPositmap;
	}

	public void setDeptPositmap(Map<String, String> deptPositmap)
	{
		this.deptPositmap = deptPositmap;
	}
	
	
}
  
