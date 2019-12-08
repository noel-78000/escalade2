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
            <div class="col-lg-3 col-md-4 col-sm-5 col-5"><c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
                <c:if test="${site.tag}"><img src="${pageContext.request.contextPath}/img/logoTag.png"/></c:if>
            </div>
            <div class="col-lg-1 col-md-1 col-sm-1">&nbsp;</div>
            <div class="col-lg-8 col-md-7 col-sm-5 col-6">
            <c:forEach items="${ site.secteurs }" var="secteur">
                <c:out value="${ secteur.nom }"></c:out>
                <ul>
                <c:forEach items="${ secteur.voies }" var="voie">
                    <li><c:out value="${ voie.nom }" ></c:out></li>
                    <ul>
                    <c:forEach items="${ voie.longueurs }" var="longueur">
                        <li>cot: <c:out value="${ longueur.cotation }"></c:out></li>
                    </c:forEach>
                    </ul>
                </c:forEach>
                </ul>
                <br/>
            </c:forEach>
            </div>
        </div>
    </div>
</c:if>