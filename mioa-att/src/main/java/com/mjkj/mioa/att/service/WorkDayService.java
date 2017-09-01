/**  
 * Project Name:mioa-att  
 * File Name:WorkDayService.java  
 * Package Name:com.mjkj.mioa.att.service  
 * Date:2017年9月1日上午9:54:41  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service;  

import org.springframework.data.domain.Page;

import com.mjkj.mioa.att.entity.TAttWorkday;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:WorkDayService   
 * Date:     2017年9月1日 上午9:54:41 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7  
 * @see        工作日调整服务接口
 */
public interface WorkDayService
{
	/**
	 * TODO 添加工作日设置
	 * @author fsluo  
	 * @param workDay 工作日设置实体类
	 * @return 工作日设置实体类TAttWorkday
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttWorkday addWorkDay(TAttWorkday workDay) throws MioaException;
	
	/**
	 * TODO 移除工作日设置
	 * @author fsluo  
	 * @param id 主键
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removeWorkDay(String id) throws MioaException;
	
	/**
	 * TODO 修改工作日设置
	 * @author fsluo  
	 * @param workDay
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateWorkDay(TAttWorkday workDay) throws MioaException;
	
	/**
	 * TODO 根据主键查询工作日设置记录(需判空)
	 * @author fsluo  
	 * @param id
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttWorkday findWorkDayById(String id) throws MioaException;
	
	/**
	 * TODO 分页查询工作日设置
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示调试
	 * @return 分页结果Page<TAttWorkday>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public Page<TAttWorkday> findWorkDayByPage(int page, int pageSize) throws MioaException;
	
	
}
  
