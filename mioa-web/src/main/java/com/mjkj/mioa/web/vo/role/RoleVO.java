/**  
 * Project Name:mioa-web  
 * File Name:RoleVOid.java  
 * Package Name:com.mjkj.mioa.web.vo.role  
 * Date:2018年2月12日下午2:30:35  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.role;  
/**  
 * ClassName:RoleVOid   
 * Date:     2018年2月12日 下午2:30:35 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class RoleVO
{
	
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色描述
	 */
	private String descr;

	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescr()
	{
		return descr;
	}

	public void setDescr(String descr)
	{
		this.descr = descr;
	}
	
	
}
  
