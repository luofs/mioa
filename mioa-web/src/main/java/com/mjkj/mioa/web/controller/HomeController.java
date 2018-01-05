/**  
 * Project Name:mioa-web  
 * File Name:HomeController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年11月10日下午11:29:09  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller;   

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * ClassName:HomeController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:29:09 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Controller
public class HomeController
{

	@RequestMapping("/")
	public String index(Principal user)
	{
		user.getName();
//		String result = HttpClientUtil.sendPostRequestByJava("http://localhost:8080/me", "");
//		System.out.println(result);
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 auth.getPrincipal();
		return "index";
	}
}
  