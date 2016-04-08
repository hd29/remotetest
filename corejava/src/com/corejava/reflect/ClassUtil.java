package com.corejava.reflect;

import java.lang.reflect.Method;

public class ClassUtil {
	public static void printClassMessage(Object obj){
		
		
		//要获取类的信息，首先要获取类的类类型
		//传递的是哪个子类的对象， c就是该子类的类类型
		//传的直接就是object的对象得到的就是object的类类型
		Class c=obj.getClass();
		//获取类的名称
		System.out.println("类的名称是："+c.getName());
		/*
		 * method类，方法对象
		 * 一个成员方法就是一个method对象
		 * getmethods（）方法获取的是所有的public函数，包括父类继承而来的
		 * getdeclaredmethods（）获取的是所有该类自己声明的方法，不问访问权限，不包括父类继承而来的
		 * 
		 * */
//		Method[] method=c.getMethods();
		Method[] method=c.getDeclaredMethods();

		for(int i=0;i<method.length;i++){
			//得到的方法的返回值类型的类类型
			Class returnType=method[i].getReturnType();
			System.out.print(returnType.getName()+"");
			//得到方法的名称
			System.out.print(method[i].getName()+"(");
			//获取参数类型--》得到的参数列表的类型的类类型
			Class[] paramTypes=method[i].getParameterTypes();
			for(Class class1:paramTypes){
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
		
	}
	
}
