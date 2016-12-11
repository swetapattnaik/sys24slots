<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="e.hospital.bean.LoginBean"%>

<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<style>
div.container1 {
	margin: auto;
	width: 60%;
	border: 3px solid #73AD21;
	padding: 10px;
}

header, footer {
	padding: 1em;
	color: white;
	background-color: black;
	clear: left;
	text-align: center;
}

nav {
	float: left;
	max-width: 10px;
	margin: 0;
	padding: 1em;
}

nav ul {
	list-style-type: none;
	padding: 0;
}

nav ul a {
	text-decoration: none;
}

article {
	margin-left: 170px;
	border-left: 1px solid gray;
	padding: 1em;
	overflow: hidden;
}
</style>
</head>
<body>

	<%
	LoginBean cb = (LoginBean) session.getAttribute("login");
	String userName = cb.getUserID();
		System.out.println(cb);
	%>

	<div class="container" ng-app="myApp">
		<div class="jumbotron" ng-controller="myCtrl">
			<h1>Welcome <%=userName %></h1>
			<div>
				<table>
					<tr>
						<th>City
						<th>Hospital
						<th>Specialization
						<th>
						<th>Qualification
					</tr>
					<tr>
						<td><select ng-model="city"
							ng-options="cities for cities in cityList"></select>
						<td><select ng-model="hospital"
							ng-options="hospitals for hospitals in hospitalList"></select>
						<td><select ng-model="specialization"
							ng-options="specializations for specializations in specializationList"></select>
						<td>
						<td><select ng-model="qualification"
							ng-options="qualifications for qualifications in qualificationList"></select>
					</tr>
				</table>
			</div>
			<c:if test="${not empty doctors}">
				<c:forEach var="listValue" items="${doctors}">
					<div
						ng-if="(city =='${listValue.city}' || !city) && (hospital=='${listValue.hospital}' || !hospital) && (specialization=='${listValue.specialization}' || !specialization) && (qualification=='${listValue.qualification}' || !qualification)">
						<div class="container1">

							<header>
								<h2>${listValue.doctorName}</h2>
							</header>

							<nav>
								<a
									href="appoint.htm?doctorID=${listValue.doctorID}&patientID=<%=userName%>&date=${date1}">Book
									Appointment</a>
									
							</nav>

							<article>
								<h2>Hospital--> ${listValue.hospital}</h2>
								<p>City- ${listValue.city}</p>
								<p>${listValue.specialization}(${listValue.qualification})</p>
								<p>${listValue.yearsOfExperience}-YearsOfExperience</p>
							</article>

							<footer>Email-${listValue.emailID}</footer>

						</div>
					</div>
				</c:forEach>


			</c:if>
		</div>
	</div>

</body>
</html>
