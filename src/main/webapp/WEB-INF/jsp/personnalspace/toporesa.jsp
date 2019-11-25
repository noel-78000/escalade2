<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${!empty toporesa}">
<form method="post" action="${pageContext.request.contextPath}/personnalspace/toporesa/selected">

    <fieldset>
        <legend><spring:message code="topo.resa"/></legend>
        <input type="text" hidden value="${toporesa.id}" name="toporesaid"/>
        <table>
            <tr>
                <td>
                    <p><spring:message code="topo.lieu"/>: <c:out value="${toporesa.topo.lieu}"/></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p><spring:message code="topo.description"/>: <c:out value="${toporesa.topo.description}"/></p>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="topo.resa"/>:<br/>
                    <c:out value="${toporesa.user.firstName}"/> <c:out value="${toporesa.user.lastName}"/><br/>
                    <c:out value="${toporesa.user.email}"/><br/>
                    <c:out value="${toporesa.user.phonenumber}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <spring:message code="topo.resa.accept"/>:
                    <input type="checkbox" name="acceptresa" <c:if test="${toporesa.acceptResa}">checked</c:if>/>
                </td>
            </tr>
        </table>

        <input formaction="${pageContext.request.contextPath}/personnalspace/toporesa/selected"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
        <input onclick="window.location='${pageContext.request.contextPath}/personnalspace/'" formmethod="get"
               class="boutonStyled" type="button" value="<spring:message code="button.submit.cancel"/>" />
    </fieldset>
</form>
</c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

