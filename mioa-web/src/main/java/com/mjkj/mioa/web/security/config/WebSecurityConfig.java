/**  
 * Project Name:mioa-web  
 * File Name:WebSecurityConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月10日下午11:21:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.config;   

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.mjkj.mioa.web.security.service.CustomUserService;

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
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Bean
	UserDetailsService customUserService()
	{
		return new CustomUserService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(customUserService());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		//TODO 暂时关闭该功能，为了安全后续将不能关闭
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/","/index","/login","/backstage/login.html").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/").permitAll()
			.and().logout().permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//解决静态资源被拦截的问题
	     web.ignoring().antMatchers("/common/**","/backstage/**/*.js","/backstage/**/*.css","/backstage/**/*.jpg","/backstage/**/*.gif","/backstage/**/*.png");
	}
	
}
  