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
 h2
 {
 color:#0f3d3d
 }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page</title>
</head>
<body>
<h2 align="center">Registration page</h2>
<form:form action="registration.html" commandName="profileBean" target="_parent">
<table align="center">
	
<tr>
	<td>Enter First Name:
	<td><form:input path="firstName"/>
	<form:errors path="firstName"></form:errors>
<tr>
	<td>Enter Last Name:
	<td><form:input path="lastName"/>
	<form:errors path="lastName"></form:errors>
<tr>
	<td>Enter your Date of Birth:
	<td><form:input path="dateOfBirth"/>
	<form:errors path="dateOfBirth"></form:errors>
      <tr>
        <td>Gender :</td>
        <td><form:radiobutton path="gender" value="M" label="M" checked="checked" /> 
            <form:radiobutton path="gender" value="F" label="F" /></td>
        
    </tr>
<tr>
	<td>Enter Street:
	<td><form:input path="street"/>
	<form:errors path="street"></form:errors>
<tr>
	<td>Enter location:
	<td><form:input path="location"/>
	<form:errors path="location"></form:errors>
<tr>
	<td>Enter city:
	<td><form:input path="city"/>
	<form:errors path="city"></form:errors>
<tr>
	<td>Enter State:
	<td><form:input path="state"/>
	<form:errors path="state"></form:errors>
<tr>
	<td>Enter pincode:
	<td><form:input path="pincode"/>
	<form:errors path="pincode"></form:errors>
<tr>
	<td>Enter mobileno no:
	<td><form:input path="mobileNo"/>
	<form:errors path="mobileNo"></form:errors>
<tr>
	<td>Enter EmailID:
	<td><form:input path="emailID"/>	
	<form:errors path="emailID"></form:errors>
<tr>
	<td>Enter Password:
	<td><form:input path="password"/>
	<form:errors path="password"></form:errors>
	
<tr>
	<td><input type="submit" value="Submit">
	<td><input type="reset" value="clear">
</table>
</form:form>
</body>
</html>