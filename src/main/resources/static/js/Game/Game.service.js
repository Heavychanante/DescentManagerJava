'use strict';

angular.module('descentManagerApp')
  .factory('Game', function ($http) {
    return {
      // Método que crea una nueva partida
      createGame: function (partida) {
        return $http({
  				method: 'POST',
  				url: '/api/partidas/',
  				data: partida
  			});
      },
      // Método que devuelve las partidas creadas por un jugador
      getUserGames: function (usuarioId) {
        return $http({
  				method: 'GET',
  				url: '/api/partidas/search/findByUsuarioOrderByCreacionDesc/',
  				params: { usuarioId : usuarioId }
  			});
      },
      // Método que elimina una partida
      deleteGame: function(partidaUrl) {
        return $http({
          method: 'DELETE',
          url: partidaUrl
        });
      }
    };
  });
