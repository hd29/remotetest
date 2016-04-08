package com.xiaoyuan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
		public static void main(String[] args){
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
			TestService ts=(TestService)ac.getBean("testservice");
			System.out.println(ts.getName());
		}
}
