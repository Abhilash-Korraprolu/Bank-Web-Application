<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register New User</title>
</head>
<body>
	<h1 align="center">The Royal Meow Bank</h1>
	<br>
	<br>

	<!--Bootstrap code to display failed validation message   -->

	<form action="register" method="post" align="center">
		<table>
			<tr>
				<td>Personummer:</td>
				<td><input type="text" name="pno" placeholder="YYYYMMDDXXXX"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>Phone Number:</td>
				<td><input type="text" name="phoneNumber"
					placeholder="0XXXXXXXXX"></td>
			</tr>

			</tr>
			<td>Additional Permissions:</td>
			<td><select name="permissions" multiple> <
					<c:forEach items="${permissions}" var="p">
						<option value="${p.permission}">${p.permission}</option>
					</c:forEach>
			</select></td>
			</tr>

			<br>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>