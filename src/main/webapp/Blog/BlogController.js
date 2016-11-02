'use strict';
 
angular.module('myApp').controller('BlogController', ['$scope', 'BlogService', '$location', '$rootScope', function($scope, BlogService,$location,$rootScope) {
	
	var self = this;
    self.blog={id:'', userId:'', title:'', status:'', description:'', errorMessage:'', errorCode:'', };
    self.blogs=[];

//    self.submit = submit;
//    self.edit = edit;
//    self.remove = remove;
//    self.reset = reset;
 
 
    self.fetchAllBlog = function (){
        BlogService.fetchAllBlog()
            .then(
            function (d){
            	self.blogss = d;
            },
            function(errResponse){
                console.error('Error while fetching Blog');
            }
        );
    };
    
 
    self.createBlog = function (blog){
        BlogService.createBlog(blog)
            .then(
            
            	self.fetchAllBlog,
            
            function(errResponse){
                console.error('Error while creating Blog');
            }
        );
    };
 
    self.updateBlog = function (blog, id){
        BlogService.updateBlog(blog, id)
            .then(
            self.fetchAllBlogs,
            function(errResponse){
                console.error('Error while updating Blog');
            }
        );
    };
 
  
 
    self.submit = function () {
 
        	  console.log('Saving new Blog ', self.blog);
        	  self.createBlog(self.blog);
//        	  $location.path('/welcome');
 
        
        self.reset();
    };
 
    self.reset = function (){
    	self.blog={id:'', userId:'', title:'', status:'', description:'', errorMessage:'', errorCode:'', };
        $scope.myForm.$setPristine(); //reset Form
    }

}]);