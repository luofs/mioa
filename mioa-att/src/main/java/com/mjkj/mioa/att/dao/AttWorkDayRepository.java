/**  
 * Project Name:mioa-att  
 * File Name:WorkDayRepository.java  
 * Package Name:com.mjkj.mioa.att.dao  
 * Date:2017年9月1日上午10:03:28  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.dao;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.att.entity.TAttWorkday;

/**  
 * ClassName:WorkDayRepository   
 * Date:     2017年9月1日 上午10:03:28 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Repository
public interface AttWorkDayRepository extends JpaRepository<TAttWorkday, String>
{

	/**
	 * TODO 判断规则是否生效
	 * @author fsluo  
	 * @param id 主键
	 * @return  true/false
	 * @since JDK 1.7
	 */
	@Query("select case when count(1)>0 then true else false end from TAttWorkday e where sysdate between e.startdate,e.enddate ")
	boolean isPassWorkDay(String id);
	
}
  
