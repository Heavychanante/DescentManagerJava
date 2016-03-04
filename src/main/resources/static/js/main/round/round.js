'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main.round', {
        url: '/round/:id',
        templateUrl: 'js/main/round/round.html',
        controller: 'RoundCtrl'
      });
  });
