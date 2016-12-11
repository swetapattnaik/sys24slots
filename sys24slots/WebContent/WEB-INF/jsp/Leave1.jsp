<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
    
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
      <title>Spring MVC Form Handling</title>  
     </head>  
     <body>  
      
       
       
       <c:if test="${!empty doctors}">
       
	<table align="left" border="1">
	<h2>List Doctor Table</h2>
		<tr>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>dateOfBirth</th>
			<th>dateOfJoining</th>
			<th>gender</th>
		</tr>

		<c:forEach items="${doctors}" var="doctor">
			<tr>
				
				<td><c:out value="${doctor.doctorID}"/></td>
				<td><c:out value="${doctor.doctorName}"/></td>
				<td><c:out value="${doctor.dateOfBirth}"/></td>
				<td><c:out value="${doctor.dateOfJoining}"/></td>
				<td><c:out value="${doctor.gender}"/></td>
				<td align="center"><a href="patientsuggest.html?doctorID=${doctor.doctorID}">view</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
       
       
       <br><br><br><br>
       
       
        <c:if test="${!empty leavedoc}">
		
		<table align="left" border="1">
		<h2>List Leave Table</h2>
		<tr>
			<th>leaveID</th>
			<th>doctorID</th>
			<th>leaveFrom</th>
			<th>leaveTo</th>
			<th>reason</th>
			<th>status</th>
		</tr>

		<c:forEach items="${leavedoc}" var="leavedoc1">
			<tr>
				<td><c:out value="${leavedoc1.leaveID}"/></td>
				<td><c:out value="${leavedoc1.doctorID}"/></td>
				<td><c:out value="${leavedoc1.leaveFrom}"/></td>
				<td><c:out value="${leavedoc1.leaveTo}"/></td>
				<td><c:out value="${leavedoc1.reason}"/></td>
				<td><c:out value="${leavedoc1.status}"/></td>
				
			</tr>
		</c:forEach>
	</table>
</c:if>


      
