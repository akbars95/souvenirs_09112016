<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="header" style="outline: 1px solid chartreuse; width: 100%; height: 50px;">
    <div class="row">
        <div class="col-sm-8"></div>
        <div class="col-sm-4">
            <sec:authorize access="authenticated" var="authenticated"/>
            <c:choose>
                <c:when test="${authenticated}">
                    <p>Welcome,
                            <sec:authentication property="name"/>
                        <a id="logout" href="#">Log Out</a>
                    <form id="logout-form" action="<c:url value="/logout"/>" method="POST">
                        <sec:csrfInput/>
                    </form>
                    </p>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/login"/>">Log In</a> or <a href="<c:url value="/registration"/>">Registration</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>