/**  
 * Project Name:mioa-org  
 * File Name:OrgDeptPositRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2018年2月6日下午3:28:03  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.org.entity.TOrgDeptPosition;
import com.mjkj.mioa.org.entity.TOrgDeptPositionPK;


/**  
 * ClassName:OrgDeptPositRepository   
 * Date:     2018年2月6日 下午3:28:03 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Repository
public interface OrgDeptPositRepository extends JpaRepository<TOrgDeptPosition, TOrgDeptPositionPK>
{

	@Query("select orgdp.id.deptid from TOrgDeptPosition orgdp where orgdp.id.posid=:posid")
	List<String> findDeptidByPostid(@Param("posid")String postid);
	
}
  
