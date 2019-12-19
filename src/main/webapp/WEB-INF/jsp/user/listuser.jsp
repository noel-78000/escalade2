<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/userlist.js"></script>
<div class="container-fluid col-xl-5 col-lg-6 col-md-7 col-sm-8">
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
        <input type="tel" id="userpagetotalpages" hidden value="${userPage.totalPages}"/>
        <button type="button" class="btn btn-success">
            <input id="userlistnumpage" type="tel" size="${1 + (userPage.number + 1) / 10}" maxlength="${1 + userPage.totalPages / 10}" value="${userPage.number + 1}"/>/${userPage.totalPages}
        </button>
        <c:if test="${userPage.hasNext()}">
            <button type="button" class="btn btn-success">
            <a href="${pageContext.request.contextPath}/user/listpage?num=${userPage.number + 1}" style="color: white;"><spring:message code="next"/> &raquo;</a>
            </button>
        </c:if>
    </c:if>
</div>