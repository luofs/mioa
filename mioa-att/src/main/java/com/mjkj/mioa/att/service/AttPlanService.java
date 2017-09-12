/**  
 * Project Name:mioa-att  
 * File Name:AttPlanService.java  
 * Package Name:com.mjkj.mioa.att.service  
 * Date:2017年9月4日下午3:34:32  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service;  

import org.springframework.data.domain.Page;

import com.mjkj.mioa.att.entity.TAttPlan;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:AttPlanService   
 * Date:     2017年9月4日 下午3:34:32 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7  
 * @see        排班服务接口
 */
public interface AttPlanService
{
	/**
	 * TODO 新增考勤排班
	 * @author fsluo  
	 * @param plan 排班计划
	 * @return 排班实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttPlan addAttPlan(TAttPlan plan) throws MioaException;
	
	/**
	 * TODO 移除排班
	 * @author fsluo  
	 * @param id 主键
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removeAttPlan(String id) throws MioaException;
	
	/**
	 * TODO 更改排班信息
	 * @author fsluo  
	 * @param plan 排班实体
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateAttPlan(TAttPlan plan) throws MioaException;
	
	/**
	 * TODO 查询排班信息
	 * @author fsluo  
	 * @param id 主键
	 * @return  排班实体
	 * @since JDK 1.7
	 */
	public TAttPlan findAttPlanById(String id);
	
	/**
	 * TODO 分页查询排班信息
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示行数
	 * @return  Page<TAttPlan>
	 * @since JDK 1.7
	 */
	public Page<TAttPlan> findAttPlanPage(int page, int pageSize);
}
  
