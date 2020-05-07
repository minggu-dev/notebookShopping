<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%response.setHeader("Cache-Control", "no-store"); %>    
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/cart_info.css">
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/cart.js"></script>
</head>

<style>
 
 #test_btn{ border-top-right-radius: 100px; border-bottom-right-radius: 100px; margin-left:30px;margin-top:5px;
  background-color: #5D5D5D;
 } 
 #btn_group button{ border: 1px solid skyblue; background-color: rgba(0,0,0,0); color: skyblue; padding: 5px; }
#aco{
	background-color: #EAEAEA ;
	font-size: 15px;
	
	.cart_info_col
	{
	   float: left;
	   font-size: 14px;
	   font-weight: 400;
	   color: #1b1b1b;
	}
	.cart_info_col_my
	{
	   width:50%;
	}
	
}
.home{
		height: 1000px;
		background-color: #FFFFFF;
	}
img{
width:50%;
height:50%;
}

   </style>



<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="super_container">

   
   <!-- Menu -->
   <br><br><br><br>
   <!-- Cart Info -->
   <div class="home">
   	<div class="col-md-10">
  			<div class="content-box-large">
  				<div class="panel-heading">
					<div class="panel-title">주문상세보기</div>
				</div>
  				<div class="panel-body">
  				<form action="서블릿">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>상품이미지</th>
								<th>회사</th>
								<th>갯수</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody>
						
						
							
						<c:set var="sum" value="0"/>
						<c:forEach items="${info.orderList}" var="order">
							<tr class="odd gradeX">
								<td><input type="text" value="${order.orderNo}" disabled></td>
								<td><img src="images/productimg/${order.product.imgName}" style="width: 180px; height: 180px; display:block"><span>${order.product.modelName }</span></td>
								<td><input type="text" value="${order.product.company }" disabled></td>
								<td><input type="text" value="${order.quantity}" disabled></td>
								<td class="center"><input type="text" value="${order.product.price*order.quantity}" disabled></td>
								<c:set var= "sum" value="${sum + order.product.price*order.quantity}"/>

							</tr>
						</c:forEach>	
						</tbody>
						<tr>
						<td>총가격 </td><td><c:out value="${sum}"/>원</td>
						</tr>
					</table>
					<input id="back" type="button" value="뒤로가기" style="float: right;">
					</form>
  				</div>
  			</div>



		  </div>
		</div>
    </div>
   

<jsp:include page="footer.jsp"/>
<script>
$("#back").click(function(){
	location = "note?command=purUser&userId=id2";
});
(function(){
	$('.home').height(${fn:length(info.orderList) * 220} + 300);
})();
</script>

</body>
</html>