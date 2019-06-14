package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class DeleteFruit {
	public int deleteFruit(int id) {
		//通过工具类获取数据库连接
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String deleteSQL = "delete from fruit where id=?";
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			 i=preparedStatement.executeUpdate();
			System.out.println("水果信息删除结果判断中...");
			
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
