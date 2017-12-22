/**  
 * Project Name:mioa-org  
 * File Name:OrgMenuService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年9月15日上午10:51:03  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TMenu;

/**  
 * ClassName:OrgMenuService   
 * Date:     2017年9月15日 上午10:51:03 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        菜单服务接口
 */
public interface OrgMenuService
{
	
	/**
	 * TODO 添加菜单
	 * @author fsluo  
	 * @param menu 菜单实体类
	 * @return TMenu
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TMenu addMenu(TMenu menu) throws MioaException;
	
	/**
	 * TODO 移除菜单
	 * @author fsluo  
	 * @param id 菜单主键
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean removeMenu(String id) throws MioaException;
	
	/**
	 * TODO 更新菜单
	 * @author fsluo  
	 * @param menu 菜单实体类
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateMenu(TMenu menu) throws MioaException;
	
	/**
	 * TODO 根据主键查询菜单
	 * @author fsluo  
	 * @param id 菜单主键
	 * @return TMenu
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TMenu findMenuById(String id) throws MioaException;
	
	/**
	 * TODO 查询域的所有菜单
	 * @author fsluo  
	 * @param domain
	 * @return List<TMenu>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public List<TMenu> findAllMenu(String domain) throws MioaException;
	
	
	List<TMenu> findRoleMenu(String roleid) throws MioaException;
}
  
