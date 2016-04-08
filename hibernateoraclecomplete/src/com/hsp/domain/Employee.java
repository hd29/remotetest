package com.hsp.domain;

import java.io.Serializable;
import java.util.Date;

//建议domain对象的名称就是对应的表的名称 首字母大写（javabeans/pojo（plain old/ordinary java project简单的java对象））
//该pojo(指此类)按照规范应当序列化，目的是可以唯一的标识该对象，同时可以在网络和文件传输
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
