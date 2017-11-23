/**  
 * Project Name:mioa-web  
 * File Name:CustomUserService.java  
 * Package Name:com.mjkj.mioa.web.security.service  
 * Date:2017年11月10日下午11:15:46  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.service;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mjkj.authserver.entry.SecurityUser;
import com.mjkj.mioa.org.dao.OrgUserRepository;
import com.mjkj.mioa.org.entity.TOrgUser;


/**  
 * ClassName:CustomUserService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:15:46 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
public class CustomUserService implements UserDetailsService
{
	
	@Autowired
	OrgUserRepository orgUserRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		TOrgUser user = orgUserRepository.findByName(userName);
		if(user == null)
		{
			throw new UsernameNotFoundException("用户名不存在");
		}
		return new SecurityUser(user);
	}

}
  