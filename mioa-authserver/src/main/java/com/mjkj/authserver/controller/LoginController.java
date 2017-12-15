/**  
 * Project Name:mioa-web  
 * File Name:LoginController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年11月12日上午12:08:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.controller;   

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.service.OrgUserService;

/**  
 * ClassName:LoginController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月12日 上午12:08:48 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Controller
public class LoginController
{
	
	@Autowired
	OrgUserService orgUserService;

	@RequestMapping("/login")
	public String login() throws MioaException
	{
		return "login";
	}
	
	 @RequestMapping("/signout")
	 public String signout(HttpServletRequest request) throws MioaException, ServletException
	 {
	        request.logout();
	        return "tologin";
	 }
	
	@RequestMapping("/")
	public String index() throws MioaException{
		return "index";
	}
	
}
  