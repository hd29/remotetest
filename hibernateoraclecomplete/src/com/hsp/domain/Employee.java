package com.hsp.domain;

import java.io.Serializable;
import java.util.Date;

//����domain��������ƾ��Ƕ�Ӧ�ı������ ����ĸ��д��javabeans/pojo��plain old/ordinary java project�򵥵�java���󣩣�
//��pojo(ָ����)���չ淶Ӧ�����л���Ŀ���ǿ���Ψһ�ı�ʶ�ö���ͬʱ������������ļ�����
public class Employee implements Serializable {
	private static final long serializable=1L;
	private Integer id;
	private String name;
	private String email;
	private Date hiredate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
}
