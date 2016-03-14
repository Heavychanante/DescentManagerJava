/* jshint unused: false */

'use strict';

angular.module('descentManagerApp')
  .controller('PlayersCtrl', ['$scope', '$uibModal', 'Player', 'uiGridConstants', '$q', 'Alert', 'dialogs', '$stateParams', 'Item', 'Skill',
              function($scope, $uibModal, Player, uiGridConstants, $q, Alert, dialogs, $stateParams, Item, Skill) {
    $scope.init = function(selectedTab) {
  		$scope.selectedTab = selectedTab;
  		$scope.partida_id = $stateParams.game_id;

  		Player.getGamePlayers($scope.partida_id).
  			then(function(response) {
  				$scope.jugadores = response.data._embedded.jugadores;

  				// Se recuperan los objetos de cada jugador
  				var jugadorObjetoPromises = [];
  				for (var i=0; i < $scope.jugadores.length; i++) {
  					jugadorObjetoPromises.push(Item.getObjetosByJugador($scope.jugadores[i].id));
  				}

  				$q.all(jugadorObjetoPromises)
  					.then(function(response) {

  						var jugadoresObjetos = response;
  						var objetosPromises = [];
						for (var i=0; i < jugadoresObjetos.length; i++) {
							// Se guardan los objetos correpondientes a cada jugador
							objetosPromises[i] = [];
							var jugadorObjeto = jugadoresObjetos[i].data._embedded.jugadorObjeto;
							for (var j=0; j < jugadorObjeto.length; j++) {
								objetosPromises[i].push(Item.findById(jugadorObjeto[j].id.objetoId));
							}
						}

						for (var k=0; k < objetosPromises.length; k++) {
							(function(k) {
								$q.all(objetosPromises[k])
									.then(function(response) {
										$scope.jugadores[k].objetos = response;
									}, function(response) {
										console.error('Error llamando a Item.getObjetosByJugador: ' + response.data + ' (' + response.status + ')');
									});
							})(k);
						}

					}, function(response) {
						console.error('Error llamando a Item.getObjetosByJugador: ' + response.data + ' (' + response.status + ')');
					});
 
  				// Se recuperan las habilidades de cada jugador
  				var jugadorHabilidadPromises = [];
  				for (var i=0; i < $scope.jugadores.length; i++) {
  					jugadorHabilidadPromises.push(Skill.getHabilidadesByJugador($scope.jugadores[i].id));
  				}

  				$q.all(jugadorHabilidadPromises)
  					.then(function(response) {

  						var jugadoresHabilidades = response;
  						var habilidadesPromises = [];
  						var cantidades = []
						for (var i=0; i < jugadoresHabilidades.length; i++) {
							// Se guardan las habilidades correpondientes a cada jugador
							cantidades[i] = [];
							habilidadesPromises[i] = [];
							var jugadorHabilidad = jugadoresHabilidades[i].data._embedded.jugadorHabilidad;
							for (var j=0; j < jugadorHabilidad.length; j++) {
								cantidades[i].push(jugadorHabilidad[j].cantidad);
								habilidadesPromises[i].push(Skill.findById(jugadorHabilidad[j].id.habilidadId));
							}
						}

						for (var k=0; k < habilidadesPromises.length; k++) {
							(function(k) {
								$q.all(habilidadesPromises[k])
									.then(function(response) {
										var cantidadesJugador = cantidades[k];
										var habilidades = response;
										for (var index=0; index < habilidades.length; index++) {
											habilidades[index].data.cantidad = cantidadesJugador[index];
										}
										$scope.jugadores[k].habilidades = habilidades;
									}, function(response) {
										console.error('Error llamando a Skill.getHabilidadesByJugador: ' + response.data + ' (' + response.status + ')');
									});
							})(k);
						}

  					}, function(response) {
						console.error('Error llamando a Skill.getHabilidadesByJugador: ' + response.data + ' (' + response.status + ')');
					});
  			}, function(response) {
  				console.error('Error llamando a Player.list(): ' + response.data + ' (' + response.status + ')');
  			});
  	};

  	$scope.setSelected = function(index) {
  		$scope.selectedTab = index;
  	};

    $scope.openSkillModal = function(jugador) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'js/main/round/players/modal/addSkillModal/addSkillModal.html',
        controller: 'AddSkillModalCtrl',
        size: 'lg',
        resolve: {
          jugador: function () {
            return jugador;
          }
        }
      });

      modalInstance.result.then(function (newSkills) {
        var promises = [];

        // Se actualiza el jugador con las nuevas habilidades
        for (var i=0; i < newSkills.length; i++) {
        	var promise = Player.setSkill(jugador.id, newSkills[i].id);
        	promises.push(promise);
        }
        $q.all(promises).then(function(response){
        	// Se recarga el jugador
        	$scope.init($scope.selectedTab);
        }, function(error){
          console.log('Error saving new skills to player ' + jugador.id + ': ' + error.message);
        });
      }, function () {
        console.log('Modal dismissed at: ' + new Date());
      });

    };

    $scope.openItemModal = function(jugador) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'js/main/round/players/modal/addItemModal/addItemModal.html',
        controller: 'AddItemModalCtrl',
        size: 'lg',
        resolve: {
          jugador: function () {
            return jugador;
          }
        }
      });

      modalInstance.result.then(function (newItems) {
        var promises = [];

        // Se actualiza el jugador con los nuevos objetos
        for (var i=0; i < newItems.length; i++) {
          var promise = Player.setItem(jugador.id, newItems[i].id);
          promises.push(promise);
        }
        $q.all(promises).then(function(response){
        	// Se recarga el jugador
        	$scope.init($scope.selectedTab);
        }, function(error){
          console.log('Error saving new items to player ' + jugador.id + ': ' + error.message);
        });
      }, function () {
        console.log('Modal dismissed at: ' + new Date());
      });
    };

    $scope.incLife = function(jugador) {
      jugador.vida++;
    };

    $scope.decLife = function(jugador) {
      jugador.vida--;
    };

    $scope.incStamina = function(jugador) {
      jugador.aguante++;
    };

    $scope.decStamina = function(jugador) {
      jugador.aguante--;
    };

  	// Se actualizan los campos del jugador
  	$scope.updateJugador = function (jugador) {
      Alert.showLoader();
  		Player.update(jugador).
  			then(function(response) {
  				console.log('Jugador ' + jugador.alias + ' actualizado: ' + response.status);
		        $scope.init($scope.selectedTab);
		        Alert.hideLoader();
		        Alert.showAlert('El jugador se ha actualizado correctamente');
  			}, function(response) {
  				console.error('Error actualizando al jugador ' + jugador.alias + ': ' + response.data + ' (' + response.status + ')');
  			});
  	};

    // Método que elimina una habilidad de un jugador
    $scope.deleteHabilidad = function(jugador, index) {
      var habilidad = jugador.habilidades[index].data;
      dialogs.confirm('Borrar habilidad', '¿Deseas borrar la habilidad "' + habilidad.nombre + '" del jugador "' + jugador.alias + '"?').
        result.then(function(){
          Alert.showLoader();
          Player.deleteSkill(jugador.id, habilidad.id).
            then(function(response){
              $scope.init($scope.selectedTab);
              Alert.hideLoader();
              Alert.showAlert('La habilidad se ha eliminado correctamente');
            }, function(error){
              console.error('Error borrando la habilidad ' + habilidad.id + ': ' + error.data + ' (' + error.status + ')');
            });
        });
    };

    // Método que elimina un objeto de un jugador
    $scope.deleteObjeto = function(jugador, index) {
      var objeto = jugador.objetos[index].data;
      dialogs.confirm('Borrar objeto', '¿Deseas borrar el objeto "' + objeto.nombre + '" del jugador "' + jugador.alias + '"?').
        result.then(function(){
          Alert.showLoader();
          Player.deleteItem(jugador.id, objeto.id).
            then(function(response){
              $scope.init($scope.selectedTab);
              Alert.hideLoader();
              Alert.showAlert('El objeto se ha eliminado correctamente');
            }, function(error){
              console.error('Error borrando el objeto ' + objeto.id + ': ' + error.data + ' (' + error.status + ')');
            });
        });
    };

    // Se inicializa la vista de jugadores
  	$scope.init(0);
  }]);
