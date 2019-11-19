<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
    <h3>Cliquer sur ce que vous voulez modifier:</h3>
    <p>
        <a href="${pageContext.request.contextPath}/site/change?id=${site.id}">
            <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
        </a>
    </p>
    <c:forEach items="${ site.secteurs }" var="secteur">
        <a href="${pageContext.request.contextPath}/secteur/change?id=${secteur.id}&siteId=${site.id}">
            <c:out value="${ secteur.nom }"></c:out>
        </a>,
        <c:forEach items="${ secteur.voies }" var="voie">
            <a href="${pageContext.request.contextPath}/voie/change?id=${voie.id}&siteId=${site.id}">
                <c:out value="${ voie.nom }" ></c:out>
            </a>,
            <c:forEach items="${ voie.longueurs }" var="longueur">
                <a href="${pageContext.request.contextPath}/longueur/change?id=${longueur.id}&siteId=${site.id}">
                cot: <c:out value="${ longueur.cotation }"></c:out>
                </a>,
            </c:forEach>
        </c:forEach>
        <br/>
    </c:forEach>
</c:if>