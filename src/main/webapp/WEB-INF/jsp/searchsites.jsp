<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty sites }">
    <c:forEach items="${sites}" var="site" varStatus="status">
        <a href="${pageContext.request.contextPath}/search/site?id=${site.id}">
            <p>N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out></p>
        </a>
    </c:forEach>
</c:if>
<c:if test="${ !empty site }">
    <p><c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out></p>
    <c:forEach items="${ site.secteurs }" var="secteur">
        <c:out value="${ secteur.nom }"></c:out>
        <c:forEach items="${ secteur.voies }" var="voie">
            <c:out value="${ voie.nom }" ></c:out>
            <c:forEach items="${ voie.longueurs }" var="longueur">
                cot: <c:out value="${ longueur.cotation }"></c:out>,
            </c:forEach>
        </c:forEach>
        <br/>
    </c:forEach>
</c:if>