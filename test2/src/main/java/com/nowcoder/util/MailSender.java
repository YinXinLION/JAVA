package com.nowcoder.util;




import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Map;
import java.util.Properties;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by 殷鑫 on 2017/2/14.
 */
@Service
public class MailSender implements InitializingBean{
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);
    private JavaMailSenderImpl mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    public boolean sendWithHTMLTemplate(String to, String subject, String template, Map<String, Object> model){
        try {

            String nick = MimeUtility.encodeText("管理员");//昵称
            //设置发送方
            InternetAddress from = new InternetAddress(nick + "<yinxinlion@163.com>");//发件人
            MimeMessage mimeMessage = mailSender.createMimeMessage();//邮件正文
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);//设置正文
            String result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, "UTF-8", model);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);//标题
            mimeMessageHelper.setText(result,true);
            mailSender.send(mimeMessage);
            return true;
        }catch (Exception e){
            logger.error("发送失败"+e.getMessage());
            return false;
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        mailSender = new JavaMailSenderImpl();
        mailSender.setUsername("yinxinlion@163.com");
        mailSender.setPassword("a12345");
        mailSender.setHost("smtp.163.com");
        mailSender.setPort(465);//查找smtp端口
        mailSender.setProtocol("smtps");//smtp+ssl
        mailSender.setDefaultEncoding("utf8");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.ssl.enable", true);//开启ssl
        mailSender.setJavaMailProperties(javaMailProperties);
    }
}
