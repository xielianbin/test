package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.UpdateFruit;
import com.itcast.pojo.Fruit;

//进行更新的服务器端的Servlet程序UpdateFruitServlet
public class UpdateFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("服务器端程序 UpdateFruitServlet 正在运行中, 正在加载更新水果信息模块...");
		try {
			//获取用户输入的更新水果的信息
			String idString=request.getParameter("updateId");
			int id = Integer.parseInt(idString);
			String name = request.getParameter("updateName");
			String priceString=request.getParameter("updatePrice");
			double price = Double.parseDouble(priceString);
			String unit = request.getParameter("updateUnit");
			Fruit fruit = new Fruit(id, name, price, unit);
			//进行更新水果操作
			int i = new UpdateFruit().updateFruit(fruit);
			//对更新结果进行判断
			if (i != -1)
				System.out.println("更新成功...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//重定向到管理水果的服务器端Java程序ManagerFruitServlet
		response.sendRedirect("managerFruitServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
