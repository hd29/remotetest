package com.travelsky.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsky.dao.ILoginDao;
import com.travelsky.service.Account;
@Service
public class AccountImpl implements Account {
	@Autowired
	private ILoginDao loginDao;
	public boolean login(String username, String password) {
		return loginDao.login(username,password);
	}

	public void register(String username, String passwod, String passwod2) {
		// TODO Auto-generated method stub

	}

}
