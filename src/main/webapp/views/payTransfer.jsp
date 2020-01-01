<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pay/Transfer</title>
</head>
<body>

	<form action="performTransfer" method="post">
		<table>
			<tr>
				<td>Choose account</td>
				<td><select name="sendersAccountNumber">
						<c:forEach items="${accounts}" var="account">
							<option value="${account.accountNumber}">${account.accountNumber}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Account Number:</td>
				<td><input type="text" name="receiversAccountNumber"></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input type="text" name="amount" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Send" /></td>
			</tr>
		</table>
	</form>
	<br>
</body>
</html>