package org.login.dao.Impl;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.login.dao.IUsersDAO;
import org.login.vo.Users;

//DAO
@SuppressWarnings("unchecked")
public class UsersDAO extends BaseDAO implements IUsersDAO {

	//��֤�û���,�����¼,HQL
	public boolean checkLogin(Users user) {
		Session session = null;
		session = getSession();
		String hql = "from Users u where u.username = ? and u.password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list = query.list();
		session.close();
		if (list.size()>0) {
			return true;
		}
		return false;	
	}

	//����IDɾ��
	public boolean deleteUser(Integer id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Users user = (Users)session.get(Users.class, id);//����ID��ѯһ������
			session.delete(user);//ɾ��
			tx.commit();//�����ύ
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
		} finally {
			session.close();//�ر�session
		}
		return false;
	}

	//���
	public boolean saveUser(Users user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();//�������Ϊ��,�ع�
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	//�޸�
	public boolean updateUser(Users user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			return true;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	//��ѯȫ���û�
	public List<Users> findAllUsers() {
		List<Users> users = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			String hsql = "from Users u";
			Query query = session.createQuery(hsql);
			users = query.list();
			tx.commit();
			return users;
		}  catch (Exception e) {
			if(tx != null) tx.rollback();
//			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	//����ID��ѯһ������
	public Users getUserById(Integer id) {
		Session session = null;
		session = getSession();
		String hql = "from Users u where u.id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		List list = query.list();
		Users user = null;
		if (list.size()>0) {
			user = (Users)list.get(0);
		}
		session.close();
		return user;	
	}

}
