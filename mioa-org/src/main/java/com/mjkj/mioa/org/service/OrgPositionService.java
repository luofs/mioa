/**  
 * Project Name:mioa-org  
 * File Name:OrgPositionService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年9月15日上午11:32:53  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgPosition;

/**  
 * ClassName:OrgPositionService   
 * Date:     2017年9月15日 上午11:32:53 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        组织机构岗位服务接口
 */
public interface OrgPositionService
{
	
	/**
	 *  添加岗位信息
	 * @author fsluo  
	 * @param position 岗位实体
	 * @return TOrgPosition岗位实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TOrgPosition addPosition(TOrgPosition position) throws MioaException;
	
	/**
	 *  删除岗位信息
	 * @author fsluo  
	 * @param id 主键
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removePosition(String id) throws MioaException;
	
	/**
	 * 更新岗位信息
	 * @author fsluo  
	 * @param position 岗位实体
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updatePosition(TOrgPosition position) throws MioaException;
	
	/**
	 *  根据主键查询实体信息
	 * @author fsluo  
	 * @param id 主键
	 * @return TOrgPosition岗位实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TOrgPosition findPositionById(String id) throws MioaException;
	
	/**
	 * 	查询域下所有岗位（已删除的不查询）
	 * @author fsluo  
	 * @param domain 域
	 * @return List<TOrgPosition>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public List<TOrgPosition> findPositionByDomain(String domain) throws MioaException;
	
}
  
