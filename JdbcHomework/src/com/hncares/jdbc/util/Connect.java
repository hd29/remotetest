package com.hncares.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
	
	private static Properties ps;

 static 
 {
	 ps = new Properties();
	 InputStream in = Connect.class.getClassLoader().getResourceAsStream("config.properties");
	 try {
		ps.load(in);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	
	public static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName(ps.getProperty("driver"));
			con = DriverManager.getConnection(
					ps.getProperty("url"),
					ps.getProperty("user"), 
					ps.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(ResultSet r,Statement s, Connection c){
		   try {
			   if(r!=null)
				   r.close();   
				   
			   if(s!=null)
					s.close();
				
			   if(c!=null)
					c.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }

	
}
