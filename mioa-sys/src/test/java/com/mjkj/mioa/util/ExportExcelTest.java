/**  
 * Project Name:mioa-sys  
 * File Name:ExportExcelTest.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2017年9月14日下午5:08:05  
 * Copyright (c) 2017, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mjkj.mioa.common.WebDto;

/**  
 * ClassName:ExportExcelTest   
 * Date:     2017年9月14日 下午5:08:05 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExportExcelTest
{
	@Test
    public void test() throws Exception {
        List<WebDto> list = new ArrayList<WebDto>();
        list.add(new WebDto("知识林", "http://www.zslin.com", "admin", "111111", 555));
        list.add(new WebDto("权限系统", "http://basic.zslin.com", "admin", "111111", 111));
        list.add(new WebDto("校园网", "http://school.zslin.com", "admin", "222222", 333));

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "网站信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());

        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "web-info-template.xls", new FileOutputStream("D:/temp/out.xls"),
                list, WebDto.class);
    }

    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
}
}
  
