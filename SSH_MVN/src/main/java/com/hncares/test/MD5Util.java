package com.hncares.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {  
	  
    /*** 
     * MD5���� ����32λmd5�� 
     * 
     */  
	public static void string2md5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    char [] strA= str.toCharArray();
		    byte [] strB= new byte[strA.length];
		    for (int i = 0; i < strB.length; i++) {
				strB[i] = (byte)strA[i];
			}
		    byte [] md5B = md.digest(strB);
		    StringBuffer stringb = new StringBuffer();
		    for (int j = 0; j < md5B.length; j++) {
		    	
		    	stringb.append(Integer.toHexString(((int)md5B[j]) & 0xff));
			}
		    System.out.println(stringb);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
            System.out.print(Integer.toHexString(((int)md5Bytes[i]) & 0xff));
        }  
        return hexValue.toString();  
  
    }  
  
    /** 
     * ���ܽ����㷨 ִ��һ�μ��ܣ����ν��� 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 'z');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
    // ����������  
    public static void main(String args[]) {  
    	
    	
        String s = new String("1222234567890");
        string2md5("1222234567890");
        System.out.println("ԭʼ��" + s);  
        System.out.println("\nMD5��" + string2MD5(s));  
        System.out.println("���ܵģ�" + convertMD5(s));  
        System.out.println("���ܵģ�" + convertMD5(convertMD5(s)));  
  
    }  
}  
