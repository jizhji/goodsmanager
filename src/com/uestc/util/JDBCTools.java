package com.uestc.util;

import java.util.*;
import java.io.*;
import java.sql.*;

import org.junit.Test;



public class JDBCTools {
	
	//һ�����ݿ����ӵ�ʵ�֣������ݿ�������Ϣ��������ݿ������ļ���database_info��
	public Connection testGetConnection() throws Exception{
		String driver = null;
		String jdbcUrl = null;
		String userName = null;
		String password = null;
		
//		��ȡlib���µ�database_info.properties�ļ�,��classpath�£���src�£�
		InputStream in = 
		this.getClass().getClassLoader().
		getResourceAsStream("database_info.properties");		
		Properties p = new Properties();
		p.load(in);
		
		driver = p.getProperty("driver");
		jdbcUrl = p.getProperty("jdbcUrl");
		userName = p.getProperty("userName");
		password = p.getProperty("password");
		
		
//		������������ע��������
//		DriverManager.registerDriver(Class.forName(driver).newInstance());
		Class.forName(driver);//������ʵ��Driver�еľ�̬�����������һ�е�����
		
//		����һ��mysql�����ӣ�����ʹ��������������
		return DriverManager.getConnection(jdbcUrl,userName,password);
		
	}
	
/*	�����ݿ�д������
 * 	����Statement�е�sql��������insert��delete��update����������select
 *  ע��һ��ԭ���쳣���Բ����������ݿ���Դһ��Ҫ�رա�
*/	
	@Test
	public void testStatement() throws Exception{
		Connection conn = null;
		Statement statement = null;
		try {
			//		1.��ȡ���ݿ�����
					conn = new JDBCTools().testGetConnection();
					
			//		2.׼��SQL���
					String sql = "insert into customers (cust_name,"
							+ "cust_address,cust_city,cust_state,"
							+ "cust_country,cust_contact,cust_email)"
							+ "values('jixiji','sichuan chengdu','chengdu','good','china','5201314','5201314@qq.com')";
					
			//		3.ִ�в���
			//		1).��ȡ����SQL����Statement����
					statement = conn.createStatement();
			//		2).����Statement�����executeUpdate()����ִ��SQL���Ĳ���
					statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		try {
				//	4.�ر�Statement����
			if(statement!=null)
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
//				5.�ر����ݿ�����
				if(conn!=null)
				conn.close();
			}
		
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
