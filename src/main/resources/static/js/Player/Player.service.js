'use strict';

angular.module('descentManagerApp')
  .factory('Player', ['$http', function ($http) {
    return {
  		// Método que devuelve la lista de todos los jugadores en BD
  		list : function() {
  			return $http({
  				method:'GET',
  				url: '/api/jugadores'
  			});
  		},
      // Método que devuelve un jugador a partir de su ID
      findById : function(id) {
  			return $http({
  				method: 'GET',
  				url: '/api/jugadores/' + id
  			});
  		},
      // Método que devuelve el listado de jugadores de una partida
  		getGamePlayers : function(game_id) {
  			return $http({
  				method:'GET',
  				url: '/api/jugadores/search/findByPartida?partidaId=' + game_id
  			});
  		},
      // Método que añade una habilidad a un jugador
  		setSkill: function (jugadorId, habilidadId){
  			return $http({
  				method: 'POST',
  				url: '/api/jugadorHabilidad/',
  				data: { id : { jugadorId: jugadorId, habilidadId: habilidadId } }
  			});
  		},
  		// Método que añade un objeto a un jugador
  		setItem: function(jugadorId, objetoId) {
  			return $http({
  				method: 'POST',
  				url: '/api/jugadorObjeto/',
  				data: { id : { jugadorId: jugadorId, objetoId: objetoId } }
  			});
  		},
  		// Método que crea un nuevo jugador
  		create: function(jugador) {
  			return $http({
  				method: 'POST',
  				url: '/api/jugadores',
  				data: jugador
  			});
  		},
  		// Método que actualiza un jugador
  		update: function(jugador) {
  			return $http({
  				method: 'PUT',
  				url: '/api/jugadores/' + jugador.id,
  				data: jugador
  			});
  		},
      // Método que elimina una habilidad a un jugador
      deleteSkill: function(jugadorId, habilidadId) {
        return $http({
          method: 'DELETE',
          url: '/api/jugadorHabilidad/' + jugadorId + '-' + habilidadId,
        });
      },
      // Método que elimina un objeto a un jugador
      deleteItem: function(jugadorId, objetoId) {
        return $http({
          method: 'DELETE',
          url: '/api/jugadorObjeto/' + jugadorId + '-' + objetoId,
        });
      },
      // Método que elimina una habilidad a un jugador
      deleteSkillUrl: function(url) {
        return $http({
          method: 'DELETE',
          url: url,
        });
      },
      // Método que elimina un objeto a un jugador
      deleteItemUrl: function(url) {
        return $http({
          method: 'DELETE',
          url: url,
        });
      },
      // Método que elimina un jugador
      deletePlayer: function(jugadorUrl) {
        return $http({
          method: 'DELETE',
          url: jugadorUrl,
        });
      }
	};
}]);
