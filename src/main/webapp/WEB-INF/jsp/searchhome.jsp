<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${empty sites}">
<form method="post" action="${pageContext.request.contextPath}/search">
    <fieldset>
        <legend>Recherche</legend>
        <label for="lieu">lieu :</label>
        <input type="text" name="lieu" id="lieu" placeholder="lieu" size="10" maxlength="100" autofocus="" />
        <br/>
        <label for="nombredesecteurs">nombre de secteurs :</label>
        <input type="text" name="nombredesecteurs" id="nombredesecteurs" placeholder="">
        <br/>
        <label for="cotation">cotation :</label>
        <input type="text" name="cotation" id="cotation" size="3" maxlength="3">
        <br/>

        <input class="boutonStyled" type="submit" value="Rechercher">
    </fieldset>
</form>
</c:if>
<c:if test="${!empty rechercheinfructueuse}"><p>${rechercheinfructueuse}</p></c:if>
<c:if test="${!empty sites}">
    <c:forEach items="${ sites }" var="site" varStatus="status">
        <p>N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out>
            <a href="${pageContext.request.contextPath}/site/details?id=${site.id}"><span style="font-size: 0.8em">(modifier)</span></a> </p>
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
</c:if>