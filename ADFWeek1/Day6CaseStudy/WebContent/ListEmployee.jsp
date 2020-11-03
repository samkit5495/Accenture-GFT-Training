<%@page import="java.util.List"%>
<%@page import="com.accenture.day6.casestudy.model.Employee"%>
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
<%

for(Employee e:(List<Employee>)session.getAttribute("employeeList")){
	%>
		<tr>
			<td><%= e.getEmpId() %></td>
			<td><%= e.getEmpName() %></td>
			<td><%= e.getSalary() %></td>
			<td><%= e.getDept() %></td>
		</tr>
	<%
}
%>
</table>
</body>
</html>