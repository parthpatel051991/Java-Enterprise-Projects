<%@page import="org.springframework.web.context.annotation.SessionScope"%>
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

<div align="right">
	<h6>Logged in as <%= session.getAttribute("username") %></h6>

</div>

	<h1>${msg}</h1>

	<div>
		<a href="/">LogOut</a>
	</div>

</body>
</html>