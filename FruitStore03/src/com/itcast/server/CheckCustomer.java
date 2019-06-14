package com.itcast.server;
import java.sql.Connection;

import com.itcast.dao.SelectCustomer;
import com.itcast.pojo.Customer;
import com.itcast.utils.DBConnection;
public class CheckCustomer {
	//调用dao层的selectCustomer进行查询客户信息服务
	public Customer checkCustomer(String name,String password) {
		Connection connection=new DBConnection().getConnection();	//通过工具类获取数据库连接
		//通过dao层进行查询获取用户信息
		Customer customer=new SelectCustomer().selectCustomer(connection, name, password);
		return customer;
	}
}
