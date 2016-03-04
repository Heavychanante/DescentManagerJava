'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main.round.players', {
        url: '/players',
        params: {
           game_id: {
             value: ''
           }
        },
        templateUrl: 'js/main/round/players/players.html',
        controller: 'PlayersCtrl'
      });
  });
