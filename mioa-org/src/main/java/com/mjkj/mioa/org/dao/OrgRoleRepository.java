/**  
 * Project Name:mioa-org  
 * File Name:OrgRoleRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年11月15日下午10:41:49  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;   

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mjkj.mioa.org.entity.TOrgRole;

/**  
 * ClassName:OrgRoleRepository <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月15日 下午10:41:49 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Repository
public interface OrgRoleRepository extends JpaRepository<TOrgRole, String>
{

	List<TOrgRole> findRoleByDomain(String domain);

}
  