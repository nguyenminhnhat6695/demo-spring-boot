<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
			<sec:authorize access="hasAnyAuthority('USER') and isAuthenticated()">
				<li class="nav-item active">
					<a class="nav-link" href='<c:url value="/user/" />'> Trang cửa hàng
						<span class="sr-only">(current)</span>
					</a>
				</li>
			</sec:authorize>
			
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<li class="nav-item active">
						<a class="nav-link" onclick="document.forms['logoutForm'].submit()" />Logout
						- ${pageContext.request.userPrincipal.name}
						<span class="sr-only">(current)</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>