/**  
 * Project Name:mioa-sys  
 * File Name:ExcelResources.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年9月14日下午4:43:07  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common;  

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**  
 * ClassName:ExcelResources   
 * Date:     2017年9月14日 下午4:43:07 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources
{
	/**
     * 属性的标题名称
     * @return
     */
    String excelTitle();
    /**
     * 在excel的顺序
     * @return
     */
    int order() default 9999;
}
  
