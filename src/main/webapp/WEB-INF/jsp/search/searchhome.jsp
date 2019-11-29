<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/search">
    <div class="container">
    <fieldset>
        <legend><spring:message code="search"/></legend>
            <div class="row">
                <label class="col-xl-2 col-lg-3 col-md-4 col-sm-5" for="lieu"><spring:message code="place"/> :</label>
                <input class="col-xl-4 col-lg-6 col-md-8 col-sm-7" type="text" name="lieu" id="lieu" placeholder="<spring:message code="place"/>" maxlength="100" autofocus="" />
            </div>
            <div class="row">
                <label class="col-xl-2 col-lg-3 col-md-4 col-sm-5" for="nombredesecteurs"><spring:message code="nber.sectors"/> :</label>
                <input class="col-xl-4 col-lg-6 col-md-8 col-sm-7" type="text" name="nombredesecteurs" id="nombredesecteurs" placeholder="<spring:message code="nber.sectors"/>">
            </div>
            <div class="row">
                <label class="col-xl-2 col-lg-3 col-md-4 col-sm-5" for="cotation"><spring:message code="cotation"/> :</label>
                <input class="col-xl-4 col-lg-6 col-md-8 col-sm-7" type="text" name="cotation" id="cotation" maxlength="3" placeholder="<spring:message code="cotation"/>">
            </div>
            <div class="row">
                <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.search"/>">
            </div>
    </fieldset>
    </div>
</form>
<c:if test="${!empty rechercheinfructueuse}"><p>${rechercheinfructueuse}</p></c:if>

<c:if test="${ !empty sitessommaire }">
    <c:forEach items="${sitessommaire}" var="sitesommaire" varStatus="status">
        <div class="container">
            <div class="row">
                <div class="col-xl-6 col-lg-6 col-md-8 col-sm-9 col-8">
                    <p>
                    <a href="${pageContext.request.contextPath}/search/site?id=${sitesommaire.id}">
                        N°${ status.count } : <c:out value="${sitesommaire.nom}"></c:out>, <c:out value="${sitesommaire.lieu}"></c:out>
                    </a>
                    <c:if test="${sitesommaire.tag}">
                        <img src="${pageContext.request.contextPath}/img/logoTag.png"/>
                    </c:if>
                    </p>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-4 col-sm-3 col-4">
                    <a href="${pageContext.request.contextPath}/site/details?id=${sitesommaire.id}"><span style="font-size: 0.8em">(<spring:message code="change"/>)</span></a>
                    <a href="${pageContext.request.contextPath}/comment/list?id=${sitesommaire.id}"><span style="font-size: 0.8em">(<spring:message code="comment.see"/>)</span></a>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="container">
        <div class="row">
            <form method="get" action="${pageContext.request.contextPath}/site/add">
                <input class="boutonStyled" type="submit" value="<spring:message code="add.new.site"/>">
            </form>
        </div>
    </div>
</c:if>

<c:if test="${!empty sites}">
    <hr/>
    <div class="container">
        <div class="row">
            <c:forEach items="${ sites }" var="site" varStatus="status">
                <div class="col-xl-4 col-lg-5 col-md-6 col-sm-6">
                    N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
                    <c:if test="${site.tag}">
                        <img src="${pageContext.request.contextPath}/img/logoTag.png"/>
                    </c:if>
                </div>
                <div class="col-xl-8 col-lg-7 col-md-6 col-sm-6">
                    <a href="${pageContext.request.contextPath}/site/details?id=${site.id}"><span style="font-size: 0.8em">(<spring:message code="change"/>)</span></a>
                    <a href="${pageContext.request.contextPath}/comment/list?id=${site.id}"><span style="font-size: 0.8em">(<spring:message code="comment.see"/>)</span></a>
                </div>
                <c:forEach items="${ site.secteurs }" var="secteur">

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                    <c:out value="${ secteur.nom }"></c:out>
                    <c:forEach items="${ secteur.voies }" var="voie">
                        <c:out value="${ voie.nom }" ></c:out>
                        <c:forEach items="${ voie.longueurs }" var="longueur">
                            cot: <c:out value="${ longueur.cotation }"></c:out>,
                        </c:forEach>
                    </c:forEach>
                </div>
                </c:forEach>
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                    <p>&nbsp;</p>
                </div>
            </c:forEach>

            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-9">
                <form method="get" action="${pageContext.request.contextPath}/site/add">
                    <input class="boutonStyled" type="submit" value="<spring:message code="add.new.site"/>">
                </form>
            </div>
        </div>
    </div>
</c:if>