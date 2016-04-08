package com.travelsky.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
   private static String driver = "oracle.jdbc.driver.OracleDriver";
   private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static String user = "cxl_test";
   private static String password ="cxl_test";
   public static Connection conn = null;
   public static Statement st = null;
   public static ResultSet rs = null;
   public static Connection getConnection(){
	   try {
		   Class.forName(driver);
		   conn= DriverManager.getConnection(url, user, password);
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
	public static void insert(){
		String sql1 = "insert into ta_psr(psr_id,psr_name) values(5,'lihe')";
		int count ;
		try {
			conn = getConnection();
			st = conn.createStatement();
		    count = st.executeUpdate(sql1);
		    if(count>0){
		    	System.out.println("插入了"+count+"条数据");
		    }
		} catch (Exception e) {
          e.printStackTrace();
          System.out.println("插入失败！");
		}finally{
			close(null,st,conn);
		}
	}
	public static void update(){
		String sql2 = "update ta_psr set psr_name = 'lisi' where psr_id = 6";
		int count ;
		try {
			conn = getConnection();
			st = conn.createStatement();
		    count = st.executeUpdate(sql2);
		    if(count>0){
		    	System.out.println("更新"+count+"条数据");
		    }
		} catch (Exception e) {
          e.printStackTrace();
		}finally{
			close(null,st,conn);
		}
	}
	
	public static void delete(){
		String sql2 = "delete from ta_psr where psr_id = 6";
		int count ;
		try {
			conn = getConnection();
			st = conn.createStatement();
		    count = st.executeUpdate(sql2);
		    if(count>0){
		    	System.out.println("删除"+count+"条数据");
		    }
		} catch (Exception e) {
          e.printStackTrace();
		}finally{
			close(null,st,conn);
		}
	}
	public static void main(String[] args) {
		//query();
//		insert();
//		update();
		delete();
	}
}
