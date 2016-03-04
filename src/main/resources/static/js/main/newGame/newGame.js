'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main.newGame', {
        url: '/newGame',
        templateUrl: 'js/main/newGame/newGame.html',
        controller: 'NewGameCtrl'
      });
  });
