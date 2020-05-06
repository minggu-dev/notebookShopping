<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
  
<%-- <c:set var="path" value="${pageContext.request.contextPath}" scope="application"/> --%>
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
  </head>
  <body>
     <div class="header">
        <div class="container">
           <div class="row">
              <div class="col-md-5">
                 <!-- Logo -->
                 <div class="logo">
                    <h1><a href="managerIndex.html">상품 전체정보</a></h1>
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
        
        
        <!-- 테이블시작 -->
        <div class="col-md-10">

           <div class="content-box-large">
              <div class="panel-heading">
               <div class="panel-title">상품 수정</div>
            </div>
              <div class="panel-body">
                 <form action="note?command=proUpdate" method="post">
                 <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example" >
                  <thead>
                     <tr>
                        <th width="5%">일련번호</th>
                        <th width="10%">제조사</th>
                        <th width="15%">모델명</th>
                        <th width="10%">가격</th>
                        <th width="5%">RAM</th>
                        <th width="5%">CPU</th>
                        <th width="5%">화면크기(인치)</th>
                        <th width="5%">무게(kg)</th>
                        <th width="5%">재고</th>
                        <th width="10%">수정</th>
  
                     </tr>
                  </thead>
                  <tbody>
                  
                  <c:set var="product"  value="${product}" />
                     <tr class="odd gradeX">
                        <td><input type="text" name="serialNum"  value="${product.serialNum}" ></td>
                        <td><input type="text" name="company"  value="${product.company}" ></td>
                        <td><input type="text" name="modelName"  value="${product.modelName}" ></td>
                        <td><input type="text" name="price"  value="${product.price}" ></td>
                        <td><input type="text" name="ram"  value="${product.ram}" ></td>
 						<td><input type="text" name="cpu"  value="${product.cpu}" ></td>
 						<td><input type="text" name="noteSize"  value="${product.noteSize}" ></td>
 						<td><input type="text" name="noteWeight"  value="${product.noteWeight}" ></td>
 						<td><input type="text" name="stock"  value="${product.stock}" ></td>
 						<td><input type="submit" value="수정" ></td>
                       
                     </tr>
                  
    
                  
      
                  </tbody>
               </table>
               </form>
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
	(function(){
		if(<%=!"admin".equals((String)session.getAttribute("id"))%>){
			alert("관리자 전용 페이지 입니다.");
			history.back();
		}
	})();
	</script>
  </body>
</html>