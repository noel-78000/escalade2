<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/comment/change" method="post">
    <input type="text" id="siteid" name="siteid" value="${comment.site.id}" hidden/>
    <input type="text" id="commentid" name="commentid" value="${comment.id}" hidden/>
    <label for="commentchange"><spring:message code="comment.your.comment"/> :</label><br/>
    <textarea id="commentchange" name="commentchange" maxlength="65535"><c:out value="${comment.commentaire}"/></textarea>
    <br/>
    <input formaction="${pageContext.request.contextPath}/comment/change"
           class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
    <input formaction="${pageContext.request.contextPath}/comment/list?id=${comment.site.id}" formmethod="get"
           class="boutonStyled" type="submit" value="<spring:message code="button.submit.cancel"/>" />
</form>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>