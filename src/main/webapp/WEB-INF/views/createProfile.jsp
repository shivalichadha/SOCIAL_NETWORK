<%--<%@ include file="header.jsp" --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.error:{color:red;font-size:10px}
</style>

<body>
<form:form method="POST" commandName="profile"  action="addProfile" enctype="multipart/form-data">
		<table>
			<tr>
				<td><img src="http://placehold.it/140x100"></td>
			</tr>			
			<tr>
				<td>Name:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>ContactNo:</td>
				<td><form:input path="contact" /></td>
				<td><form:errors path="contact" cssClass="error" /></td>
			</tr>
			<tr>
				<td>dob:</td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:input path="gender" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Qualification:</td>
				<td><form:input path="education" /></td>
				<td><form:errors path="education" cssClass="error" /></td>
			</tr>			
			<tr>
				
				<td><form:input type="file" path="profilePhoto" /></td>
				
			</tr>
						
			<tr>
				<td colspan="3"><input type="submit" value="Submit"></td>
			</tr>
		</table>

</form:form>

<%@ include file="footer.jsp" %>
</body>