<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="container-fluid col-xl-5 col-lg-6 col-md-7 col-sm-8">
    <fieldset>
        <legend><spring:message code="login.please"/>!</legend>
        <c:if test="${param.error != null}"><p style="color: red"><spring:message code="login.invalid"/>.</p></c:if>
        <c:if test="${param.logout != null}"><p><spring:message code="logout.ok"/>.</p></c:if>
            <div class="row">
                <label class="col-sm-5" for="username"><spring:message code="login.username"/></label>
                <input class="col-sm-7" type="email" id="username" name="username" autofocus autocomplete="off"/>
            </div>

            <div class="row">
                <label class="col-sm-5" for="password"><spring:message code="login.password"/></label>
                <input class="col-sm-7" type="password" id="password" name="password"/>
            </div>
        <div class="row">
            <div>&nbsp;</div>
        </div>
            <div class="row">
                <div class="container-fluid col-sm-12">
                    <div class="text-center">
                        <button type="submit" class="boutonStyled"><spring:message code="login.submit"/></button>
                    </div>
                </div>
            </div>
    </fieldset>
    </div>
</form>