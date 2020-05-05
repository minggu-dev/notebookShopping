<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<style>

</style>

<script>
	$(function(){
		if(<%=session.getAttribute("id") == null%>){
			$('#logout').hide();
			$('#myPage').hide();
		}else{
			$('#login').hide();
			$('#register').hide();
		}
	});
</script>
</head>
<body>
	<!-- Header -->
	<header class="header">
		<div class="header_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="header_content d-flex flex-row align-items-center justify-content-start">
							<div class="logo"><a href="#">노트북 쇼핑</a></div>
							<nav class="main_nav">
								<ul>
									<li>
										<a href="note">Home</a>
									</li>
									<li class="hassubs">
										<a href="#">Categories</a>
										<ul>
											<li><a href="note?command=proCompany&company=삼성전자">SAMSUNG</a></li>
											<li><a href="note?command=proCompany&company=LG">LG</a></li>
											<li><a href="note?command=proCompany&company=hp">HP</a></li>
											<li><a href="note?command=proCompany&company=레노버">LENOVA</a></li>
											<li><a href="note?command=proCompany&company=애플">APPLE</a></li>
											<li><a href="note?command=proCompany&company=한성">HANSUNG</a></li>
											<li><a href="note?command=proSortAll">All</a></li>
										</ul>
									</li>
									<li>
										<a href="note?command=qnaAll">Q&A</a>
									</li>
									<li id="login">
										<a href="login.jsp">Login</a>
									</li>
									<li id="register">
										<a href="note?command=questionAll">JoinUs</a>
									</li>
									
									<li id="logout">
										<a href="note?command=userLogout">Logout</a>
									</li>
									
									<li id="myPage">
										<a href="myPage.jsp">MyPage</a>
									</li>
								</ul>
							</nav>
							<div class="header_extra ml-auto">
								<div class="shopping_cart">
									<a href="note?command=cartMyCart">
										<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
												 viewBox="0 0 489 489" style="enable-background:new 0 0 489 489;" xml:space="preserve">
											<g>
												<path d="M440.1,422.7l-28-315.3c-0.6-7-6.5-12.3-13.4-12.3h-57.6C340.3,42.5,297.3,0,244.5,0s-95.8,42.5-96.6,95.1H90.3
													c-7,0-12.8,5.3-13.4,12.3l-28,315.3c0,0.4-0.1,0.8-0.1,1.2c0,35.9,32.9,65.1,73.4,65.1h244.6c40.5,0,73.4-29.2,73.4-65.1
													C440.2,423.5,440.2,423.1,440.1,422.7z M244.5,27c37.9,0,68.8,30.4,69.6,68.1H174.9C175.7,57.4,206.6,27,244.5,27z M366.8,462
													H122.2c-25.4,0-46-16.8-46.4-37.5l26.8-302.3h45.2v41c0,7.5,6,13.5,13.5,13.5s13.5-6,13.5-13.5v-41h139.3v41
													c0,7.5,6,13.5,13.5,13.5s13.5-6,13.5-13.5v-41h45.2l26.9,302.3C412.8,445.2,392.1,462,366.8,462z"/>
											</g>
										</svg>
										<div>Cart <span>(0)</span></div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>


</body>
</html>