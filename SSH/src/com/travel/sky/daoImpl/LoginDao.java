package com.travel.sky.daoImpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.travelsky.dao.ILoginDao;
import com.travelsky.model.Users;
@Repository
public class LoginDao implements ILoginDao{

	@Autowired
	private  SessionFactory sessionFactory;
	
	public boolean login(String username,String password){
		boolean pass;
		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from Users where username='"+username+
//				"' and password ='"+password+"'");
		Query query = session.createQuery("from Users where username=? and password =?");
		query.setString(0, username);
		query.setString(1, password);
		List<Users> list = query.list();
		
		if(list.size()>0)
			pass = true;
		else 
			pass = false;

		return pass; 
	}

	public boolean register(String username, String password, String password1) {
		return false;
	}
}
