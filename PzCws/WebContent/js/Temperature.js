
	var app = angular.module('myApp', []);
	app.controller('latestTemp', function($scope, $http) {
	  $http.get("http://localhost:8080/PzCws/measurements/latest")
	  .then(function (response) {$scope.latestTemperature = response.data.records;});
	});