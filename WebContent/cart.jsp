<%@page import="notebook.domain.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="plugins/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">


<!-- Css Styles -->
    <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/ie7.css" type="text/css">
    <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
    
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

 <!-- Js Plugins -->
    <script src="js/js/jquery-ui.min.js"></script>
    <script src="js/js/jquery.countdown.min.js"></script>
    <script src="js/js/jquery.nice-select.min.js"></script>
    <script src="js/js/jquery.zoom.min.js"></script>
    <script src="js/js/jquery.dd.min.js"></script>
    <script src="js/js/jquery.slicknav.js"></script>
    <script src="js/js/owl.carousel.min.js"></script>
    <script src="js/js/main.js"></script>
	<script src="js/js/ie7.js"></script>


</head>

 <style>
 body {
  background: none;
  font-size: 62.5%;
}

.container {
  padding: 2em;
}

/* GENERAL BUTTON STYLING */
button,
button::after {
  -webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
  -o-transition: all 0.3s;
	transition: all 0.3s;
}

button {
  background: none;
  border: 3px solid #e9e9e9;
  border-radius: 5px;
  color: orange;
  
  font-size: 5;
  font-weight: bold;
  margin: 1em auto;
  padding: 1em 1em;
  position: relative;
  text-transform: uppercase;
}

button::before,
button::after {
  background: orange;
  content: '';
  position: absolute;
  z-index: -1;
}

button:hover {
  color: white;
}

/* BUTTON 1 */
.btn-delete::after {
  height: 0;
  left: 0;
  top: 0;
  width: 100%;
}

.btn-delete:hover:after {
  height: 100%;
}
</style> 
<body>
<!-- <div class="super_container"> -->
<jsp:include page="header.jsp"/>


	<h1>dddddddddddd</h1>
	<!-- Cart Info -->
	<!-- Shopping Cart Section Begin -->
	<div class="cart_info">
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                    <!-- 카트 리스트 뿌리기  -->
                        <table>
                            <thead>	
                                <tr>
                                    <th>Image</th>
                                    <th class="p-name">Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                           <tbody name="cart_info"> 
                           
                           <c:choose>
                           <c:when test="${empty requestScope.list}">
                           <tr>
       						 <td colspan="5">
           					 <p align="center"><b><span style="font-size:20pt;">등록된 상품이 없습니다.</span></b></p>
        					</td>
   							 </tr>
                           </c:when>
                           <c:otherwise>
                             <c:forEach items="${requestScope.list }" var="result">
                                <tr name="cart">								<%-- ${l.product.imgName } --%>
                                    <td class="cart-pic first-row"><img src="images/productimg/${result.product.imgName }" alt="모른다."></td>
                                    <td class="cart-title first-row">
                                        <h5>${result.product.modelName }<input type="hidden" name="serialNum" value="${result.product.serialNum }"></h5>
                                    </td>
                                    <td class="p-price first-row" name="sell_price">${result.product.price}</td>
                                    
                                    <td class="qua-col first-row">
                                        <div class="quantity">  <div class="pro-qty" name="count">
                                                 <input type="text" value="${result.quantity }" name="amount">
                                            </div>
                                        </div> 
                                    </td>
                                    <td class="total-price first-row"><div name="total"><fmt:formatNumber>${result.quantity* result.product.price}</fmt:formatNumber>원	</div></td>
                                   
                                   <td >
                                		<div class="container">							<!-- 삭제할 변수명${l.serialNum} -->
  										<button class="btn-delete" name="btn_delete"><a href="note?command=cartDelete&userId=${result.userId }&serialNum=${result.product.serialNum}">X</button>
  										</div>
                                		 
                                   </td> 
                                </tr>
                             </c:forEach>
                             </c:otherwise>
                             </c:choose>
                            </tbody>
                            
                        </table>
                        
                    </div>
                    <div class="row row_cart_buttons">
				<div class="col">
					<div class="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
						<div class="button continue_shopping_button"><a href="note">쇼핑 계속하기</a></div>
						<div class="cart_buttons_right ml-lg-auto">
																		
							<div class="button clear_cart_button" id="clear_cart"><a href="note?command=cartEmpty&userId=${l.userId }">장바구니 비우기</a></div>
							<div class="button update_cart_button" id="update_cart"><%-- <a href="note?command=cartUpdate&userId=${l.userId }&serialNum=${l.product.serialNum}&count=${l.count}"> --%><a>장바구니 갱신</a><!-- </a> --></div>
						</div>
					</div>
				</div>
			</div>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Shopping Cart Section End -->

  
    <!-- Pner Logo Section End -->
    
    
			<div class="row row_extra">
				<div class="offset-lg-2 col-lg-4">
				
					<!-- Delivery -->
					<div class="delivery">
				
					
						<div class="section_title">배송지 선택</div>
						
						<div class="section_subtitle">Select the one you want</div>
						<form>
						
						
						<div class="delivery_options">
							<label class="delivery_option clearfix">기본배송지
							
								<input type="radio" name="addr" id="addr" value="">
							
								
								<span class="checkmark"></span>
							</label>
							
								<div>
									 <ul>
									 <li>
									 <p class="heading"> <input type="radio" name="addr">신규배송지</p>
									  <div class="new_addr" name="new_addr" style="font-size: 20px">				  
								
													<!-- 주소지 -->
													
													<input type="text" name="newAddr" size="30" placeholder="받을 주소를 입력해주세요" focus>
											
													
										
									 </div>
									 </li>
									 </ul>
							</div>
						</div>
						</form>
					</div>
					
					

					
				</div>

			<div class="col-lg-4 offset-lg-0">
					<div class="cart_total">
						<div class="section_title">Cart total</div>
						<div class="section_subtitle">Final info</div>
						<div class="cart_total_container">
							<ul>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">Subtotal</div>
									<div class="cart_total_value ml-auto" name="sub_total"></div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">수량</div>
									<div class="cart_total_value ml-auto" name="quantity"></div>
								</li>
								<li class="d-flex flex-row align-items-center justify-content-start">
									<div class="cart_total_title">Total</div><input type="hidden" name="hidden_total">
									<div class="cart_total_value ml-auto" name="all_total"></div>
								</li>
							</ul>
						</div>
						<div class="button checkout_button" name="purchase"><a href="">구매</a></div>
					</div>
				</div>			
			</div>
		</div>

