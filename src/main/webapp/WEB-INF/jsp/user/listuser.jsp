<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>List des utilisateurs</p>
<c:forEach items="${userList}" var="user">
    <p> ${user.firstName} ${user.lastName} </p>
</c:forEach>
</body>
</html>
