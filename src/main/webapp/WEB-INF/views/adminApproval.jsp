<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Approval</title>
</head>
<body>

<%
	ArrayList<String> list=(ArrayList<String>)application.getAttribute("topicApprovalRequests");
	session.setAttribute("approvalList",list);
%>
<h1>Topics for Approvals</h1>
<table>
<form action="approvals" method="post">
<c:forEach var="e" items="${sessionScope.approvalList}">
		<tr>
			<td>${e}</td>			
			<td><input type="radio" name="check" value="yes"/>Yes</td>
			<td><input type="radio" name="check" value="no"/>No</td>						
		</tr>
		<tr><td><input type="submit"/></td></tr>
</c:forEach>
</form>		
</table>
</body>
</html>