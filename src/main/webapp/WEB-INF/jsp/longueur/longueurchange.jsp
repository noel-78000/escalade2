<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty longueur }">
    <p><spring:message code="longueur"/> : <c:out value="${longueur.cotation}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/longueur/change">

        <fieldset>
            <legend><spring:message code="modification.longueur"/></legend>
            <input type="text" hidden value="${longueur.id}" name="id"/>
            <input type="text" hidden value="${siteid}" name="siteid"/>
            <input type="text" hidden value="${voieid}" name="voieid"/>
            <table>
                <tr>
                    <td><spring:message code="cotation"/>:</td>
                    <td><input type="text" value="${longueur.cotation}" name="cotation" autofocus/></td>
                </tr>
            </table>

            <input formaction="${pageContext.request.contextPath}/longueur/change"
                   class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
            <input formaction="${pageContext.request.contextPath}/longueur/delete"
                   class="boutonStyled" type="submit" value="<spring:message code="button.submit.delete"/>" />
        </fieldset>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

</c:if>