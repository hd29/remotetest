package com.hncares.aop;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAspect {

//	@After("execution(* com.hncares.action.UsersAction.login(..))")
//	@After("execution(* com.hncares.action.AccountAction.login(..))")
	public void loginLog() {
		System.out.println("aop");
		Logger logger = Logger.getLogger(LogAspect.class);
		logger.info("��¼��Ϣ........���ԣ�");
		logger.error("������Ϣ");
		logger.log(Level.INFO, "�ռ�");
	}
	
}