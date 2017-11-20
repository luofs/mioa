/**  
 * Project Name:mioa-org  
 * File Name:OrgUserService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年11月10日下午11:14:04  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  

package com.mjkj.mioa.org.service;  

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
	
	TOrgUser findByName(String name) throws MioaException;
	
	TOrgUser addUser(TOrgUser user) throws MioaException;
	
	TOrgUser updateUser(TOrgUser user) throws MioaException;
	
	void delUser(String id) throws MioaException;
	
	void disableOrEnableUser(String id, byte flag);
}
