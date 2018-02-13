/**  
 * Project Name:mioa-web  
 * File Name:DeptVO.java  
 * Package Name:com.mjkj.mioa.web.vo.dept  
 * Date:2018年1月30日下午2:40:37  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.dept;  
/**  
 * ClassName:DeptVO   
 * Date:     2018年1月30日 下午2:40:37 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class DeptVO
{
	private String id;

	private String deptpath;

	private String name;

	private String parentid;
	
	private String abbr;
	
	private String telphone;
	
	private String fax;
	
	private String address;
	
	private String parentName;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDeptpath()
	{
		return deptpath;
	}

	public void setDeptpath(String deptpath)
	{
		this.deptpath = deptpath;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getParentid()
	{
		return parentid;
	}

	public void setParentid(String parentid)
	{
		this.parentid = parentid;
	}

	public String getAbbr()
	{
		return abbr;
	}

	public void setAbbr(String abbr)
	{
		this.abbr = abbr;
	}

	public String getTelphone()
	{
		return telphone;
	}

	public void setTelphone(String telphone)
	{
		this.telphone = telphone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}
	
	
}
  
