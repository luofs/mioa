/**  
 * Project Name:mioa-web  
 * File Name:ThreadLocalVar.java  
 * Package Name:com.mjkj.mioa.web.util  
 * Date:2018年2月5日下午10:02:47  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.util;  

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**  
 * ClassName:ThreadLocalVar   
 * Date:     2018年2月5日 下午10:02:47 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public class ThreadLocalVar
{
	private static ThreadLocal<ThreadLocalObject> threadVar = new ThreadLocal<ThreadLocalObject>();

    @SuppressWarnings("unchecked")
	public static ThreadLocalObject get() 
    {
    	if(threadVar.get() == null)
    	{
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Map<String,String> obj = (Map<String,String>)auth.getPrincipal();
    		ThreadLocalObject threadLocalObj = new ThreadLocalObject();
    		threadLocalObj.setDomain(obj.get("domain"));
    		threadLocalObj.setUserEmail(obj.get("email"));
    		threadLocalObj.setUserId(obj.get("id"));
    		threadLocalObj.setUserMobile(obj.get("mobile"));
    		threadLocalObj.setUserName(obj.get("name"));
    		threadLocalObj.setUserRealName(obj.get("realname"));
    		ThreadLocalVar.set(threadLocalObj);
    	}
        return threadVar.get();
    }
    
    public static void set(ThreadLocalObject obj)
    {
        threadVar.set(obj);
    }
}
  
