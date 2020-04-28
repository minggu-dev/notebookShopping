<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src=js/jquery-3.2.1.min.js></script>
  
<body>
<div class="super_container">

   <!-- Header -->

   <header class="header">
      <div class="header_container">
         <div class="container">
            <div class="row">
               <div class="col">
                  <div class="header_content d-flex flex-row align-items-center justify-content-start">
                     <div class="logo"><a href="index.jsp">홈페이지 이름</a></div>
                     <nav class="main_nav">
                        <ul>
                           <li>
                              <a href="index.jsp">Home</a>
                           </li>
                           <li>
                              <a href="#">Products</a>
                           </li>
                           <li class="hassubs">
                              <a href="categories.html">Categories</a>
                              <ul>
                                 <li><a href="categories.html">Category</a></li>
                                 <li><a href="categories.html">Category</a></li>
                                 <li><a href="categories.html">Category</a></li>
                                 <li><a href="categories.html">Category</a></li>
                                 <li><a href="categories.html">Category</a></li>
                              </ul>
                           </li>
                           <li>
                              <a href="q&aList.jsp">Q&A</a>
                           </li>
                           <li>
                              <a href="login.jsp">Login</a>
                           </li>
                           <li>
                              <a href="register.jsp">JoinUs</a>
                           </li>
                        </ul>
                     </nav>
                     <div class="header_extra ml-auto">
                        <div class="shopping_cart">
                           <a href="cart_new.jsp">
                              <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     viewBox="0 0 489 489" style="enable-background:new 0 0 489 489;" xml:space="preserve">
                                 <g>
                                    <path d="M440.1,422.7l-28-315.3c-0.6-7-6.5-12.3-13.4-12.3h-57.6C340.3,42.5,297.3,0,244.5,0s-95.8,42.5-96.6,95.1H90.3
                                       c-7,0-12.8,5.3-13.4,12.3l-28,315.3c0,0.4-0.1,0.8-0.1,1.2c0,35.9,32.9,65.1,73.4,65.1h244.6c40.5,0,73.4-29.2,73.4-65.1
                                       C440.2,423.5,440.2,423.1,440.1,422.7z M244.5,27c37.9,0,68.8,30.4,69.6,68.1H174.9C175.7,57.4,206.6,27,244.5,27z M366.8,462
                                       H122.2c-25.4,0-46-16.8-46.4-37.5l26.8-302.3h45.2v41c0,7.5,6,13.5,13.5,13.5s13.5-6,13.5-13.5v-41h139.3v41
                                       c0,7.5,6,13.5,13.5,13.5s13.5-6,13.5-13.5v-41h45.2l26.9,302.3C412.8,445.2,392.1,462,366.8,462z"/>
                                 </g>
                              </svg>
                              <div>Cart <span>(0)</span></div>
                           </a>
                        </div>
                        <div class="search">
                           <div class="search_icon">
                              <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                              viewBox="0 0 475.084 475.084" style="enable-background:new 0 0 475.084 475.084;"
                               xml:space="preserve">
                              <g>
                                 <path d="M464.524,412.846l-97.929-97.925c23.6-34.068,35.406-72.047,35.406-113.917c0-27.218-5.284-53.249-15.852-78.087
                                    c-10.561-24.842-24.838-46.254-42.825-64.241c-17.987-17.987-39.396-32.264-64.233-42.826
                                    C254.246,5.285,228.217,0.003,200.999,0.003c-27.216,0-53.247,5.282-78.085,15.847C98.072,26.412,76.66,40.689,58.673,58.676
                                    c-17.989,17.987-32.264,39.403-42.827,64.241C5.282,147.758,0,173.786,0,201.004c0,27.216,5.282,53.238,15.846,78.083
                                    c10.562,24.838,24.838,46.247,42.827,64.234c17.987,17.993,39.403,32.264,64.241,42.832c24.841,10.563,50.869,15.844,78.085,15.844
                                    c41.879,0,79.852-11.807,113.922-35.405l97.929,97.641c6.852,7.231,15.406,10.849,25.693,10.849
                                    c9.897,0,18.467-3.617,25.694-10.849c7.23-7.23,10.848-15.796,10.848-25.693C475.088,428.458,471.567,419.889,464.524,412.846z
                                     M291.363,291.358c-25.029,25.033-55.148,37.549-90.364,37.549c-35.21,0-65.329-12.519-90.36-37.549
                                    c-25.031-25.029-37.546-55.144-37.546-90.36c0-35.21,12.518-65.334,37.546-90.36c25.026-25.032,55.15-37.546,90.36-37.546
                                    c35.212,0,65.331,12.519,90.364,37.546c25.033,25.026,37.548,55.15,37.548,90.36C328.911,236.214,316.392,266.329,291.363,291.358z
                                    "/>
                              </g>
                           </svg>
                           </div>
                        </div>
                        <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      
      <!-- Search Panel -->
      <div class="search_panel trans_300">
         <div class="container">
            <div class="row">
               <div class="col">
                  <div class="search_panel_content d-flex flex-row align-items-center justify-content-end">
                     <form action="#">
                        <input type="text" class="search_input" placeholder="Search" required="required">
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>

      
   </header>

   <!-- Menu -->

   <div class="menu menu_mm trans_300">
      <div class="menu_container menu_mm">
         <div class="page_menu_content">
                     
            <div class="page_menu_search menu_mm">
               <form action="#">
                  <input type="search" required="required" class="page_menu_search_input menu_mm" placeholder="Search for products...">
               </form>
            </div>
            <ul class="page_menu_nav menu_mm">
               <li class="page_menu_item has-children menu_mm">
                  <a href="index.html">Home<i class="fa fa-angle-down"></i></a>
                  <ul class="page_menu_selection menu_mm">
                     <li class="page_menu_item menu_mm"><a href="categories.html">Categories<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="product.html">Product<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="cart.html">Cart<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="checkout.html">Checkout<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="contact.html">Contact<i class="fa fa-angle-down"></i></a></li>
                  </ul>
               </li>
               <li class="page_menu_item has-children menu_mm">
                  <a href="categories.html">Categories<i class="fa fa-angle-down"></i></a>
                  <ul class="page_menu_selection menu_mm">
                     <li class="page_menu_item menu_mm"><a href="categories.html">Category<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="categories.html">Category<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="categories.html">Category<i class="fa fa-angle-down"></i></a></li>
                     <li class="page_menu_item menu_mm"><a href="categories.html">Category<i class="fa fa-angle-down"></i></a></li>
                  </ul>
               </li>
               <li class="page_menu_item menu_mm"><a href="index.html">Q&A<i class="fa fa-angle-down"></i></a></li>
               <li class="page_menu_item menu_mm"><a href="#">Login<i class="fa fa-angle-down"></i></a></li>
               <li class="page_menu_item menu_mm"><a href="contact.html">JoinUs<i class="fa fa-angle-down"></i></a></li>
            </ul>
         </div>
      </div>

      <div class="menu_close"><i class="fa fa-times" aria-hidden="true"></i></div>

      <div class="menu_social">
         <ul>
            <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
         </ul>
      </div>
   </div>
   
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
										<li><a href="index.html">Home</a></li>
										<li>Q&A</li>
										
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


  
  <!-- Bootstrap -->
  <link href="css/css/bootstrap.min.css" rel="stylesheet">
  <style>
    #container {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 2%;   /* 테두리와 내용 사이의 패딩 여백 */
    }
     
    #list {
      text-align: center;
    }
   
    #write {
      text-align: right;
    }
     
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;
      animation-duration: 1.5s;
      animation-timing-function: ease;
      animation-iteration-count: infinite;
      /* 위 속성들을 한 줄로 표기하기 */
      /* -webkit-animation: blink 1.5s ease infinite; */
    }
     
    /* 애니메이션 지점 설정하기 */
    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      /* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
    }
  </style>
</head>
<body>
  <div id="container">
    <div align="right">
      <!-- Login 검증 -->
      <!-- jstl의 if문은 else가 없어서 따로 검증해야함. -->
      <c:if test="${id != null}">
        <%-- < %@include file="loginOk.jsp" %> --%>
      </c:if>
      <c:if test="${id == null}">
        <%-- <%@include file="login.jsp" %> --%>
      </c:if>
    </div>
   
    <div id="list">
      <b>게시판 (전체 글: ${totalCount})</b>
    </div>
     
    <div id="write">
      <a href="write.html">글쓰기</a>
    </div>
     
    <div>
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="10%">아이디</th>
            <th width="20%">작성일</th>
            <th width="10%">조회</th>
          </tr>
        </thead>
        <tbody>
        <c:choose>
        <c:otherwise>
        
          <c:forEach var="article" items="${articles}" varStatus="status">
            <tr>
              <td>${article.articleNumber}</td>
              <td id="title">
                <c:if test="${article.depth > 0}">
                  &nbsp;&nbsp;
                </c:if>
                <a href="read.jsp"></a>
                <c:if test="${article.hit >= 20}">
                  <span class="hit">공지★</span>
                </c:if>
              </td>
              <td><fmt:formatNumber value="${article.id}"/></td>
              <td>${article.writeDate}</td>
              <td>${article.hit}</td>
            <tr>
          </c:forEach>
           <tr>
            <td width="10%">선1호</th>
            <td width="50%" onclick="document.location.href='q&aRead.jsp?pageNum=${pageNum}'"><a href="">제목</a></th>
            <td width="10%">작성1자</th>
            <td width="20%">작성1일</th>
            <td width="10%">조회1</th>
          </tr>
           <tr>
            <td width="10%">준호2</th>
            <td width="50%">제2목</th>
            <td width="10%">작성2자</th>
            <td width="20%">작성2일</th>
            <td width="10%">조회2</th>
          </tr>
           <tr>
            <td width="10%">민3호</th>
            <td width="50%">제3목</th>
            <td width="10%">작3성자</th>
            <td width="20%">작3성일</th>
            <td width="10%">조3회</th>
          </tr>
           
          </c:otherwise>
          </c:choose>
          
        </tbody>
      </table>
       
      <!-- Paging 처리 -->
       <div id="paging">
        ${pageCode}
      </div> 
      
      <nav aria-label="..." style="text-align: center;">
 		 <ul class="pagination">
   		 ${pageCode}
  		</ul>
	</nav>

    </div>
  </div>
  
 <br>
 <br>
 <br>
 <br>
 <!-- Footer -->
	
	<div class="footer_overlay"></div>
	<footer class="footer">
		<div class="footer_background" style="background-image:url(images/footer.jpg)"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="footer_content d-flex flex-lg-row flex-column align-items-center justify-content-lg-start justify-content-center">
						<div class="footer_logo"><a href="#">이효정짱</a></div>
						<div class="copyright ml-auto mr-auto"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> 서울시 강남구 개포동으로 놀러오세요 <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">어디로 갈까</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
						
					</div>
				</div>
			</div>
		</div>
	</footer>
</div>
</body>
</html>
