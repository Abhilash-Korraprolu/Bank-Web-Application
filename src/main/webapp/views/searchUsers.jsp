<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
</head>
<body>
	<h1 align="center">The Royal Meow Bank</h1>
	<br>
	<br>
	<form action="/users">
		<table align="center">
			<tr>
				<td>Personummer: <input type="text" name="pno"
					placeholder="Search pno" /> First Name: <input type="text"
					name="firstName" placeholder="Search first Name" /> Last Name: <input
					type="text" name="lastName"> <br>
				<br> City: <input type="text" name="city"> Email: <input
					type="text" name="email"> Phone Number: <input type="text"
					name="phoneNumber"> <input type="submit" value="Search!">
				</td>
				</form>
		</table>
		<br>
		<br>
		<a href="/logout">Logout</a><br>
		<table align="center">
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.pno}" /></td>
					<td><c:out value="${user.firstName}" /></td>

					<td>
						<form action="createAccount">
							<button name="pno" value="${user.pno}">Create Account</button>
						</form>
					</td>

				</tr>
			</c:forEach>
		</table>
</body>
</html>