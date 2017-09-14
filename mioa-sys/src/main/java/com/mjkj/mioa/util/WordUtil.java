/**  
 * Project Name:mioa-sys  
 * File Name:WordUtil.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月14日下午3:19:31  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import com.mjkj.mioa.exception.MioaException;

/**  
 * ClassName:WordUtil   
 * Date:     2017年9月14日 下午3:19:31 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        word文件操作类
 */
public class WordUtil
{
	
	/**
	 * TODO 填充word文件（需替换的内容用${}，eg:${ulr} 将被替换存储data中url的值）
	 * @author fsluo  
	 * @param file 需被填充的文件
	 * @param data 数据集合
	 * @param exportFile 最终文件
	 * @throws MioaException  
	 * @since JDK 1.7
	 */
	@SuppressWarnings("resource")
	public static void fillWord(File file, Map<String,String> data, String exportFile) throws MioaException
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(file);
			HWPFDocument document = new HWPFDocument(inputStream);
			//读取word内容
			Range bodyRange = document.getRange();
			//填充内容
			for (Map.Entry<String, String> entry : data.entrySet())
			{
				bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
			}
			//导出到文件
		    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		    document.write(byteArrayOutputStream);
		    OutputStream outputStream = new FileOutputStream(exportFile);
		    outputStream.write(byteArrayOutputStream.toByteArray());
		    outputStream.close();
		} catch (Exception e)
		{
			e.printStackTrace();  
			throw new MioaException("填充word文件失败");
		} 
	}
	
}
  
