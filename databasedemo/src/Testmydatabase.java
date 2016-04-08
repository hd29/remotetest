
import java.sql.*;
import java.text.SimpleDateFormat;

public class Testmydatabase {
	String con1="jdbc:oracle:thin:@localhost:1521:orcl";
	String url="oracle.jdbc.driver.OracleDriver";
	Connection connection;
	PreparedStatement preparestatement;
	ResultSet resultSet;
	SimpleDateFormat sdf=new SimpleDateFormat("yy年mm月dd日");
	public Testmydatabase(){
		
			try {
				try {
					Class.forName(url);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				connection=DriverManager.getConnection(con1, "system", "123");
				preparestatement=connection.prepareStatement("select * from employee");
				resultSet=preparestatement.executeQuery();
				while(resultSet.next()){
					System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getString(2));
					System.out.println(resultSet.getString(3));
					System.out.println(sdf.format(resultSet.getDate(4)));
//					System.out.println("连接成功");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
		
	}
	public void close(){
		try {
			resultSet.close();
			preparestatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] arg0){
		Testmydatabase myDatabase=new Testmydatabase();
		myDatabase.close();
	}
}
