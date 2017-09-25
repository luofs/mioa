/**  
 * Project Name:mioa-sys  
 * File Name:MioaResultGenerator.java  
 * Package Name:com.mjkj.mioa.common.result  
 * Date:2017年9月22日下午5:55:33  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common.result;  
/**  
 * ClassName:MioaResultGenerator   
 * Date:     2017年9月22日 下午5:55:33 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        返回结果封装
 */
public class MioaResultGenerator
{
	
	public static MioaResult successResult()
	{
		return new MioaResult();
	}
	
	public static MioaResult succeResult(Object data)
	{
		return new MioaResult(data);
	}
	
	public static MioaResult generalResult(int code, String msg,  Object data)
	{
		return new MioaResult(code, msg, data);
	}
	
	public static MioaResult failResult(String msg)
	{
		return new MioaResult(MioaResult.ERROR, msg);
	}
}
  
