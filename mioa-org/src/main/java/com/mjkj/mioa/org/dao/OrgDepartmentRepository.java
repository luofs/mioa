/**  
 * Project Name:mioa-org  
 * File Name:OrgDepartmentRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年9月15日上午11:23:20  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.org.entity.TOrgDepartment;

/**  
 * ClassName:OrgDepartmentRepository   
 * Date:     2017年9月15日 上午11:23:20 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        部门服务数据库交互类
 */
@Repository
public interface OrgDepartmentRepository extends JpaRepository<TOrgDepartment, String>
{

	TOrgDepartment findDepartmentByNameAndParentid(String name, String parentid);

	List<TOrgDepartment> findAllByDomain(@Param("domain")String domain);

	TOrgDepartment findDepartmentByParentid(String parentId);

	@Query("select t1.name from TOrgDepartment t1, TOrgDepartment t2 where t1.id = t2.parentid and t2.id = :id")
	String findParentDeptName(@Param("id")String id);

}
  
