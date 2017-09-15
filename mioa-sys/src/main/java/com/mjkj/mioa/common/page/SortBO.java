/**  
 * Project Name:mioa-sys  
 * File Name:SortBO.java  
 * Package Name:com.mjkj.mioa.common.page  
 * Date:2017年9月14日下午5:52:24  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common.page;  

import org.springframework.util.StringUtils;

/**  
 * ClassName:SortBO   
 * Date:     2017年9月14日 下午5:52:24 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class SortBO
{
	
	/**
	 * 排序类型 asc/desc
	 */
	private String orderType;
	/**
	 * 排序字段
	 */
	private String orderField;
	
	public SortBO(String orderType, String orderField)
	{
		this.orderField = orderField;
		if(StringUtils.isEmpty(orderField))
		{
			this.orderField = "desc";
		}
		else{
			this.orderType = orderType;
		}
	}
	//没传默认降序
	public SortBO(String orderField)
	{
		this.orderField = orderField;
		this.orderType = "desc";
	}
	
	
	/*************************以下get set*******************************/
	public String getOrderType()
	{
		return orderType;
	}
	public void setOrderType(String orderType)
	{
		this.orderType = orderType;
	}
	public String getOrderField()
	{
		return orderField;
	}
	public void setOrderField(String orderField)
	{
		this.orderField = orderField;
	}
	
	
}
  
