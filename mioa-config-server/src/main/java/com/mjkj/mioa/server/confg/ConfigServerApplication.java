/**  
 * Project Name:mioa-config-server  
 * File Name:ConfigServerApplication.java  
 * Package Name:com.mjkj.mioa.server.confg  
 * Date:2017年8月18日下午12:04:10  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.server.confg;  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**  
 * ClassName:ConfigServerApplication <br/>  
 * Date:     2017年8月18日 下午12:04:10 <br/>  
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigServerApplication.class, args);
	}
	
}
  
