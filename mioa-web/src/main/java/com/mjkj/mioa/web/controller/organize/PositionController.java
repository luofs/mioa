/**  
 * Project Name:mioa-web  
 * File Name:PositionController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年9月21日上午11:44:13  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.service.OrgDeptPositService;
import com.mjkj.mioa.org.service.OrgPositionService;
import com.mjkj.mioa.web.util.ThreadLocalVar;
import com.mjkj.mioa.web.vo.page.PageVO;
import com.mjkj.mioa.web.vo.position.PositionVO;

/**  
 * ClassName:PositionController   
 * Date:     2017年9月21日 上午11:44:13 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        岗位请求入口
 */
@RestController
@RequestMapping("/position")
public class PositionController
{
	
	@Autowired
	private OrgPositionService positionService;
	@Autowired
	private OrgDeptPositService deptPositService;
	
	@RequestMapping("/findPosition")
	public MioaResult getOrgPosition(PageVO pageVO) throws MioaException
	{
		TOrgPosition parem = new TOrgPosition();
		parem.setDomain(ThreadLocalVar.get().getDomain());
		Page<TOrgPosition> positList = positionService.findPositionByPage(pageVO.getPage(), pageVO.getLimit(), parem);
		List<PositionVO> volist = new ArrayList<PositionVO>(positList.getContent().size());
		for(TOrgPosition posit : positList)
		{
			PositionVO vo = new PositionVO();
			org.springframework.beans.BeanUtils.copyProperties(posit, vo);
			volist.add(vo);
		}
		MioaResult result = MioaResultGenerator.succeResult(volist);
		result.setCount(positList.getTotalElements());
		
		 return result;
	}
	
	@RequestMapping(value="/addOrUpdatePosition", method=RequestMethod.POST)
	public MioaResult addPositon(PositionVO positionvo) throws MioaException
	{
		MioaResult result = null;
		//新增
		if(StringUtils.isEmpty(positionvo.getId()))
		{
			TOrgPosition position = new TOrgPosition(positionvo.getName(), positionvo.getPositdesc(), ThreadLocalVar.get().getDomain());
			position = positionService.addPosition(position);
			result = MioaResultGenerator.succeResult(position);
			result.setCount(1);
		}
		//更改
		else
		{
			TOrgPosition position = positionService.findPositionById(positionvo.getId());
			position.setName(positionvo.getName());
			position.setPositdesc(positionvo.getPositdesc());
			positionService.updatePosition(position);
			result = MioaResultGenerator.succeResult(position);
			result.setCount(1);
		}
		return result;
	}
	
	@RequestMapping(value="/deletePosition", method=RequestMethod.POST)
	public MioaResult deletePosition(@RequestParam("ids[]")String[] ids) throws MioaException
	{
		for(String id : ids)
		{
			positionService.removePosition(id);
		}
		return new MioaResult();
	}
	
	@RequestMapping("/findDeptid")
	public MioaResult findDeptidOfPosition(@RequestParam("id")String id)
	{
		List<String> deptids = deptPositService.findDeptidByPostid(id);
		MioaResult result = MioaResultGenerator.succeResult(deptids);
		result.setCount(deptids.size());
		return result;
	}
	
	/**
	 * 职位分配
	 * @author fsluo  
	 * @param postid 职位id
	 * @param orgids 分配给的部门id
	 * @return
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	@RequestMapping("/assignPosition")
	public MioaResult assignPosition(@RequestParam("positid")String postid, @RequestParam("orgids[]")String orgids[]) throws MioaException
	{
		deptPositService.batchAddDeptPosit(postid, orgids);
		return new MioaResult();
	}
	
	
	
}
  
