<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/voie/add">
    <fieldset>
        <legend><spring:message code="voie"/></legend>
        <input type="text" hidden value="${siteid}" name="siteid"/>
        <input type="text" hidden value="${secteurid}" name="secteurid"/>
        <table>
            <tr>
                <td><spring:message code="name.word"/> :</td>
                <td><input type="text" placeholder="<spring:message code="name.word"/>" name="nom" maxlength="100" autofocus/></td>
            </tr>
        </table>
        <input type="submit" class="boutonStyled" value="<spring:message code="button.submit.record"/>"/>
    </fieldset>
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
