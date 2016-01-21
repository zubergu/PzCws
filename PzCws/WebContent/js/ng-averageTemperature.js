var app = angular.module('averageTemperature', [ 'ngMaterial' ]);

app.controller(
				'avrgTemp',
				function($scope, $http, $filter) {

					$scope.myDate = new Date();

					$scope.show = function(item, event) {
						var date = $filter('date')($scope.myDate, 'yyyy-MM-dd');
						$http.get("http://localhost:8080/PzCws/measurements/average/temperature/date",
										{
											params : {
												date : date
											}
										}).then(function(response) {
									$scope.averageTemperature = response.data
								});
						
						$http.get("http://localhost:8080/PzCws/measurements/min/temperature/date",
								{
									params : {
										date : date
									}
								}).then(function(response) {
							$scope.minTemperature = response.data
						});
						
						
						$http.get("http://localhost:8080/PzCws/measurements/max/temperature/date",
								{
									params : {
										date : date
									}
								}).then(function(response) {
							$scope.maxTemperature = response.data
						});
					}
				});

app.controller(
				'avrgTempPeriod',
				function($scope, $http, $filter) {

					$scope.myStartDate = new Date();
					$scope.myEndDate = new Date();

					$scope.showPeriod = function(item, event) {
						var startDate=$filter('date')($scope.myStartDate,'yyyy-MM-dd');
					  	var endDate = $filter('date')($scope.myEndDate,'yyyy-MM-dd');
						$http.get("http://localhost:8080/PzCws/measurements/average/temperature/period",
										{
											params : {startDate:startDate, endDate:endDate}
										}).then(function(response) {
									$scope.averageTemperaturePeriod = response.data
								});
						
						
						$http.get("http://localhost:8080/PzCws/measurements/min/temperature/period",
								{
									params : {startDate:startDate, endDate:endDate}
								}).then(function(response) {
							$scope.minTemperaturePeriod = response.data
						});
						
						
						$http.get("http://localhost:8080/PzCws/measurements/max/temperature/period",
								{
									params : {startDate:startDate, endDate:endDate}
								}).then(function(response) {
							$scope.maxTemperaturePeriod = response.data
						});
					}
				});