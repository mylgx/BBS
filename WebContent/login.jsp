<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

<style>
body {
	padding: 0;
	margin: 0;
	background: #F7FAFC;
}

a {
	text-decoration: none;
}

.index-box {
	width: 300px;
	height: auto;
	margin: 0 auto;
	margin-top: 40px;
}

.logo {
	background: url(images/header/headerNew4.png) no-repeat;;
	width: 350px;
	height: 100px;
	margin: 0 auto
}

.title {
	font-size: 18px;
	text-align: center;
	color: #707171;
	font-weight: bold;
	margin: 30px auto;
}

.index-body {
	text-align: center;
}

.nav-sliders {
	position: relative;
	display: inline-block;
	margin-bottom: 20px;
}

.nav-sliders>a {
	font-size: 20px;
	display: inline-block;
	width: 60px;
	font-family: "微软雅黑";
	color: #999;
	cursor: pointer;
	float: left;
	$
	width
}

.nav-sliders>a.active {
	color: #7c919a;
}

.nav-sliders>span {
	position: absolute;
	height: 2px;
	background: #7c919a;
	display: block;
	left: 5px;
	width: 50px;
	bottom: -8px;
}

.stage {
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background: #F7FAFC;
}

.login-box {
	width: 300px;
}

.wrap {
	border: 1px solid #d5d5d5;
	border-radius: 5px;
	background: #fff;
}

.wrap>div {
	position: relative;
	overflow: hidden;
}

.wrap>div>input {
	width: 95%;
	border: none;
	padding: 17px 2.5%;
	border-radius: 5px;
}

.wrap>div>label.error {
	position: absolute;
	color: #c33;
	top: 0;
	line-height: 50px;
	transform: translate(25px, 0);
	transition: all 0.5s ease-out;
	-webkit-transform: translate(25px, 0);
	-moz-transform: translate(25px, 0);
	opacity: 0;
	visibility: hidden;
	cursor: text;
}

.wrap>div>label.move {
	transform: translate(0, 0);
	transition: all 0.5s ease-out;
	-webkit-transform: translate(0, 0);
	-moz-transform: translate(0, 0);
	opacity: 1;
	visibility: visible;
}

.password {
	border-top: solid 1px #d5d5d5;
}

.code {
	right: 115px;
}

.name {
	right: 5px;
}

.loginName {
	right: 5px;
}

.loginPass {
	right: 5px;
}

.pass {
	right: 5px;
}

.passagain {
	right: 5px;
}

.button {
	width: 300px;
	height: 40px;
	background: #7c919a;
	text-align: center;
	line-height: 5px 40px;
	border-radius: 5px;
	margin-top: 25px;
	color: #fff;
	font-family: "微软雅黑";
	cursor: pointer;
}

.remember {
	text-align: left;
	margin-top: 20px;
	font-family: "微软雅黑";
	color: #666666;
}

.remember>a {
	float: right;
	cursor: pointer;
	color: #666666;
}

.other {
	text-align: left;
	margin-top: 20px;
	font-family: "微软雅黑";
	color: #666666;
	overflow: hidden;
}

.other>span {
	font-size: 14px;
	float: left;
	margin-top: 2px;
	cursor: pointer;
}

.other>div {
	float: left;
	transition: all 1s ease-in;
	-webkit-transition: all 0.3s ease-in;
	opacity: 0;
	transform: translateX(-20px);
	-webkit-transform: translateX(-18px);
	-moz-transform: translateX(-18px);
	visibility: hidden;
}

.other>div>a {
	margin-left: 20px;
	color: #666666;
	font-size: 15px;
}

.other>.hidden {
	transition: all 1s ease-in;
	display: block;
	-webkit-transition: all 0.3s ease-in;
	opacity: 1;
	transform: translateX(0);
	-webkit-transform: translateX(0);
	-moz-transform: translateX(0);
	visibility: visible;
}

.download {
	border: solid 1px #0f88eb;
	height: 40px;
	line-height: 40px;
	border-radius: 5px;
	color: #0f88eb;
	font-family: "微软雅黑";
	margin-top: 50px;
	cursor: pointer;
	position: relative;
}

.download>.close {
	display: none;
}

.download .pic {
	display: none;
	position: absolute;
	background: #fff;
	bottom: 78px;
	width: 310px;
	left: -10px;
	z-index: 5;
	padding: 40px 0;
	border-radius: 8px;
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, .15);
}

.registered-box {
	width: 300px;
	display: none;
}

.text {
	font-size: 14px;
	margin-top: 20px;
	font-family: "微软雅黑";
	color: #666666;
}

.text>a {
	color: #0f88eb;
}

.verification-code {
	position: absolute;
	right: 22px;
	top: 14px;
	font-family: "微软雅黑";
	font-size: 18px;
	cursor: pointer;
}

#register:hover {
	opacity: 0.7;
}

#login:hover {
	opacity: 0.7;
}
</style>

</head>

<body>
	<div class="index-box" style="z-index: 9999; position: relative">
		<div class="index-header">
			<h1 class="logo"></h1>
			<h2 class="title"></h2>
		</div>
		<div class="index-body">
			<div class="nav-sliders">
				<a id="loginButton" class="login active">登录</a> <span class="on"></span>
			</div>
			<div class="change">
			<a
							href="<%=request.getContextPath()%>/bbsServlet?action=toindex"
							target="_blank"><span>&nbsp;&nbsp;</span><span></span></a>
							
				<!--登录开始-->
				<div class="login-box">
					<form id="loginForm"
						 action="${pageContext.request.contextPath}/LoginServlet"
						method="post">
						<div class="wrap">
							<div class="phone">
								<input id="username" name='userCode' value="" placeholder="用户名">
								<!-- <label class="error loginName">请输入登录名（email地址）</label> -->
							</div>
							<div class="password">
								<input type="password" id="password" name='userPassword'
									placeholder="密码"> <label class="error loginPass">密码</label>
							</div>
						</div>
						<!-- <input type="submit" class="button" value="登录" /> -->
						<button  type="submit" class="button" value="登录">登录
					</button>
						<div class="remember">
							<label><input id="rememberMe"
								name="_spring_security_remember_me" type="checkbox">记住我:</label>
							<a href = "repassword.jsp">忘记密码？</a>

						</div>
					</form>
					<div class="other">
						<span> <a href="index.jsp">游客登录</a></div>
					</span>
						<div class="other-login">
							<!-- <a href="javascript:volid(0);">QQ</a> <a
								href="javascript:volid(0);">微信</a> <a
								href="javascript:volid(0);">微博</a>
						 -->
						</div>
					<div class="other">
						<span style="color:"></span>
					</div>
				</div>
				<!--登录结束-->

			</div>
		</div>
	</div>
	<canvas id="canvas" class="stage" style="z-index:1000"></canvas>
	<!-- <script type="text/javascript" src="./js/a.js"> -->
	</script>
</body>

</html>