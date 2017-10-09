/**  
 * Project Name:${project_name}  
 * File Name:${modelNameUpperCamel}ServiceImpl.java  
 * Package Name:${basePackage}.service.impl  
 * Date:${date}
 * Copyright (c) ${year}, 597668255@qq.com All Rights Reserved.  
 */

package ${basePackage}.service.impl;

import java.util.List;
import ${basePackage}.dao.${modelNameUpperCamel}Repository;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import com.mjkj.mioa.exception.MioaException;
import javax.annotation.Resource;


/**  
 * ClassName: ${modelNameUpperCamel}ServiceImpl  
 * date: ${date}  
 *  
 * @author ${user}  
 * @version ${project_version}
 * @since ${jdk_version}  
 * @see 
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Repository ${modelNameLowerCamel}Repository;
    
    @Override
	public ${modelNameUpperCamel} add${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) throws MioaException
	{
		//参数完整性判断
		if(${modelNameLowerCamel} == null)
		{
			throw new MioaException("参数不完整");
		}
		//数据重复性判断 db${modelNameUpperCamel}从数据库取
		${modelNameUpperCamel} db${modelNameUpperCamel} = null; 
		if(db${modelNameUpperCamel}  != null)
		{
			throw new MioaException("系统已存在该参数");
		}
		return ${modelNameLowerCamel}Repository.save(${modelNameLowerCamel});
	}
	
	@Override
	public boolean remove${modelNameUpperCamel}(String id) throws MioaException
	{
		if (! ${modelNameLowerCamel}Repository.exists(id))
		{
			return false;
		}
		${modelNameLowerCamel}Repository.delete(id);
		return true;
	}
	
	@Override
	public boolean update${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) throws MioaException
	{
		${modelNameUpperCamel} db${modelNameUpperCamel} = ${modelNameLowerCamel}Repository.findOne(${modelNameLowerCamel}.getId());
		if (db${modelNameUpperCamel} == null)
		{
			throw new MioaException("未找到对应数据");
		}
		${modelNameLowerCamel}Repository.save(${modelNameLowerCamel});
		return true;
	}
	
	@Override
	public ${modelNameUpperCamel} find${modelNameUpperCamel}ById(String id) throws MioaException
	{
		return ${modelNameLowerCamel}Repository.findOne(id);
	}
	
	@Override
	public List<${modelNameUpperCamel}> findAll${modelNameUpperCamel}(String domain) throws MioaException
	{
		return ${modelNameLowerCamel}Repository.findAllByDomain(domain);
	}
	
	@Override
	public Page<${modelNameUpperCamel}> find${modelNameUpperCamel}Page(int page, int pageSize) throws MioaException
	{
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, pageSize, sort);  
		return ${modelNameLowerCamel}Repository.findAll(pageable);
	}

}
