<%@ page language= "java" contentType= "text/html; charset=utf-8" pageEncoding= "utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1> Hello world!  </h1>
	<a href="/getData">구디아카데미</a>
	<a href="/naverData">네이버블로그</a>
	<c:forEach var="li" items="${list}">
		<div>
			<h2>${li.title}</h2>
			<h3>${li.type}</h3>
			<p>${li.date}</p>
		</div>
	</c:forEach>
	<c:forEach var="naver" items="${naver}">
		<div>
			<h2>${naver.name}</h2>
			<h3>${naver.title}</h3>
			<p>${naver.content}</p>
		</div>
	</c:forEach>
</body>
</html>
