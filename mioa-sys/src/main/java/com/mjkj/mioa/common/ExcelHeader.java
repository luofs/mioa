/**  
 * Project Name:mioa-sys  
 * File Name:ExcelHeader.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年9月14日下午4:40:51  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
 */

package com.mjkj.mioa.common;

/**
 * ClassName:ExcelHeader Date: 2017年9月14日 下午4:40:51
 * 
 * @author fsluo
 * @version 1.0
 * @since JDK 1.7
 * @see excel表头信息用于自动生成表头结构及排序
 */
public class ExcelHeader implements Comparable<ExcelHeader>
{
	/**
	 * excel的标题名称
	 */
	private String title;
	/**
	 * 每一个标题的顺序
	 */
	private int order;
	/**
	 * 说对应方法名称
	 */
	private String methodName;
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getOrder()
	{
		return order;
	}
	
	public void setOrder(int order)
	{
		this.order = order;
	}
	
	public String getMethodName()
	{
		return methodName;
	}
	
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	
	public int compareTo(ExcelHeader o)
	{
		return order > o.order ? 1 : (order < o.order ? -1 : 0);
	}
	
	public ExcelHeader(String title, int order, String methodName)
	{
		super();
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}
}
