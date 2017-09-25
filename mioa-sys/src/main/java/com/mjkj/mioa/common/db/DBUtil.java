/**  
 * Project Name:mioa-sys  
 * File Name:DBUtil.java  
 * Package Name:com.mjkj.mioa.common  
 * Date:2017年9月12日下午3:23:19  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.common.db;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class DBUtil 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String QUERY_BASE = "select ?1 from ?2 where ?3";
	
	public String findTableFieldWithCondition(String field, String tableName, String where)
	{
		String[] args = new String[]{tableName, field, where};
		return jdbcTemplate.queryForObject(QUERY_BASE, args, String.class);
	}
}
  
