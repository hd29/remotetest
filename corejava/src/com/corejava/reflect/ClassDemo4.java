package com.corejava.reflect;

import java.lang.reflect.Method;

public class ClassDemo4 {
	public static void main(String[] args){
		//Ҫ��ȡprint��int��int��������1.Ҫ��ȡһ���������ǻ�ȡ�����Ϣ����ȡ�� ����Ϣ����Ҫ���������
		A a1=new A();
		Class c=a1.getClass();
		/*
		 * 2.��ȡ���������ƺͲ����б�������
		 * getmethod��ȡ����public�ķ���
		 * getdeclaredmethod�Լ������ķ���*/
		try {
			Method method=c.getMethod("print",new Class[]{int.class,int.class});
			//�����ķ������
			//a1.print��10��20�������ķ����������m���������з������ú�a1.print��Ч����һ����
			//�������û�з���ֵ����null���з���ֵ���ؾ���ķ���ֵ
			//method.invoke(a1, new Object[]{10,20});
			Object o=method.invoke(a1, 10,20);
			//��ȡ����print��String,String��
			System.out.println("==================");
//			Method m1=c.getMethod("print", new Class[]{String.class,String.class});
//			Method m1=c.getMethod("print", String.class,String.class);
//			//�÷������з������
//			a1.print("hello", "world");
//			Method m2=c.getMethod("print", new Class[]{});
			Method m2=c.getMethod("print");
//			m2.invoke(a1, new Object[]{});
			m2.invoke(a1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class A{
	public void print(){
		System.out.println("hello world");
	}
	public void print(int a,int b){
		System.out.println(a+b);
	 	}

	public void print(String a, String b) {
		// TODO Auto-generated method stub
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
	}
