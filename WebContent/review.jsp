<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<script>
</script>
</head>
<body>

<c:choose>
					<c:when test="${empty requestScope.list}">
						<div style="text-align: center;">등록된 후기가 없습니다.</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.list}" var="review">
							<div style="text-align: left; border: 1px solid silver;">
								<div style="text-align: left">
									<span style="font-weight: bold;" class="reviewuser">${review.userId}</span> 
									<a class="reviewupdate" href="">수정</a> 
									<a class="reviewdelete" href="">삭제</a>
								</div>
								
								<div style="text-align: right;">${review.createDate}</div><br>
								${review.content}
								<br><br><br><br>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<br>
				<br>
				<br>
				<br>
				<fieldset class="scheduler-border">
					<br>
					<legend class="scheduler-border"><div style="text-align: center">후기 작성하기</div></legend>
					<div>
						<p>후기 작성하시면 다음 구매시에 무료로 배송해드려요</p>
						<form class="form-inline" action="note?command=reviewInsert" method="post" enctype="multipart/form-data">
							<div>
								평점:
								<input name="grade" value ="5" type="radio" checked>★★★★★ &nbsp;&nbsp;<input name="grade" value ="4" type="radio">★★★★&nbsp;&nbsp;
								<input name="grade" value ="3" type="radio">★★★&nbsp;&nbsp;<input name="grade" value ="2" type="radio">★★&nbsp;&nbsp;
								<input name="grade" value ="1" type="radio">★
							</div>
							<br>
							<div>
								<label>내용 </label>
								<textarea class="form-control" name = "content" rows="4" cols="80" maxlength="500" placeholder="후기를 작성해 주세요(500자 제한)"></textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-default">쓰기</button>
							</div>
								<input type="hidden" name="serialNum" value="${requestScope.serialNum}">
							<br> 
							<br>
						</form>
					</div>
				</fieldset>

</body>
</html>