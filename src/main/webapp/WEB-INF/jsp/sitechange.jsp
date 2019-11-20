<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
<p>Site : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/site/change">
    <fieldset>
    <legend>Site</legend>
        <input type="text" hidden value="${site.id}" name="id"/>
        <table>
            <tr>
                <td>nom:</td>
                <td><input type="text" value="${site.nom}" name="nom" autofocus/></td>
            </tr>
            <tr>
                <td>lieu:</td>
                <td><input type="text" value="${site.lieu}" name="lieu"/></td>
            </tr>
        </table>
    <input type="submit" class="boutonStyled" value="enregistrer"/>
    </fieldset>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

</c:if>

<form method="post" action="${pageContext.request.contextPath}/secteur/add">
    <fieldset>
    <legend>Nouveau secteur</legend>
    <c:if test="${!empty site}">
        <input type="text" hidden value="${site.id}" name="siteid"/>
    </c:if>
    <c:if test="${empty site}">
        <input type="text" hidden value="${siteid}" name="siteid"/>
    </c:if>
    <table>
        <tr>
            <td>nom du secteur:</td>
            <td><input type="text" placeholder="taper ici le nouveau secteur" name="nom" maxlength="100"/></td>
        </tr>
    </table>
    <input type="submit" class="boutonStyled" value="enregistrer secteur"/>
</fieldset>
</form>

<c:if test="${!empty errorsecteur}"><p style="color: red">${errorsecteur}</p></c:if>