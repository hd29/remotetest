package com.hsp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static ThreadLocal <Session>threadLocal=new ThreadLocal<Session>();
	private HibernateUtil(){};
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	//��ȡȫ�µ�session
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		//�ж��Ƿ�õ�
		if(session==null){
			session=sessionFactory.openSession();
			//��session�������õ�threadlocal��ȥ,�൱�ڸ�session�Ѿ����̰߳�
			threadLocal.set(session);
		}
		return session;
	}
}
