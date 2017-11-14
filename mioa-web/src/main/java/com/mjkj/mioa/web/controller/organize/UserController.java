/**  
 * Project Name:mioa-web  
 * File Name:UserController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年11月14日上午10:56:52  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;

/**  
 * ClassName:UserController   
 * Date:     2017年11月14日 上午10:56:52 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
@RequestMapping("/user")
public class UserController
{
	
	@Autowired
	private OrgUserService orgUserService;
	
	@RequestMapping("/findUser")
	public MioaResult getUser(@RequestParam("domain") String domain) throws MioaException
	{
		Page<TOrgUser> userList = orgUserService.findUserByPage(0, 10);
		MioaResult result = MioaResultGenerator.succeResult(userList.getContent());
		result.setCount(userList.getNumber());
		return result;
	}
}
  