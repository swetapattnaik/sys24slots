<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="viewdoc.html" method="GET">
<table>
<tr>
<td>Enter Date(yyyy-mm-dd):
            <td><input name="fieldName" type="text" />
            </td>
            </tr>
            
            
   <tr>  
   
   <tr>
   <td>Enter status(either 0 or 1):
            <td><input name="status" type="text" />
            </td>
            </tr>
            
            
   <tr> 
   
   
        <td colspan="2"><input type="submit" value="Submit"/></td>  
    </tr>  
            
</table>
            
            </form>
</body>
</html>