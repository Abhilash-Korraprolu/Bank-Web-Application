<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RM Bank</title>
</head>
<body>
	<h1>The Royal Meow Bank</h1>

	<h3>Welcome ${user.firstName} ${user.lastName}</h3>
	<a href="/logout">Logout</a>

	<br>
	<br>
	<br>
	<br>

	<h2>My Accounts</h2>
	<table>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>
					<form action="account" method="post">
						<button class="block" name="accountNumber"
							value="${account.accountNumber}">
							<c:out value="${account.accountNumber}" />
							&emsp; &emsp;
							<c:out value="${account.balance}" />
						</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/transfer"> Transfer </a>
	
</body>
</html>