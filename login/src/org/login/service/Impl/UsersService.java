package org.login.service.Impl;

import java.util.List;

import org.login.dao.IUsersDAO;
import org.login.service.IUsersService;
import org.login.vo.Users;

//业务逻辑层
@SuppressWarnings("unchecked")
public class UsersService implements IUsersService {
	
	//IOC,IUsersDAO接口注入
	private IUsersDAO userDAO = null;
	
	public IUsersDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	//登陆,返回boolean值
	public boolean checkLogin(Users user) {
		
		return userDAO.checkLogin(user);
	}

	//删除
	public boolean deleteUser(Integer id) {
		
		return userDAO.deleteUser(id);
	}

	//添加
	public boolean saveUser(Users user) {
		
		return userDAO.saveUser(user);
	}

	//修改
	public boolean updateUser(Users user) {
		
		return userDAO.updateUser(user);
	}

	//查询所有
	public List<Users> findAllUsers() {
		
		return userDAO.findAllUsers();
	}

	//根据ID查询一个
	public Users getUserById(Integer id) {
		
		return userDAO.getUserById(id);
	}

}
