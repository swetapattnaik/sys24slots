<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
body
{
background-color:#adebeb
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
<title>All Doctors</title>
</head>
<body>
<!--
<h1>${id}</h1>
<h1>${date1}</h1>
<h1>${flag}</h1>
  -->



<form method="POST">

<c:choose>
<c:when test="${flag}">

	


<c:choose>
<c:when test="${!empty doctors1}">
<h1>Your Doctor is on leave.The Available Doctors are:</h1>
	<table align="left" border="1">
		<tr>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>Doctor DOB</th>
			<th>Doctor DOJ</th>
			<th>Gender</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${doctors1}" var="doctors2">
			<tr>
				<td><c:out value="${doctors2.doctorID}"/></td>
				<td><c:out value="${doctors2.doctorName}"/></td>
				<td><c:out value="${doctors2.dateOfBirth}"/></td>
				<td><c:out value="${doctors2.dateOfJoining}"/></td>
				<td><c:out value="${doctors2.gender}"/></td>
	<td align="center"><a href="appoint.html?doctorID=${doctors2.doctorID}&patientID=${id}&date=${date1}">Book Appointment</a></td>
			</tr>
			
			
			
		</c:forEach>
	</table>
</c:when>
<c:otherwise><h1>Your Doctor is on leave.& No Other Doctors are Available</h1></c:otherwise>
</c:choose>
</c:when>
<c:otherwise><h1>Your Appointment is Confirmed</h1></c:otherwise>







</c:choose>
</form>





</body>
</html>