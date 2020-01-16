<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">

</head>
<body>
	<h1>CRUD - Hibernate - Test</h1>
	
	<a href="new">New employer</a>
	<br>
	<br>
	<table border="1">
<tr>
<td>ID</td>
<td>Name</td>
<td>E-mail</td>
<td>Address</td>
<td>Action</td>
</tr>
<c:forEach items="${list}" var="employer">

<tr>
<td>${employer.id }</td>
<td>${employer.name }</td>
<td>${employer.email }</td>
<td>${employer.address }</td>
<td>
<a href="edit?id=${employer.id}">Edit</a><br>
<a href="delete?id=${employer.id}">Delete</a>

</td>
</tr>

    <img alt="image"  src="<c:url value="images/img.jpg" />">
</c:forEach>


	</table>
</body>
</html>