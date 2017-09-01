/**  
 * Project Name:mioa-att  
 * File Name:WorkDayServiceImpl.java  
 * Package Name:com.mjkj.mioa.att.service.impl  
 * Date:2017年9月1日上午10:02:21  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mjkj.mioa.att.dao.WorkDayRepository;
import com.mjkj.mioa.att.entity.TAttWorkday;
import com.mjkj.mioa.att.service.WorkDayService;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:WorkDayServiceImpl   
 * Date:     2017年9月1日 上午10:02:21 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7  
 * @see        工作日调整服务接口实现类
 */
@Service
public class WorkDayServiceImpl implements WorkDayService
{
	
	@Autowired
	private WorkDayRepository workDayRepository;
	
	@Override
	public TAttWorkday addWorkDay(TAttWorkday workDay) throws MioaException
	{
		
		if(existsWorkDay(workDay))
		{
			throw new MioaException("已存在重复的工作日设置");
		}
		return workDayRepository.save(workDay);
	}
	
	@Override
	public boolean removeWorkDay(String id) throws MioaException
	{
		if(workDayRepository.isPassWorkDay(id))
		{
			throw new MioaException("该规则已生效，不能删除");
		}
		workDayRepository.delete(id);
		return true;
	}
	
	@Override
	public boolean updateWorkDay(TAttWorkday workDay) throws MioaException
	{
		if(workDayRepository.isPassWorkDay(workDay.getId()))
		{
			throw new MioaException("该规则已生效，不能更改");
		}
		workDayRepository.save(workDay);
		return true;
	}
	
	@Override
	public TAttWorkday findWorkDayById(String id) throws MioaException
	{
		return workDayRepository.findOne(id);
	}
	
	@Override
	public Page<TAttWorkday> findWorkDayByPage(int page, int pageSize)
			throws MioaException
	{
		Sort sort = new Sort(Direction.DESC,"enddate");
		Pageable pageable = new PageRequest(page, pageSize, sort);
		Page<TAttWorkday> result = workDayRepository.findAll(pageable);
		return result;
	}
	
	//-------------------------------------私有方法-------------------------------------------------//
	
	private boolean existsWorkDay(TAttWorkday workDay)
	{
		  
		Example<TAttWorkday> example = Example.of(workDay);
		return workDayRepository.exists(example);
	}

	
}
  
