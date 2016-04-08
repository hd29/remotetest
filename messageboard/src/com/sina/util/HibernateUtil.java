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
	//�˴��ѹ��췽����Ϊprivate  ���ⲿ�Ͳ����ٽ���ʵ��������Ĳ����ˡ�Ŀ����Ϊ�˲��ñ���������������ʵ����
	//����ģʽ ����Ӧ�ö���ĳ����ֻ��Ҫһ��ʵ��������ֻ����ͬһ��ʵ���Ļ�����Ӧ�����óɵ�������ͷ��βֻ��һ�������ʵ����
	private HibernateUtil(){};
	//��̬������  ִֻ��һ�Σ����ڳ�ʼ��sessionfactory  ʵ����sessionfactory�ӿڵ�����
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	//��ȡȫ�µ�session
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	//��ȡ���̹߳�����session
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
	//�ṩһ��ͳһ�Ĳ�ѯ����  �û���ѯ��hql����ɲ����ṩ
	public static List executeQuery(String hql){
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try {
//			session=HibernateUtil.getCurrentSession();
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			list=session.createQuery(hql).list();//���η�װ֮��ֱ�Ӿ���user����
//			System.out.println(list.get(0).getName());
			transaction.commit();
//			threadLocal.remove();//�����Ҫ�õ�getcurrentsession����Ҫ���ϴ˾� ������ε�¼����
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
