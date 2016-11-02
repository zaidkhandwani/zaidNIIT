'use strict';
 
angular.module('myApp').factory('UserService', ['$http', '$q', '$rootScope', '$location', function($http, $q, $rootScope, $location){
	console.log("User Service active...")
	
    var BASE_URL='http://localhost:8051/hubback'
 
    var factory = {
        fetchAllUsers: fetchAllUsers,
        fetchAllPendingUsers: fetchAllPendingUsers,
        createUser: createUser,
        updateUser:updateUser,
        deleteUser:deleteUser,
        authenticate:authenticate
    };
 
    return factory;
 
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(BASE_URL+'/UserDetails/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchAllPendingUsers() {
        var deferred = $q.defer();
        $http.get(BASE_URL+'/UserDetailsPending/')
            .then(
            function (response) {
                deferred.resolve(response.data);
                console.log('userService data: ', response.data);
             
            },
            function(errResponse){
                console.error('Error while fetching Pending Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(BASE_URL+'/UserSave/', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
                $location.path('/rsuccess');
                console.log('after path');
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateUser(user, userId) {
        var deferred = $q.defer();
        $http.put(BASE_URL+userId, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(BASE_URL+userId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function authenticate(user) {
        var deferred = $q.defer();
        $http.post(BASE_URL+'/UserValidate/', user)
            .then(
            function (response) {
//                deferred.resolve(response.data);
               
                $rootScope.currentUser = {username:response.data.name, userId:response.data.userId, role:response.data.role,errorMessage:response.data.errorMessage,};
                console.log('errorMessage: '+$rootScope.currentUser.errorMessage);
                console.log('Name='+$rootScope.currentUser.username)
                if($rootScope.currentUser.errorMessage==null){
                	$location.path("/test");
                }
                else{$location.path("/")}
            },
            function(errResponse){
                console.error('Error while authenticating User');
//                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);