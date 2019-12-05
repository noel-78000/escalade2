<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <button type="button" class="btn btn-secondary">
        <spring:message code="users.list"/>
    </button>
    <div class="row">&nbsp;</div>
    <c:if test="${!empty userPage}">
        <c:forEach items="${userPage.content}" var="user">
            <p> ${user.firstName} ${user.lastName} </p>
        </c:forEach>
        <c:if test="${userPage.hasPrevious()}">
            <button type="button" class="btn btn-success">
            <a href="${pageContext.request.contextPath}/user/listpage?num=${userPage.number - 1}" style="color: white;">&laquo; <spring:message code="previous"/></a>
            </button>
        </c:if>
        <button type="button" class="btn btn-success">
            <a href="#" style="color: white;">${userPage.number + 1}</a>
        </button>
        <c:if test="${userPage.hasNext()}">
            <button type="button" class="btn btn-success">
            <a href="${pageContext.request.contextPath}/user/listpage?num=${userPage.number + 1}" style="color: white;"><spring:message code="next"/> &raquo;</a>
            </button>
        </c:if>
    </c:if>
</div>