/**  
 * Project Name:mioa-org  
 * File Name:OrgDeptPositService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2018年2月6日下午3:23:35  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;

import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:OrgDeptPositService   
 * Date:     2018年2月6日 下午3:23:35 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public interface OrgDeptPositService
{
	List<String> findDeptidByPostid(String postid);
	
	void addDeptPosit(String posid, String deptid) throws MioaException;
	
	void batchAddDeptPosit(String posid, String[] deptids) throws MioaException;
	
}
  
