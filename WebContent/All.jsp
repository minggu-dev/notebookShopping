<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
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
<!-- 브랜드 전체보기 -->
<title>All</title>

<style>
</style>

<script>

</script>

</head>

<body>
	<%@include file="header.jsp"%>
	<!-- Product Content -->



	<div class="col-lg-6">
		<div class="details_content">
			<div class="details_name"></div>
			<div class="details_discount"></div>
			<div class="details_price"></div>

			<!-- In Stock -->
			<div class="in_stock_container">
				<div class="availability">Availability:</div>
				<span>In Stock</span>
			</div>
			<div class="details_text">
				<br>
				<br>
				<br> <span>세상의 모든 노트북이 여기에</span>
			</div>
		</div>
	</div>

	<!-- Products -->

	<div class="products">
		<div class="container">
			<div class="high">
				<div class="col text-center">
					<div class="products_title">All Products</div>
				</div>
			</div>
			<div class="row">
				<div class="col">

					<div class="product_grid">

						<!--All PRODUCT -->


						<!-- APPLE 노트북-->

						<!-- Product -->
						<div class="product">
							<div class="product_image">
								<img src="images/애플31.jpg" alt="">
							</div>
							<div class="product_extra product_sale">
								<a href="categories.html">New</a>
							</div>
							<div class="product_content">
								<div class="product_title">
									<a href="productSpecify.html">APPLE MVVK2KH/A</a>
								</div>
								<div class="product_price">3,244,000원</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="footer.jsp"%>
</body>
</html>