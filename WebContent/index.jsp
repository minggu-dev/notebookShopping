<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<script>
$(function(){
	
});

</script>
</head>
<body>



<%@include file="header.jsp" %>

<!-- Home -->

	<div class="home">
		<div class="home_slider_container">
			
			<!-- Home Slider -->
			<div class="owl-carousel owl-theme home_slider">
				
				
				<!-- Slider Item -->
				<div class="owl-item home_slider_item">
					<div class="home_slider_background" style="background-image:url(images/엘지메인광고.gif)"></div>
					<div class="home_slider_content_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
										<br><br><br><br>
										<div class="home_slider_title" style="font-size: 40px">[${requestScope.map['new'][0].company}] ${requestScope.map['new'][0].modelName}</div>
										<div class="button button_light home_button"><a href="note?command=proDetail&serialNum=${requestScope.map['new'][0].serialNum}">Shop Now</a></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Slider Item -->
				
				
				<div class="owl-item home_slider_item">
					<div class="home_slider_background" style="background-image:url(images/productimg/삼성광고12.jpg)"></div>
					<div class="home_slider_content_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
										<br><br><br><br>
										<div class="home_slider_title" style="font-size: 40px">[${requestScope.map['new'][1].company}] ${requestScope.map['new'][1].modelName}</div>
										<div class="button button_light home_button"><a href="note?command=proDetail&serialNum=${requestScope.map['new'][1].serialNum}">Shop Now</a></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Slider Item -->
				<div class="owl-item home_slider_item">
					<div class="home_slider_background" style="background-image:url(images/삼성메인광고.gif)"></div>
					<div class="home_slider_content_container">
						<div class="container">
							<div class="row">
								<div class="col">
									<div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
										<br><br><br><br>
										<div class="home_slider_title" style="font-size: 40px">[${requestScope.map['new'][2].company}] ${requestScope.map['new'][2].modelName}</div>
										<div class="button button_light home_button"><a href="note?command=proDetail&serialNum=${requestScope.map['new'][2].serialNum}">Shop Now</a></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Home Slider Dots -->
			
			<div class="home_slider_dots_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_slider_dots">
								<ul id="home_slider_custom_dots" class="home_slider_custom_dots">
									<li class="home_slider_custom_dot active">01.</li>
									<li class="home_slider_custom_dot">02.</li>
									<li class="home_slider_custom_dot">03.</li>
								</ul>
							</div>
						</div>
					</div>
				</div>	
			</div>

		</div>
	</div>

	<!-- Products -->
	<div class="products">
	
		<div class="container">
			<div class="row">
				<div class="col">
					
					<div class="product_grid">

						<!-- Product -->
						<c:forEach items="${requestScope.map['best']}" var="pro">
							<div class="product">
								<div class="product_image"><img width=250px height=250px src="images/productimg/${pro.imgName}" alt="" ></div>
							<div class="product_extra product_sale"><a style="color: white;">best</a></div>
								<div class="product_content">
									<div class="product_title"><a href="note?command=proDetail&serialNum=${pro.serialNum}">${pro.modelName}</a></div>
									<div class="product_price"><fmt:formatNumber value="${pro.price}"/>원</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					<div class="product_grid">

						<!-- Product -->
						<c:forEach items="${requestScope.map['random']}" var="pro">
							<div class="product">
								<div class="product_image"><img width=250px height=250px src="images/productimg/${pro.imgName}" alt=""></div>
								<div class="product_content">
									<div class="product_title"><a href="note?command=proDetail&serialNum=${pro.serialNum}">${pro.modelName}</a></div>
									<div class="product_price"><fmt:formatNumber value="${pro.price}"/>원</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="footer.jsp" %>

	

</body>
</html>