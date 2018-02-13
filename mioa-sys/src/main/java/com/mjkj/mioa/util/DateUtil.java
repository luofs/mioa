/**  
 * Project Name:mioa-sys  
 * File Name:DateUtil.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2018年2月1日上午11:07:37  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.sql.Timestamp;

/**  
 * ClassName:DateUtil   
 * Date:     2018年2月1日 上午11:07:37 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class DateUtil
{
	
	/**
	 * 获取当前系统时间戳
	 * @author fsluo  
	 * @return  Timestamp
	 * @since JDK 1.7
	 */
	public static Timestamp currentTime()
	{
		return new Timestamp(System.currentTimeMillis());
	}
}
  
