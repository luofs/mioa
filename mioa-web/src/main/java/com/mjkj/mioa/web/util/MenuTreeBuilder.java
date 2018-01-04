/**  
 * Project Name:mioa-web  
 * File Name:MenuTreeBuilder.java  
 * Package Name:com.mjkj.mioa.web.util  
 * Date:2018年1月4日下午4:42:41  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.util;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mjkj.mioa.org.entity.TMenu;
import com.mjkj.mioa.web.vo.menu.MenuVO;

/**  
 * ClassName:MenuTreeBuilder   
 * Date:     2018年1月4日 下午4:42:41 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class MenuTreeBuilder
{
	
	private static List<TMenu> menuList;
	
	public static List<MenuVO> buildMenuTree(List<TMenu> paramMenuList)
	{
		menuList = paramMenuList;
		List<MenuVO> menuVOList = new ArrayList<>();
		for(int i = menuList.size() - 1; i >= 0; i--)
		{
			TMenu orgMenu = menuList.get(i);
			if(StringUtils.isEmpty(orgMenu.getParentid()) || "0".equals(orgMenu.getParentid()))
			{
				menuVOList.add(convertMenuVO(orgMenu));
				menuList.remove(orgMenu);
			}
        }
		return menuVOList;
	}
	
	public static List<MenuVO> getChildren(TMenu paramMenu)
	{
		List<MenuVO> childMenus = new ArrayList<>();
		for(int i = menuList.size() - 1; i >= 0; i--)
		{
			TMenu orgMenu = menuList.get(i);
			if(paramMenu.getId().equals(orgMenu.getParentid()))
			{
				childMenus.add(convertMenuVO(orgMenu));
				menuList.remove(orgMenu);
			}
        }
		
		return childMenus;
	}
	
	private static MenuVO convertMenuVO(TMenu orgMenu)
	{
		MenuVO vo = new MenuVO();
		vo.setChildren(getChildren(orgMenu));
		vo.setIcon(orgMenu.getIcon());
		vo.setId(orgMenu.getId());
		vo.setPid(orgMenu.getParentid());
		vo.setSpread("Y".equals(orgMenu.getSpread()));
		vo.setTitle(orgMenu.getTitle());
		vo.setUrl(orgMenu.getUrl());
		return vo;
	}
}
  
