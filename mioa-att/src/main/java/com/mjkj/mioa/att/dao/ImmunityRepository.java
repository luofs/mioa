/**  
 * Project Name:mioa-att  
 * File Name:ImmunityRepository.java  
 * Package Name:com.mjkj.mioa.att.dao  
 * Date:2017年8月30日下午12:26:26  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.dao;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.att.entity.TAttImmunity;

/**  
 * ClassName:ImmunityRepository   
 * Date:     2017年8月30日 下午12:26:26 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        数据库交互类
 */
@Repository
public interface ImmunityRepository extends JpaRepository<TAttImmunity, String>
{

	/**
	 * TODO 判断规则是否过期
	 * @author fsluo  
	 * @param id 主键
	 * @return  true/false
	 * @since JDK 1.7
	 */
	@Query("select case when count(1)> 0 then true else false end from TAttImmunity e where e.enddate < sysdate")
	boolean isPassImmunity(String id);
	
}
  
