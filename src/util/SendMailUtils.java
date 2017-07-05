package util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMailUtils {

	public static void sendMail(String to, String code) throws GeneralSecurityException, MessagingException {
//		// session是mail包下的，因为是本地测试，所以第一个参数直接创建默认的即可
//		Session session = Session.getInstance(new Properties(),
//				new Authenticator() {
//					@Override
//					protected PasswordAuthentication getPasswordAuthentication() {
//						return new PasswordAuthentication("1478161802@qq.com",
//								"hsvsqhofljqtjgdi");
//					}
//				});
//
//		// 创建邮件对象
//		Message message = new MimeMessage(session);
//		// 设置发件人，这里我创建了一个server@store.com用于发送邮件
//		try {
//			message.setFrom(new InternetAddress("1478161802@qq.com"));
//			message.setRecipient(RecipientType.TO, new InternetAddress(to));
//			message.setSubject("来自个博网的注册激活邮件");
//			message.setContent(
//					"<a href='http://localhost:8080/RegistMailWeb/active.do'>点我激活</a>",
//					"text/html;charset=utf-8");
//
//			// 发送邮件
//			Transport.send(message);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		 Properties props = new Properties();

		    // 开启debug调试
		    props.setProperty("mail.debug", "true");
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
//		    StringBuilder builder = new StringBuilder();
//		    builder.append("点击测试<a href='http://loc alhost:8080/ssm/listCategory'>listCategory1</a>");
//		    msg.setText(builder.toString());
		    msg.setContent("<a href='http://localhost:8080/javamail/ActiveServlet'>点我激活</a>", "text/html;charset=UTF-8");
		    msg.setFrom(new InternetAddress("1478161802@qq.com"));

		    Transport transport = session.getTransport();
		    transport.connect("smtp.qq.com", "1478161802@qq.com", "hsvsqhofljqtjgdi");

		    transport.sendMessage(msg, new Address[] { new InternetAddress(to) });
		    transport.close();
	}
}
