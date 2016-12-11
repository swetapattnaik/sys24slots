<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.sql.Date"%>
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
      <title>Doctor Details</title>  
     </head>  
     <body>
 <%%>
      <h3>Enter the Specialization details:</h3>  
      <f:form method="GET" action="view.html">  
          <table>
          <tr> <td>Specialization:</td>
          <td><input type="text" value="${patient.ailmentType}" readonly="true" name="specialization">
           </tr> 
           <tr><td>Date:</td>
         <td><input type="text" value="${patient.appointmentDate}" readonly="true" name="date"/>
          
          </tr>
           <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
           
            
            </tr>  
</table>
</f:form>
</body>
</html>