/**  
 * Project Name:mioa-org  
 * File Name:OrgDepartmentServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年9月15日上午11:22:31  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgDepartmentRepository;
import com.mjkj.mioa.org.entity.TOrgDepartment;
import com.mjkj.mioa.org.service.OrgDepartmentService;

/**  
 * ClassName:OrgDepartmentServiceImpl   
 * Date:     2017年9月15日 上午11:22:31 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see       部门服务接口 
 */
@Service
public class OrgDepartmentServiceImpl implements OrgDepartmentService
{

	@Autowired
	private OrgDepartmentRepository departmentRepository;
	
	@Override
	public TOrgDepartment addDepartment(TOrgDepartment department)
			throws MioaException
	{
		TOrgDepartment dbDepartment = departmentRepository.findDepartmentByNameAndParentid(department.getName(), department.getParentid());
		if (dbDepartment != null)
		{
			throw new MioaException("该部门已存在");
		}
		return departmentRepository.save(dbDepartment);
	}

	@Override
	public boolean removeDepartment(String id) throws MioaException
	{
		if (! departmentRepository.exists(id))
		{
			return false;
		}
		departmentRepository.delete(id);
		return true;
	}

	@Override
	public boolean updateDepartment(TOrgDepartment department)
			throws MioaException
	{
		TOrgDepartment dbDepartment = departmentRepository.findOne(department.getId());
		if (dbDepartment == null)
		{
			throw new MioaException("未找到对应部门信息");
		}
		departmentRepository.save(department);
		return true;
	}

	@Override
	public TOrgDepartment findDepartmentById(String id) throws MioaException
	{
		return departmentRepository.findOne(id);
	}

	@Override
	public List<TOrgDepartment> findAllDepartment(String domain)
			throws MioaException
	{
		return departmentRepository.findAllByDomain(domain);
	}
	
}
  
