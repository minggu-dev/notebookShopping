<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.setHeader("Cache-Control", "no-store"); %>    
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
    <meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link rel="stylesheet" href="assets/css/main.css" />

<script src="js/custom.js"></script>
 <script src="js/tables.js"></script>
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
 <script src="js/tables.js"></script>
 <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="managerIndex.jsp">상품추가</a></h1>
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
                    <li><a href="note"><i class="glyphicon glyphicon-home"></i> 홈으로</a></li>
                    <li class="current"><a href="note?command=proAll"><i class="glyphicon glyphicon-list"></i> 상품정보</a></li>
                    <li class="current"><a href="note?command=userAll"><i class="glyphicon glyphicon-list"></i> 회원정보</a></li>
                    <li class="current"><a href="note?command=qnaAll"><i class="glyphicon glyphicon-list"></i> Q&A</a></li>
                    <li class="current"><a href="note?command=purAll"><i class="glyphicon glyphicon-list"></i> 주문정보</a></li>
                </ul>
             </div>
		  </div>
 <!-- 정보 -->
		  <form action="note?command=proInsert" method="post" enctype="multipart/form-data" >
		  <section id="one" >
							<h2>상품 추가</h2>
							<table>
								<tr><td>모델명</td><td><input type="text" name="modelName"></td></tr>
								<tr><td>회사이름</td><td><input type="text" name="company"></td></tr>
								<tr><td>금액</td><td><input type="text"  name="price"></td></tr>
								<tr><td>RAM</td><td><input type="text" name="ram"></td></tr>
								<tr><td>CPU</td><td><input type="text" name="cpu"></td></tr>
								<tr><td>화면 크기</td><td><input type="text" name="noteSize"></td></tr>
								<tr><td>무게</td><td><input type="text"  name="noteWeight"></td></tr>
								<tr><td>날짜</td><td><input type="text" name="launchDate"></td></tr>
								<tr><td>이미지파일</td><td> <input type="file" name="file" ></td></tr>
								<tr><td>설명파일</td><td> <input type="file" name="file2" ></td></tr>
								<tr><td><button type="submit" name="add">추가완료</button></td>
								<td><button type="button" name="back">뒤로가기</button></td></tr>
								
							</table>

			</section>
		 </form>
		  </div>

		</div>
		
    </div>

    <footer>
         <div class="container">
         
            <div class="copy text-center">
               Copyright 2014 <a href='#'>Website</a>
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



 
 
   <script>
     $("button[name=back]").click(function(){
    	 location="productAll.jsp"
     });
     </script>
     
     <script>
	(function(){
		if(<%=!"admin".equals((String)session.getAttribute("id"))%>){
			alert("관리자 전용 페이지 입니다.");
			history.back();
		}
	})();
	</script>
  </body>
</html>