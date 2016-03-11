'use strict';

angular.module('descentManagerApp')
  .controller('AddItemModalCtrl', function ($scope, $uibModalInstance, Item, uiGridConstants, jugador, $q) {
    $scope.player = jugador;
    $scope.totalSize = 0;
    $scope.currentPage = 0;
    $scope.pageSize = 10;
    $scope.totalItems = [];
    $scope.currentItems = [];

    $scope.save = function () {
      var newItems = [];
      // Se guardan las nuevas habilidades del jugador
      for (var i=0; i < $scope.totalItems.length; i++) {
        if ($scope.totalItems[i].selected) {
          newItems.push($scope.totalItems[i]);
        }
      }
      $uibModalInstance.close(newItems);
    };

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };

    $scope.pageChanged = function() {
      $scope.currentItems = $scope.totalItems.slice(($scope.currentPage - 1) * $scope.pageSize,
                                                    (($scope.currentPage - 1)*$scope.pageSize) + $scope.pageSize);
    };

    // Obtiene los objetos pertenecienes al jugador
    Item.getObjetosByJugador($scope.player.id)
    	.then(function(response) {
    		var objetosJugador = response.data._embedded.jugadorObjeto;

    		// Obtiene los objetos asignables al jugador
    	    Item.list()
    	      .then(function(response){
    	    	  // Se recupera la información de los objetos asignables
    	    	  var objetos = response.data._embedded.objetos;
    	    	  var objetosPromises = [];
    	    	  for (var i=0; i < objetos.length; i++) {
    	    		  var exists = false;
    	    		  for (var j=0; j < objetosJugador.length; j++) {
    	    			  if (objetosJugador[j].id.objetoId == objetos[i].id) {
    	    				  exists = true;
    	    			  }
    	    		  }
    	    		  if (!exists) {
    	    			  objetos[i].selected = false;
    	    			  $scope.totalItems.push(objetos[i]);
    	    		  }
    	    	  }

    	    	  $scope.totalSize = $scope.totalItems.length;
	    		  $scope.currentItems = $scope.totalItems.slice($scope.currentPage, $scope.pageSize);
	    		  $scope.numPages = Math.ceil($scope.totalSize / $scope.pageSize);

    	      }, function(error){
    	        console.log('ERROR objetos.list() -> ' + error);
    	      });
    	}, function(error) {
    		console.log('ERROR getObjetosByJugador -> ' + error);
    	});
    
  });
