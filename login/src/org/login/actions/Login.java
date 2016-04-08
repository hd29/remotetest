package org.login.actions;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.login.service.IUsersService;
import org.login.vo.Users;

import com.opensymphony.xwork2.ActionSupport;

//action
@SuppressWarnings({"serial","unchecked"})
public class Login extends ActionSupport implements ServletRequestAware {

	//设置常量
	private static final String UPDATE = "update";
	
	private HttpServletRequest request = null;
	
	private IUsersService userService = null;
	
	//属性
	private String id = null;
	private String name = null;
	private String password = null;
	
	//set/get方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public IUsersService getUserService() {
		return userService;
	}

	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}

	//调用execute方法,登陆
	@Override
	public String execute() throws Exception {
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);
		if (getUserService().checkLogin(user)) {
			return SUCCESS;//返回常量
		}
		return INPUT;
	}
	
	//添加
	public String save() throws Exception {
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);
//		user.setId(11);
		if (getUserService().saveUser(user)) {
			return SUCCESS;
		}
		return ERROR;
	}

	//修改
	public String update() throws Exception {
		Users user = null;
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		if ("loading".equals(action)) {
			user = new Users();
			user = getUserService().getUserById(Integer.valueOf(id));
			if (null != user) {
				request.setAttribute("user", user);
			}
			return UPDATE;//到修改页面
			
		} else {
			user = new Users();
			user.setUsername(name);
			user.setPassword(password);
			user.setId(Integer.valueOf(id));//string转成bigdecimal不能用integer.valueof(string id)的形式
			if (getUserService().updateUser(user)) {
				return SUCCESS;//修改完成到成功页面
			}
		}
		
		return ERROR;//到错误页面
	}
	
	//删除
	public String delete() throws Exception {
		String id = request.getParameter("id");
		if (getUserService().deleteUser(Integer.valueOf(id))) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	//查询所有
	public String findAllUsers() throws Exception {
		List<Users> list = getUserService().findAllUsers(); 
		if (list.size() > 0) {
			request.setAttribute("list", list);
			return SUCCESS;
		}
		return ERROR;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}


}
