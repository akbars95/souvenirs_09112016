searchSiteApp.controller("searchSiteLoginCtrl", function ($scope, $http, contextPath) {
    $scope.reset = function () {
        $scope.s_username = "";
        $scope.s_password = "";
        $scope.s_remember_me = false;
    };

});

searchSiteApp.controller("searchSiteRegistrationCtrl", function ($scope, $http, contextPath, restServicePath, success, error) {

    $scope.set = function (token) {
        $scope.csrf_token_value = token;
    };

    $scope.reset = function () {
        $scope.accountUsername = "";
        $scope.accountPassword = "";
        $scope.accountPassword2 = "";
        $scope.userFirstName = "";
        $scope.userLastName = "";
        $scope.userMiddleName = "";
        $scope.userGender = "";
        $scope.userDateOfBirth = "";
        $scope.userEmail = "";
    };

    $scope.registrateResult = {
        hasError: false,
        description: undefined
    };

    $scope.default = function(){
        var rand = Math.round(Math.random() * 100);
        $scope.accountUsername = "alex." + rand + "user";
        $scope.accountPassword = "Alex" + rand + "#";
        $scope.accountPassword2 = $scope.accountPassword;
        $scope.userFirstName = "Alexei";
        $scope.userLastName = "Iliya";
        $scope.userMiddleName = "Ivan";
        $scope.userGender = "M";
        //02.12.2010 23:12:02:000
        $scope.userEmail = "alexei.iliya" + rand + "@mail.md";
    };

    $scope.registrate = function () {
        var dataObject = {
            accountUsername: $scope.accountUsername,
            accountPassword: $scope.accountPassword,
            accountPassword2: $scope.accountPassword2,
            userFirstName: $scope.userFirstName,
            userLastName: $scope.userLastName,
            userMiddleName: $scope.userMiddleName,
            userGender: $scope.userGender,
            userDateOfBirth: /*$scope.userDateOfBirth*/"19.10.1983",
            userEmail: $scope.userEmail
        };

        var config = {
            headers: {
                /*'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;',
                 */'Content-Type': 'application/json;charset=utf-8;',
                'X-XSRF-TOKEN': $scope.csrf_token_value
            }
        };

        $http.post(contextPath + restServicePath + "/registration", dataObject, config)
            .then(
                function (response) {
                    if (response.status = 200 && response.data) {
                        $scope.registrateResult = {
                            hasError: false,
                            description: response.data.messageErrorDescription
                        };
                    } else {
                        $scope.registrateResult = {
                            hasError: true,
                            description: response.data.messageErrorDescription
                        };
                    }
                },
                function (response) {
                    // failure callback
                }
            );
    };

});