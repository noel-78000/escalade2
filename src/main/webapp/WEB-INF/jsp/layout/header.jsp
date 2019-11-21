<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <c:if test="${isauth}">
        <div class="flottantRight hideOnPhone" id="firstAnLastName">
        <sec:authentication var="principal" property="principal" />
        <p><spring:message code="goodmorning"/> ${principal.user.firstName} ${principal.user.lastName}</p>
        </div>
    </c:if>
    <div class="centerBloc hideOnPhone">
        <img src="${pageContext.request.contextPath}/img/logo.png"/>
    </div>
<hr class="hideOnPhone"/>
