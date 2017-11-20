/**  
 * Project Name:mioa-web  
 * File Name:WebSecurityConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月10日下午11:21:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.config;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.mjkj.mioa.web.security.handler.LoginSuccessHandler;
import com.mjkj.mioa.web.security.service.CustomUserService;
import com.mjkj.mioa.web.security.vo.SecurityFilter;

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

	@Autowired
	private SecurityFilter securityFilter;
	
	@Bean
	UserDetailsService customUserService()
	{
		return new CustomUserService();
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
		http.addFilterBefore(securityFilter, FilterSecurityInterceptor.class)
			.authorizeRequests()
			.antMatchers("/","/index","/login","/backstage/login.html").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/").permitAll().successHandler(loginSuccessHandler())
			.and().logout().logoutSuccessUrl("/").permitAll()
			.invalidateHttpSession(true)
			.and().rememberMe().tokenValiditySeconds(1209600);
	}
	
	@Bean
	public LoginSuccessHandler loginSuccessHandler()
	{
		return new LoginSuccessHandler();
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//解决静态资源被拦截的问题
	     web.ignoring().antMatchers("/common/**","/backstage/**/*.js","/backstage/**/*.css","/backstage/**/*.jpg","/backstage/**/*.gif","/backstage/**/*.png");
	}
	
}
  