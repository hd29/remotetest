package com.sina.util;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sina.domain.Users;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static ThreadLocal <Session>threadLocal=new ThreadLocal<Session>();
	//此处把构造方法设为private  在外部就不能再进行实例化此类的操作了。目的是为了不让别的类调用这个对象的实例。
	//单例模式 整个应用对于某个类只需要一个实例，或者只能是同一个实例的话，就应该设置成单例（从头到尾只有一个对象的实例）
	private HibernateUtil(){};
	//静态方法块  只执行一次，用于初始化sessionfactory  实例化sessionfactory接口的引用
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	//获取全新的session
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	//获取和线程关联的session
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
	//提供一个统一的查询方法  用户查询，hql语句由参数提供
	public static List executeQuery(String hql){
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
//			session=HibernateUtil.getCurrentSession();
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			list=session.createQuery(hql).list();//二次封装之后直接就是user类型
//			System.out.println(list.get(0).getName());
			transaction.commit();
//			threadLocal.remove();//如果需要用到getcurrentsession就需要加上此句 否则二次登录报错
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
}
