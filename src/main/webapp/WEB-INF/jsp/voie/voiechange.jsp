<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty voie }">
    <p><spring:message code="voie"/> : <c:out value="${voie.nom}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/voie/change">

        <fieldset>
            <legend><spring:message code="modification.voie"/></legend>
            <input type="text" hidden value="${voie.id}" name="id"/>
            <input type="text" hidden value="${siteid}" name="siteid"/>
            <input type="text" hidden value="${secteurid}" name="secteurid"/>
            <table>
                <tr>
                    <td><spring:message code="name.word"/>:</td>
                    <td><input type="text" value="${voie.nom}" name="nom" autofocus/></td>
                </tr>
            </table>

            <input formaction="${pageContext.request.contextPath}/voie/change"
                   class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
            <input formaction="${pageContext.request.contextPath}/voie/delete"
                   class="boutonStyled" type="submit" value="<spring:message code="button.submit.delete"/>" />
            <input formaction="${pageContext.request.contextPath}/longueur/add" formmethod="get"
                   class="boutonStyled" type="submit" value="<spring:message code="button.submit.add.longueur"/>" />
        </fieldset>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

</c:if>