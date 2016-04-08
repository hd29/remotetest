package com.corejava.reflect;

public class ClassDemo1 {
	public static void main(String[] args){
		//foo的实例对象如何表示 
		Foo foo1=new Foo();//foo1就表示出来了
		//Foo这个类也是一个实例对象，Class类的实例对象如何表示？
		//任何一个类都是Class的实例对象，这个实例对象有三种表示方式
		
		/*第一种表示方式---》实际在告诉我们
		任何一个类都有一个隐含的静态成员变量class*/
		Class<Foo> c1=Foo.class;
		
		//第二种表达方式  已经知道该类的对象通过getclass方法
		Class<? extends Foo> c2=foo1.getClass();
		
		/* 官网 c1,c2表示了foo类的类类型（class type）*/
		//不管c1 or c2都代表了foo类的类类型，一个类只可能是class类的一个实例对象
		System.out.println(c1==c2);
		
		//第三种表达方式
		Class<?> c3=null;
		try {
			c3=Class.forName("com.corejava.reflect.Foo");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(c2==c3);
		//我们完全可以通过类的类类型创建该类的对象实例---》通过c1 or c2 or c3创建foo的实例
		try {
			Foo foo=(Foo) c1.newInstance();//前提是需要有无参数的构造方法
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