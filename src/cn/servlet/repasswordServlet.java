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
import cn.utils.JdbcUtils;

/**
 * Servlet implementation class repasswordServlet
 */
@WebServlet("/repasswordServlet")
public class repasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public repasswordServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
	

		response.setContentType("text/html;charset=UTF-8");
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		System.out.println(userCode);
		System.out.println(password);
		System.out.println(repassword);
		UserService userService = new UserServiceImpl();
		User user1 = userService.LoginByName(userCode, password);
		String sql = "update user set password=?where userName=?";
		if(null!=user1){
			System.out.println(userCode);
			int m = JdbcUtils.executeSQL(sql,repassword,userCode);
			if(m!=0)
				response.sendRedirect("login.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}
}


