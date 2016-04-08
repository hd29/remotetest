package com.hncares.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hncares.jdbc.dao.UserDao;
import com.hncares.jdbc.daoImpl.UserDaoImpl;
import com.hncares.jdbc.entity.User;

public class UserService {
	public void add(User user) throws SQLException {
		
	    UserDao userdao = new UserDaoImpl();
//	    User user = new User();
//		user.setId(23);
//		user.setUserneme("lin");
//		user.setPassword("pas");
		userdao.insert(user);
	}
	
	public void delete(User user) throws SQLException {
	    UserDao userdao = new UserDaoImpl();
//	    User user = new User();
//		user.setId(23);
//		user.setUserneme("lin");
//		user.setPassword("pas");
		userdao.delete(user);
	}
	public void update(User user) throws SQLException {
	    UserDao userdao = new UserDaoImpl();
//	    User user = new User();
//		user.setId(23);
//		user.setUserneme("lin");
		userdao.update(user);
	}
	public void query() throws SQLException {
	    UserDao userdao = new UserDaoImpl();
		ResultSet rs = userdao.query();
		while (rs.next()) {
			System.out.println("id:"+rs.getString(1));
			System.out.println("username:"+rs.getString(2));
			System.out.println("password:"+rs.getString(3));
		}
	}
	
	
}
