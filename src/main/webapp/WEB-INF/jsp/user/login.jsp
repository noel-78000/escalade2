<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="container">
    <fieldset>
        <legend><spring:message code="login.please"/>!</legend>
        <c:if test="${param.error != null}"><p style="color: red"><spring:message code="login.invalid"/>.</p></c:if>
        <c:if test="${param.logout != null}"><p><spring:message code="logout.ok"/>.</p></c:if>
            <div class="row">
                <label class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xm-5" for="username"><spring:message code="login.username"/></label>
                <input class="col-xl-4 col-lg-4 col-md-4 col-sm-6 col-xm-7" type="email" id="username" name="username" autofocus autocomplete="off"/>
            </div>

            <div class="row">
                <label class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xm-5" for="password"><spring:message code="login.password"/></label>
                <input class="col-xl-4 col-lg-4 col-md-4 col-sm-6 col-xm-7" type="password" id="password" name="password"/>
            </div>

            <div class="row">
                <div class="form-actions">
                    <button type="submit" class="boutonStyled"><spring:message code="login.submit"/></button>
                </div>
            </div>
    </fieldset>
    </div>
</form>