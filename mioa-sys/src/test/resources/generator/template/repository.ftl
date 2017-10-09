/**  
 * Project Name:${project_name}  
 * File Name:${modelNameUpperCamel}Repository.java  
 * Package Name:${basePackage}.dao  
 * Date:${date} 
 * Copyright (c) ${year}, 597668255@qq.com All Rights Reserved.  
 */

package ${basePackage}.dao;
import ${basePackage}.entity.${modelNameUpperCamel};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**  
 * ClassName: ${modelNameUpperCamel}Repository  
 * date: ${date}  
 *  
 * @author ${user}  
 * @version ${project_version}
 * @since ${jdk_version}  
 * @see 
 */
 @Repository
public interface ${modelNameUpperCamel}Repository extends JpaRepository<${modelNameUpperCamel}, String> {

	List<${modelNameUpperCamel}> findAllByDomain(String domain);
}
