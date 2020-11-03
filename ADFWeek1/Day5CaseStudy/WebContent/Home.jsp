<%@page import="com.accenture.day5.casestudy.model.Voter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<%

session=request.getSession(false);
if(session!=null)
{
	Voter voter = (Voter)session.getAttribute("voter");
	out.println("<b>ID:</b>"+voter.getVoterId());
	out.println("<br><b>Name:</b>"+voter.getVoterName());
	out.println("<br><b>Age:</b>"+voter.getVoterAge());
	out.println("<br><b>Vote Done:</b>"+voter.isVote());
}
%>
<form action="VoterController" method="post">
	<input value="LOGOUT" name="operation" type="submit">
</form>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>