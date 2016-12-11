ll<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

	<form method="POST" action="LoginController">
<h2>Doctors List</h2>


<c:if test="${!empty doctors1}">
	<table align="left" border="1" >
		<tr>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>Doctor DOB</th>
			<th>Doctor DOJ</th>
			<th>Gender</th>
			<th>Specialization</th>
			<th>Edit/Delete</th>
			<th>View Schedule</th>
		</tr>

		<c:forEach items="${doctors1}" var="doctors2">
			<tr>
				<td><c:out value="${doctors2.doctorID}"/></td>
				<td><c:out value="${doctors2.doctorName}"/></td>
				<td><c:out value="${doctors2.dateOfBirth}"/></td>
				<td><c:out value="${doctors2.dateOfJoining}"/></td>
				<td><c:out value="${doctors2.gender}"/></td>
				<td><c:out value="${doctors2.specialization}"/></td>
				
				<td align="center"><a href="edit.html?doctorID=${doctors2.doctorID}">Edit</a> | <a href="delete.html?doctorID=${doctors2.doctorID}">Delete</a></td>
				<td align="center"><a href="Report/viewdocschedule.html?doctorID=${doctors2.doctorID}">View schedule</a>
			</tr>
		</c:forEach>
	</table>
</c:if>
</form>
</body>
</html>