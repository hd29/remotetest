package org.login.service.Impl;

import java.util.List;

import org.login.dao.IUsersDAO;
import org.login.service.IUsersService;
import org.login.vo.Users;

//ҵ���߼���
@SuppressWarnings("unchecked")
public class UsersService implements IUsersService {
	
	//IOC,IUsersDAO�ӿ�ע��
	private IUsersDAO userDAO = null;
	
	public IUsersDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	//��½,����booleanֵ
	public boolean checkLogin(Users user) {
		
		return userDAO.checkLogin(user);
	}

	//ɾ��
	public boolean deleteUser(Integer id) {
		
		return userDAO.deleteUser(id);
	}

	//���
	public boolean saveUser(Users user) {
		
		return userDAO.saveUser(user);
	}

	//�޸�
	public boolean updateUser(Users user) {
		
		return userDAO.updateUser(user);
	}

	//��ѯ����
	public List<Users> findAllUsers() {
		
		return userDAO.findAllUsers();
	}

	//����ID��ѯһ��
	public Users getUserById(Integer id) {
		
		return userDAO.getUserById(id);
	}

}
