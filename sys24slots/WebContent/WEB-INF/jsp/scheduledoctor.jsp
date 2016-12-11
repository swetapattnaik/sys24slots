<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <html>  
     <head> 
        <style>

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
      <h2>Add Schedule Record</h2>  
      <f:form  action="addschedule.html" method="POST" commandName="scheduleBean">  
          <table>  
            
           <tr>
            <td><f:label path="doctorID">Doctor ID:</f:label></td>
			<td><f:input path="doctorID"  value="${schedule.doctorID}"/></td>
            <td><f:errors path="doctorID"></f:errors>
           </tr>
           
           <tr>  
               <td><f:label path="availableDays">Available Days</f:label></td>  
               <td><f:input path="availableDays" value="${schedule.availableDays}"/></td>  
           <td><f:errors path="availableDays"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="slots">Slots</f:label></td>
               <td><f:input path="slots" value="${schedule.slots}" /></td>  
           <td><f:errors path="slots"></f:errors>
           </tr>  
    
   
  
           <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
            </tr>  
       </table>
       
       
       
       <c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>ScheduleID</th>
			<th>Doctor ID</th>
			<th>availableDays</th>
			<th>slots</th>
			
			
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.scheduleID}"/></td>
				<td><c:out value="${employee.doctorID}"/></td>
				<td><c:out value="${employee.availableDays}"/></td>
				<td><c:out value="${employee.dateOfJoining}"/></td>
				<td><c:out value="${employee.slots}"/></td>
				<td align="center"><a href="view.html?doctorID=${employee.doctorID}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
       
       
       
        <c:if test="${!empty doctor}">
		<h2>List Employees</h2>
		<table align="left" border="1">
		<tr>
			<th>leaveID</th>
			<th>doctorID</th>
			<th>leaveFrom</th>
			<th>leaveTo</th>
			<th>reason</th>
			<th>status</th>
		</tr>

		<c:forEach items="${doctor}" var="employee">
			<tr>
				<td><c:out value="${employee.leaveID}"/></td>
				<td><c:out value="${employee.doctorID}"/></td>
				<td><c:out value="${employee.leaveFrom}"/></td>
				<td><c:out value="${employee.leaveTo}"/></td>
				<td><c:out value="${employee.reason}"/></td>
				<td><c:out value="${employee.status}"/></td>
				<td align="center"><a href="edit.html?doctorID=${employee.doctorID}">Edit</a> | <a href="delete.html?doctorID=${employee.doctorID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

      </f:form>  
