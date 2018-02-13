/**  
 * Project Name:mioa-web  
 * File Name:MioaException.java  
 * Package Name:com.mjkj.mioa.web.exception  
 * Date:2017年8月18日下午5:35:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common.result;  
/**  
 * ClassName:MioaException   
 * Date:     2017年8月18日 下午5:35:48 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class MioaResult
{
	public static final Integer OK = 0;
	public static final Integer ERROR = -1;
	private static final String DEFAULT_MSG = "SUCCESS";
	
	private int code;
	private String msg;
	private long count;
	private Object data;
	
	public MioaResult()
	{
		this.code = OK;
		this.msg = DEFAULT_MSG;
	}
	
	public MioaResult(Object data)
	{
		this.code = OK;
		this.msg = DEFAULT_MSG;
		this.data = data;
	}
	
	public MioaResult(int code, String msg,  Object data)
	{
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public MioaResult(int code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}

	/*************************以下get set************************************/
	
	public int getCode()
	{
		return code;
	}
	public void setCode(int code)
	{
		this.code = code;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public long getCount()
	{
		return count;
	}
	public void setCount(long count)
	{
		this.count = count;
	}
	public Object getData()
	{
		return data;
	}
	public void setData(Object data)
	{
		this.data = data;
	}
	
}
  
