<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h3>Veuillez vous loguer!</h3>
<!--<form name="f" th:action="@{/login}" method="post">-->
<form action="${pageContext.request.contextPath}/login" method="post">
    <fieldset>
        <legend>Please Login</legend>
        <c:if test="${param.error != null}"><p style="color: red">Invalid username and password.</p></c:if>
        <c:if test="${param.logout != null}"><p>You have been logged out.</p></c:if>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" autofocus/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
        <div class="form-actions">
            <button type="submit" class="boutonStyled">Log in</button>
        </div>
    </fieldset>
</form>