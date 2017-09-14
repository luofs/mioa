/**  
 * Project Name:mioa-att  
 * File Name:ImmunityService.java  
 * Package Name:com.mjkj.mioa.att.service  
 * Date:2017年8月30日下午12:21:43  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service;  

import org.springframework.data.domain.Page;

import com.mjkj.mioa.att.entity.TAttImmunity;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:ImmunityService   
 * Date:     2017年8月30日 下午12:21:43 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        豁免设置服务
 */
public interface AttImmunityService
{
	/**
	 * TODO 保存豁免设置
	 * @author fsluo  
	 * @param immunity 保存实体
	 * @return  实体对象TAttImmunity
	 * @since JDK 1.7
	 */
	public TAttImmunity addImmunity(TAttImmunity immunity) throws MioaException;
	
	/**
	 * TODO 移除豁免规则
	 * @author fsluo  
	 * @param id 主键
	 * @return  true/false
	 * @since JDK 1.7
	 */
	public boolean removeImmunity(String id) throws MioaException;
	
	/**
	 * TODO 更新豁免规则
	 * @author fsluo  
	 * @param immunity
	 * @return  true/false
	 * @since JDK 1.7
	 */
	public boolean updateImmunity(TAttImmunity immunity) throws MioaException;
	
	/**
	 * 
	 * TODO 根据主键查询实体对象TAttImmunity（需判空）
	 * @author fsluo  
	 * @param id 主键
	 * @return  实体对象TAttImmunity
	 * @since JDK 1.7
	 */
	public TAttImmunity findImmunityById(String id);
	
	/**
	 * TODO 分页查询豁免规则
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示记录数
	 * @return  实体集合 Page<TAttImmunity>
	 * @since JDK 1.7
	 */
	public Page<TAttImmunity> findImmunityPage(int page, int pageSize);
	
}
  
