var commentApp = angular.module("commentApp", [])
	commentApp.controller("CommentsController", function($scope, $http) {
    $scope.comment = {};

    $scope.comment.submitTheForm = function(item, event) {
    	console.log("--> Submitting form");
    	var comment = { "comment" : {
    		userName : $scope.comment.userName
    		,userComment  : $scope.comment.userComment
       		}
    	};

    	var responsePromise = $http.post("http://localhost:8080/PzCws/comments/add", comment, {});
    	responsePromise.success(function(dataFromServer, status, headers, config) {
    		console.log(dataFromServer.title);
    	});
        responsePromise.error(function(data, status, headers, config) {
        	alert("Submitting form failed!");
        });
	}
    
	$http.get("http://localhost:8080/PzCws/comments/last/5")
    .then(function (response) {$scope.latestComments = response.data;});

});