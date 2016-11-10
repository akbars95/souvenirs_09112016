<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blockCenter" ng-controller="searchSiteLoginCtrl">
    <form action="${loginVar}" method="POST" name="loginForm" novalidate>
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
                <label for="s_username">Login</label>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-9 col-lg-9">
                <input type="text" id="s_username" name="s_username" ng-model="s_username" required>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
                <label for="s_password">Password</label>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-9 col-lg-9">
                <input type="password" id="s_password" name="s_password" ng-model="s_password" required>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
                <label for="s_remember_me">Remember me</label>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-9 col-lg-9">
                <input type="checkbox" id="s_remember_me" name="s_remember_me" ng-model="s_remember_me">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <c:if test="${error != null}">
                    <%--<p>Invalid Username or password!</p>--%>
                    <p class="error">${error}</p>
                </c:if>
                <%--<c:if test="${param.logout != null}">--%>
                <c:if test="${logout != null}">
                    <%--<p>You have successfully been logged out</p>--%>
                    <p class="label-info">${logout}</p>
                </c:if>
                <c:if test="${expired != null}">
                    <%--<p>You have successfully been logged out</p>--%>
                    <p class="label-danger">${expired}</p>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-3 col-lg-3">
                <button type="button" class="btn btn-danger" ng-click="reset()" ng-disabled="isDisabledReset">Reset</button>
            </div>
            <div class="col-xs-7 col-sm-7 col-md-9 col-lg-9">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input class="btn btn-default" ng-disabled="loginForm.s_username.$invalid || loginForm.s_password.$invalid" type="submit" value="Log In">
            </div>
        </div>
    </form>
</div>