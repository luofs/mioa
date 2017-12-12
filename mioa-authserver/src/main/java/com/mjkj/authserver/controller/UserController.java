/**  
 * Project Name:mioa-authserver  
 * File Name:UserController.java  
 * Package Name:com.mjkj.authserver.controller  
 * Date:2017年12月11日下午3:19:29  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.authserver.controller;  

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
 * ClassName:UserController   
 * Date:     2017年12月11日 下午3:19:29 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
public class UserController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user")
    public Principal getUser(Principal principal) {
        LOGGER.info("GET USER RESOURCE");
        LOGGER.info(principal.toString());
        return principal;
}
}
  
