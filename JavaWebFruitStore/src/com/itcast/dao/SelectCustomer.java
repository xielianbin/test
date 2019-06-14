package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcast.pojo.Customer;
import com.itcast.utils.DBReplease;

public class SelectCustomer {
	public Customer selectCustomer(Connection connection, String selectName, String selectPassword) {
		//初始化用户信息链表
		List<Customer> customerList=new ArrayList<Customer>();
		String sql = "select * from customer";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		int id;
		String name;
		String password;
		String sex;
		String address;
		String telephone;
		try {
			// 使用preparedStatement对象进行数据库操作
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("正在查找用户...");
			//进行循环查找用户信息
			while(resultSet.next()) {
				id=resultSet.getInt("id");
				name=resultSet.getString("name");
				System.out.println("用户id= "+id+" 的用户名字为"+name);
				password=resultSet.getString("password");
				sex=resultSet.getString("sex");
				address=resultSet.getString("address");
				telephone=resultSet.getString("telephone");
				//将查询到的用户信息放入用户信息链表
				customerList.add(new Customer(id,name,password,sex,address,telephone));
			}
			int i=0;	//用i进行循环判断
			int nameFlag=-1;	//进行用户名判断
			for(i=0;i<customerList.size();i++) {
				//进行用户名与密码匹配,匹配成功则登录成功
				if((customerList.get(i).getName().equals(selectName))&&(customerList.get(i).getPassword().equals(selectPassword))) {
					System.out.println("用户查找成功, 登录成功!");
					return customerList.get(i);
				}
				//如果有匹配的用户名字成功,则进行记录
				if(customerList.get(i).getName().equals(selectName)) {
					nameFlag=i;
				}
			}
			//如果进行记录名字的nameFlag有记录,则返回密码错误
			if(nameFlag!=-1) {
				customerList.get(nameFlag).setPassword(null);
				System.out.println("密码错误!");
				return customerList.get(nameFlag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 进行回收资源操作
			new DBReplease(resultSet, connection);
		}
		// 在控制台打印输出客户信息
		System.out.println("查询失败!");
		return null;
	}
}
