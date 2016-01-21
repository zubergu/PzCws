var postApp = angular.module('postApp', []);
    
    postApp.controller('postController', function($scope, $http, $window) {
     
        $scope.commment = {};
      
        $scope.submitForm = function($window) {
        
        $http({
          method  : 'POST',
          url     : '/PzCws/comments/add',
          data    : $scope.comment, //forms user object
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
            if (data.errors) {
              
              $scope.errorName = data.errors.name;
              $scope.errorUserName = data.errors.username;
              $scope.errorEmail = data.errors.email;
            } else {
              $scope.message = data.message;
             
            }
          });
        
        $window.location.reload();
        };
        
        
    });