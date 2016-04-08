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
	//获取全新的session
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		//判断是否得到
		if(session==null){
			session=sessionFactory.openSession();
			//把session对象设置到threadlocal中去,相当于该session已经和线程绑定
			threadLocal.set(session);
		}
		return session;
	}
}
