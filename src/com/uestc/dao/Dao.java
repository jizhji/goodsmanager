package com.uestc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uestc.model.Operater;

/**
 * 该类为负责连接数据库，操作数据库的工作
 * 
 * @author jizhji
 * @date： 日期：2016年9月18日 时间：上午1:33:50
 * @version 1.0
 */
public class Dao {
//	创建连接四要素,protected说明当前成员变量同一个包中类或者子类都可以使用
	protected static String dbClassName="com.mysql.jdbc.Driver";//驱动名
	protected static String dbUrl = "jdbc:mysql://localhost:3306/db_library";//地址
	protected static String dbUserName = "root";//登录MySQL用户名，这里是超级用户
	protected static String dbPassword = "123456";//密码
	
	static Connection conn = null;//一个数据库连接通道类
	
	//构造函数即创建一个(仅一个)数据库连接，private说明这个方法仅供当前类使用
	private Dao(){
		try {
			if(conn==null){
				Class.forName(dbClassName).newInstance();//利用反射根据驱动名启动一个驱动类
				conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//利用驱动管理器类创建一个数据库连接		
			}else
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//查询数据库的信息，结果返回到ResultSet类
	private static ResultSet executeQuery(String sql){
		
		try {
			if(conn==null)
				new Dao();
			/**
			 * 这里有两个参数：TYPE_SCROLL_SENSITIVE:游标可上下移，并且数据库能同步更新结果集，CONCUR_UPDATABLE：结果集能同步更新数据库
			 * 其实这个Statement的设置是限定了结果集（ResultSet）的功能：可以用next()、previous()前后滚动获得记录，并且结果集和数据库可以互相同步；
			 * 这里要注意一点：结果集相当于数据库中的视图，所以对ResultSet的修改未必能变动数据库，需要满足以下三个条件：
			 * a.只引用了单个表 b.不含有join或group by子句 c.那些列中要包含PRIMARY KEY
			 */
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//这里的executeQuery与上面的方法重名，但包名不同
		} catch (SQLException e) {
			e.printStackTrace();
			return null;//如果上面的return句出错而没有执行return，这里能保证正常返回
		}
	}
	
	//更新数据库的信息或者插入数据
	private static int executeUpdate(String sql){
		try {
			if(conn==null)
				new Dao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//返回-1表示更新数据库失败
		}
		
	}
	
	//关闭数据库连接：数据库连接会占用资源，不用或者用完要及时关闭
	private static void close(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn=null;
		}
	}
	
	//核对管理员身份：到数据库管理员表（名单）中查看是否有该管理员（用户名和密码）
	Operater check(String name,String password){
		
		password ="";
		return null;
		
		
	}
	
	
}


