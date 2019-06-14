package com.itcast.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//释放资源操作工具类
public class DBReplease {
	public DBReplease(Connection connection) {
		if(connection!=null)
			try {
				connection.close();
				System.out.println("数据库连接关闭成功..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public DBReplease(ResultSet resultSet,Connection connection) {
		if(resultSet!=null)
			try {
				resultSet.close();
				System.out.println("结果集关闭成功..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(connection!=null)
			try {
				connection.close();
				System.out.println("数据库连接关闭成功..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
