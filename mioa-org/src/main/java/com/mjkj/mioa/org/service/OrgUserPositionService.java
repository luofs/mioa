/**  
 * Project Name:mioa-org  
 * File Name:OrgUserPositionService.java  
 * Package Name:com.mjkj.mioa.org.service  
 * Date:2018年2月8日下午5:30:41  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service;  

import java.util.List;
import java.util.Map;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgUserPosition;

/**  
 * ClassName:OrgUserPositionService   
 * Date:     2018年2月8日 下午5:30:41 
 * @author   fsluo  
 * @version    用户职位服务接口
 * @since    JDK 1.7 
 * @see        
 */
public interface OrgUserPositionService
{
	
	List<TOrgUserPosition> findPositionByUserid(String userid);
	
	void addUserPosit(String userid, String deptid, String posid) throws MioaException;
	
	void batchAddUserPosit(String userid, Map<String, String> deptAndPosids) throws MioaException;
}
  
