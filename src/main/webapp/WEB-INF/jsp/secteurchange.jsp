<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty secteur }">
    <p>Secteur : <c:out value="${secteur.nom}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/secteur/change">
        <input type="text" hidden value="${siteid}" name="siteid"/>
        <input type="text" hidden value="${secteur.id}" name="id"/>
        <table>
            <tr>
                <td>nom:</td>
                <td><input type="text" value="${secteur.nom}" name="nom" autofocus/></td>
            </tr>
        </table>
        <input type="submit" class="boutonStyled" value="enregistrer"/>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
</c:if>