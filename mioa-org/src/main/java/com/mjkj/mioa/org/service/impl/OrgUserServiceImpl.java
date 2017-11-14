/**  
 * Project Name:mioa-org  
 * File Name:OrgUserServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2017年11月10日下午11:17:45  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgUserRepository;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;
import freemarker.template.utility.StringUtil;


/**  
 * ClassName:OrgUserServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:17:45 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Service
public class OrgUserServiceImpl implements OrgUserService
{

	@Autowired
	private OrgUserRepository userRepository;
	
	@Override
	public TOrgUser findByName(String name) throws MioaException
	{
		if(StringUtils.isEmpty(name))
		{
			throw new MioaException("param name is null");
		}
		return userRepository.findByName(name);
	}

}
  