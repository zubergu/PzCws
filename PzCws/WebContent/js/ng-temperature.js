
	var app = angular.module('latestMeasurements', []);
	app.controller('latestMeas', function($scope, $http) {
	  $http.get("http://localhost:8080/PzCws/measurements/latest")
	  .then(function (response) {$scope.latestMeasurement = response.data.measurement;});
	});