/**  
 * Project Name:mioa-org  
 * File Name:OrgUserRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年11月10日下午11:18:15  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;   

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mjkj.mioa.org.entity.TOrgUser;


/**  
 * ClassName:OrgUserRepository <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月10日 下午11:18:15 <br/>  
 * @author   Administrator  
 * @version    
 * @since    JDK 1.7.0_67  
 * @see        
 */
@Repository
public interface OrgUserRepository extends JpaRepository<TOrgUser, String>
{

	TOrgUser findByName(String name);
}
  