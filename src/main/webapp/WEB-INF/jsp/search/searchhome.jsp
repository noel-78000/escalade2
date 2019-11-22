<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/search">
    <fieldset>
        <legend><spring:message code="search"/></legend>
        <label for="lieu"><spring:message code="place"/> :</label>
        <input type="text" name="lieu" id="lieu" placeholder="<spring:message code="place"/>" size="10" maxlength="100" autofocus="" />
        <br/>
        <label for="nombredesecteurs"><spring:message code="nber.sectors"/> :</label>
        <input type="text" name="nombredesecteurs" id="nombredesecteurs" placeholder="">
        <br/>
        <label for="cotation"><spring:message code="cotation"/> :</label>
        <input type="text" name="cotation" id="cotation" size="3" maxlength="3">
        <br/>

        <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.search"/>">
    </fieldset>
</form>
<c:if test="${!empty rechercheinfructueuse}"><p>${rechercheinfructueuse}</p></c:if>

<c:if test="${ !empty sitessommaire }">
    <c:forEach items="${sitessommaire}" var="sitesommaire" varStatus="status">
        <a href="${pageContext.request.contextPath}/search/site?id=${sitesommaire.id}">
            <p>N°<c:out value="${ status.count }" /> : <c:out value="${sitesommaire.nom}"></c:out>, <c:out value="${sitesommaire.lieu}"></c:out>
        </a>
        <c:if test="${sitesommaire.tag}">
            <img src="${pageContext.request.contextPath}/img/logoTag.png"/>
        </c:if>
        &nbsp<a href="${pageContext.request.contextPath}/site/details?id=${sitesommaire.id}"><span style="font-size: 0.8em">(<spring:message code="change"/>)</span></a>
        &nbsp<a href="${pageContext.request.contextPath}/comment/list?id=${sitesommaire.id}"><span style="font-size: 0.8em">(<spring:message code="comment.see"/>)</span></a>
            </p>
    </c:forEach>
    <form method="get" action="${pageContext.request.contextPath}/site/add">
        <input class="boutonStyled" type="submit" value="<spring:message code="add.new.site"/>">
    </form>
</c:if>

<c:if test="${!empty sites}">
    <hr/>
    <c:forEach items="${ sites }" var="site" varStatus="status">
        <p>N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
            <c:if test="${site.tag}">
                <img src="${pageContext.request.contextPath}/img/logoTag.png"/>
            </c:if>
            <a href="${pageContext.request.contextPath}/site/details?id=${site.id}"><span style="font-size: 0.8em">(<spring:message code="change"/>)</span></a>
            <a href="${pageContext.request.contextPath}/comment/list?id=${site.id}"><span style="font-size: 0.8em">(<spring:message code="comment.see"/>)</span></a></p>
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
        <br/>
    </c:forEach>
    <form method="get" action="${pageContext.request.contextPath}/site/add">
        <input class="boutonStyled" type="submit" value="<spring:message code="add.new.site"/>">
    </form>
</c:if>