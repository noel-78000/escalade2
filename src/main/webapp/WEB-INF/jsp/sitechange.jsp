<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
<p>Site : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/site/change">
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
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
</c:if>