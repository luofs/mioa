/**  
 * Project Name:mioa-web  
 * File Name:DemoApplication.java  
 * Package Name:com.mjkj.mioa.web.demo  
 * Date:2017年8月18日下午3:13:20  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.demo;  

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
 * ClassName:DemoApplication <br/>  
 * Date:     2017年8月18日 下午3:13:20 <br/>  
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RestController
public class DemoApplication
{
	@RequestMapping("/index")
	public String index()
	{
		return "Hello word!";
	}
}
  
