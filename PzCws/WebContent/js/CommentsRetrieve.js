var app = angular.module('commentApp', []);
	app.controller('displayCommentsController', function($scope, $http) {
	  $http.get("http://localhost:8080/PzCws/comments/last/5")
	  .then(function (response) {$scope.latestComments = response.data.comment;});
	});