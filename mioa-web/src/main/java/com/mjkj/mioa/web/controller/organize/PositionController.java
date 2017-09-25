/**  
 * Project Name:mioa-web  
 * File Name:PositionController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年9月21日上午11:44:13  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.service.OrgPositionService;

/**  
 * ClassName:PositionController   
 * Date:     2017年9月21日 上午11:44:13 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        岗位请求入口
 */
@RestController
@RequestMapping("/position")
public class PositionController
{
	
	private Logger log = (Logger) LoggerFactory.getLogger(PositionController.class);
	
	@Autowired
	private OrgPositionService positionService;
	
	@RequestMapping("/findPosition/{domain}")
	public List<TOrgPosition> getOrgPosition(@PathVariable("domain") String domain) throws MioaException
	{
		return positionService.findPositionByDomain(domain);
	}
	
}
  
