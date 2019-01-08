<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>BBS-reply</title>
<!-- load stylesheets -->
<link rel="stylesheet"
	href="http://fonts.useso.com/css?family=Open+Sans:300,400">
<!-- Google web font "Open Sans" -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/templatemo-style.css">
<!-- Templatemo style -->
<style>
li {
	list-style: none;
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
							<li class="nav-item active"><a href="reply.jsp"
								class="nav-link">回帖</a></li>
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/bbsServlet?action=toAddNews"
								class="nav-link">发帖</a></li>
							<li class="nav-item "><a
								href="<%=request.getContextPath()%>/bbsServlet?action=tomine"
								class="nav-link">我的</a></li>
							<%
								Object o = session.getAttribute("username");
								System.out.print("------------------------" + o);
								if (o == null) {
							%>
							<li class="nav-item"><a href="login.jsp" class="nav-link">登录</a>
							</li>
							<li class="nav-item"><a href="register.jsp" class="nav-link">注册</a>
							</li>
							<%
								} else {
							%>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/LogoutServlet"
								class="nav-link">注销</a></li>
							<li class="nav-item"><a href="#o=<%o.toString();%>"
								class="nav-link"><%=o.toString()%></a></li>
							<%
								}
							%>
						</ul>
					</div>

				</nav>

			</div>
		</div>
	</div>

	<div class="tm-about-img-container"></div>

	<section class="tm-section">
		<div class="container-fluid">
			<div class="row tm-2-rows-sm-swap">
				<div
					class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 tm-2-rows-sm-down-2">

					<h3 class="tm-gold-text">主题 ${theReplyNews.subject}</h3>

					<nav>
						<ul class="nav">
							<c:forEach items="${news}" var="somenews">

								<li><a
									href="<%=request.getContextPath() %>/bbsServlet?action=toreply&subject=${somenews.subject}&postId=${somenews.postId}"
									class="tm-text-link"> ${somenews.title}</a></li>
							</c:forEach>
						</ul>
					</nav>

				</div>

				<div
					style="border-left: 1px dashed #7c919a; padding: 5px; margin-top: 5px; border-right: 1px dashed #7c919a;"
					class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9 tm-2-rows-sm-down-1">
					<h3 class="tm-gold-text">${theReplyNews.title}</h3>
					<p>${theReplyNews.message }</p>

					<a id="user" value="username">
						<p style="font-size: 14px">楼主&nbsp;${newsUserName}
							&nbsp;&nbsp; ${theReplyNews.postTime }</p>
					</a>
					<p>
					<p style="font-size: 14px; color: #8c8c8c">
						${theReplyNews.title}的回复</p>
					<p style="font-size: 14px; color: #0275d8;">我的回复：</p>
					<c:forEach items="${myreplys}" var="myreply">

						<li>${myreply.message}</li>
					</c:forEach>
					<br>
					<p style="font-size: 14px; color: #0275d8;">评论：</p>
					<c:forEach items="${replys}" var="reply">
						<li style="font-size: 14px; color: #0275d8;">${replyname }
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${reply.replyTime }</li>
						<li>${reply.message}</li>
					</c:forEach>

					</p>

				</div>


			</div>
		</div>
		<div
			class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9 tm-2-rows-sm-down-1">
			<hr>
			<form style="margin-left: 300px;"
				action="<%=request.getContextPath() %>/bbsServlet?action=reply&userId=${user.userId }&postId=${theReplyNews.postId}"
				method="post">

				<br> <br>
				<p>输入内容</p>
				<input style="width: 100%; height: 200px; text-align: center;"
					type="text" name="message" placeholder="发表你的看法！" />
				<button style="margin-left: 88%; margin-top: 5px;"
					class="tm-btn text-uppercase">发表</button>

			</form>


		</div>

		<!-- load JS files -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<script
			src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!-- <script>
			function replay(obj) {
				//获取id
				var user = document.getElementById("user");
				//获取标签的value属性
				user.value = obj.value;
				alert(user.value);
				//obj.value=value;
				$('replay').value += '回复' + obj.value + '楼\n';
			}
			function $(id) {
				return document.getElementById(id)
			}

			/* 	function reply(obj){
					var send=document.getElementById("send");
					if(obj.onclick){
						send.style.visibility="visible";
					}
				} */
		</script> -->
</body>
</html>
