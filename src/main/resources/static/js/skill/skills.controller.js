'use strict';

angular.module('descentManagerApp')
  .controller('SkillCtrl', function ($scope, $http) {
	  $http.get('/DescentManager/api/habilidades')
	  	.then(function(response) {
	  		console.log(response.data._embedded.habilidades);
	  		$scope.currentSkills = response.data._embedded.habilidades;
	  	}, function(error) {
	  		console.error(error);
	  	});
  });