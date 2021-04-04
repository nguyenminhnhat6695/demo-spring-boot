<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
      <link href="${contextPath}/template/admin/assets/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form method="POST" action="${contextPath}/login">
					<span>${message}</span>
					<div class="form-group ${error != null ? 'has-error' : ''}">
					
						<input type="text" class="form-control" id="username" name="username"
							placeholder="Tên đăng nhập" value="admin">
					</div>

					<div class="form-group ${error != null ? 'has-error' : ''}">
						<input type="password" class="form-control" id="password" name="password"
							placeholder="Mật khẩu" value="123456">
					</div>
					<span>${error}</span>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button type="submit" class="btn btn-primary" >Đăng nhập</button>
					<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
				</form>
			</div>
		</div>
	</div>
</body>
</html>