package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class InsertFruit {
	public int insertFruit(Fruit fruit) {
		//通过工具类获取数据库连接
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String insertSQL = "insert into fruit (id,name,price,unit) values ("+fruit.getId()+",'" + fruit.getName()
				+ "','" + fruit.getPrice() + "','" + fruit.getUnit() + "')";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertSQL);
			 i=preparedStatement.executeUpdate();
			System.out.println("水果信息插入结果判断中...");
			
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
