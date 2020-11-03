<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="validate.do" modelAttribute="EMPLOYEE">

	firstName: <s:input path="firstName"/><br>
	<s:errors path="firstName"></s:errors><br>
	lastName: <s:input path="lastName"/><br>
	<s:errors path="lastName"></s:errors><br>
	age: <s:input path="age"/><br>
	<s:errors path="age"></s:errors><br>
	salary: <s:input path="salary"/><br>
	<s:errors path="salary"></s:errors><br>
	<input type="submit">
</s:form>

</body>
</html>