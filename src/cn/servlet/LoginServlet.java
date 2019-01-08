package cn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.entity.User;
import cn.service.UserService;
import cn.service.impl.UserServiceImpl;

import cn.entity.User;
import cn.entity.newspost;
import cn.entity.subject;
import cn.service.UserService;
import cn.service.newspostService;
import cn.service.impl.UserServiceImpl;
import cn.service.impl.newspostServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
	    
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("userPassword");
	    UserService userService = new UserServiceImpl();
		
	    User user = userService.LoginByName(userCode, password);
	 
	    if(null!=user) {
	    	if(!user.getPassword().equals(password)) {
	    		response.sendRedirect("error.jsp");
		    	
	    		}
	    	else {

	    		HttpSession session = request.getSession();
				session.setAttribute("username", userCode);
				session.setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
	    	}
	    }
	    else {
	    	response.sendRedirect("register.jsp");
	    }
	}

}
