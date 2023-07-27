<%@page import="java.util.List"%>
<%@page import="in.ineuron.model.Blog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog List</title>
</head>
<body style="background-color: yellow; color: blue;">

	<div align="right">
		<a href="logout">Logout</a>
	</div>


	<h1>List of Blog Posts</h1>

	<% 
            List<Blog> blogPosts = (List<Blog>) request.getAttribute("blogPosts");
            for (Blog blogPost : blogPosts) {
        %>

	<h2>
		Blog Id:
		<%= blogPost.getBlogId() %></h2>
	<h3>
		Title:
		<%= blogPost.getTitle() %></h2>
		<p>
			Description:
			<%= blogPost.getDescription() %></p>
		<p>
			Content:
			<%= blogPost.getContent() %></p>

		<% 
            }
        %>
	
</body>
</html>