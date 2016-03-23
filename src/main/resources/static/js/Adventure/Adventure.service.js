'use strict';

angular.module('descentManagerApp')
  .factory('Adventure', function ($http) {
    return {
      // Método que devuelve el listado completo de aventuras
      list: function () {
        return $http({
                  method: 'GET',
                  url: '/api/aventuras/'
              });
      },
      getGameAdventures: function (gameId) {
        return $http({
                  method: 'GET',
                  url: '/api/aventuraPartida/search/findByPartida/',
                  params : {
                	  partidaId : gameId
                  }
              });
      },
      updateAdventures: function (gameId, adventure) {
        return $http({
                  method: 'POST',
                  url: '/api/aventuras/game/' + gameId,
                  data: adventure
              });
      }
    };
  });
