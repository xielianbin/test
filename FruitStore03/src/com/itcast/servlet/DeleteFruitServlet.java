package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.DeleteFruit;
//删除水果信息的服务器端Servlet模块DeleteFruitServlet
public class DeleteFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("服务器端程序 DeleteFruitServlet 正在运行中, 正在加载删除水果信息模块...");
		try {
			// 获取用户输入的删除的水果ID的值
			String idString = request.getParameter("deleteId");
			int id = Integer.parseInt(idString);
			System.out.println("deleteFruitServlet 正在运行中...");
			System.out.println("正在删除id=" + "的水果数据中...");
			//进行删除操作
			int i = new DeleteFruit().deleteFruit(id);
			//对删除结果进行判断
			if (i != -1) {
				System.out.println("删除水果信息成功!--");
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
