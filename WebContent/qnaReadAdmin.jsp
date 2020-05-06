<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>

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
    
<style>
    .contentForm {
      width: 70%;
      margin: 0 auto;
      padding-top: 12%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
    .home{
    	height: 1500px;
    	background-color: #FFFFFF;
    }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>

<div class="super_container">
<div class="home">
<jsp:include page="header.jsp"/>
	<!-- Home -->

<br>
<br>


	<h1 align="center">나는야 관리자 </h1>

<br>
<br>
<br>
<br>
<table class="table table-striped table-bordered contentForm">
   <tr>
      <c:set var = "b" value="${board}"/>
   
          <th style="width:10%">글번호</th>
          <td style="width:40%">${b.qnaNo}</td>
          <th style="width:10%">작성일자</th>
          <td>${b.createDate}</td>
        </tr>
     <tr>
          <th>글쓴이</th>
          <td>${b.userId}</td>
          <th>상품번호</th>
          <td>${b.product.serialNum}</td>
        </tr>
        <tr>
          <th >제목</th>
          <td colspan="3">${b.subject}</td>
    
        </tr>
        
        <tr height="400" valign="top">
        <th>내용</th>
          <td colspan="4">${b.content}</td>
        </tr>
        
        
        
        <tr>
          <td colspan="4" align="right">
       
            <!-- 로그인 검증 -->
            <div class="btn-group btn-group-sm" role="group" aria-label="...">
            
           <form action="note?command=qnaDelete" method="post" onSubmit="return confirm('정말 삭제하시겠습니까?');">
			<input type="submit"  class="btn btn-default" value="삭제하기" id ="qnaDelete" name="qnaDelete">
			<input type="hidden" name="qnaNo" value="${b.qnaNo }">
      	   </form>       
        </div>
        </td>
        </tr>
        
      </table>
      
      
      <br>
      <br>
      <br>
      <!-- 댓글달기 댓글보기  -->
      <table class="table table-striped table-bordered contentForm" id="contentForm">
    	<tr class="topAns">
       	 <th colspan="6" valign="top">댓글내용</th>
        </tr>
        
        
        
    
        
        <tr height="100" valign="top">
		        <th style="width:10%">댓글입력</th>
		        
		        <form action="note?command=ansInsert" method="post">
		         <c:set var = "b" value="${board}"/>
		   			<input type="hidden" value="${b.qnaNo}" name="qnaNo">
		        <td colspan="4"><textarea rows="5" id="commentContent" placeholder="댓글을 입력하세요." name="content" style="width:100%; height:100%; resize: none;"></textarea></td>
		        
		        
		        <td style="width:10%" align="right" valign="bottom">
		            <!— 로그인 검증 —>
		            
		            <input type="submit" style="width:100%; " class="btn btn-default" value="답글달기">
		       </td>
		       </form>  
       </tr>
        
        
      </table>
      <!-- 
      
      ----------댓글------------------------------------------------------------------
      
       -->
      <table class="table table-striped table-bordered" id="contentForm">
			<!-- Comment 태그 추가 -->
			<div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
			    <div id="showComment" style="text-align: center;"></div>
			</div>
			
      </table>
      
      </div>
    </div>
 <br>
 <br>
 <br>
 <br>
 <form action="note?command=ansDelete" method="post" name="ansDeleteForm">
 	<input type="hidden" name="qnaNo" value="${board.qnaNo}">
 	<input type="hidden" name="ansNo" value="">
 </form>
 
  <script>
 jQuery(document).ready(function() {



if(<%=!"admin".equals(session.getAttribute("id"))%>) { 
	  alert("관리자에게만 권한이 있습니다."); 
	 location.href="note?command=qnaAll"; 
	}
});
 
 $(function(){
	 $.ajax({
		 url:"ajax",
		 data:"command=ansSelect&qnaNo=" + $('input[name=qnaNo]').val(),
		 dataType: "json",
		 success : function(jsonObj){
			 $.each(jsonObj,function(index,item){
				var trhtml = "";
				trhtml += '<tr height="100"><th style="width:10%" name="minho"></th><td colspan="4" name="content">' + item.content + '</td>';
			    trhtml += '<td align="right" style="background-color: rgba(0, 0, 0, 0.05);">';
			    trhtml += '<input type="button" name="reviewDelete" class="btn btn-default" value="삭제하기"><input type="hidden" name="ansNo" value="' + item.ansNo + '"></td></tr>';
			    $('#contentForm').append(trhtml);
			 });
			(function(){
					$('.home').height(jsonObj.length * 102 + 1100);
			})();
		 },error : function(e){
			 alert(e);
		 }
	 })
	 
	 $('#contentForm').on('click','input[name=reviewDelete]', function(){
		$('form[name=ansDeleteForm]>input[name=ansNo]').val($(this).siblings('input[name=ansNo]').val());
		$('form[name=ansDeleteForm]').submit();
	 });
 });
 </script>
 
  <!-- Footer -->
 <jsp:include page="footer.jsp"/>
	
</body>
</html>

