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
               
                  
                  <div class="cart_info_col cart_info_col_product" style="width:155px;">주문번호</div>
                  <div class="cart_info_col cart_info_col_my" style="width:120px;" > 주문상품</div>
                  <div class="cart_info_col cart_info_col_quantity" style="width:150px;">구매일</div>
                  <div class="cart_info_col cart_info_col_total" style="width:145px;">배송상태</div>
                  <div class="cart_info_col cart_info_col_total"style="width:115px;">환불요청</div>
                  <div class="cart_info_col cart_info_col_total"style="width:115px;">배송지</div>
                  <div class="cart_info_col cart_info_col_total"style="width:120px;">총금액</div>
                  <div class="cart_info_col cart_info_col_total">주문취소</div>
         
               </div>
            </div>
         </div>
         <div class="row cart_items_row">
            <div class="col">
               <!-- Cart Item -->
                  <div class="cart_info_col cart_info_col_product">1</div>
                  <div class="cart_info_col cart_info_col_my" >
                    <button name="orderDetail" >주문상품1</button>
                  </div>
                  <div class="cart_info_col cart_info_col_quantity" >2020.04.26</div>
                  <div class="cart_info_col cart_info_col_total">배송중</div>
                  <div class="cart_info_col cart_info_col_total">미환물</div>
                  <div class="cart_info_col cart_info_col_total">판교</div>
                  <div class="cart_info_col cart_info_col_total">60000</div>
                  <div class="cart_info_col cart_info_col_quantity">
                  <button id="test_btn" name="delete">삭제하기</button></div>
                  
      
            </div>
         </div>
         
         <div class="row cart_items_row">
            <div class="col">
               <!-- Cart Item -->
                  <div class="cart_info_col cart_info_col_product">1</div>
                  <div class="cart_info_col cart_info_col_my">
                    <button name="orderDetail" >주문상품1</button>
                  </div>
                  <div class="cart_info_col cart_info_col_quantity">2020.04.26</div>
                  <div class="cart_info_col cart_info_col_total">배송중</div>
                  <div class="cart_info_col cart_info_col_total">미환물</div>
                  <div class="cart_info_col cart_info_col_total">판교</div>
                  <div class="cart_info_col cart_info_col_total">60000</div>
                  <div class="cart_info_col cart_info_col_quantity">
                  <button id="test_btn" name="delete">삭제하기</button></div>
                  
      
            </div>
         </div>
               
         </div>
      </div>   
      </section>   
   </div>
<%@include file="footer.jsp" %>
<script src="js/jquery-3.2.1.min.js"></script>
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
});

$("button[name=orderDetail]").click(function(){
   alert("상품디테일");
   location = "orderInfoDetail.jsp";
});
</script>

</body>
</html>