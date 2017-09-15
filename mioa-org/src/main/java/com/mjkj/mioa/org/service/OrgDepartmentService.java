/**  
 * Project Name:mioa-org  
 * File Name:OrgDepartmentService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年9月15日上午11:14:17  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgDepartment;

/**  
 * ClassName:OrgDepartmentService   
 * Date:     2017年9月15日 上午11:14:17 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        组织机构部门服务接口
 */
public interface OrgDepartmentService
{
	/**
	 *  添加部门
	 * @author fsluo  
	 * @param department
	 * @return TOrgDepartment
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TOrgDepartment addDepartment(TOrgDepartment department) throws MioaException;
	
	/**
	 *  移除部门
	 * @author fsluo  
	 * @param id 主键
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removeDepartment(String id) throws MioaException;
	
	/**
	 *  更新部门信息
	 * @author fsluo  
	 * @param department 部门实体（该实体id必须要有值）
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateDepartment(TOrgDepartment department) throws MioaException;
	
	/**
	 *  根据主键查询部门信息，需判空
	 * @author fsluo  
	 * @param id 主键
	 * @return TOrgDepartment实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TOrgDepartment findDepartmentById(String id) throws MioaException;
	
	/**
	 *  查询域下所有部门信息
	 * @author fsluo  
	 * @param domain
	 * @return List<TOrgDepartment>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public List<TOrgDepartment> findAllDepartment(String domain) throws MioaException;
}
  
