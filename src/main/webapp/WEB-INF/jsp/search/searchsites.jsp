<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty sites }">
    <c:forEach items="${sites}" var="site" varStatus="status">
        <a href="${pageContext.request.contextPath}/search/site?id=${site.id}">
            <p>N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out></p>
        </a>
    </c:forEach>
</c:if>
<c:if test="${ !empty site }">
    <div class="container">
        <div class="row">
            <p><c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
                <c:if test="${site.tag}"><img src="${pageContext.request.contextPath}/img/logoTag.png"/></c:if>
            </p>
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
        </>
    </div>
</c:if>