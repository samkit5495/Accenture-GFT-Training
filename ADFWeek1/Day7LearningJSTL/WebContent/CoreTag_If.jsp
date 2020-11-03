<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Number1: <c:out value="${ sessionScope.num1 }"></c:out>
<br>Number2: <c:out value="${ sessionScope.num2 }"></c:out>
<br>
<c:if test="${ sessionScope.num1 > sessionScope.num2 }">
	<h1><c:out value="${ sessionScope.num1 }"/> num 1 greater</h1>
</c:if>
<c:if test="${ sessionScope.num1 < sessionScope.num2 }">
	<h1><c:out value="${ sessionScope.num2 }"/> num 2 greater</h1>
</c:if>

</body>
</html>