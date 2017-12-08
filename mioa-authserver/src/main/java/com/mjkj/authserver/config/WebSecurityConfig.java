/**  
 * Project Name:mioa-web  
 * File Name:WebSecurityConfig.java  
 * Package Name:com.mjkj.mioa.web.security.config  
 * Date:2017年11月10日下午11:21:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.config;   

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import com.mjkj.authserver.handler.LoginSuccessHandler;
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

	@Autowired 
    @Qualifier("dataSource")
    private DataSource dataSource;
	
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
		 http.formLogin().loginPage("/login").permitAll().failureUrl("/error").successHandler(loginSuccessHandler())
		 .and().authorizeRequests()
		 		.antMatchers("/images/**", "/checkcode", "/scripts/**", "/styles/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and().exceptionHandling().accessDeniedPage("/deny")
                .and().rememberMe().tokenValiditySeconds(86400).tokenRepository(tokenRepository());
		//使用JWT，关闭csrf
		http.csrf().disable();
		//禁用缓存
		http.headers().cacheControl();
	}
	
	@Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
	
	@Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jtr = new JdbcTokenRepositoryImpl();
        jtr.setDataSource(dataSource);
        return jtr;
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//解决静态资源被拦截的问题
	     web.ignoring().antMatchers("/common/**","/backstage/**/*.js","/backstage/**/*.css","/backstage/**/*.jpg","/backstage/**/*.gif","/backstage/**/*.png");
	}
	
}
  