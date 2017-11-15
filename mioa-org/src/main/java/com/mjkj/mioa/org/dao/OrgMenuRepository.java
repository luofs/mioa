/**  
 * Project Name:mioa-org  
 * File Name:OrgMenuRepository.java  
 * Package Name:com.mjkj.mioa.org.dao  
 * Date:2017年9月15日上午11:03:17  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.dao;  

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mjkj.mioa.org.entity.TMenu;

/**  
 * ClassName:OrgMenuRepository   
 * Date:     2017年9月15日 上午11:03:17 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        菜单服务数据库交互类
 */
@Repository
public interface OrgMenuRepository extends JpaRepository<TMenu, String>
{

	TMenu findMenuByNameAndDomainAndIsdel(String name, String domain, byte isdel);

	List<TMenu> findMenuByDomain(String domain);

	List<TMenu> findMenuByUserIdAndDomain(String userid, String domain);

	List<TMenu> findRoleMenu(String roleid);
	
}
  
