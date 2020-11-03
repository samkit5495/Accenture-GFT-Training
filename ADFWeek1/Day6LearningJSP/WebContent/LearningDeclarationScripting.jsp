<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	int num;//possible

	//System.out.println(num); Executable statement not possible
	
	public void greeting(){
		System.out.println("We need break");
	}
	
%>

<%
System.out.println(num);
greeting();
%>

num=  <%=num %>

<%=10+30 %>

<%="total="+10+30 %>
</body>
</html>