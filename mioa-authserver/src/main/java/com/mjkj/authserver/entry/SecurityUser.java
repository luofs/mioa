/**  
 * Project Name:mioa-web  
 * File Name:SecurityUser.java  
 * Package Name:com.mjkj.mioa.web.security.vo  
 * Date:2017年11月15日下午10:04:37  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.entry;   

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.mjkj.mioa.org.entity.TOrgRole;
import com.mjkj.mioa.org.entity.TOrgUser;


/**  
 * ClassName:SecurityUser <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午10:04:37 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
public class SecurityUser extends TOrgUser implements UserDetails
{

	private static final long serialVersionUID = -8886908164724734326L;

	public SecurityUser(TOrgUser user)
	{
		if(user!=null)
		{
			try
			{
				BeanUtils.copyProperties(this, user);
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<GrantedAuthority> auths = new ArrayList<>();
		List<TOrgRole> roles = this.getTOrgRoles();
		for(TOrgRole role : roles)
		{
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}

	@Override
	public String getUsername()
	{
		return super.getName();
	}
	
	@Override
	public String getPassword()
	{
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}


}
  