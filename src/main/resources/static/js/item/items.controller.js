'use strict';

angular.module('descentManagerApp')
  .controller('ItemCtrl', function ($scope, $http) {
	  $http.get('/DescentManager/api/objetos')
	  	.then(function(response) {
	  		console.log(response.data._embedded.objetos);
	  		$scope.currentItems = response.data._embedded.objetos;
	  	}, function(error) {
	  		console.error(error);
	  	});
  });