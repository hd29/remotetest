package com.xiaoyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xiaoyuan.domain.University;
import com.xiaoyuan.service.inter.UniversityServiceInter;

public class ChangeInfo extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings({"unchecked" })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache"); 
		PrintWriter out = response.getWriter();
		//响应用户选择不同省/直辖市的大学信息请求
		String proid=request.getParameter("proid");
		String cid=request.getParameter("cid");
//		System.out.println(proid);
//		System.out.println(cid);
		//获取spring容器
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从spring容器中，取出了universityserviceinter类型的bean
		UniversityServiceInter universityService=(UniversityServiceInter)ctx.getBean("universiteImpl");
		List<University> uniList=universityService.getResult("from University where province.id=? and country.id=?",new Object[]{Integer.valueOf(proid),Integer.valueOf(cid)});
		
//		String res="<allUniversities>";
//		for(int i=0;i<uniList.size();i++){
//			University u=uniList.get(i);
//			res+="<unis><id>"+u.getId()+"</id><name><[CDATA>["
//			+u.getName()+"]]></name></unis>";
//		}
//		res+="</allUniversities>";
//		System.out.println(res);
		String res = "<allUniversities>";
		
		for (int i = 0; i < uniList.size(); i++) {
			University u = uniList.get(i);
			res += "<unis><id>" + u.getId() + "</id><name><![CDATA["
					+ u.getName() + "]]></name></unis>";
		}
		res += "</allUniversities>";
		out.write(res);
		out.close();
		System.out.println(res);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
