<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
	
	<p>License Number <c:out value="${license.number}"/></p>
	<p>State: <c:out value="${license.state}"/></p>
	<p>Expiration Date: <c:out value="${license.expiration_date}"/></p>
</body>
</html>