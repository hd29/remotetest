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
				System.out.println("�о���ѭ��");
			}
			//ͨ�������ͣ������������
			OfficeAble oa=(OfficeAble) c.newInstance();
			oa.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
