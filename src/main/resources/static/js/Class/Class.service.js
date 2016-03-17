'use strict';

angular.module('descentManagerApp')
  .factory('Class', ['$http', function ($http) {
    return {
      // Método que devuelve el listado completo de clases
      list: function () {
        return $http({
                  method: 'GET',
                  url: '/api/clases/'
              });
      },
      // Método que devuelve una clase a partir de su ID
      list: function (claseId) {
        return $http({
                  method: 'GET',
                  url: '/api/clases/' + claseId
              });
      },
      // Método que devuelve las clases asociadas a un arquetipo
      getClassesByArchetype: function (archetype_id) {
        return $http({
                  method: 'GET',
                  url: '/api/clases/search/findByArquetipo/',
                  params: { arquetipoId : archetype_id}
              });
      }
    };
  }]);
