package com.corejava.reflect;

import java.lang.reflect.Method;

public class ClassUtil {
	public static void printClassMessage(Object obj){
		
		
		//Ҫ��ȡ�����Ϣ������Ҫ��ȡ���������
		//���ݵ����ĸ�����Ķ��� c���Ǹ������������
		//����ֱ�Ӿ���object�Ķ���õ��ľ���object��������
		Class c=obj.getClass();
		//��ȡ�������
		System.out.println("��������ǣ�"+c.getName());
		/*
		 * method�࣬��������
		 * һ����Ա��������һ��method����
		 * getmethods����������ȡ�������е�public��������������̳ж�����
		 * getdeclaredmethods������ȡ�������и����Լ������ķ��������ʷ���Ȩ�ޣ�����������̳ж�����
		 * 
		 * */
//		Method[] method=c.getMethods();
		Method[] method=c.getDeclaredMethods();

		for(int i=0;i<method.length;i++){
			//�õ��ķ����ķ���ֵ���͵�������
			Class returnType=method[i].getReturnType();
			System.out.print(returnType.getName()+"");
			//�õ�����������
			System.out.print(method[i].getName()+"(");
			//��ȡ��������--���õ��Ĳ����б�����͵�������
			Class[] paramTypes=method[i].getParameterTypes();
			for(Class class1:paramTypes){
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
		
	}
	
}
