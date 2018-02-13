/**  
 * Project Name:mioa-web  
 * File Name:DepartMentController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年11月20日下午5:31:06  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgDepartment;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.service.OrgDepartmentService;
import com.mjkj.mioa.util.DateUtil;
import com.mjkj.mioa.web.util.ThreadLocalVar;
import com.mjkj.mioa.web.vo.dept.DeptVO;
import com.mjkj.mioa.web.vo.position.PositionVO;
/**  
 * ClassName:DepartMentController   
 * Date:     2017年11月20日 下午5:31:06 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RestController
@RequestMapping("/department")
public class DepartMentController
{
	
	@Autowired
	private OrgDepartmentService departmentService;
	
	@RequestMapping("/addOrUpdateDept")
	public MioaResult createDept(TOrgDepartment dept) throws MioaException
	{
		if(StringUtils.isEmpty(dept.getId()))
		{
			dept.setDomain(ThreadLocalVar.get().getDomain());
			dept.setCreatetime(DateUtil.currentTime());
			departmentService.addDepartment(dept);
		}
		else
		{
			departmentService.updateDepartment(dept);
		}
		return MioaResultGenerator.successResult();
	}
	
	@RequestMapping("/findAllDept")
	public MioaResult findAllDept() throws MioaException
	{
		List<TOrgDepartment> allDept = departmentService.findAllDepartment(ThreadLocalVar.get().getDomain());
		List<DeptVO> deptvolist = new ArrayList<DeptVO>(allDept.size());
		for(TOrgDepartment dept : allDept){
			DeptVO deptvo = new DeptVO();
			BeanUtils.copyProperties(dept, deptvo);
			if(dept.getParentNames()!=null && dept.getParentNames().size() > 0 ){
				deptvo.setParentName(dept.getParentNames().get(0));
			}
			deptvolist.add(deptvo);
		}
		return MioaResultGenerator.succeResult(deptvolist);
	}
	
	@RequestMapping("/findDeptById")
	public MioaResult findDeptById(@RequestParam("id")String id) throws MioaException
	{
		TOrgDepartment dept = departmentService.findDepartmentById(id);
		String parentDeptName = departmentService.findParentDeptName(id);
		DeptVO deptvo = new DeptVO();
		BeanUtils.copyProperties(dept, deptvo);
		deptvo.setParentName(parentDeptName);
		return MioaResultGenerator.succeResult(deptvo);
	}
	
	@RequestMapping("/findDeptPost")
	public MioaResult findDeptPosition(@RequestParam("id")String deptid) throws MioaException
	{
		TOrgDepartment dept = departmentService.findDepartmentById(deptid);
		List<TOrgPosition> positList = dept.getTOrgPositions();
		List<PositionVO> volist = new ArrayList<PositionVO>(positList.size());
		for(TOrgPosition posit : positList)
		{
			PositionVO vo = new PositionVO();
			org.springframework.beans.BeanUtils.copyProperties(posit, vo);
			volist.add(vo);
		}
		MioaResult result = MioaResultGenerator.succeResult(volist);
		result.setCount(positList.size());
		 return result;
	}
	
	@RequestMapping(value="/delDept", method=RequestMethod.POST)
	public MioaResult delDept(@RequestParam("id")String id) throws MioaException
	{
		departmentService.delDept(id);
		return MioaResultGenerator.succeResult(id);
	}
}
  
