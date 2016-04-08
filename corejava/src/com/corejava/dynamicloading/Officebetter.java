package com.corejava.dynamicloading;

public class Officebetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?> c=Class.forName("com.corejava.dynamicloading.Word");
			for(int i=0;i<=args.length-1;i++){
				System.out.println(args[i]);
				System.out.println("有经过循环");
			}
			//通过类类型，创建该类对象
			OfficeAble oa=(OfficeAble) c.newInstance();
			oa.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
