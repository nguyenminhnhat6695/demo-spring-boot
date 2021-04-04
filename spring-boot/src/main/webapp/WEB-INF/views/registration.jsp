<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/template/admin/assets/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/template/admin/assets/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="username"
                               ></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password_confirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password_confirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="password_confirm"></form:errors>
                </div>
            </spring:bind>

			<sec:authorize access="isAuthenticated()">
				<spring:bind path="roles">
					<input type="hidden" name="roles" value="1"/>
				</spring:bind>
			</sec:authorize>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/template/admin/assets/js/bootstrap.min.js"></script>
  </body>
</html>