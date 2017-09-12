/**  
 * Project Name:mioa-sys  
 * File Name:TSysParamRepo.java  
 * Package Name:com.mjkj.mioa.sys.dao  
 * Date:2017年9月12日下午12:14:48  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.sys.dao;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.sys.entity.TSysParam;

/**  
 * ClassName:TSysParamRepo   
 * Date:     2017年9月12日 下午12:14:48 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Repository
public interface TSysParamRepository extends JpaRepository<TSysParam, String>
{

	/**
	 * TODO 根据系统变量名查询系统变量信息
	 * @author fsluo  
	 * @param paramName 系统变量名
	 * @return  TSysParam 系统变量实体
	 * @since JDK 1.7
	 */
	TSysParam findSysParamByParamName(String paramName);
	
}
  
