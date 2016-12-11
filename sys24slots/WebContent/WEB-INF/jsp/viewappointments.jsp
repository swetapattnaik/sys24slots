<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
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
      <title>Patient Ailment Details</title>  
     </head>  
     <body> 
      <h2>Ailment Details:-</h2>  
    
       <c:if test="${!empty patientAilments}">
		<h2>Your Ailment Details:</h2>
	<table align="left" border="1">
		<tr>
		<th>User ID</th>
		<th>Patient ID</th>
		<th>Appointment Date</th>
		<th>Ailment Type</th>
		<th>Ailment Details</th>
		<th>Diagnosis History</th>
		</tr>

		<c:forEach items="${patientAilments}" var="patientBean">
			<tr>
				<td><c:out value="${patientBean.userID}"/></td>
				<td><c:out value="${patientBean.patientID}"/></td>
				<td><c:out value="${patientBean.appointmentDate}"/></td>
				<td><c:out value="${patientBean.ailmentType}"/></td>
				<td><c:out value="${patientBean.diagnosisHistory}"/></td>
			
			<td align="center"><a href="ViewAppintmentDetails.html?patientID=${patientBean.patientID}&appointmentDate=${patientBean.appointmentDate}">View AppointmentDetails List</a></td>
			
			
			
			</tr>
		</c:forEach>
	</table>
</c:if>


</body>
</html>