package com.corejava.reflect;

public class ClassDemo2 {
	public static void main(String[] arg0){
		Class c1=int.class;
		Class c2=String.class;
		Class c3=double.class;
		Class c4=Double.class;
		Class c5=void.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getSimpleName());

		System.out.println(c2.getName());

		System.out.println("ÊÇ"+c2.getClass()+"µÄÊµÀý");

	}
}
