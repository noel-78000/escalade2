<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/site/add">
    <fieldset>
        <legend>Site</legend>
        <table>
            <tr>
                <td>nom:</td>
                <td><input type="text" placeholder="nom du site" name="nom" maxlength="100" autofocus/></td>
            </tr>
            <tr>
                <td>lieu:</td>
                <td><input type="text" placeholder="lieu" maxlength="100" name="lieu"/></td>
            </tr>
        </table>
        <input type="submit" class="boutonStyled" value="enregistrer"/>
    </fieldset>
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
