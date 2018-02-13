/**  
 * Project Name:mioa-org  
 * File Name:OrgDeptPositServiceImpl.java  
 * Package Name:com.mjkj.mioa.org.service.impl  
 * Date:2018年2月6日下午3:27:30  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.org.service.impl;  

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.org.dao.OrgDeptPositRepository;
import com.mjkj.mioa.org.entity.TOrgDeptPosition;
import com.mjkj.mioa.org.entity.TOrgDeptPositionPK;
import com.mjkj.mioa.org.service.OrgDeptPositService;

/**  
 * ClassName:OrgDeptPositServiceImpl   
 * Date:     2018年2月6日 下午3:27:30 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@Service
public class OrgDeptPositServiceImpl implements OrgDeptPositService
{
	
	@Autowired
	OrgDeptPositRepository orgDeptPositRepository; 
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<String> findDeptidByPostid(String postid)
	{
		return orgDeptPositRepository.findDeptidByPostid(postid);
	}

	@Override
	@Transactional
	public void addDeptPosit(String posid, String deptid) throws MioaException
	{
		TOrgDeptPositionPK pk = new TOrgDeptPositionPK();
		pk.setDeptid(deptid);
		pk.setPosid(posid);
		TOrgDeptPosition dbDeptPost = orgDeptPositRepository.findOne(pk);
		if(dbDeptPost != null)
		{
			throw new MioaException("该机构已拥有该岗位");
		}
		else
		{
			TOrgDeptPosition deptPost = new TOrgDeptPosition();
			deptPost.setId(pk);
			orgDeptPositRepository.save(deptPost) ;
		}
	}

	@Override
	@Transactional
	public void batchAddDeptPosit(String posid, String[] deptids)
	{
		for (int i = 0; i < deptids.length; i++) {
			TOrgDeptPositionPK pk = new TOrgDeptPositionPK();
			pk.setDeptid(deptids[i]);
			pk.setPosid(posid);
			TOrgDeptPosition deptPost = new TOrgDeptPosition();
			deptPost.setId(pk);
			em.persist(deptPost);
			if (i % 30 == 0) {
				em.flush();
				em.clear();
			}
		}
	}
	
}
  
