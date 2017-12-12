/**  
 * Project Name:mioa-web  
 * File Name:HelloController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年12月12日下午4:28:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller;  

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
 * ClassName:HelloController   
 * Date:     2017年12月12日 下午4:28:06 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
public class HelloController
{
	 @RequestMapping("/hello")
	  public String home(Principal user) {
	    return "Hello " + user.getName();
	  }
}
  
