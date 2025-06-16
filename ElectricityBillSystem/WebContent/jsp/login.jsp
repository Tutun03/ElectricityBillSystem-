<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/script.js"></script>
</head>
<body>
	<h2>User Login</h2>
	<form action="../login" method="post" id="loginForm"
		onsubmit="return validateForm('loginForm')">
		<label for="userId">User ID:</label> <input type="text" name="userId"
			id="userId" required> <label for="password">Password:</label>
		<input type="password" name="password" id="password" required>

		<input type="submit" value="Login">
	</form>
	<div style="text-align: center; margin-top: 15px;" class="redirect">
		Don't have an account? <a href="./register.jsp">Register here</a>
	</div>
</body>
</html>