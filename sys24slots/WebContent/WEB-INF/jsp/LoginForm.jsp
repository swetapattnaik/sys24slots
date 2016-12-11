<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style>
body {
    background-color: #adebeb;
}
.cursor1:hover
{
	background-color:blue
	
}
form{
	background-color:#d6f5f5;
}
 h1
 {
 color:#0f3d3d
 }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Login Form</h1>
<form:form action="login.htm" method="post" commandName="credentialsBean" target="_parent">
<table align="center" width="400">
<tr>
	<td>Enter UserName:
	<td><form:input path="userID"/>
	<form:errors path="userID"></form:errors>
<tr>
	<td>Enter password:
	<td><form:password path="password"/>
	<form:errors path="password"></form:errors>
	
<tr>
	<td><input type="submit" value="submit">
	<td><input type="reset" value="reset">
	<tr>
	<td><a href="register.htm">New User?Register Here</a>
</table>
</form:form>
</body>
</html>