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
<script type="text/javascript" src="js//registration.js"></script>
<title>Register Candidate</title>
</head>
<body>
	<sec:authorize access="hasRole('HR_Executive')">
		<div>
			<form:form action="saveCandidate.do" method="post"
				modelAttribute="Registration" enctype="multipart/form-data">
				<h4>Register new Candidate</h4>
				<table>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" id="firstName"
								maxlength="30" /></td>
						<td><form:errors path="firstName" cssClass="error"></form:errors></td>
						<form:hidden path="registrationId" />
						<form:hidden path="createdDate"/>
						
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" id="lastName" maxlength="30" /></td>
						<td><form:errors path="lastName" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Email Id:</label></td>
						<td><form:input path="emailId" id="emailId" maxlength="30"/></td>
						<td><form:errors path="emailId" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Primary Mobile No.:</label></td>
						<td><form:input path="primaryMobileNo" id="primaryMobileNo"
								maxlength="10" /></td>
						<td><form:errors path="primaryMobileNo" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Secondary Mobile No.:</label></td>
						<td><form:input path="secondaryMobileNo"
								id="secondaryMobileNo" maxlength="10" /></td>
						<td><form:errors path="secondaryMobileNo" cssClass="error"></form:errors></td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" id="city"
								maxlength="30" /></td>
						<td><form:errors path="city" cssClass="error"></form:errors></td>
					</tr>
					
					<tr>
						<td><label>Present Address:</label></td>
						<td><form:textarea path="presentAddress" id="presentAddress"
								maxlength="140" /></td>
						<td><form:errors path="presentAddress" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Permanent Address:</label></td>
						<td><form:textarea path="permanentAddress"
								id="permanentAddress" maxlength="140" /></td>
						<td><form:errors path="permanentAddress" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Gender:</label></td>
						<td><form:radiobutton path="gender" value="M" />Male</td>
						<td><form:radiobutton path="gender" value="F" />Female</td>
						<td><form:errors path="gender" cssClass="error"></form:errors></td>

					</tr>
					<tr>
						<td><label>Open Position:</label></td>
						<td><form:select path="skills.skillsId">
								<form:option value="0" label="Select" />
								<c:forEach items="${skillList}" var="skillList">
									<form:option value="${skillList.skillsId}"
										label="${skillList.skills}" />
								</c:forEach>

							</form:select></td>
						<td><form:errors path="skills.skillsId" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Experience:</label></td>
						<td><form:input path="experience" id="experience"
								maxlength="3" onkeypress="return num(evt, e);" />in months</td>
						<td><form:errors path="experience" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Consultancy Name:</label></td>
						<td><form:input path="consultancyName" id="consultancyName"
								maxlength="15" /></td>
						<td><form:errors path="consultancyName" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td>Select Resume : <input type="file" path="resumeName"
							name="fileUpload" id="fileUpload" />
						</td>
						<%-- <td><form:errors path="resumeName" cssClass="error"></form:errors></td> --%>
					</tr>
					<tr>
						<td><input type="Submit" value="Register" size="200" ></td>
					</tr>
				</table>
			</form:form>
		</div>
	</sec:authorize>
</body>
</html>