package com.itcast.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itcast.dao.SelectFruitList;
import com.itcast.pojo.Fruit;

public class ManagerFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ManagerFruitServlet 正在运行中...");
		// 获取数据库的水果信息
		@SuppressWarnings("unchecked")
		List<Fruit> fruitList = new SelectFruitList().selectFruitList();
		request.setAttribute("fruitList", fruitList);
		request.setAttribute("xinxi", "--欢迎使用水果管理系统--");
		request.setAttribute("welcome", "--欢迎回来,亲爱的用户" + request.getParameter("name") + "--");
		// 转发到managerFruit页面
		request.getRequestDispatcher("/source/managerFruit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
