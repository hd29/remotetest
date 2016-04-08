package com.travelsky.jdbctest;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTest1 {
	 private static String driver = null;
	   private static String url = null;
	   private static String user = null;
	   private static String password =null;
	   public static Connection conn = null;
	   public static Statement st = null;
	   public static ResultSet rs = null;
	   public static Properties ps = null;
	   static{
		   try {
			   ps = new Properties();
			   InputStream in = JdbcTest1.class.getClassLoader().getResourceAsStream("config.properties");
			   ps.load(in);
		} catch (Exception e) {
                e.printStackTrace();
                System.out.println("加载失败！");
		}
	   }
	   
	   public static Connection getConnection(){
		   try {
			   Class.forName(ps.getProperty("driver"));
			   conn= DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("user"), ps.getProperty("password"));
		} catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("数据库连接失败");
		}
		   return conn;
	   }
	
	   public static void close(ResultSet r,Statement s, Connection c){
		   try {
			   if(r!=null){
				   r.close();   
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(s!=null){
					s.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(c!=null){
					c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   public static void query(){
			String sql = "select * from ta_psr";
			try {
				conn=  getConnection();
			    st = conn.createStatement();
			    rs = st.executeQuery(sql);
			    while(rs.next()){
			    	System.out.print("序号："+rs.getLong(1));
			    	System.out.print("姓名（EN）："+rs.getString(2));
			    	System.out.print("姓名（CN）："+rs.getString("psr_name_cn"));
			    	System.out.println();
			    }
			} catch (Exception e) {
	          e.printStackTrace();
	          System.out.println("数据库连接失败！");
			} finally{
				close(rs, st, conn);
			}
		}
	   public static void main(String[] args) {
		query();
	}
}
