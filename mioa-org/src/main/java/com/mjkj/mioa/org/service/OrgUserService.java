/**  
 * Project Name:mioa-org  
 * File Name:OrgUserService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年11月14日上午10:58:40  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;

import org.springframework.data.domain.Page;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUser;

/**  
 * ClassName:OrgUserService   
 * Date:     2017年11月14日 上午10:58:40 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public interface OrgUserService
{
	
	Page<TOrgUser> findUserByPage(int page, int pageSize) throws MioaException;
}
  
