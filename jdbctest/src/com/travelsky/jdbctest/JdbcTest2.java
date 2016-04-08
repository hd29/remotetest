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
	 //插入
	/* perpson.setId(7);
	 perpson.setNameCn("SIM");
	 perpsonDao.insert(conn, perpson);*/
	 
	 //更新
	/* perpson.setNameCn("李強");
	 perpsonDao.update(conn, 4, perpson);*/
	 
	 //刪除
	/* perpson.setId(7);
	 perpsonDao.delete(conn, perpson);*/
	 
	 //查詢
	 perpsonDao.query(conn);
	 
	 conn.commit();
    } catch (SQLException e) {
     e.printStackTrace();
     System.out.println("插入失败！——————");
     try {
		conn.rollback();
		System.out.println("回滾事物！");
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
