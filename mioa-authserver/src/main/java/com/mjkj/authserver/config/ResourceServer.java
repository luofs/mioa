/**  
 * Project Name:mioa-authserver  
 * File Name:ResourceServer.java  
 * Package Name:com.mjkj.authserver.config  
 * Date:2017年12月8日下午4:44:42  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.config;  

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**  
 * ClassName:ResourceServer   
 * Date:     2017年12月8日 下午4:44:42 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter
{
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
    }
}
  
