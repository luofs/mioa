/**  
 * Project Name:mioa-web  
 * File Name:LoginVO.java  
 * Package Name:com.mjkj.mioa.web.vo.login  
 * Date:2017年11月12日上午12:14:04  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.vo.login;   

/**  
 * ClassName:LoginVO <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月12日 上午12:14:04 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
public class LoginVO
{

	private String name; //登录名
	
	private String password; //密码
	
	private String code; //验证码

	
	public String getName()
	{
		return name;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}

	
	public String getPassword()
	{
		return password;
	}

	
	public void setPassword(String password)
	{
		this.password = password;
	}

	
	public String getCode()
	{
		return code;
	}

	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	
}
  