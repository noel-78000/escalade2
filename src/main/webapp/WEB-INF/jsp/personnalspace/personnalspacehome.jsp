<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>
    <tr>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/add?userid=${user.id}'">
                <spring:message code="button.submit.topo.add"/>
            </button>
        </td>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/list?userid=${user.id}'">
                <spring:message code="button.submit.topo.list"/>
            </button>
        </td>
    </tr>
</table>
<hr>

<c:if test="${!empty topoinfos}">
    <table>
        <c:forEach items="${topoinfos}" var="topoinfo">
            <tr>
                <td>
                    <c:out value="${topoinfo.lieu}"/>
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
                        <p><c:out value="${toporesa.user.firstName}"/> <c:out value="${toporesa.user.lastName}"/></p>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>