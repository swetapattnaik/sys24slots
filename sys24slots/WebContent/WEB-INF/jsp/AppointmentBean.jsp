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
      <title>Appointment</title>  
     </head>  
     <body>  
      <h2>Appointment Details</h2>  
      <f:form  action="appointment.html" method="POST" commandName="appointmentBean">  
          <table>  
         
           <tr>  
               <td><f:label path="appointmentID">Appointment ID</f:label></td>  
               <td><f:input path="appointmentID" value="${appoint.appointmentID}" readonly="true"/></td>  
            <td><f:errors path="appointmentID"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="doctorID">Doctor ID</f:label></td>  
               <td><f:input path="doctorID" value="${appoint.doctorID}" readonly="true"/></td>  
             <td><f:errors path="doctorID"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="patientID">Patient Id</f:label></td>
               <td><f:input path="patientID" value="${appoint.patientID}" readonly="true"/></td>  
             <td><f:errors path="patientID"></f:errors>
           </tr>  
         <tr>
          <td><f:label path="appointmentDate">Apointment Date</f:label></td>
            <td><f:input path="appointmentDate" value="${appoint.appointmentDate}"/></td>  
    <td><f:errors path="appointmentDate"></f:errors>
  </tr> 
    
    <tr>  
           <td><f:label path="appointmentTime">Apointment Time</f:label></td>
            <td><f:input path="appointmentTime" value="${appoint.appointmentTime}" /></td> 
              <td><a href="Slots.html?ID=${appoint.doctorID}&date=${appoint.appointmentDate}"><b>View Available Slots<b></b></a> 
    <td><f:errors path="appointmentTime"></f:errors>
  </tr> 
  
  
  <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
            </tr>  
  
  
  
   </table>
       
       
       
       </f:form>
       
   
       
   
</body>
</html>