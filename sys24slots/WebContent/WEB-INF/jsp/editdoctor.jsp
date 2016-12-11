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
      <h2>Edit Doctor Record</h2>  
      <f:form  action="edit.html" method="POST" commandName="doctorBean">  
          <table>  
           
           <tr>
            <td><f:label path="doctorID">DoctorID:</f:label></td>
			<td><f:input path="doctorID" value="${doctors2.doctorID}" readonly="true"/></td>
           
          <!--   </tr>
           <tr>  
               <td><f:label path="doctorName">doctorName</f:label></td>  
               <td><f:input path="doctorName" value="${doctors2.doctorName}"/></td>  
           </tr>  
           <tr>  
               <td><f:label path="dateOfBirth">dateOfBirth</f:label></td>  
               <td><f:input path="dateOfBirth" value="${doctors2.dateOfBirth}"/></td>  
           </tr>  
           <tr>  
               <td><f:label path="dateOfJoining">dateOfJoining</f:label></td>
               <td><f:input path="dateOfJoining" value="${doctors2.dateOfJoining}" /></td>  
           </tr>  
             
             
             <tr>
        <td>Gender :</td>
        <td><f:radiobutton path="gender" value="${doctors2.gender}" label="M" /> 
            <f:radiobutton path="gender" value="${doctors2.gender}" label="F" /></td>
        
    </tr>
    <tr>
        <td>Qualification:</td>
        <td><f:select path="qualification">
            <f:option value="" label="Select" />
            <f:option value="${doctors2.qualification}" label="MBBS" />
            <f:option value="${doctors2.qualification}" label="BDS" />
            <f:option value="${doctors2.qualification}" label="M.Phil" />
              <f:option value="${doctors2.qualification}" label="MBBS,MD" />    
        </f:select></td>
       
    </tr>
    
      <tr>
        <td>specialization</td>
        <td><f:select path="specialization">
            <f:option value="" label="Select" />
            <f:option value="${doctors2.specialization}" label="Pediatric Cardiology" />
            <f:option value="${doctors2.specialization}" label="Clinical Neurophysiology" />
            <f:option value="${doctors2.specialization}" label="Forensic Pathology" />
            <f:option value="${doctors2.specialization}" label="Medical Genetics" />
            
        </f:select></td>
       
    </tr>
    
   
  <tr>  
          <td><f:label path="yearsOfExperience">yearsOfExperience</f:label></td>
            <td><f:input path="yearsOfExperience" value="${doctors2.yearsOfExperience}"/></td>  
  </tr> 
    
    <tr>  
           <td><f:label path="street">street</f:label></td>
            <td><f:input path="street" value="${doctors2.street}" /></td>  
  </tr> 
  
   <tr>  
            <td><f:label path="location">location</f:label></td> 
            <td><f:input path="location" value="${doctors2.location}" /></td>  
  </tr> 
  
   <tr>  
           <td><f:label path="city">city</f:label></td> 
            <td><f:input path="city" value="${doctors2.city}" /></td>  
  </tr> 
             
    <tr>  
           <td><f:label path="state">state</f:label></td> 
            <td><f:input path="state" value="${doctors2.state}"  /></td>  
  </tr>    
             
   <tr>  
           <td><f:label path="pincode">pin-code</f:label></td>  
            <td><f:input path="pincode" value="${doctors2.pincode}"  /></td>  
  </tr> 
  
   <tr>  
           <td><f:label path="contactNumber">contactNumber</f:label></td>   
            <td><f:input path="contactNumber"  value="${doctors2.contactNumber}" /></td>  
  </tr> 
  
     <tr>  
           <td><f:label path="emailID">EmailID:</f:label></td> 
            <td><f:input path="emailID"  value="${doctors2.emailID}" /></td> 
  </tr> 
           <tr>  
             <td colspan="2"><input type="submit" value="Submit"/></td>  
            </tr>  -->
             <tr>  
               <td><f:label path="doctorName">Doctor Name</f:label></td>  
               <td><f:input path="doctorName" value="${doctors2.doctorName}"/></td>  
           <td><f:errors path="doctorName"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="dateOfBirth">Date Of Birth(yyyy-mm-dd)</f:label></td>  
               <td><f:input path="dateOfBirth" value="${doctors2.dateOfBirth}"/></td>  
            <td><f:errors path="dateOfBirth"></f:errors>
           </tr>  
           <tr>  
               <td><f:label path="dateOfJoining">Date Of Joining(yyyy-mm-dd)</f:label></td>
               <td><f:input path="dateOfJoining" value="${doctors2.dateOfJoining}" /></td>  
            <td><f:errors path="dateOfJoining"></f:errors>
           </tr>  
             
             
             <tr>
        <td>Gender :</td>
        <td><f:radiobutton path="gender" value="M" label="M" checked="checked"/> 
            <f:radiobutton path="gender" value="F" label="F" /></td>
        
    </tr>
    <tr>
      <td>Qualification:</td>
        <td><f:select path="qualification">
         <f:option value="" label="Select"/>
            <f:option value="MBBS" label="MBBS"/>
            <f:option value="BDS" label="BDS"/>
            <f:option value="M.Phil" label="M.Phil"/>
            <f:option value="MBBS,MD" label="MBBS,MD" />
        </f:select></td>
        <td><f:errors path="qualification"></f:errors>
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
        <td><f:errors path="specialization"></f:errors>
    </tr>
    
   
  <tr>  
          <td><f:label path="yearsOfExperience">Years Of Experience</f:label></td>
            <td><f:input path="yearsOfExperience" value="${doctors2.yearsOfExperience}"/></td>  
   <td><f:errors path="yearsOfExperience"></f:errors>
  </tr> 
    
    <tr>  
           <td><f:label path="street">Street</f:label></td>
            <td><f:input path="street" value="${doctors2.street}" /></td>  
   <td><f:errors path="street"></f:errors>
  </tr> 
  
   <tr>  
            <td><f:label path="location">Location</f:label></td> 
            <td><f:input path="location" value="${doctors2.location}" /></td>  
   <td><f:errors path="location"></f:errors>
  </tr> 
  
   <tr>  
           <td><f:label path="city">City</f:label></td> 
            <td><f:input path="city" value="${doctors2.city}" /></td>  
   <td><f:errors path="city"></f:errors>
  </tr> 
             
    <tr>  
           <td><f:label path="state">State</f:label></td> 
            <td><f:input path="state" value="${doctors2.state}"  /></td>  
   <td><f:errors path="state"></f:errors>
  </tr>   
             
   <tr>  
           <td><f:label path="pincode">Pin-code</f:label></td>  
            <td><f:input path="pincode" value="${doctors2.pincode}"  /></td>  
   <td><f:errors path="pincode"></f:errors>
  </tr> 
  
   <tr>  
           <td><f:label path="contactNumber">Contact Number</f:label></td>   
            <td><f:input path="contactNumber"  value="${doctors2.contactNumber}" /></td>  
   <td><f:errors path="contactNumber"></f:errors>
  </tr> 
  
     <tr>  
           <td><f:label path="emailID">EmailID:</f:label></td> 
            <td><f:input path="emailID"  value="${doctors2.emailID}" /></td> 
   <td><f:errors path="emailID"></f:errors>
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
