'use strict';

angular.module('descentManagerApp')
  .controller('NewGameCtrl', function ($scope, $uibModal, Alert, Game, Player, Skill, $rootScope, $state, $q, $http) {

    $scope.players = [];

    $scope.newGame = {
      nombre: '',
      usuario: $rootScope.currentUser.url,
      activa: true
    };

    // Método que añade un jugador a la partida
    $scope.addPlayer = function() {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'js/main/newGame/modal/addPlayerModal/addPlayerModal.html',
        controller: 'AddPlayerModalCtrl',
        size: 'lg',
        resolve: {
          players: function () {
            return $scope.players;
          }
        }
      });

      modalInstance.result.then(function (player) {
        $scope.players.push(player);
      }, function () {
        console.log('Modal dismissed at: ' + new Date());
      });
    };

    // Método que borra un jugador de una partida
    $scope.deletePlayer = function(index) {
      $scope.players.splice(index, 1);
    };

    // Método que guarda la partida
    $scope.save = function() {
    	var partidaId;

      Alert.showLoader();
      Game.createGame($scope.newGame)
        .then(function(response) {
        	partidaId = response.data.id;

        	// Una vez creada la partida, se asignan los jugadores
        	var jugadoresPromises = [];
        	for (var i=0; i < $scope.players.length; i++) {
        		var player = $scope.players[i];
        		var jugador = {
        			alias: player.alias,
        			proeza: false,
        			oro: 0,
        			experiencia: 0,
        			envenenado: false,
        			aturdido: false,
        			enfermo: false,
        			inmovil: false,
        			vida: player.personaje.vida,
        			aguante: player.personaje.aguante,
        			personaje: player.personaje_url,
        			clase: player.clase_url,
        			partida: response.data._links.self.href
        		};
        		jugadoresPromises.push(Player.create(jugador));
        	}

        	// Cuando se crean todos los jugadores se les asignan las habilidades
        	$q.all(jugadoresPromises)
        		.then(function(jugadores) {
        			var promises = [];

        			for (var i=0; i < jugadores.length; i++) {
        				var jugador = jugadores[i].data;
        				promises.push(findClase(jugador.id, jugador._links.clase.href) // Se busca la clase de cada jugador
			        					.then(function(jugadorClase) {
			        						return findByClaseAndCosteExperiencia0(jugadorClase); // Se recuperan las habilidades de coste 0 de la clase
			        					})
			        					.then(function(jugadorHabilidades) {
			        						return setHabilidadesToJugador(jugadorHabilidades.jugadorId, jugadorHabilidades.habilidades); // Se asignan las habilidades al jugador
			        					}));
        			}

        			// Cuando se crean todos los jugadores se confirma el guardado de partida
        			$q.all(promises)
        				.then(function(response) {
        					Alert.hideLoader();
		                    Alert.showAlert('La partida se ha creado correctamente');
		                    $state.go('main.games');
        				}, function(error) {
        					Alert.hideLoader();
                            Alert.showAlert('Error inesperado creando la partida', 'error');
        				});
        		});

        	// Por último se crea la aventura inicial de la partida
        	var aventuraPartida = {
        			id : {
        				aventuraId : 1,
        				partidaId : partidaId
        			},
        			activa : true
        	}
			Game.setAdventure(aventuraPartida)
				.then(function(response) {
					// Ok
				}, function(error) {
					console.log("ERROR llamando a Game.setAdventure: " + error);
				});

          }, function(error) {
        	  Alert.hideLoader();
        	  Alert.showAlert('Error inesperado creando la partida', 'error');
          });
    };

    // MÉTODOS AUXILIARES PARA CREAR LA PARTIDA

    // Método que recupera la información de una clase a partir de su URL
    var findClase = function(jugadorId, urlClase) {
    	return $http.get(urlClase)
				.then(function(clase) {
					return {jugadorId: jugadorId, clase: clase.data};
				});
    };

    // Método que recupera las habilidades de coste cero de una clase
    var findByClaseAndCosteExperiencia0 = function(jugadorClase) {
    	return Skill.findByClaseAndCosteExperiencia(jugadorClase.clase.id, 0)
				.then(function(response) {
					return {jugadorId: jugadorClase.jugadorId, habilidades: response.data._embedded.habilidades};
				});
    };

    // Método que asigna un listado de habilidades a un jugador
    var setHabilidadesToJugador = function(jugadorId, habilidades) {
    	var promises = []
    	for (var j=0; j < habilidades.length; j++) {
			promises.push(Player.setSkill(jugadorId, habilidades[j].id));
    	}
    	return $q.all(promises);
    };
  });
