<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/site/add">
    <fieldset>
        <legend>Site</legend>
        <table>
            <tr>
                <td>nom:</td>
                <td><input type="text" placeholder="nom du site" id="nom" name="nom" value="${param.nom}" maxlength="100" autofocus/></td>
            </tr>
            <tr>
                <td>lieu:</td>
                <td><input type="text" placeholder="lieu" maxlength="100" id="lieu" name="lieu" value="${param.lieu}"/></td>
            </tr>
            <c:if test="${isassolevel}">
                <tr>
                    <td><spring:message code="official.association.site"/>:</td>
                    <td>
                        <spring:message code="official.association.site.yes"/>:<input type="radio" name="siteofficial" value="yes" id="siteofficial"/>
                        <spring:message code="official.association.site.no"/>:<input type="radio" name="siteofficial" value="no" id="siteofficial"/>
                    </td>
                </tr>
            </c:if>
        </table>
        <input type="submit" class="boutonStyled" value="enregistrer"/>
    </fieldset>
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
