package com.travelsky.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Perpson;

import Dao.PerpsonDao;
import DaoImpl.PerpsonDaoImpl;

public class JdbcTest2 {
 public static void main(String[] args) {
	Connection conn = null;
	JdbcTest1 jdbcTest1 = new JdbcTest1();
 try {
	 conn = jdbcTest1.getConnection();
	 conn.setAutoCommit(false);
	 PerpsonDao perpsonDao = new PerpsonDaoImpl();
	 Perpson perpson = new Perpson();
	 //����
	/* perpson.setId(7);
	 perpson.setNameCn("SIM");
	 perpsonDao.insert(conn, perpson);*/
	 
	 //����
	/* perpson.setNameCn("�");
	 perpsonDao.update(conn, 4, perpson);*/
	 
	 //�h��
	/* perpson.setId(7);
	 perpsonDao.delete(conn, perpson);*/
	 
	 //��ԃ
	 perpsonDao.query(conn);
	 
	 conn.commit();
    } catch (SQLException e) {
     e.printStackTrace();
     System.out.println("����ʧ�ܣ�������������");
     try {
		conn.rollback();
		System.out.println("�؝L���");
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
   }finally{
	   try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
   }
  }
}
