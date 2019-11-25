<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>
    <tr>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/add'">
                <spring:message code="button.submit.topo.add"/>
            </button>
        </td>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/list'">
                <spring:message code="button.submit.topo.list"/>
            </button>
        </td>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/myresas'">
                <spring:message code="button.submit.topo.resa.list.mine"/>
            </button>
        </td>
    </tr>
</table>

<c:if test="${!empty topoinfos}">
    <hr>
    <table>
        <c:forEach items="${topoinfos}" var="topoinfo">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/personnalspace/topo/change?topoid=${topoinfo.id}">
                        <c:out value="${topoinfo.lieu}"/>
                    </a>
                </td>
                <td>
                    <div class="centerBlocHead">
                        <c:out value="${topoinfo.description}"/>
                    </div>
                </td>
                <td>
                     ${topoinfo.dtParutionFormated}
                </td>
                <td>
                    <input type="checkbox" id="disporesa" disabled="disabled" <c:if test="${topoinfo.dispoResa}">checked</c:if>/>
                    <label for="disporesa"><spring:message code="topo.pret.dispo"/></label>
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
    </table>
</c:if>