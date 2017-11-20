/**  
 * Project Name:mioa-web  
 * File Name:mioaAuthenticationProvider.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月11日下午10:12:04  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.config;   

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;
import com.mjkj.mioa.web.security.vo.SecurityUser;


/**  
 * ClassName:mioaAuthenticationProvider <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月11日 下午10:12:04 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Component
public class mioaAuthenticationProvider implements AuthenticationProvider
{
	
	@Autowired
	private OrgUserService orgUserService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		TOrgUser user = null;
		try
		{
			user = orgUserService.findByName(username);
		} catch (MioaException e)
		{
			throw new BadCredentialsException(e.getMessage());
		}
		if(user == null)
		{
			throw new BadCredentialsException("user not found.");
		}
		if(!password.equals(user.getPassword()))
		{
			throw new BadCredentialsException("Wrong password.");
		}
		SecurityUser securityUser = new SecurityUser(user);
		Collection<? extends GrantedAuthority> authorities = securityUser.getAuthorities();
	     return new UsernamePasswordAuthenticationToken(securityUser, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return true;
	}

}
  