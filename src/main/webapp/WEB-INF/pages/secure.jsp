<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        secure!
    </tiles:putAttribute>
</tiles:insertDefinition>
