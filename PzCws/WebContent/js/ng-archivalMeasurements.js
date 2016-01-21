var app = angular.module('archivalMeasurements', ['ngMaterial']);


app.controller('archMeas', function ($scope,$http,$filter) {
    	
    	$scope.myDate = new Date();	
    	
      	$scope.show=function (){
      	var date=$filter('date')($scope.myDate,'yyyy-MM-dd');	
    	 $http.get("http://localhost:8080/PzCws/measurements/date",{params:{date:date}})
    	 .then(function (response) {$scope.dayMeasurement = response.data.measurement;}); 
    	

    	  var create = document.getElementById('create');

    	  create.addEventListener('click', function() {
    	    var link = document.getElementById('downloadlink');
    	    link.href = createUrl($scope.dayMeasurement);
    	    link.style.display = 'block';
    	  }, false);
      }
    });



app.controller('archMeasPeriod', function ($scope,$http,$filter) {
	
	$scope.myStartDate = new Date();
	$scope.myEndDate = new Date();
	
  	$scope.showPeriod=function (){
  	var startDate=$filter('date')($scope.myStartDate,'yyyy-MM-dd');
  	var endDate = $filter('date')($scope.myEndDate,'yyyy-MM-dd');
  	
	 $http.get("http://localhost:8080/PzCws/measurements/period",{params:{startDate:startDate, endDate:endDate}})
	 .then(function (response) {$scope.periodMeasurement = response.data.measurement;});
	 
	 
	 var create = document.getElementById('create');

	  create.addEventListener('click', function() {
	    var link = document.getElementById('downloadlink');
	    link.href = createUrl($scope.periodMeasurement);
	    link.style.display = 'block';
	  }, false);
  }
});

function createUrl(resource) {
	var json = JSON.stringify(resource);
    var data = new Blob([json], {
      type: 'application/json'
    });


    dataUrl = window.URL.createObjectURL(data);

    return dataUrl;
}