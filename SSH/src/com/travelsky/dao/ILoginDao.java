package com.travelsky.dao;

public interface ILoginDao {
	public boolean login(String username,String password);
	public boolean register(String username,String password,String password1);
}
