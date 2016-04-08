package com.hsp.view;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.sql.Insert;

import com.hsp.domain.Employee;
import com.hsp.util.MySessionFactory;
public class TestMain {
	public static void main(String[] arg0){
		insertEmployee();
	}

	public static void deleteEmployee() {
		//删除
		//获取一个session会话  同理：
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Employee employee=(Employee) session.load(Employee.class, 4);
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	public static void updateEmployee() {
		//修改用户
		//1.创建configuration对象
		//2.创建会话工厂，sessionfactory这是一个重量级的对象，我们应当
		//保证sessionfactory是单态的。
		//获取一个会话   相当于用来打开连接
		Session session=MySessionFactory.getSessionFactory().openSession();
		//修改用户1.获取要修改的用户， 2.修改
		//load是通过主键属性，获取该对象实例<--->表的记录对应
		Transaction transaction=session.beginTransaction();
		Employee emlpoyee=(Employee) session.load(Employee.class,3);
		//上句相当于-->select * from employee where id=3;
		emlpoyee.setName("周杰伦");//-->相当于update employee set name='韩顺平' where id=3;
		emlpoyee.setHiredate(new Date());//同时修改两个只会产生一个update语句  能自动识别。
		transaction.commit();
		session.close();
	}

	public static void insertEmployee() {
		//我们使用hibernate完成crud操作[这里我们只见对象，不见表]
		//现在我们不使用service ，直接测试
		//1.创建configuration,该对象用于读取hibernate.cfg.xml，并完成初始化
		Configuration configuration=new Configuration().configure();
		//2.创建sessionfactory【这是一个会话工厂，是一个重量级的对象  是一个接口】
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//3.创建session相当于jdbc中创建的connection【servelt httpsession ，也不是jsp session】
		Session session=sessionFactory.openSession();
		//4.对hibernate而言，要求程序员在进行， 增加，删除，修改的时候使用事务提交
		Transaction transaction=session.beginTransaction();
		//添加一个雇员
		Employee employee=new Employee();
		employee.setName("liangjie");
		employee.setEmail("liangjie@sohu.com");
		employee.setHiredate(new Date());
		//insert,,,,,
		//保存
		session.save(employee);//==>insert into..[被hibernate封装]
		transaction.commit();
		session.close();
	}
}
