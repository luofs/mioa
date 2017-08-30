/**  
 * Project Name:mioa-web  
 * File Name:RedisDemoApplication.java  
 * Package Name:com.mjkj.mioa.web.demo  
 * Date:2017年8月25日上午10:22:41  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.demo;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * ClassName:RedisDemoApplication   
 * Date:     2017年8月25日 上午10:22:41 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RequestMapping("redis")
public class RedisDemoApplication
{
	@Autowired
	private StringRedisTemplate redis ;
	
	@GetMapping("/addData")
	public String addDataInRedis(@PathVariable(value="data") String data)
	{
		ValueOperations<String, String> reidsV = redis.opsForValue();
		if(!redis.hasKey("mydata"))
		{
			reidsV.set("mydata", data);
		}
		return reidsV.get("mydata");
	}
}
  
