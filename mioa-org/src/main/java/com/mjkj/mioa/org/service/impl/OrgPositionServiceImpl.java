/**  
 * Project Name:mioa-org  
 * File Name:OrgPositionServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年9月15日上午11:40:50  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgPositionRepository;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.service.OrgPositionService;

/**  
 * ClassName:OrgPositionServiceImpl   
 * Date:     2017年9月15日 上午11:40:50 
 * @author   fsluo  
 * @version 1.0    
 * @since    JDK 1.7 
 * @see        岗位服务接口实现类
 */
@Service
public class OrgPositionServiceImpl implements OrgPositionService
{
	
	@Autowired
	private OrgPositionRepository positionRepository;
	
	@Override
	public TOrgPosition addPosition(TOrgPosition position) throws MioaException
	{
		TOrgPosition dbPosition = positionRepository.findPositionByNameAndDomainAndIsdeleteEquals  (position.getName(), position.getDomain(), (byte)0);
		if (dbPosition != null)
		{
			throw new MioaException("岗位已存在");
		}
		return positionRepository.save(position);
	}
	
	@Override
	public boolean removePosition(String id) throws MioaException
	{
		positionRepository.delete(id);
		return true;
	}
	
	@Override
	public boolean updatePosition(TOrgPosition position) throws MioaException
	{
		positionRepository.save(position);
		return true;
	}
	
	@Override
	public TOrgPosition findPositionById(String id) throws MioaException
	{
		return positionRepository.findOne(id);
	}

	@Override
	public List<TOrgPosition> findPositionByDomain(String domain) throws MioaException
	{
		return positionRepository.findPositionByDomainAndIsdeleteEquals(domain, (byte)0);
	}

	@Override
	public Page<TOrgPosition> findPositionByPage(int page, int pageSize, TOrgPosition position)
	{
		Sort sort = new Sort(Direction.ASC,"name");
		Pageable pageable = new PageRequest(page, pageSize, sort);
		Page<TOrgPosition> result = positionRepository.findAll(Example.of(position), pageable);
		return result;
	}
	
}
  
