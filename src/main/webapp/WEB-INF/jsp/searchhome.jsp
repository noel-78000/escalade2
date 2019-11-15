
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylessearch.css">
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

        <input class="styled" type="submit" value="Rechercher">
    </fieldset>
</form>

<c:if test="${empty sites}">Aucun resultats
</c:if>
<c:if test="${!empty sites}">
    <c:forEach items="${ sites }" var="site" varStatus="status">
        <p>N°<c:out value="${ status.count }" /> : <c:out value="${site.nom}"></c:out>, <c:out value="${site.lieu}"></c:out></p>
        <c:forEach items="${ site.secteurs }" var="secteur">
            <c:out value="${ secteur.nom }"></c:out>
            <c:forEach items="${ secteur.voies }" var="voie">
                <c:out value="${ voie.nom }" ></c:out>
                <c:forEach items="${ voie.longueurs }" var="longueur">
                    cot : <c:out value="${ longueur.cotation }"></c:out>
                </c:forEach>
            </c:forEach>
        </c:forEach>
        <br/>
    </c:forEach>
</c:if>