package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Perpson;

public interface PerpsonDao {
   public void query(Connection con)throws SQLException;
   
   public void insert(Connection con,Perpson ps1) throws SQLException;
   
   public void update(Connection con, long id,Perpson ps2) throws SQLException;
   
   public void delete(Connection con,Perpson ps3) throws SQLException;
}
