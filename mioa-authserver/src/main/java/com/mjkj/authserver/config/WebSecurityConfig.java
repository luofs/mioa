/**  
 * Project Name:mioa-web  
 * File Name:WebSecurityConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月10日下午11:21:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.config;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mjkj.authserver.service.CustomUserService;

/**  
 * ClassName:WebSecurityConfig <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:21:06 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	
	@Bean
	UserDetailsService customUserService()
	{
		return new CustomUserService();
	}
	

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserService())
				.passwordEncoder(new Md5PasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		//使用JWT，关闭csrf
		http.csrf().disable();
		//采用token方式，不需要session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//禁用缓存
		http.headers().cacheControl();
		//http.addFilterBefore(securityFilter, FilterSecurityInterceptor.class)
		http.authorizeRequests().antMatchers("/login", "/oauth/**").permitAll().anyRequest().authenticated().and()
			.httpBasic();
	}
	
}
  