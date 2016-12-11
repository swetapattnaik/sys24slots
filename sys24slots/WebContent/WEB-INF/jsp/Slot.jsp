<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


</head>
<body>

	<form method="POST" action="LoginController">
<h2>Slot List</h2>


<c:if test="${!empty slot}">
	<table align="left" border="1">
		<tr>
			<th>slot no</th>
			<th>slotduration</th>
		
		</tr>

		<c:forEach items="${slot}" var="slot1">
			<tr>
				<td><c:out value="${slot1.slotnumber}"/></td>
				<td><c:out value="${slot1.slotduration}"/></td>
				
				
			</tr>
		</c:forEach>
	</table>
</c:if>
</form>
</body>
</html>












