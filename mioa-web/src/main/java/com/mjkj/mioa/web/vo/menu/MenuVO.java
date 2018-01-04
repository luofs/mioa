/**  
 * Project Name:mioa-web  
 * File Name:MenuVO.java  
 * Package Name:com.mjkj.mioa.web.vo.menu  
 * Date:2018年1月4日下午4:18:33  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.menu;  

import java.util.List;

/**  
 * ClassName:MenuVO   
 * Date:     2018年1月4日 下午4:18:33 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class MenuVO
{
	private String id;
	
	private String pid;
	
	private String title;
	
	private String icon;
	
	private String url;
	
	private boolean spread;
	
	private List<MenuVO> children;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public boolean isSpread()
	{
		return spread;
	}

	public void setSpread(boolean spread)
	{
		this.spread = spread;
	}

	public List<MenuVO> getChildren()
	{
		return children;
	}

	public void setChildren(List<MenuVO> children)
	{
		this.children = children;
	}
	
	
}
  
