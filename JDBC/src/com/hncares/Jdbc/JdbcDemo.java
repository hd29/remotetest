package com.hncares.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	
	private static String url ="jdbc:oracle:thin:@192.168.10.9:1521:ORCL" ;
	private static String user = "greency";
	private static String password = "greency";
//	private static Statement sm;
	
	private static Connection con(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user,password);
			System.out.println("connectionStatement:"+con);
//			sm = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private static void query() throws SQLException{
		Connection con = con();
		Statement sm = con.createStatement();
		ResultSet rs = null;
		try {
			rs = sm.executeQuery("select * from users");
			while (rs.next()) {
				System.out.println("id:"+rs.getString(1));
				System.out.println("name:"+rs.getString(2));
				System.out.println("paw:"+rs.getString(3));
				System.out.println("=======================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs.close();
			sm.close();
			con.close();
		}
	}
	
	private static int delete(int id) throws SQLException{
		Connection con = con();
	    int row = 0;
	    String sql = "delete from users where id='" + id + "'";
	    PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        row = pstmt.executeUpdate();
	        System.out.println("resutl: " + row);
//	        pstmt.close();
//	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	    	pstmt.close();
	    	con.close();
	    }
	    return row;
	}
	
	private static int date(int id,String user,String pass){
		Connection con = con();
	    int row = 0;
	    String sql = "update users set username='" +user + "' where id='" + id + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        row = pstmt.executeUpdate();
	        System.out.println("resutl: " + row);
	        pstmt.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}
	private static int add(int id,String user,String pass){
		
	    int row = 0;
	    String sql = "insert into users (id,username,password) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con().prepareStatement(sql);
	        pstmt.setString(1, String.valueOf(id));
	        pstmt.setString(2, user);
	        pstmt.setString(3, pass);
	        row = pstmt.executeUpdate();
	        
	        pstmt.close();
	        con().close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}
	
	public static void main(String[] args) throws SQLException {
//		con();
//		query();
//		delete(222); 
//		add(220,"lin","lin");
		date(1,"lin","lin");
	    
	}
}
