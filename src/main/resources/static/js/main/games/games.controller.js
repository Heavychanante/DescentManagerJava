'use strict';

angular.module('descentManagerApp')
  .controller('GamesCtrl', function ($scope, $rootScope, Game, Player, Alert, dialogs, $q) {
    // Carga las partidas del usuario
    $scope.init = function() {
      Game.getUserGames($rootScope.currentUser.id)
        .then(function(response) {
          $scope.partidas = response.data._embedded.partidas;
        }, function(error) {
          Alert.showAlert('Error inesperado recuperando las partidas del usuario', 'error');
        });
    };

    // Borra una partida
    $scope.deleteGame = function(partida) {
    	console.log(partida);
      dialogs.confirm('Borrar partida', '¿Deseas borrar la partida "' + partida.nombre + '"?').
        result.then(function(){
          Alert.showLoader();

          // Primero se borran los jugadores de la partida
          Player.getGamePlayers(partida.id)
          	.then(function(response) {
          		var jugadoresPromise = [];
          		var jugadores = response.data._embedded.jugadores;
          		for (var i=0; i < jugadores.length; i++) {
          			jugadoresPromise.push(Player.deletePlayer(jugadores[i]._links.self.href));
          		}
          		
          		// Cuando se han borrado todos los jugadores se borra la partida
          		$q.all(jugadoresPromise)
	          		.then(function(response) {

	          			Game.deleteGame(partida._links.self.href).
		                    then(function(response){
		                      $scope.init();
		                      Alert.hideLoader();
		                      Alert.showAlert('La partida se ha eliminado correctamente');
		                    }, function(error){
		                      var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
		                      Alert.hideLoader();
		                      Alert.showAlert(message, error);
		                    });

	  				}, function(error) {
	  					var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
	  	                Alert.hideLoader();
	  	                Alert.showAlert(message, error);
	  				});
          		
          	}, function(error) {
          		var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
                Alert.hideLoader();
                Alert.showAlert(message, error);
          	});

        });
    };

    $scope.init();
  });
