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
            <li><a href="${pageContext.request.contextPath}/user/listpage"><spring:message code="menu.user.list"/></a> </li>
        </c:if>
        <li><a href="${pageContext.request.contextPath}/search"><spring:message code="menu.search.and.change"/> </a> </li>
    </ul>

    <div class="container">
    <div class="row">
    <div class="col-8">
        <div class="dropdown showOnPhoneOnly">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <spring:message code="menu"/>
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/"><spring:message code="menu.accueil"/></a>
                <c:if test="${!isauth}">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/login"><spring:message code="menu.login"/></a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/registeruser"><spring:message code="menu.log-in"/></a>
                </c:if>
                <c:if test="${isauth}">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><spring:message code="menu.logout"/></a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/moncompte"><spring:message code="menu.account"/></a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/personnalspace"><spring:message code="menu.personnal.space"/></a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/listpage"><spring:message code="menu.user.list"/></a>
                </c:if>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/search"><spring:message code="menu.search.and.change"/></a>
            </div>
        </div>
    </div>
    <div class="col-4">
        <div class="flottantRight showOnPhoneOnly">
            <div class="container">
                <div class="row">
                    <img src="${pageContext.request.contextPath}/img/drapeau-francais.jpg" class="imgLanguage" id="refreshfrench2"/>
                    <p>&nbsp;&nbsp;&nbsp;</p>
                    <img src="${pageContext.request.contextPath}/img/drapeau-anglais.png" class="imgLanguage" id="refreshenglish2"/>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
    </nav>
