<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${!empty topos}">
    <c:forEach items="${topos}" var="topo">
        <form method="post" action="${pageContext.request.contextPath}/personnalspace/topo/resa">
            <fieldset>
                <legend><spring:message code="topo"/> <c:out value="${topo.user.firstName}"/> <c:out value="${topo.user.lastName}"/> </legend>
                <input type="text" hidden value="${userid}" name="userid"/>
                <input type="text" hidden value="${topo.id}" name="topoid"/>
                <table>
                    <tr>
                        <td>
                            <c:out value="${topo.lieu}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${topo.description}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.topo.ask.resa"/>"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </c:forEach>
</c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
