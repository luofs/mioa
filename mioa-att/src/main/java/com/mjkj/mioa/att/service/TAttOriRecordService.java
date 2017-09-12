/**  
 * Project Name:mioa-att  
 * File Name:TAttOriRecord.java  
 * Package Name:com.mjkj.mioa.att.service  
 * Date:2017年9月12日上午11:06:02  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.service;  

import java.util.Date;

import com.mjkj.mioa.att.entity.TAttOriRecord;
import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:TAttOriRecordService  
 * Date:     2017年9月12日 上午11:06:02 
 * @author   fsluo  
 * @version    打卡原始记录服务
 * @since    JDK 1.7  
 * @see        
 */
public interface TAttOriRecordService
{
	/**
	 * TODO 添加原始打卡记录
	 * @author fsluo  
	 * @param oriRecord 打卡原始记录实体类
	 * @return 打卡原始记录实体类TAttOriRecord
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttOriRecord addAttOriRecord(TAttOriRecord oriRecord) throws MioaException;
	
	/**
	 * TODO 修改原始打卡记录
	 * @author fsluo  
	 * @param oriRecord 原始打卡记录实体TAttOriRecord
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateAttOriRecord(TAttOriRecord oriRecord) throws MioaException;
	
	/**
	 * TODO 根据用户id和打卡日期查询原始打卡记录(需判空)
	 * @author fsluo  
	 * @param id
	 * @return 原始打卡记录实体TAttOriRecord
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TAttOriRecord findAttOriRecordByUserIdAndRecordDate(String userid, Date recordDate) throws MioaException;
}
  
