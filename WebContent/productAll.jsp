<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="plugins/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/categories.css">
<link rel="stylesheet" type="text/css" href="styles/categories_responsive.css">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

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
.product_pagination{
	text-align: center;
}

#custom-search-form {
        margin:0;
        margin-top: 5px;
        padding: 0;
    }
 
    #custom-search-form .search-query {
        padding-right: 3px;
        padding-right: 4px \9;
        padding-left: 3px;
        padding-left: 4px \9;
        /* IE7-8 doesn't have border-radius, so don't indent the padding */
 
        margin-bottom: 0;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
    }
 
    #custom-search-form button {
        border: 0;
        background: none;
        /** belows styles are working good */
        padding: 2px 5px;
        margin-top: 2px;
        position: relative;
        left: -28px;
        /* IE7-8 doesn't have border-radius, so don't indent the padding */
        margin-bottom: 0;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        border-radius: 3px;
    }
 
    .search-query:focus + button {
        z-index: 3;   
    }

</style>

<script>
$(function(){
	$('.page_cnt').each(function(){
		if($(this).children().html() == <%=request.getAttribute("page")%>){
			$(this).addClass('active');
		}
	});
	
	$('.page_cnt>a').click(function(){
		var hrefstr = $(this).attr("href");
		<% 
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String name = en.nextElement();
			if(name.equals("page")){
				continue;
			}
			%>hrefstr += "&" + "<%=name%>=";
			hrefstr += "<%=request.getParameter(name)%>";
		<%
		}
		%>
		$(this).attr("href",hrefstr);
	});
});

</script>

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<!-- Home -->
	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(images/test.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="home_title">세상의 모든 노트북이 여기에<span>.</span></div>
								<div class="home_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros. Sed viverra velit venenatis fermentum luctus.</p></div>
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
					<!-- Product Sorting -->
					<div class="sorting_bar d-flex flex-md-row flex-column align-items-md-center justify-content-md-start">
						<div class="results">Showing <span>${fn:length(requestScope.list)}</span> results</div>
						<div class="sorting_container ml-md-auto">
							<div class="sorting">
								<ul class="item_sorting">
									<li>
										<span class="sorting_text">Sort by</span>
										<i class="fa fa-chevron-down" aria-hidden="true"></i>
										<ul>
											<li class="product_sorting_btn"><span>기본</span></li>
											<li class="product_sorting_btn"><span>가격 높은순</span></li>
											<li class="product_sorting_btn"><span>가격 낮은순</span></li>
											<li class="product_sorting_btn"><span>출시일 순</span></li>
											<li class="product_sorting_btn"><span>평점 순</span></li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="product_grid">
						<!-- Product -->
						<c:choose>
							<c:when test="${empty requestScope.list}">
								상품 목록이 없습니다.
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.list}" var="pro">
									<div class="product" id="${pro.serialNum}">
										<div class="product_image">
											<a href="note?command=proDetail&serialNum=${pro.serialNum}">
												<img width=250px height=250px
												src="images/productimg/${pro.imgName}" alt="">
											</a>
										</div>
										<div class="product_content">
											<div class="product_title">
												<a href="note?command=proDetail&serialNum=${pro.serialNum}">${pro.modelName}</a>
											</div>
											<div class="product_price">
												<fmt:formatNumber value="${pro.price}" />원
											</div>
										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="product_pagination">
						<div class="container">
							<div class="row">
						        <div class="span12">
						            <form id="custom-search-form" class="form-search form-horizontal pull-right">
						                <div class="input-append span12" style="text-align: center;">
						                    <input type="text" class="search-query" placeholder="Search">
						                </div>
						                    <button type="submit" class="btn"><i class="icon-search"></i></button>
						            </form>
						        </div>
							</div>
						</div>
						<ul>
							<li class="page_cnt"><a href="note?page=${param.page - 1}" style="font-size: 15px;">이전</a>＊＊</li>
							<c:forEach begin="1" end="${requestScope.pageObj.totalPage}" varStatus="state">
								<li class="page_cnt"><a href="note?page=${state.count}" style="font-size: 20px;">${state.count}</a></li>
							</c:forEach>
							<li class="page_cnt">＊＊<a href="note?page=${param.page + 1}" style="font-size: 15px;">다음</a></li>
						</ul>
					</div>
					<br>
					<br>
					<br>
					<div style="cursor: pointer; text-align: center"
						onclick="window.scrollTo(0,0);">TOP

					</div>
				<br>
					<br>
					<br>
					<br>
			</div>	
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>