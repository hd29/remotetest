package com.sina.service;
import java.util.List;

import javax.print.attribute.standard.Finishings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sina.domain.Users;
import com.sina.util.HibernateUtil;
import com.sina.util.MySessionFactory;

public class UserService {
	//��֤�û��Ƿ�Ϸ�
	public Users checkUser(Users users){
//		Session session=null;
//		Transaction transaction=null;
//		try {
//			session=HibernateUtil.getCurrentSession();
//			transaction=session.beginTransaction();
//			List<Users> list=session.createQuery("from Users where name='"+users.getName()+"'and password='"+users.getPassword()+"'").list();
//			
//			
//			if(list.size()==1){
//				users=list.get(0);
//			}else{
//				users=null;
//			}
//			transaction.commit();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			if(transaction!=null){
//				transaction.rollback();
//			}
//			throw new RuntimeException(e.getMessage());
//		}finally{
//			if(session!=null&&session.isOpen()){
//				session.close();
//			}
//		}
//		return users;
		//service�����ã�����Ƿ��б��е�name �� password  Ȼ��users�ɲ�������
		String hql="from Users where name='"
				+users.getName()+"' and password='"+users.getPassword()+"'";
		//�˴�hibernateUtil������û�н���ʵ����  Ҫֱ�ӵ��÷�����Ҫ��executeQuery�������ó�static
		List<Users> list=HibernateUtil.executeQuery(hql);
		if(list.size()==1)
		{
			System.out.println("����Ϊ1");
			return list.get(0);
		}else{
			System.out.println("����Ϊ2");
			return null;
		}
	}
	
}
