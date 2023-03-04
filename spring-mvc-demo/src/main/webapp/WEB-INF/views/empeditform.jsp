<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit form employee</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Edit Employee</h1>
	<form:form method="post" action="editsave">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input type="number" min="1" path="age" /></td>
			</tr>
			<tr>
				<td>Phone number</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>