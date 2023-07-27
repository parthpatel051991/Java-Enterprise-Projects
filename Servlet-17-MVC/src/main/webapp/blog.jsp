<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog Page</title>
</head>
<body style="background-color:olive; ;color: blue;">

<div align="right">

  <a href="logout">Logout</a>
</div>


	<div align="center">

		<form action="./blog" method="post">
			<label for="title">Title:</label> <input type="text" id="title"
				name="title" required><br> <label for="description">Description:</label>
			<input type="text" id="description" name="description" required><br>

			<label for="content">Content:</label>
			<textarea id="content" name="content" rows="10" required></textarea>
			<br> <input type="submit" value="Create">
		</form>
	</div>

	<div align="left">
		<h3>To see all blogs</h3>
		<a href="./show">click here</a>
	</div>


	<c:set var="result" value="${sessionScope.success}" />


	<c:if test="${ result}">

		<h4>Blog is created</h4>

	</c:if>

	<c:if test="${ not result}">

		<h4>Blog creation is failed</h4>

	</c:if>

</body>
</html>