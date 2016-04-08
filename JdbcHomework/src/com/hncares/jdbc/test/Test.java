package com.hncares.jdbc.test;

import java.sql.SQLException;

import com.hncares.jdbc.entity.User;
import com.hncares.jdbc.service.UserService;

public class Test {
	
	static UserService userService = new UserService();
	public static void main(String[] args) throws SQLException {
		
//		User user = new User();
//		user.setId(21);
//		user.setUserneme("lin");
//		user.setPassword("pas");
//		userService.add(user);
//		userService.delete(user);
//		userService.update(user);
		userService.query();
		
	}
}
