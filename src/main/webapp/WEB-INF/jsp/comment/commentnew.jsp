<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/comment/add" method="post">
    <input type="text" id="siteid" name="siteid" value="${siteid}" hidden/>
    <label for="commentnew"><spring:message code="comment.your.comment"/> :</label><br/>
    <textarea id="commentnew" name="commentnew" placeholder="<spring:message code="comment.write.your.comment"/>" maxlength="65535" autofocus><c:out value="${param.commentnew}"/></textarea>
    <br/>
    <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/> ">
</form>