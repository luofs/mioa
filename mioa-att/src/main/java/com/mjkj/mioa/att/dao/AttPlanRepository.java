/**  
 * Project Name:mioa-att  
 * File Name:AttPlanRepository.java  
 * Package Name:com.mjkj.mioa.att.dao  
 * Date:2017年9月4日下午3:41:39  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.dao;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.att.entity.TAttPlan;

/**  
 * ClassName:AttPlanRepository   
 * Date:     2017年9月4日 下午3:41:39 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        排班数据库交互类
 */
@Repository
public interface AttPlanRepository extends JpaRepository<TAttPlan, String>
{
	
}
  
