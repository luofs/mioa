/**  
 * Project Name:mioa-org  
 * File Name:OrgUserServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年11月14日上午11:03:13  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgUserRepository;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserPositionService;
import com.mjkj.mioa.org.service.OrgUserService;
import com.mjkj.mioa.org.to.OrgUserTO;

/**  
 * ClassName:OrgUserServiceImpl   
 * Date:     2017年11月14日 上午11:03:13 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Service
public class OrgUserServiceImpl implements OrgUserService
{
	
	@Autowired
	OrgUserRepository orgUserRepository;
	@Autowired
	OrgUserPositionService orgUserPositionService;
	
	@Override
	public Page<TOrgUser> findUserByPage(int page, int pageSize)
			throws MioaException
	{
		
		Sort sort = new Sort(Direction.ASC,"name");
		Pageable pageable = new PageRequest(page, pageSize, sort);
		Page<TOrgUser> result = orgUserRepository.findAll(pageable);
		return result;
	}
	
	@Override
	public TOrgUser findByName(String name) throws MioaException
	{
		if(StringUtils.isEmpty(name))
		{
			throw new MioaException("param name is null");
		}
		return orgUserRepository.findByName(name);
	}
	
	@Override
	public TOrgUser findById(String userid) throws MioaException
	{
		if(StringUtils.isEmpty(userid))
		{
			throw new MioaException("param name is null");
		}
		return orgUserRepository.findOne(userid);
	}

	@Override
	public TOrgUser addUser(OrgUserTO userto) throws MioaException
	{
		/*Example<TOrgUser> example = Example.of(user, ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase()));
		boolean exist = orgUserRepository.exists(example);
		if(exist)
		{
			throw new MioaException("账号已存在");
		}*/
		TOrgUser user = new TOrgUser();
		BeanUtils.copyProperties(userto, user);
		TOrgUser dbuser = orgUserRepository.save(user);
		if(userto.getDeptPositmap()!=null && userto.getDeptPositmap().size()>0 
				&& dbuser!=null && !StringUtils.isEmpty(dbuser.getId())){
			orgUserPositionService.batchAddUserPosit(dbuser.getId(), userto.getDeptPositmap());
		}
		return dbuser;
	}

	@Override
	public TOrgUser updateUser(TOrgUser user) throws MioaException
	{
		boolean exist = orgUserRepository.exists(user.getId());
		if(!exist)
		{
			throw new MioaException("用户不存在");
		}
		return orgUserRepository.save(user);
	}

	@Override
	public void delUser(String id) throws MioaException
	{
		orgUserRepository.delete(id);
	}

	@Override
	public void disableOrEnableUser(String id, byte flag)
	{
		orgUserRepository.disableOrEnableUser(id, flag);
	}
	
}
 
