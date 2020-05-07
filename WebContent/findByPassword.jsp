<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.setHeader("Cache-Control", "no-store"); %>    
<!DOCTYPE html>
<html>
<head>
<title>Login V14</title>
<meta charset="UTF-8">
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

	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>
<title>Insert title here</title>
<style>
.home{
	background-color: #ebebeb;
	height: 1000px;
}
</style>

<script>

</script>
</head>
<body>

<div class="super_container">
<!-- Header -->
<jsp:include page="header.jsp"/>
<%String id = request.getParameter("userId"); %>
<div class="home">
<div class="container" style="position: relative;">
     <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form action="note?command=userPwdQuestion" class="login100-form validate-form flex-sb flex-w" method="post">
					<span class="login100-form-title p-b-32">
						비밀번호 찾는곳
					</span>

					<span class="txt1 p-b-11">
						아이디
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
						<input class="input100" type="text" name="userId" >
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						이름
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "name is required">
						<input class="input100" type="text" name="name" >
		
					</div>
					
					<span class="txt1 p-b-11">
						폰번호
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "name is required">
						<input class="input100" type="text" name="phone" >
		
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							다음으로
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
    </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
    
</div>
</body>
</html>