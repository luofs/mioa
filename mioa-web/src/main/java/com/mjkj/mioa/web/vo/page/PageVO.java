/**  
 * Project Name:mioa-web  
 * File Name:PageVOid.java  
 * Package Name:com.mjkj.mioa.web.vo.page  
 * Date:2018年1月25日上午9:15:09  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.page;  
/**  
 * ClassName:PageVOid   
 * Date:     2018年1月25日 上午9:15:09 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class PageVO
{
	/**
	 * 第几页（默认首页）
	 */
	private int page = 1;
	
	/**
	 * 每页显示条数（默认每页10条）
	 */
	private int limit = 10;

	public int getPage()
	{
		return page - 1;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getLimit()
	{
		return limit;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}
	
	
}
  
