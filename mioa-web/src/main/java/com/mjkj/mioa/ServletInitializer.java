/**  
 * Project Name:mioa-web  
 * File Name:ServletInitializer.java  
 * Package Name:com.mjkj.mioa  
 * Date:2017年11月15日下午11:19:55  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
 */

package com.mjkj.mioa;

/**  
 * ClassName:ServletInitializer <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午11:19:55 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;


public class ServletInitializer extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(WebApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		FilterRegistration.Dynamic openEntityManagerInViewFilter = servletContext
				.addFilter("openEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class);
		openEntityManagerInViewFilter.setInitParameter("entityManagerFactoryBeanName", "entityManagerFactory");
		openEntityManagerInViewFilter.addMappingForUrlPatterns(null, false, "/*");
		super.onStartup(servletContext);
	}
}
