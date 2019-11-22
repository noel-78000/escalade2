<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
<p>Site : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
    <form method="post" action="${pageContext.request.contextPath}/site/change">
    <fieldset>
    <legend><spring:message code="site"/></legend>
        <input type="text" hidden value="${site.id}" name="id"/>
        <table>
            <tr>
                <td><spring:message code="name.word"/>:</td>
                <td><input type="text" value="${site.nom}" name="nom" autofocus/></td>
            </tr>
            <tr>
                <td><spring:message code="place"/>:</td>
                <td><input type="text" value="${site.lieu}" name="lieu"/></td>
            </tr>
            <c:if test="${isassolevel}">
                <tr>
                    <td><spring:message code="official.association.site"/>:</td>
                    <td>
                        <spring:message code="official.association.site.yes"/> <input type="radio" name="siteofficial" value="yes" <c:if test="${siteofficialistaged}">checked</c:if>/>
                        <spring:message code="official.association.site.no"/> <input type="radio" name="siteofficial" value="no" <c:if test="${!siteofficialistaged}">checked</c:if>/>
                    </td>
                </tr>
            </c:if>
        </table>
        <input formaction="${pageContext.request.contextPath}/site/change"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
        <input formaction="${pageContext.request.contextPath}/site/delete"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.delete"/>" />
        <input formaction="${pageContext.request.contextPath}/secteur/add" formmethod="get"
               class="boutonStyled" type="submit" value="<spring:message code="button.submit.add.secteur"/>" />
    </fieldset>
    </form>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>

</c:if>
