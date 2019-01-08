package cn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.impl.UserDaoImpl;
import cn.entity.Reply;
import cn.entity.User;
import cn.entity.newspost;
import cn.entity.subject;
import cn.service.ReplyService;
import cn.service.UserService;
import cn.service.newspostService;
import cn.service.impl.ReplyServiceImpl;
import cn.service.impl.UserServiceImpl;
import cn.service.impl.newspostServiceImpl;

/**
 * Servlet implementation class bbsServlet
 */
@WebServlet("/bbsServlet")
public class bbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bbsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userservice=new UserServiceImpl();
		newspostService newservice = new newspostServiceImpl();
		ReplyService replyservice = new ReplyServiceImpl();
		String action = request.getParameter("action");// 要执行的动作
		HttpSession session = request.getSession();
		System.out.println(action);
		switch (action) {
		case "toindex":// 成功登陆后、跳转至index页面，显示所有主题和一条最热贴子（待做排行榜）
			List<subject> subs = newservice.getAllSubject();
			List<List<newspost>> somenews = new ArrayList<List<newspost>>();
			for (int i = 0; (i < subs.size()); i++) {// 获取全部贴子或者前三个贴子
				subject sub = subs.get(i);// 获取每一个Subject对象
				List<newspost> some = newservice.getBySubject(sub.getSubject());
				somenews.add(some);
			
			}
			request.setAttribute("somenews", somenews);
			request.setAttribute("subs", subs);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "toreply":
			toReplyBySubjectAndPostId(request, newservice,replyservice);
			request.getRequestDispatcher("reply.jsp").forward(request, response);
			break;
		case "toAddNews":
			List<subject> sub = newservice.getAllSubject();
			request.setAttribute("sub", sub);
			toShowMyPostOnPostNews(request, newservice);
			request.getRequestDispatcher("postnews.jsp").forward(request, response);
			break;
		case "deletepost":
			deletepost(request, response, newservice);
			request.getRequestDispatcher("postnews.jsp").forward(request, response);
			break;
		case "toAddpostnews":
			// 添加新帖子
		
			toAddpostnews(request, newservice, session);
			request.getRequestDispatcher("postnews.jsp").forward(request, response);

			break;
		case "tomine":
		//	session.setAttribute("user", user);
			request.getRequestDispatcher("mine.jsp").forward(request, response);

			break;
		case "reply":
			reply(request, newservice, replyservice, session);

			request.getRequestDispatcher("reply.jsp").forward(request, response);
			break;
		case "modify":
			
			modify(request,userservice,session);
			request.getRequestDispatcher("mine.jsp").forward(request, response);
			break;
		case "toSearchNews":
			String title=request.getParameter("text");
			newspostService newspostservice=new newspostServiceImpl();
			List<newspost> newspostlist=new ArrayList<newspost>();
			newspostlist=newspostservice.getByLikeTitle(title);
			if(newspostlist!=null)
			{
				request.getSession().setAttribute("newspostlist", newspostlist);
				response.sendRedirect("index.jsp");
			
			}
			break;
			
		case "toSearchNewsSubject":
		    String subject=request.getParameter("text");
			newspostService newspostservice1=new newspostServiceImpl();
			List<newspost> newspostlist1=new ArrayList<newspost>();
			newspostlist=newspostservice1.getBySubject(subject);
			if(newspostlist!=null) {
				request.getSession().setAttribute("newspostlist", newspostlist1);
				System.out.println(newspostlist);
			}
			break;
			
			
		default:
			break;
		}
	}

	private void reply(HttpServletRequest request, newspostService newservice, ReplyService replyservice,
			HttpSession session) {
		String userId = request.getParameter("userId");
		String postId = request.getParameter("postId");
		String message = request.getParameter("message");
		newspost news = newservice.getBypostId(Integer.parseInt(postId));
	
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String replyTime = sdf.format(d);
	
		Reply reply = new Reply(Integer.parseInt(userId), message, replyTime, Integer.parseInt(postId));
	    int m = replyservice.addReply(reply);
		if (m != 0) {
			System.out.println("已发表！");
		} else {
			System.out.println("servlet中出错！");
		}

		int id=Integer.parseInt(postId);
		int userid=Integer.parseInt(userId);
		getReply(replyservice, session, id, userid);
	}

	private void deletepost(HttpServletRequest request, HttpServletResponse response, newspostService newservice)
			throws ServletException, IOException {
		String postId = request.getParameter("postId");
		newspost oldone = newservice.getBypostId(Integer.parseInt(postId));
		if (newservice.DeleteNewspost(oldone) != 1) {
			System.out.println("删除失败");
		}
		toShowMyPostOnPostNews(request, newservice);
	}

	private void toAddpostnews(HttpServletRequest request, newspostService newservice, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
	    String subject = request.getParameter("subject");
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String postTime = sdf.format(d);
	
		newspost newone = new newspost(subject, title, message, userId, postTime);
		int flag=newservice.AddNewspost(newone);
		if(flag!=0)
		{
			// 显示数据
			try {
				toShowMyPostOnPostNews(request, newservice);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newspost todaynewone = newone;
			String todaypostflag = "yes";
			session.setAttribute("todaypostflag", todaypostflag);// 放置该板块的主题
			session.setAttribute("todaynewone", todaynewone);

		}
		
		
	}

	

	private void toShowMyPostOnPostNews(HttpServletRequest request, 
			newspostService newservice) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
	    int userId=user.getUserId();
		List<newspost> bfposts = newservice.getByUserId(userId);
		String postflag = "yes";
		if (null == bfposts || bfposts.size() == 0) {
			postflag = "no";
		}
		System.out.println("有无发过帖" + postflag);

		request.setAttribute("myposts", bfposts);
		request.setAttribute("postflag", postflag);
	}

	private void toReplyBySubjectAndPostId(HttpServletRequest request, newspostService newservice,ReplyService replyservice) {
		HttpSession session = request.getSession();
		UserService userservice = new UserServiceImpl();
		String subject = request.getParameter("subject");
		String postId = request.getParameter("postId");
		List<newspost> news = newservice.getBySubject(subject);
		newspost theReplyNews = new newspost();
		User user1 = new User();
		int id;
		if (postId == null) {
			id = news.get(0).getPostId();
			
		} else {
			id = Integer.parseInt(postId);
		}
		theReplyNews = newservice.getBypostId(id);
		int userid = theReplyNews.getUserId();
		user1 = userservice.getuserById(userid);
		// 获取theReplyNews的所有回复
		getReply(replyservice, session, id, userid);
		String replyname="";
		User replyuser=new User();
		replyuser=userservice.getuserById(id);
		if(replyuser!=null)
		{
			replyname=replyuser.getUserName();
			request.setAttribute("replyname", replyname);
		}
		request.setAttribute("newsUserName", user1.getUserName());//放置发帖人名字
		session.setAttribute("theReplyNews", theReplyNews);//放置要回帖的帖子对象
		session.setAttribute("news", news);//放置该板块的所有帖子对象
	    request.getSession().setAttribute("postId", theReplyNews.getPostId());
	}

	private void getReply(ReplyService replyservice, HttpSession session, int id, int userid) {
		List<Reply> replys=replyservice.getAllByPostId(id);
		List<Reply> myreplys=replyservice.getAllByPostIdAndUserId(id, userid);
		session.setAttribute("replys", replys);//放置该板块的所有回复对象
		session.setAttribute("myreplys", replys);//放置该板块的所有回复对象
	}

	private void modify(HttpServletRequest request,UserService userservice,HttpSession session) {
		User mine = (User) session.getAttribute("user");
		int userId = mine.getUserId();
		String n_username=request.getParameter("name");
		String phone=request.getParameter("telephone");
		boolean n=userservice.updateUserById(n_username,phone,userId);
		if(n!=false) {
			session.removeAttribute("username");
			session.setAttribute("username", n_username);//更新session中的用户名
			session.removeAttribute("user");
			User n_user= userservice.getuserById(userId);//更新session中的user
			session.setAttribute("user", n_user);
			System.out.println("更新成功。");
			
		}
		else {
			System.out.println("更新失败");
		}
	}
}
