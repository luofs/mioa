/**  
 * Project Name:mioa-sys  
 * File Name:TSysParamService.java  
 * Package Name:com.mjkj.mioa.sys.service  
 * Date:2017年9月12日上午11:54:02  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.sys.service;  

import org.springframework.data.domain.Page;

import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.sys.entity.TSysParam;

/**  
 * ClassName:TSysParamService   
 * Date:     2017年9月12日 上午11:54:02 
 * @author   fsluo  
 * @version  1.0  
 * @since    JDK 1.7 
 * @see       系统变量服务接口 
 */
public interface TSysParamService
{
	/**
	 * TODO 添加系统变量
	 * @author fsluo  
	 * @param sysParam 系统变量实体
	 * @return TSysParam 系统变量实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TSysParam addSysParam(TSysParam sysParam) throws MioaException;
	
	/**
	 * TODO 更新系统变量
	 * @author fsluo  
	 * @param sysParam系统变量实体
	 * @return true/false
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public boolean updateSysParam(TSysParam sysParam) throws MioaException;
	
	/**
	 * TODO 根据变量名查询系统变量信息
	 * @author fsluo  
	 * @param paramName 系统变量名
	 * @return TSysParam 系统变量实体
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public TSysParam findSysParamByParamName(String paramName) throws MioaException;
	
	/**
	 * TODO 分页查询变量实体
	 * @author fsluo  
	 * @param page 第几页
	 * @param pageSize 每页显示条数
	 * @return Page<TSysParam>
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public Page<TSysParam> findSysParamPage(int page, int pageSize) throws MioaException;
	
	/**
	 * TODO 根据变量名返回变量值
	 * @author fsluo  
	 * @param paramName 变量名
	 * @return 变量值
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public String findSysParamValue(String paramName) throws MioaException;
}
  
