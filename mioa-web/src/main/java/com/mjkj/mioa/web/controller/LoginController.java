/**  
 * Project Name:mioa-web  
 * File Name:LoginController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年11月12日上午12:08:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;
import com.mjkj.mioa.web.util.HttpClientUtil;
import com.mjkj.mioa.web.vo.login.LoginVO;

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
		String name = loginvo.getName();
		String password = loginvo.getPassword();
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		TOrgUser user = orgUserService.findByName(name);
		if(user == null)
		{
			throw new MioaException("系统无此用户");
		} 
		else if(!passwordEncoder.encodePassword(password, null).equals(user.getPassword()))
		{
			throw new MioaException("密码错误");
		}
		String code = HttpClientUtil.sendGetRequest("http://localhost:8080/oauth/authorize?client_id=client&response_type=code&redirect_uri=/getToken", null);
		return "";
	}
	
	@RequestMapping("/getToken")
	public void getToken()
	{
		System.out.println("111111");
	}
}
  