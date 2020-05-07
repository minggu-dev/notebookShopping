<%@ page info="게시글 등록하기" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%response.setHeader("Cache-Control", "no-store"); %>    
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/categories.css">
<link rel="stylesheet" type="text/css" href="styles/categories_responsive.css">

<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/js/jquery-3.3.1.min.js"></script>

<style>
    #contentForm {
      margin: 0 auto;
      padding-top: 6%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
    .home{
    	width : 100%;
    	height : 1000px;
    	background-color: #FFFFFF;
    }
    .super_container{
    	background-color: #FFFFFe;
    }
  </style>

</head>
<body>



<div class="super_container">

<jsp:include page="header.jsp"/>

 <div class="home">


<br>
 <% 
 String userId =(String)session.getAttribute("id");
%>

             

<form name=insertForm method="post" action="note?command=qnaInsert" >

              
<input type="hidden" name="userId" value="<%=userId %>">
<div id= "contentForm">
         
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>

            
            <tr>
              <th width="30%">아이디</th>
              <td width="70%" ><%=userId %></td>
            </tr>
            
            <tr>
              <th style="padding-top: 15px">제목</th>
              <td> 
              <textarea rows="1" style="width:100%; resize: none;" name="subject"></textarea>  
              </td>
              </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="2">
                <textarea cols="160" rows="20" name="content"  style="resize: none;"></textarea>
              </td>
            </tr>
            
            <tr>
              <th style="padding-top: 15px">비밀번호</th>
              <td><input type="password"  size="70" name="password">
                    </td>
            </tr>
            
            <tr>
             <td colspan="2" rowspan="1">
             
				<div   style="margin-left:5px; float:right; display: inline-block;">
        		<input type="button" class="btn btn-default" value="목록으로 돌아가기" onclick="document.location.href='qnaList.jsp'">
        		</div>
        		<div  style="float:right; display: inline-block;">
              	<input type="submit" name="save" class="btn btn-default" value="저장하기" >
       			</div>
              	
              	</td>  
            </tr>
           
            
          </tbody>
        </table>
      </div>
      
    </div>
  </form>
  <br> <br> <br> <br> <br> <br> <br> <br>  
  </div>
 
 </div>
 </div>
 <jsp:include page="footer.jsp"/>
 
 
  
    <script>
     jQuery(document).ready(function() {
    
       if("<%=userId%>" == null) { 
         	alert("게시판을 이용하시려면 로그인하셔야 합니다."); 
        	location.href="login.jsp" ;
       }
       
    }); 
 </script>

</BODY>	
</html>








