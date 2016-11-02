'use strict';
 
angular.module('myApp').controller('UserController', ['$scope', 'UserService', '$location', '$rootScope', function($scope, UserService,$location,$rootScope) {
	
	var self = this;
    self.user={userId:'', name:'',password:'', mobile:'',role:'',email:'', errorMessage:'', errorCode:'', };
    self.users=[];

//    self.submit = submit;
//    self.edit = edit;
//    self.remove = remove;
//    self.reset = reset;
 
 
    self.fetchAllUsers = function (){
        UserService.fetchAllUsers()
            .then(
            function (d){
            	self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching User');
            }
        );
    };
    self.fetchAllPendingUsers = function (){
        UserService.fetchAllPendingUsers()
            .then(
            function (d){
            	self.users = d;
            	console.log('userController data : ', self.users);
            	   $location.path("/viewrr");
            },
            function(errResponse){
                console.error('Error while fetching User');
            }
        );
    };
 
    self.createUser = function (user){
        UserService.createUser(user)
            .then(
            
            	self.fetchAllUsers,
            
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    };
 
    self.updateUser = function (user, id){
        UserService.updateUser(user, id)
            .then(
            self.fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    };
 
  
 
    self.submit = function () {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
//            updateUser(self.user, self.user.id);
//            console.log('User updated with id ', self.user.id);
        	  console.log('Saving new user 2', self.user);
        	  self.createUser(self.user);
        	 
 
        }
        self.reset();
    };
 
    self.reset = function (){
        self.user={userId:'',name:'',password:'', mobile:'',userType:'',email:'',errorMessage:'',errorCode:'', };
        $scope.myForm.$setPristine(); //reset Form
    }
    
    self.authenticate = function (user){
        UserService.authenticate(user)
        .then(
                function (d){
                	self.user = d;	
                },
                function(errResponse){
                    console.error('Error while Authenticating User');
                }
            );
    };
    
    self.login= function(){
    {
    	console.log('In ctrl.login with' , self.user);
    	self.authenticate(self.user);
    	
    	
    }
    };
    

}]);