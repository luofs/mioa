/**  
 * Project Name:mioa-att  
 * File Name:AttHolidayService.java  
 * Package Name:com.mjkj.mioa.att.service  
 * Date:2017年9月13日下午3:38:07  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service;  

import java.util.List;

import com.mjkj.mioa.att.entity.TAttHoliday;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:AttHolidayService   
 * Date:     2017年9月13日 下午3:38:07 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        假期服务接口
 */
public interface AttHolidayService
{
	
	/**
	 * TODO 添加假期定义
	 * @author fsluo  
	 * @param holiday
	 * @return TAttHoliday
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttHoliday addHoliday(TAttHoliday holiday) throws MioaException;
	
	/**
	 * TODO 移除假期定义
	 * @author fsluo  
	 * @param id
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removeHoliday(String id) throws MioaException;
	
	/**
	 * TODO 修改假期定义
	 * @author fsluo  
	 * @param holiday
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateHoliday(TAttHoliday holiday) throws MioaException;
	
	/**
	 * TODO 根据主键查询假期定义
	 * @author fsluo  
	 * @param id 主键
	 * @return TAttHoliday
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttHoliday findHolidayById(String id) throws MioaException;
	
	/**
	 * TODO 查询所有假期定义
	 * @author fsluo  
	 * @param domain
	 * @return List<TAttHoliday>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public List<TAttHoliday> findAllHoliday(String domain) throws MioaException;
}
  
