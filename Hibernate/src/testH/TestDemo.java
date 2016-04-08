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
	            //��������  
	            session.beginTransaction();  
	              
	            Users user = new Users();  
	            user.setId(2);
	            user.setUsername("�û���");  
	            user.setPassword("123");  
	              
	            session.save(user);  
	            //�ύ����  
	            session.getTransaction().commit();  
	            session.close();
	        }catch(Exception e){  
	            e.printStackTrace();  
	            //�ع�����  
	            session.getTransaction().rollback();  
	        }finally{  
	            if(session != null){  
	                if(session.isOpen()){  
	                    //�ر�session  
	                    session.close();  
	                }  
	            }  
	        }  
	    }  
}
