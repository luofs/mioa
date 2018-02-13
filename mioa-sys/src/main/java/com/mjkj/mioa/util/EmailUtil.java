/**  
 * Project Name:mioa-sys  
 * File Name:EmailUtil.java  
 * Package Name:com.mjkj.mioa.util  
 * Date:2018年1月10日下午5:38:21  
 * Copyright (c) 2018, 597668255@qq.com All Rights Reserved.  
 *  
*/  
  
package com.mjkj.mioa.util;  

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**  
 * ClassName:EmailUtil   
 * Date:     2018年1月10日 下午5:38:21 
 * @author   fsluo  
 * @version    1.0
 * @since    JDK 1.7 
 * @see        
 */
public class EmailUtil
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     *  发送简单的邮件
     * @author fsluo  
     * @param receiveEmail 接收邮箱
     * @param subject 邮件主题
     * @param content  邮件内容
     * @since JDK 1.7
     */
    public void sendSimpleMail(String receiveEmail, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(receiveEmail);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
    }
    
    /**
     * 发送带附件邮件
     * @author fsluo  
     * @param receiveEmail 接收邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filePath  附件地址
     * @since JDK 1.7
     */
    public void sendAttachmentsMail(String receiveEmail, String subject, String content, String filePath){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(receiveEmail);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);//多个附件则添加多个helper.addAttachment(fileName, file)

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }
    
    /**
     * 添加静态资源的邮件（邮件中的静态资源一般就是指图片，见测试例子）
     * @author fsluo  
     * @param receiveEmail 接收邮箱
     * @param subject 主题
     * @param content 内容
     * @param rscPath 静态资源地址
     * @param rscId  替换静态资源地址的路径
     * @since JDK 1.7
     */
    public void sendInlineResourceMail(String receiveEmail, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(receiveEmail);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);//多个静态资源该行代码添加多个
            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
  
