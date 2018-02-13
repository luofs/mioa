/**  
 * Project Name:mioa-org  
 * File Name:OrgUserPositionRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2018年2月8日下午5:32:29  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mjkj.mioa.org.entity.TOrgUserPosition;
import com.mjkj.mioa.org.entity.TOrgUserPositionPK;

/**  
 * ClassName:OrgUserPositionRepository   
 * Date:     2018年2月8日 下午5:32:29 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
public interface OrgUserPositionRepository extends JpaRepository<TOrgUserPosition, TOrgUserPositionPK>
{

	@Query("from TOrgUserPosition t where t.id.userid = :userid")
	List<TOrgUserPosition> findPositionByUserid(@Param("userid")String userid);
	
}
  
