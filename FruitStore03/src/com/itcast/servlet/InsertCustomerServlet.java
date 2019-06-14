package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.InsertCustomer;
import com.itcast.pojo.Customer;

//进行添加用户的服务器端的Servlet模块InsertCustomerServlet
public class InsertCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("正在添加用户中...");
		// 获取用户的输入信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		// 进行用户输入信息的插入
		int i = new InsertCustomer().insertCustomer(new Customer(name, password, sex, address, telephone));
		// 对插入信息的结果进行判断
		if (i != -1) {
			System.out.println("用户信息插入成功!");
		} else {
			System.out.println("用户信息插入失败!");
		}
		request.setAttribute("welcome", "用户" + name + "注册成功!");
		// 转发到水果管理界面
		request.getRequestDispatcher("managerFruitServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
