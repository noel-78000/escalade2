<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<div class="container-fluid col-xs-8">
    <div class="text-center">
    <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/comment/add?siteid=${siteid}'">
        <spring:message code="button.submit.add.comment"/>
    </button>
    </div>
</div>
<c:forEach  items="${commentaires}" var="commentaire" varStatus="status">
    <div class="monCadre">
        <p style="font-size: 0.8em">${commentaire.user.firstName} ${commentaire.user.lastName}</p>
        <p>${commentaire.commentaire}</p>
        <c:if test="${isassolevel}">
            <p>
                <a href="${pageContext.request.contextPath}/comment/delete?id=${commentaire.id}&siteid=${siteid}">
                    <span><spring:message code="button.submit.delete"/></span>
                </a>&nbsp
                <a href="${pageContext.request.contextPath}/comment/change?id=${commentaire.id}&siteid=${siteid}">
                    <span><spring:message code="button.submit.change"/></span>
                </a>
            </p>
        </c:if>
    </div>

</c:forEach>