<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%response.setHeader("Cache-Control", "no-store"); %>    
<!DOCTYPE html>
<html lang="en">
<head>

<style>
    #contentForm {
      width: 70%;
      margin: 0 auto;
      padding-top: 12%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
  </style>
  
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<link rel="stylesheet" href="css/style.css">
 
    
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

$(function(){
	if('<%=session.getAttribute("id")%>' != '${board.userId}'){
		$('#qnaUpdate').hide();
		$('#qnaDelete').hide();
	}
	
		 $.ajax({
			 url:"ajax",
			 data:"command=ansSelect&qnaNo=" + $('input[name=qnaNo]').val(),
			 dataType: "json",
			 success : function(jsonObj){
				 $.each(jsonObj,function(index,item){
					var trhtml = "";
					trhtml += '<tr height="100"><th style="width:10%" name="minho"></th><td colspan="5" name="content"><span style="font-size: 15px;"><b><pre>' + item.content + '</pre></b></span></td>';
				    trhtml += '</tr>';
				    $('table[name=minotest]').append(trhtml);
				 });
			 },error : function(e){
				 alert(e);
			 }
		 })
		 
})

</script>
</head>

<body>

<div class="super_container">
<jsp:include page="header.jsp"/>
	<!-- Home -->

	<div class="home">
		<div class="home_container">
			<div class="home_background" style="background-image:url(images/cart.jpg)"></div>
			<div class="home_content_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="home_content">
								<div class="breadcrumbs">
									<ul>
										<li><a href="note">Home</a></li>
										<li><a href="note?command=qnaAll">Q&A</a></li>
										<li>내 게시물</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<br>
<br>

<%
// 	String userId = request.getParameter("userId");
// 	String qnaNo = request.getParameter("qnaNo");
// 	String serialNum = request.getParameter("serialNum");
// 	String subject = request.getParameter("subject");
// 	String content = request.getParameter("content");
// 	String createDate = request.getParameter("createDate");
// 	String password = request.getParameter("password");
%>






	<div class="cart_info">
    <div align="center">
<%--         <input type="hidden" name="userId" value="${list.userId}"> --%>
<%--         <input type="hidden" name="qnaNo" value="${list.qnaNo}"> --%>
<%--         <input type="hidden" name="serialNum" value="${list.serialNum}"> --%>
<%--         <input type="hidden" name="subject" value="${list.subject}"> --%>
<%--         <input type="hidden" name="content" value="${list.content}"> --%>


<table class="table table-striped table-bordered" id="contentForm">

   <tr>
   <c:set var = "b" value="${board}"/>

          <th style="width:10%">글번호</th>
          <td style="width:40%">${b.qnaNo}</td>
          <th style="width:10%">작성일자</th>
          <td>${b.createDate}</td>
        </tr>
     <tr>
          <th>글쓴이</th>
          <td colspan="1">${b.userId}</td>
          
          <th>상품명</th>
		<td>[${b.product.company}] ${b.product.modelName}</td>
        </tr>
        <tr>
          <th >제목</th>
          <td colspan="3">${b.subject}</td>
    
        </tr>
        
        <tr height="400" valign="top">
        <th>내용</th>
          <td colspan="4"><span style="font-size: 15px;"><b><pre>${b.content}</pre></b></span></td>
        </tr>
        
        <tr>
          <td colspan="4" align="right">
            
            <!-- 로그인 검증 -->
            <div class="btn-group btn-group-sm" role="group" aria-label="...">
            
            
      	   <form action="qnaUpdate.jsp" method="post" >
      	<input type="hidden" name="userId" value="${b.userId }">
        <input type="hidden" name="qnaNo" value="${b.qnaNo }">
        <input type="hidden" name="subject" value="${b.subject }">
        <input type="hidden" name="content" value="${b.content }">
        <input type="hidden" name="password" value="${b.password }">
        
			<input type="submit"  class="btn btn-default" value="수정하기" id ="qnaUpdate" name="qnaUpdate">
      	   </form>
            
           <form action="note?command=qnaDelete" method="post" onSubmit="return confirm('정말 삭제하시겠습니까?');">
           <input type="hidden" name="qnaNo" value="${b.qnaNo}">
			<input type="submit"  class="btn btn-default" value="삭제하기" id ="qnaDelete" name="qnaDelete">
      	   </form>
        </div>
        </td>
        </tr>
        
      </table>
      <br>
      <br>
      <br>
      <!-- 댓글달기 댓글보기  -->
      <table class="table table-striped table-bordered contentForm" id="contentForm" name="minotest">
    	<tr class="topAns">
       	 <th colspan="6" valign="top">댓글내용</th>
        </tr>
        
      </table>
 <br><br><br><br><br>
 </div>
      
    </div>

 
  <!-- Footer -->
 <jsp:include page="footer.jsp"/>
	

     </div> 
</body>
</html>