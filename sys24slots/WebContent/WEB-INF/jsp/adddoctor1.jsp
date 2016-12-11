    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <html>  
     <head>  
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
      <title>Spring MVC Form Handling</title>  
     </head>  
     <body>  
      <h2>Add Doctor Record</h2>  
      <f:form  action="add.html" method="POST" commandName="addDoctor1">  
          <table>  
           
           <tr>
            <td><f:label path="doctorID">doctorID:</f:label></td>
			<td><f:input path="doctorID" value="${employee.doctorID}" readonly="true"/></td>
           
           </tr>
           <tr>  
               <td><f:label path="doctorName">doctorName</f:label></td>  
               <td><f:input path="doctorName" value="${employee.doctorName}"/></td>  
           </tr>  
           <tr>  
               <td><f:label path="dateOfBirth">dateOfBirth</f:label></td>  
               <td><f:input path="dateOfBirth" value="${employee.dateOfBirth}"/></td>  
           </tr>  
           <tr>  
               <td><f:label path="dateOfJoining">dateOfJoining</f:label></td>
               <td><f:input path="dateOfJoining" value="${employee.dateOfJoining}" /></td>  
           </tr>  
             
             
             <tr>
        <td>Gender :</td>
        <td><f:radiobutton path="gender" value="M" label="M" /> 
            <f:radiobutton path="gender" value="F" label="F" /></td>
        
    </tr>
    <tr>
        <td>Qualification:</td>
        <td><f:select path="qualification">
         <f:option value="" label="Select"/>
            <f:option value="" label="MBBS"/>
            <f:option value="1" label="BDS"/>
            <f:option value="2" label="M.Phil"/>
            <f:option value="3" label="MBBS,MD" />
        </f:select></td>
       
    </tr>
    
      <tr>
     <td>Specialization:</td>
         <td><f:select path="specialization">
            <f:option value="" label="Select"/>
            <f:option value="Pediatric Cardiology" label="Pediatric Cardiology"/>
            <f:option value="Clinical Neurophysiology" label="Clinical Neurophysiology"/>
            <f:option value="Forensic Pathology" label="Forensic Pathology"/>
            <f:option value="Medical Genetics" label="Medical Genetics"/>
        </f:select></td>
       
    </tr>
    
   
  <tr>  
          <td><f:label path="yearsOfExperience">yearsOfExperience</f:label></td>
            <td><f:input path="yearsOfExperience" value="${employee.yearsOfExperience}"/></td>  
  </tr> 
    
    <tr>  
           <td><f:label path="street">street</f:label></td>
            <td><f:input path="street" value="${employee.street}" /></td>  
  </tr> 
  
   <tr>  
            <td><f:label path="location">location</f:label></td> 
            <td><f:input path="location" value="${employee.location}" /></td>  
  </tr> 
  
   <tr>  
           <td><f:label path="city">city</f:label></td> 
            <td><f:input path="city" value="${employee.city}" /></td>  
  </tr> 
             
    <tr>  
           <td><f:label path="state">state</f:label></td> 
            <td><f:input path="state" value="${employee.state}"  /></td>  
  </tr>    
             
   <tr>  
           <td><f:label path="pincode">pin-code</f:label></td>  
            <td><f:input path="pincode" value="${employee.pincode}"  /></td>  
  </tr> 
  
   <tr>  
           <td><f:label path="contactNumber">contactNumber</f:label></td>   
            <td><f:input path="contactNumber"  value="${employee.contactNumber}" /></td>  
  </tr> 
  
     <tr>  
           <td><f:label path="emailID">EmailID:</f:label></td> 
            <td><f:input path="emailID"  value="${employee.emailID}" /></td> 
  </tr> 
           <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
            </tr>  
       </table>
       
       
       
       
       
       
       
        <c:if test="${!empty employees}">
		<h2>List Employees</h2>
		<table align="left" border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.doctorID}"/></td>
				<td><c:out value="${employee.doctorName}"/></td>
				<td><c:out value="${employee.dateOfBirth}"/></td>
				<td><c:out value="${employee.dateOfJoining}"/></td>
				<td><c:out value="${employee.gender}"/></td>
				<td align="center"><a href="edit.html?doctorID=${employee.doctorID}">Edit</a> | <a href="delete.html?doctorID=${employee.doctorID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

      </f:form>  
