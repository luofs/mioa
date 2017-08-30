/**  
 * Project Name:mioa-att  
 * File Name:UUIDGenerator.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年8月30日下午3:54:51  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common;  

import java.util.UUID;

/**  
 * ClassName:UUIDGenerator   
 * Date:     2017年8月30日 下午3:54:51 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7  
 * @see        生成uuid
 */
public class UUIDGenerator
{
	public static String creatUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
  
