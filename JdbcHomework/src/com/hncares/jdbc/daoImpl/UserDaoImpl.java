package com.hncares.jdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sun.rmi.runtime.Log;

import com.hncares.jdbc.dao.UserDao;
import com.hncares.jdbc.entity.User;
import com.hncares.jdbc.util.Connect;

public class UserDaoImpl implements UserDao {

	Connection con = Connect.getConnect();
	Log log;
	public ResultSet query(){
//		Connection con = null;
//		con = Connect.getConnect();
//		int row;
		String sql = "select * from users";
		ResultSet rs = null;
		try {
//			PreparedStatement ps = con.prepareCall(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
//			row =  ps.executeUpdate();
//			System.out.println(row);
		} catch (Exception e) {
			
		}
		return rs;
	}

	public void insert(User user){
		
		  String sql = "insert into users(id,username,password) values(?,?,?)";
	      int row = 0 ;
	      PreparedStatement ps = null;
		try {
//			ps = con.prepareCall(sql);
			ps = con.prepareStatement(sql);
			 ps.setLong(1, user.getId());
		      ps.setString(2, user.getUserneme());
		      ps.setString(3, user.getPassword());
		      row =  ps.executeUpdate();
		      System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update users set username = ? where id = ?";
	      int row ;
	      PreparedStatement ps = null;
		try {
//			ps = con.prepareCall(sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserneme());
		      ps.setLong(2, user.getId());
		      row =  ps.executeUpdate();
		      System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		  String sql = "delete from users where id = ?";
	      int row ;
	      PreparedStatement ps = null;
		try {
//			ps = con.prepareCall(sql);
			ps = con.prepareStatement(sql);
			ps.setLong(1, user.getId());
		      row =  ps.executeUpdate();
		    
		      System.out.println(row); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	}

}
