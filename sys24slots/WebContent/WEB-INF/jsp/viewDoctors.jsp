<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:if test="${empty doctors}">
<h2>Doctors are not available for your request</h2>
<h1><a href=""></a></h1>
</c:if>



<c:if test="${!empty doctors}">
		<h2>Available Doctor Details:</h2>
	<table align="left" border="1">
		<tr>
		<th>Doctor ID</th>
		<th>Doctor Name</th>
		<th>Gender</th>
		<th>Qualification</th>
		<th>Years of Experience</th>
		<th>Contact Number</th>
		<th>Email ID</th>
		<th>Action</th>
		</tr>

		<c:forEach items="${doctors}" var="doctorBean">
			<tr>
				<td><c:out value="${doctorBean.doctorID}"/></td>
				<td><c:out value="${doctorBean.doctorName}"/></td>
				<td><c:out value="${doctorBean.gender}"/></td>
				<td><c:out value="${doctorBean.qualification}"/></td>
				<td><c:out value="${doctorBean.yearsOfExperience}"/></td>
				<td><c:out value="${doctorBean.contactNumber}"/></td>
				<td><c:out value="${doctorBean.emailID}"/></td>
	<td align="center"><a href="appoint.html?doctorID=${doctorBean.doctorID}&patientID=${id}&date=${date}">Book Appointment</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<br></br>
	<br></br>
	<br></br>
	<a href="PatientForm.html">Back to Menu page</a>
</body>
</html>