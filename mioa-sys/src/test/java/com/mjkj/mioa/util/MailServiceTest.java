/**  
 * Project Name:mioa-sys  
 * File Name:MailServiceTest.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2018年1月10日下午5:45:41  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**  
 * ClassName:MailServiceTest   
 * Date:     2018年1月10日 下午5:45:41 
 * @author   fsluo  
 * @version    
 * @since    JDK 1.7 
 * @see        
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest
{
	@Autowired
    private EmailUtil MailService;

    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("ityouknow@126.com","test simple mail"," hello this is simple mail");
    }
    
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        MailService.sendInlineResourceMail("ityouknow@126.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
    
//    @Test 采用邮件模板
//    public void sendTemplateMail() {
//        //创建邮件正文
//        Context context = new Context();
//        context.setVariable("id", "006");
//        String emailContent = templateEngine.process("emailTemplate", context);
//
//        MailService.sendHtmlMail("ityouknow@126.com","主题：这是模板邮件",emailContent);
//    }
}
  
