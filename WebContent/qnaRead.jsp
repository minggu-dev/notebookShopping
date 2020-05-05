<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
          <td colspan="3">${b.userId}</td>
<!--           <th>상품번호</th> -->
<%--           <td>${b.product.serialNum}</td> --%>
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
            
            
      	   <form action="qnaUpdate.jsp" method="post" >
      	<input type="hidden" name="userId" value="${b.userId }">
        <input type="hidden" name="qnaNo" value="${b.qnaNo }">
<%--         <input type="hidden" name="serialNum" value="${b.product.serialNum }"> --%>
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
 <br><br><br><br><br>
 </div>
      
<!--       <script> -->


    	  
      

      
<!-- //     jQuery(document).ready(function() { -->
<%-- //         if(${id == null}){ --%>
<!-- //             alert("게시판을 이용하시려면 로그인하셔야 합니다."); -->
<!-- //             location.href="/bbs/login.bbs"; -->
<!-- //         } -->
<!-- //     }); -->
    
    
    
<!-- //     // Perform an asynchronous HTTP (Ajax) request. -->
<!-- //     // 비동기 통신 Ajax를 Setting한다. -->
<!-- //     $.ajaxSetup({ -->
<!-- //         type:"POST", -->
<!-- //         async:true, -->
<!-- //         dataType:"json", -->
<!-- //         error:function(xhr) { -->
<!-- //             console.log("error html = " + xhr.statusText); -->
<!-- //         } -->
<!-- //     }); -->
    
<!-- //     $(function() { -->
<!-- //         $("#commentWrite").on("click", function() { -->
<!-- //             $.ajax({ -->
<!-- //                 url:"/bbs/commentWrite.bbs", -->
<!-- //                 // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다. -->
<!-- //                 data:{ -->
<!-- //                     commentContent:$("#commentContent").val(), -->
<%-- //                     articleNumber:"${article.articleNumber}" --%>
<!-- //                 }, -->
<!-- //                 beforeSend:function() { -->
<!-- //                     console.log("시작 전..."); -->
<!-- //                 }, -->
<!-- //                 complete:function() { -->
<!-- //                     console.log("완료 후..."); -->
<!-- //                 }, -->
<!-- //                 success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback -->
<!-- //                     if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과 -->
<!-- //                         console.log("comment가 정상적으로 입력되었습니다."); -->
<!-- //                         $("#commentContent").val(""); -->
<!-- //                         showHtml(data.comments, 1); -->
<!-- //                     } -->
<!-- //                 } -->
<!-- //             }) -->
<!-- //         }); -->
<!-- //     }); -->
 
<!-- //     function showHtml(data, commPageNum) { -->
<!-- //         let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>"; -->
<!-- //         $.each(data, function(index, item) { -->
<!-- //             html += "<tr align='center'>"; -->
<!-- //             html += "<td>" + (index+1) + "</td>"; -->
<!-- //             html += "<td>" + item.id + "</td>"; -->
<!-- //             html += "<td align='left'>" + item.commentContent + "</td>"; -->
<!-- //             let presentDay = item.commentDate.substring(0, 10); -->
<!-- //             html += "<td>" + presentDay + "</td>"; -->
<!-- //             html += "</tr>"; -->
<!-- //         }); -->
<!-- //         html += "</tbody></table>"; -->
<!-- //         commPageNum = parseInt(commPageNum);        // 정수로 변경 -->
<!-- //         // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다. -->
<%-- //         if("${article.commentCount}" > commPageNum * 10) { --%>
<!-- //             nextPageNum = commPageNum + 1; -->
<!-- //             html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>"; -->
<!-- //         } -->
        
<!-- //         $("#showComment").html(html); -->
<!-- //         $("#commentContent").val(""); -->
<!-- //         $("#commentContent").focus(); -->
<!-- //     } -->
    
<!-- //     function getComment(commPageNum, event) { -->
<!-- //         $.ajax({ -->
<!-- //             url:"/bbs/commentRead.bbs", -->
<!-- //             data:{ -->
<!-- //                 commPageNum:commPageNum*10, -->
<%-- //                 articleNumber:"${article.articleNumber}" --%>
<!-- //             }, -->
<!-- //             beforeSend:function() { -->
<!-- //                 console.log("읽어오기 시작 전..."); -->
<!-- //             }, -->
<!-- //             complete:function() { -->
<!-- //                 console.log("읽어오기 완료 후..."); -->
<!-- //             }, -->
<!-- //             success:function(data) { -->
<!-- //                 console.log("comment를 정상적으로 조회하였습니다."); -->
<!-- //                 showHtml(data, commPageNum); -->
                
<!-- //                 let position = $("#showComment table tr:last").position(); -->
<!-- //                 $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간 -->
<!-- //             } -->
<!-- //         }) -->
<!-- //     } -->
    
   
<!-- </script> -->
   
      
    </div>

 
  <!-- Footer -->
 <jsp:include page="footer.jsp"/>
	

     </div> 
</body>
</html>