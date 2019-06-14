package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class SelectFruitList {
	@SuppressWarnings("rawtypes")
	public List selectFruitList() {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		//通过工具类获取数据库连接
		Connection connection=new DBConnection().getConnection();	
		String sql = "select * from fruit";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int id;
		String name;
		double price;
		String unit;
		try {
			// 使用preparedStatement对象进行数据库操作
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("正在查找水果信息...");
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("name");
				price = resultSet.getDouble("price");
				unit = resultSet.getString("unit");
				System.out.println("查询中...");
				fruitList.add(new Fruit(id, name, price, unit));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 进行回收资源操作
			new DBReplease(resultSet, connection);
		}
		// 在控制台打印输出客户信息
		System.out.println("查询结果返回中...");
		return fruitList;
	}
}
