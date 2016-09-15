package com.uestc.util;

import java.util.*;
import java.io.*;
import java.sql.*;

import org.junit.Test;



public class JDBCTools {
	
	//一个数据库连接的实现（与数据库连接信息解耦），数据库配置文件在database_info下
	public Connection testGetConnection() throws Exception{
		String driver = null;
		String jdbcUrl = null;
		String userName = null;
		String password = null;
		
//		读取lib包下的database_info.properties文件,在classpath下（即src下）
		InputStream in = 
		this.getClass().getClassLoader().
		getResourceAsStream("database_info.properties");		
		Properties p = new Properties();
		p.load(in);
		
		driver = p.getProperty("driver");
		jdbcUrl = p.getProperty("jdbcUrl");
		userName = p.getProperty("userName");
		password = p.getProperty("password");
		
		
//		加载驱动程序（注册驱动）
//		DriverManager.registerDriver(Class.forName(driver).newInstance());
		Class.forName(driver);//这里其实是Driver中的静态代码块做了上一行的事情
		
//		创建一个mysql的连接，这里使用了驱动管理器
		return DriverManager.getConnection(jdbcUrl,userName,password);
		
	}
	
/*	向数据库写入数据
 * 	其中Statement中的sql语句可以是insert，delete，update，但不能是select
 *  注意一个原则：异常可以不处理，但数据库资源一定要关闭。
*/	
	@Test
	public void testStatement() throws Exception{
		Connection conn = null;
		Statement statement = null;
		try {
			//		1.获取数据库连接
					conn = new JDBCTools().testGetConnection();
					
			//		2.准备SQL语句
					String sql = "insert into customers (cust_name,"
							+ "cust_address,cust_city,cust_state,"
							+ "cust_country,cust_contact,cust_email)"
							+ "values('jixiji','sichuan chengdu','chengdu','good','china','5201314','5201314@qq.com')";
					
			//		3.执行插入
			//		1).获取操作SQL语句的Statement对象
					statement = conn.createStatement();
			//		2).调用Statement对象的executeUpdate()方法执行SQL语句的插入
					statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		try {
				//	4.关闭Statement对象
			if(statement!=null)
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
//				5.关闭数据库连接
				if(conn!=null)
				conn.close();
			}
		
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
