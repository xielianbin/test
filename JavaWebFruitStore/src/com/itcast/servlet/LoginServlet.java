package com.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itcast.pojo.Customer;
import com.itcast.server.CheckCustomer;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("LoginServlet run ...<br />");
		// 获取请求信息中的用户名
		String name = request.getParameter("name");
		// 获取请求信息中的用户密码
		String password = request.getParameter("password");
		// 调用server层的校验用户信息
		Customer customer = new CheckCustomer().checkCustomer(name, password);
		// 判断是否登录
		if (customer == null) {
			out.println("用户 " + name + "未注册, 请先<b><a href=\"source/register.jsp\">&nbsp;注册</a></b>");
		} else if (customer.getPassword() == null) {
			out.println("用户 " + name + "的密码错误!<h4><a href=\"source/login.jsp\">&nbsp;重新登录</a></h4>");
		} else {
			//转发到水果管理色Servlet服务器端程序ManagerFruitServlet
			request.getRequestDispatcher("managerFruitServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
