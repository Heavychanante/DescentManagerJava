'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main.round.adventures', {
        url: '/adventures',
        params: {
           game_id: {
             value: ''
           }
        },
        templateUrl: 'js/main/round/adventures/adventures.html',
        controller: 'AdventuresCtrl'
      });
  });
