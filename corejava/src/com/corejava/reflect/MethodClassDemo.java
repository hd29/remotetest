package com.corejava.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodClassDemo {
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("hello");
		//list1.add(20);错误
		Class c1=list.getClass();
		Class c2=list1.getClass();
		System.out.println(c1==c2);
		//c1 == c2为true 说明集合编译之后是去泛型化的
		//反射的操作都是编译之后的操作
		
		/*
		 * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
		 * java中集合的泛型，是防止错误输入的，只在编译阶段有效，
		 * 绕过编译就无效了
		 * 验证：我们可以通过方法的反射来操作，绕过编译*/
		try {
			Method m=c2.getMethod("add", Object.class);
			m.invoke(list1,20);
			System.out.println(list1.size());
			System.out.println(list1);
			/*
			 * for(String string：list1){
			 * System.out.println(string)
			 * }*///现在就不能这样遍历了,
			//因为反射    Class  Method Field等的操作都是绕过编译 ，在运行时刻执行的
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
