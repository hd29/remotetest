package com.travelsky.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsky.dao.IaduqDao;
import com.travelsky.service.ADUQService;
@Service
public class AduqServiceImpl implements ADUQService{
	
	@Autowired
	private IaduqDao aduqDao;

	public void add(int id, String username, String password) {
		aduqDao.add(id, username, password);
	}

	public void delete(int id) {
		aduqDao.delete(id);
	}

	public List query(int id) {
		return aduqDao.query(id);
	}

	public void update(int id, String password) {
		aduqDao.update(id, password);
	}

}
