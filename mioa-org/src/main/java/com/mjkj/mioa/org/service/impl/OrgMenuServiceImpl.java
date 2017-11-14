/**  
 * Project Name:mioa-org  
 * File Name:OrgMenuServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年9月15日上午10:58:02  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgMenuRepository;
import com.mjkj.mioa.org.entity.TMenu;
import com.mjkj.mioa.org.service.OrgMenuService;

/**  
 * ClassName:OrgMenuServiceImpl   
 * Date:     2017年9月15日 上午10:58:02 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see  菜单服务接口实现类      
 */
@Service
public class OrgMenuServiceImpl implements OrgMenuService
{
	
	@Autowired
	private OrgMenuRepository menuRepository;
	
	@Override
	public TMenu addMenu(TMenu menu) throws MioaException
	{
		TMenu dbMenu =  menuRepository.findMenuByNameAndDomainAndIsdel(menu.getTitle(), menu.getDomain(), (byte) 1);
		if(dbMenu != null)
		{
			throw new MioaException("菜单已存在");
		}
		return menuRepository.save(menu);
	}
	
	@Override
	public boolean removeMenu(String id) throws MioaException
	{
		if(menuRepository.exists(id))
		{
			menuRepository.delete(id);
		}
		return false;
	}
	
	@Override
	public boolean updateMenu(TMenu menu) throws MioaException
	{
		TMenu dbMenu =  menuRepository.findOne(menu.getId());
		if(dbMenu == null)
		{
			throw new MioaException("未找到对应菜单");
		}
		menuRepository.save(menu);
		return true;
	}
	
	@Override
	public TMenu findMenuById(String id) throws MioaException
	{
		return menuRepository.findOne(id);
	}
	
	@Override
	public List<TMenu> findAllMenu(String domain) throws MioaException
	{
		return menuRepository.findMenuByDomain(domain);
	}
	
}
  
