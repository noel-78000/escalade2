<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/longueur/add">
    <fieldset>
        <legend><spring:message code="longueur"/></legend>
        <input type="text" hidden value="${siteid}" name="siteid"/>
        <input type="text" hidden value="${voieid}" name="voieid"/>
        <table>
            <tr>
                <td><spring:message code="cotation"/> :</td>
                <td><input type="text" placeholder="<spring:message code="cotation"/>" name="cotation" maxlength="3" minlength="1" autofocus/></td>
            </tr>
        </table>
        <input type="submit" class="boutonStyled" value="<spring:message code="button.submit.record"/>"/>
    </fieldset>
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
