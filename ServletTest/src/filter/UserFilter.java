package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("user");
		System.out.println("session"+username);
		if(username==null||username==""){
//			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
			resp.sendRedirect("/ServletTest/login.jsp");
			System.out.println("跳转到登录页面执行");
		}else{
			chain.doFilter(request, response);
		}
		
//		if (username.equals("lin")) {//username!=null&&username!=""
//			   chain.doFilter(request, response);
//			   System.out.println("userf");
//			  } else {
//				  
////				  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
////				  rd.forward(request, response);
////				  chain.doFilter(request, response);
////				  resp.sendRedirect("login.jsp");
//			  }
			  
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
