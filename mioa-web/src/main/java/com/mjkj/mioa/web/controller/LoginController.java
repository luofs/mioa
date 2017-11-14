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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;
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
@RestController
public class LoginController
{
	
	@Autowired
	OrgUserService orgUserService;

	@RequestMapping(value="/login")
	public MioaResult login(LoginVO loginvo) throws MioaException
	{
		String name = loginvo.getName();
		String password = loginvo.getPassword();
		TOrgUser user = orgUserService.findByName(name);
		if(user == null)
		{
			throw new MioaException("系统无此用户");
		} 
		else if(!password.equals(user.getPassword()))
		{
			throw new MioaException("密码错误");
		}
		return new MioaResult();
	}
}
  