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
			//ע�Ͳ�����ʹ��query��װ�����
//			//��ȡquery���� �������employee���Ǳ�����domain������
//			//��where��������������������������Ҳ�����Ǳ���ֶΣ�����hibernate�涨�����ǻ���Ӧ��ʹ�������������
//			Query query=session.createQuery("from Employee where id=7");
//			//ͨ��list������ȡ��������list���Զ��Ľ������װ�ɶ�Ӧ��domain����
//			//�������Ƕ�jdbc���ж��η�װ�Ĺ�����û����
//			List<Employee> list=query.list();
//			for(Employee e:list){
//				System.out.println("����Ϊ"+e.getName()+"  id��Ϊ"+e.getId());
//			}
			//���²�����ʹ��Criteria�������Ʋ�ѯ
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
		//ɾ��
		//��ȡһ��session�Ự  ͬ��
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
			throw new RuntimeException(e.getMessage()+"ɾ��ʱ����");
		}finally{
			//�ر�session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}

	public static void updateEmployee() {
//		//�޸��û�
//		//1.����configuration����
//		//2.�����Ự������sessionfactory����һ���������Ķ�������Ӧ��
//		//��֤sessionfactory�ǵ�̬�ġ�
//		//��ȡһ���Ự   �൱������������
//		Session session=MySessionFactory.getSessionFactory().openSession();
//		//�޸��û�1.��ȡҪ�޸ĵ��û��� 2.�޸�
//		//load��ͨ���������ԣ���ȡ�ö���ʵ��<--->��ļ�¼��Ӧ
//		Transaction transaction=session.beginTransaction();
//		Employee emlpoyee=(Employee) session.load(Employee.class,3);
//		//�Ͼ��൱��-->select * from employee where id=3;
//		emlpoyee.setName("�ܽ���");//-->�൱��update employee set name='��˳ƽ' where id=3;
//		emlpoyee.setHiredate(new Date());//ͬʱ�޸�����ֻ�����һ��update���  ���Զ�ʶ��
//		transaction.commit();
//		session.close();
		
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			Employee employee=(Employee) session.load(Employee.class, 5);
			employee.setName("�");
//			int i=10/0;
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			//�ر�session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}

	public static void insertEmployee() {
//		//����ʹ��hibernate���crud����[��������ֻ�����󣬲�����]
//		//�������ǲ�ʹ��service ��ֱ�Ӳ���
//		//1.����configuration,�ö������ڶ�ȡhibernate.cfg.xml������ɳ�ʼ��
//		Configuration configuration=new Configuration().configure();
//		//2.����sessionfactory������һ���Ự��������һ���������Ķ���  ��һ���ӿڡ�
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		//3.����session�൱��jdbc�д�����connection��servelt httpsession ��Ҳ����jsp session��
//		Session session=sessionFactory.openSession();
//		//4.��hibernate���ԣ�Ҫ�����Ա�ڽ��У� ���ӣ�ɾ�����޸ĵ�ʱ��ʹ�������ύ
//		Transaction transaction=session.beginTransaction();
//		//���һ����Ա
//		Employee employee=new Employee();
//		employee.setName("liangjie");
//		employee.setEmail("liangjie@sohu.com");
//		employee.setHiredate(new Date());
//		//insert,,,,,
//		//����
//		session.save(employee);//==>insert into..[��hibernate��װ]
//		transaction.commit();
//		session.close();
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=null;
		try {
			transaction=session.beginTransaction();
			Employee employee=new Employee();
			employee.setName("����");
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
			//�ر�session
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
	}
}
