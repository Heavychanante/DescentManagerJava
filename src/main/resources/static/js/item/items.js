'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('items', {
        url: '/item',
        templateUrl: 'js/item/items.html',
        controller: 'ItemCtrl'
      });
  });