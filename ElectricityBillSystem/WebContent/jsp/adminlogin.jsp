<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/script.js"></script>
</head>
<body>
<h2>Admin Login</h2>
	<form action="../AdminLoginServlet" method="post" id="loginForm"
		onsubmit="return validateForm('loginForm')">
		<label for="adminId">adminId</label> <input type="text" name="adminId"
			id="adminId" required> <label for="password">Password:</label>
		<input type="password" name="password" id="password" required>

		<input type="submit" value="Login">
	</form>
	<div style="text-align: center; margin-top: 15px;" class="redirect">
		Not an Admin? <a href="../">Go to home</a>
	</div>

</body>
</html>