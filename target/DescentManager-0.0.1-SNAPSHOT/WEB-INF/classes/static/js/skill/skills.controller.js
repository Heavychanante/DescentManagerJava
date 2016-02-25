'use strict';

angular.module('descentManagerApp')
  .controller('SkillCtrl', function ($scope) {
    $scope.currentSkills = [{
    	nombre: 'Bola de fuego',
    	tipo: 'Magia',
    	coste_experiencia: '1',
    	descripcion: 'Una bola de fuego',
    	selected: false
    }, {
    	nombre: 'Desarmar',
    	tipo: 'Ataque',
    	coste_experiencia: '0',
    	descripcion: 'Desarma al rival',
    	selected: true
    }];
  });