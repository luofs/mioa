/**  
 * Project Name:mioa-web  
 * File Name:HomeController.java  
 * Package Name:com.mjkj.mioa.web.controller  
 * Date:2017年11月10日下午11:29:09  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller;   

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * ClassName:HomeController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:29:09 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Controller
public class HomeController
{

	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}
  