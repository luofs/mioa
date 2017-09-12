/**  
 * Project Name:mioa-att  
 * File Name:AttPlanServiceImpl.java  
 * Package Name:com.mjkj.mioa.att.service.impl  
 * Date:2017年9月4日下午3:42:53  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.mjkj.mioa.att.dao.AttPlanRepository;
import com.mjkj.mioa.att.entity.TAttPlan;
import com.mjkj.mioa.att.service.AttPlanService;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:AttPlanServiceImpl   
 * Date:     2017年9月4日 下午3:42:53 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7  
 * @see        排班服务接口实现类
 */
public class AttPlanServiceImpl implements AttPlanService
{
	
	@Autowired
	private AttPlanRepository planRepository;
	
	@Override
	public TAttPlan addAttPlan(TAttPlan plan) throws MioaException
	{
		return planRepository.save(plan);
	}
	
	@Override
	public boolean removeAttPlan(String id) throws MioaException
	{
		planRepository.delete(id); 
		return true;
	}
	
	@Override
	public boolean updateAttPlan(TAttPlan plan) throws MioaException
	{
		planRepository.save(plan);
		return false;
	}
	
	@Override
	public TAttPlan findAttPlanById(String id)
	{
		return planRepository.findOne(id);
	}
	
	@Override
	public Page<TAttPlan> findAttPlanPage(int page, int pageSize)
	{
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, pageSize, sort);
		return planRepository.findAll(pageable);
	}
	
}
  
