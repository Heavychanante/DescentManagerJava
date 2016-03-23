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
      },
      // Método que asigna una aventura a una partida
      setAdventure: function(aventuraPartida) {
    	  return $http({
    		 method: 'POST',
    		 url: '/api/aventuraPartida/',
    		 data: aventuraPartida
    	  });
      },
      // Método que borra una aventura de una partida
      deleteAdventure: function(url) {
    	  return $http({
    		 method: 'DELETE',
    		 url: url
    	  });
      }
    };
  });
