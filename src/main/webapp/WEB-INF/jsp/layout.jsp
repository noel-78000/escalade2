<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylesLayout.css">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<div><tiles:insertAttribute name="header" /></div>
<div class="menu"><tiles:insertAttribute name="menu" /></div>
<div class="body"><tiles:insertAttribute name="body" /></div>
<div style="clear:both"><tiles:insertAttribute name="footer" /></div>

</body>
</html>