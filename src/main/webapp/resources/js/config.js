/**
 * Created by dminzat on 8/10/2016.
 */
searchSiteApp.config(['$httpProvider', function($httpProvider){
    $httpProvider.interceptors.push('AuthInterceptor');
}]);