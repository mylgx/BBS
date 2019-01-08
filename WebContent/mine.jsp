<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BBS-mine</title>

    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
<style>
.left_choose{width: 15%;float: left;}
.left_choose ul{list-style: none;}
.left_choose ul li{padding: 10px 10px;background:#7c919a; color: white;cursor: pointer;border-radius: 5px;}
.left_choose ul li:hover,.info2 .submit:hover,.info2 .reset:hover{background:#7c919a; }
.info1{text-align: center;display: inline;}
.info2{text-align: center;display: none;}
.info2 .submit{margin-left: 15%;}
.container-fluid.row .col{width: 100%; text-align: center;}
.setting { list-style: none;padding-left: 0;border: 1px solid #7c919a;border-radius: 5px;}
.setting li input{padding-left: 10px;}
.list-item{padding: 20px 10px;border-bottom: 1px solid #7c919a;}
.setting li:nth-child(4){border: none;}
.form-label{float: left;display: block;padding-left: 40px;width: 80px;font-weight: 400;text-align: left;box-sizing: content-box;color: #7c919a;}
.tm-contact-form {width: 70%;margin: 0 auto;text-align: left;}
.info2 .submit,.info2 .reset{background: #7c919a;border: none;color: white; }

</style>
</head>

    <body>
       
        <div class="tm-header">
            <div class="container-fluid">
                <div class="tm-header-inner">
                    <a href="#" class="navbar-brand tm-site-name">BBS</a>
                    
                    <!-- navbar -->
                    <nav class="navbar tm-main-nav">

                        <button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                            &#9776;
                        </button>
                        
                        <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item">
                                    <a href="<%=request.getContextPath()%>/bbsServlet?action=toindex" class="nav-link">首页</a>
                                </li>
                                <li class="nav-item">
                                    <a href="reply.jsp" class="nav-link">回帖</a>
                                </li>
                                <li class="nav-item">
                                    <a href="<%=request.getContextPath()%>/bbsServlet?action=toAddNews" class="nav-link">发帖</a>
                                </li>
                                <li class="nav-item active">
                                    <a href="mine.jsp" class="nav-link">我的</a>
                                </li>
                                 <%
									Object o = session.getAttribute("username");
									System.out.print("------------------------"+o);
									if (o == null){
								%>  
                                <li class="nav-item">
                                    <a href="login.jsp" class="nav-link">登录</a>
                                </li>
                                <li class="nav-item">
                                    <a href="register.jsp" class="nav-link">注册</a>
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

        <div class="tm-contact-img-container">
            
        </div>

        <section class="tm-section">
        <div class="left_choose">
        <ul>
        <li id="index1">查看个人资料</li><br/>
        <li id="index2">修改和设置</li>
        </ul>
        </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col">

                        <section class="info1">
                            <h3 class="tm-gold-text tm-form-title">个人资料</h3>
                            <p class="tm-form-description">Personal Information</p> 
                            <form action="" method="post" class="tm-contact-form">                                
                               <ul class="setting">
                               <li class="list-item">
                               <label class="form-label">用户名</label>                                                     
                               <span class="name"> ${user.userName }</span>  
                               </li>             
                               <li class="list-item">
                               <label class="form-label">性别</label>                               
                               <span class="gender">未设置</span>                
                               </li>
                               <li class="list-item">
                               <label class="form-label"> 电话</label>
                              
                               <span class="telephone">${user.phoneNumber}</span>
                              </li>
                               <li class="list-item">
                               <label class="form-label">邮箱</label>                     
                               <span class="email" >未设置</span>
                               </li>
                               </ul>
                               </form> 
                               </section>
                               <section class="info2"> 
                                <h3 class="tm-gold-text tm-form-title">个人资料修改</h3>
                            <p class="tm-form-description">Modify Personal Information</p> 
                                <form action="<%=request.getContextPath() %>/bbsServlet?action=modify" method="post" class="tm-contact-form">                                
                               <ul class="setting">
                               <li class="list-item">
                               <label class="form-label">用户名</label>                                                     
                               <input name="name" type="text"/>                        
                               <li class="list-item">
                               <label class="form-label">性别</label>                               
                               <input name="gender" type="radio"/>男&nbsp;
                               <input name="gender" type="radio"/>女            
                               </li>
                               <li class="list-item">
                               <label class="form-label">电话</label>
                              
                               <input name="telephone" type="text"/>
                              </li>
                              <li class="list-item">
                               <label class="form-label">邮箱</label>                     
                               <input name="email" type="text"/>
                               </li>
                               </ul>
                                <input class="submit" type="submit" name="submit"/>
                               <input class="reset" type="reset" name="reset"/>
                               </form>  
                            
                        </section>
                 </div>       
              </div>
            </div>
      
  <script>
  document.getElementById("index1").onclick=function(){
	  document.getElementsByClassName("info1")[0].style.display="inline";
	  document.getElementsByClassName("info2")[0].style.display="none";
  }
  document.getElementById("index2").onclick=function(){
	  document.getElementsByClassName("info2")[0].style.display="inline";
	  document.getElementsByClassName("info1")[0].style.display="none";
  }
  </script>

</body>
</html>