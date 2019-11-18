<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Veuillez vous loguer!</h1>
<h2>${message}</h2>
<form name="f" th:action="@{/registeruser}" method="post">
    <fieldset>
        <legend>S'engegistrer</legend>
        <label for="email">email</label>
        <input type="text" id="email" name="email"/>
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password"/>
        <label for="passwordconfirm">Mot de passe</label>
        <input type="password" id="passwordconfirm" name="passwordconfirm"/>
        <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
</form>