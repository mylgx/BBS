package cn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Timestamp;

import cn.entity.Reply;
import cn.entity.User;
import cn.entity.newspost;
import cn.service.ReplyService;
import cn.service.UserService;
import cn.service.newspostService;
import cn.service.impl.ReplyServiceImpl;
import cn.service.impl.UserServiceImpl;
import cn.service.impl.newspostServiceImpl;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		System.out.println("到达");
		newspostService  newservice=new newspostServiceImpl();
		ReplyService replyservice=new ReplyServiceImpl();
		/*HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");*/
		/*int userId=user.getUserId();*/		
		String userId=request.getParameter("userId");
		String postId=request.getParameter("postId");
		String message=request.getParameter("message");
		/*newspost news=(newspost)session.getAttribute("theReplyNews");*/
		/*int postId=news.getPostId();*/
		newspost news=newservice.getBypostId(Integer.parseInt(postId));
		System.out.println(news);
		/*System.out.println("postnews de id "+news.getPostId());*/
		
		System.out.println(message);
		
	
	  	Date d = new Date();  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    String replyTime = sdf.format(d);  
	    System.out.println("huifushijian"+replyTime);
	    
	    Reply reply=new Reply(Integer.parseInt(userId),message,replyTime,Integer.parseInt(postId));
	    int m=replyservice.addReply(reply);request.getRequestDispatcher("reply.jsp").forward(request, response);
	    if(m!=0)
	    {
	    	System.out.println("已发表！");
	    	request.setAttribute("message",message);
	    	
	    }
	    else {
	    	System.out.println("servlet中出错！");
	    	request.getRequestDispatcher("reply.jsp").forward(request, response);

	    }

		
		
		
	}
	

}
