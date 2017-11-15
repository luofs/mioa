/**  
 * Project Name:mioa-web  
 * File Name:MenuController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年11月15日下午5:11:37  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TMenu;
import com.mjkj.mioa.org.service.OrgMenuService;

/**  
 * ClassName:MenuController   
 * Date:     2017年11月15日 下午5:11:37 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
@RequestMapping("/menu")
public class MenuController
{
	
	@Autowired
	private OrgMenuService menuService;
	
	@RequestMapping("/findUserMenu")
	public MioaResult getUserMenu(@RequestParam("userid")String userid, @RequestParam("domain")String domain) throws MioaException
	{
		List<TMenu> menuList = menuService.findUserMen(userid, domain);
		MioaResult result = MioaResultGenerator.succeResult(menuList);
		result.setCount(menuList.size());
		return result;
	}
}
  
