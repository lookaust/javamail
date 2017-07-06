package com.look.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.look.dao.UserDao;

public class ActiveServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		super.init();
	}

	public void service(HttpServletRequest request,
			HttpServletResponse response) {

		// 获取数据
		String code = request.getParameter("code");

		// 数据库判断对应code是否存在，（这里就不进行判断了，直接进行比对）state=1&code=null代表激活
		UserDao dao = new UserDao();
		dao.getConn();
		dao.activeByCode(code);
		dao.closeConn();
		// 重定向success.jsp
		try {
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		super.destroy();
	}
}