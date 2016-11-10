<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Registration new User</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="container" ng-controller="searchSiteRegistrationCtrl">
            <form novalidate name="registrationForm">
                <div class="row">
                    <div class="text-center text-uppercase"><h2>Registration Form</h2></div>
                </div>
                <div class="row" ng-show="registrate.hasError">
                    <div>
                        <h3>{{registrate.description}}</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="accountUsername">User name</label>
                        <span class="mandatory"></span>
                    </div>
                    <div class="col-sm-6"><input type="text" name="accountUsername" id="accountUsername"
                                                 ng-model="accountUsername" required></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="accountPassword">Password</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6"><input type="password" name="accountPassword" id="accountPassword"
                                                 ng-model="accountPassword"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="accountPassword2">Confirm Password</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6"><input type="password" name="accountPassword2" id="accountPassword2"
                                                 ng-model="accountPassword2"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userFirstName">First name</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6"><input type="text" name="userFirstName" id="userFirstName"
                                                 ng-model="userFirstName"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userLastName">Last name</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6"><input type="text" name="userLastName" id="userLastName"
                                                 ng-model="userLastName"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userMiddleName">Middle name</label></div>
                    <div class="col-sm-6"><input type="text" name="userMiddleName" id="userMiddleName"
                                                 ng-model="userMiddleName"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userGender">Gender</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6">
                        <input type="radio" name="userGender" id="userGender" value="m" ng-model="userGender">Male
                        <input type="radio" name="userGender" value="f" ng-model="userGender">Female
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userDateOfBirth">Date of birth</label></div>
                    <div class="col-sm-6"><input type="date" name="userDateOfBirth" id="userDateOfBirth"
                                                 ng-model="userDateOfBirth"></div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userEmail">Email</label>
                        <span class="mandatory"></span></div>
                    <div class="col-sm-6"><input type="email" name="userEmail" id="userEmail" ng-model="userEmail">
                    </div>
                </div>
                <%--<div class="phoneTypes" id="phoneTypesContainer">
                    <div class="phoneType" id="phoneType1">
                        <div class="row text-center">
                            <h3>1</h3>
                        </div>
                        <div class="row">
                            <div class="col-sm-6"><label for="userEmail">Phone type</label>
                                <span class="mandatory"></span></div>
                            <div class="col-sm-6">
                                <select>
                                    <option>1</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6"><label for="userEmail">Phone number</label>
                                <span class="mandatory"></span></div>
                            <div class="col-sm-6">
                                <input type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6"><label for="userEmail">
                        <button type="button">Add phone number</button>
                    </label></div>
                </div>--%>
                <div class="row">
                    <div class="col-sm-offset-6 col-sm-6">
                        <input type="hidden"
                               name="csrf_token_value"
                               ng-init="set('${_csrf.token}')" ng-model="csrf_token_value"/>
                        <button type="button" class="btn btn-danger" ng-click="reset();">Reset</button>
                        <span style="width: 1%;"></span>
                        <button type="button" class="btn btn-success" ng-click="registrate();">Registrate</button>
                        <button type="button" class="btn btn-success" ng-click="default();">Default</button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
