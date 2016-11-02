
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "home.html",
        controller : "UserController"
    })
  
    .when("/test", {
        templateUrl : "test.html",
        controller : "UserController"
    })
    .when("/viewrr", {
        templateUrl : "viewrr.html",
        controller : "UserController"
    })
    .when("/rsuccess", {
        templateUrl : "rsuccess.html",
        controller : "UserController"
    })
    
});

