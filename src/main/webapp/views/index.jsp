<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1 align="center">The Royal Meow Bank</h1>
	<br>
	<br> ${SPRING_SECURITY_LAST_EXCEPTION.message}
	<form action="login" method="post">
		<table>
			<tr>
				<td>Personummer:</td>
				<td><input type="text" name="username" placeholder="YYMMDDXXXX"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

	<a href="/register">Register</a>
	<br>
	<a href="/users">Users</a>
	<br>

	<a href="#">Feedback</a>

</body>
</html>