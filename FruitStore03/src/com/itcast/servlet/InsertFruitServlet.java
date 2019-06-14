package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.InsertFruit;
import com.itcast.pojo.Fruit;
//进行插入水果信息的服务器端的Servlet模块InsertFruitServlet
public class InsertFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("服务器端程序 InsertFruitServlet 正在运行中, 正在加载插入水果信息模块...");
		//获取用户输入的需要插入的水果信息
		try {
			String idString = request.getParameter("insertId");
			int id = Integer.parseInt(idString);
			String name = request.getParameter("insertName");
			String priceString = request.getParameter("insertPrice");
			double price = Double.parseDouble(priceString);
			String unit = request.getParameter("insertUnit");
			Fruit fruit = new Fruit(id, name, price, unit);
			//进行插入水果信息操作
			int i = new InsertFruit().insertFruit(fruit);
			//对插入的结果进行判断
			if (i != -1) {
				System.out.println("插入水果信息成功.....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 重定向到管理水果的服务器端Java程序ManagerFruitServlet
		response.sendRedirect("managerFruitServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}