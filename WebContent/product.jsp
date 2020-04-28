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
<link rel="stylesheet" type="text/css" href="styles/categories.css">
<link rel="stylesheet" type="text/css" href="styles/categories_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<title>dd</title>
<style>
.form-control{
	width : 90%;
}

.super_container{
	z-index: 2;
}

 .animated {
    -webkit-transition: height 0.2s;
    -moz-transition: height 0.2s;
    transition: height 0.2s;
}

.stars
{
    margin: 20px 0;
    font-size: 24px;
    color: #d17581;
}

fieldset.scheduler-border {
    border: 1px groove #ddd !important;
    padding: 0 1.4em 1.4em 1.4em !important;
    margin: 0 0 1.5em 0 !important;
    -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
}

legend.scheduler-border {
    font-size: 1.2em !important;
    font-weight: bold !important;
    text-align: left !important;
}
</style>

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
	$('.cart_button').click(function(){
		if(parseInt($('#stock').val()) < parseInt($('.quantity').val())){
			alert('재고를 확인해 주세요');
		}else{
			$('input[name=quantity]').val($('.quantity').val());
			$('form[name=cartform]').submit();
		}
		return false;
	});
	
	
	$('span.reviewuser').each(function(){
		if(!$(this).html() == '<%=session.getAttribute("id")%>'){
			$('a.reviewdelete').hide();
			$('a.reviewupdate').hide();
		}
	});
});
</script>
</head>
<body>

<div class="newsletter">
<!-- Header -->



<%@include file="header.jsp" %>



<!-- Home -->

	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(images/categories.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="home_title">notebook<span>.</span></div>
								<div class="home_text"><p>Designed for those who defy limits and change the world, the new MacBook Pro is by far the most powerful notebook we’ve ever made. With an immersive 16-inch Retina display, superfast processors, next-generation graphics, the largest battery capacity ever in a MacBook Pro, a new Magic Keyboard, and massive storage, it’s the ultimate pro notebook for the ultimate user.</p></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<br>
<br>
	<!-- Product Details -->
	<div class="product_details">
		<div class="container">
			<div class="row details_row">

				<!-- Product Image -->
				<div class="col-lg-6">
					<div class="details_image">
						<div class="details_image_large"><img src="images/productimg/${requestScope.product.imgName}" alt=""><div class="product_extra product_new"><a></a></div></div>
						<div class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
						</div>
					</div>
				</div>


<!-- Product Content -->
				<div class="col-lg-6">
					<div class="details_content">
						<br>
						<br>
						<div class="details_company"> 제조사   :  ${requestScope.product.company}</div>
						<div class="details_model_name"> 모델명   :  ${requestScope.product.modelName}</div>
						<div class="details_ram">   램     :  ${requestScope.product.ram}</div>
						<div class="details_cpu"> ＣＰＵ   :  ${requestScope.product.cpu}</div>
						<div class="details_size">화면크기  :  ${requestScope.product.noteSize}</div>
						<div class="details_weight">  무게    :  ${requestScope.product.noteWeight}</div>
						<div class="details_date"> 출시일   :  ${requestScope.product.launchDate}</div>
						<div class="details_stock">  재고    :  ${requestScope.product.stock}</div>

						<!-- Product Quantity -->
						<span>수량 </span>
						<input type="number" class="quantity" value="1" min="1" max="${requestScope.product.stock}" step="1"/>
						<div class="details_price">   가격     :  <fmt:formatNumber value="${requestScope.product.price}"/>원 </div>
						<div class="button cart_button"><a href="">Add to cart</a></div>
					</div>
				</div>
			</div>

			</div>
		</div>
	
<div class="container" >
		<div style="border: 1px solid silver;"></div><br>
		<h3> 제품 상세정보</h3>
		<div class="product_image"><img src="images/productimg/${requestScope.product.descriptionImgName}" alt=""></div>
		<br>
		<div class="product_image"><img src="images/info.png" alt=""></div>
</div>
	<br>
	<br>
	<br>
	
<div class="container" >
		<div style="border: 1px solid silver;"></div><br>
		<h3>배송 정보</h3>
		<div>
		평균 배송기간은 3~5일(주말,공휴일 제외) 소요되며 상품의 특성(주문제작/대형가전)이나
        주문량에 따라서 달라질 수 있습니다.  자세한 출고일은 매장에서 확인 가능합니다.

        주문 후 상품 준비 과정 중 매장에서 판매가 완료되어 상품의 발송이 늦어지거나 품절 될 수 도 있습니다.
        품절 시, 1~2일 이내 자동으로 취소 및 환불 됩니다. 
		</div>
</div>
	<br>
	<br>
		<div class="container">
			<div style="border: 1px solid silver;"></div>
			<br>
				<div class="button cart_button" style="display: inline-block;"><a href="review">후기</a></div>
				<div class="button cart_button" style="display: inline-block;"><a href="qna">Q&A</a></div>
			<br>
			<br>
			<br>
			<section>
				<c:choose>
					<c:when test="${empty requestScope.review}">
						<div style="text-align: center;">등록된 후기가 없습니다.</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.review}" var="review">
							<div style="text-align: left; border: 1px solid silver;">
								<div style="text-align: left">
									<span style="font-weight: bold;" class="reviewuser">${review.userId}</span> 
									<a class="reviewupdate" href="">수정</a> 
									<a class="reviewdelete" href="">삭제</a>
								</div>
								
								<div style="text-align: right;">${review.createDate}</div><br>
								${review.content}
								<br><br><br><br>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<br>
				<br>
				<br>
				<br>
				<fieldset class="scheduler-border">
					<br>
					<legend class="scheduler-border"><div style="text-align: center">후기 작성하기</div></legend>
					<div>
						<p>후기 작성하시면 다음 구매시에 무료로 배송해드려요</p>
						<form class="form-inline" action="note?command=reviewInsert" method="post" enctype="multipart/form-data">
							<div>
								평점:
								<input name="grade" value ="5" type="radio" checked>★★★★★ &nbsp;&nbsp;<input name="grade" value ="4" type="radio">★★★★&nbsp;&nbsp;
								<input name="grade" value ="3" type="radio">★★★&nbsp;&nbsp;<input name="grade" value ="2" type="radio">★★&nbsp;&nbsp;
								<input name="grade" value ="1" type="radio">★
							</div>
							<br>
							<div>
								<label>내용 </label>
								<textarea class="form-control" name = "content" rows="4" cols="80" maxlength="500" placeholder="후기를 작성해 주세요(500자 제한)"></textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-default">쓰기</button>
							</div>
								<input type="hidden" name="serialNum" value="${requestScope.product.serialNum}">
							<br> 
							<br>
						</form>
					</div>
				</fieldset>
			</section>
			<br>
			<div style="border: 1px solid silver;"></div>
			<br>
			<div style="border: 1px solid silver;" align="center">
				<h3>QnA 게시판</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>사진</th>
							<th>아이디</th>
							<th>내용</th>
							<th>평점</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6">게시판내용이 없습니다</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>



		<br><br><br><div style="cursor:pointer; text-align: center" onclick="window.scrollTo(0,0);">TOP</div>

	</div>
<!-- Footer -->
<%@include file="footer.jsp" %>


<form action = "note?command=cartInsert" name="cartform" method="post">
	<input type="hidden" name="quantity" value="">
	<input type="hidden" name="serialNum" value = "${requestScope.product.serialNum}">
</form>

</body>
</html>