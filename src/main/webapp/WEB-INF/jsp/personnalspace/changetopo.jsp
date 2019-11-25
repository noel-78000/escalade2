<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${!empty topo}">
<form method="post" action="${pageContext.request.contextPath}/personnalspace/topo/change">

    <fieldset>
        <input type="text" name="topoid" hidden value="${topo.id}"/>
        <legend><spring:message code="topo"/></legend>
        <div>
            <label for="lieu"><spring:message code="topo.lieu"/>:</label>
            <input type="text" id="lieu" name="lieu" maxlength="100" value="<c:out value="${topo.lieu}"/>"/>
        </div>
        <div>
            <label for="description"><spring:message code="topo.description"/>:</label>
            <textarea id="description" name="description" maxlength="65535"><c:out value="${topo.description}"/></textarea>
        </div>
        <div><spring:message code="topo.pret.dispo"/>:</div>
        <div>
            <spring:message code="topo.yes"/>:<input type="radio" name="topopret" value="yes" <c:if test="${topo.dispoResa}">checked</c:if>/>
            <spring:message code="topo.no"/>:<input type="radio" name="topopret" value="no" <c:if test="${!topo.dispoResa}">checked</c:if>/>
        </div>

        <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
        <input class="boutonStyled" type="button" value="<spring:message code="button.submit.cancel"/>"
               onclick="window.location='${pageContext.request.contextPath}/personnalspace/'"/>
    </fieldset>
</form>
</c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

