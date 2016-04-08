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

	//���ó���
	private static final String UPDATE = "update";
	
	private HttpServletRequest request = null;
	
	private IUsersService userService = null;
	
	//����
	private String id = null;
	private String name = null;
	private String password = null;
	
	//set/get����
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

	//����execute����,��½
	@Override
	public String execute() throws Exception {
		Users user = new Users();
		user.setUsername(name);
		user.setPassword(password);
		if (getUserService().checkLogin(user)) {
			return SUCCESS;//���س���
		}
		return INPUT;
	}
	
	//���
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

	//�޸�
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
			return UPDATE;//���޸�ҳ��
			
		} else {
			user = new Users();
			user.setUsername(name);
			user.setPassword(password);
			user.setId(Integer.valueOf(id));//stringת��bigdecimal������integer.valueof(string id)����ʽ
			if (getUserService().updateUser(user)) {
				return SUCCESS;//�޸���ɵ��ɹ�ҳ��
			}
		}
		
		return ERROR;//������ҳ��
	}
	
	//ɾ��
	public String delete() throws Exception {
		String id = request.getParameter("id");
		if (getUserService().deleteUser(Integer.valueOf(id))) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	//��ѯ����
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
