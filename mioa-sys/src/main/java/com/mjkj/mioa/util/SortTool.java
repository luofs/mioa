/**  
 * Project Name:mioa-sys  
 * File Name:SortTool.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月14日下午6:00:41  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.mjkj.mioa.common.page.SortBO;

/**  
 * ClassName:SortTool   
 * Date:     2017年9月14日 下午6:00:41 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        排序工具类
 */
public class SortTool
{
	
	/**
	 * TODO 默认按创建时间降序（查询字段中必须要有createtime,否则报错）
	 * @author fsluo  
	 * @return  Sort
	 * @since JDK 1.7
	 */
	public static Sort baseSort()
	{
		return getSort("createtime","desc");
	}
	
	/**
	 * TODO 获取排序对象
	 * @author fsluo  
	 * @param orderField 排序字段
	 * @param orderType 排序类型 asc/desc
	 * @return  
	 * @since JDK 1.7
	 */
	public static Sort getSort(String orderField, String orderType)
	{
		Sort sort = new Sort(Direction.fromStringOrNull(orderType), orderField);
		return sort;
	}
	
	public static Sort getSort(SortBO...sortbos)
	{
		List<Order> orders = new ArrayList<Order>(sortbos.length);
		for (int i = 0; i < sortbos.length; i++)
		{
			SortBO sortbo = sortbos[i];
			Order order = new Order(Direction.fromStringOrNull(sortbo.getOrderType()), sortbo.getOrderField());
			orders.add(order);
		}
		Sort sort = new Sort(orders);
		return sort;
	}
}
  
