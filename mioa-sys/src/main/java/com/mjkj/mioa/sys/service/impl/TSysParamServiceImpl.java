/**  
 * Project Name:mioa-sys  
 * File Name:TSysParamServiceImpl.java  
 * Package Name:com.mjkj.mioa.sys.service.impl  
 * Date:2017年9月12日下午12:11:41  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.sys.service.impl;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mjkj.mioa.common.db.DBUtil;
import com.mjkj.mioa.exception.MioaException;
import com.mjkj.mioa.sys.dao.TSysParamRepository;
import com.mjkj.mioa.sys.entity.TSysParam;
import com.mjkj.mioa.sys.service.TSysParamService;
import com.mjkj.mioa.util.GroovyUtil;

/**  
 * ClassName:TSysParamServiceImpl   
 * Date:     2017年9月12日 下午12:11:41 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see       系统变量服务接口 
 */
@Service
public class TSysParamServiceImpl implements TSysParamService
{
	
	@Autowired
	private TSysParamRepository sysParamRepository;
	@Autowired
	private DBUtil dbutil;
	
	@Override
	public TSysParam addSysParam(TSysParam sysParam) throws MioaException
	{
		if(sysParam == null || StringUtils.isEmpty(sysParam.getParamName()))
		{
			throw new MioaException("参数不完整");
		}
		TSysParam dbSysparam = findSysParamByParamName(sysParam.getParamName());
		if(dbSysparam != null)
		{
			throw new MioaException("系统已存在该参数");
		}
		return sysParamRepository.save(sysParam);
	}
	
	@Override
	public boolean updateSysParam(TSysParam sysParam) throws MioaException
	{
		TSysParam dbSysparam = findSysParamByParamName(sysParam.getParamName());
		if(dbSysparam == null)
		{
			throw new MioaException("系统未找到对应记录");
		} 
		sysParamRepository.save(sysParam);
		return true;
	}
	
	@Override
	public TSysParam findSysParamByParamName(String paramName)
			throws MioaException
	{
		return sysParamRepository.findSysParamByParamName(paramName);
	}
	
	@Override
	public Page<TSysParam> findSysParamPage(int page, int pageSize)
			throws MioaException
	{
		Sort sort = new Sort(Direction.ASC, "param_name");
		Pageable pageable = new PageRequest(page, pageSize, sort);  
		return sysParamRepository.findAll(pageable);
	}
	
	@Override
	public String findSysParamValue(String paramName) throws MioaException
	{
		TSysParam dbSysparam = findSysParamByParamName(paramName);  
		if(dbSysparam == null)
		{
			throw new MioaException("系统未找到对应记录");
		}
		//1. 通过groovy脚本计算
		if(!StringUtils.isEmpty(dbSysparam.getGroovyScript()))
		{
			Object args[] = {};
			Object obj = GroovyUtil.invokeGroovy(dbSysparam.getGroovyScript(), args);
			return obj.toString();
		} 
		//2. 通过数据库表取值
		else if(!StringUtils.isEmpty(dbSysparam.getParamTable()) && !StringUtils.isEmpty(dbSysparam.getParamField()))
		{
			String field = dbSysparam.getParamField();
			//判断聚合函数
			if(StringUtils.isEmpty(dbSysparam.getAggregateFunction()))
			{
				field = dbSysparam.getAggregateFunction() + "(" + field + ")";
			}
			String tableName = dbSysparam.getParamTable();
			String where = "";
			return dbutil.findOneBySql(field, tableName, where);
		}
		//3. 取默认值
		return dbSysparam.getDefaultValue();
	}
	
}
  
