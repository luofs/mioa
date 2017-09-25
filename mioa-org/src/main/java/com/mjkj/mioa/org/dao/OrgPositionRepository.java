/**  
 * Project Name:mioa-org  
 * File Name:OrgPositionRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年9月15日上午11:54:46  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.org.entity.TOrgPosition;

/**  
 * ClassName:OrgPositionRepository   
 * Date:     2017年9月15日 上午11:54:46 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        岗位接口数据库交互类
 */
@Repository
public interface OrgPositionRepository extends JpaRepository<TOrgPosition, String>
{

	TOrgPosition findPositionByNameAndDomainAndIsdeleteEquals(String name,String domain, int i);

	List<TOrgPosition> findPositionByDomainAndIsdeleteEquals(String domain, int i);
	
}
  
