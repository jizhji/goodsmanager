package com.uestc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uestc.model.Operater;

/**
 * ����Ϊ�����������ݿ⣬�������ݿ�Ĺ���
 * 
 * @author jizhji
 * @date�� ���ڣ�2016��9��18�� ʱ�䣺����1:33:50
 * @version 1.0
 */
public class Dao {
//	����������Ҫ��,protected˵����ǰ��Ա����ͬһ��������������඼����ʹ��
	protected static String dbClassName="com.mysql.jdbc.Driver";//������
	protected static String dbUrl = "jdbc:mysql://localhost:3306/db_library";//��ַ
	protected static String dbUserName = "root";//��¼MySQL�û����������ǳ����û�
	protected static String dbPassword = "123456";//����
	
	static Connection conn = null;//һ�����ݿ�����ͨ����
	
	//���캯��������һ��(��һ��)���ݿ����ӣ�private˵���������������ǰ��ʹ��
	private Dao(){
		try {
			if(conn==null){
				Class.forName(dbClassName).newInstance();//���÷����������������һ��������
				conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//���������������ഴ��һ�����ݿ�����		
			}else
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//��ѯ���ݿ����Ϣ��������ص�ResultSet��
	private static ResultSet executeQuery(String sql){
		
		try {
			if(conn==null)
				new Dao();
			/**
			 * ����������������TYPE_SCROLL_SENSITIVE:�α�������ƣ��������ݿ���ͬ�����½������CONCUR_UPDATABLE���������ͬ���������ݿ�
			 * ��ʵ���Statement���������޶��˽������ResultSet���Ĺ��ܣ�������next()��previous()ǰ�������ü�¼�����ҽ���������ݿ���Ի���ͬ����
			 * ����Ҫע��һ�㣺������൱�����ݿ��е���ͼ�����Զ�ResultSet���޸�δ���ܱ䶯���ݿ⣬��Ҫ������������������
			 * a.ֻ�����˵����� b.������join��group by�Ӿ� c.��Щ����Ҫ����PRIMARY KEY
			 */
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//�����executeQuery������ķ�����������������ͬ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;//��������return������û��ִ��return�������ܱ�֤��������
		}
	}
	
	//�������ݿ����Ϣ���߲�������
	private static int executeUpdate(String sql){
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//����-1��ʾ�������ݿ�ʧ��
		}
		
	}
	
	//�ر����ݿ����ӣ����ݿ����ӻ�ռ����Դ�����û�������Ҫ��ʱ�ر�
	private static void close(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn=null;
		}
	}
	
	//�˶Թ���Ա��ݣ������ݿ����Ա���������в鿴�Ƿ��иù���Ա���û��������룩
	Operater check(String name,String password){
		
		password ="";
		return null;
		
		
	}
	
	
}


