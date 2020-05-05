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
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/cart_info.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
 <link rel="stylesheet" href="assets/css/main.css" />
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
<%@include file="myHeader.jsp" %>
<div class="super_container">

   
   <!-- Menu -->


   <br><br><br><br>
   <!-- Cart Info -->

<section id="one" class="wrapper style1" style="z-index:2;">
   
   <div class="cart_info">
   <h3 align="center">주문내역보기</h3>
      <div class="container">
         <div class="row">
            <div class="col">
               <!-- Column Titles -->
      
               <div class="cart_info_columns clearfix" style="width: 1300px;">
               
                  
                  <div class="cart_info_col cart_info_col_product" style="width:165px;">주문번호</div>
                  <div class="cart_info_col cart_info_col_my" style="width:130px;" > 유저아이디</div>
                  <div class="cart_info_col cart_info_col_quantity" style="width:160px;">구매일</div>
                  <div class="cart_info_col cart_info_col_total" style="width:155px;">배송상태</div>
                  <div class="cart_info_col cart_info_col_total"style="width:125px;">환불요청</div>
                  <div class="cart_info_col cart_info_col_total"style="width:125px;">배송지</div>
                  <div class="cart_info_col cart_info_col_total"style="width:110px;">총금액</div>
                  <div class="cart_info_col cart_info_col_total">주문취소(환불)</div>
         
               </div>
            </div>
         </div>
         
         
         <div class="row cart_items_row">
         <c:forEach var="orderInfo" items="${requestScope.list}">
            <div class="col">
               <!-- Cart Item -->
					              	

                  <div class="cart_info_col cart_info_col_product"><button type="button" name="orderDetail" >${orderInfo.orderNo}</button></div>
                  <div class="cart_info_col cart_info_col_quantity"><c:out value="${orderInfo.userId}"></c:out></div>
                  <div class="cart_info_col cart_info_col_quantity"><c:out value="${orderInfo.purchaseDate}"></c:out></div>
                  <div class="cart_info_col cart_info_col_total"><c:out value="${orderInfo.deliveryState}"></c:out></div>
                  <div class="cart_info_col cart_info_col_total"><c:out value="${orderInfo.refundState}"></c:out></div>
                  <div class="cart_info_col cart_info_col_total">
                  <a href="note?command=purDeliveryForm&orderNo=${orderInfo.orderNo}"><c:out value="${orderInfo.addrDelivery}"></c:out>
                  </a></div>
                  <div class="cart_info_col cart_info_col_total">${orderInfo.totalPrice}</div>
				 <c:choose>

					<c:when test="${orderInfo.deliveryState ne 1}">					
						<button id="test_btn" name="delete" hidden="" >취소하기</button>
					</c:when>	
					<c:when test="${orderInfo.refundState == 1}">	
						<button id="test_btn" name="delete" hidden="" >취소하기</button>
					</c:when>				
					<c:otherwise>					
						<button id="test_btn" name="delete" value="${orderInfo.orderNo}">취소하기</button>		
					</c:otherwise>				
				</c:choose>
                  </div>
 

              
            </div>
           </c:forEach>
         </div>
         
               
         </div>
      </div>   
       </section> 
   </div>
    
<%@include file="footer.jsp" %>

<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/cart.js"></script>

<script>
$("button[name=delete]").click(function(){
	
   alert("삭제되었습니다.");
   var orderNo=$(this).val();
   location="note?command=purRefundState&request=1&orderNo="+orderNo;
});

$("button[name=orderDetail]").click(function(){
   alert("상품디테일");
   var orderNo = $(this).text();
   
   location = "note?command=purDetail&orderNo="+orderNo;
});
</script>

</body>
</html>