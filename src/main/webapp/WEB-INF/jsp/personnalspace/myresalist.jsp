<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid col-xs-10 col-sm-9 col-md-8 col-lg-7 col-xl-6">
<c:if test="${!empty toporesas}">
    <c:forEach items="${toporesas}" var="toporesa">
        <form method="post" action="${pageContext.request.contextPath}/personnalspace/toporesa/delete">
            <fieldset>
                <legend><spring:message code="topo"/> <c:out value="${toporesa.topo.user.firstName}"/> <c:out value="${toporesa.topo.user.lastName}"/> </legend>
                <input type="text" hidden value="${toporesa.id}" name="toporesaid"/>
                <div><c:out value="${toporesa.topo.lieu}"/></div>
                <div><c:out value="${toporesa.topo.description}"/></div>
                <c:if test="${!toporesa.acceptResa}">
                    <div><spring:message code="topo.resa.accept.waiting"/> </div>
                </c:if>
                <c:if test="${toporesa.acceptResa}">
                    <div>
                        <div><spring:message code="topo.resa.accept"/></div>
                        <div><c:out value="${toporesa.topo.user.email}"/><div>
                        <div><c:out value="${toporesa.topo.user.phonenumber}"/></div>
                    </div>
                </c:if>
                 <div>
                     <input class="boutonStyled" type="submit" value="<spring:message code="button.submit.delete"/>"/>
                 </div>
            </fieldset>
        </form>
        <div class="row">&nbsp;</div>
        <div class="row">&nbsp;</div>
    </c:forEach>
</c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
</div>
