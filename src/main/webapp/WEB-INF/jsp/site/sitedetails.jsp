<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
    <h3>Cliquer sur ce que vous voulez modifier:</h3>
    <p>
        <a href="${pageContext.request.contextPath}/site/change?id=${site.id}">
            <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
            <c:if test="${site.tag}"><img src="${pageContext.request.contextPath}/img/logoTag.png"/></c:if>
        </a>
    </p>
    <c:forEach items="${ site.secteurs }" var="secteur">
        <a href="${pageContext.request.contextPath}/secteur/change?id=${secteur.id}&siteid=${site.id}">
            <c:out value="${ secteur.nom }"></c:out>
        </a>,
        <c:forEach items="${ secteur.voies }" var="voie">
            <a href="${pageContext.request.contextPath}/voie/change?id=${voie.id}&siteid=${site.id}">
                <c:out value="${ voie.nom }" ></c:out>
            </a>,
            <c:forEach items="${ voie.longueurs }" var="longueur">
                <a href="${pageContext.request.contextPath}/longueur/change?id=${longueur.id}&siteid=${site.id}">
                cot: <c:out value="${ longueur.cotation }"></c:out>
                </a>,
            </c:forEach>
        </c:forEach>
        <br/>
    </c:forEach>
</c:if>