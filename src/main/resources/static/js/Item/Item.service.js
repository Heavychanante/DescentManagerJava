'use strict';

angular.module('descentManagerApp')
  .factory('Item', ['$http', function ($http) {
    return {
  		// Método que obtiene todos los objetos de la BD
  		list : function() {
  			return $http({
                  method: 'GET',
                  url: '/api/objetos/'
              });
  		},
  		// Método que obtiene un objeto a partir de su ID
  		findById : function(objeto_id) {
  			return $http({
                  method: 'GET',
                  url: '/api/objetos/' + objeto_id
              });
  		},
  		// Método que obtiene los objetos pertenecientes a un jugador
  		getObjetosByJugador: function(jugadorId) {
  			return $http({
                  method: 'GET',
                  url: '/api/jugadorObjeto/search/findByJugador/',
                  params: { jugadorId : jugadorId }
              });
  		},
  		// Método que obtiene listado paginado de los objetos pertenecientes a un jugador
  		getObjetosByJugadorPaginados: function(jugadorId, indice, cantidad) {
  			return $http({
  				method: 'GET',
  				url: '/api/jugadorObjeto/search/findByJugador/',
  				params: {
  					jugadorId : jugadorId,
  					page : indice,
  					size : cantidad
  				}
  			});
  		}
  	};
  }]);
