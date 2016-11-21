var app = angular.module("dashboard", [ "ngRoute" ]);
app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : 'DashboardController',
		templateUrl : 'templates/flights.html'
	})
});

app.controller('DashboardController', function($scope, flightService) {
	flightService.getAvailFlights().success(function(res) {
		$scope.flights = res;
		loadFlightSchedules(res);
	});
});

app.service('flightService', function($http) {
	this.getAvailFlights = function() {
		return $http.get("/flights");
	}
});


