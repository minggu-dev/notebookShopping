<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		$('form').submit(function(){
			$(this).find("input[name=serialNum]").val($('form[name=deletereview]').find('input[name=serialNum]').val());
			var data = $(this).serialize();
			$('section').empty();
			console.log(data)
			$.ajax({
				url : $(this).attr("action"),
				data : data,
				success : function(resourceData){
					$('section').html(resourceData);
				}
			});
		});
		
		$('input[name=list]').click(function(){
			$('section').empty();
			$.ajax({
				url : "note",
				data : "command=qnaProduct&serialNum=" + $('form[name=deletereview]').find('input[name=serialNum]').val(),
				success : function(resourcedata) {
					$('section').html(resourcedata);
				}
			});
		})
	});
</script>
<style>
    #contentForm {
      width: 20%;
      margin: 0 auto;
      padding-top: 12%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
</style>
</head>
<body>


</head>
    

<body>
<div class="super_container">
<div class="offset-lg-0 col-lg-3" >

 <% 
 String userId =(String)session.getAttribute("id");

%>

<form name=insertForm method="post" action="note?command=qnaInsert" >
	<input type="hidden" name="userId" value="<%=userId %>">
	<input type="hidden" name="serialNum" value="">
	<div id= "contentForm">
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th width="30%">아이디</th>
              <td width="40%" ><%=userId %></td>
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
                <textarea cols="130" rows="20" name="content"  style="resize: none;"></textarea>
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
        		<input type="button" name="list" class="btn btn-default" value="목록으로 돌아가기">
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
</body>
</html>