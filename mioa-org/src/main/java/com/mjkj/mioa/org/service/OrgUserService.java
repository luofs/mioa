/**  
 * Project Name:mioa-org  
 * File Name:OrgUserService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年11月10日下午11:14:04  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;   

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;

/**  
 * ClassName:OrgUserService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:14:04 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
public interface OrgUserService
{
	TOrgUser findByName(String name) throws MioaException;
}
  