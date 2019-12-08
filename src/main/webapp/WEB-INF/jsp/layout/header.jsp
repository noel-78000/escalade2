<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <c:if test="${isauth}">
        <div class="flottantRight hideOnPhone" id="firstAnLastName">
        <sec:authentication var="principal" property="principal" />
        <p><spring:message code="goodmorning"/> ${principal.user.firstName} ${principal.user.lastName}&nbsp;&nbsp;&nbsp;</p>
        </div>
    </c:if>
    <div class="centerBlocHead hideOnPhone">
        <img src="${pageContext.request.contextPath}/img/logo.png"/>
    </div>
    <div class="flottantRight hideOnPhone">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/language?lang=fr">
            <img src="${pageContext.request.contextPath}/img/drapeau-francais.jpg" class="imgLanguage"/>
            </a>
            <p>&nbsp;</p>
            <a href="${pageContext.request.contextPath}/language?lang=en">
            <img src="${pageContext.request.contextPath}/img/drapeau-anglais.png" class="imgLanguage" "/>
            </a>
        </div>
    </div>
    </div>
<hr class="hideOnPhone"/>
