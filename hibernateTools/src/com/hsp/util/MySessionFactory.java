package com.hsp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//��ʹ��hibernate������Ŀ����һ����ֻ֤��һ��sessionfactory�ࣨ�Ự������
//��һ�����ݿ⣨�ǿ� ������һ�ű�ֻ������Ŀ�Ӵ��ʱ��ʹ���˶������ݿ⣨mysql  oracle  �ȵȣ��Ż���Ҫ���sessionfactory�ࣩ��Ӧһ��sessionfactory����ʵ��������ӿڵĶ���ʵ����sessionfactory��һ���ӿڣ���
final public class MySessionFactory {
	private static SessionFactory sessionFactory=null;
	private MySessionFactory(){
		
	}
	static{//��̬�����  ֻ�����һ��,��Ϊ���ش˴�����൱�ķ��ڴ�
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
