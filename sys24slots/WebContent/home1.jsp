<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="e.hospital.bean.LoginBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#adebeb">
<%LoginBean c=(LoginBean)session.getAttribute("login");
String s=c.getUserID();%>
<h3 align="left" font color="#0f3d3d"> Welcome <%=s%>!</h3>
</body>
</html>