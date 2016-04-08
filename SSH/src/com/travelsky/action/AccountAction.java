package com.travelsky.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelsky.service.Account;


public class AccountAction {
	
//	ApplicationContext context =
//		new ClassPathXmlApplicationContext("application.xml");
//	Account accountImpl = (Account) ADUQAction.context.getBean("accountImpl");
	@Autowired
	private Account accountImpl;
	private String username;
	private String password;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		System.out.println("accountImpl");
		if(accountImpl.login(username, password))
			return "success";
		else 
			return "failed";
			
	}


}
