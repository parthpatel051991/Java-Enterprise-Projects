<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body style="background-color:teal; color: blue;">

	<h1>Welcome to BlogSite</h1>


	<div align="center">

		<form action="./controller/login" method="post">

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
					<td><input type="submit" value="login" /></td>
				</tr>

			</table>

		</form>

	</div>
	
	<div align="center">
	
	<h4>To register Account</h4>
	
	
	<a href="./register.jsp"><button>Register</button></a>
		
	
	</div>
	

	
	  <c:set var="result" value="${sessionScope.authentication}" />
	
	
	<c:if test="${ result==false}">
	
	<h4>Login Failed</h4>
	
	</c:if>


</body>
</html>
