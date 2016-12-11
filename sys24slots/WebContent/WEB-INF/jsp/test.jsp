<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body ng-app="controllers">
welcome to trst jsp page just to check
<div ng-controller="FooController">
<c:out value="${doctors}"/>
 <select ng-model="detail" ng-options="doctor.city for doctor in doctors">
</select> 

</div>
<script type="text/javascript">
angular.module("controllers",[])
.controller("FooController",
  function($scope, $window) {
	$scope.doctors = '<c:out value="${doctors}"/>';
  });
  </script>

</body>
</html>`