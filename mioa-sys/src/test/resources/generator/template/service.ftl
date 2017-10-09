/**  
 * Project Name:${project_name}  
 * File Name:${modelNameUpperCamel}Service.java  
 * Package Name:${basePackage}.service  
 * Date:${date}  
 * Copyright (c) ${year}, 597668255@qq.com All Rights Reserved.  
 */

package ${basePackage}.service;
import org.springframework.data.domain.Page;
import ${basePackage}.entity.${modelNameUpperCamel};
import com.mjkj.mioa.exception.MioaException;
import java.util.List;


/**  
 * ClassName: ${modelNameUpperCamel}Service  
 * date: ${date}  
 *  
 * @author ${user}  
 * @version ${project_version}
 * @since ${jdk_version}  
 * @see 
 */
public interface ${modelNameUpperCamel}Service {

	/**  
	 * 持久化 ${modelNameUpperCamel}
	 * @author ${user}  
	 * @param ${modelNameLowerCamel} 
	 * @return ${modelNameUpperCamel} 
	 * @throws MioaException   
	 * @since ${jdk_version}  
	 */
	${modelNameUpperCamel} add${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) throws MioaException;
	
	/**   
	 * 通过主键移除 ${modelNameUpperCamel}
	 * @author ${user}  
	 * @param id 主键 
	 * @return true/false
	 * @throws MioaException  
	 * @since ${jdk_version}  
	 */
	boolean remove${modelNameUpperCamel}(String id) throws MioaException;
	
	/**   
	 * 更新${modelNameUpperCamel}
	 * @author ${user}  
	 * @param ${modelNameLowerCamel} 
	 * @return true/false
	 * @throws MioaException 
	 * @since ${jdk_version}  
	 */
	boolean update${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) throws MioaException;
	
	/**   
	 * 根据主键查询${modelNameUpperCamel}
	 * @author ${user}  
	 * @param id 
	 * @return ${modelNameUpperCamel}
	 * @throws MioaException  
	 * @since ${jdk_version}  
	 */
	${modelNameUpperCamel} find${modelNameUpperCamel}ById(String id) throws MioaException;
	
	/**
	 * 查询域下所有${modelNameUpperCamel}
	 * @author ${user}  
	 * @param domain 域名 
	 * @return List<${modelNameUpperCamel}>
	 * @throws MioaException    
	 * @since ${jdk_version}  
	 */
	List<${modelNameUpperCamel}> findAll${modelNameUpperCamel}(String domain) throws MioaException;
	
	/**   
	 *  分页查询${modelNameUpperCamel}
	 * @author ${user}  
	 * @param page 第几页 
	 * @param pageSize 每页显示条数
	 * @return Page<${modelNameUpperCamel}>
	 * @throws MioaException  
	 * @since ${jdk_version}  
	 */
	Page<${modelNameUpperCamel}> find${modelNameUpperCamel}Page(int page, int pageSize) throws MioaException;
}
