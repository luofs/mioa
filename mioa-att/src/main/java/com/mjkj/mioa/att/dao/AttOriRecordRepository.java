/**  
 * Project Name:mioa-att  
 * File Name:TAttOriRecordRepository.java  
 * Package Name:com.mjkj.mioa.att.dao  
 * Date:2017年9月12日上午11:13:12  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.att.dao;  

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjkj.mioa.att.entity.TAttOriRecord;

/**  
 * ClassName:TAttOriRecordRepository   
 * Date:     2017年9月12日 上午11:13:12 
 * @author   fsluo  
 * @version   1.0 
 * @since    JDK 1.6  
 * @see       考勤原始打卡记录数据库交互类 
 */
@Repository
public interface AttOriRecordRepository extends JpaRepository<TAttOriRecord, String>
{

	/**
	 * TODO 根据用户id和打卡日期查询原始打卡记录
	 * @author fsluo  
	 * @param userid 用户id
	 * @param recordDate 打卡记录
	 * @return  TAttOriRecord实体
	 * @since JDK 1.7
	 */
	TAttOriRecord findAttOriRecordByUserIdAndRecordDate(String userid,Date recordDate);
	
}
  
