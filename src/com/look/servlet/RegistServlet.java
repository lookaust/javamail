package com.look.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.look.bean.User;
import com.look.dao.UserDao;
import com.look.util.SendMailUtils;
import com.look.util.UUIDUtils;

public class RegistServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		super.init();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		// 封装数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setEmail(email);
		user.setCode(UUIDUtils.getUUID());
		System.out.println(user.getEmail() + "\t" + user.getCode());
		// 注册
		UserDao dao = new UserDao();
		dao.getConn();
		dao.regist(user);
		dao.closeConn();

		// 发送邮件
		try {
			SendMailUtils.sendMail(email, user.getCode());
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head><meta charset='utf-8'/></head><body><p>邮件已经发送到"
					+ user.getEmail() + "中，请登录邮箱点击链接完成验证</p></body></html>");
			out.flush();
			out.close();
		} catch (GeneralSecurityException | MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		super.destroy();
	}
}
