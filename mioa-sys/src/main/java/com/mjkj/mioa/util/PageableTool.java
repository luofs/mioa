/**  
 * Project Name:mioa-sys  
 * File Name:PageableTool.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月15日上午9:46:22  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mjkj.mioa.common.page.SortBO;

/**  
 * ClassName:PageableTool   
 * Date:     2017年9月15日 上午9:46:22 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        分页工具
 */
public class PageableTool
{
	
	/**
	 * 默认分页条数
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * TODO 获取基础分页对象
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示条数
	 * @param sortbos 排序对象数组
	 * @return  Pageable
	 * @since JDK 1.7
	 */
	public static Pageable getBasicPage(int page, int pageSize, SortBO...sortbos)
	{
		Sort sort = SortTool.getSort(sortbos);
		page = page<0?0:page;
		pageSize = pageSize<=0?DEFAULT_PAGE_SIZE:pageSize;
		Pageable pageable = new PageRequest(page, pageSize, sort);
		return pageable;
	}
	
	/**
	 * TODO 只传页数，显示 DEFAULT_PAGE_SIZE条数据
	 * @author fsluo  
	 * @param page 第几页
	 * @param sortbos 排序对象
	 * @return  Pageable
	 * @since JDK 1.7
	 */
	public static Pageable getPage(int page, SortBO...sortbos)
	{
		return getBasicPage(page, 0, sortbos);
	}
	
	/**
	 * TODO
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示条数
	 * @param orderField 排序字段
	 * @param orderType 排序类型
	 * @return  
	 * @since JDK 1.7
	 */
	public static Pageable getPage(int page, int pageSize, String orderField, String orderType)
	{
		SortBO sortbo = new SortBO(orderType, orderField);
		return getBasicPage(page, pageSize, sortbo);
	}
	
	/**
	 * 
	 * TODO 只传页数和排序字段，默认降序
	 * @author fsluo  
	 * @param page 第几页
	 * @param orderField 排序字段
	 * @return  
	 * @since JDK 1.7
	 */
	public static Pageable getPage(int page, String orderField)
	{
		SortBO sortbo = new SortBO("desc", orderField);
		return getBasicPage(page, 0, sortbo);
	}
}
  
