<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Account</title>
</head>
<body>

	Account Number: ${account.accountNumber}
	<br>
	<a href="/logout">Logout</a>
	<br>
	<br>
	<br>
	<table>
		<c:forEach items="${transactions}" var="transaction">
			<tr>
				<td><c:out value="${transaction.name}" /></td>
				<td><c:out value="${transaction.amount}" /></td>
				<td><c:out value="${transaction.balance}" /></td>
				<td><c:out value="${transaction.timeStamp}" /></td>

			</tr>
		</c:forEach>
	</table>


</body>
</html>