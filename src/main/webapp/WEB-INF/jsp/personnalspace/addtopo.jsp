<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form method="post" action="${pageContext.request.contextPath}/personnalspace/topo/add">

    <fieldset>
        <legend><spring:message code="topo"/></legend>
        <table>
            <tr>
                <td>
                    <p><spring:message code="topo.lieu"/>:</p>
                </td>
                <td>
                    <input type="text" name="lieu" maxlength="100" value="${param.lieu}" autofocus/>
                </td>
            </tr>
            <tr>
                <td>
                    <p><spring:message code="topo.description"/>:</p>
                </td>
                <td>
                    <textarea name="description" value="${param.description}" maxlength="65535"></textarea>
                </td>
            </tr>
            <tr>
                <td><spring:message code="topo.pret.dispo"/>:</td>
                <td>
                    <spring:message code="topo.yes"/>:<input type="radio" name="topopret" value="yes"/>
                    <spring:message code="topo.no"/>:<input type="radio" name="topopret" value="no"/>
                </td>
            </tr>
        </table>

        <input formaction="${pageContext.request.contextPath}/personnalspace/topo/add"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
        <input class="boutonStyled" type="button" value="<spring:message code="button.submit.cancel"/>"
        onclick="window.location='${pageContext.request.contextPath}/personnalspace/'"/>
    </fieldset>
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

