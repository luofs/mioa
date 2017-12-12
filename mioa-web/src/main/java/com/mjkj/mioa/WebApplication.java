/**  
 * Project Name:mioa-web  
 * File Name:WebApplication.java  
 * Package Name:com.mjkj.mioa.web  
 * Date:2017年8月18日下午3:07:41  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa;  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**  
 * ClassName:WebApplication <br/>  
 * Date:     2017年8月18日 下午3:07:41 <br/>  
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@SpringBootApplication
public class WebApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(WebApplication.class, args);
	}
	
}
  
