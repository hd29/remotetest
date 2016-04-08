package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		if(name.equals("lin")&&password.equals("123")){
			HttpSession session = req.getSession();
			session.setAttribute("user", name);
			System.out.println("xinxi"+name+password+session.getAttribute("user"));
//			resp.sendRedirect("/filter_file/result.jsp");
			RequestDispatcher rd = req.getRequestDispatcher("/filter_file/result.jsp");
			rd.forward(req, resp);
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("user", "ding");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
