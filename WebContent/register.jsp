<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title></title>

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
	width: 400px;
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
	font-size: 30px;
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
	font-size: 25px;
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

.registered-box {
	text-align: left;
	width: 600px;
	font-size: 25px;
	font-family: "微软雅黑";
	color: #707171;
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
	padding: 15px 2.5%;
	border-radius: 5px;
}

.password {
	border-top: solid 1px #d5d5d5;
}

.code {
	right: 115px;
}

.id {;
	
}

.registeredname {
	right: 5px;
}

.registeredpass {
	right: 5px;
}

.pass {
	right: 5px;
}

.passagain {
	right: 5px;
}

.name {
	border-top: solid 1px #d5d5d5;
}

.age {
	border-top: solid 1px #d5d5d5;
}

.sex {
	border-top: solid 1px #d5d5d5;
}

.button {
	width: 430px;
	height: 40px;
	background: #7c919a;
	text-align: center;
	line-height: 40px;
	border-radius: 5px;
	margin-top: 25px;
	color: #fff;
	font-size: 19px;
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
	font-size: 15px;
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

.size {
	width: 300px;
	font-size: 19px;
	font-family: "宋体";
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
				<a id="registered" class="registered active">注册</a> <span class="on"></span>
			</div>
			<div class="change">
				<!--注册-->
				<div class="registered-box">
					<form id="registerForm" method="post"
						action="${pageContext.request.contextPath}/RegisterServlet">
						<table style="font-size: 21px;">
							<tbody>
								<tr>
									<td><span style="color: red">*</span><span
										style="color: #707171; font-size: 19px">手机号：</span></td>
									<td><input
										style="border: 1px solid #d5d5d5; border-radius: 5px"
										align="right" type="id" class="size" name="phoneNumber"
										value="" id="id" placeholder="联系电话" required><br></td>
									</te>
								<tr>
									<td><span style="color: red">*</span><span
										style="color: #707171; font-size: 19px">用户名：</span></td>
									<td><input
										style="border: 1px solid #d5d5d5; border-radius: 5px"
										align="right" type="id" class="size" name="id" value=""
										id="id" placeholder="用户名" required><br></td>
									</te>
								<tr>
									<td><span style="color: red">*</span><span
										style="color: #707171; font-size: 19px">微信：</span></td>
									<td><input
										style="border: 1px solid #d5d5d5; border-radius: 5px"
										align="right" type="id" class="size" name="weixin" value=""
										id="weixin" placeholder="微信" required><br></td>
									</te>
								<tr>
									<td><span style="color: red">*</span><span
										style="color: #707171; font-size: 19px">密码：</span></td>
									<td><input
										style="border: 1px solid #d5d5d5; border-radius: 5px"
										align="right" type="password" class="size" id="password"
										name="password" value="" placeholder="密码" required><br></td>
								</tr>

								<tr>
									<td><span style="color: red">*</span><span
										style="color: #707171; font-size: 19px">确认密码：</span></td>
									<td><input
										style="border: 1px solid #d5d5d5; border-radius: 5px"
										align="right" type="password" class="size" id="pssworAgain"
										name="repassword" value="" placeholder="再次输入密码" required><br>
								</tr>


							</tbody>
						</table>

						<input type="submit" class="button" value="注册" />

					</form>
				</div>
			</div>

			<!--注册结束-->
		</div>
	</div>
	<canvas id="canvas" class="stage" style="z-index:1000"></canvas>
	<script type="text/javascript" src="./jsp/a.js">
			</script>
	<script>
			
			var jcPublic = {
				register:function(){//注册
					var currentThis = this;//当前对象
					$("#register").on("click",function(){
						var $this = $(this);
						var name = $("#id").val();//姓名
						var registerName = document.getElementById("id");
						var passwor = $("#passwor").val();
						var passworAgain = $("#pssworAgain").val();
						var name = $("#name").val();
						var age = $("#age").val();
						var sex = $("#sex").val();
						if(name.length==0 && passwor.length==0){//同时为空
							$this.prev(".wrap").find("label").addClass("move");
							return false;
						}else if(name == "" || name == "undefined" || name == "null"){
							$this.prev(".wrap").find(".name").html("请输入用户名").addClass("move");
							return false;
						}else if(passwor == "" || passwor == "undefined" || passwor == null ){
							$this.prev(".wrap").find(".pass").addClass("move");
							return false;
						}else if(passworAgain == "" || passworAgain == "undefined" || passworAgain == null ){
							$this.prev(".wrap").find(".passagain").addClass("move");
							return false;
						}else if(passworAgain == "" || passworAgain == "undefined" || passworAgain == null ){
							$this.prev(".wrap").find(".passagain").addClass("move");
							return false;
						}else if(passworAgain != passwor){
							$this.prev(".wrap").find(".passagain").html("请确保输入的密码一致").addClass("move");
							return false;
						}else{
							 //发送添加用户申请
							$.ajax({
								type : "POST",
								url : "${pageContext.request.contextPath}/RegisterServlet",
								data : {"id":id,"password":passwor,"name":name,age":age,"sex":sex},
								dataType: "json", 
								error: function(XMLHttpRequest, textStatus, errorThrown){
									alert("Error:"+XMLHttpRequest.status+",,,"+textStatus);
								},
								success : function(msg) {
									alert(msg.messageString);
									if(msg.messageString == "注册成功"){
										$("#loginButton").click();
										$("#registerForm")[0].reset();
										
									}						
								}
							}); 
						 $("#registerForm").ajaxSubmit(function(message){
								alert(message.messageString);
							}); 
						}
					});
				},
				
			};
		</script>
</body>
</html>