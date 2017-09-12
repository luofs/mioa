/**  
 * Project Name:mioa-sys  
 * File Name:DBUtil.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年9月12日下午3:23:19  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**  
 * ClassName:DBUtil   
 * Date:     2017年9月12日 下午3:23:19 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Repository
public interface DBUtil extends JpaRepository
{
	@Query("select ?1 from ?2 where ?3")
	String findOneBySql(String field, String tableName, String where);
}
  
