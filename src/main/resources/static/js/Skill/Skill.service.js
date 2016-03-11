'use strict';

angular.module('descentManagerApp')
  .factory('Skill', ['$http', function ($http) {
    return {
    	// Método que obtiene todas las habilidades de la BD
  		list : function() {
  			return $http({
                  method: 'GET',
                  url: '/api/habilidades/'
              });
  		},
  		// Método que obtiene una habilidad a partir de su ID
  		findById : function(habilidad_id) {
  			return $http({
                  method: 'GET',
                  url: '/api/habilidades/' + habilidad_id
              });
  		},
  		// Método que obtiene las habilidades pertenecientes a un jugador
  		getHabilidadesByJugador: function(jugadorId) {
  			return $http({
  				method: 'GET',
  				url: 'api/jugadorHabilidad/search/findByJugador',
  				params: { jugadorId : jugadorId }
  			});
  		},
  		// Método que obtiene listado paginado de habilidades asignables a un jugador
  		getHabilidadesByJugadorPaginadas: function(jugadorId, indice, cantidad) {
  			return $http({
  				method: 'GET',
  				url: '/api/jugadorHabilidad/search/findByJugador/',
  				params: {
  					jugadorId : jugadorId,
  					page : indice,
  					size : cantidad
  				}
  			});
  		}
  	};
  }]);
