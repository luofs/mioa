/**  
 * Project Name:mioa-org  
 * File Name:OrgUserRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年11月14日上午11:03:37  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.org.entity.TOrgUser;

/**  
 * ClassName:OrgUserRepository   
 * Date:     2017年11月14日 上午11:03:37 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Repository
public interface OrgUserRepository extends JpaRepository<TOrgUser, String>
{

	TOrgUser findByName(String name);

	@Query("update t_org_user set disable = ? where id = ?")
	void disableOrEnableUser(String id, byte flag);
	
}
  
