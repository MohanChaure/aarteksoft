<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<title>Schedule Candidate</title>
</head>
<body>
	<sec:authorize access="hasRole('HR_Executive')">
		<div>
			<form:form action="saveScheduledCandidate.do" method="post"
				modelAttribute="Schedule" enctype="multipart/form-data">
				<h4>Schedule Candidate</h4>
				<c:forEach var="user" items="${scheduledCandidateDetails}"
					varStatus="status">
					<table>
						<tr>
							<td><label>Candidate Name:</label></td>
							<td><input type="text"
								value="${user.firstName} ${user.lastName} " readonly="readonly"
								size="22" /></td>
						</tr>
						<tr>
							<td><label>Candidate Email Id:</label></td>
							<td><input type="text" value="${user.emailId}"
								readonly="readonly" size="22" /></td>
						</tr>
						<tr>
							<td><label>Candidate Mobile No.:</label></td>
							<td><input type="text" value="${user.primaryMobileNo}"
								readonly="readonly" size="22" /></td>
						</tr>
						<tr>
							<td><label>Candidate Skill:</label></td>
							<td><input type="text" value="${user.skills.skills}"
								readonly="readonly" size="22" /></td>
						</tr>
						<tr>
							<td><label>Date & Time From:</label></td>
							<td><form:input path="dateTimeFrom" id="datetimepicker" value=""
									size="22" /></td>
						</tr>
						<tr>
							<td><label>Date & Time To:</label></td>
							<td><form:input path="dateTimeTo" id="datetimepickersecond"
									value="" size="22" /></td>
						</tr>

						<tr>
							<td><label>Interviewer</label></td>
							<td><form:select path="interviewer.interviewerId"
									id="interviewer">
									<form:option value="select" label="Select" />
									<c:forEach items="${interviewerList}" var="interviewer">
										<form:option value="${interviewer.interviewerId}"
											label="${interviewer.interviewerFirstName } ${interviewer.interviewerLastName }" />
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><input type="Submit" value="Save" style="height: 26px"
								width="70px"></td>
						</tr>
					</table>
				</c:forEach>
			</form:form>
		</div>
	</sec:authorize>
</body>
<script src="/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="jquery.datetimepicker.css">
<script src="jquery.datetimepicker.js"></script>
<script type="text/javascript">
jQuery('#datetimepicker').datetimepicker();
jQuery('#datetimepickersecond').datetimepicker();
</script>
</html>