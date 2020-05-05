<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="plugins/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/categories.css">
<link rel="stylesheet" type="text/css" href="styles/categories_responsive.css">

<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">


<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/animsition/js/animsition.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<script src="vendor/countdowntime/countdowntime.js"></script>
<script src="js/main.js"></script>

<style>
.home {
	background-color: #ebebeb;
	height: 1300px;
}

</style>

</head>
<body>

	<!-- Header -->
	<jsp:include page="header.jsp" />

	<div class="home">
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
					<br> <br> <br> <br> <br> <br>
					<form action="note?command=userJoin" method="post"
						class="login100-form validate-form flex-sb flex-w">

						<span class="login100-form-title p-b-32"> 회원 가입 하는곳 </span>

						<div class="modal fade" id="defaultModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title">알림</h4>
									</div>
									<div class="modal-body">
										<p class="modal-contents"></p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">닫기</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
						<!--// 모달창 -->
						<hr />

						<div class="wrap-input100 validate-input m-b-36" id="divId">
							<label for="inputId" class="col-lg-3 control-label">아이디</label>
							<div class="col-lg-10">
								<input type="text" class="form-control onlyAlphabetAndNumber"
									id="id" name="userId" data-rule-required="true"
									placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다."
									maxlength="30" required> 
								<input type="button" value="중복확인" name="idcheck">
							</div>
						</div>
						<div class="wrap-input100 validate-input m-b-36" id="divPassword">
							<label for="inputPassword" class="col-lg-4 control-label">패스워드</label>
							<div class="col-lg-10">
								<input type="password" class="form-control" id="password"
									name="pwd" data-rule-required="true" placeholder="패스워드"
									maxlength="30" required>
							</div>
						</div>
						<div class="wrap-input100 validate-input m-b-36"
							id="divPasswordCheck">
							<label for="inputPasswordCheck" class="col-lg-10 control-label">패스워드
								확인</label>
							<div class="col-lg-10">
								<input type="password" class="form-control" id="passwordCheck"
									data-rule-required="true" placeholder="패스워드 확인" maxlength="30" required>
								<span id="spanPasswordCheck">비밀번호 불일치</span>
							</div>
						</div>

						<div class="wrap-input100 validate-input m-b-36" id="divName">
							<label for="inputName" class="col-lg-2 control-label">이름</label>
							<div class="col-lg-10">
								<input type="text" class="form-control onlyHangul" id="name"
									name="name" data-rule-required="true"
									placeholder="한글만 입력 가능합니다." maxlength="15" required>
							</div>
						</div>



						<div class="wrap-input100 validate-input m-b-36" id="divEmail">
							<label for="inputEmail" class="col-lg-2 control-label">주소</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="email" name="addr"
									data-rule-required="true" placeholder="이메일" maxlength="40" required>
							</div>
						</div>
						<div class="wrap-input100 validate-input m-b-36"
							id="divPhoneNumber">
							<label for="inputPhoneNumber" class="col-lg-7 control-label">휴대폰
								번호</label>
							<div class="col-lg-10">
								<input type="tel" class="form-control onlyNumber"
									id="phoneNumber" name="phone" data-rule-required="true"
									placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" required>
								<input type="button" value="중복확인" name="phonecheck">
							</div>
						</div>
						<div class="wrap-input100 validate-input m-b-36">
							<label for="inputPhoneNumber" class="col-lg-2 control-label">질문</label>
							<div class="col-lg-10">

								<select id="questions" name="queNo">
									<c:forEach items="${list}" var="questions">
										<option value="${questions.queNo}">${questions.question}</option>
					`				</c:forEach>
								</select>
							</div>
						</div>

						<div class="wrap-input100 validate-input m-b-36" id="divNickname">
							<label for="inputNickname" class="col-lg-2 control-label">답변</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="nickname"
									name="answer" data-rule-required="true" 
									maxlength="15" required>
							</div>
						</div>


						<div class="container-login100-form-btn">
							<button class="login100-form-btn">가입하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<div id="dropDownSelect1"></div>


	<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$(function(){
		var idCheck = false;
		$("input[name=idcheck]").click(function() {
			// id = "id_reg" / name = "userId"
			var userId = $('#id').val();
			$.ajax({
				url : "ajax",
				data : "command=userDupId&userId=" + userId,
				success : function(jsonObj){
					var obj = JSON.parse(jsonObj);
					if(obj.status == 0){
						alert("사용 가능");
						idCheck = true;
						if(phoneCheck && idCheck && passwordCheck){
							$('button.login100-form-btn').show();
						}
					}else if(obj.status == 1){
						alert("중복된 아이디 입니다.");
						$('#id').focus();
					}else if(obj.status == 2){
						alert("아이디를 입력하세요.");
						$('#id').focus();
					}
					
				}
			})
		});
		
		$('#id').keydown(function(){
			idCheck = false;
			$('button.login100-form-btn').hide();
		})
		
		$('button.login100-form-btn').hide();
		
		$('.onlyAlphabetAndNumber').keyup(function(event){
            if (!(event.keyCode >=37 && event.keyCode<=40)) {
                var inputVal = $(this).val();
                $(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
            }
        });
        
        $(".onlyHangul").keyup(function(event){
            if (!(event.keyCode >=37 && event.keyCode<=40)) {
                var inputVal = $(this).val();
                $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
            }
        });
    
        $(".onlyNumber").keyup(function(event){
            if (!(event.keyCode >=37 && event.keyCode<=40)) {
                var inputVal = $(this).val();
                $(this).val(inputVal.replace(/[^0-9]/gi,''));
            }
        });

        $('#spanPasswordCheck').hide();
        
        var passwordCheck = false;
        $('#password').keydown(function(){
        	passwordCheck = false;
        })
        
        $('#passwordCheck').blur(function(){
        	if($('#password').val() != $('#passwordCheck').val()){
        		$(this).val("");
                $('#spanPasswordCheck').show();
        		passwordCheck = false;
				$('button.login100-form-btn').hide();
        	}else{
        		passwordCheck = true;
				if(phoneCheck && idCheck && passwordCheck){
					$('button.login100-form-btn').show();
				}
                $('#spanPasswordCheck').hide();
        	}
        });
        
        var phoneCheck = false;
        
        $("input[name=phonecheck]").click(function() {
			// id = "id_reg" / name = "userId"
			var phone = $('#phoneNumber').val();
			if(phone.length < 10){
				alert("핸드폰 번호를 확인하세요");
				$('#phoneNumber').focus();
				return;
			}
			$.ajax({
				url : "ajax",
				data : "command=userDupPhone&phone=" + phone,
				success : function(jsonObj){
					var obj = JSON.parse(jsonObj);
					if(obj.status == 0){
						alert("사용 가능");
						phoneCheck = true;
						if(phoneCheck && idCheck && passwordCheck){
							$('button.login100-form-btn').show();
						}
					}else if(obj.status == 1){
						alert("중복된 전화번호 입니다.");
						$('#phoneNumber').focus();
					}else if(obj.status == 2){
						alert("전화번호를 입력하세요.");
						$('#phoneNumber').focus();
					}
				}
			})
		});
        
		$('#phoneNumber').keydown(function(){
			phoneCheck = false;
			$('button.login100-form-btn').hide();
		});
		
		$('form').submit(function(){
			if(!(phoneCheck && idCheck && passwordCheck)){
				alert("정보를 확인하세요.");
				return false;
			}
		})
	})
		
	</script>

</body>
</html>