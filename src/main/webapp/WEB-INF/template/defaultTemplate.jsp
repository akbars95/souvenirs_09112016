<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="css"/>
    <tiles:insertAttribute name="js"/>
</head>
<body>

<div class="container" ng-app="searchSiteApp" ng-cloak>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="menu"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>
</div>

</body>
</html>
