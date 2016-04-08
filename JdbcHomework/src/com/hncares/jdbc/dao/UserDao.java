package com.hncares.jdbc.dao;

import java.sql.ResultSet;

import com.hncares.jdbc.entity.User;

public interface UserDao {
	
	public ResultSet query();

	public void insert(User user);

	public void update(User user);

	public void delete(User user);
	
}
