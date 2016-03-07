'use strict';

angular.module('descentManagerApp')
  .controller('NewGameCtrl', function ($scope, $uibModal, Alert, Game, Player, $rootScope, $state, $q) {

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
      Alert.showLoader();
      Game.createGame($scope.newGame)
        .then(function(response) {

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

        	// Cuando se crean todos los jugadores se devuelve el control
        	$q.all(jugadoresPromises)
        		.then(function(response) {
        			Alert.hideLoader();
                    Alert.showAlert('La partida se ha creado correctamente');
                    $state.go('main.games');
        		}, function(error) {
        			Alert.hideLoader();
                    Alert.showAlert('Error inesperado creando la partida', 'error');
        		});
            
          }, function(error) {
            Alert.hideLoader();
            Alert.showAlert('Error inesperado creando la partida', 'error');
          });
    };

  });
