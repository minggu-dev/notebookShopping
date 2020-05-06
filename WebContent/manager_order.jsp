<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <title>관리자 페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery UI -->
    <link href="https://code.jquery.com/ui/1.10.3/themes/redmond/jquery-ui.css" rel="stylesheet" media="screen">

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="css/styles.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    
    <script src=js/jquery-3.2.1.min.js></script>
  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="managerIndex.html">Bootstrap Admin Theme</a></h1>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>

    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <!-- Main menu -->
                    <li><a href="index.jsp"><i class="glyphicon glyphicon-home"></i> 홈으로</a></li>
                    <li class="current"><a href="note?command=proAll"><i class="glyphicon glyphicon-list"></i> 상품정보</a></li>
                    <li class="current"><a href="note?command=userAll"><i class="glyphicon glyphicon-list"></i> 회원정보</a></li>
                    <li class="current"><a href="note?command=qnaAll"><i class="glyphicon glyphicon-list"></i> Q&A</a></li>
                    <li class="current"><a href="note?command=purAll"><i class="glyphicon glyphicon-list"></i> 주문정보</a></li>
                         
                </ul>
             </div>
		  </div>
		  
		  
		  <!-- 테이블시작 -->
		  <div class="col-md-10">

  			<div class="content-box-large">
  				<div class="panel-heading">
					<div class="panel-title">주문 전체정보</div>
				</div>
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>아이디</th>
								<th>구매날짜</th>
								<th>배송상태</th>
								<th>환불상태</th>
								<th>주소</th>
								<th>총금액</th>
								<th>배송처리</th>
								<th>환불처리</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="order" items="${list}" varStatus="status">
							<tr class="odd gradeX">
								<td><c:out value="${order.orderNo}" /></td>
								<td><c:out value="${order.userId}"  /></td>
								<td><c:out value="${order.purchaseDate}" /></td>
								<c:choose>
									<c:when test="${order.deliveryState==1}">
										<td><select name="delivery" id="delivery">
										<option></option>
										<option value="1" selected="selected">배송전</option>
										<option value="2">배송중</option>
										<option value="3">배송완료</option>
										</select></td>
									</c:when>
									<c:when test="${order.deliveryState==2}">
										<td><select name="delivery">
										<option></option>
										<option value="1" >배송전</option>
										<option value="2" selected="selected">배송중</option>
										<option value="3">배송완료</option>
										</select></td>
									</c:when>
									<c:otherwise>
										<td><select name="delivery">
										<option></option>
										<option value="1" >배송전</option>
										<option value="2" >배송중</option>
										<option value="3" selected="selected">배송완료</option>
										</select></td>
									</c:otherwise>
								</c:choose>
								
								<td>
									<input name="refund_state" type="text" style="border: none; background-color: #FFFFFF" disabled value="${order.refundState==0 ? "" : '환불요청'}">
								</td>

								<td><c:out value="${order.addrDelivery}" /></td>
								<td class="center"><c:out value="${order.totalPrice}"  /></td>
								<td><button name="delivery" value="${order.orderNo}" >배송수정</button></td>
								<td><button name=refund value="${order.orderNo}">환불수정</button></td>			
							</tr>
						</c:forEach>
						</tbody>
					</table>
  				</div>
  			</div>
		  </div>
		</div>
    </div>

    <footer>
         <div class="container">
         
            <div class="copy text-center">
               Copyright 2014 <a href='#'>Website</a>
            </div>
            
         </div>
      </footer>

      <link href="vendors/datatables/dataTables.bootstrap.css" rel="stylesheet" media="screen">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- jQuery UI -->
    <script src="https://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="vendors/datatables/js/jquery.dataTables.min.js"></script>

    <script src="vendors/datatables/dataTables.bootstrap.js"></script>

    <script src="js/custom.js"></script>
    <script src="js/tables.js"></script>
    
    
    <script>
    $("button[name=delivery]").click(function(){
//   	    var deliveryState;
//     	$('.odd').each(function(i, element) {
//     		deliveryState = $('#delivery').eq(i).val();
// 		});
//     	alert(deliveryState);
  	    
    	var orderNo = $(this).val();
    	var deliveryState =$(this).parents('tr').find('select[name=delivery]').val();
  	    
    	location="note?command=purDeliveryState&orderNo="+orderNo+"&deliveryState="+deliveryState;
    });
    
    $("button[name=refund]").click(function(){
    	var orderNo = $(this).val();
 
    	location="note?command=purRefund&orderNo="+orderNo;
    });
    
    $(function(){
		var $refundState = $('input[name=refund_state]');
		$refundState.each(function(){
			if($(this).val() == '환불요청'){
				$(this).parents('tr').find('button[name=refund]').show();
			}
		});
    });
    
    </script>
    
     <script>
	(function(){
		if(<%=!"admin".equals((String)session.getAttribute("id"))%>){
			alert("관리자 전용 페이지 입니다.");
			history.back();
		}
		$("button[name=refund]").hide();
	})();
	</script>
  </body>
</html>