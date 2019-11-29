<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid col-xl-8 col-lg-9 col-md-10 col-sm-12">
    <div class="row">
        <div class="col-sm-4">
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/add'">
                <spring:message code="button.submit.topo.add"/>
            </button>
        </div>
        <div class="col-sm-4">
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/list'">
                <spring:message code="button.submit.topo.list"/>
            </button>
        </div>
        <div class="col-sm-4">
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/myresas'">
                <spring:message code="button.submit.topo.resa.list.mine"/>
            </button>
        </div>
    </div>
</div>

<c:if test="${!empty topoinfos}">
    <hr>
    <table class="table table-striped table-bordered">

        <thead>
        <tr>
            <th scope="col"><spring:message code="place.maj"/></th>
            <th scope="col"><spring:message code="description"/></th>
            <th scope="col" class="hideOnPhone"><spring:message code="publication"/></th>
            <th scope="col"><spring:message code="available"/></th>
            <th scope="col"><spring:message code="booked"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${topoinfos}" var="topoinfo">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/personnalspace/topo/change?topoid=${topoinfo.id}">
                        <c:out value="${topoinfo.lieu}"/>
                    </a>
                </td>
                <td>
                    <div class="monBlocTable">
                        <p><c:out value="${topoinfo.description}"/></p>
                    </div>
                </td>
                <td class="hideOnPhone">
                     ${topoinfo.dtParutionFormated}
                </td>
                <td>
                    <input type="checkbox" id="disporesa" disabled="disabled" <c:if test="${topoinfo.dispoResa}">checked</c:if>/>
                    <label class="hideOnPhone" for="disporesa"><spring:message code="topo.pret.dispo"/></label>
                </td>
                <td>
                    <c:forEach items="${topoinfo.topoResas}" var="toporesa">
                        <a href="${pageContext.request.contextPath}/personnalspace/toporesa/selected?toporesaid=${toporesa.id}">
                            <p><c:out value="${toporesa.user.firstName}"/> <c:out value="${toporesa.user.lastName}"/></p>
                        </a>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>