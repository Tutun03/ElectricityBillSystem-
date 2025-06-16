<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>User Registration</title>

<link rel="stylesheet" href="../css/style.css">

<script src="../js/script.js"></script>

</head>

<body>

	<h2>User Registration</h2>

	<form action="../register" method="post" id="registerForm"
		onsubmit="return validateForm('registerForm')"
		onreset="return resetfunction('registerForm')">

		<label for="consumerId">Consumer ID:</label> <input type="text"
			name="consumerId" id="consumerId" maxlength="13" pattern="^\d{13}$"
			required> <label for="billNumber">Bill Number (last 5
			digits of Consumer ID):</label> <input type="text" name="billNumber"
			id="billNumber" maxlength="5" pattern="^\d{5}$" required>

		<div class="form-row">
			<div class="form-group">
				<label for="title">Title</label> <select id="title" required>
					<option value="Mr">Mr</option>
					<option value="Mrs">Mrs</option>
					<option value="Ms">Ms</option>
				</select>
			</div>
		</div>
		<label for="customername">CustomerName <input type="text"
			name="customername" id="customername" maxlength="30" required
			pattern="[A-Za-z\s]+" title="Only letters and spaces allowed">
		</label> <label for="email">Email <input type="email" name="email"
			id="email" maxlength="20" required></label>
		<label for="mobileNo">Mobile No:</label> <input type="text"
			name="mobileNo" id="mobileNo" maxlength="10" pattern="^\d{10}$"
			required title="Mobile number should be of 10 digits"> 
			<label>Password:</label> <input
			type="password" name="password" id="password" required
>

		<label for="confirmPassword">Confirm Password:</label> <input
			type="password" name="confirmPassword" id="confirmPassword" required>
		<div class="btn">
			<input type="submit" value="Register"> <input type="reset"
				value="Reset">

		</div>

	</form>

	<div style="text-align: center; margin-top: 15px;" class="redirect">

		Already registered? <a href="login.jsp">Login here</a>

	</div>

</body>

</html>