<script language='javascript'>


//개별 상품삭제하기 버튼
/* function Delete(delProduct) {
  //alert('테스트');
	
     location.href = "Delete?productName=" + 상품이름;   //get방식으로 삭제할아이디를 넘김 */

 $(document).ready(function() {
  $(".content").hide(); //content 클래스를 가진 div를 표시/숨김(토글)
  $('input[name=newAddr]').hide();
 
	
  var amount;

  var total;
  var sub_total;
 
  var amt = Number();
  var qt = Number(0);
  var money = Number();
  var sum = Number(0);
  
  $('tr[name=cart]').each(function(i, element) {
		amt = $('input[name=amount]').eq(i).val(); //수량
		money = $('td[name=sell_price]').eq(i).text();
		qt += parseInt(amt);
		sum += amt * money;
	});
	//$('td[name=sell_price]').text(money.toLocaleString()+'원');
  $('div[name=quantity]').text(qt);//수량
  $('div[name=sub_total]').text(sum.toLocaleString()+'원');
	$('div[name=all_total]').text(sum.toLocaleString()+'원');
	
	$('input[name=hidden_total]').val(sum);
  	
	$('div[name=count]').on('click', function() {
		var qty = Number(0);
		var all_total = Number();
		  var sell_price = Number();
		$('tr[name=cart]').each(function(i, element) {
			amount = $('input[name=amount]').eq(i).val(); //수량
			sell_price = $('td[name=sell_price]').eq(i).text();
			//sell_price = $('fmt:formatNumber[type=number]').eq(i).val();
			//alert(sell_price);
			total = amount * sell_price;
			all_total += amount * sell_price;
			qty += parseInt(amount);
			$('td>div[name=total]').eq(i).text(total.toLocaleString()+'원');  
		});
		$('div[name=sub_total]').text(all_total.toLocaleString()+'원');
		$('div[name=quantity]').text(qty);
		$('div[name=all_total]').text(all_total.toLocaleString()+'원');
		$('input[name=hidden_total]').val(all_total);
	});
	var all_total;

	
	/* $('#update_cart').on('click', function(){
		var quantity = Number(0);
		$('tr[name=cart]').each(function(i, element) {
			var update_amount = $('input[name=amount]').eq(i).val(); //수량
			total += amount * sell_price;
			quantity += parseInt(update_amount);
		});
		$('div[name=sub_total]').text(total.toLocaleString()+'원');
		$('div[name=quantity]').text(quantity);
		$('div[name=all_total]').text(total.toLocaleString()+'원');
		
	}); */
	
	
	/* var serialNum = $('input[name=serialNum]').val();
	var count = $('amount')
	alert(list.userId); */
	 $('#update_cart').click(function() {
		 $('tr[name=cart]').each(function(i, element) {
			var serialNum = $('input[name=serialNum]').eq(i).val();
			var count = $('input[name=amount]').eq(i).val();
			
			$.ajax({
				type: "POST",
				url:"note",
				data: "command=cartUpdate&serialNum=" + serialNum +"&count=" + count,
				dataType:"json",
				success: function(jsonObj) {
					if(jsonObj.status == 1){
						alert("갱신 되었습니다.");
						}
					
				}
				
			
			});
			
		 });
	
		
	}); 
	
	//기본 배송지
	 $('#addr').on('click', function() {
		//var id = $('input[name=userId]').val();
		var an = $('#addr').val();
		alert(an);
		//alert(id);
		/* $.ajax({
			type: "POST",
			url:"ajax",
			data:"id="+ id,
			success: function(arr){
				$('#addr').val(arr);
			}
		}) */
	}); 
	
	
	
	//구매하기
	$('div[name=purchase]').on('click', function() {
		//alert('dd');
		var addrDelivery;
		var totalPrice = $('input[name=hidden_total]').val();
		
	    addrDelivery = $('input[name=newAddr]').val();//새로운 주소 
		
		$.ajax({
			type: "POST",
			url:"note",
			data: "command=purInsert&totalPrice=" + totalPrice +"&addrDelivery=" + addrDelivery,
			success: function() {
				location.href = "orderInfo.jsp";
			}
		});
	});
	
  $(".heading").click(function()
  {
	  //$(this).next(".content").slideToggle(100);
	  $('input[name=newAddr]').slideToggle(100);
  });
});

</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>


</html>