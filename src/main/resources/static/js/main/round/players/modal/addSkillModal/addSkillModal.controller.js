'use strict';

angular.module('descentManagerApp')
  .controller('AddSkillModalCtrl', function ($scope, $uibModalInstance, Skill, uiGridConstants, jugador) {
    $scope.player = jugador;
    $scope.totalItems = 0;
    $scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.totalSkills = [];
    $scope.currentSkills = [];

    $scope.save = function () {
      var newSkills = [];
      // Se guardan las nuevas habilidades del jugador
      for (var i=0; i < $scope.totalSkills.length; i++) {
        if ($scope.totalSkills[i].selected) {
          newSkills.push($scope.totalSkills[i]);
        }
      }
      $uibModalInstance.close(newSkills);
    };

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };

    $scope.pageChanged = function() {
      $scope.currentSkills = $scope.totalSkills.slice(($scope.currentPage - 1) * $scope.pageSize,
                                                      (($scope.currentPage - 1)*$scope.pageSize) + $scope.pageSize);
    };

    // Recupera las habilidades asignables al jugador (las de su clase)
    Skill.findByClase($scope.player.clase.id)
    	.then(function(response) {
	        $scope.totalSkills = response.data._embedded.habilidades;
	        $scope.totalItems = $scope.totalSkills.length;
	        for (var i=0; i < $scope.totalItems; i++) {
	        	$scope.totalSkills[i].selected = false;
	        }
	        $scope.currentSkills = $scope.totalSkills.slice($scope.currentPage, $scope.pageSize);
	        $scope.numPages = Math.ceil($scope.totalItems / $scope.pageSize);
    	}, function(error) {
	        console.log('ERROR Skill.findByClase -> ' + error);
    	});
  });
