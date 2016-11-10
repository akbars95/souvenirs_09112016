<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <h1>Access denied, 403 error!</h1>
        <p>Dear <strong><sec:authentication property="name"/></strong>, you are not authorized to access this page</p>
    </tiles:putAttribute>
</tiles:insertDefinition>
