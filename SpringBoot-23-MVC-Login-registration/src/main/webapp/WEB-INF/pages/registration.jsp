<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reg</title>
</head>
<body>

	<h1>Register</h1>

	<div>
		<form action="/register" method="post">

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
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td>Age</td>
					<td><input type="number" name="age" /></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="register" /></td>

				</tr>

			</table>

		</form>

	</div>

${msg}
</body>
</html>