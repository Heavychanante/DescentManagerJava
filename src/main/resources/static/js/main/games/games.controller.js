'use strict';

angular.module('descentManagerApp')
  .controller('GamesCtrl', function ($scope, $rootScope, Game, Player, Skill, Item, Adventure, Alert, dialogs, $q, $http) {
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
      dialogs.confirm('Borrar partida', '¿Deseas borrar la partida "' + partida.nombre + '"?').
        result.then(function(){
          Alert.showLoader();
          console.log("PARTIDA A BORRAR = " + partida.id);
          // Primero se borran los jugadores de la partida
          Player.getGamePlayers(partida.id)
          	.then(function(response) {
          		var habilidadesObjetosPromise = [];
          		var jugadoresPromise = [];
          		var jugadores = response.data._embedded.jugadores;

          		for (var i=0; i < jugadores.length; i++) {
          			// Se borran las habilidades de cada jugador
          			Skill.getHabilidadesByJugador(jugadores[i].id)
          				.then(function(response) {
          					var habilidades = response.data._embedded.jugadorHabilidad;

          					for (var j=0; j < habilidades.length; j++) {
          						habilidadesObjetosPromise.push($http.delete(habilidades[j]._links.self.href));
          					}
          				}, function(error) {
          					var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
	          	            Alert.hideLoader();
	          	            Alert.showAlert(message, error);
          				});

          			// Se borran los objetos de cada jugador
          			Item.getObjetosByJugador(jugadores[i].id)
          				.then(function(response) {
          					var objetos = response.data._embedded.jugadorObjeto;

          					for (var j=0; j < objetos.length; j++) {
          						habilidadesObjetosPromise.push($http.delete(objetos[j]._links.self.href));
          					}
          				}, function(error) {
          					var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
	          	            Alert.hideLoader();
	          	            Alert.showAlert(message, error);
          				});
          		}

          		// Una vez borradoslos objetos y las habilidades se borran los jugadores
          		$q.all(habilidadesObjetosPromise)
          			.then(function(response) {
          				for (var i=0; i < jugadores.length; i++) {
                  			jugadoresPromise.push(Player.deletePlayer(jugadores[i]._links.self.href));
                  		}
          			}, function(error) {
          				var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
          	            Alert.hideLoader();
          	            Alert.showAlert(message, error);
          			})
          		
          		// Cuando se han borrado todos los jugadores se borran las aventuras de la partida
          		$q.all(jugadoresPromise)
	          		.then(function(response) {

	          			// Primero se recuperan las aventuras de la partida
	          			Adventure.getGameAdventures(partida.id)
	          				.then(function(response) {

	          					// Se borran todas las aventuras de la partida
	          					var aventuras = response.data._embedded.aventuraPartida;
	          					var aventurasPromise = [];
	          					for (var i=0; i < aventuras.length; i++) {
	          						aventurasPromise.push(Game.deleteAdventure(aventuras[i]._links.self.href));
	          					}

	          					// Finalmente se borra la partida
	          					$q.all(aventurasPromise)
	          						.then(function(response) {
	          							Game.deleteGame(partida._links.self.href).
						                    then(function(response) {
						                      $scope.init();
						                      Alert.hideLoader();
						                      Alert.showAlert('La partida se ha eliminado correctamente');
						                    }, function(error) {
						                      var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
						                      Alert.hideLoader();
						                      Alert.showAlert(message, error);
						                    });
	          						}, function(error) {
	          							var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
	    	          	                Alert.hideLoader();
	    	          	                Alert.showAlert(message, error);
	          						})
	          					
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
          		
          	}, function(error) {
          		var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
                Alert.hideLoader();
                Alert.showAlert(message, error);
          	});

        });
    };

    $scope.init();
  });
