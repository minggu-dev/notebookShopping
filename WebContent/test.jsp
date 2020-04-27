<%@page import="notebook.controller.cart.CartUpdateController"%>
<%@page import="notebook.controller.purchase.PurSelectUserController"%>
<%@page import="notebook.controller.purchase.PurDetailController"%>
<%@page import="notebook.controller.purchase.PurSelectAllController"%>
<%@page import="notebook.controller.purchase.PurRefundStateController"%>
<%@page import="notebook.controller.purchase.PurRefundController"%>
<%@page import="notebook.controller.purchase.PurDeliveryStateController"%>
<%@page import="notebook.controller.purchase.PurInsertController"%>
<%@page import="notebook.controller.purchase.PurDeliveryController"%>
<%@page import="notebook.controller.product.ProUpdateController"%>
<%@page import="notebook.controller.product.ProShowDetailController"%>
<%@page import="notebook.controller.product.ProSelectByPriceRangeController"%>
<%@page import="notebook.controller.product.ProSelectAllSortController"%>
<%@page import="notebook.controller.product.ProSearchController"%>
<%@page import="notebook.controller.product.ProInsertController"%>
<%@page import="notebook.controller.product.ProHomeController"%>
<%@page import="notebook.controller.user.UserIdQuestionFindController"%>
<%@page import="notebook.controller.user.UserDuplicatePhoneController"%>
<%@page import="notebook.controller.user.UserWithdrawalController"%>
<%@page import="notebook.controller.user.UserShowDetailController"%>
<%@page import="notebook.controller.user.UserModifyController"%>
<%@page import="notebook.controller.user.UserJoinController"%>
<%@page import="notebook.domain.Users"%>
<%@page import="java.util.List"%>
<%@page import="notebook.controller.Controller"%>
<%@page import="notebook.controller.user.UserAllController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>테스트 페이지</h1>
<%
	Controller con = null;
// 	con = new UserJoinController();
// 	con.handleRequest(request, response);

// 	con = new UserAllController();
// 	con.handleRequest(request, response);
// 	List<Users> list = (List<Users>)request.getAttribute("list");
// 	for(Users user : list){
// 		out.print(user.getName());
// 	}
// 	con = new UserModifyController();
// 	con.handleRequest(request, response);
	
// 	con = new UserShowDetailController();
// 	con.handleRequest(request, response);
// 	Users user = (Users)request.getAttribute("user");	
// 	out.print(user.getName());

// 	con = new UserWithdrawalController();
// 	con.handleRequest(request, response);

// 	con = new UserDuplicatePhoneController();
// 	con.handleRequest(request, response);
	
// 	con = new UserFindController();
// 	con.handleRequest(request, response);
	
// 	con = new ProHomeController();
// 	con.handleRequest(request, response);
	
// 	con = new ProInsertController();
// 	con.handleRequest(request, response);

// 	con = new ProSearchController();
// 	con.handleRequest(request, response);

// 	con = new ProSelectAllSortController();
// 	con.handleRequest(request, response);

// 	con = new ProSelectByPriceRangeController();
// 	con.handleRequest(request, response);
	
	con = new ProShowDetailController();
	con.handleRequest(request, response);

// 	con = new ProUpdateController();
// 	con.handleRequest(request, response);

// 	con = new PurInsertController();
// 	con.handleRequest(request, response);

// 	con = new PurDeliveryController();
// 	con.handleRequest(request, response);

// 	con = new PurDeliveryStateController();
// 	con.handleRequest(request, response);
	
// 	con = new PurRefundStateController();
// 	con.handleRequest(request, response);

// 	con = new PurSelectAllController();
// 	con.handleRequest(request, response);
	
// 	con = new PurSelectProductController();
// 	con.handleRequest(request, response);

// 	con = new PurSelectUserController();
// 	con.handleRequest(request, response);
	
// 	con = new PurRefundController();
// 	con.handleRequest(request, response);

// 	con = new CartUpdateController();
// 	con.handleRequest(request, response);
%>

<!-- <form action="note?command=proInsert" method="post" enctype="multipart/form-data"> -->
<!-- 	<input type="text" name="modelName"> -->
<!-- 	<input type="text" name="company"> -->
<!-- 	<input type="number" name="price"> -->
<!-- 	<input type="number" name="ram"> -->
<!-- 	<input type="text" name="cpu"> -->
<!-- 	<input type="number" name="noteSize"> -->
<!-- 	<input type="text" name="noteWeight"> -->
<!-- 	<input type="text" name="launchDate"> -->
<!-- 	<input type="file" name="imgName"> -->
<!-- 	<input type="file" name="descriptionImgName"> -->
<!-- 	<input type="submit"> -->
<!-- </form> -->

</body>
</html>