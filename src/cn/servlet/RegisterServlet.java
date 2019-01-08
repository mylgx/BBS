package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.entity.User;
import cn.service.UserService;
import cn.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		String phoneNumber = request.getParameter("phoneNumber");
		String username = request.getParameter("id");
		String weixin = request.getParameter("weixin");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		if(password.equals(repassword)) {
			System.out.println("开始注册");
		    UserService userservice = new UserServiceImpl();
		    User user = new User(username,password,phoneNumber,weixin);
		    int m = userservice.addUser(user);
		    System.out.println(m);
		    if(m!=0) {
			System.out.println("注册成功");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
			
		  }
		   else {
			System.out.println("注册失败");
			response.sendRedirect("register.jsp");
		  }
		}
		else {
			System.out.println("密码输入错误");
			response.sendRedirect("register.jsp");
		}
		
		
	}

}
