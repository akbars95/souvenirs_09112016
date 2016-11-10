<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="page_404">
        <div class="content">
            <h1>Page Not Found, 404!</h1>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
