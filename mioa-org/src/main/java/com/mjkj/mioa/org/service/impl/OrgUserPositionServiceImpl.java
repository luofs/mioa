/**  
 * Project Name:mioa-org  
 * File Name:OrgUserPositionServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2018年2月8日下午5:31:35  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgUserPositionRepository;
import com.mjkj.mioa.org.entity.TOrgUserPosition;
import com.mjkj.mioa.org.entity.TOrgUserPositionPK;
import com.mjkj.mioa.org.service.OrgUserPositionService;

/**  
 * ClassName:OrgUserPositionServiceImpl   
 * Date:     2018年2月8日 下午5:31:35 
 * @author   fsluo  
 * @version    用户职位服务实现类
 * @since    JDK 1.7 
 * @see        
 */
@Service
public class OrgUserPositionServiceImpl implements OrgUserPositionService
{
	@Autowired
	OrgUserPositionRepository orgUserPositionRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public List<TOrgUserPosition> findPositionByUserid(String userid)
	{
		return orgUserPositionRepository.findPositionByUserid(userid);
	}

	@Transactional
	@Override
	public void addUserPosit(String userid, String deptid, String posid) throws MioaException
	{
		TOrgUserPositionPK pk = new TOrgUserPositionPK();
		pk.setUserid(userid);
		pk.setPosid(posid);
		pk.setDeptid(deptid);
		TOrgUserPosition dbUserPosit = orgUserPositionRepository.findOne(pk);
		if(dbUserPosit != null)
		{
			throw new MioaException("该用户已拥有该职位");
		}
		else
		{
			TOrgUserPosition userPosit = new TOrgUserPosition();
			userPosit.setId(pk);
			orgUserPositionRepository.save(userPosit) ;
		}
	}

	@Transactional
	@Override
	public void batchAddUserPosit(String userid, Map<String, String> deptposids) throws MioaException
	{
		for(String deptid : deptposids.keySet()){
			TOrgUserPositionPK pk = new TOrgUserPositionPK();
			pk.setUserid(userid);
			pk.setPosid(deptposids.get(deptid));
			pk.setDeptid(deptid);
			TOrgUserPosition userposit = new TOrgUserPosition();
			userposit.setId(pk);
			em.persist(userposit);
		}
	}
}
  
