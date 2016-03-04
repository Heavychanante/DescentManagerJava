'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main.games', {
        url: '/games',
        templateUrl: 'js/main/games/games.html',
        controller: 'GamesCtrl'
      });
  });
