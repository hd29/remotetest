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
		//ɾ��
		//��ȡһ��session�Ự  ͬ��
		Session session=MySessionFactory.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Employee employee=(Employee) session.load(Employee.class, 4);
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	public static void updateEmployee() {
		//�޸��û�
		//1.����configuration����
		//2.�����Ự������sessionfactory����һ���������Ķ�������Ӧ��
		//��֤sessionfactory�ǵ�̬�ġ�
		//��ȡһ���Ự   �൱������������
		Session session=MySessionFactory.getSessionFactory().openSession();
		//�޸��û�1.��ȡҪ�޸ĵ��û��� 2.�޸�
		//load��ͨ���������ԣ���ȡ�ö���ʵ��<--->��ļ�¼��Ӧ
		Transaction transaction=session.beginTransaction();
		Employee emlpoyee=(Employee) session.load(Employee.class,3);
		//�Ͼ��൱��-->select * from employee where id=3;
		emlpoyee.setName("�ܽ���");//-->�൱��update employee set name='��˳ƽ' where id=3;
		emlpoyee.setHiredate(new Date());//ͬʱ�޸�����ֻ�����һ��update���  ���Զ�ʶ��
		transaction.commit();
		session.close();
	}

	public static void insertEmployee() {
		//����ʹ��hibernate���crud����[��������ֻ�����󣬲�����]
		//�������ǲ�ʹ��service ��ֱ�Ӳ���
		//1.����configuration,�ö������ڶ�ȡhibernate.cfg.xml������ɳ�ʼ��
		Configuration configuration=new Configuration().configure();
		//2.����sessionfactory������һ���Ự��������һ���������Ķ���  ��һ���ӿڡ�
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//3.����session�൱��jdbc�д�����connection��servelt httpsession ��Ҳ����jsp session��
		Session session=sessionFactory.openSession();
		//4.��hibernate���ԣ�Ҫ�����Ա�ڽ��У� ���ӣ�ɾ�����޸ĵ�ʱ��ʹ�������ύ
		Transaction transaction=session.beginTransaction();
		//���һ����Ա
		Employee employee=new Employee();
		employee.setName("liangjie");
		employee.setEmail("liangjie@sohu.com");
		employee.setHiredate(new Date());
		//insert,,,,,
		//����
		session.save(employee);//==>insert into..[��hibernate��װ]
		transaction.commit();
		session.close();
	}
}
