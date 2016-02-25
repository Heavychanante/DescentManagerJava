'use strict';

angular.module('descentManagerApp')
  .controller('ItemCtrl', function ($scope) {
    $scope.currentItems = [{
    	nombre: 'Espada de plata de perjurio',
    	tipo: 'Espada',
    	precio: '500',
    	manos: '1',
    	a_distancia: '0',
    	descripcion: "Una espada"
    }, {
    	nombre: 'Bastón de llamas',
    	tipo: 'Bastón',
    	precio: '300',
    	manos: '1',
    	a_distancia: '1',
    	descripcion: "Un bastón"
    }];
  });