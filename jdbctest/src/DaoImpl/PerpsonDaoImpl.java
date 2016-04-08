package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Perpson;
import Dao.PerpsonDao;

public class PerpsonDaoImpl implements PerpsonDao {

	public void query(Connection con) throws SQLException {
	  String sql = "select * from ta_psr";	
	  ResultSet rs = null;
      PreparedStatement pp = con.prepareCall(sql);
	  rs = pp.executeQuery();
	  while(rs.next()){
		  System.out.print("序号："+rs.getLong(1));
		  System.out.print("姓名（CN）："+rs.getString("psr_name_cn"));
		  System.out.print("航班号："+rs.getString("psr_fltnum"));
		  System.out.println();
	  }
	}

	public void insert(Connection con, Perpson ps1) throws SQLException {
      String sql1 = "insert into ta_psr(psr_id,psr_name_cn,psr_fltnum) values(?,?,?)";
      int count ;
      PreparedStatement pp1 = con.prepareCall(sql1);
      pp1.setLong(1, ps1.getId());
      pp1.setString(2, ps1.getNameCn());
      pp1.setString(3, ps1.getFltNum());
      count =  pp1.executeUpdate();
     if(count>0){
    	System.out.println("插入了"+count+"条数据"); 
     }
	}

	public void update(Connection con, long id, Perpson ps2)
			throws SQLException {
		 String sql2 = "update ta_psr set psr_name_cn = ? where psr_id = ?";
	      int count2 ;
	      PreparedStatement pp1 = con.prepareCall(sql2);
	      pp1.setString(1, ps2.getNameCn());
	      pp1.setLong(2, id);
	      count2 =  pp1.executeUpdate();
	     if(count2>0){
	    	System.out.println("更新了"+count2+"条数据"); 
	     }
	}

	public void delete(Connection con, Perpson ps3) throws SQLException {
		 String sql3 = "delete from ta_psr where psr_id = ?";
	      int count3 ;
	      PreparedStatement pp1 = con.prepareCall(sql3);
	      pp1.setLong(1, ps3.getId());
	      count3 =  pp1.executeUpdate();
	     if(count3>0){
	    	System.out.println("删除了"+count3+"条数据"); 
	     }
	}

}
