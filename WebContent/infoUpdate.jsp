<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.setHeader("Cache-Control", "no-store"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link rel="stylesheet" href="assets/css/main.css" />

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/custom.js"></script>

<style>

</style>

<script>

</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="home">
			<section id="one" class="wrapper style1">
				<div class="inner">
					<article class="feature left">
						<span class="image"><img src="images/pic01.jpg" alt="" /></span>
						<div class="content">
							
							<h2>내 정보(수정)</h2>
							<form method="post" action="note?command=userUpdate">							
							<c:set var="myinfo" value="${user}" />
							<table>
								<tr><td>아이디</td><td><input type="text" disabled="disabled" value="${myinfo.userId }"></td></tr>
								<tr><td>비밀번호(수정 가능)</td><td><input name="pwd" type="password" value="${myinfo.pwd }"></td></tr>
								<tr><td>이름</td><td><input type="text" disabled="disabled" value="${myinfo.name }"></td></tr>
								<tr><td>주소(수정 가능)</td><td><input name="addr" type="text"  value="${myinfo.addr }"></td></tr>
								<tr><td>전화번호(수정 가능)</td><td><input name="phone" type="text"  value="${myinfo.phone }"></td></tr>
								<tr><td>질문</td><td><input type="text" disabled="disabled" value="${myinfo.question.queNo }"></td></tr>
								<tr><td>답변</td><td><input type="text" disabled="disabled" value="${myinfo.answer }"></td></tr>
								<tr><td>회원상태</td><td>활성화</td></tr>
								<tr><td><button name="update">수정완료</button></td>
								<td><button type="button" name="back">처음으로</button></td></tr>
							</table>
						   </form>
						   
					
						</div>
					</article>
					
				</div>
			</section>
			</div>
<jsp:include page="footer.jsp"></jsp:include>
 <script>
 	
 	
 	$("button[name=back]").click(function(){
 		location = "myPage.jsp";
 	});
 	
 </script>

</body>
</html>