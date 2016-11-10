<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <a href="<c:url value="/login"/>">Log in</a><br>
        <a href="<c:url value="/secure"/>">Secure</a>
    </tiles:putAttribute>
</tiles:insertDefinition>
