/**  
 * Project Name:mioa-sys  
 * File Name:GroovyUtil.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月12日下午2:36:35  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.io.File;

import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;

/**  
 * ClassName:GroovyUtil   
 * Date:     2017年9月12日 下午2:36:35 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        groovy脚本执行工具
 */
public class GroovyUtil
{
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static Object invokeGroovy(String groovyPath, Object[] args)
	{
		try
		{
			Class<Script> groovyClass = null;
			if(true) //判断缓存，如果有，则从缓存中取
			{
				
			}
			else
			{
				ClassLoader cl = GroovyUtil.class.getClass().getClassLoader();
				GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
				groovyClass = (Class<Script>)groovyCl.parseClass(new File(groovyPath));
				//TODO 将得到的class进行缓存
			}
			Script groovyScript = groovyClass.newInstance();
			return groovyScript.invokeMethod("", args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
  
