package com.xiaoyuan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;

import sun.jdbc.odbc.OdbcDef;

public class MyTools {
	//�ϴ�ͷ��ķ���
	public static String uploadHead(HttpServletRequest request,FormFile formFile,String id){
	
	String newPhotoName="";	
	try{
		//���Ǹ��û������Լ����ļ���
		String filePath=request.getSession().getServletContext().getRealPath("/");
		//filePath���ǵ�ǰ���webӦ�õľ���·��  ����E:\����\tomcat\apache-tomcat-6.0.20\webapps\xiaoyuanwang\
//		System.out.println(filePath);
		InputStream stream=formFile.getInputStream();//���ļ�����
		
		String oldPhotoName=formFile.getFileName();//��ȡ�ļ���
		newPhotoName=id+oldPhotoName.substring(oldPhotoName.indexOf("."), oldPhotoName.length());
		
		String newFullNewPath=filePath+"\\images\\"+id+"\\head\\";
		//�ж�newFullPath�ļ����Ƿ����
		File f=new File(newFullNewPath);
		if(!f.isDirectory()){
			//�����ļ��У���������
			f.mkdirs();//ֻ����һ��  ����s����һ��һ��Ŀ¼����
		}
		OutputStream bos=new FileOutputStream(newFullNewPath+ newPhotoName);
		int len=0;
		byte[] buffer=new byte[8192];
		while((len=stream.read(buffer,0,8192))!=-1){
			bos.write(buffer,0,len);
		}
		bos.close();
		stream.close();
		
		
		
	}catch (Exception e) {
		e.printStackTrace();		
		}
	return newPhotoName;
	}
}
