<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container-fluid col-xl-6 col-lg-7 col-md-9 col-sm-12">
<div class="container">
<form method="post" action="${pageContext.request.contextPath}/user/moncompte">
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="email"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="<c:out value="${email}"/>" name="email" readonly/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="password"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="password" name="password" maxlength="100">
        <c:if test="${!empty passworderror}">
            <p class="col-sm-12 text-right" style="color: red">${passworderror}</p>
        </c:if>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="password.confirm"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="password" name="passwordconfirm" maxlength="100">
        <c:if test="${!empty passworderror}">
            <p class="col-sm-12 text-right" style="color: red">${passworderror}</p>
        </c:if>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="fisrtname"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="${firstname}" name="firstname" maxlength="50"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="lastname"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="${lastname}" name="lastname" maxlength="50"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="phone.number"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="tel" value="${phonenumber}" name="phonenumber" maxlength="10"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="address"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="${address}" name="address" maxlength="255"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="city"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="${city}" name="city" maxlength="50"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="zip.code"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="tel" value="${zipcode}" name="zipcode" maxlength="5"/>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-5 col-sm-6"><spring:message code="country"/>:</div>
        <input class="col-lg-8 col-md-7 col-sm-6" type="text" value="${country}" name="country" maxlength="50"/>
    </div>
    <div class="row">
        <div>&nbsp;</div>
    </div>
    <div class="row">
        <div class="container-fluid col-xs-12">
            <div class="text-center">
                <input type="submit" class="boutonStyled" value="<spring:message code="button.submit.record"/>"/>
            </div>
        </div>
    </div>
</form>
<c:if test="${!empty message}"><p>${message}</p></c:if>
<c:if test="${!empty error}"><p style="color: red">${error}</p></c:if>
</div>
</div>