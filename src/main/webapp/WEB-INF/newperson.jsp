<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<h1>Create a Person</h1>

	<form:form action="/create_person" method="post" modelAttribute="persons">
	    <p>
	        <form:label path="firstName">First Name</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    
	    <input type="submit" value="Create"/>
	</form:form>  
</body>
</html>