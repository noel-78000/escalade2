<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table>
    <tr>
        <td>
            <button class="boutonStyled" onclick="window.location.href='${pageContext.request.contextPath}/personnalspace/topo/add?userid=${user.id}'">
                <spring:message code="button.submit.add.topo"/>
            </button>
        </td>
    </tr>
</table>
