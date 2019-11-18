<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>Veuillez vous inscrire!</h1>
<h2>${message}</h2>
<form name="f" th:action="@{/registeruser}" method="post">
    <fieldset>
        <legend>S'engegistrer</legend>
        <label for="email">email</label>
        <input type="text" id="email" name="email"/><br/>
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password"/><br/>
        <label for="passwordconfirm">Confirmer le mot de passe</label>
        <input type="password" id="passwordconfirm" name="passwordconfirm"/><br/>
        <label for="firstname">Prénom</label>
        <input type="text" id="firstname" name="firstname"/><br/>
        <label for="lastname">Nom</label>
        <input type="text" id="lastname" name="lastname"/><br/>
        <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
</form>
<c:if test="${ !empty error}"><p><c:out value="${error}"/></p></c:if>