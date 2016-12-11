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

	<form method="GET" action="suggest.html">
<h2>Available Doctors</h2>
<c:if test="${!empty doctors1}">
	<table align="left" border="1">
		<tr>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>Doctor DOB</th>
			<th>Doctor DOJ</th>
			<th>Gender</th>
		</tr>

		<c:forEach items="${doctors1}" var="doctors2">
			<tr>
				<td><c:out value="${doctors2.doctorID}"/></td>
				<td><c:out value="${doctors2.doctorName}"/></td>
				<td><c:out value="${doctors2.city}"/></td>
				<td><c:out value="${doctors2.hospital}"/></td>
				<td><c:out value="${doctors2.gender}"/></td>
				
			</tr>
		</c:forEach>
	</table>
</c:if>

</form>
</body>
</html>