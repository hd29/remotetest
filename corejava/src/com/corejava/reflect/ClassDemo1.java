package com.corejava.reflect;

public class ClassDemo1 {
	public static void main(String[] args){
		//foo��ʵ��������α�ʾ 
		Foo foo1=new Foo();//foo1�ͱ�ʾ������
		//Foo�����Ҳ��һ��ʵ������Class���ʵ��������α�ʾ��
		//�κ�һ���඼��Class��ʵ���������ʵ�����������ֱ�ʾ��ʽ
		
		/*��һ�ֱ�ʾ��ʽ---��ʵ���ڸ�������
		�κ�һ���඼��һ�������ľ�̬��Ա����class*/
		Class<Foo> c1=Foo.class;
		
		//�ڶ��ֱ�﷽ʽ  �Ѿ�֪������Ķ���ͨ��getclass����
		Class<? extends Foo> c2=foo1.getClass();
		
		/* ���� c1,c2��ʾ��foo��������ͣ�class type��*/
		//����c1 or c2��������foo��������ͣ�һ����ֻ������class���һ��ʵ������
		System.out.println(c1==c2);
		
		//�����ֱ�﷽ʽ
		Class<?> c3=null;
		try {
			c3=Class.forName("com.corejava.reflect.Foo");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(c2==c3);
		//������ȫ����ͨ����������ʹ�������Ķ���ʵ��---��ͨ��c1 or c2 or c3����foo��ʵ��
		try {
			Foo foo=(Foo) c1.newInstance();//ǰ������Ҫ���޲����Ĺ��췽��
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Foo{
	
	void print(){
		
	}
}