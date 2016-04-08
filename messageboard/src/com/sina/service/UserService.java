package com.sina.service;
import java.util.List;

import javax.print.attribute.standard.Finishings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sina.domain.Users;
import com.sina.util.HibernateUtil;
import com.sina.util.MySessionFactory;

public class UserService {
	//验证用户是否合法
	public Users checkUser(Users users){
//		Session session=null;
//		Transaction transaction=null;
//		try {
//			session=HibernateUtil.getCurrentSession();
//			transaction=session.beginTransaction();
//			List<Users> list=session.createQuery("from Users where name='"+users.getName()+"'and password='"+users.getPassword()+"'").list();
//			
//			
//			if(list.size()==1){
//				users=list.get(0);
//			}else{
//				users=null;
//			}
//			transaction.commit();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			if(transaction!=null){
//				transaction.rollback();
//			}
//			throw new RuntimeException(e.getMessage());
//		}finally{
//			if(session!=null&&session.isOpen()){
//				session.close();
//			}
//		}
//		return users;
		//service的作用：查出是否有表单中的name 和 password  然后users由参数传入
		String hql="from Users where name='"
				+users.getName()+"' and password='"+users.getPassword()+"'";
		//此处hibernateUtil类由于没有进行实例化  要直接调用方法需要把executeQuery方法设置成static
		List<Users> list=HibernateUtil.executeQuery(hql);
		if(list.size()==1)
		{
			System.out.println("数字为1");
			return list.get(0);
		}else{
			System.out.println("数字为2");
			return null;
		}
	}
	
}
