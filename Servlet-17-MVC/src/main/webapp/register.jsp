<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: cyan; color: blue;">

	<div>

		<form action="./register" method="post">

			<table>

				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="register" /></td>
				</tr>

			</table>



		</form>


	</div>


	<c:set var="result" value="${sessionScope.result}" />


	<c:if test="${ result==-1}">

		<h4>username is not available</h4>

	</c:if>

	<c:if test="${ result==0}">

		<h4>Account creation is failed</h4>

	</c:if>

</body>
</html>