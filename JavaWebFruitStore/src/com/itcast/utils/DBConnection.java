package com.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
//获取数据库连接工具类
public class DBConnection {
	Connection connection = null;
	// 获取连接对象
	public Connection getConnection() {
		try {
			// 1.加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2019?"
					+ "useUnicode=true&characterEncoding=utf8&" + "useSSL=false&serverTimezone=Hongkong", "root",
					"117411");
			// 3.通过Statement对象创建Connection连接对象
			System.out.println("数据库连接加载成功..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
