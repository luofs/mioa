/**  
 * Project Name:mioa-web  
 * File Name:CustomInvocationSecurityMetadataSourceService.java  
 * Package Name:com.mjkj.mioa.web.security.service  
 * Date:2017年11月15日下午10:17:44  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
 */

package com.mjkj.mioa.web.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import com.mjkj.mioa.org.entity.TMenu;
import com.mjkj.mioa.org.entity.TOrgRole;
import com.mjkj.mioa.org.service.OrgMenuService;
import com.mjkj.mioa.org.service.OrgRoleService;


/**
 * ClassName:CustomInvocationSecurityMetadataSourceService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年11月15日 下午10:17:44 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.7.0_67
 * @see 用来加载权限对应的url
 */
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource
{

	@Autowired
	private OrgMenuService menuService;
	@Autowired
	private OrgRoleService orgRoleService;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	/*
	 * public CustomInvocationSecurityMetadataSourceService(SResourceService sres,SRoleService sR) {
	 * this.sResourceService = sres; this.sRoleService = sR; loadResourceDefine(); }
	 */

	/**
	 * 在Web服务器启动时，提取系统中的所有权限 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
	 */
	@PostConstruct
	private void loadResourceDefine(String domain)
	{
		try
		{

			List<TOrgRole> roleList = orgRoleService.findAllRoleByDomain(domain);

			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

			for (TOrgRole role : roleList)
			{
				ConfigAttribute ca = new SecurityConfig(role.getName());
				List<TMenu> roleMenuList = menuService.findRoleMenu(role.getId());
				for (TMenu menu : roleMenuList)
				{
					String url = menu.getUrl();
					/*
					 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。 sparta
					 */
					if (resourceMap.containsKey(url))
					{

						Collection<ConfigAttribute> value = resourceMap.get(url);
						value.add(ca);
						resourceMap.put(url, value);
					} else
					{
						Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
						atts.add(ca);
						resourceMap.put(url, atts);
					}

				}
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return new ArrayList<ConfigAttribute>();
	}

	/**
	 * 根据URL，找到相关的权限配置
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException
	{
		// object 是一个URL，被用户请求的url。</span>
		FilterInvocation filterInvocation = (FilterInvocation) object;
		if (resourceMap == null)
		{
			loadResourceDefine("msm");
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext())
		{
			String resURL = ite.next();
			RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
			if (requestMatcher.matches(filterInvocation.getHttpRequest()))
			{
				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{

		return true;
	}

}
