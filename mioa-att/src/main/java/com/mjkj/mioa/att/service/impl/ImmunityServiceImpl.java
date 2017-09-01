/**  
 * Project Name:mioa-att  
 * File Name:ImmunityServiceImpl.java  
 * Package Name:com.mjkj.mioa.att.service.impl  
 * Date:2017年8月30日下午12:24:48  
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

import com.mjkj.mioa.att.dao.ImmunityRepository;
import com.mjkj.mioa.att.entity.TAttImmunity;
import com.mjkj.mioa.att.service.ImmunityService;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:ImmunityServiceImpl   
 * Date:     2017年8月30日 下午12:24:48 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.6  
 * @see     豁免设置服务实现   
 */
@Service
public class ImmunityServiceImpl implements ImmunityService
{
	@Autowired
	private ImmunityRepository immRepository;

	@Override
	public TAttImmunity addImmunity(TAttImmunity immunity) throws MioaException
	{
		if(existsImmunity(immunity))
		{
			throw new MioaException("豁免规则已存在，请确认是否重复设置");
		}
		return immRepository.save(immunity);  
	}
	
	@Override
	public boolean removeImmunity(String id) throws MioaException
	{
		if(immRepository.isPassImmunity(id))
		{
			throw new MioaException("豁免规则已生效，不能删除");
		}
		immRepository.delete(id);
		return false;
	}

	@Override
	public boolean updateImmunity(TAttImmunity immunity) throws MioaException
	{
		if(immRepository.isPassImmunity(immunity.getId()))
		{
			throw new MioaException("豁免规则已生效，不能更改");
		}
		immRepository.save(immunity);
		return true;
	}

	@Override
	public TAttImmunity findImmunityById(String id)
	{
		return immRepository.findOne(id);
	}

	@Override
	public Page<TAttImmunity> findImmunityPage(int page, int pageSize)
	{
	    Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(page, pageSize, sort);
		Page<TAttImmunity> immunityPage = immRepository.findAll(pageable);
		return immunityPage;
	}

	
	//-------------------------------------私有方法-------------------------------------------------//
	
	/**
	 * TODO 是否存在相同的豁免规则
	 * @author fsluo  
	 * @return  true/false
	 * @since JDK 1.7
	 */
	private boolean existsImmunity(TAttImmunity immunity)
	{
		Example<TAttImmunity> example = Example.<TAttImmunity>of(immunity);
		boolean exists = immRepository.exists(example);
		return exists;
	}
	
}
  
