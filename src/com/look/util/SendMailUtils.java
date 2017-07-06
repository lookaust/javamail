package com.look.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMailUtils {

	public static void sendMail(String to, String code)
			throws GeneralSecurityException, MessagingException {

		Properties props = new Properties();

		// 开启debug调试
		// props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.qq.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject("本邮件用于测试");
		// send text to the mail
		// StringBuilder builder = new StringBuilder();
		// builder.append("点击测试<a href='http://loc alhost:8080/ssm/listCategory'>listCategory1</a>");
		// msg.setText(builder.toString());
		msg.setContent(
				"<a href='http://localhost:8080/javamail/ActiveServlet?code="
						+ code + "'>点我激活</a>", "text/html;charset=UTF-8");
		msg.setFrom(new InternetAddress("1478161802@qq.com"));

		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", "1478161802@qq.com",
				"hsvsqhofljqtjgdi");

		transport.sendMessage(msg, new Address[] { new InternetAddress(to) });
		transport.close();
	}
}
