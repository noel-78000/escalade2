<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <c:if test="${!empty toporesa}">
    <form method="post" action="${pageContext.request.contextPath}/personnalspace/toporesa/selected">

        <fieldset>
            <legend><spring:message code="topo.resa"/></legend>
            <input type="text" hidden value="${toporesa.id}" name="toporesaid"/>

            <div class="row">
                <div class="col-lg-4 col-md-5 col-sm-6 col-5"><spring:message code="topo.lieu"/>:</div>
                <div class="col-lg-8 col-md-7 col-sm-6 col-7"><c:out value="${toporesa.topo.lieu}"/></div>
            </div>
            <div class="row">&nbsp;</div>
            <div class="row">
                <div class="col-lg-4 col-md-5 col-sm-6 col-5"><spring:message code="topo.description"/>:</div>
                <div class="col-lg-8 col-md-7 col-sm-6 col-7"><c:out value="${toporesa.topo.description}"/></div>
            </div>
            <div class="row">&nbsp;</div>
            <div class="row">
                <div class="col-lg-4 col-md-5 col-sm-6 col-5"><spring:message code="topo.resa"/>:</div>
                <div class="col-lg-8 col-md-7 col-sm-6 col-7">
                        <c:out value="${toporesa.user.firstName}"/> <c:out value="${toporesa.user.lastName}"/><br/>
                        <c:out value="${toporesa.user.email}"/><br/>
                        <c:out value="${toporesa.user.phonenumber}"/>
                </div>
            </div>
            <div class="row">&nbsp;</div>
            <div class="row">
                <div class="col-lg-4 col-md-5 col-sm-6 col-5"><spring:message code="topo.resa.accept"/>:</div>
                <div class="col-lg-8 col-md-7 col-sm-6 col-7"><input type="checkbox" name="acceptresa" <c:if test="${toporesa.acceptResa}">checked</c:if>/></div>
            </div>
            <div class="row">&nbsp;</div>
            <div class="row">
                <div class="col-lg-4 col-md-5 col-sm-6 col-5">&nbsp;</div>
                    <div class="col-lg-8 col-md-7 col-sm-6 col-7">
                        <input formaction="${pageContext.request.contextPath}/personnalspace/toporesa/selected"
                               class="boutonStyled" type="submit" value="<spring:message code="button.submit.record"/>" />
                        <input onclick="window.location='${pageContext.request.contextPath}/personnalspace/'" formmethod="get"
                               class="boutonStyled" type="button" value="<spring:message code="button.submit.cancel"/>" />
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
    </c:if>
    <c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
</div>

