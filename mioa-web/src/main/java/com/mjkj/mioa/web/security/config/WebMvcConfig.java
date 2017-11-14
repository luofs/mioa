/**  
 * Project Name:mioa-web  
 * File Name:WebMvcConfig.java  
 * Package Name:com.mjkj.mioa.web.security  
 * Date:2017年11月11日上午12:13:05  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.security.config;   

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
 * ClassName:WebMvcConfig <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月11日 上午12:13:05 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/login").setViewName("index");
	    }
}
  