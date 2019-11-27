<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<c:if test="${ !empty site }">
    <div class="container">
        <div class="row">
            <h3 class="col-xl-12 col-xs-12"><spring:message code="clic.to.change"/>:</h3>
            <div class="col-lg-5 col-sm-6">
                <a href="${pageContext.request.contextPath}/site/change?id=${site.id}">
                    <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
                    <c:if test="${site.tag}"><img src="${pageContext.request.contextPath}/img/logoTag.png"/></c:if>
                </a>
            </div>
            <div class="col-lg-1 col-sm-1"></div>
            <div class="col-lg-6 col-sm-5">
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
            </div>
        </div>
    </div>
</c:if>