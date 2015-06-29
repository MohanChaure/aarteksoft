<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<sec:authorize access="hasRole('HR_Executive')">
		<h2>Welcome, HR-Executive</h2>
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				<a href="getRegistrationPage">Register New Candidate</a>
			</h2>

			<h2>
				<a href="viewCandidates">ViewCandidates</a>
			</h2>

			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

	</sec:authorize>
	<sec:authorize access="hasRole('HR_Manager')">
		<!-- For login user -->
		<h2>Welcome, HR-Manager</h2>
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">

			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

	</sec:authorize>
</body>
</html>