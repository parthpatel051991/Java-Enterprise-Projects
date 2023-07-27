<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h1>Welcome to Login App!</h1>

	<div>
		<form action="/login" method="post">

			<table>

				<tr>
					<td>Email</td>
					<td><input type="email" name="email" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Sign In" /></td>

				</tr>

			</table>

		</form>

	</div>
	
	<div>
	<a href="/reg">Sign Up</a>
	</div>

${msg}
</body>
</html>