<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="entete.jsp" %>
<h1>Veuillez vous loguer!</h1>
<h2>${message}</h2>
<form name="f" th:action="@{/login}" method="post">
    <fieldset>
        <legend>Please Login</legend>
        <c:if test="${param.error != null}"><p style="color: red">Invalid username and password.</p></c:if>
        <c:if test="${param.logout != null}"><p>You have been logged out.</p></c:if>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
        <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
</form>
</body>
</html>
