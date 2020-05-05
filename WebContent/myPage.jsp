<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>

</style>

<script>

</script>
</head>
<body>
<%@include file="myHeader.jsp" %>

<!-- One -->
			<section id="one" class="wrapper style1" style="z-index:2;">
				<div class="inner">
					<article class="feature left">
						<span class="image"><img src="images/orderInfo.gif" alt="" /></span>
						<div class="content">
							<h2>주문내역</h2>
							<h3>
							구매 내역을 확인하세요
							</h3>
							<ul class="actions">
								<li>
									<a href="note?command=purUser&userId=${id}" >구매내역보기</a>
								</li>
							</ul>
						</div>
					</article>
					<article class="feature right">
						<span class="image"><img src="images/personInfo.png" alt="" /></span>
						<div class="content">
							<h2>내정보보기</h2>
						
							<p><h3>
							${id}님의 회원정보 확인하기
							</h3></p>
						
							<ul class="actions">
								<li>
									<a href="note?command=userDetail&userId=${id}" >내정보 확인하기</a>
								</li>
							</ul>
						</div>
					</article>
				</div>
			</section>



<%@include file="footer.jsp" %>


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

</body>
</html>