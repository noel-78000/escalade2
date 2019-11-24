<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
    <ul class="hideOnPhone">
        <li><a href="${pageContext.request.contextPath}/"><spring:message code="menu.accueil"/></a> </li>
        <c:if test="${!isauth}">
            <li><a href="${pageContext.request.contextPath}/login"><spring:message code="menu.login"/></a> </li>
            <li><a href="${pageContext.request.contextPath}/user/registeruser"><spring:message code="menu.log-in"/></a></li>
        </c:if>
        <c:if test="${isauth}">
            <li><a href="${pageContext.request.contextPath}/logout"><spring:message code="menu.logout"/></a> </li>
            <li><a href="${pageContext.request.contextPath}/user/moncompte"><spring:message code="menu.account"/></a></li>
            <li><a href="${pageContext.request.contextPath}/personnalspace"><spring:message code="menu.personnal.space"/></a></li>
        </c:if>
    <li><a href="${pageContext.request.contextPath}/user/list"><spring:message code="menu.user.list"/></a> </li>
        <li><a href="${pageContext.request.contextPath}/search"><spring:message code="menu.search.and.change"/> </a> </li>
    </ul>
</nav>
