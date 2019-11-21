<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesLayout.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesgeneral.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesbutton.css">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal" />
    <c:set var="isauth" value="${true}" scope="request"/>
</sec:authorize>
<div><tiles:insertAttribute name="header" /></div>
<div class="menu"><tiles:insertAttribute name="menu" /></div>
<div class="body"><tiles:insertAttribute name="body" /></div>
<div style="clear:both"><tiles:insertAttribute name="footer" /></div>

</body>
</html>