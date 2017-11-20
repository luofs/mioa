/**  
 * Project Name:mioa-web  
 * File Name:DepartMentController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年11月20日下午5:31:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.org.service.OrgDepartmentService;
/**  
 * ClassName:DepartMentController   
 * Date:     2017年11月20日 下午5:31:06 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
@RequestMapping("/department")
public class DepartMentController
{
	
	@Autowired
	private OrgDepartmentService departmentService;
}
  
