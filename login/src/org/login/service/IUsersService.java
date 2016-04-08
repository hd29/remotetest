package org.login.service;

import java.util.List;

import org.login.vo.Users;

//业务逻辑层接口
@SuppressWarnings("unchecked")
public interface IUsersService {

	public boolean checkLogin(Users user);
	
	public boolean saveUser(Users user);
	
	public boolean deleteUser(Integer id);
	
	public boolean updateUser(Users user);
	
	public List<Users> findAllUsers();
	
	public Users getUserById(Integer id);
}
