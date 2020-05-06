<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>
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
    	height : 1000px;
    }
  </style>

</head>

<body>



<div class="super_container">

<jsp:include page="header.jsp"/>

<div class="home">


<br>
 <% 
    String userId = request.getParameter("userId");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String qnaNo = request.getParameter("qnaNo");
	String password = request.getParameter("password");
	String createDate = request.getParameter("createDate");
	String serialNum = request.getParameter("serialNum");

%>

             

<form name=updateForm method="post" action="note?command=qnaUpdate" >
             <input type="hidden" name="qnaNo" value="<%=qnaNo %>">
              <input type="hidden" name="userId" value="<%=userId %>">
              <input type="hidden" name="password" value="<%=password %>">
              <input type="hidden" name="createDate" value="<%=createDate %>">
              <input type="hidden" name="serialNum" value="<%=serialNum %>">
              
              
 
<div id= "contentForm">
         
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>
          	<tr>
              <th width="30%">글번호</th>
              <td width="70%" ><%=qnaNo %></td>
            </tr>
            
            <tr>
              <th width="30%">아이디</th>
              <td width="70%" ><%=userId %></td>
            </tr>
            <tr>
              <th style="padding-top: 15px">제목</th>
              <td> <textarea rows="1" style="width:100%; resize: none;" name="subject"><%=subject %></textarea>  </td>
              
<%--               <td><input type="text" name="subject" size="70" ><%=subject%> --%>
<!--                     </td> -->
<!--             </tr> -->
            
          </thead>
          <tbody>
            <tr>
              <td colspan="2">
                <textarea cols="160" rows="20" name="content"  style="resize: none;"><%=content %></textarea>
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
        		<input type="button" class="btn btn-default" value="게시물로 돌아가기" onclick="javascript:history.back()">
        		</div>
        		<div  style="float:right; display: inline-block;">
              	<input type="button" name="update" class="btn btn-default" value="수정하기" >
       			</div>
              	
              	</td>  
            </tr>
           
            
          </tbody>
        </table>
      </div>
      
    </div>
  </form>
 
   
<br>
<br>
<br>
<br>
<br>

</div>
</div>	
 
 <jsp:include page="footer.jsp"/>
 
 <script>
 
 jQuery(document).ready(function() {

	


	if(<%=session.getAttribute("id")%> == null) { 
	  alert("게시판을 이용하시려면 로그인하셔야 합니다."); 
	 location.href="login.jsp" 
	}

});

$('input[type=button][name=update]').click(function(){
	var pwd = $('input[type=password][name=password]').val();
	var password = $('input[type=hidden][name=password]').val();
	if(pwd == password){
		$("form[name=updateForm]").submit();	
	}
	else{
		alert("비밀번호가 잘못되어 수정을 못합니다.");
		return;
	
	}
	
})

 
 
 </script>
  
<!--     <script> -->
<!-- //     jQuery(document).ready(function() { -->
<!-- //     	var id = session.getAttribute("id"); -->

    	
<!-- //       if(id== null) { -->
<!-- //         alert("게시판을 이용하시려면 로그인하셔야 합니다."); -->
<!-- //         location.href="login.jsp" -->
<!-- //       }if(id!=null){ -->
<!-- //     	  $("input[name=pwd]").click(function(){ -->
<!-- //     			var pwd = prompt("비밀번호를 입력하세요.","비밀번호 "); -->
<!-- //     			location = "q&aUpdate.jsp"; -->
<!-- //     		}); -->
<!-- //       } -->
<!-- //     }); -->
<!--   </script> -->
</BODY>	
</html>








