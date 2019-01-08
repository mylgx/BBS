<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!-- 首页-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BBS - home</title>

    <!-- load stylesheets -->
    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
<style>


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
                                <li class="nav-item active">
                                    <a href="index.jsp" class="nav-link">首页</a>
                                </li>
                             
                                <li class="nav-item">
                                
                                    <a href="<%=request.getContextPath()%>/bbsServlet?action=toAddNews" class="nav-link">发帖 </a>
                                </li>
                                <li class="nav-item">
                                    <a href="<%=request.getContextPath()%>/bbsServlet?action=tomine" class="nav-link">我的</a>
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

        <div class="tm-home-img-container">
            <img src="img/tm-home-img.jpg" alt="Image" class="hidden-lg-up img-fluid">
         </div>

        <section class="tm-section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center">
                        <h2 class="tm-gold-text tm-title">Introduction</h2>
                        <p class="tm-subtitle">Talk with others on web web. Show your ideas on our web!</p>
                    </div>
                </div>
                	<form name="搜索" method="post"
				action="<%=request.getContextPath()%>/bbsServlet?action=toSearchNews">
				<div>
					<input type="text" name="text" value="" class="textboxt" /> <input
						type="submit" name="submit" value="搜索" class="sub" />
				</div>
			</form>

			<br> <br> <br>

			<div>
				<h3>
					<span>搜索结果</span>
				</h3>
				<ul>
					<c:forEach items="${newspostlist}" var="newspostlist">
						<!--<a href="reply.jsp?title=${newspostlist.title}" ></a>  -->
						<tr>
							<td align="left">${newspostlist.title}</td>
						</tr>
					</c:forEach>

				</ul>
			</div>
                
                <div class="row">
                   <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/school.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                         
                             <a href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=校园天地" class="tm-btn text-uppercase">校园天地</a>
                   
                         </div>  

                    </div>
                    
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/news.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                         
                             <a href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=新闻时事" class="tm-btn text-uppercase">新闻时事</a>
                   
                         </div>  

                    </div>
                    
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/travel.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                         
                             <a href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=旅游休闲" class="tm-btn text-uppercase">旅游休闲</a>
                   
                         </div>  

                    </div>
                    
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/amuse.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                         
                             <a href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=娱乐八卦" class="tm-btn text-uppercase">娱乐八卦</a>
                   
                         </div>  

                    </div>
                   
                   <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/music.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                         
                             <a href="<%=request.getContextPath()%>/bbsServlet?action=toreply&subject=影视音乐" class="tm-btn text-uppercase">影视音乐</a>
                   
                         </div>  

                    </div>
                </div> <!-- row -->
                
                <div class="row tm-margin-t-big">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
                        <div class="tm-2-col-left">
                            
                            <h3 class="tm-gold-text tm-title"></h3>
                            <img src="img/tm-img-660x330-1.jpg" alt="Image" class="tm-margin-b-40 img-fluid">
                          
                        </div>
                    </div>
		
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">

                        <div class="tm-2-col-right">

                            <div class="tm-2-rows-md-swap">
                                <div class="tm-overflow-auto row tm-2-rows-md-down-2">
                                 
                                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 col-xl-6 tm-xs-m-t">
                                        <h3 class="tm-gold-text tm-title">
                                            Useful Links
                                        </h3>
                                        <nav>
                                            <ul class="nav">
									<li><a href="http://news.qq.com/a/20181216/005405.htm"
										class="tm-text-link">创意数据视频|改变中国 影响世界的40年</a></li>
									<li><a href="http://news.qq.com/a/20181216/005227.htm"
										class="tm-text-link">焦点访谈|40年伟大的变革 披荆斩棘成大道</a></li>
									<li><a href="http://news.qq.com/a/20181216/004463.htm"
										class="tm-text-link">改革开放，发展中国、造福世界</a></li>
									<li><a href="http://news.qq.com/a/20181216/004395.htm"
										class="tm-text-link">改革开放四十年：影视见证时代变迁</a></li>
									<li><a href="http://news.qq.com/a/20181216/004284.htm"
										class="tm-text-link">【我们的改革开放】两代人的“花”样年华</a></li>

								</ul>
                                        </nav>    
                                    </div> 
                                </div>                        
                                
                     
                            </div>
                        
                        </div>
                    </div> 
 
                </div>
        </section>
        
        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>  
        <script src="js/tether.min.js"></script> 
        <script src="js/bootstrap.min.js"></script>   
</body>
</html>