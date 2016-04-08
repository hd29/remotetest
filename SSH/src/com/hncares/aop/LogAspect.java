package com.hncares.aop;

import org.apache.log4j.Logger;




public class LogAspect {

//	@After("execution(* com.hncares.action.UsersAction.login(..))")
	//@After("execution(* com.hncares.action.AccountAction.login(..))")
	public void loginLog() {
		System.out.println("aop");
		Logger logger = Logger.getLogger(LogAspect.class);
		logger.info("Here is INFO message");
//		Users user = (Users) ActionContext.getContext().getSession().get("user");
//		if (user!=null) {
//			//saveLog(user,joinpoint);
//		}
	}
	
////	@Before("execution(* com.hncares.action.UsersAction.registered(..))")
//	@Before("execution(* com.hncares.test.*.*(..))")
//	public void RegisterLog(Joinpoint joinpoint) {
//		System.out.println(11);
//		Users user = (Users) ActionContext.getContext().getSession().get("user");
//		if (user!=null) {
//			saveLog(user,joinpoint);
//		}
//	}

//	public void saveLog(Users user, Joinpoint joinpoint) {
//		Logger loger = Logger.getLogger(LogAspect.class);
//		loger.log(Level.INFO, user+":caozuo");
//	}
	
}
