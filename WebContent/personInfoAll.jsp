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
  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="managerIndex.html">회원 전체 정보</a></h1>
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
					<div class="panel-title">Bootstrap dataTables</div>
				</div>
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>일련번호</th>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>주소</th>
								<th>전화번호</th>
								<th>질문</th>
								<th>답변</th>
								<th>활동상태</th>
								<th>회원비활성화</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="personInfo" items="${list}" varStatus="status">
							<tr class="odd gradeX">
								<td><c:out value="${status.count}" /></td>
								<td><c:out value="${personInfo.userId}"  /></td>
								<td><c:out value="${personInfo.pwd}"  /></td>
								<td><c:out value="${personInfo.name}"  /></td>
								<td class="center"><c:out value="${personInfo.addr}" /></td>
								<td class="center"><c:out value="${personInfo.phone}"  /></td>
								<td>${personInfo.question}</td>
								<td>${personInfo.answer}</td>
								<td>${personInfo.state}</td>
								<td><button name="state" value="${personInfo.userId}" id="${personInfo.pwd}">비활성화</button></td>			
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

  

    <script>
    	$("button[name=state]").click(function(){
    		alert(1);
    		var id = $(this).val();
    		var password= $(this).attr("id");
    		location="note?command=userWithdraw&id="+id+"&password="+password;
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