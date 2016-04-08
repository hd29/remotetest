package org.login.service;

import java.util.List;

import org.login.vo.Users;

//ҵ���߼���ӿ�
@SuppressWarnings("unchecked")
public interface IUsersService {

	public boolean checkLogin(Users user);
	
	public boolean saveUser(Users user);
	
	public boolean deleteUser(Integer id);
	
	public boolean updateUser(Users user);
	
	public List<Users> findAllUsers();
	
	public Users getUserById(Integer id);
}
