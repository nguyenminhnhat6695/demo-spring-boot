
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasAnyAuthority('USER') and isAuthenticated()">
	<c:redirect url="/user/" />
</sec:authorize>
<sec:authorize access="hasAnyAuthority('ADMIN') and isAuthenticated()">
	<c:redirect url="/admin/medicine-list?page=1" />
</sec:authorize>
