/**  
 * Project Name:mioa-web  
 * File Name:MioaException.java  
 * Package Name:com.mjkj.mioa.web.exception  
 * Date:2017年8月18日下午5:35:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common.exception;  
/**  
 * ClassName:MioaException   
 * Date:     2017年8月18日 下午5:35:48 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class MioaResult<T>
{
	public static final Integer OK = 0;
	public static final Integer ERROR = -1;
	
	private Integer retCode;
	private String retMessage;
	private T retData;
	
	
	/*************************以下get set************************************/
	public Integer getRetCode()
	{
		return retCode;
	}
	public void setRetCode(Integer retCode)
	{
		this.retCode = retCode;
	}
	public String getRetMessage()
	{
		return retMessage;
	}
	public void setRetMessage(String retMessage)
	{
		this.retMessage = retMessage;
	}
	public T getRetData()
	{
		return retData;
	}
	public void setRetData(T retData)
	{
		this.retData = retData;
	}
	
	
}
  
