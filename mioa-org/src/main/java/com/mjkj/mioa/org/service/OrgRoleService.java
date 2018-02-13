/**  
 * Project Name:mioa-org  
 * File Name:OrgRoleService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2017年11月15日下午10:38:58  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;   

import java.util.List;

import org.springframework.data.domain.Page;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgRole;

/**  
 * ClassName:OrgRoleService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午10:38:58 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
public interface OrgRoleService
{

	List<TOrgRole> findAllRoleByDomain(String domain) throws MioaException;

	Page<TOrgRole> findRoleByPage(int page, int limit, TOrgRole parem);

	void delete(String[] ids) throws Exception;

	void addRole(TOrgRole role);

	TOrgRole findRoleById(String id);

	void updateRole(TOrgRole role);
}
  