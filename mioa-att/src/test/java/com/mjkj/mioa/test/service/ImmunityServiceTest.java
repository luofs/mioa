/**  
 * Project Name:mioa-att  
 * File Name:ImmunityServiceTest.java  
 * Package Name:com.mjkj.mioa.test.service  
 * Date:2017年8月30日下午3:14:50  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.test.service;  

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mjkj.mioa.att.entity.TAttImmunity;
import com.mjkj.mioa.att.service.AttImmunityService;
import com.mjkj.mioa.common.Constant;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.test.AttTest;


/**  
 * ClassName:ImmunityServiceTest   
 * Date:     2017年8月30日 下午3:14:50 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public class ImmunityServiceTest extends AttTest
{
	@Autowired
	private AttImmunityService immService;
	
	@Test
	public void testAddImmunity() throws MioaException
	{
		TAttImmunity immunity = new TAttImmunity();
		immunity.setEarly(10);
		immunity.setEnddate(new Date());
		immunity.setImmunityType(Constant.IMMUNITY_TYPE_MAN);
		immunity.setLate(20);
		immunity.setNoAtt("Y");
		immunity.setStartdate(new Date());
		TAttImmunity result = immService.addImmunity(immunity);
		Assert.assertEquals(immunity.getNoAtt(), result.getNoAtt());
		
	}
}
  
