<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="left">
	<h5>
		Welcome,
		<%=request.getSession().getAttribute("username")%>
		</h5>
	</div>

<div align="center">

	<h1>This is first page of App</h1>
	
	<h3>Enter Some more information</h3>
	
	<form action="./create" method="get">

		<table>

			<tr>
				<td>Phone No</td>
				<td><input type="tel" name="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Create Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="Create Account" /></td>
			</tr>

		</table>


	</form>
	
	
	

</div>

</body>
</html>