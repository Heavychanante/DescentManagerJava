'use strict';

angular.module('descentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('skills', {
        url: '/skill',
        templateUrl: 'js/skill/skills.html',
        controller: 'SkillCtrl'
      });
  });