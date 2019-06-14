package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.itcast.pojo.Customer;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class InsertCustomer {
	public int insertCustomer(Customer customer) {
		//通过工具类获取数据库连接
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String insertSQL = "insert into customer (name,password,sex,address,telephone) values ('" + customer.getName()
				+ "','" + customer.getPassword() + "','" + customer.getSex() + "','" + customer.getAddress() + "','"
				+ customer.getTelephone() + "')";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertSQL);
			 i=preparedStatement.executeUpdate();
			System.out.println("插入结果判断中...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			new DBReplease(connection);
		}
		//用返回值i来进行判断是否插入成功
		return i;
	}
}
