/**  
 * Project Name:mioa-org  
 * File Name:OrgPositionServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年9月15日上午11:40:50  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
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
		TOrgPosition dbPosition = positionRepository.findPositionByNameAndDomainAndIsdelete(position.getName(), position.getDomain(), 0);
		if (dbPosition != null)
		{
			throw new MioaException("岗位已存在");
		}
		return positionRepository.save(dbPosition);
	}
	
	@Override
	public boolean removePosition(String id) throws MioaException
	{
		
		// TODO Auto-generated method stub  
		return false;
	}
	
	@Override
	public boolean updatePosition(TOrgPosition position) throws MioaException
	{
		
		// TODO Auto-generated method stub  
		return false;
	}
	
	@Override
	public TOrgPosition findPositionById(String id) throws MioaException
	{
		
		// TODO Auto-generated method stub  
		return null;
	}
	
}
  
