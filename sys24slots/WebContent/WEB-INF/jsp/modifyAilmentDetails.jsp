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
      <h3>Modify your Ailment Details:-</h3>  
      <form:form method="POST" action="modify1.html" commandName="patientBean">  
          <table>
          <tr>  
               <td><form:label path="userID">User ID:</form:label></td>
			   <td><form:input path="userID" value="${patientBean.userID}"/></td>  
           <td><form:errors path="userID"></form:errors>
           </tr>  
          <tr>  
               <td><form:label path="patientID">Patient ID:</form:label></td>
			   <td><form:input path="patientID" value="${patientBean.patientID}"/></td>  
            <td><form:errors path="patientID"></form:errors>
           </tr> 
           <tr>  
               <td><form:label path="appointmentDate">Appointment Date:</form:label></td>
			   <td><form:input path="appointmentDate" value="${patientBean.appointmentDate}"/></td>  
           <td><form:errors path="appointmentDate"></form:errors>
           </tr> 
                    <tr>
   <td>Ailment Type</td>
        <td><form:select path="ailmentType">
            <form:option value="" label="Select"/>
            <form:option value="Pediatric Cardiology" label="Pediatric Cardiology"/>
            <form:option value="Clinical Neurophysiology" label="Clinical Neurophysiology"/>
            <form:option value="Forensic Pathology" label="Forensic Pathology"/>
            <form:option value="Medical Genetics" label="Medical Genetics"/>
        </form:select></td>
        <td><form:errors path="ailmentType"></form:errors>
    </tr>
           <tr>  
               <td><form:label path="ailmentDetails">Ailment Details:</form:label></td>
			   <td><form:input path="ailmentDetails" value="${patientBean.ailmentDetails}"/></td>  
           <td><form:errors path="ailmentDetails"></form:errors>
           </tr>   
             <tr>  
               <td><form:label path="diagnosisHistory">Diagnosis History:</form:label></td>
			   <td><form:input path="diagnosisHistory" value="${patientBean.diagnosisHistory}"/></td>  
           <td><form:errors path="diagnosisHistory"></form:errors>
           </tr> 
          
           <tr>  
             <td colspan="2"><input type="submit" value="Modify"/></td>  
           
            
            </tr>  
       </table>   
      </form:form> 
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
				<td align="center"><a href="modify.html?patientID=${patientBean.patientID}">Modify</a></td>
			<td align="center"><a href="viewListOfDoctors.html?patientID=${patientBean.patientID}">View Available Doctor List</a></td>
			
			
			
			</tr>
		</c:forEach>
	</table>
</c:if>

<br></br>
	<br></br>
	<br></br>
	<a href="addAilmentDetails.html">Back</a>
</body>
</html>