/**  
 * Project Name:mioa-att  
 * File Name:AttHolidayServiceImpl.java  
 * Package Name:com.mjkj.mioa.att.service.impl  
 * Date:2017年9月13日下午3:45:37  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.mjkj.mioa.att.dao.AttHolidayRepository;
import com.mjkj.mioa.att.entity.TAttHoliday;
import com.mjkj.mioa.att.service.AttHolidayService;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:AttHolidayServiceImpl   
 * Date:     2017年9月13日 下午3:45:37 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        假期服务接口实现类
 */
@Service
public class AttHolidayServiceImpl implements AttHolidayService
{
	@Autowired
	private AttHolidayRepository holidayRepository;
	
	@Override
	public TAttHoliday addHoliday(TAttHoliday holiday) throws MioaException
	{
		Example<TAttHoliday> example = Example.of(holiday, ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase()));
		boolean exists = holidayRepository.exists(example);
		if(exists)
		{
			throw new MioaException("该假期已存在");
		}
		return holidayRepository.save(holiday);
	}
	
	@Override
	public boolean removeHoliday(String id) throws MioaException
	{
		// TODO 需要先判断该假期是否被使用，如果已被使用则不能删除
		holidayRepository.delete(id);
		return false;
	}
	
	@Override
	public boolean updateHoliday(TAttHoliday holiday) throws MioaException
	{
		TAttHoliday dbHoliday = findHolidayById(holiday.getId());
		if(dbHoliday == null)
		{
			throw new MioaException("未找到对应数据");
		}
		holidayRepository.save(holiday);
		return false;
	}
	
	@Override
	public TAttHoliday findHolidayById(String id) throws MioaException
	{
		return holidayRepository.findOne(id);
	}
	
	@Override
	public List<TAttHoliday> findAllHoliday(String domain) throws MioaException
	{
		return holidayRepository.findHolidayByDomain(domain);
	}
	
}
  
