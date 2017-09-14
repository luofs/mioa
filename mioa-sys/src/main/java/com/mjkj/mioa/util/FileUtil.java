/**  
 * Project Name:mioa-sys  
 * File Name:FileUtil.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月14日下午2:27:15  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:FileUtil   
 * Date:     2017年9月14日 下午2:27:15 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        文件相关工具类
 */
public class FileUtil
{
	
	private static final Path rootLocation = Paths.get("/upload/file");
	
	/**
	 * TODO 保存文件，如果存在则覆盖
	 * @author fsluo  
	 * @param file MultipartFile
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public static void saveFile(MultipartFile file) throws MioaException
	{
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(file.isEmpty())
		{
			throw new MioaException("Failed to store empty file " + filename);
		}
		try
		{
			Files.copy(file.getInputStream(), rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e)
		{
			e.printStackTrace();  
			throw new MioaException("存储文件失败");
		}
	}
	
	/**
	 * TODO 加载文件
	 * @author fsluo  
	 * @param filename 文件名
	 * @return  Path
	 * @since JDK 1.7
	 */
	public static Path loadFile(String filename)
	{
		return rootLocation.resolve(filename);
	}
	
	/**
	 * TODO 加载文件（文件必须存在且可读）
	 * @author fsluo  
	 * @param filename 文件名
	 * @return Resource
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	public static Resource loadFileAsResource(String filename) throws MioaException
	{
		try
		{
			Path file = loadFile(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable())
			{
				return resource;
			} 
			else
			{
				throw new MioaException("文件不存在或不可读");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new MioaException("加载文件失败");
		}
	}
	
	/**
	 * TODO 移除文件
	 * @author fsluo  
	 * @param filename 文件名 
	 * @since JDK 1.7
	 */
	public static void removeFile(String filename)
	{
		File file = new File(filename);
		FileSystemUtils.deleteRecursively(file);
	}
}
  
