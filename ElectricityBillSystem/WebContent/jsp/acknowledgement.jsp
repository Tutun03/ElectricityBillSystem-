<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/style.css">
<title>Acknowledgement Page</title>
</head>
<body>
	<%
		String newUsrId = request.getParameter("userId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	%>
	<div class="container ack">
		<h2>Acknowledgement Page</h2>
		<p>
			<strong>Your User ID is:</strong>
			<%=newUsrId%></p>
		<p>
			<strong>Your User Name is:</strong>
			<%=name%></p>
		<p>
			<strong>Your Email is:</strong>
			<%=email%></p>
	</div>
	<div style="text-align: center; margin-top: 15px;" class="redirect">

		Back to <a href="login.jsp">Login</a>
	</div>
</body>
</html>