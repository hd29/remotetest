package com.xiaoyuan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;

import sun.jdbc.odbc.OdbcDef;

public class MyTools {
	//上传头像的方法
	public static String uploadHead(HttpServletRequest request,FormFile formFile,String id){
	
	String newPhotoName="";	
	try{
		//考虑给用户创建自己的文件夹
		String filePath=request.getSession().getServletContext().getRealPath("/");
		//filePath就是当前这个web应用的绝对路径  即是E:\久其\tomcat\apache-tomcat-6.0.20\webapps\xiaoyuanwang\
//		System.out.println(filePath);
		InputStream stream=formFile.getInputStream();//把文件读入
		
		String oldPhotoName=formFile.getFileName();//获取文件名
		newPhotoName=id+oldPhotoName.substring(oldPhotoName.indexOf("."), oldPhotoName.length());
		
		String newFullNewPath=filePath+"\\images\\"+id+"\\head\\";
		//判断newFullPath文件夹是否存在
		File f=new File(newFullNewPath);
		if(!f.isDirectory()){
			//不是文件夹，创建即可
			f.mkdirs();//只创建一个  不加s则是一级一级目录创建
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
