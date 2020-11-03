<%@page import="java.util.List"%>
<%@page import="com.accenture.day6.casestudy.model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Salary</th>
	<th>Dept</th>
</tr>
<c:forEach items="${ sessionScope.employeeList }" var="emp">
	<tr>
		<td><c:out value="${ emp.empId }"></c:out></td>
		<td><c:out value="${ emp.empName }"></c:out></td>
		<td><c:out value="${ emp.salary }"></c:out></td>
		<td><c:out value="${ emp.dept }"></c:out></td>
	</tr>
</c:forEach>
</table>
</body>
</html>  