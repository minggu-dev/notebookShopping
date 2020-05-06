<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/cart_info.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/main.css" />

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
   </style>



<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="super_container">
<c:set var="orderList" value="${info}" />
   
   <!-- Menu -->


   <br><br><br><br>
   <!-- Cart Info -->
   
   <div class="col-md-10">

  			<div class="content-box-large">
  				<div class="panel-heading">
					<div class="panel-title">배송지 변경</div>
				</div>
  				<div class="panel-body">
  				<form method="post" action="note?command=purChangeAddr">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>주문상품</th>
								<th>구매일</th>
								<th>배송상태</th>
								<th>환불요청</th>
								<th>배송지(수정)</th>
								<th>총금액</th>
							</tr>
						</thead>
						<tbody>
						
						
							<tr class="odd gradeX">
							
								<td><input type="text" value="${orderList.userId}" disabled="disabled"></td>
								<td><input type="text" value="${orderList.purchaseDate}" disabled="disabled"></td>
								<td><input type="text" value="${orderList.deliveryState}" disabled="disabled"></td>
								<td><input type="text" value="${orderList.refundState}" disabled="disabled"></td>
								<td><input name="deliveryAddr" type="text" value="${orderList.addrDelivery}" ></td>
								<td><input type="text" value="${orderList.totalPrice}" disabled="disabled"></td>

							</tr>		
						</tbody>
					</table>
					<input type="submit" value="배송지변경" name="addrUpdate" style="float: right;">
								<input name="orderNo" type="hidden" value="${orderList.orderNo}">
				</form>
  				</div>
  			</div>



		  </div>
		</div>
    </div>
   

   
   </div>
<jsp:include page="footer.jsp"></jsp:include>


<script>
// $("input[name=addrUpdate]").click(function(){
// 	var orderNo = $("#orderNo").val();
// 	var deliveryAddr=("#deliveryAddr").val();
// 	location.href="note?command=purChangeAddr&orderNo="+orderNo+"&deliveryAddr="+deliveryAddr;
// });
</script>

</body>
</html>