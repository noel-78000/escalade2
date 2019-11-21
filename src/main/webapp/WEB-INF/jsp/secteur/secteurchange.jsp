<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty secteur }">
    <p>Secteur : <c:out value="${secteur.nom}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/secteur/change">

    <fieldset>
        <legend>Modification secteur</legend>
        <input type="text" hidden value="${siteid}" name="siteid"/>
        <input type="text" hidden value="${secteur.id}" name="id"/>
        <table>
            <tr>
                <td>nom:</td>
                <td><input type="text" value="${secteur.nom}" name="nom" autofocus/></td>
            </tr>
        </table>

        <input formaction="${pageContext.request.contextPath}/secteur/change"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
        <input formaction="${pageContext.request.contextPath}/secteur/delete"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.delete"/>" />
        <input formaction="${pageContext.request.contextPath}/voie/add" formmethod="get"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.add.voie"/>" />
    </fieldset>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

</c:if>