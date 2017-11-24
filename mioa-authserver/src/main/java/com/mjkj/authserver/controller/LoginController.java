/**  
 * Project Name:mioa-web  
 * File Name:LoginController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年11月12日上午12:08:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.controller;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjkj.authserver.vo.LoginVO;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
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

	@RequestMapping(value="/login")
	public String login(LoginVO loginvo) throws MioaException
	{
		String name = loginvo.getUsername();
		String password = loginvo.getPassword();
//		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
//		TOrgUser user = orgUserService.findByName(name);
//		if(user == null)
//		{
//			throw new MioaException("系统无此用户");
//		} 
//		else if(!passwordEncoder.encodePassword(password, null).equals(user.getPassword()))
//		{
//			throw new MioaException("密码错误");
//		}
		return "/oauth/token?grant_type=password&username=luofs&password=111111";
	}
	
	@RequestMapping("/getToken")
	public void getToken(@PathVariable("code")String code)
	{
		System.out.println("111111");
		System.out.println(code);
	}
}
  