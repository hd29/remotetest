package com.corejava.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodClassDemo {
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("hello");
		//list1.add(20);����
		Class c1=list.getClass();
		Class c2=list1.getClass();
		System.out.println(c1==c2);
		//c1 == c2Ϊtrue ˵�����ϱ���֮����ȥ���ͻ���
		//����Ĳ������Ǳ���֮��Ĳ���
		
		/*
		 * c1==c2�������true˵������֮�󼯺ϵķ�����ȥ���ͻ���
		 * java�м��ϵķ��ͣ��Ƿ�ֹ��������ģ�ֻ�ڱ���׶���Ч��
		 * �ƹ��������Ч��
		 * ��֤�����ǿ���ͨ�������ķ������������ƹ�����*/
		try {
			Method m=c2.getMethod("add", Object.class);
			m.invoke(list1,20);
			System.out.println(list1.size());
			System.out.println(list1);
			/*
			 * for(String string��list1){
			 * System.out.println(string)
			 * }*///���ھͲ�������������,
			//��Ϊ����    Class  Method Field�ȵĲ��������ƹ����� ��������ʱ��ִ�е�
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
