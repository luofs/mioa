/**  
 * Project Name:mioa-web  
 * File Name:Test.java  
 * Package Name:com.mjkj.mioa  
 * Date:2018年1月18日下午2:46:05  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa;  

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**  
 * ClassName:Test   
 * Date:     2018年1月18日 下午2:46:05 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class Test
{
	public static void main(String[] args)
	{
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		System.out.println(passwordEncoder.encodePassword("111111", null));
	}
}
  
