<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://fonts.useso.com/css?family=Open+Sans:300,400">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<title>BBS-postnews</title>
<style>
.lastpost h2 {
	background: #7c919a;
	color: white;
	font-size: 25px;
	padding: 10px;
	text-align: center;
}

.lastpost p {
	text-indent: 2em;
}

.lastpost div {
	padding: 20px 10px;
}

.post h4 {
	border-bottom: 1px solid #7c919a;
	margin-top: -10px;
	font-size: 20px;
}

nav h4 {
	border-right: 3px solid #7c919a;
	text-align: right;
	font-size: 16px;
	margin-top: 20px;
}

.lastpost span.date {
	font-size: 16px;
	margin-left: 800px;
	font-weight: bolder;
	color: black;
}

.tm-margin-t-big input {
	border: 1px solid #e6e6e6;
	padding-left: 15px;
	width: 80%;
}

.tm-margin-t-big textarea {
	width: 100%;
	height: 180px;
	border: 1px solid #e6e6e6;
	padding-left: 15px;
}

.tm-margin-t-big {
	margin-left: -3px;
	margin-right: -3px;
}

.tm-margin-t-big h2 {
	background: #7c919a;
	color: white;
	font-size: 25px;
	padding: 10px;
	text-align: center;
	margin-bottom: 30px;
}

.tm-margin-t-big span:nth-child(1) {
	color: #8c8c8c;
	font-size: 18px;
	font-weight: bolder;
}

.tm-margin-t-big span:nth-child(3) {
	color: #8c8c8c;
	font-weight: bold;
	font-size: 15px;
}

.tm-margin-t-big input:hover, textarea:hover {
	border: 1px solid #7c919a;
}
</style>
</head>
<body>

	<div class="tm-header">
		<div class="container-fluid">
			<div class="tm-header-inner">
				<a href="#" class="navbar-brand tm-site-name">BBS</a>

				<!-- navbar -->
				<nav class="navbar tm-main-nav">

				<button class="navbar-toggler hidden-md-up" type="button"
					data-toggle="collapse" data-target="#tmNavbar">&#9776;</button>

				<div class="collapse navbar-toggleable-sm" id="tmNavbar">
					<ul class="nav navbar-nav">
						<li class="nav-item"><a
							href="<%=request.getContextPath()%>/bbsServlet?action=toindex"
							class="nav-link">首页</a></li>
						<!--  <li class="nav-item">
                                    <a href="reply.jsp" class="nav-link">回帖</a>
                                </li> -->
						<li class="nav-item active"><a href="postnews.jsp"
							class="nav-link">发帖</a></li>
						<li class="nav-item "><a
							href="<%=request.getContextPath()%>/bbsServlet?action=tomine"
							class="nav-link">我的</a></li>
							<%
									Object o = session.getAttribute("username");
									System.out.print("------------------------"+o);
									if (o == null){
								%>   
						<li class="nav-item"><a href="login.jsp" class="nav-link">登录</a>
						</li>
						<li class="nav-item"><a href="register.jsp" class="nav-link">注册</a>
						</li>
						  <% 
									} else {
								%>
									<li class="nav-item">
									<a href="${pageContext.request.contextPath}/LogoutServlet" class="nav-link">注销</a>
									</li>
									<li class="nav-item">
									<a href="#o=<%o.toString(); %>" class="nav-link"><%=o.toString() %></a>
									</li>
								<% }
									%> 
					</ul>
				</div>

				</nav>

			</div>
		</div>
	</div>

	<div class="tm-blog-img-container"></div>

	<section class="tm-section">
	<div class="container-fluid">
		<div class="row">

			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
				<div class="tm-blog-post">
					<h3 class="tm-gold-text">发帖区</h3>
					<p>A place talk what you want to talk</p>
					<!--  <img src="img/tm-img-1010x336-1.jpg" alt="Image" class="img-fluid tm-img-post"> -->

					<div class="lastpost">
						<!--  已经有的帖子区-->
						<%-- <h2>旧帖子</h2>
						
						<c:if test="${postflag==null}">
						还没有发帖~
						</c:if>
						<c:if test="${postflag=='yes'}">
							<div >
							
								<h5>标题：${bfposts.title}</h5>
								<h5>主题：${bfposts.subject}</h5>
								<p>详情：${bfposts.message}</p>
								<p> 发布时间${bfposts.postTime }</p>
							</div>
						</c:if> --%>
					</div>
					
				</div>

				<div class="row tm-margin-t-big">
					<h2>今日帖子</h2>
					
						<c:if test="${todaypostflag==null}">
						今天还没有发帖~
						</c:if>
						<c:if test="${todaypostflag=='yes'}">
					

							<div >
							
								<h5>标题：${todaynewone.title}</h5>
								<h5>主题：${todaynewone.subject}</h5>
								<p>详情：${todaynewone.message}</p>
								<p> 发布时间${todaynewone.postTime }</p>
							</div>
						</c:if>
					<div class="input_post">
					    <form action="<%=request.getContextPath()%>/bbsServlet?action=toAddpostnews" method="post">
						<span>主题</span>&nbsp;&nbsp;&nbsp; 
						<select id="subject" name="subject" style="width: 197px; border: 1px solid #e6e6e6; text-align: center;">
								<c:forEach items="${sub}" var="sub" varStatus="id" begin="1">
									<option value="${sub.subject}">
										<c:out value="${sub.subject }" />
									</option>
								</c:forEach>
							</select></br> 
				      	<span>标题</span>&nbsp;&nbsp;&nbsp;
						<input type="text" value="" name="title" placeholder="添加你的标题"
							 /><br>
						<span>内容</span>&nbsp;&nbsp;&nbsp;</br>
						<input style="height: 200px; text-align: center;" type="text"
								name="message" placeholder="发表新鲜事！" /> </br> <br />
							<button class="tm-btn text-uppercase" style="margin-left:80%">发表</button>
						 </form>
					</div>
					
				</div>

			</div>

			<aside
				class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 tm-aside-r">

			<div class="tm-aside-container">
				<h3 class="tm-gold-text tm-title">我的旧贴</h3>
				<nav>
				
				<ul class="nav">
					<c:if test="${postflag=='yes'}">
						<c:forEach items="${myposts}" var="mypost">
						<h4>${mypost.postTime }</h4>
							<li><a
								href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=${mypost.subject}&postId=${mypost.postId}"
								class="tm-text-link">${mypost.title}</a></li>
							<li><a
								style="margin: 0; font-size: 15px; background: #7c919a; color: white;"
								href="<%=request.getContextPath()%>/bbsServlet?action=deletepost&userId=${user.userId}&postId=${mypost.postId}"
								class="tm-text-link">删除</a></li>

						</c:forEach>
					</c:if>
					<c:if test="${postflag=='no'}">
								还没有发过贴子~试试发帖吧~
								</c:if>
				</ul>
				</nav>


			</div>


			</aside>

		</div>

	</div>
	</section>

	<!-- load JS files -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- jQuery (https://jquery.com/download/) -->
	<script
		src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
	<!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->

</body>
</html>