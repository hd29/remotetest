package com.hsp.view;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;

import com.hsp.domain.Employee;
import com.hsp.util.HibernateUtil;
import com.hsp.util.MySessionFactory;
public class TestMain {
	public static void main(String[] arg0){
//		Session s1=HibernateUtil.getCurrentSession();
//		Session s2=HibernateUtil.getCurrentSession();
//		System.out.println("s1="+s1.hashCode()+"  "+"s2="+s2.hashCode());
//		insertEmployee();
		Session session=HibernateUtil.getCurrentSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			//注释部分是使用query封装结果集
//			//获取query引用 【这里的employee不是表，而是domain类名】
//			//【where后面的条件可以是类的属性名，也可以是表的字段，按照hibernate规定，我们还是应该使用类的属性名】
//			Query query=session.createQuery("from Employee where id=7");
//			//通过list方法获取结果，这个list会自动的将结果封装成对应的domain对象
//			//所以我们对jdbc进行二次封装的工作就没有了
//			List<Employee> list=query.list();
//			for(Employee e:list){
//				System.out.println("姓名为"+e.getName()+"  id号为"+e.getId());
//			}
			//以下部分是使用Criteria进行限制查询
			Criteria criteria=session.createCriteria(Employee.class).setMaxResults(5).addOrder(Order.desc("id"));
			List<Employee> list=criteria.list();
			for(Employee e:list){
				System.out.println(e.getId()+" "+e.getName()+" "+e.getEmail()+" "+e.getHiredate());
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}

	public static void deleteEmployee() {
		//删除
		//获取一个session会话  同理：
//		Session session=MySessionFactory.getSessionFactory().openSession();
//		Transaction transaction=session.beginTransaction();
//		Employee employee=(Employee) session.load(Employee.class, 4);
//		session.delete(employee);
//		transaction.commit();
//		session.close();
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			Employee employee=(Employee) session.load(Employee.class, 3);
			session.delete(employee);
//			int i=10/0;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage()+"删除时出错！");
		}finally{
			//关闭session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}

	public static void updateEmployee() {
//		//修改用户
//		//1.创建configuration对象
//		//2.创建会话工厂，sessionfactory这是一个重量级的对象，我们应当
//		//保证sessionfactory是单态的。
//		//获取一个会话   相当于用来打开连接
//		Session session=MySessionFactory.getSessionFactory().openSession();
//		//修改用户1.获取要修改的用户， 2.修改
//		//load是通过主键属性，获取该对象实例<--->表的记录对应
//		Transaction transaction=session.beginTransaction();
//		Employee emlpoyee=(Employee) session.load(Employee.class,3);
//		//上句相当于-->select * from employee where id=3;
//		emlpoyee.setName("周杰伦");//-->相当于update employee set name='韩顺平' where id=3;
//		emlpoyee.setHiredate(new Date());//同时修改两个只会产生一个update语句  能自动识别。
//		transaction.commit();
//		session.close();
		
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			Employee employee=(Employee) session.load(Employee.class, 5);
			employee.setName("李晨");
//			int i=10/0;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			//关闭session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}

	public static void insertEmployee() {
//		//我们使用hibernate完成crud操作[这里我们只见对象，不见表]
//		//现在我们不使用service ，直接测试
//		//1.创建configuration,该对象用于读取hibernate.cfg.xml，并完成初始化
//		Configuration configuration=new Configuration().configure();
//		//2.创建sessionfactory【这是一个会话工厂，是一个重量级的对象  是一个接口】
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		//3.创建session相当于jdbc中创建的connection【servelt httpsession ，也不是jsp session】
//		Session session=sessionFactory.openSession();
//		//4.对hibernate而言，要求程序员在进行， 增加，删除，修改的时候使用事务提交
//		Transaction transaction=session.beginTransaction();
//		//添加一个雇员
//		Employee employee=new Employee();
//		employee.setName("liangjie");
//		employee.setEmail("liangjie@sohu.com");
//		employee.setHiredate(new Date());
//		//insert,,,,,
//		//保存
//		session.save(employee);//==>insert into..[被hibernate封装]
//		transaction.commit();
//		session.close();
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			Employee employee=new Employee();
			employee.setName("梁杰");
			employee.setEmail("929558508@qq.com");
			employee.setHiredate(new Date());
			session.save(employee);
//			int i=10/0;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			//关闭session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}
}
