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

<title>All Available Doctors</title>
</head>
<body>

	<form method="GET" action="viewPatients1.html">

<table>
<tr>
<td>Enter Date(yyyy-mm-dd):
<td><input type="text" name="pdate">
<tr>
<td><input type="submit" value="submit">
</table>
<c:if test="${!empty patient }">
		<table align="left" border="1">
		
		<tr>
			<th>patientID</th>
			<th>userID</th>
			<th>appointmentDate</th>
			<th>ailmentType</th>
			<th>ailmentDetails</th>
		</tr>
		
			<tr>
				<td><c:out value="${patient.patientID}"/></td>
				<td><c:out value="${patient.userID}"/></td>
				<td><c:out value="${patient.appointmentDate}"/></td>
				<td><c:out value="${patient.ailmentType}"/></td>
				<td><c:out value="${patient.ailmentDetails}"/></td>
				</table>
</c:if>
<c:if test="${!empty appoint }">
	<table align="left" border="1">
		<tr>
			<th>appointmentID</th>
			<th>doctorID</th>
			<th>patientID</th>
			<th>appointmentDate</th>
			<th>appointmentTime</th>
		</tr>

		
			<tr>
				<td><c:out value="${appoint.appointmentID}"/></td>
				<td><c:out value="${appoint.doctorID}"/></td>
				<td><c:out value="${appoint.patientID}"/></td>
				<td><c:out value="${appoint.appointmentDate}"/></td>
				<td><c:out value="${appoint.appointmentTime}"/></td>
				
			</tr>
	
	</table>
	</c:if>


</form>
</body>
</html>