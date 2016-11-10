/**
 * Created by dminzat on 8/10/2016.
 */
searchSiteApp.factory('AuthInterceptor', [
    function(){
        return {
            'request' : function(config){
                config.headers = config.headers || {};
                var encodedString = btoa("bill:abc123");
                config.headers.Authorization = 'Basic ' + encodedString;
                return config;
            }
        };
    }
]);