/**  
 * Project Name:mioa-web  
 * File Name:mioaAuthenticationProvider.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月11日下午10:12:04  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.config;   

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.mjkj.authserver.entry.SecurityUser;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;


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
@Service
public class MioaAuthenticationProvider implements AuthenticationProvider
{
	
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
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(username, passwordEncoder.encodePassword(password, null), authorities);
		//authenticate.setDetails(new CustomUserService());
	     return authenticate;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return true;
	}
}
  