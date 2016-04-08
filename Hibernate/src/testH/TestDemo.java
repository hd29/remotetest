package testH;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;



public class TestDemo{
	public static void main(String[] args) {
		 Configuration cfg = new Configuration().configure();  
       
	        SessionFactory factory = cfg.buildSessionFactory();  
	          
	        Session session = null;  
	        try{  
	            session = factory.openSession();  
	            //开启事务  
	            session.beginTransaction();  
	              
	            Users user = new Users();  
	            user.setId(2);
	            user.setUsername("用户名");  
	            user.setPassword("123");  
	              
	            session.save(user);  
	            //提交事务  
	            session.getTransaction().commit();  
	            session.close();
	        }catch(Exception e){  
	            e.printStackTrace();  
	            //回滚事务  
	            session.getTransaction().rollback();  
	        }finally{  
	            if(session != null){  
	                if(session.isOpen()){  
	                    //关闭session  
	                    session.close();  
	                }  
	            }  
	        }  
	    }  
}
