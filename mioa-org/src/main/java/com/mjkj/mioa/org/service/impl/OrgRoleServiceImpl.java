/**  
 * Project Name:mioa-org  
 * File Name:OrgRoleServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年11月15日下午10:40:18  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;   

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgRoleRepository;
import com.mjkj.mioa.org.entity.TOrgRole;
import com.mjkj.mioa.org.service.OrgRoleService;

/**  
 * ClassName:OrgRoleServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午10:40:18 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Service
public class OrgRoleServiceImpl implements OrgRoleService
{
	
	@Autowired
	private OrgRoleRepository orgRoleRepository;

	@Override
	public List<TOrgRole> findAllRoleByDomain(String domain) throws MioaException
	{
		if(StringUtils.isEmpty(domain))
		{
			throw new MioaException("参数不完整");
		}
		return orgRoleRepository.findAllRoleByDomain(domain);
	}

}
  