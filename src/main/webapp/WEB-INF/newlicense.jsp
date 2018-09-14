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
	<h1>License a Person</h1>
	<form:form action="/create_license" method="post" modelAttribute="licenses">
	    <p>
	        <form:label path="person">Person:</form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
	        <c:forEach items="${personList}" var="list">
	        	<form:option value="${list.id}" label="${list.firstName} ${list.lastName}"/>
	        </c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="state">State</form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
	    <p>
	        <form:label path="expiration_date">Expiration Date</form:label>
	        <form:errors path="expiration_date"/>
	        <form:input type="date" path="expiration_date"/>
	    </p>
	    
	    <input type="submit" value="Create"/>
	</form:form>  
</body>
</html>