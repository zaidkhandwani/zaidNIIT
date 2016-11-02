'use strict';
 
angular.module('myApp').factory('BlogService', ['$http', '$q', '$rootScope', '$location', function($http, $q, $rootScope, $location){
	console.log("Blog Service active...")
	
    var BASE_URL='http://localhost:8051/hubback'
 
    var factory = {
        fetchAllBlog: fetchAllBlog,
        createBlog: createBlog,
        updateBlog:updateBlog,
        deleteBlog:deleteBlog,
        
    };
 
    return factory;
 
    function fetchAllBlog() {
        var deferred = $q.defer();
        $http.get(BASE_URL+'/Blogs/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function fetchPendingBlog() {
        var deferred = $q.defer();
        $http.get(BASE_URL+'/BlogsPending/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Pending Blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    
    function createBlog(blog) {
        var deferred = $q.defer();
        $http.post(BASE_URL+'/BlogSave/', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Blog');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateBlog(blog) {
        var deferred = $q.defer();
        $http.put(BASE_URL+'/ApproveBlog/'+blog.id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while approving Blog');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteBlog(blog) {
        var deferred = $q.defer();
        $http.delete(BASE_URL+'/Blog/'+blog.id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Blog');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);