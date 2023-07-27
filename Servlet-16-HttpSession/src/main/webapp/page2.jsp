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
		<h1>Your Account is Created</h1>
		<h5>Your details as followed</h5>





		<table border="1">
			<tr>
				<th>Name</th>
				<th>Value</th>
			</tr>


			<tr>
				<td>Username</td>
				<td><%= session.getAttribute("username") %></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><%= session.getAttribute("age") %></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><%= session.getAttribute("phone") %></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%= session.getAttribute("email") %></td>
			</tr>


		</table>
	</div>


</body>
</html>