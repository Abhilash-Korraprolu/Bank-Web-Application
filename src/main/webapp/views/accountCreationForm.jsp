<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>

	<form action="createAccount" method="post" align="center">
		<table>
			<tr>
				<td>Initial Deposit:</td>
				<td><input type="text" name="initialDeposit"></td>
			</tr>

			<tr>
				<td><label>Account Type</label></td>
				<td><select name="accountType">
						<option value="current">Current</option>
						<option value="savings" selected>Savings</option>
				</select></td>
			</tr>

			<tr>
				<td><label>Currency</label></td>
				<td><select name="currencyType">
						<option value="SEK">Swedish Krona (SEK)</option>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>