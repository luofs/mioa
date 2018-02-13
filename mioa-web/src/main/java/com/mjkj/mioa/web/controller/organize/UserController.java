/**  
 * Project Name:mioa-web  
 * File Name:UserController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年11月14日上午10:56:52  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.client.UserTokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TMenu;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.entity.TOrgUser;
import com.mjkj.mioa.org.service.OrgUserService;
import com.mjkj.mioa.org.to.OrgUserTO;
import com.mjkj.mioa.web.util.MenuTreeBuilder;
import com.mjkj.mioa.web.util.ThreadLocalVar;
import com.mjkj.mioa.web.vo.menu.MenuVO;
import com.mjkj.mioa.web.vo.page.PageVO;
import com.mjkj.mioa.web.vo.user.UserListVO;
import com.mjkj.mioa.web.vo.user.UserVO;

/**  
 * ClassName:UserController   
 * Date:     2017年11月14日 上午10:56:52 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
@RequestMapping("/user")
public class UserController
{
	
	@Autowired
	private OrgUserService orgUserService;
	
	@RequestMapping("/findUserList")
	public MioaResult getUser(PageVO pageVO) throws MioaException
	{
		Page<TOrgUser> userList = orgUserService.findUserByPage(pageVO.getPage(), pageVO.getLimit());
		List<UserListVO> volist = new ArrayList<UserListVO>(userList.getContent().size());
		for(TOrgUser user : userList)
		{
			UserListVO vo = new UserListVO();
			org.springframework.beans.BeanUtils.copyProperties(user, vo);
			volist.add(vo);
		}
		MioaResult result = MioaResultGenerator.succeResult(volist);
		result.setCount(userList.getTotalElements());
		return result;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public MioaResult addUser(UserVO uservo) throws Exception
	{
		OrgUserTO userto = new OrgUserTO();
		BeanUtils.copyProperties(userto, uservo);
		userto.setDomain(ThreadLocalVar.get().getDomain());
		//用户岗位
		if(uservo.getSelectPostIds()!=null && uservo.getSelectPostIds().size() >0){
			Map<String, String> deptPositmap = new HashMap<String, String>(uservo.getSelectPostIds().size());
			for(String deptAndpostid : uservo.getSelectPostIds()){
				String[] dpid = deptAndpostid.split(":");
				if(dpid.length != 2){
					throw new MioaException("提交的岗位不合法");
				}
				deptPositmap.put(dpid[0], dpid[1]);
			}
			userto.setDeptPositmap(deptPositmap);
		}
		orgUserService.addUser(userto);
		return new MioaResult();
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public MioaResult updateUser(UserVO uservo) throws MioaException
	{
		try
		{
			TOrgUser user = new TOrgUser();
			BeanUtils.copyProperties(user, uservo);
			orgUserService.updateUser(user);
		} catch (Exception e)
		{
			e.printStackTrace();  
			
		}
		return new MioaResult();
	}
	
	@RequestMapping(value="/disableOrEnableUser", method = RequestMethod.POST)
	public MioaResult disableOrEnableUser(@RequestParam("id")String id, @RequestParam("flag") byte flag)
	{
		orgUserService.disableOrEnableUser(id, flag);
		return new MioaResult();
	}
	
	@RequestMapping(value="/findUserMenu")
	public MioaResult findUserMenu() throws MioaException
	{
		TOrgUser user = orgUserService.findById(ThreadLocalVar.get().getUserId());
		List<TMenu> menuList = user.getTMenus();
		List<MenuVO> menuResult = MenuTreeBuilder.buildMenuTree(menuList);
		MioaResult result = MioaResultGenerator.succeResult(menuResult);
		result.setCount(menuResult.size());
		return result;
	}
	
	@RequestMapping("/findUser")
	public MioaResult findUser(@RequestParam("id")String userid) throws MioaException
	{
		TOrgUser user = orgUserService.findById(userid);
		UserVO uservo = new UserVO();
		org.springframework.beans.BeanUtils.copyProperties(user, uservo);
		MioaResult result = MioaResultGenerator.succeResult(uservo);
		return result;
	}
	
	@RequestMapping("/delUser")
	public MioaResult delUser(@RequestParam("id")String userid) throws MioaException
	{
		orgUserService.delUser(userid);
		return MioaResultGenerator.successResult();
	}

}
  
