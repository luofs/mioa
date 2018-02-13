/**  
 * Project Name:mioa-org  
 * File Name:OrgRoleServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年11月15日下午10:40:18  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;   

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgRoleRepository;
import com.mjkj.mioa.org.entity.TOrgRole;
import com.mjkj.mioa.org.service.OrgRoleService;

/**  
 * ClassName:OrgRoleServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午10:40:18 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Service
public class OrgRoleServiceImpl implements OrgRoleService
{
	
	@Autowired
	private OrgRoleRepository orgRoleRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public List<TOrgRole> findAllRoleByDomain(String domain) throws MioaException
	{
		if(StringUtils.isEmpty(domain))
		{
			throw new MioaException("参数不完整");
		}
		return orgRoleRepository.findRoleByDomain(domain);
	}

	@Override
	public Page<TOrgRole> findRoleByPage(int page, int limit, TOrgRole parem)
	{
		Sort sort = new Sort(Direction.ASC,"name");
		Pageable pageable = new PageRequest(page, limit, sort);
		Page<TOrgRole> result = orgRoleRepository.findAll(Example.of(parem), pageable);
		return result;
	}

	@Override
	public void delete(String[] ids) throws Exception
	{
		  if(ids==null || ids.length==0)
		  {
			  throw new MioaException("参数不完整");
		  }
		  List<TOrgRole> delRole = new ArrayList<TOrgRole>(ids.length);
		  for(String id : ids)
		  {
			  TOrgRole role = new TOrgRole();
			  role.setId(id);
			  delRole.add(role);
		  }
		  orgRoleRepository.delete(delRole);
	}

	@Override
	public void addRole(TOrgRole role)
	{
		orgRoleRepository.save(role);
	}

	@Override
	public TOrgRole findRoleById(String id)
	{
		return orgRoleRepository.findOne(id);
	}

	@Override
	public void updateRole(TOrgRole role)
	{
		orgRoleRepository.save(role);
	}

}
  