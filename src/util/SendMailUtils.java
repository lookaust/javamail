package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtils{

	 public static void sendMail(String to,String code){
	  //session是mail包下的，因为是本地测试，所以第一个参数直接创建默认的即可
	  Session session = Session.getInstance(new Properties(),new Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication(){
	     return new PasswordAuthentication("server@store.com", "111");
	    }
	   });

	  //创建邮件对象
	  Message message = new MimeMessage(session);
	  //设置发件人，这里我创建了一个server@store.com用于发送邮件
	  try {
		message.setFrom(new InternetAddress("server@store.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject("来自个博网的注册激活邮件");
		message.setContent("<a href='http://localhost:8080/RegistMailWeb/active.do'>点我激活</a>","text/html;charset=utf-8");
		
		//发送邮件
		Transport.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 } 
	}
