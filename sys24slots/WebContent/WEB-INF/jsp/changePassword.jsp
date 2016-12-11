<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="e.hospital.bean.LoginBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.cursor1:hover {
	background-color: blue
}
h2 {
	color: #0f3d3d
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		LoginBean cb = (LoginBean) session.getAttribute("login");
		String userName = cb.getUserID();
	%>

	<h2 align="center">Change Password</h2>
	<form:form action="changePassword.html" method="post">
		<table>
			<tr>
				<td>Enter UserName:
				<td><form:input path="userID" value="<%=userName%>"
						readonly="true" />
			<tr>
				<td>Enter old password:
				<td><form:password path="password" />
			<tr>
				<td>Enter new password:
				<td><input type="password" name="newpassword" />
			<tr>
				<td><input type="submit" value="submit">
				<td><input type="reset" value="reset">
		</table>
	</form:form>
</body>
</html>