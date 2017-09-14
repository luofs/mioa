/**  
 * Project Name:mioa-att  
 * File Name:TAttOriRecordServiceImpl.java  
 * Package Name:com.mjkj.mioa.att.service.impl  
 * Date:2017年9月12日上午11:12:07  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service.impl;  

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mjkj.mioa.att.dao.AttOriRecordRepository;
import com.mjkj.mioa.att.entity.TAttOriRecord;
import com.mjkj.mioa.att.service.AttOriRecordService;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:TAttOriRecordServiceImpl   
 * Date:     2017年9月12日 上午11:12:07 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7  
 * @see        原始打卡记录服务实现类
 */
@Service
public class AttOriRecordServiceImpl implements AttOriRecordService
{
	
	@Autowired
	private AttOriRecordRepository oriRecordRepository;
	
	@Override
	public TAttOriRecord addAttOriRecord(TAttOriRecord oriRecord)
			throws MioaException
	{
		if(oriRecord == null || StringUtils.isEmpty(oriRecord.getUserid()) || oriRecord.getRecordDate() == null )
		{
			throw new MioaException("参数不完整");
		}
		TAttOriRecord dbOriRecord = findAttOriRecordByUserIdAndRecordDate(oriRecord.getUserid(), oriRecord.getRecordDate());
		if(dbOriRecord != null)
		{
			throw new MioaException("该用户当日打卡记录已存在，不可重复插入");
		}
		return oriRecordRepository.save(oriRecord);
	}
	
	@Override
	public boolean updateAttOriRecord(TAttOriRecord oriRecord)
			throws MioaException
	{
		TAttOriRecord dbOriRecord = findAttOriRecordByUserIdAndRecordDate(oriRecord.getUserid(), oriRecord.getRecordDate());
		if(dbOriRecord == null)
		{
			throw new MioaException("该用户当日打卡记录不存在");
		}
		oriRecordRepository.save(oriRecord);
		return false;
	}
	
	@Override
	public TAttOriRecord findAttOriRecordByUserIdAndRecordDate(String userid, Date recordDate)
			throws MioaException
	{
		return oriRecordRepository.findAttOriRecordByUserIdAndRecordDate(userid, recordDate);
	}
	
}
  
