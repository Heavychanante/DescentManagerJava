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

          deleteAdventures(partida.id) // Se borran las aventuras de la partida
          	.then(function(response) {
          		return deleteGamePlayers(partida.id); // Se borran los jugadores de la partida
          	})
          	.then(function(response) {
          		return deleteGame(partida); // Se borra la partida
          	})
          	.then(function(response) {
		    	$scope.init();
				Alert.hideLoader();
				Alert.showAlert('La partida se ha eliminado correctamente');
          	}, function(error){
          		var message = 'Error borrando la partida ' + partida.id + ': ' + error.data + ' (' + error.status + ')';
	            Alert.hideLoader();
	            Alert.showAlert(message, error);
          	});

        });
    };

    // MÉTODOS PARA IMPLEMENTAR EL BORRADO

    // Borra las aventuras de la partida
    var deleteAdventures = function(partidaId) {
    	return Adventure.getGameAdventures(partidaId)
		      	.then(function(response) {
		      		var aventuras = response.data._embedded.aventuraPartida;
					var aventurasPromise = [];

					for (var i=0; i < aventuras.length; i++) {
						aventurasPromise.push(Game.deleteAdventure(aventuras[i]._links.self.href));
					}
					return $q.all(aventurasPromise);
		      	});
    };

    // Borra las habilidades de un jugador
    var deleteSkills = function(jugadorId) {
    	return Skill.getHabilidadesByJugador(jugadorId)
				.then(function(response) {
					var habilidadesPromise = [];
					var habilidades = response.data._embedded.jugadorHabilidad;
					
					for (var i=0; i < habilidades.length; i++) {
						habilidadesPromise.push(Player.deleteSkillUrl(habilidades[i]._links.self.href));
					}
			    	return $q.all(habilidadesPromise);
				});
    };

    // Borra los objetos de un jugador
    var deleteItems = function(jugadorId) {
    	return Item.getObjetosByJugador(jugadorId)
				.then(function(response) {
					var objetosPromise = [];
			    	var objetos = response.data._embedded.jugadorObjeto;
	
			    	for (var i=0; i < objetos.length; i++) {
						objetosPromise.push(Player.deleteItemUrl(objetos[i]._links.self.href));
					}
			    	return $q.all(objetosPromise);
				});
    };

    // Borra un jugador
    var deletePlayer = function(jugador) {
    	return $q.all([deleteItems(jugador.id), // Se borran los objetos del jugador
    	               deleteSkills(jugador.id)]) // Se borran las habilidades del jugador
	    	        .then(function(response) {
	    	        	return Player.deletePlayer(jugador._links.self.href); // Por último se borra el jugador
	    	        });
    };

    // Borra todos los jugadores de una partida
    var deleteGamePlayers = function(gameId) {
    	return Player.getGamePlayers(gameId)
	    		.then(function(response) {
	    			var playerPromises = [];
	    			var jugadores = response.data._embedded.jugadores;
	
	    			for (var i=0; i < jugadores.length; i++) {
	    				playerPromises.push(deletePlayer(jugadores[i]));
	    			}
	    			return $q.all(playerPromises);
	    		});
    };

    // Borra la partida
    var deleteGame = function(game) {
    	return Game.deleteGame(game._links.self.href);
    };

    $scope.init();
  });
