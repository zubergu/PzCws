  var myapp = angular.module("myapp", [])
     .controller("MyController", function($scope, $http) {
       $scope.subscriber = {};

     $scope.subscriber.submitTheForm = function(item, event) {
       console.log("--> Submitting form");
       var subscriber = { "subscriber" : {
    	   
          userFirstName : $scope.subscriber.userFirstName
          ,userLastName  : $scope.subscriber.userLastName
          ,email : $scope.subscriber.email
       }
       };

       var responsePromise = $http.post("http://localhost:8080/PzCws/subscriptions/add", subscriber, {});
       responsePromise.success(function(dataFromServer, status, headers, config) {
          console.log(dataFromServer.title);
       });
        responsePromise.error(function(data, status, headers, config) {
          alert("Submitting form failed!");
       });
     }

  });