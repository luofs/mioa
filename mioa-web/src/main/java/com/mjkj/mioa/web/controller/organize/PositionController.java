/**  
 * Project Name:mioa-web  
 * File Name:PositionController.java  
 * Package Name:com.mjkj.mioa.web.controller.organize  
 * Date:2017年9月21日上午11:44:13  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.web.controller.organize;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjkj.mioa.common.result.MioaResult;
import com.mjkj.mioa.common.result.MioaResultGenerator;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.entity.TOrgPosition;
import com.mjkj.mioa.org.service.OrgPositionService;
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
	
	@RequestMapping("/findPosition")
	public MioaResult getOrgPosition(@RequestParam("domain") String domain) throws MioaException
	{
		 List<TOrgPosition> data = positionService.findPositionByDomain(domain);
		 MioaResult result = MioaResultGenerator.succeResult(data);
		 result.setCount(data.size());
		 return result;
	}
	
	@RequestMapping(value="/addPosition", method=RequestMethod.POST)
	public MioaResult addPositon(PositionVO positionvo) throws MioaException
	{
		TOrgPosition position = new TOrgPosition(positionvo.getName(), positionvo.getDesc());
		position = positionService.addPosition(position);
		MioaResult result = MioaResultGenerator.succeResult(position);
		 result.setCount(1);
		 return result;
	}
	
	@RequestMapping(value="/deletePosition", method=RequestMethod.POST)
	public MioaResult deletePosition(String id) throws MioaException
	{
		positionService.removePosition(id);
		return new MioaResult();
	}
	
}
  
