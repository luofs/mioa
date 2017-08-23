/**  
 * Project Name:mioa-web  
 * File Name:DemoApplication.java  
 * Package Name:com.mjkj.mioa.web.demo  
 * Date:2017年8月18日下午3:13:20  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.demo;  

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.mjkj.mioa.web.exception.MioaException;

/**  
 * ClassName:DemoApplication <br/>  
 * Date:     2017年8月18日 下午3:13:20 <br/>  
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Controller
@RequestMapping("/demo")
public class DemoApplication
{

	private Logger log = (Logger) LoggerFactory.getLogger(DemoApplication.class);
	
	@Value("${spring.profiles.active}")
	private String profiles;
	
	@ResponseBody
	@RequestMapping("/index")
	public String index()
	{
		//return "Hello word!";
		log.info("============== index =================");
		return profiles;
	}
	
	@RequestMapping("/error")
	public String error() throws Exception
	{
		throw new Exception("exception");
	}
	
	@RequestMapping("/mioaerror")
	public String mioaError() throws MioaException
	{
		throw new MioaException("This is mioa exception");
	}
}
  
