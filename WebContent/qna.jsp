<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    }
  </style>


     <script>
     	$(function(){
     		$('a.write').click(function(){
   				$('section').empty();
         		$.ajax({
         			url : "qnaProWrite.jsp",
         			success : function(resourceData){
         				$('section').html(resourceData);
         			}
         		})
         		return false;
         	});
     		
     		
     	});
     	function checkPwd(count){
			var pass = $("#pwd" + count).val();
			$('input[name=qnaNo]').val(count);
			if(typeof pass != 'undefined' && pass != ""){
				var pwd = prompt("비밀번호를 입력하세요.","비밀번호 ");
				if(pwd != pass ){
					alert("비밀번호가 잘못되었습니다.");
					return false;
				}
			}
			$('#detail').submit();
			return false;
		}
     </script>
</head>
<body>

<!-- ------------------------------------------------------------------- -->
<!-- 여기서부터 -->
<!-- ------------------------------------------------------------------- -->
<!-- 여기서부터 -->
<!-- ------------------------------------------------------------------- -->
<!-- 여기서부터 -->

  
  <!-- Bootstrap -->
  
</head>
  <div id="container" class="qnacontainer">
    <div align="right">
      <c:if test="${id != null}">
      </c:if>
      <c:if test="${id == null}">
      </c:if>
    </div>
   
    <div id="list">
      <b>게시판 (전체 글 ${totalCount})</b>
    </div>
    
    
    
                <h6>1:1 고객 게시판</h2>	
                <h8>고객님의 질문에 대해서 운영자가  1:1 답변을 드립니다.</h3>
    
     <div align=right>
     <form id="qnaWrite" action="note?command=proSortAll" method="post">
       <a href="" class="write">글쓰기</a>
    </form>
    </div>
     
      
    <div>
      <table class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th width="15%">답변상태</th>
            <th width="10%">번호</th>
            <th width="25%">제목</th>
            <th width="10%">작성자</th>
            <th width="15%">작성일</th>          
            <th width="20%">조회</th>
          </tr>
        </thead>
        <tbody>
     	
        
          <c:forEach var="qna" items="${list}" varStatus="status">
            <tr>
              <td>${qna.answerState == 0 ? '미답변' : '답변완료'}</td>
              <td>${status.count}</td>
              <td id="subject"><a href="#" onclick="checkPwd('${qna.qnaNo}')">${qna.password == null ? qna.subject : '잠긴글 입니다.'}</a></td>
              <td>${qna.userId}</td>             
              <td>${qna.createDate}</td>
              <td>${qna.viewCnt}</td> 
            </tr>
			<input type="hidden" id="pwd${qna.qnaNo}" name="password" value="${qna.password }"> 
                
          </c:forEach>
          
        </tbody>
      </table>
    </div>
  </div>
  
 <br>
 <br>
 <br>
 <br>
 <!--  -->
 <% String myId =(String)session.getAttribute("userId"); %>
 
 
	<form id="detail" action="note?command=qnaDetail" method="post">
		<input type="hidden" name="qnaNo" value="">
		<input type="hidden" name="flag" value="1">
	</form> 
	
	<script>
		if(<%=session.getAttribute("id") == null%>){
			$('#qnaWrite').hide();
		}
	</script>
</html>