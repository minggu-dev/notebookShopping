<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.setHeader("Cache-Control", "no-store"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>

<script>
$(function(){	

	var $reviewUpObjs = $('.reviewupdate');
	$reviewUpObjs.each(function(){
		if('<%=session.getAttribute("id")%>' != $(this).siblings('span').html()){
		$(this).css('visibility', 'hidden');
		}
	});
	
	var $reviewDelObjs = $('.reviewdelete');
	$reviewDelObjs.each(function(){
		if('<%=session.getAttribute("id")%>' != $(this).siblings('span').html()){
		$(this).css('visibility', 'hidden');
		}
	});
	
	
	(function(){
		if(${empty sessionScope.id}){
			$('fieldset').hide();
		}
	})();
	

	$('a.reviewdelete').click(function(){
		$('input[name=reviewNo]').val($(this).attr('href'));
		$('form[name=deletereview]').submit();
		return false;
	});
	
	$('a.reviewupdate').click(function(){
		var content = $(this).parent().siblings('div.reviewcontent').find('pre').html();
		var $divcontent = $(this).parent().siblings('div.reviewcontent');
		$divcontent.empty();
		var divhtml = "";
		
		divhtml += '<form class="form-inline" action="note?command=reviewUpdate" method="post">';
		divhtml += '<div>평점: <input name="grade" value="5" type="radio" checked>★★★★★&nbsp;&nbsp;<input name="grade" value="4" type="radio">★★★★&nbsp;&nbsp;';
		divhtml += '<input name="grade" value="3" type="radio">★★★&nbsp;&nbsp;<input name="grade" value="2" type="radio">★★&nbsp;&nbsp; <input name="grade" value="1" type="radio">★';
		divhtml += '</div><br><div><label>내용 </label><textarea class="form-control" name="content" rows="4" cols="100" maxlength="500" placeholder="후기를 작성해 주세요(500자 제한)">';
		divhtml += content;
		divhtml += '</textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-default" value="수정"></div>';
		divhtml += '<input type="hidden" name="serialNum" value="${requestScope.product.serialNum}"><br><br><input type="hidden" name="reviewNo" value="'+ $(this).attr('href') +'"></form>';
		$divcontent.append(divhtml);
		return false;
	});
});
function formSubmit(){
	$('form.form-inline').submit();
}

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
						<a class="reviewupdate" href="${review.reviewNo}">수정</a> <a
							class="reviewdelete" href="${review.reviewNo}">삭제</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:choose>
							<c:when test="${review.grade == 5}"> 평점 : ★★★★★</c:when>
							<c:when test="${review.grade == 4}"> 평점 : ★★★★☆</c:when>
							<c:when test="${review.grade == 3}"> 평점 : ★★★☆☆</c:when>
							<c:when test="${review.grade == 2}"> 평점 : ★★☆☆☆</c:when>
							<c:when test="${review.grade == 1}"> 평점 : ★☆☆☆☆</c:when>
						</c:choose>
					</div>

					<div style="text-align: right;">${review.createDate}</div>
					<br>
					<div class="reviewcontent">
						<span><b><pre>${review.content}</pre></b></span>
					</div>
					<br> <br> <br> <br>
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
		<legend class="scheduler-border">
			<div style="text-align: center">후기 작성하기</div>
		</legend>
		<div>
			<p>후기 작성하시면 다음 구매시에 무료로 배송해드려요</p>
			<form class="form-inline" action="note?command=reviewInsert"
				method="post">
				<div>
					평점: <input name="grade" value="5" type="radio" checked>★★★★★
					&nbsp;&nbsp;<input name="grade" value="4" type="radio">★★★★&nbsp;&nbsp;
					<input name="grade" value="3" type="radio">★★★&nbsp;&nbsp;<input
						name="grade" value="2" type="radio">★★&nbsp;&nbsp; <input
						name="grade" value="1" type="radio">★
				</div>
				<br>
				<div>
					<label>내용 </label>
					<textarea class="form-control" name="content" rows="4" cols="80"
						maxlength="500" placeholder="후기를 작성해 주세요(500자 제한)" style="resize: none;"></textarea>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="button" class="btn btn-default" value="쓰기"
						onclick="formSubmit()">
				</div>
				<input type="hidden" name="serialNum"
					value="${requestScope.product.serialNum}"> <br> <br>
			</form>
		</div>
	</fieldset>

</body>
</html>