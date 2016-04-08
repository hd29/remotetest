package com.hsp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//在使用hibernate开发项目，请一定保证只有一个sessionfactory类（会话工厂）
//（一个数据库（是库 而不是一张表只有在项目庞大的时候使用了多种数据库（mysql  oracle  等等）才会需要多个sessionfactory类）对应一个sessionfactory对象（实现了这个接口的对象实例，sessionfactory是一个接口））
final public class MySessionFactory {
	private static SessionFactory sessionFactory=null;
	private MySessionFactory(){
		
	}
	static{//静态代码块  只会调用一次,因为加载此代码块相当耗费内存
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
