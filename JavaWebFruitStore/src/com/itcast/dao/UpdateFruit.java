package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class UpdateFruit {
	public int updateFruit(Fruit fruit) {
		//通过工具类获取数据库连接
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String updateSQL = "update fruit set name=?,price=?,unit=? where id=?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(updateSQL);
			preparedStatement.setString(1,fruit.getName());
			preparedStatement.setDouble(2,fruit.getPrice());
			preparedStatement.setString(3,fruit.getUnit());
			preparedStatement.setInt(4,fruit.getId());
			 i=preparedStatement.executeUpdate();
			System.out.println("水果信息更新结果判断中...");	
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
