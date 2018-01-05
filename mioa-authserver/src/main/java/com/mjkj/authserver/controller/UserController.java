/**  
 * Project Name:mioa-authserver  
 * File Name:UserController.java  
 * Package Name:com.mjkj.authserver.controller  
 * Date:2017年12月11日下午3:19:29  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.controller;  

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.org.entity.TOrgUser;

/**  
 * ClassName:UserController   
 * Date:     2017年12月11日 下午3:19:29 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
public class UserController
{

	@RequestMapping({ "/user", "/me" })
	public Map<String, String> user(Principal principal) {
	  Map<String, String> map = new LinkedHashMap<>();
	  map.put("name", principal.getName());
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  TOrgUser orgUser = (TOrgUser)auth.getPrincipal();
	  map.put("id", orgUser.getId());
	  map.put("domain", orgUser.getDomain());
	  return map;
	}
}
  
