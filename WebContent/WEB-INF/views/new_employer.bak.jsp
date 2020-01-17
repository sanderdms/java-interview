<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add news</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<h1>CRUD - Hibernate - Test > Add new employer</h1>

<form:form action="save" method="post" modelAttribute="employer">
<table>
<tr>
<td>Name:</td>
<td><form:input path="name" /></td>
<td><form:errors path="name" cssClass="error" /></td>

</tr>
<tr>
<td>Email:</td>
<td><form:input path="email" /></td>
<td><form:errors path="email" cssClass="error" /></td>

</tr>
<tr>
<td>Address:</td>
<td><form:input path="address" /></td>
<td><form:errors path="address" cssClass="error" /></td>

</tr>

<tr>
<td>
<input type="submit" value="save"/>
</td>
</tr>
</table>
</form:form>



</body>
</html>