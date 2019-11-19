<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post" action="${pageContext.request.contextPath}/user/moncompte">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" value="${email}" name="email" readonly/></td>
        </tr>
        <tr>
            <td>Mot de passe:</td>
            <td><input type="password" name="password" maxlength="100">
                <c:if test="${!empty passworderror}"><p style="color: red">${passworderror}</p></c:if>
            </td>
        </tr>
        <tr>
            <td>Mot de passe (confirmation):</td>
            <td><input type="password" name="passwordconfirm" maxlength="100">
            <c:if test="${!empty passworderror}"><p style="color: red">${passworderror}</p></c:if>
            </td>
        </tr>
        <tr>
            <td>Prénom:</td>
            <td><input type="text" value="${firstname}" name="firstname" maxlength="50"/></td>
        </tr>
        <tr>
            <td>Nom:</td>
            <td><input type="text" value="${lastname}" name="lastname" maxlength="50"/></td>
        </tr>
        <tr>
            <td>N° de téléphone:</td>
            <td><input type="text" value="${phonenumber}" name="phonenumber" maxlength="10"/></td>
        </tr>
        <tr>
            <td>Adresse:</td>
            <td><input type="text" value="${address}" name="address" maxlength="255"/></td>
        </tr>
        <tr>
            <td>Ville:</td>
            <td><input type="text" value="${city}" name="city" maxlength="50"/></td>
        </tr>
        <tr>
            <td>Code postal:</td>
            <td><input type="text" value="${zipcode}" name="zipcode" maxlength="5"/></td>
        </tr>
        <tr>
            <td>Pays:</td>
            <td><input type="text" value="${country}" name="country" maxlength="50"/></td>
        </tr>
    </table>
    <input type="submit" class="boutonStyled" value="enregistrer"/>
</form>
<c:if test="${!empty message}"><p>${message}</p></c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>