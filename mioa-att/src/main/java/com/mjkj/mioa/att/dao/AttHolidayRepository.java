/**  
 * Project Name:mioa-att  
 * File Name:AttHolidayRepository.java  
 * Package Name:com.mjkj.mioa.att.dao  
 * Date:2017年9月13日下午3:46:36  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.dao;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.att.entity.TAttHoliday;

/**  
 * ClassName:AttHolidayRepository   
 * Date:     2017年9月13日 下午3:46:36 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        考勤假期定义数据库交互类
 */
@Repository
public interface AttHolidayRepository extends JpaRepository<TAttHoliday, String>
{

	/**
	 * TODO 找出域下面所有的假期
	 * @author fsluo  
	 * @param domain
	 * @return  1.0
	 * @since JDK 1.7
	 */
	List<TAttHoliday> findHolidayByDomain(String domain);
	
}
  
