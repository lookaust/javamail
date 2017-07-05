package servlet;

import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.Messaging.SyncScopeHelper;

import bean.UserBean;
import dao.UserDao;
import util.*;

public class RegistServlet extends HttpServlet {
	public void init() throws ServletException {
		super.init();
	}

	public void service(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		// 封装数据
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setCode(UUIDUtils.getUUID());
		System.out.println(user.getEmail());
		// 注册
		UserDao dao = new UserDao();
		dao.getConn();
		dao.regist(user);
		dao.closeConn();

//		// 发送邮件
//		try {
//			SendMailUtils.sendMail(email, user.getCode());
//		} catch (GeneralSecurityException | MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void destroy() {
		super.destroy();
	}
}
