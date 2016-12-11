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
      <h2>Booking an Appointment</h2>  
      <f:form  action="requestAppointment.html" method="POST" commandName="appointmentBean">  
          <table>  
         
           <tr>  
               <td><f:label path="appointmentID">Appointment ID</f:label></td>  
               <td><f:input path="appointmentID" value="${appointmentBean.appointmentID}"/></td>  
            <td><f:errors path="appointmentID"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="doctorID">Doctor ID</f:label></td>  
               <td><f:input path="doctorID" value="${appointmentBean.doctorID}"/></td>  
             <td><f:errors path="doctorID"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="patientID">Patient Id</f:label></td>
               <td><f:input path="patientID" value="${appointmentBean.patientID}" /></td>  
             <td><f:errors path="patientID"></f:errors>
           </tr>  
         <tr>
          <td><f:label path="appointmentDate">Appointment Date</f:label></td>
            <td><f:input path="appointmentDate" value="${appointmentBean.appointmentDate}"/></td>  
    <td><f:errors path="appointmentDate"></f:errors>
  </tr> 
    
    <tr>  
           <td><f:label path="appointmentTime">Appointment Time</f:label></td>
            <td><f:input path="appointmentTime" value="${appointmentBean.appointmentTime}" /></td>  
    <td><f:errors path="appointmentTime"></f:errors>
  </tr> 
  
   
           <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
            </tr>  
       </table>
       </f:form>
   
</body>
</html>