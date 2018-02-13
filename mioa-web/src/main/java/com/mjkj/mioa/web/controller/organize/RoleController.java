/**  
 * Project Name:mioa-web  
 * File Name:RoleController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2018年2月12日下午2:23:46  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.org.entity.TOrgRole;
import com.mjkj.mioa.org.service.OrgRoleService;
import com.mjkj.mioa.web.util.ThreadLocalVar;
import com.mjkj.mioa.web.vo.page.PageVO;
import com.mjkj.mioa.web.vo.role.RoleVO;

/**  
 * ClassName:RoleController   
 * Date:     2018年2月12日 下午2:23:46 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see      角色操作请求入口  
 */
@RestController
@RequestMapping("/role")
public class RoleController
{
	
	@Autowired
	OrgRoleService orgRoleService;
	
	@RequestMapping("/findRole")
	public MioaResult findRole(PageVO pagevo)
	{
		TOrgRole parem = new TOrgRole();
		parem.setDomain(ThreadLocalVar.get().getDomain());
		parem.setIsdel((byte)0);
		Page<TOrgRole> roleList = orgRoleService.findRoleByPage(pagevo.getPage(), pagevo.getLimit(), parem);
		List<RoleVO> volist = new ArrayList<RoleVO>(roleList.getContent().size());
		for(TOrgRole role : roleList)
		{
			RoleVO vo = new RoleVO();
			org.springframework.beans.BeanUtils.copyProperties(role, vo);
			volist.add(vo);
		}
		MioaResult result = MioaResultGenerator.succeResult(volist);
		result.setCount(roleList.getTotalElements());
		
		 return result;
	}
	
	@RequestMapping(value="/addOrUpdateRole", method=RequestMethod.POST)
	public MioaResult editRole(RoleVO rolevo)
	{
		if(StringUtils.isEmpty(rolevo.getId()))
		{
			//新增
			TOrgRole role = new TOrgRole();
			BeanUtils.copyProperties(rolevo, role);
			role.setDomain(ThreadLocalVar.get().getDomain());
			orgRoleService.addRole(role);
		}
		else
		{
			//编辑
			TOrgRole role = orgRoleService.findRoleById(rolevo.getId());
			role.setDescr(rolevo.getDescr());
			role.setName(rolevo.getName());
			orgRoleService.updateRole(role);
		}
		return  MioaResultGenerator.successResult();
	}
	
	@RequestMapping(value="/deleteRole", method=RequestMethod.POST)
	public MioaResult deleteRole(@RequestParam("ids[]")String[] ids) throws Exception
	{
		orgRoleService.delete(ids);
		return MioaResultGenerator.successResult();
	}
}
  
